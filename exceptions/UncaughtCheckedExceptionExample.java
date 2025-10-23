import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.FileAlreadyExistsException;

public class UncaughtCheckedExceptionExample {
    public static void main(String[] args) throws FileNotFoundException {
        // Attempt to open a file that may not exist, without handling the exception
//        try {
//            readFile("existent_file.txt");  // FileNotFoundException may occur
//        }
//        catch (FileNotFoundException e) {
////            e.printStackTrace();
//            System.out.println("File not found in main");
//        }
        readFile("non_existent_file.txt");
//        readFile("existent_file.txt");
        System.out.println("This line gets executed because we are catching the exception");

    }

    public static void readFile(String filePath) throws NullPointerException {
        // Attempt to open the file
//        try {
//            FileReader file = new FileReader(new File(filePath));  // This line may throw FileNotFoundException
//            System.out.println("File opened successfully.");
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found.");
//        }
//        FileReader file = new FileReader(new File(filePath));  // This line may throw FileNotFoundException
        throw new NullPointerException();
        System.out.println("File opened successfully.");
//        throw new FileNotFoundException();


    }
}
