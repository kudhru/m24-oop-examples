import java.io.*;

public class PrintWriterAppendWithFileWriter {
    public static void main(String[] args) throws Exception {
//        try (PrintWriter out = new PrintWriter(new FileWriter("notes.txt", true))) {
//            out.println("Appended line");
//        }
        try {
            FileWriter fw = new FileWriter("notes.txt", true);
            PrintWriter out = new PrintWriter(fw);
            out.println("Appended line");
            out.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
