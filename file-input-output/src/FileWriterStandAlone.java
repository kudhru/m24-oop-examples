import java.io.FileWriter;
import java.io.IOException;

public class FileWriterStandAlone {
    public static void main(String[] args) {
        // Overwrite
        try (FileWriter fw = new FileWriter("students.txt")) {
            fw.write("# Students\n");
            fw.write("Alice,93\n");
            fw.write("Bob,88\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Append
        try (FileWriter fw = new FileWriter("students.txt", true)) {
            fw.write("Carol,95\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Wrote students.txt with FileWriter.");
    }
}
