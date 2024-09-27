import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        // Create an ArrayDeque
        Deque<String> arrayDeque = new ArrayDeque<>();

        // Add elements to both ends of the ArrayDeque
        arrayDeque.addFirst("Front");
        arrayDeque.addLast("Back");

        // Display the ArrayDeque
        System.out.println("ArrayDeque: " + arrayDeque); // Output: [Front, Back]

        // Add more elements
        arrayDeque.push("Stack Top"); // Pushes to the front (as in stack)
        System.out.println("After push: " + arrayDeque); // Output: [Stack Top, Front, Back]

        // Peek at the first and last elements
        System.out.println("First element (peekFirst): " + arrayDeque.peekFirst()); // Output: Stack Top
        System.out.println("Last element (peekLast): " + arrayDeque.peekLast()); // Output: Back

        // Pop an element from the deque (LIFO operation)
        String popped = arrayDeque.pop(); // Pops from the front
        System.out.println("Popped element: " + popped); // Output: Stack Top
        System.out.println("ArrayDeque after pop: " + arrayDeque); // Output: [Front, Back]

        // Remove the last element
        arrayDeque.removeLast();
        System.out.println("ArrayDeque after removing last element: " + arrayDeque); // Output: [Front]
    }
}
