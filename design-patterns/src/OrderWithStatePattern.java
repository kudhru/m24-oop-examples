public class OrderWithStatePattern {

    // ----- State interface -----
    interface OrderState {
        void pay(Order order);
        void ship(Order order);
        void cancel(Order order);
        String getName();
    }

    // ----- Context -----
    static class Order {
        private OrderState state;
        private final String id;

        public Order(String id) {
            this.id = id;
            this.state = new NewState();  // initial state
        }

        // Package-private or public setter used by states
        void setState(OrderState state) {
            System.out.println("Order " + id + ": transitioning to " + state.getName());
            this.state = state;
        }

        public void pay() {
            state.pay(this);
        }

        public void ship() {
            state.ship(this);
        }

        public void cancel() {
            state.cancel(this);
        }

        public String getStateName() {
            return state.getName();
        }

        public String getId() {
            return id;
        }
    }

    // ----- Concrete States -----

    static class NewState implements OrderState {

        @Override
        public void pay(Order order) {
            System.out.println("Order " + order.getId() + " [NEW]: payment successful.");
            order.setState(new PaidState());
        }

        @Override
        public void ship(Order order) {
            System.out.println("Order " + order.getId() + " [NEW]: cannot ship, payment pending.");
        }

        @Override
        public void cancel(Order order) {
            System.out.println("Order " + order.getId() + " [NEW]: cancelling order.");
            order.setState(new CancelledState());
        }

        @Override
        public String getName() {
            return "NEW";
        }
    }

    static class PaidState implements OrderState {

        @Override
        public void pay(Order order) {
            System.out.println("Order " + order.getId() + " [PAID]: already paid.");
        }

        @Override
        public void ship(Order order) {
            System.out.println("Order " + order.getId() + " [PAID]: shipping order.");
            order.setState(new ShippedState());
        }

        @Override
        public void cancel(Order order) {
            System.out.println("Order " + order.getId() + " [PAID]: refunding and cancelling.");
            order.setState(new CancelledState());
        }

        @Override
        public String getName() {
            return "PAID";
        }
    }

    static class ShippedState implements OrderState {

        @Override
        public void pay(Order order) {
            System.out.println("Order " + order.getId() + " [SHIPPED]: cannot pay, already shipped.");
        }

        @Override
        public void ship(Order order) {
            System.out.println("Order " + order.getId() + " [SHIPPED]: already shipped.");
        }

        @Override
        public void cancel(Order order) {
            System.out.println("Order " + order.getId() + " [SHIPPED]: cannot cancel, already shipped.");
        }

        @Override
        public String getName() {
            return "SHIPPED";
        }
    }

    static class CancelledState implements OrderState {

        @Override
        public void pay(Order order) {
            System.out.println("Order " + order.getId() + " [CANCELLED]: cannot pay, order cancelled.");
        }

        @Override
        public void ship(Order order) {
            System.out.println("Order " + order.getId() + " [CANCELLED]: cannot ship, order cancelled.");
        }

        @Override
        public void cancel(Order order) {
            System.out.println("Order " + order.getId() + " [CANCELLED]: already cancelled.");
        }

        @Override
        public String getName() {
            return "CANCELLED";
        }
    }

    // ----- Demo -----
    public static void main(String[] args) {
        Order order = new Order("ORD-202");

        order.ship();   // NEW: cannot ship
        order.pay();    // NEW -> PAID
        order.pay();    // PAID: already paid
        order.ship();   // PAID -> SHIPPED
        order.cancel(); // SHIPPED: cannot cancel

        System.out.println("Final state: " + order.getStateName());
    }
}
