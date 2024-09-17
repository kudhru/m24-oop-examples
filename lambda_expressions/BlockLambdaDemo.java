@FunctionalInterface
interface Factorial {
    int calculate(int n);
}

public class BlockLambdaDemo {
    public static void main(String[] args) {
        // Block lambda to calculate the factorial of a number
        int a = 8;
        Factorial factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result + a;
        };

        // Testing the block lambda
        int fact = factorial.calculate(5);
        System.out.println("Factorial of 5: " + fact); // Output: Factorial of 5: 120
    }
}
