// File: StartVsRun.java
public class StartVsRun {
    static class Task implements Runnable {
        public void run() {
            System.out.println("Running on thread: " + Thread.currentThread().getName());
        }

    }
    static {
        Thread t = new Thread(new Task(), "Worker inside Static");

        System.out.println("Inside Static:");
        t.start(); // executes on a NEW thread
    }
    public static void main(String[] args) {
        Thread t = new Thread(new Task(), "Worker");

        System.out.println("Outside static: Calling run() directly:");
        t.run();   // executes on main thread (no new thread)

//        System.out.println("Calling start():");
//        t = new Thread(new Task(), "Worker");
        t.start(); // executes on a NEW thread
    }
}
