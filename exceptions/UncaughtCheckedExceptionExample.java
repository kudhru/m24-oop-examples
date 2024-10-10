import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class UncaughtCheckedExceptionExample {
    public static void main(String[] args) {
        // Attempt to open a file that may not exist, without handling the exception
        try {
            readFile("non_existent_file.txt");  // FileNotFoundException may occur
        }
        catch (FileNotFoundException e) {
//            e.printStackTrace();
        }

        System.out.println("This line gets executed because we are catching the exception");

    }

    public static void readFile(String filePath) throws FileNotFoundException {
        // Attempt to open the file
        FileReader file = new FileReader(new File(filePath));  // This line may throw FileNotFoundException
        System.out.println("File opened successfully.");
    }
}
