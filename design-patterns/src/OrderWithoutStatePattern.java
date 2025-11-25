public class OrderWithoutStatePattern {

    enum OrderStatus {
        NEW, PAID, SHIPPED, CANCELLED
    }

    static class Order {
        private OrderStatus status = OrderStatus.NEW;
        private final String id;

        public Order(String id) {
            this.id = id;
        }

        public void pay() {
            switch (status) {
                case NEW:
                    System.out.println("Order " + id + ": payment successful, moving to PAID");
                    status = OrderStatus.PAID;
                    break;
                case PAID:
                    System.out.println("Order " + id + ": already paid");
                    break;
                case SHIPPED:
                    System.out.println("Order " + id + ": cannot pay, already shipped");
                    break;
                case CANCELLED:
                    System.out.println("Order " + id + ": cannot pay, order is cancelled");
                    break;
            }
        }

        public void ship() {
            switch (status) {
                case NEW:
                    System.out.println("Order " + id + ": cannot ship, payment pending");
                    break;
                case PAID:
                    System.out.println("Order " + id + ": shipping now, moving to SHIPPED");
                    status = OrderStatus.SHIPPED;
                    break;
                case SHIPPED:
                    System.out.println("Order " + id + ": already shipped");
                    break;
                case CANCELLED:
                    System.out.println("Order " + id + ": cannot ship, order is cancelled");
                    break;
            }
        }

        public void cancel() {
            switch (status) {
                case NEW:
                    System.out.println("Order " + id + ": cancelling from NEW, moving to CANCELLED");
                    status = OrderStatus.CANCELLED;
                    break;
                case PAID:
                    System.out.println("Order " + id + ": refund and cancel, moving to CANCELLED");
                    status = OrderStatus.CANCELLED;
                    break;
                case SHIPPED:
                    System.out.println("Order " + id + ": cannot cancel, already shipped");
                    break;
                case CANCELLED:
                    System.out.println("Order " + id + ": already cancelled");
                    break;
            }
        }

        public OrderStatus getStatus() {
            return status;
        }
    }

    // Demo
    public static void main(String[] args) {
        Order order = new Order("ORD-101");

        order.ship();   // cannot ship, payment pending
        order.pay();    // NEW -> PAID
        order.pay();    // already paid
        order.ship();   // PAID -> SHIPPED
        order.cancel(); // cannot cancel, shipped

        System.out.println("Final status: " + order.getStatus());
    }
}
