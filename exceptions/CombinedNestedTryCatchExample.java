public class CombinedNestedTryCatchExample {
    public static void main(String[] args) {
        try {
            // Outer try block
            System.out.println("Outer try block starts.");

            // First inner try-catch block (Scenario 1: Inner block handles the exception)
            try {
                System.out.println("First inner try block starts.");

                // Create an array of size 5
                int[] numbers = {1, 2, 3, 4, 5};

                // Attempt to access an invalid index (ArrayIndexOutOfBoundsException)
                System.out.println(numbers[10]);  // This will throw ArrayIndexOutOfBoundsException

            } catch (ArrayIndexOutOfBoundsException e) {
                // Inner catch block handles ArrayIndexOutOfBoundsException
                System.out.println("Caught ArrayIndexOutOfBoundsException in first inner catch block: " + e.getMessage());
            }

            // Second inner try-catch block (Scenario 2: Inner block does not handle the exception)
            try {
                System.out.println("Second inner try block starts.");

                // Attempting a null reference operation (NullPointerException)
                String str = null;
                System.out.println(str.length());  // This will throw NullPointerException

            } catch (ArrayIndexOutOfBoundsException e) {
                // This block cannot handle NullPointerException, so it will propagate to the outer catch
                System.out.println("Caught ArrayIndexOutOfBoundsException in second inner catch block: " + e.getMessage());
            }

            // Code after both inner try-catch blocks
            System.out.println("Code after both inner try-catch blocks.");

        } catch (NullPointerException e) {
            // Outer catch block handles NullPointerException from the second inner try block
            System.out.println("Caught NullPointerException in outer catch block: " + e.getMessage());
        } catch (Exception e) {
            // General catch block to handle any other exception
            System.out.println("Caught a general exception in outer catch block: " + e.getMessage());
        }

        System.out.println("Program continues after handling all exceptions.");
    }
}
