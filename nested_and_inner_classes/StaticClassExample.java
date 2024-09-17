class BankAccount {
    private int accountNumber;
    private double balance;
    static String bankName = "Global Bank";

    public BankAccount(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Get the account balance
    public double getBalance() {
        return balance;
    }

    // Static nested class representing a transaction
    static class Transaction {
        private int transactionId;
        private String transactionType;
        private double amount;

        public Transaction(int transactionId, String transactionType, double amount) {
            this.transactionId = transactionId;
            this.transactionType = transactionType;
            this.amount = amount;
        }

        public void processTransaction(BankAccount account) {
            System.out.println("Processing transaction at " + bankName);
            if ("Deposit".equalsIgnoreCase(transactionType)) {
                account.deposit(amount);
            } else if ("Withdraw".equalsIgnoreCase(transactionType)) {
                account.withdraw(amount);
            } else {
                System.out.println("Invalid transaction type!");
            }
        }

        public void showTransactionDetails() {
            System.out.println("Transaction ID: " + transactionId);
            System.out.println("Transaction Type: " + transactionType);
            System.out.println("Transaction Amount: " + amount);
        }
    }
}

public class StaticClassExample {
    public static void main(String[] args) {
        // Creating a BankAccount object
        BankAccount account = new BankAccount(12345, 1000.00);

        // Creating a Transaction object using the static nested class
        BankAccount.Transaction transaction1 = new BankAccount.Transaction(1, "Deposit", 500.00);
        BankAccount.Transaction transaction2 = new BankAccount.Transaction(2, "Withdraw", 200.00);

        // Processing transactions
        transaction1.processTransaction(account);
        System.out.println("Balance after deposit: " + account.getBalance());

        transaction2.processTransaction(account);
        System.out.println("Balance after withdrawal: " + account.getBalance());

        // Showing transaction details
        transaction1.showTransactionDetails();
        transaction2.showTransactionDetails();
    }
}