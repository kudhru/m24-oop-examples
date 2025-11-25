import java.math.BigDecimal;

// 1. The Strategy Interface (PaymentStrategy)
interface PaymentStrategy {
    void pay(BigDecimal amount);
}

// 2. Concrete Strategies (Implementations of the algorithm)

class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardPayment(String nm, String ccNum, String cvv, String expiryDate) {
        this.name = nm;
        this.cardNumber = ccNum;
        this.cvv = cvv;
        this.dateOfExpiry = expiryDate;
    }

    @Override
    public void pay(BigDecimal amount) {
        System.out.println(amount + " paid with Credit Card (ending in " + cardNumber.substring(cardNumber.length() - 4) + ").");
        // Actual logic for processing credit card payment would go here
    }
}

class PayPalPayment implements PaymentStrategy {
    private String emailId;
    private String password; // In a real app, this would be handled securely

    public PayPalPayment(String email, String pwd) {
        this.emailId = email;
        this.password = pwd;
    }

    @Override
    public void pay(BigDecimal amount) {
        System.out.println(amount + " paid using PayPal account: " + emailId);
        // Actual logic for interfacing with PayPal API would go here
    }
}

class BitcoinPayment implements PaymentStrategy {
    private String walletAddress;

    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(BigDecimal amount) {
        System.out.println(amount + " paid using Bitcoin wallet address: " + walletAddress);
        // Actual logic for processing Bitcoin transaction would go here
    }
}

// 3. The Context (ShoppingCart/Checkout Process)
class ShoppingCart {
    private BigDecimal totalAmount = BigDecimal.ZERO;

    public void addProductPrice(BigDecimal price) {
        totalAmount = totalAmount.add(price);
    }

    // This is the key method: it accepts a PaymentStrategy and uses it
    public void checkout(PaymentStrategy paymentMethod) {
        System.out.println("Total amount due: " + totalAmount);
        paymentMethod.pay(totalAmount);
        totalAmount = BigDecimal.ZERO; // Reset cart after checkout
    }
}

// 4. Demonstration (Client)
public class StrategyPatternExample2 {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProductPrice(new BigDecimal("100.50"));
        cart.addProductPrice(new BigDecimal("25.00"));

        // The client decides which strategy to use at runtime:

        System.out.println("--- Scenario 1: Paying with PayPal ---");
        PaymentStrategy payPal = new PayPalPayment("john.doe@example.com", "mypwd");
        // The checkout method doesn't care *how* it's paid, just that it fulfills the interface
        cart.checkout(payPal);

        System.out.println("\n--- Scenario 2: Paying with Credit Card ---");
        cart.addProductPrice(new BigDecimal("50.00")); // Add new items to cart
        cart.addProductPrice(new BigDecimal("10.00"));
        PaymentStrategy creditCard = new CreditCardPayment("John Doe", "1234567890123456", "123", "12/25");
        cart.checkout(creditCard);
    }
}
