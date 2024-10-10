import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class FixedCheckedExceptionWithThrowsExample {
    public static void main(String[] args) {
        try {
            // Call the method that throws the exception
            readFile("non_existent_file.txt");
        } catch (FileNotFoundException e) {
            // Handle the exception in the main method
            System.out.println("Caught FileNotFoundException in main: " + e.getMessage());
        }
        System.out.println("This line will be executed after the exception is handled.");
    }

    // Method declares it may throw FileNotFoundException
    public static void readFile(String filePath) throws FileNotFoundException {
        FileReader file = new FileReader(new File(filePath));  // This may throw FileNotFoundException
        System.out.println("File opened successfully.");
    }
}
