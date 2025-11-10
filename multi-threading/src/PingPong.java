// File: PingPong.java
public class PingPong {
    private static final Object lock = new Object();
    private static boolean pingTurn = true; // ping starts

    static class Ping implements Runnable {
        @Override public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    while (!pingTurn) {
                        try { lock.wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); return; }
                    }
                    System.out.println("ping");
                    pingTurn = false;
                    lock.notifyAll();
                }
            }
        }
    }

    static class Pong implements Runnable {
        @Override public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    while (pingTurn) {
                        try { lock.wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); return; }
                    }
                    System.out.println("pong");
                    pingTurn = true;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Ping(), "Ping");
        Thread b = new Thread(new Pong(), "Pong");
        a.start(); b.start();
        a.join();  b.join();
        System.out.println("Game over.");
    }
}
