interface MathOperations {
    // Static method in interface
    static int add(int a, int b) {
        return a + b;
    }

    // Abstract method
    void multiply(int a, int b);
}

class Calculator implements MathOperations {
    public void multiply(int a, int b) {
        System.out.println("Multiplication: " + (a * b));
    }
    static int add(int a, int b) {
        return a + b;
    }
}

public class StaticMethodDemo {
    public static void main(String[] args) {
        // Calling static method from the interface
        int sum = MathOperations.add(5, 10);
        System.out.println("Sum: " + sum);

        // Using the implemented method
        Calculator calc = new Calculator();
        calc.multiply(5, 10);
        Calculator.add(5,10);
    }
}