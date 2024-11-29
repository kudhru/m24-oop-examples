package File_io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIOCSVDemo {

    public static void main(String[] args) {
        // Writing to CSV
        try (PrintWriter writer = new PrintWriter(new FileOutputStream("File_io/users.csv"))) {
            writer.println("ID,Name,Email,Age");        //Creating headers
            writer.println("1,John Doe,john@example.com,30");       //Adding Values
            writer.println("2,Jane Smith,jane@example.com,25");     
            writer.println("3,Bob Johnson,bob@example.com,45");
        } catch (FileNotFoundException e) {
            System.err.println("Error writing to CSV: " + e.getMessage());
        }

        // Reading from CSV
        List<String[]> csvData = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("File_io/users.csv"))) {
            // Skip header
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                csvData.add(values);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading CSV: " + e.getMessage());
        }

        // Printing CSV data
        System.out.println("Users from CSV:");
        for (String[] user : csvData) {
            System.out.println("ID: " + user[0] + 
                               ", Name: " + user[1] + 
                               ", Email: " + user[2] + 
                               ", Age: " + user[3]);
        }
    }
}