// Generic superclass with a method that returns type T
class GenericClass<T> {
    public T getValue() {
        return null;
    }
}

// Non-generic subclass that extends the generic class
class StringSubclass extends GenericClass<String> {
    // Override the method to return a String
    @Override
    public String getValue() {
        return "Bridge Method Example";
    }
}

public class GenericsBridgeMethodDemo {
    public static void main(String[] args) {
        // Create an instance of StringSubclass
        GenericClass<String> obj = new StringSubclass();

        // Call the overridden method
        System.out.println("Value: " + obj.getValue());
    }
}
