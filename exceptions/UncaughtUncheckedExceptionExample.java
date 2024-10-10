public class UncaughtUncheckedExceptionExample {
    public static void main(String[] args) {
        // Create an array of size 5
        int[] numbers = {1, 2, 3, 4, 5};

        // Attempt to access an invalid index (causes ArrayIndexOutOfBoundsException)
        System.out.println("This line will be printed as it is before the exception.");
        System.out.println(numbers[10]);  // This will throw ArrayIndexOutOfBoundsException
        System.out.println("This line will not be executed due to the exception.");
    }
}
