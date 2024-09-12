@FunctionalInterface
interface StringOperation {
    String operate(String s);
}

public class LambdaArgumentDemo {

    // Method that accepts a functional interface as a parameter
    public static void printFormatted(String s, StringOperation operation) {
        String result = operation.operate(s);
        System.out.println(result);
    }

    public static void main(String[] args) {
        // Passing a lambda expression as an argument
        printFormatted("hello", (str) -> str.toUpperCase()); // Output: HELLO

        // Another lambda for reversing the string
        printFormatted("world", (str) -> new StringBuilder(str).reverse().toString()); // Output: dlrow
    }
}
