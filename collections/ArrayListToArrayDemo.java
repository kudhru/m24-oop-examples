import java.util.ArrayList;

public class ArrayListToArrayDemo {
    public static void main(String[] args) {
        // Create an ArrayList of integers
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Add elements to the ArrayList
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);

        // Display the ArrayList
        System.out.println("ArrayList: " + arrayList); // Output: [10, 20, 30, 40]

        // Convert ArrayList to an array using toArray(T[] array)
        Integer[] intArray = arrayList.toArray(new Integer[0]);

        // Display the array elements
        System.out.print("Array: ");
        for (int element : intArray) {
            System.out.print(element + " "); // Output: 10 20 30 40
        }

        System.out.println();

        // Modify and work with the array as needed
        int sum = 0;
        for (int num : intArray) {
            sum += num;
        }
        System.out.println("Sum of array elements: " + sum); // Output: Sum of array elements: 100
    }
}
