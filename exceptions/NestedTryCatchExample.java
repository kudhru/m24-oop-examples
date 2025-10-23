public class NestedTryCatchExample {
    public static void main(String[] args) {
        try {
            // Outer try block
            System.out.println("Outer try block starts.");

            try {
                // Inner try block
                System.out.println("Inner try block starts.");

                // Create an array of size 5
                int[] numbers = {1, 2, 3, 4, 5};

                // Attempt to access an invalid index (ArrayIndexOutOfBoundsException)
                System.out.println(numbers[10]);  // This will throw ArrayIndexOutOfBoundsException

            }
//            catch (NullPointerException e) {
//                // Inner catch block handles NullPointerException only
//                System.out.println("Caught NullPointerException in inner catch block: " + e.getMessage());
//            }

            // More code here, but the inner block will throw an exception before reaching this point

        } catch (ArrayIndexOutOfBoundsException e) {
            // Outer catch block handles ArrayIndexOutOfBoundsException
            System.out.println("Caught ArrayIndexOutOfBoundsException in outer catch block: " + e.getMessage());
        } catch (Exception e) {
            // General catch block to handle any other exception
            System.out.println("Caught a general exception in outer catch block: " + e.getMessage());
        }

        System.out.println("Program continues after handling exceptions.");
    }
}
