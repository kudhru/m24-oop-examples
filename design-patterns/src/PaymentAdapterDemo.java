
// ===== Target interface (what our app is written against) =====
interface PaymentProcessor1 {
    void pay(double amountInRupees);
}

// ===== Existing app code: uses ONLY PaymentProcessor =====
class OnlineStore1 {
    static void checkout(PaymentProcessor1 processor, double amount) {
        System.out.println("OnlineStore: Starting checkout for amount Rs " + amount);
        processor.pay(amount);
        System.out.println("OnlineStore: Checkout complete.\n");
    }
}

// ===== Adaptee: legacy / third-party API (we cannot change this) =====
class LegacyBankApi1 {

    void makeTransaction(int amountInPaise, String fromAccount, String toAccount) {
        System.out.println("LegacyBankApi: Transferring " + amountInPaise +
                " paise from " + fromAccount + " to " + toAccount);
    }
}

// ===== Adapter: implements PaymentProcessor, uses LegacyBankApi =====
class BankApiAdapter implements PaymentProcessor1 {

    private final LegacyBankApi1 bankApi;
    private final String fromAccount;
    private final String toAccount;

    BankApiAdapter(LegacyBankApi1 bankApi, String fromAccount, String toAccount) {
        this.bankApi = bankApi;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    @Override
    public void pay(double amountInRupees) {
        // Adapt rupees -> paise (double -> int)
        int paise = (int) Math.round(amountInRupees * 100);
        bankApi.makeTransaction(paise, fromAccount, toAccount);
    }
}

public class PaymentAdapterDemo {

    public static void main(String[] args) {

        // ---------- This would NOT compile (uncomment to show students) ----------
        // LegacyBankApi bankApi = new LegacyBankApi();
        // OnlineStore.checkout(bankApi, 500.0);  // ❌ incompatible types

        // ---------- WITH ADAPTER: now it works ----------
        LegacyBankApi1 bankApi = new LegacyBankApi1();
        PaymentProcessor1 processor =
                new BankApiAdapter(bankApi, "ACC-111", "ACC-222");

        OnlineStore1.checkout(processor, 500.0);
        OnlineStore1.checkout(processor, 123.45);
    }
}
