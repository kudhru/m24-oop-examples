import java.util.ArrayList;
import java.util.List;

class MutableData {
    public List<String> items;

    public MutableData(List<String> items) {
        this.items = items;
    }

    // A method to simulate shallow cloning via copy constructor
    public MutableData shallowClone() {
        // Only the top-level object is new; the 'items' list is shared by reference
        return new MutableData(this.items);
    }

    // A method to simulate deep cloning
    public MutableData deepClone() {
        // A new list is created, and all elements are copied over, ensuring independence
        List<String> clonedItems = new ArrayList<>(this.items);
        return new MutableData(clonedItems);
    }
}

public class CloningDemoMutable {
    public static void main(String[] args) {
        List<String> originalItems = new ArrayList<>();
        originalItems.add("Item A");
        originalItems.add("Item B");

        MutableData original = new MutableData(originalItems);
        MutableData shallowCopy = original.shallowClone();
        MutableData deepCopy = original.deepClone();

        System.out.println("--- Initial State ---");
        System.out.println("Original: " + original.items);
        System.out.println("Shallow Copy: " + shallowCopy.items);
        System.out.println("Deep Copy: " + deepCopy.items);

        // Modify the *original* object's list
        original.items.add("Item C");

        System.out.println("\n--- State After Modifying Original ---");
        // Problem: Shallow copy sees the change because it shares the same List reference
        System.out.println("Shallow Copy (affected): " + shallowCopy.items);
        // Deep copy remains independent
        System.out.println("Deep Copy (unaffected): " + deepCopy.items);
    }
} 