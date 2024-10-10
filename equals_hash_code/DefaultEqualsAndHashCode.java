import java.util.Objects;

class Order {
    String orderId;
    String customerName;
    double amount;

    Order(String orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
    }

    public boolean equals(Order order) {
        return this.orderId.equals(order.orderId) &&
                this.customerName.equals(order.customerName) && this.amount == order.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerName, amount);
    }
}

public class DefaultEqualsAndHashCode {
    public static void main(String[] args) {
        Order order1 = new Order("ORD123", "John Doe", 250.0);
        Order order2 = new Order("ORD123", "John Doe", 250.0);

        // Hash code is nothing but f(x) = some mathematical function
        System.out.println(order1 == order2);
        System.out.println(order1.equals(order2)); // false, because the default equals() compares memory addresses
        System.out.println(order1.hashCode() == order2.hashCode()); // also false, as hashCode is not overridden
    }
}
