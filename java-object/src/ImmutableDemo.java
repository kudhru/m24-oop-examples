public class ImmutableDemo {
    public static void main(String[] args) {
        int i = 2000; //Integer i = 1000;
        
        // Print the identity hash code of the initial object
        System.out.println("Initial 'i' value: " + i);
        System.out.println("Identity Hash Code of 'i': " + System.identityHashCode(i));
        
        System.out.println("--- Adding 1 ---");
        
        // The operation i + 1 creates a new Integer object behind the scenes
        i = i + 1; 
        
        // Print the new value and its hash code
        System.out.println("New 'i' value: " + i);
        System.out.println("Identity Hash Code of 'i' after addition: " + System.identityHashCode(i));
    }
}
