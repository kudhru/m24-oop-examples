// File: ProducerConsumerNotifyPitfall.java
import java.util.ArrayDeque;
import java.util.Queue;

public class ProducerConsumerNotifyPitfall {

    static class BoundedBuffer {
        private final Queue<Integer> q = new ArrayDeque<>();
        private final int capacity;
        private final Object lock = new Object();
        BoundedBuffer(int capacity) { this.capacity = capacity; }

        // BUG: uses `if` and single `notify()`
        public void put(int x) throws InterruptedException {
            synchronized (lock) {
                if (q.size() == capacity) {   // should be while(...)
                    lock.wait();              // spurious wakeups -> broken
                }
                q.add(x);
                lock.notify();                // may wake another producer, not a consumer
            }
        }

        // BUG: uses `if` and single `notify()`
        public int take() throws InterruptedException {
            synchronized (lock) {
                if (q.isEmpty()) {           // should be while(...)
                    lock.wait();
                }
                int x = q.remove();
                lock.notify();                // may wake another consumer, not a producer
                return x;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BoundedBuffer buf = new BoundedBuffer(1);
        int producers = 2, consumers = 2, itemsPerProducer = 10_000;

        for (int p = 0; p < producers; p++) {
            final int id = p;
            new Thread(() -> {
                try { for (int i = 0; i < itemsPerProducer; i++) buf.put(i); }
                catch (InterruptedException ignored) {}
                System.out.println("Producer-" + id + " done");
            }, "P"+p).start();
        }
        for (int c = 0; c < consumers; c++) {
            final int id = c;
            new Thread(() -> {
                try { while (true) buf.take(); }  // will often hang
                catch (InterruptedException ignored) {}
            }, "C"+c).start();
        }

        Thread.sleep(5000);
        System.out.println("If it hasn't finished, it's likely stuck due to notify/if bug.");
        System.exit(0);
    }
}
