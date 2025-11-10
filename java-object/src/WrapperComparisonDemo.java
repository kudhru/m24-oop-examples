public class WrapperComparisonDemo {
    public static void main(String[] args) {
        // --- Case 1: Values outside the JVM cache range (e.g., 200) ---
        // Autoboxing creates two *different* objects in memory.
        Integer num1 = 200; 
        Integer num2 = 200;
        
        System.out.println("--- Values 200 ---");
        System.out.println("num1 identity hash code: " + System.identityHashCode(num1));
        System.out.println("num2 identity hash code: " + System.identityHashCode(num2));
        System.out.println("Are they the same object (==)? " + (num1 == num2)); // Checks identity
        System.out.println("Do they have equal contents (.equals())? " + (num1.equals(num2))); // Checks content

        // --- Case 2: Values inside the JVM cache range (e.g., 50) ---
        // Autoboxing reuses the *same* cached object for efficiency.
        Integer num3 = 50;
        Integer num4 = 50;

        System.out.println("\n--- Values 50 (Cached) ---");
        System.out.println("Are they the same object (==)? " + (num3 == num4)); // Checks identity
        System.out.println("Do they have equal contents (.equals())? " + (num3.equals(num4))); // Checks content
        
        // --- Case 3: Explicitly creating new objects using 'new' ---
        // This forces new objects to be created, regardless of the value.
        //Integer num5 = new Integer(10);
        //Integer num6 = new Integer(10);
        int num5 = 10;
        int num6 = 10;
        
        System.out.println("\n--- Values 10 (Using new Integer()) ---");
        System.out.println("Are they the same object (==)? " + (num5 == num6)); // Checks identity
        //System.out.println("Do they have equal contents (.equals())? " + (num5.equals(num6))); // Checks content
    }
}