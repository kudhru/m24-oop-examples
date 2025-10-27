package module07.multithreading;

// This program uses a synchronized block.
class Callme02 {
    synchronized void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller02 implements Runnable {
    String msg;
    Callme02 target;
    Thread t;

    public Caller02(Callme02 targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    // synchronize calls to call()
    public void run() {
            target.call(msg);

    }
}

class Sync2 {
    public static void main(String args[]) {
        Callme02 target = new Callme02();
        Caller02 ob1 = new Caller02(target, "Hello");
        Caller02 ob2 = new Caller02(target, "Synchronized");
        Caller02 ob3 = new Caller02(target, "World");

        // wait for threads to end
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}