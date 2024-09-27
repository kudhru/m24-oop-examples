import java.util.LinkedList;
import java.util.Queue;

public class QueueInterfaceDemo {
    public static void main(String[] args) {
        // Create a Queue using LinkedList (which implements the Queue interface)
        Queue<String> queue = new LinkedList<>();

        // Add elements to the queue
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");

        // Display the elements in the queue
        System.out.println("Initial Queue: " + queue); // Output: [First, Second, Third]

        // Peek at the head of the queue
        String head = queue.peek();
        System.out.println("Head of the queue (peek): " + head); // Output: First

        // Poll (retrieve and remove) the head of the queue
        String removedElement = queue.poll();
        System.out.println("Removed Element (poll): " + removedElement); // Output: First

        // Display the queue after poll
        System.out.println("Queue after poll: " + queue); // Output: [Second, Third]

        // Remove another element using remove()
        queue.remove();
        System.out.println("Queue after remove(): " + queue); // Output: [Third]
    }
}
