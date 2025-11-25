// Product Interface
interface Processor {
    void process();
}

// Concrete Products
class IntelProcessor implements Processor {
    @Override
    public void process() {
        System.out.println("Creating Intel Processor: Core i9");
    }
}

class AMDProcessor implements Processor {
    @Override
    public void process() {
        System.out.println("Creating AMD Processor: Ryzen 9");
    }
}

// Abstract Creator Class
abstract class ProcessorFactory {
    // The Factory Method
    public abstract Processor createProcessor();

    public void assembleComputer() {
        // Factory Method is called within other operations
        Processor processor = createProcessor();
        processor.process();
        System.out.println("Computer assembled with a new processor.");
    }
}

// Concrete Creators (Subclasses decide which concrete product to instantiate)
class IntelFactory extends ProcessorFactory {
    @Override
    public Processor createProcessor() {
        return new IntelProcessor();
    }
}

class AMDFactory extends ProcessorFactory {
    @Override
    public Processor createProcessor() {
        return new AMDProcessor();
    }
}

// Demo Class
public class FactoryMethodDemo {
    public static void main(String[] args) {
        ProcessorFactory factory1 = new IntelFactory();
        factory1.assembleComputer();

        System.out.println();

        ProcessorFactory factory2 = new AMDFactory();
        factory2.assembleComputer();
    }
}
