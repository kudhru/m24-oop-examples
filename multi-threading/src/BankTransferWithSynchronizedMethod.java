// File: BadAccount.java
import java.util.concurrent.ThreadLocalRandom;

public class BankTransferWithSynchronizedMethod {
    private int cents;

    public BankTransferWithSynchronizedMethod(int cents) {
        this.cents = cents;
    }

    // Each method locks on "this", but they do NOT hold both accounts at once.
    public synchronized void debit(int amt) {
        if (amt <= 0) throw new IllegalArgumentException("amount must be > 0");
        if (cents < amt) throw new IllegalStateException("insufficient funds");
        sleepQuiet(1); // widen interleaving window (for demo)
        cents -= amt;
    }

    public synchronized void credit(int amt) {
        if (amt <= 0) throw new IllegalArgumentException("amount must be > 0");
        sleepQuiet(1); // widen interleaving window (for demo)
        cents += amt;
    }

    public synchronized int balanceCents() {
        return cents;
    }

    // BAD: Not atomic. Debits "from" and only later credits "to".
    // If something fails in between (simulated below), money disappears.
    static void transfer(BankTransferWithSynchronizedMethod from, BankTransferWithSynchronizedMethod to, int amt) {
        from.debit(amt);                  // holds 'from' monitor during call
        maybeFailRandomly();              // simulate crash/network/db error, etc.
        to.credit(amt);                   // holds 'to' monitor during call
    }

    // --- Demo driver ---
    public static void main(String[] args) throws InterruptedException {
        final BankTransferWithSynchronizedMethod a = new BankTransferWithSynchronizedMethod(100_00); // ₹100.00
        final BankTransferWithSynchronizedMethod b = new BankTransferWithSynchronizedMethod(100_00); // ₹100.00
        final int initialTotal = a.balanceCents() + b.balanceCents();

        Runnable t1 = () -> {
            for (int i = 0; i < 5_000; i++) {
                try { transfer(a, b, 1); } catch (RuntimeException ignored) {}
            }
        };
        Runnable t2 = () -> {
            for (int i = 0; i < 5_000; i++) {
                try { transfer(b, a, 1); } catch (RuntimeException ignored) {}
            }
        };

        Thread th1 = new Thread(t1, "A→B");
        Thread th2 = new Thread(t2, "B→A");
        th1.start(); th2.start();
        th1.join();  th2.join();

        int finalTotal = a.balanceCents() + b.balanceCents();
        System.out.printf("A = ₹%.2f, B = ₹%.2f, total = ₹%.2f (initial ₹%.2f)%n",
                a.balanceCents() / 100.0, b.balanceCents() / 100.0,
                finalTotal / 100.0, initialTotal / 100.0);

        if (finalTotal != initialTotal) {
            System.out.println("⚠️ Money lost: transfer was not atomic (failure between debit and credit).");
        } else {
            System.out.println("No loss observed this run, but the design is still unsafe.");
        }
    }

    // --- helpers for the demo ---
    private static void maybeFailRandomly() {
        // ~0.1% chance to "crash" between debit and credit
        if (ThreadLocalRandom.current().nextInt(1000) == 0) {
            throw new RuntimeException("Simulated failure between debit and credit");
        }
    }

    private static void sleepQuiet(long ms) {
        try { Thread.sleep(ms); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
