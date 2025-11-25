public class DecoratorCoffeeExample {

    // ----- Component interface -----
    interface Coffee {
        double getCost();
        String getDescription();
    }

    // ----- Concrete component -----
    static class SimpleCoffee implements Coffee {
        @Override
        public double getCost() {
            return 50.0; // Rs 50
        }

        @Override
        public String getDescription() {
            return "Simple coffee";
        }
    }

    // ----- Base Decorator (implements same interface, wraps a Coffee) -----
    static abstract class CoffeeDecorator implements Coffee {

        protected Coffee decoratedCoffee; // the wrapped object

        public CoffeeDecorator(Coffee coffee) {
            this.decoratedCoffee = coffee;
        }

        @Override
        public double getCost() {
            return decoratedCoffee.getCost();
        }

        @Override
        public String getDescription() {
            return decoratedCoffee.getDescription();
        }
    }

    // ----- Concrete decorators -----

    static class MilkDecorator extends CoffeeDecorator {

        public MilkDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public double getCost() {
            // add milk cost
            return super.getCost() + 10.0;
        }

        @Override
        public String getDescription() {
            return super.getDescription() + ", milk";
        }
    }

    static class SugarDecorator extends CoffeeDecorator {

        public SugarDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public double getCost() {
            // add sugar cost
            return super.getCost() + 5.0;
        }

        @Override
        public String getDescription() {
            return super.getDescription() + ", sugar";
        }
    }

    static class WhippedCreamDecorator extends CoffeeDecorator {

        public WhippedCreamDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public double getCost() {
            return super.getCost() + 15.0;
        }

        @Override
        public String getDescription() {
            return super.getDescription() + ", whipped cream";
        }
    }

    // ----- Client code -----
    public static void main(String[] args) {

        Coffee c1 = new SimpleCoffee();
        System.out.println(c1.getDescription() + " => Rs " + c1.getCost());

        Coffee c2 = new MilkDecorator(new SimpleCoffee());
        System.out.println(c2.getDescription() + " => Rs " + c2.getCost());

        Coffee c3 = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println(c3.getDescription() + " => Rs " + c3.getCost());

        Coffee c4 = new WhippedCreamDecorator(
                new SugarDecorator(
                        new MilkDecorator(
                                new SimpleCoffee())));
        System.out.println(c4.getDescription() + " => Rs " + c4.getCost());
    }
}
