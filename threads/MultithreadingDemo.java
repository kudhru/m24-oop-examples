import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;


public class MultithreadingDemo {
    // Shared resource with thread-safe operations
    static class Counter {
        //private final AtomicInteger count = new AtomicInteger(0);
        private int count = 0 ;

        public void increment() {
            count++;
        }
        
        public int getCount() {
            return count;
        }
    }

    // Runnable task for parallel processing
    static class WorkerTask implements Runnable {
        private final Counter counter;
        private final String taskName;

        public WorkerTask(Counter counter, String taskName) {
            this.counter = counter;
            this.taskName = taskName;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
                try {
                    Thread.sleep(1); // Simulate some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(taskName + " completed.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Demonstrate thread pool and concurrent processing
        Counter sharedCounter = new Counter();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<?>> futures = new ArrayList<>();

        // Submit multiple tasks to thread pool
        for (int i = 0; i < 5; i++) {
            WorkerTask task = new WorkerTask(sharedCounter, "Worker-" + i);
            futures.add(executor.submit(task));
        }

        // Wait for all tasks to complete
        for (Future<?> future : futures) {
            try {
                future.get(); // Block until task completes
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Shutdown thread pool
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        // Print final count
        System.out.println("Final Counter Value: " + sharedCounter.getCount());

        // Demonstrate future with callable
        Callable<String> callableTask = () -> {
            Thread.sleep(2000);     //Delays for 2s
            return "Task completed successfully!";
        };

        Future<String> resultFuture = Executors.newSingleThreadExecutor().submit(callableTask);
        try {
            String result = resultFuture.get(3, TimeUnit.SECONDS);
            System.out.println("Callable Result: " + result);
        } catch (ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}