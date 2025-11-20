// File: SimpleBlockingQueueDemo.java
import java.util.concurrent.*;

public class SimpleBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(1); // capacity 1 → clear back-pressure

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    q.put(i); // waits if full
                    System.out.println("produced " + i);
                }
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }, "Producer");

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    int x = q.take(); // waits if empty
                    System.out.println("consumed " + x);
                }
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }, "Consumer");

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        System.out.println("done");
    }
}
