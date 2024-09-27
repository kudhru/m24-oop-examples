import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // Create a PriorityQueue of integers
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements to the PriorityQueue
        pq.offer(30);
        pq.offer(20);
        pq.offer(10);
        pq.offer(40);

        // Display the PriorityQueue (ordered based on natural ordering)
        System.out.println("PriorityQueue elements: " + pq); // Output might be: [10, 20, 30, 40]

        // Retrieve and remove the head element (smallest element)
        int head = pq.poll();
        System.out.println("Polled element (head): " + head); // Output: 10

        // Peek at the next head element without removing
        int nextHead = pq.peek();
        System.out.println("Next head element (peek): " + nextHead); // Output: 20

        // Display the remaining elements in the PriorityQueue
        System.out.println("Remaining PriorityQueue elements: " + pq); // Output might be: [20, 40, 30]
    }
}
