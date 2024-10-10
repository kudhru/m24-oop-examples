import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class MultipleExceptionsExample {
    public static void main(String[] args) {
        try {
            // Attempt to open a file that may not exist (FileNotFoundException)
//            FileReader file = new FileReader(new File("NestedTryCatchExample.java"));
            FileReader file = new FileReader(new File("FileDoesNotExist.java"));

            // Create an array of size 5
            int[] numbers = {1, 2, 3, 4, 5};

            // Attempt to access an invalid index (ArrayIndexOutOfBoundsException)
            System.out.println(numbers[10]);

        } catch (FileNotFoundException e) {
            // Handle FileNotFoundException
            System.out.println("Caught FileNotFoundException: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle ArrayIndexOutOfBoundsException
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (Exception e) {
            // General exception handler (catches any other exception)
            System.out.println("Caught a general exception: " + e.getMessage());
        }

        System.out.println("This line will be executed after handling the exceptions.");
    }
}
