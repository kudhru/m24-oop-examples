public class PartA {
    public static void main(String[] args) {
        PartA app = new PartA();
        
        // Thread for cal1(5)
        Thread thread1 = new Thread(() -> {
            try {
                int result = app.cal1(5);
                System.out.println("cal1(5) result: " + result);
            } catch (Exception e) {
                System.out.println("Error in cal1(5): " + e.getMessage());
            }
        });
        
        // Thread for cal1(0)
        Thread thread2 = new Thread(() -> {
            try {
                int result = app.cal1(0);
                System.out.println("cal1(0) result: " + result);
            } catch (Exception e) {
                System.out.println("Error in cal1(0): " + e.getMessage());
            }
        });
        
        // Thread for cal2(2)
        Thread thread3 = new Thread(() -> {
            try {
                int result = app.cal2(2);
                System.out.println("cal2(2) result: " + result);
            } catch (Exception e) {
                System.out.println("Error in cal2(2): " + e.getMessage());
            }
        });
        
        // Thread for cal2(0)
        Thread thread4 = new Thread(() -> {
            try {
                int result = app.cal2(0);
                System.out.println("cal2(0) result: " + result);
            } catch (Exception e) {
                System.out.println("Error in cal2(0): " + e.getMessage());
            }
        });
        
        // Start all threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
    
    public int cal1(int num) {
        try {
            // Prevent division by zero
            if (num == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            
            // Original calculation with potential division by zero
            return num / num;
        } catch (ArithmeticException e) {
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
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error in cal2: " + e.getMessage());
            return 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error in cal2: Cannot access array index");
            return 0;
        }
    }
}