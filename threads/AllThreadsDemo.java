import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class BasicThreadDemo extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running: " + i);
            try {
                Thread.sleep(500); // Pause for 500ms
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

class SynchronizationDemo {
    public synchronized void printNumbers(String threadName) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " - Number: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }
        }
    }
}

class SynchronizationBlockDemo {
    public void printSafe(String threadName) {
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + " - Safe Print: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted: " + e.getMessage());
                }
            }
        }
    }
}

class ReentrantLockDemo {
    private final ReentrantLock lock = new ReentrantLock();

    public void display(String name) {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(name + " - Reentrant Lock: " + i);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            lock.unlock();
        }
    }
}

class ThreadPoolDemo {
    public void executeTasks() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " is executing.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        };

        for (int i = 0; i < 5; i++) {
            executor.submit(task);
        }

        executor.shutdown();
    }
}

class InterThreadCommunication {
    public synchronized void produce() throws InterruptedException {
        System.out.println("Producing items...");
        wait();
        System.out.println("Resumed Production");
    }

    public synchronized void consume() {
        System.out.println("Consuming items...");
        notify();
    }
}

public class AllThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        // Basic Thread Demo
        BasicThreadDemo t1 = new BasicThreadDemo();
        BasicThreadDemo t2 = new BasicThreadDemo();
        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // Synchronization Demo
        SynchronizationDemo syncDemo = new SynchronizationDemo();
        Thread syncThread1 = new Thread(() -> syncDemo.printNumbers("Sync-Thread-1"));
        Thread syncThread2 = new Thread(() -> syncDemo.printNumbers("Sync-Thread-2"));
        syncThread1.start();
        syncThread2.start();
        syncThread1.join();
        syncThread2.join();

        // ReentrantLock Demo
        ReentrantLockDemo lockDemo = new ReentrantLockDemo();
        Thread lockThread1 = new Thread(() -> lockDemo.display("Lock-Thread-1"));
        Thread lockThread2 = new Thread(() -> lockDemo.display("Lock-Thread-2"));
        lockThread1.start();
        lockThread2.start();
        lockThread1.join();
        lockThread2.join();

        // Thread Pool Demo
        ThreadPoolDemo poolDemo = new ThreadPoolDemo();
        poolDemo.executeTasks();

        // Inter-Thread Communication Demo
        InterThreadCommunication comm = new InterThreadCommunication();
        Thread producer = new Thread(() -> {
            try {
                comm.produce();
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted: " + e.getMessage());
            }
        });
        Thread consumer = new Thread(comm::consume);
        producer.start();
        Thread.sleep(2000); // Allow producer to wait
        consumer.start();
        producer.join();
        consumer.join();

        System.out.println("All demos completed.");
    }
}
