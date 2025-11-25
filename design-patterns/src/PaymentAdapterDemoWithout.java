interface PaymentProcessor {
    void pay(double amountInRupees);
}

class OnlineStore {
    static void checkout(PaymentProcessor1 processor, double amount) {
        System.out.println("Starting checkout for amount: Rs " + amount);
        processor.pay(amount);
        System.out.println("Checkout complete.\n");
    }
}
class LegacyBankApi {
    void makeTransaction(int amountInPaise, String fromAccount, String toAccount) {
        System.out.println("LegacyBankApi: Transferring " + amountInPaise +
                " paise from " + fromAccount + " to " + toAccount);
    }
}
public class PaymentAdapterDemoWithout {
    public static void main(String[] args) {
        LegacyBankApi1 bankApi = new LegacyBankApi1();
        // OnlineStore.checkout(bankApi, 500.0);  // ❌ DOES NOT COMPILE
    }
}
