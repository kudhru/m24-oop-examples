// A generic interface with no bounds on the type parameter
interface Container<T> {
    void set(T item);  // Set an item of type T
    T get();           // Get an item of type T
}
// A class that implements the generic interface
class Box<T> implements Container<T> {
    private T item;

    // Implement the set method
    public void set(T item) {
        this.item = item;
    }

    // Implement the get method
    public T get() {
        return item;
    }
}

class BoxNonGeneric implements Container<Integer> {
    private Integer item;

    // Implement the set method
    public void set(Integer item) {
        this.item = item;
    }

    // Implement the get method
    public Integer get() {
        return item;
    }
}

public class SimpleGenericInterfaceDemo {
    public static void main(String[] args) {
        // Create a Box object for Integers
//        Box<Integer> intBox = new Box<>();
//        intBox.set(123);  // Set an Integer value
//        System.out.println("Integer Value: " + intBox.get());  // Output: 123
//
//        Container<Integer> intBox1 = new Box<>();
//        intBox1.set(123);  // Set an Integer value
//        System.out.println("Integer Value: " + intBox1.get());  // Output: 123
//
//        // Create a Box object for Strings
//        Box<String> strBox = new Box<>();
//        strBox.set("Hello Generics");  // Set a String value
//        System.out.println("String Value: " + strBox.get());  // Output: Hello Generics
        BoxNonGeneric boxNonGeneric = new BoxNonGeneric();
        boxNonGeneric.set(1);
        System.out.println(boxNonGeneric.get());
    }
}
