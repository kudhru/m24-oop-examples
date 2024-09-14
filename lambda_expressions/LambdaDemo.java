// Define a functional interface with a single abstract method
@FunctionalInterface
interface MyFunctionalInterface {
    void displayMessage(String message);
}
// Example 2: Lambda with multiple parameters
// This functional interface doesn't exist, but let's create it for demonstration
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}
public class LambdaDemo {
    public static void main(String[] args) {
        // Example 1: Basic Lambda Expression with a Functional Interface
        MyFunctionalInterface messagePrinterOne = new MyFunctionalInterface() {
            @java.lang.Override
            public void displayMessage(String message) {
                System.out.println("Message inside anonymous class: " + message);
            }
        }
        messagePrinterOne.displayMessage("Hello World");

        MyFunctionalInterface messagePrinter = (message) -> System.out.println("Message: " + message);
        // Calling the method using the lambda expression
        messagePrinter.displayMessage("Hello, Lambda!");

        MathOperation additionOne = new MathOperation() {
            @java.lang.Override
            public int operate(int a, int b) {
//                return a + b;
                return a * b;
            }
        }
        // Lambda expression implementing MathOperation (addition)
        MathOperation addition = (a, b) -> a + b;
        // Lambda expression implementing MathOperation (multiplication)
        MathOperation multiplication = (a, b) -> a * b;

        // Using the lambda expressions
        int sum = addition.operate(5, 3);
        int product = multiplication.operate(5, 3);

        // Displaying results
        System.out.println("Sum: " + sum); // Output: Sum: 8
        System.out.println("Product: " + product); // Output: Product: 15
    }
}
