import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        // Create a LinkedList of Strings
        LinkedList<String> linkedList = new LinkedList<>();

        // Add elements to the LinkedList
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");
        linkedList.add("Banana");
        System.out.println(linkedList.size());

        // Display the LinkedList
        System.out.println("Initial LinkedList: " + linkedList); // Output: [Apple, Banana, Cherry]

        // Add elements at the first and last positions
        linkedList.addFirst("First");
        linkedList.addLast("Last");
        System.out.println("After adding First and Last: " + linkedList); // Output: [First, Apple, Banana, Cherry, Last]

        // Remove the first and last elements
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("After removing First and Last: " + linkedList); // Output: [Apple, Banana, Cherry]

        // Get the element at index 1
        String elementAt1 = linkedList.get(1);
        System.out.println("Element at index 1: " + elementAt1); // Output: Banana

        // Set a new value at index 2
        linkedList.set(2, "Blueberry");
        System.out.println("After setting index 2 to 'Blueberry': " + linkedList); // Output: [Apple, Banana, Blueberry]
    }
}
