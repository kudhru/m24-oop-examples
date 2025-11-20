// File: SimplestThreadPoolExecutor.java
import java.util.concurrent.*;

public class SimplestThreadPoolExecutor {
    public static void main(String[] args) throws InterruptedException {
        // 2 worker threads, small task queue, default thread names (pool-1-thread-1, ...)
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2, 2,                      // core & max threads
                0L, TimeUnit.SECONDS,      // keep-alive (unused since core==max)
                new ArrayBlockingQueue<>(10) // task queue
        );

        for (int i = 1; i <= 5; i++) {
            final int id = i;
            pool.execute(() -> {
                System.out.println("Task " + id + " on " + Thread.currentThread().getName());
                try { Thread.sleep(200); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            });
        }

        pool.shutdown();                          // stop accepting new tasks
        pool.awaitTermination(1, TimeUnit.MINUTES); // wait for tasks to finish
        System.out.println("done");
    }
}
