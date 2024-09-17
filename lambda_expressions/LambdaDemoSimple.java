// Define a functional interface with a single abstract method
@FunctionalInterface
interface MyFunctionalInterface {
    void displayMessage(String message);
}

public class LambdaDemoSimple {
    public static void main(String[] args) {

        // Anonymous Inner Class
        MyFunctionalInterface messagePrinterOne = new MyFunctionalInterface() {
            @java.lang.Override
            public void displayMessage(String message) {
                System.out.println("Message inside anonymous class: " + message);
            }
        };
        messagePrinterOne.displayMessage("Hello World");

        MyFunctionalInterface messagePrinter = (message) -> System.out.println("Message: " + message);
        // Calling the method using the lambda expression
        messagePrinter.displayMessage("Hello, Lambda!");

    }
}
