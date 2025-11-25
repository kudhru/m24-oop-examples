// File: RaceCondition.java
import java.util.ArrayList;
import java.util.List;

public class RaceCondition {
    static class Counter {
        int value = 400000;
        Object lock = new Object();
        void inc() {
            synchronized (lock) {
                value = value + 1;
            }

        }
        void dec() {
            synchronized (lock) {
                value = value - 1;
            }
        }
    }


    static class ProperRunnableClass implements Runnable {
        int perThread;
        Counter counter;

        ProperRunnableClass(int perThread, Counter counter) {
            this.perThread = perThread;
            this.counter = counter;
        }
        public void run() {
            for (int i = 0; i < perThread; i++) {
                counter.inc(); // do value = value + 1
                counter.dec();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        int threads = 4;
        int perThread = 100_000;

        List<Thread> list = new ArrayList<>();
        Runnable r = new ProperRunnableClass(perThread, counter); // Task

        for (int i = 0; i < threads; i++) {
            Thread thread = new Thread(r);
            list.add(thread);
        }
        // How many threads we have?
        // Main thread (executing) + threads (have not start executing)

        for (Thread t : list){
            t.start();
        }
        // Main thread and the threads - all are executing.

        for (Thread t : list)
            t.join();

        int expected = threads * perThread;
        System.out.println("Expected = " + expected + " | Actual = " + counter.value);
        // Almost always: Actual < Expected due to lost updates.
    }
}
