// A class with a generic constructor
class GenericConstructor {
    private double val;

    // Generic constructor
    <T extends Number> GenericConstructor(T arg) {
        val = arg.doubleValue();  // Works because T is a subclass of Number
    }

//    GenericConstructor(Double arg) {
//        val = arg.doubleValue();  // Works because T is a subclass of Number
//    }

    void showVal() {
        System.out.println("Value: " + val);
    }
}

public class GenericConstructorDemo {
    public static void main(String[] args) {
        // Create objects using different numeric types
        GenericConstructor intConstructor = new GenericConstructor(100);   // Integer passed
        GenericConstructor floatCons = new GenericConstructor(123.45F);  // Float passed

        intConstructor.showVal();  // Output: Value: 100.0
        floatCons.showVal();  // Output: Value: 123.45
    }
}
