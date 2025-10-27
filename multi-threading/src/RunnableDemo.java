package module07;


class MyRunnable implements Runnable {
 // The run() method defines the task for the thread.
 @Override
 public void run() {
     System.out.println("Child thread (from implementing Runnable) is running.");
     
     for(int i = 0; i < 5; i++) {
    	 System.out.println("Child thread: " + i);
     }
     
 }
}

public class RunnableDemo {
 public static void main(String[] args) {
     MyRunnable runnable = new MyRunnable(); // Create a Runnable object.
     Thread t = new Thread(runnable); // Pass the Runnable object to a Thread constructor.
     t.start(); // Start the thread.
     System.out.println("Main thread is also running.");
     
     for(int i = 0; i < 5; i++) {
    	 System.out.println("Main thread: " + i);
     }
     
 }
}
