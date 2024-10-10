@FunctionalInterface
interface StringOperation {
    void perform(String str);
//    void display(String str);
}

// create a class here for implementing the above interface

public class StaticMethodReferenceDemo {

    // Static method to be referenced
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {

        StaticMethodReferenceDemo.printMessage("Hello World");
        // Anonymous Inner class
        StringOperation operation3 = new StringOperation() {
            @java.lang.Override
            public void perform(String message) {
                StaticMethodReferenceDemo.printMessage(message);
            }

//            @java.lang.Override
//            public void display(String message) {
//                StaticMethodReferenceDemo.printMessage(message);
//            }
        };
        operation3.perform("Anonymous Inner Class");

        // Using method reference for a static method
        StringOperation operation1 = (message) -> StaticMethodReferenceDemo.printMessage(message);
        operation1.perform("Hello, Normal Lambda Expression!"); // Output: Hello, Method References!

        StringOperation operation2 = StaticMethodReferenceDemo::printMessage;
        StringOperation operation4 = this::printMessage;
        // Calling the method via the functional interface
        operation2.perform("Hello, Static Method References!"); // Output: Hello, Method References!
    }
}
