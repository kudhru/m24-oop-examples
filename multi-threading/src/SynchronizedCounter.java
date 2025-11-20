// File: SynchronizedCounter.java
import java.util.ArrayList;
import java.util.List;

public class SynchronizedCounter {
    static class Counter {
        private int value = 0;
//        synchronized void inc() {
//            value++;
//        }
//        synchronized int get() {
//            return value;
//        }

        private final Object lock = new Object();
        void inc() {
            synchronized (lock) {
                value++; // critical section
            }
            value++;
        }
        int get() {
            synchronized (lock) {
                return value;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        int threads = 8, perThread = 100_000;

        List<Thread> list = new ArrayList<>();
        Runnable r = () -> { for (int i = 0; i < perThread; i++) counter.inc(); };

        for (int i = 0; i < threads; i++) list.add(new Thread(r));
        for (Thread t : list) t.start();
        for (Thread t : list) t.join();

        System.out.println("Final = " + counter.get()); // Should equal threads*perThread
    }
}
