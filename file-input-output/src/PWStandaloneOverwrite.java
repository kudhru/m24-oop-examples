import java.io.PrintWriter;

public class PWStandaloneOverwrite {
    public static void main(String[] args) throws Exception {
//        try (PrintWriter out = new PrintWriter("notes.txt")) { // overwrites
        try { // overwrites
            PrintWriter out = new PrintWriter("notes.txt");
//            out.println("# Notes");
//            out.println("Hello from PrintWriter!");
//            out.printf("%d\n", 5);
            out.append("Appended Text");
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}