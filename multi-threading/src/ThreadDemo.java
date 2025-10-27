package module07;

class MyThread extends Thread {
 // The run() method contains the code to be executed by the new thread.
 @Override
 public void run() {
     System.out.println("Child thread (from extending Thread) is running.");
     
     for(int i = 0; i < 5; i++) {
    	 System.out.println("Child thread: " + i);
     }
     
 }
 /*
 public static void changePriority(Thread t) {
	 t.setPriority(MAX_PRIORITY);
 }*/
}

public class ThreadDemo {
 public static void main(String[] args) {
     MyThread t = new MyThread(); // Create a thread object.
     
     Thread t1 = Thread.currentThread();
     t1.setPriority(1);
     
     t.start(); // Start the thread. This calls the run() method.
 
     /*try {
    	 t1.sleep(1000);
     } catch(InterruptedException e) {
    	 //
     }*/
     System.out.println("Main thread is also running.");
     
     for(int i = 0; i < 10; i++) {
    	 System.out.println("Main thread: " + i);
     }
     
 }
}
