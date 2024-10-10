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

    @Override
    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
//        return Double.compare(order.amount, amount) == 0 &&
//                Objects.equals(orderId, order.orderId) &&
//                Objects.equals(customerName, order.customerName);

        return this.orderId.equals(order.orderId) &&
                this.customerName.equals(order.customerName) && this.amount == order.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerName, amount);
    }
}

public class OverriddenEqualsAndHashCode {
    public static void main(String[] args) {
        Order order1 = new Order("ORD123", "John Doe", 250.0);
        Order order2 = new Order("ORD123", "John Doe", 250.0);

        System.out.println(order1.equals(order2)); // true, because equals() compares orderId, customerName, and amount
        System.out.println(order1.hashCode() == order2.hashCode()); // true, as hashCode is consistent with equals

        // Demonstration with a HashSet
        Set<Order> orders = new HashSet<>();
        orders.add(order1);
        orders.add(order2); // order2 will not be added because order1 and order2 are equal

        System.out.println(orders.size()); // 1
    }
}
