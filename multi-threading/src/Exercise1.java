package module07.multithreading;

/*
Write a class Main.java with at least 3 classes
public class  Main{…} , class  ThreadA, class ThreadB 

ThreadA extends Thread, whose run() method will randomly and repeatedly print “You say hello” or “You say good morning” to the console, until interrupted by Main
ThreadB extends Thread, whose run() method will print “I say good bye” or “I say good night” to the console depending on whether ThreadA said “…hello” or “…good morning”, until it is interrupted (or informed) by ThreadA.
Main is the main class, whose main(…) method will 
- Create an instance of ThreadA and an instance of ThreadB and start them.
- Read a char from the console
- Interrupt threadA, which will then interrupt (and terminate )threadB, and then terminate (by running to completion ) itself. (notes: don’t use stop() method).

Requirement: ThreadA and threadB must be executed in such a way that
- The output is started with a “…hello” or “…good morning“ line said by A,
- Every line said by A is followed by a corresponding line said by B, which, unless is the last line, is followed by a line said by A .
- The output is ended with a line said by B.

To avoid too many messages shown in  the console in a short time, you threads are advised to sleep() for a short time after printing a message.
*/

import java.util.Random;
import java.util.Scanner;

public class Exercise1 {
    public static final Object lock = new Object(); // Shared lock for synchronization
    public static volatile String lastMessage = null; // Stores the last message from ThreadA
    public static volatile boolean finished = false; // Indicates threads should terminate

    // Class for ThreadA, which extends Thread
    public static class ThreadA extends Thread {
        private final ThreadB threadB;
        private final Random random = new Random();
        private final String[] greetings = {"You say hello", "You say good morning"};

        public ThreadA(ThreadB threadB) {
            this.threadB = threadB;
        }

        @Override
        public void run() {
            try {
                // Initial message to start the conversation
                String message = greetings[random.nextInt(2)];
                System.out.println(message);
                
                synchronized (lock) {
                    lastMessage = message;
                    lock.notify(); // Wake up ThreadB
                }
                
                while (!isInterrupted()) {
                    synchronized (lock) {
                        lock.wait(); // Wait for ThreadB to finish its response
                        if (isInterrupted()) break;
                    }

                    message = greetings[random.nextInt(2)];
                    System.out.println(message);
                    Thread.sleep(300); // Sleep to avoid console flooding

                    synchronized (lock) {
                        lastMessage = message;
                        lock.notify(); // Wake up ThreadB
                    }
                }
            } catch (InterruptedException e) {
                // Clean shutdown procedure
                System.out.println("ThreadA interrupted. Interrupting ThreadB...");
                threadB.interrupt(); // Interrupt ThreadB
                // Final message to allow ThreadB to respond one last time
                synchronized (lock) {
                    finished = true;
                    lock.notify();
                }
            } finally {
                System.out.println("ThreadA terminated.");
            }
        }
    }

    // Class for ThreadB, which extends Thread
    public static class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    String response;
                    synchronized (lock) {
                        lock.wait(); // Wait for a message from ThreadA
                        if (finished) break; // Check for termination
                        
                        if ("You say hello".equals(lastMessage)) {
                            response = "I say good bye";
                        } else {
                            response = "I say good night";
                        }
                    }
                    
                    System.out.println(response);
                    Thread.sleep(300); // Sleep to avoid console flooding
                    
                    synchronized (lock) {
                        if (finished) break;
                        lock.notify(); // Wake up ThreadA for the next round
                    }
                }
            } catch (InterruptedException e) {
                // ThreadB handles its own interruption
                System.out.println("ThreadB interrupted. Responding to the last message...");
                String finalResponse;
                synchronized (lock) {
                    if ("You say hello".equals(lastMessage)) {
                        finalResponse = "I say good bye";
                    } else {
                        finalResponse = "I say good night";
                    }
                }
                System.out.println(finalResponse);
            } finally {
                System.out.println("ThreadB terminated.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting threads. Press any key and Enter to interrupt.");

        // Create thread instances
        ThreadB threadB = new ThreadB();
        ThreadA threadA = new ThreadA(threadB);

        // Start the threads
        threadB.start();
        threadA.start();

        // Read a character from the console
        try {
            scanner.next();
        } finally {
            scanner.close();
        }

        // Interrupt ThreadA to begin the shutdown process
        threadA.interrupt();
    }
}
