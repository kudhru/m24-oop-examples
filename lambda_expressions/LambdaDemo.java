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
        MyFunctionalInterface messagePrinter = (message) -> System.out.println("Message: " + message);
        // Calling the method using the lambda expression
        messagePrinter.displayMessage("Hello, Lambda!");

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
