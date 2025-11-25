
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

class AccountAdapter extends LegacyUSDAccount implements INRAccount {
    // Constructor and methods to be implemented
    // Constructor signature: public AccountAdapter(double balanceInUSD)
    private double conversionRate;
    public AccountAdapter(double balanceInUSD, double conversionRate) {
        super(balanceInUSD);
        this.conversionRate = conversionRate;
    }

    // Method to implement: public double getBalanceInINR()
    public double getBalanceInINR() {
        double balanceInUSD = getBalanceInUSD();
        return balanceInUSD * conversionRate;
    }
}

// Client
public class AdapterPatternExample {
    public static void main(String[] args) {
        // Conversion Rate: 1 USD = 82.5 INR (use this rate in your adapter implementation)

        // Create a LegacyUSDAccount with a specific balance
        LegacyUSDAccount legacyAccount = new LegacyUSDAccount(1000);

        // Use the adapter to retrieve the balance in INR
        INRAccount adapter = new AccountAdapter(legacyAccount.getBalanceInUSD(), 81);
        System.out.println("Balance in INR: " + adapter.getBalanceInINR());

        // Additional Test Cases
        INRAccount adapter2 = new AccountAdapter(500, 81);
        System.out.println("Balance in INR: " + adapter2.getBalanceInINR());

        INRAccount adapter3 = new AccountAdapter(1234.56, 81);
        System.out.println("Balance in INR: " + adapter3.getBalanceInINR());
    }
}
