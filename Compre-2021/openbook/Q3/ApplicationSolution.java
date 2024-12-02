public class ApplicationSolution {
    public static void main(String[] args) {
        ApplicationSolution app = new ApplicationSolution();
        
        try {
            // Call methods with potential exceptions
            app.cal1(5);
            app.cal1(0);  // Will cause an exception
        } 
        catch (Exception e) {
            System.out.println("Error in cal1: " + e.getMessage());
        }
        


        try {
            // Call methods with potential exceptions
            app.cal2(2);
            app.cal2(0);  // Will cause an exception
        } 
        catch (Exception e) {
            System.out.println("Error in cal2: " + e.getMessage());
        }
    }

    public int cal1(int num) {
        try {

            // Prevent division by zero
            if (num == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            // Original calculation with potential division by zero
            return num / num;

        } 
        catch (ArithmeticException e) {

            System.out.println("Arithmetic error in cal1: " + e.getMessage());
            return 0;
        }
    }

    public int cal2(int num) {
        try {

            // Prevent division by zero
            if (num == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            
            // Create array and perform calculation
            int[] a = new int[num];
            a[5] = 30 / num;
            return a[5];

        } 
        
        catch (ArithmeticException e) {
            System.out.println("Arithmetic error in cal2: " + e.getMessage());
            return 0;
        } 
        
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error in cal2: Cannot access array index");
            return 0;
        }
    }
}