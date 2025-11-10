// File: BankTransferWithLockOrdering.java
public class BankTransferWithLockOrdering {

    static class Account {
        private int cents;
        private final Object lock = new Object();          // private monitor for this account
        private static final Object tieLock = new Object(); // rare hash tie breaker

        Account(int cents) { this.cents = cents; }

        // -- Good: synchronize with explicit lock ordering across two different accounts.
        static void transfer(Account from, Account to, int amountCents) {
            if (from == to) return; // no-op

            int h1 = System.identityHashCode(from.lock);
            int h2 = System.identityHashCode(to.lock);

            if (h1 < h2) {
                synchronized (from.lock) {
                    synchronized (to.lock) {
                        move(from, to, amountCents);
                    }
                }
            } else if (h1 > h2) {
                synchronized (to.lock) {
                    synchronized (from.lock) {
                        move(from, to, amountCents);
                    }
                }
            } else { // extremely rare: identical identityHashCode; use a global tie lock
                synchronized (tieLock) {
                    synchronized (from.lock) {
                        synchronized (to.lock) {
                            move(from, to, amountCents);
                        }
                    }
                }
            }
        }

        private static void move(Account from, Account to, int amount) {
            if (amount <= 0) throw new IllegalArgumentException("amount > 0 required");
            if (from.cents < amount) throw new IllegalStateException("insufficient funds");
            from.cents -= amount;
            to.cents   += amount;
        }

        int balanceCents() {
            synchronized (lock) { return cents; }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Account a = new Account(100_00); // ₹100.00
        Account b = new Account(100_00); // ₹100.00

        // Two opposing transfers running concurrently (classic deadlock scenario if done wrong)
        Thread t1 = new Thread(() -> { for (int i = 0; i < 10_000; i++) Account.transfer(a, b, 1); }, "A→B");
        Thread t2 = new Thread(() -> { for (int i = 0; i < 10_000; i++) Account.transfer(b, a, 1); }, "B→A");

        t1.start(); t2.start();
        t1.join();  t2.join();

        System.out.println("A balance ₹" + a.balanceCents() / 100.0);
        System.out.println("B balance ₹" + b.balanceCents() / 100.0);
    }
}
