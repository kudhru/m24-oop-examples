package module07.multithreading;

class A3 {
    void foo(B3 b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered A2.foo");

        try { Thread.sleep(1000); } catch(Exception e) {}

        b.last(); // only last() is synchronized
    }

    synchronized void last() {
        System.out.println("Inside A2.last");
    }
}

class B3 {
    void bar(A3 a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered B2.bar");

        try { Thread.sleep(1000); } catch(Exception e) {}

        a.last(); // only last() is synchronized
    }

    synchronized void last() {
        System.out.println("Inside B2.last");
    }
}

class DeadlockFree2 implements Runnable {
    A3 a = new A3();
    B3 b = new B3();

    DeadlockFree2() {
        Thread.currentThread().setName("MainThread");
        Thread t = new Thread(this, "RacingThread");
        t.start();

        a.foo(b); // Main thread
        System.out.println("Back in main thread");
    }

    public void run() {
        b.bar(a); // Other thread
        System.out.println("Back in other thread");
    }

    public static void main(String args[]) {
        new DeadlockFree2();
    }
}
