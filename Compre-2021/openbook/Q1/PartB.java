public class PartB {
    // Shared lock object for synchronization
    private static final Object LOCK = new Object();
    
    public static void main(String[] args) {
        PartB app = new PartB();
        
        // Thread for first method calls
        Thread thread1 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    app.cal1(5);
                    app.cal1(0);  // Will cause an exception
                } catch (Exception e) {
                    System.out.println("Error in cal1: " + e.getMessage());
                }
            }
        });
        
        // Thread for second method calls
        Thread thread2 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    app.cal2(2);
                    app.cal2(0);  // Will cause an exception
                } catch (Exception e) {
                    System.out.println("Error in cal2: " + e.getMessage());
                }
            }
        });
        
        // Start threads
        thread1.start();
        thread2.start();
        
        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
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