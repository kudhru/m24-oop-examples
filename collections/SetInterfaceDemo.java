import java.util.HashSet;
import java.util.Set;

public class SetInterfaceDemo {
    public static void main(String[] args) {
        // Create a HashSet (which implements the Set interface)
        Set<String> set = new HashSet<>();

        // Add elements to the set
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple"); // Duplicate, will not be added

        // Display the set elements
        System.out.println("Set elements: " + set); // Output: [Apple, Banana, Cherry]

        // Check if the set contains 'Banana'
        boolean containsBanana = set.contains("Banana");
        System.out.println("Set contains 'Banana': " + containsBanana); // Output: true

        // Remove an element from the set
        set.remove("Banana");
        System.out.println("After removing 'Banana': " + set); // Output: [Apple, Cherry]

        // Get the size of the set
        int size = set.size();
        System.out.println("Size of the set: " + size); // Output: 2

        // Clear the set
        set.clear();
        System.out.println("Set after clear(): " + set); // Output: []
    }
}
