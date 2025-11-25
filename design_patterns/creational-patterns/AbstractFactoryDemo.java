// Abstract Products (Interfaces for a family of components)
interface Processor1 {
    void process();
}

interface Motherboard {
    void attachProcessor(Processor1 processor);
}

// Concrete Products for Intel Family
class IntelProcessor1 implements Processor1 {
    @Override
    public void process() {
        System.out.println("Intel Processor: Core i9");
    }
}

class IntelMotherboard implements Motherboard {
    @Override
    public void attachProcessor(Processor1 processor) {
        System.out.print("Intel Motherboard: Attaching ");
        processor.process();
    }
}

// Concrete Products for AMD Family
class AMDProcessor1 implements Processor1 {
    @Override
    public void process() {
        System.out.println("AMD Processor: Ryzen 9");
    }
}

class AMDMotherboard implements Motherboard {
    @Override
    public void attachProcessor(Processor1 processor) {
        System.out.print("AMD Motherboard: Attaching ");
        processor.process();
    }
}

// Abstract Factory (Interface grouping creation methods)
interface ComputerPartsFactory {
    Processor1 createProcessor();
    Motherboard createMotherboard();
}

// Concrete Factories (Implement the abstract factory interface)
class IntelPartsFactory implements ComputerPartsFactory {
    @Override
    public Processor1 createProcessor() {
        return new IntelProcessor1();
    }

    @Override
    public Motherboard createMotherboard() {
        return new IntelMotherboard();
    }
}

class AMDPartsFactory implements ComputerPartsFactory {
    @Override
    public Processor1 createProcessor() {
        return new AMDProcessor1();
    }

    @Override
    public Motherboard createMotherboard() {
        return new AMDMotherboard();
    }
}

// Client Class: Uses the factory interface to build a system
class ComputerAssembler {
    public void assembleSystem(ComputerPartsFactory factory) {
        Processor1 processor = factory.createProcessor();
        Motherboard motherboard = factory.createMotherboard();

        System.out.println("Assembling system:");
        processor.process();
        motherboard.attachProcessor(processor);
        System.out.println("System build complete and compatible.");
    }
}

// Demo Class
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        ComputerAssembler assembler = new ComputerAssembler();

        System.out.println("--- Building Intel System ---");
        ComputerPartsFactory intelFactory = new IntelPartsFactory();
        assembler.assembleSystem(intelFactory);

        System.out.println("\n--- Building AMD System ---");
        ComputerPartsFactory amdFactory = new AMDPartsFactory();
        assembler.assembleSystem(amdFactory);
    }
}
