import java.util.ArrayList;
import java.util.List;

public class ListInterfaceDemo {
    public static void main(String[] args) {
        // Create a list using ArrayList (which implements the List interface)
        List<String> list = new ArrayList<>();

        // Add elements to the list
        list.add("A");
        list.add("B");
        list.add("C");
        list.add(1, "D"); // Insert 'D' at index 1
        list.add("B"); // Insert 'D' at index 1

        // Display the list elements
        System.out.println("List elements: " + list); // Output: [A, D, B, C]

        // Get element at index 2
        String elementAt2 = list.get(2);
        System.out.println("Element at index 2: " + elementAt2); // Output: B

        // Remove element at index 3
        list.remove(3);
        System.out.println("List after removing element at index 3: " + list); // Output: [A, D, B]

        // Find the index of element 'D'
        int indexOfD = list.indexOf("D");
        System.out.println("Index of 'D': " + indexOfD); // Output: 1

        // Create a sublist from index 0 to 2 (exclusive)
        List<String> subList = list.subList(0, 2);
        System.out.println("Sublist from index 0 to 2: " + subList); // Output: [A, D]
    }
}
