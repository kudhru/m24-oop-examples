import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        // Create a LinkedHashSet
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        // Add elements to the LinkedHashSet
        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Cherry");
        linkedHashSet.add("Apple"); // Duplicate, will not be added

        // Display the LinkedHashSet (in insertion order)
        System.out.println("LinkedHashSet elements: " + linkedHashSet); // Output: [Apple, Banana, Cherry]

        // Check if LinkedHashSet contains 'Banana'
        boolean containsBanana = linkedHashSet.contains("Banana");
        System.out.println("Contains 'Banana': " + containsBanana); // Output: true

        // Remove 'Banana' from the LinkedHashSet
        linkedHashSet.remove("Banana");
        System.out.println("After removing 'Banana': " + linkedHashSet); // Output: [Apple, Cherry]

        // Check the size of the LinkedHashSet
        int size = linkedHashSet.size();
        System.out.println("Size of the LinkedHashSet: " + size); // Output: 2

        // Clear the LinkedHashSet
        linkedHashSet.clear();
        System.out.println("LinkedHashSet after clearing: " + linkedHashSet); // Output: []
    }
}
