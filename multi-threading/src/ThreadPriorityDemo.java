// File: ThreadPriorityDemo.java
public class ThreadPriorityDemo {
    static class Counter implements Runnable {
        volatile boolean running = true;
        long count = 0;
        @Override public void run() {
            while (running) { count++; } // CPU-bound loop
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter hi = new Counter();
        Counter lo = new Counter();

        Thread th = new Thread(hi, "HIGH");
        Thread tl = new Thread(lo, "LOW");

        th.setPriority(Thread.MAX_PRIORITY);  // 10
        tl.setPriority(Thread.MIN_PRIORITY);  // 1

        th.start();
        tl.start();

        Thread.sleep(2000);     // let them run for ~2s
        hi.running = false;
        lo.running = false;

        th.join();
        tl.join();

        System.out.println("HIGH priority count = " + hi.count);
        System.out.println("LOW  priority count = " + lo.count);
    }
}
