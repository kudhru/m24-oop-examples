// A generic class where T is bounded by Number
class Gen<T extends Number> {
    // Declare a variable of type T
    T ob;
    // Constructor that accepts a reference of type T
    Gen(T o) {
        ob = o;
    }
    // Return the value of ob as a double
    double getDoubleValue() {
        return ob.doubleValue(); // T is known to be a subclass of Number, so doubleValue() is available
    }
    // Show type of T
    void showType() {
        System.out.println("Type of T is: " + ob.getClass().getName());
    }
}
class Gen {
    Number ob; // T is erased to Number
    Gen(Number o) {
        ob = o;
    }
    double getDoubleValue() {
        return ob.doubleValue(); // Safe because ob is guaranteed to be a Number
    }
    void showType() {
        System.out.println("Type of T is: " + ob.getClass().getName());
    }
}


public class GenericsErasureBoundedDemo {
    public static void main(String[] args) {
        // Create a Gen object for Integer
        Gen<Integer> intOb = new Gen<>(100);

        // Display type and double value for intOb
        intOb.showType();
        System.out.println("Double value: " + intOb.getDoubleValue());

        System.out.println();

        // Create a Gen object for Double
        Gen<Double> doubleOb = new Gen<>(123.45);

        // Display type and double value for doubleOb
        doubleOb.showType();
        System.out.println("Double value: " + doubleOb.getDoubleValue());
    }
}