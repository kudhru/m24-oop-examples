package module07.multithreading;

class A1 {
    void foo(B1 b) {
        String name = Thread.currentThread().getName();
        synchronized(this) {          // lock on A
            System.out.println(name + " entered A.foo");

            try { Thread.sleep(1000); } catch(Exception e) {}

            synchronized(b) {        // lock on B
                System.out.println(name + " calling B.last()");
                b.last();
            }
        }
    }

    void last() {
        System.out.println("Inside A.last");
    }
}

class B1 {
    void bar(A1 a) {
        String name = Thread.currentThread().getName();
        synchronized(a) {             // lock on A first
            synchronized(this) {      // then lock on B
                System.out.println(name + " entered B.bar");
                try { Thread.sleep(1000); } catch(Exception e) {}
                System.out.println(name + " calling A.last()");
                a.last();
            }
        }
    }

    void last() {
        System.out.println("Inside B.last");
    }
}

class DeadlockFree1 implements Runnable {
    A1 a = new A1();
    B1 b = new B1();

    DeadlockFree1() {
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
        new DeadlockFree1();
    }
}
