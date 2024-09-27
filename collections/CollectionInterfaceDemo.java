import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionInterfaceDemo {
    public static void main(String[] args) {
        // Create a collection using ArrayList (which implements Collection interface)
        Collection<String> collection = new ArrayList<>();

        // Add elements to the collection
        collection.add("A");
//        collection.add(10);
        collection.add("B");
        collection.add("C");

        // Display the size of the collection
        System.out.println("Initial size of collection: " + collection.size()); // Output: 3

        // Remove an element from the collection
        collection.remove("B");
        System.out.println("Size after removal: " + collection.size()); // Output: 2

        // Check if an element is present in the collection
        System.out.println("Contains 'A': " + collection.contains("A")); // Output: true

        // Use an iterator to traverse through the collection
        Iterator<String> iterator = collection.iterator();
        System.out.print("Collection elements: ");
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.print(element + " "); // Output: A C
        }
//        System.out.println(iterator.next());

        // Clear the collection
        collection.clear();
        System.out.println("\nCollection is empty: " + collection.isEmpty()); // Output: true
    }
}
