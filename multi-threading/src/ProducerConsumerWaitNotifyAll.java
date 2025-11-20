// File: ProducerConsumerWaitNotifyAll.java
import java.util.ArrayDeque;
import java.util.Queue;

/*
Correct way of using wait and notifyAll
* synchronized(lock) {
    while (!condition) lock.wait();
    // do critical work
    lock.notifyAll();
}
* */

public class ProducerConsumerWaitNotifyAll {

    static class BoundedBuffer {
        private final Queue<Integer> q = new ArrayDeque<>();
        private final int capacity;
        private final Object lock = new Object();

        BoundedBuffer(int capacity) { this.capacity = capacity; }

        public void put(int x) throws InterruptedException {
            synchronized (lock) {
                while (q.size() == capacity) {   // wait in a LOOP (handles spurious wakeups)
                    lock.wait();
                }
                q.add(x);
                // State changed: not-empty may now be true → wake *all* potential waiters.
                lock.notifyAll();
            }
        }

        public int take() throws InterruptedException {
            synchronized (lock) {
                while (q.isEmpty()) {            // wait in a LOOP (handles spurious wakeups)
                    lock.wait();
                }
                int x = q.remove();
                // State changed: not-full may now be true → wake *all* potential waiters.
                lock.notifyAll();
                return x;
            }
        }
    }

    private static final int POISON = Integer.MIN_VALUE; // sentinel to stop consumers

    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer buf = new BoundedBuffer(5);
        int producers = 3, consumers = 2, itemsPerProducer = 1000;
        int itemsPerConsumer = producers * itemsPerProducer / consumers;

        Thread[] ps = new Thread[producers];
        for (int p = 0; p < producers; p++) { // 0, 1, 2
            final int id = p;
            ps[p] = new Thread(() -> {
                try {
                    for (int i = 1; i <= itemsPerProducer; i++) {  // 1 to 1000
                        buf.put(i); // 1 to 1000 (1000 items)
                        if ((i % 200) == 0) Thread.sleep(1); // just to vary timing
                    }
                    System.out.println("Producer-" + id + " done");
                } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }, "Prod-" + p);
            ps[p].start();
        }

        Thread[] cs = new Thread[consumers];
        for (int c = 0; c < consumers; c++) { // 0, 1
            final int id = c;
            cs[c] = new Thread(() -> {
                long sum = 0; int count = 0;
                try {
                    while (true) {
                        int v = buf.take();
//                        if (v == POISON) break; // stop when sentinel received
                        sum += v; count++;
                        if (count == itemsPerConsumer)
                            break;
                    }
                } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                System.out.println("Consumer-" + id + " consumed " + count + " items, sum=" + sum);
            }, "Cons-" + c);
            cs[c].start();
        }

        for (Thread t : ps) t.join();          // wait for all producers to finish
//        for (int i = 0; i < consumers; i++) {  // send one poison pill per consumer
//            buf.put(POISON);
//        }
        for (Thread t : cs) t.join();

        System.out.println("All done.");
    }
}
