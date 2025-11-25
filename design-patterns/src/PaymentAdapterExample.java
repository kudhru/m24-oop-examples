public class PaymentAdapterExample {

    // ===== Target interface (what our app expects) =====
    interface PaymentProcessor {
        void pay(double amountInRupees);
    }

    // ===== Adaptee (legacy / third-party API, we cannot change it) =====
    static class LegacyBankApi {

        void makeTransaction(int amountInPaise, String fromAccount, String toAccount) {
            System.out.println("LegacyBankApi: Transferring " + amountInPaise +
                    " paise from " + fromAccount + " to " + toAccount);
        }
    }

    // ===== 1. CLASS ADAPTER: extends Adaptee, implements Target =====
    static class ClassAdapter extends LegacyBankApi implements PaymentProcessor {

        private final String fromAccount;
        private final String toAccount;

        ClassAdapter(String fromAccount, String toAccount) {
            this.fromAccount = fromAccount;
            this.toAccount = toAccount;
        }

        @Override
        public void pay(double amountInRupees) {
            int paise = (int) (amountInRupees * 100); // convert Rs → paise
            // call legacy method
            makeTransaction(paise, fromAccount, toAccount);
        }
    }

    // ===== 2. OBJECT ADAPTER: has-a Adaptee, implements Target =====
    static class ObjectAdapter implements PaymentProcessor {

        private final LegacyBankApi bankApi;
        private final String fromAccount;
        private final String toAccount;

        ObjectAdapter(LegacyBankApi bankApi, String fromAccount, String toAccount) {
            this.bankApi = bankApi;
            this.fromAccount = fromAccount;
            this.toAccount = toAccount;
        }

        @Override
        public void pay(double amountInRupees) {
            int paise = (int) (amountInRupees * 100); // convert Rs → paise
            bankApi.makeTransaction(paise, fromAccount, toAccount);
        }
    }

    // ===== Client code to compare both =====
    public static void main(String[] args) {

        System.out.println("=== Class Adapter ===");
        PaymentProcessor p1 = new ClassAdapter("ACC-111", "ACC-222");
        p1.pay(123.45);

        System.out.println("=== Object Adapter ===");
        LegacyBankApi bankApi = new LegacyBankApi();
        PaymentProcessor p2 = new ObjectAdapter(bankApi, "ACC-333", "ACC-444");
        p2.pay(500.00);
    }
}
