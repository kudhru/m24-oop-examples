package module07.multithreading;

// This program uses a synchronized block.
class Callme01 {
    void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller01 implements Runnable {
    String msg;
    Callme01 target;
    Thread t;

    public Caller01(Callme01 targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    // synchronize calls to call()
    public void run() {
        synchronized(target) { // synchronized block
            target.call(msg);
        }
    }
}

class Synch1 {
    public static void main(String args[]) {
        Callme01 target = new Callme01();
        Caller01 ob1 = new Caller01(target, "Hello");
        Caller01 ob2 = new Caller01(target, "Synchronized");
        Caller01 ob3 = new Caller01(target, "World");

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