// File: SynchronizedMethodRunnableDemo.java
import java.util.ArrayList;
import java.util.List;

public class SynchronizedMethodRunnableDemo {

    // -------------- Shared components guarded by synchronized METHODS --------------

    // Hands out unique IDs safely across threads (tiny critical section).
    static class IdGenerator {
        private long next = 1;
        public synchronized long nextId() { return next++; }
    }

    // One shared sink (think: a single CSV/log) — appends lines safely.
    static class ResultSink {
        private final List<String> lines = new ArrayList<>();
        public synchronized void record(String line) { lines.add(line); }
        public synchronized int size() { return lines.size(); }
        public synchronized List<String> snapshot() { return new ArrayList<>(lines); }
        public synchronized void clear() { lines.clear(); }
    }

    // Hands out job indices 0..total-1 safely (tiny critical section).
    static class JobDispenser {
        private int next = 0;
        private final int total;
        JobDispenser(int total) { this.total = total; }
        public synchronized int nextJob() {
            return (next < total) ? next++ : -1;  // -1 => no more jobs
        }
    }

    // -------------- Worker using only Runnable + Thread --------------

    static class Worker implements Runnable {
        private final int ioMillis;
        private final int cpuIters;
        private final JobDispenser jobs;
        private final IdGenerator ids;
        private final ResultSink sink;

        Worker(int ioMillis, int cpuIters, JobDispenser jobs, IdGenerator ids, ResultSink sink) {
            this.ioMillis = ioMillis; this.cpuIters = cpuIters;
            this.jobs = jobs; this.ids = ids; this.sink = sink;
        }

        @Override public void run() {
            while (true) {
                int job = jobs.nextJob();     // synchronized method (very fast)
                if (job == -1) break;

                long id = ids.nextId();       // synchronized method (very fast)

                long work = cpuWork(cpuIters);  // parallelizable CPU work
                try { Thread.sleep(ioMillis); } // simulate I/O (DB/API)
                catch (InterruptedException e) { Thread.currentThread().interrupt(); break; }

                // synchronized method — serialize just the append
                sink.record("job=" + job + " id=" + id + " work=" + work +
                        " by " + Thread.currentThread().getName());
            }
        }

        private static long cpuWork(int n) {
            long s = 0;
            for (int i = 0; i < n; i++) s = (s * 1664525 + 1013904223) ^ i;
            return s;
        }
    }

    // Helper to run a “single-threaded baseline” without multiple threads
    private static void doJobOnce(int job, int ioMillis, int cpuIters, IdGenerator ids, ResultSink sink) {
        long id = ids.nextId();                 // synchronized, tiny
        long work = Worker.cpuWork(cpuIters);   // CPU work
        try { Thread.sleep(ioMillis); } catch (InterruptedException ignored) {}
        sink.record("job=" + job + " id=" + id + " work=" + work + " by MAIN");
    }

    public static void main(String[] args) throws Exception {
        final int TASKS = 200;          // total jobs to do
        final int THREADS = Math.max(2, Runtime.getRuntime().availableProcessors());
        final int IO_MS = 10;           // simulate I/O per job
        final int CPU_ITERS = 150_000;  // simulate CPU work per job

        // -------- Baseline: single-threaded (no extra threads) --------
        IdGenerator ids1 = new IdGenerator();
        ResultSink sink1 = new ResultSink();

        long t0 = System.nanoTime();
        for (int j = 0; j < TASKS; j++) {
            doJobOnce(j, IO_MS, CPU_ITERS, ids1, sink1);
        }
        long t1 = System.nanoTime();
        System.out.printf("Single-thread: %d results in %.1f ms%n",
                sink1.size(), (t1 - t0) / 1e6);

        // -------- Multithreaded: Runnable + Thread --------
        IdGenerator ids2 = new IdGenerator();
        ResultSink sink2 = new ResultSink();
        JobDispenser jobs = new JobDispenser(TASKS);

        Thread[] ts = new Thread[THREADS];
        for (int i = 0; i < THREADS; i++) {
            ts[i] = new Thread(new Worker(IO_MS, CPU_ITERS, jobs, ids2, sink2), "W" + i);
        }

        long t2 = System.nanoTime();
        for (Thread t : ts) t.start();
        for (Thread t : ts) t.join();
        long t3 = System.nanoTime();

        System.out.printf("Multi-thread (%d threads): %d results in %.1f ms%n",
                THREADS, sink2.size(), (t3 - t2) / 1e6);

        // Peek at a few lines to show mixed thread ownership
        for (String line : sink2.snapshot().subList(0, Math.min(5, sink2.size()))) {
            System.out.println(line);
        }
    }
}
