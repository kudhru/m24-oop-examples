public class HandledUncheckedExceptionExample {
    public static void main(String[] args) {
        // Create an array of size 5
        int[] numbers = {1, 2, 3, 4, 5};

        try {
            // Attempt to access an invalid index
            System.out.println(numbers[10]);  // This will throw ArrayIndexOutOfBoundsException
//            System.out.println(numbers[2]);
            System.out.println("This line will not get executed.");
        } catch (ArrayIndexOutOfBoundsException exception) {
            // Handle the exception
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + exception.getMessage());
//            System.out.println(numbers[10]);
        } catch (NullPointerException exception) {
            System.out.println("Caught NullPointerException: " + exception.getMessage());
        }

        System.out.println("This line will be executed after handling the exception.");
    }
}
