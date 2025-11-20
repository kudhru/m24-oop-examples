// File: WaitNotifyOne.java
public class WaitNotifyOne {
    private static final Object lock = new Object();
    private static boolean ready = false;

    static class Waiter implements Runnable {
        @Override public void run() {
            synchronized (lock) {
                while (!ready) { // always loop; protects against spurious wakeups
                    try { lock.wait(); } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); return;
                    }
                }
                System.out.println("Waiter: got the signal, proceeding!");
            }
        }
    }

    static class Notifier implements Runnable {
        @Override public void run() {
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            synchronized (lock) {
                ready = true;
                lock.notify(); // wake one waiter
                System.out.println("Notifier: signaled!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread w = new Thread(new Waiter(), "Waiter"); // lock.wait()
        Thread n = new Thread(new Notifier(), "Notifier"); // lock.notify()
        w.start(); n.start();
        w.join();  n.join();
        System.out.println("Done.");
    }
}
