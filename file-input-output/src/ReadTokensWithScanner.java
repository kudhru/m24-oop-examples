import java.io.File;
import java.util.Scanner;

public class ReadTokensWithScanner {
    public static void main(String[] args) throws Exception {
        int sum = 0;
        try (Scanner sc = new Scanner(new File("numbers.txt"))) {
//            sc.useDelimiter("\n");
            while (sc.hasNext()) {                 // any next token?
                if (sc.hasNextInt()) {             // safe to read an int?
                    sum += sc.nextInt();           // consume the int
                } else {
                    System.out.println("Skipping: " + sc.next()); // consume non-int
                }
            }
        }
        System.out.println("Sum = " + sum);
    }
}
