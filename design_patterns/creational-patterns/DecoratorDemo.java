// 1. Component Interface
// Defines the common operations for simple objects and their decorators.
interface Coffee {
    double getCost();
    String getDescription();
}

// 2. Concrete Component (The basic object being wrapped)
class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 2.0; // Base cost of a black coffee
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}

// 3. Decorator Abstract Class
// Maintains a reference to a Component object and conforms to the Component interface.
abstract class CoffeeDecorator implements Coffee {
    protected final Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost(); // Default behavior: delegate
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription(); // Default behavior: delegate
    }
}

// 4. Concrete Decorators (Add specific functionalities/costs)
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5; // Add cost of milk
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk"; // Add description
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.2; // Add cost of sugar
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar"; // Add description
    }
}

class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0; // Add cost of whipped cream
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Whipped Cream"; // Add description
    }
}


// 5. Demo Class (Client Code)
public class DecoratorDemo {
    public static void main(String[] args) {
        // Start with a basic coffee
        Coffee myCoffee = new SimpleCoffee();
        System.out.println("Base Coffee: " + myCoffee.getDescription() + " Cost: $" + myCoffee.getCost());

        // Decorate it with Milk
        myCoffee = new MilkDecorator(myCoffee);
        System.out.println("With Milk: " + myCoffee.getDescription() + " Cost: $" + myCoffee.getCost());

        // Decorate the *already milked* coffee with Sugar
        myCoffee = new SugarDecorator(myCoffee);
        System.out.println("With Sugar: " + myCoffee.getDescription() + " Cost: $" + myCoffee.getCost());

        // Decorate that with Whipped Cream
        myCoffee = new WhippedCreamDecorator(myCoffee);
        System.out.println("With Whipped Cream: " + myCoffee.getDescription() + " Cost: $" + myCoffee.getCost());
    }
}
