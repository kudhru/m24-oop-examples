// File: StartVsRun.java
public class StartVsRun {
    static class Task implements Runnable {
        public void run() {
            System.out.println("Running on thread: " + Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        Thread t = new Thread(new Task(), "Worker");

        System.out.println("Calling run() directly:");
        t.run();   // executes on main thread (no new thread)

        System.out.println("Calling start():");
        t = new Thread(new Task(), "Worker");
        t.start(); // executes on a NEW thread
    }
}
