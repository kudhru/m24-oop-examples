package module07.multithreading;

// Create multiple threads.
class NewThread03 implements Runnable {
    String name; // name of thread
    Thread t;
    
    NewThread03(String threadname) {
        name = threadname;
        t = new Thread(this, name);
       
        if(name.equals("One")) {
        	t.setPriority(10);
        }
        
        if(name.equals("Two")) {
        	t.setPriority(1);
        }
        
        System.out.println("New thread: " + t);
        t.start(); // Start the thread
    }

    // This is the entry point for thread.
    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + "Interrupted");
        }
        System.out.println(name + " exiting.");
    }
}

class MultiThreadDemo {
    public static void main(String args[]) {
        NewThread03 obj1 = new NewThread03("One"); // start threads
        NewThread03 obj2 =new NewThread03("Two");
        NewThread03 obj3 =new NewThread03("Three");
        
        System.out.println(obj1.t.isAlive());
        System.out.println(obj2.t.isAlive());
        System.out.println(obj3.t.isAlive());

        try {
            // wait for other threads to end
            //Thread.sleep(10000);
        	obj1.t.join();
        	obj2.t.join();
        	obj3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        System.out.println("Main thread exiting.");
    }
}
