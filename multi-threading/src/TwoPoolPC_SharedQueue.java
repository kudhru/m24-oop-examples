// File: TwoPoolPC_SharedQueue.java
// Compile & run: javac TwoPoolPC_SharedQueue.java && java TwoPoolPC_SharedQueue
import java.util.concurrent.*;

public class TwoPoolPC_SharedQueue {

    // Bounded queue → natural back-pressure if consumers are slower
    private static final int QUEUE_CAPACITY = 5;
    private static final BlockingQueue<Runnable> QUEUE = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

    // Sentinel "poison pill" to stop each consumer loop (Runnable is allowed; it just does nothing)
    private static final Runnable POISON = () -> {};

    public static void main(String[] args) throws InterruptedException {
        final int PRODUCERS = 2;           // # producer threads
        final int CONSUMERS = 3;           // # consumer threads
        final int JOBS_PER_PRODUCER = 10;  // how many jobs each producer emits

        // --- Producer pool: ONLY enqueues jobs onto QUEUE ---
        ThreadPoolExecutor producerPool = new ThreadPoolExecutor(
                PRODUCERS, PRODUCERS, 0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>()
        );

        // --- Consumer pool: each worker runs a loop that takes from QUEUE and runs the job ---
        ThreadPoolExecutor consumerPool = new ThreadPoolExecutor(
                CONSUMERS, CONSUMERS, 0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>()
        );

        // Submit one long-running consumer loop per consumer thread
        for (int i = 0; i < CONSUMERS; i++) {
            consumerPool.execute(() -> {
                try {
                    while (true) {
                        Runnable job = QUEUE.take();       // blocks if queue is empty
                        if (job == POISON) break;           // graceful stop
                        job.run();                          // execute the computation
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Submit producers: they only create jobs and put them onto the shared queue
        for (int p = 0; p < PRODUCERS; p++) {
            final int producerId = p;
            producerPool.execute(() -> {
                try {
                    for (int i = 1; i <= JOBS_PER_PRODUCER; i++) {
                        final int jobId = producerId * 100 + i;
                        // Each job is a Runnable with a small computation + a tiny sleep
                        Runnable job = () -> {
                            long r = compute(jobId);
                            try { Thread.sleep(80); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                            System.out.printf("[%s] processed job %d -> %d%n",
                                    Thread.currentThread().getName(), jobId, r);
                        };
                        QUEUE.put(job); // blocks if queue is full (bounded)
                        System.out.printf("[%s] queued job %d%n",
                                Thread.currentThread().getName(), jobId);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // 1) Wait for all producers to finish submitting
        producerPool.shutdown();
        producerPool.awaitTermination(1, TimeUnit.MINUTES);

        // 2) Enqueue one poison pill per consumer so each loop can exit
        for (int i = 0; i < CONSUMERS; i++) QUEUE.put(POISON);

        // 3) Let consumer loops finish then shut down the consumer pool
        consumerPool.shutdown();
        consumerPool.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("All done.");
    }

    // Tiny synthetic computation so work isn't trivial
    private static long compute(int n) {
        long acc = 0;
        for (int i = 0; i < 150_000; i++) acc = (acc * 1664525 + 1013904223) ^ (i + n);
        return acc ^ n;
    }
}
