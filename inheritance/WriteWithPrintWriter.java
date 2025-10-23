import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteWithPrintWriter {
    public static void main(String[] args) {
//        try (PrintWriter out = new PrintWriter(new FileWriter("students.txt"))) {
        try {
//            FileWriter fileWriter = new FileWriter("students_1.txt");
//            PrintWriter out = new PrintWriter(fileWriter);

            FileOutputStream fileOutputStream = new FileOutputStream("students.txt");
            PrintWriter out = new PrintWriter(fileOutputStream);
            out.println("Alice,93");
            out.println("Bob,88");
            out.printf("Carol,%d%n", 95);
//            fileWriter.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Wrote students.txt (overwrite).");
    }
}
