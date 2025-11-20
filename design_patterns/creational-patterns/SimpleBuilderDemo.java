// Product Class
class Computer {
    private String processor;
    private String ram;
    private boolean hasGPU;
    private boolean hasBluetooth;

    public void setProcessor(String processor) { this.processor = processor; }
    public void setRam(String ram) { this.ram = ram; }
    public void setHasGPU(boolean hasGPU) { this.hasGPU = hasGPU; }
    public void setHasBluetooth(boolean hasBluetooth) { this.hasBluetooth = hasBluetooth; }

    @Override
    public String toString() {
        return "Computer Specs:\n" +
               "  Processor: " + processor + "\n" +
               "  RAM: " + ram + "\n" +
               "  GPU Installed: " + hasGPU + "\n" +
               "  Bluetooth: " + hasBluetooth;
    }
}

// Builder Interface
interface ComputerBuilder {
    void buildProcessor();
    void buildRAM();
    void buildGPU();
    void buildBluetooth();
    Computer getResult();
}

// Concrete Builder
class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i9");
    }

    @Override
    public void buildRAM() {
        computer.setRam("32GB DDR4");
    }

    @Override
    public void buildGPU() {
        computer.setHasGPU(true); // Yes, has GPU
    }

    @Override
    public void buildBluetooth() {
        computer.setHasBluetooth(false); // No Bluetooth needed
    }

    @Override
    public Computer getResult() {
        return this.computer;
    }
}

// Director (Manages the building process)
class Director {
    public void constructGamingPC(ComputerBuilder builder) {
        builder.buildProcessor();
        builder.buildRAM();
        builder.buildGPU();
        // Skip buildBluetooth() for a gaming PC
    }
}

// Demo Class
public class SimpleBuilderDemo {
    public static void main(String[] args) {
        Director director = new Director();
        GamingComputerBuilder builder = new GamingComputerBuilder();

        // Director orchestrates the build process
        director.constructGamingPC(builder);

        // Get the final product
        Computer gamingPC = builder.getResult();
        System.out.println(gamingPC);
    }
}
