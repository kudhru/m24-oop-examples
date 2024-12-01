// Target Interface
interface INRAccount {
    double getBalanceInINR();
}

// Adaptee
class LegacyUSDAccount {
    private double balanceInUSD;

    public LegacyUSDAccount(double balanceInUSD) {
        this.balanceInUSD = balanceInUSD;
    }

    public double getBalanceInUSD() {
        return balanceInUSD;
    }
}

// Adapter
// Implement the Adapter class to make LegacyUSDAccount compatible with INRAccount

class AccountAdapter implements INRAccount {
    private LegacyUSDAccount legacyAccount;
    private double conversionRate;

    // Constructor to accept the LegacyUSDAccount object
    public AccountAdapter(LegacyUSDAccount legacyAccount, double conversionRate) {
        // Initialize the legacyAccount reference
        this.legacyAccount = legacyAccount;
        this.conversionRate = conversionRate;
    }

    // Implement the getBalanceInINR method
    public double getBalanceInINR() {
        // Use the legacyAccount reference to get balance in USD
        double balanceInUSD = legacyAccount.getBalanceInUSD();
        // and convert it to INR using 1 USD = 82.5 INR
        return balanceInUSD * conversionRate; // Replace with actual implementation
    }
}

// Client
public class AdapterPatternExample2 {
    public static void main(String[] args) {
        // Conversion Rate: 1 USD = 82.5 INR (use this rate in your adapter implementation)

        // Create a LegacyUSDAccount with a specific balance
        LegacyUSDAccount legacyAccount = new LegacyUSDAccount(1000);

        // Use the adapter to retrieve the balance in INR
        INRAccount adapter = new AccountAdapter(legacyAccount, 81);
        System.out.println("Balance in INR: " + adapter.getBalanceInINR());

        // Additional Test Cases
        INRAccount adapter2 = new AccountAdapter(new LegacyUSDAccount(500), 81);
        System.out.println("Balance in INR: " + adapter2.getBalanceInINR());

        INRAccount adapter3 = new AccountAdapter(new LegacyUSDAccount(1234.56), 83);
        System.out.println("Balance in INR: " + adapter3.getBalanceInINR());
    }
}
