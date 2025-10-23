import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadLinesWithScanner {
    public static void main(String[] args) throws Exception {
        int lineNo = 1;
//        try (Scanner sc = new Scanner(new File("notes.txt"))) {
        try (Scanner sc = new Scanner(new FileInputStream("notes.txt"))) {
            while (sc.hasNextLine()) {             // check next line exists
                String line = sc.nextLine();       // read whole line
                System.out.printf("%02d | %s%n", lineNo++, line);
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("ArrayIndexOutOfBoundsException inside just try");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found inside just try");
        }
//        try {
//            Scanner sc = new Scanner(new FileInputStream("notes.txt"));
//            while (sc.hasNextLine()) {             // check next line exists
//                String line = sc.nextLine();       // read whole line
//                System.out.printf("%02d | %s%n", lineNo++, line);
//            }
//        }
//        catch (FileNotFoundException e) {
//            System.out.println("File not found inside try-catch");
//            e.printStackTrace();
//
//        }
    }
}
