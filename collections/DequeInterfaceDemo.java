import java.util.Deque;
import java.util.LinkedList;

public class DequeInterfaceDemo {
    public static void main(String[] args) {
        // Create a Deque using LinkedList (which implements Deque)
        Deque<String> deque = new LinkedList<>();

        // Add elements at both ends
        deque.addFirst("Front");
        deque.addLast("Back");

        // Display the Deque
        System.out.println("Deque after adding elements: " + deque); // Output: [Front, Back]

        // Add more elements
        deque.addFirst("New Front");
        deque.addLast("New Back");
        System.out.println("Deque after adding more elements: " + deque); // Output: [New Front, Front, Back, New Back]

        // Peek at the first and last elements
        System.out.println("First element (peekFirst): " + deque.peekFirst()); // Output: New Front
        System.out.println("Last element (peekLast): " + deque.peekLast()); // Output: New Back

        // Remove elements from both ends
        deque.removeFirst();
        deque.removeLast();
        System.out.println("Deque after removing first and last: " + deque); // Output: [Front, Back]
    }
}
