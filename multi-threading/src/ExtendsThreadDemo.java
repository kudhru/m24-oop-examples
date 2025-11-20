// File: ExtendsThreadDemo.java
public class ExtendsThreadDemo {
    static class MyThread extends Thread {
        private final int n;
        MyThread(String name, int n) { super(name); this.n = n; }

        @Override
        public void run() {
            for (int i = 1; i <= n; i++) {
                System.out.printf("[%s] i=%d%n", getName(), i);
                try { Thread.sleep(150); } catch (InterruptedException e) { return; }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MyThread("Counter-1", 5);
        Thread t2 = new MyThread("Counter-2", 5);
        Thread t3 = new Thread(new MyThread("Counter-3", 5));

//        t1.setPriority(Thread.MAX_PRIORITY); // just to show API (not deterministic)
        t1.start(); t2.start(); t3.start();
        t1.join();  t2.join();
        t3.join();

        System.out.println("Done");
    }
}
