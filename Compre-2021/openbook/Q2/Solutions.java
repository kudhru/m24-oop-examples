// QUESTION

/* Write a JAVA program that accepts either Integer or Float data
 * (and Nothin else) and prints the greater of these two.
 * Your program should be complete in all respects 
 * and use Generics correctly
 */

import java.util.Scanner;

public class Solutions<T extends Number & Comparable<T>> {

    private T num1;
    private T num2;

    // Constructor to initialize two numbers
    public Solutions(T num1, T num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // Method to find the greater number
    public T findGreater() {
        return (num1.compareTo(num2) >= 0) ? num1 : num2;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        try {

            // Prompt for first number
            System.out.print("Enter first number (Integer or Float): ");
            String input1 = scanner.nextLine().trim();
            
            // Prompt for second number
            System.out.print("Enter second number (Integer or Float): ");
            String input2 = scanner.nextLine().trim();
            
            // Determine and create appropriate generic comparator
            if (isInteger(input1) && isInteger(input2)) {

                Integer val1 = Integer.parseInt(input1);
                Integer val2 = Integer.parseInt(input2);
                
                Solutions<Integer> comparator = new Solutions<>(val1, val2);
                System.out.println("Greater number: " + comparator.findGreater());

            } 
            
            else if (isFloat(input1) && isFloat(input2)) {

                Float val1 = Float.parseFloat(input1);
                Float val2 = Float.parseFloat(input2);

                Solutions<Float> comparator = new Solutions<>(val1, val2);
                System.out.println("Greater number: " + comparator.findGreater());

            } else {

                throw new IllegalArgumentException("Please enter only Integer or Float values.");
            }
            
        } catch (NumberFormatException e) {

            System.out.println("Error: Invalid number format. Please enter only Integer or Float values.");

        } 
        catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        } 
        
        finally {
            scanner.close();
        }
    }
    
    // Helper method to check if input is a valid Integer
    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    // Helper method to check if input is a valid Float
    private static boolean isFloat(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}