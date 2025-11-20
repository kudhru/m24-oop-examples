// File: NotifyAllBell.java
public class NotifyAllBell {
    private static final Object bell = new Object();
    private static boolean bellRung = false;

    static class Student implements Runnable {
        private final int id;
        Student(int id) { this.id = id; }
        @Override public void run() {
            synchronized (bell) {
                while (!bellRung) {
                    try { bell.wait(); } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); return;
                    }
                }
                System.out.println("Student " + id + ": leaving class!");
            }
        }
    }

    static class Teacher implements Runnable {
        @Override public void run() {
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            synchronized (bell) {
                bellRung = true;
                bell.notifyAll(); // wake ALL waiting students
                System.out.println("Teacher: bell rung!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 3; i++) new Thread(new Student(i), "S"+i).start();
        Thread t = new Thread(new Teacher(), "Teacher");
        t.start(); t.join();
        Thread.sleep(300); // small grace to let students print
        System.out.println("All students released.");
    }
}
