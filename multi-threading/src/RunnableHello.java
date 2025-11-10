// File: RunnableHello.java
public class RunnableHello {
    static class HelloTask implements Runnable {
        private final String message;
        HelloTask(String message) { this.message = message; }

        @Override
        public void run() {
            while(true){
                String t = Thread.currentThread().getName();
//                System.out.println(t);
            }
//            String t = Thread.currentThread().getName();
//            for (int i = 1; i <= 3; i++) {
//                System.out.printf("[%s] %s (%d)%n", t, message, i);
//                try { Thread.sleep(200); } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new HelloTask("Hello from A"), "A");
        Thread t2 = new Thread(new HelloTask("Hello from B"), "B");
        Thread t3 = new Thread(new HelloTask("Hello from C"), "C");
        t1.setDaemon(true);
        t2.setDaemon(true);
        t3.setDaemon(true);
        t1.start(); t2.start(); t3.start(); // run concurrently
        System.out.println("Waiting for T1 to finish");
//        t1.join();
        System.out.println("T1 finished");
        System.out.println("Waiting for T2 to finish");
//        t2.join();
        System.out.println("T2 finished");
        System.out.println("Waiting for T3 to finish");
//        t3.join();  // wait for all to finish
        System.out.println("T3 finished");

        System.out.println("All done!");
    }
}
