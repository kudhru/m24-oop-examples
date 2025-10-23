// File: RaceCondition.java
import java.util.ArrayList;
import java.util.List;

public class RaceCondition {
    static class Counter { int value = 0; void inc() { value++; } }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        int threads = 8;
        int perThread = 100_000;

        List<Thread> list = new ArrayList<>();
        Runnable r = () -> { for (int i = 0; i < perThread; i++) counter.inc(); };

        for (int i = 0; i < threads; i++) list.add(new Thread(r));
        for (Thread t : list) t.start();
        for (Thread t : list) t.join();

        int expected = threads * perThread;
        System.out.println("Expected = " + expected + " | Actual = " + counter.value);
        // Almost always: Actual < Expected due to lost updates.
    }
}
