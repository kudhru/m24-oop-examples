// Example 2: Lambda with multiple parameters
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class LambdaDemo {
    public static void main(String[] args) {

        MathOperation additionOne = new MathOperation() {
            @java.lang.Override
            public int operate(int a, int b) {
                return a + b;
            }
        }
        int sumOne = additionOne.operate(10,20);
        System.out.println(sumOne);

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
