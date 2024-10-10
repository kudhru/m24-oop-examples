import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class FixedCheckedExceptionExample {
    public static void main(String[] args) {
        // Attempt to open a file that may not exist
        readFile("non_existent_file.txt");  // Now exception is handled properly
        System.out.println("This line will be executed after the exception is handled.");
    }

    public static void readFile(String filePath) {
        try {
            // Attempt to open the file
            FileReader file = new FileReader(new File(filePath));  // This may throw FileNotFoundException
            System.out.println("File opened successfully.");
        } catch (FileNotFoundException e) {
            // Handle the exception if the file is not found
            System.out.println("Caught FileNotFoundException: " + e.getMessage());
        }
        System.out.println("End of Method readFile");
    }
}
