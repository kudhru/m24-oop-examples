// A class with a generic constructor
class GenCons {
    private double val;

    // Generic constructor
    <T extends Number> GenCons(T arg) {
        val = arg.doubleValue();  // Works because T is a subclass of Number
    }

    void showVal() {
        System.out.println("Value: " + val);
    }
}

public class GenericConstructorDemo {
    public static void main(String[] args) {
        // Create objects using different numeric types
        GenCons intCons = new GenCons(100);   // Integer passed
        GenCons floatCons = new GenCons(123.45F);  // Float passed

        intCons.showVal();  // Output: Value: 100.0
        floatCons.showVal();  // Output: Value: 123.45
    }
}
