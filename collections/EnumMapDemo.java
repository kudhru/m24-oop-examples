import java.util.EnumMap;
import java.util.Map;

// Define an enum for demonstration
enum Size {
    SMALL, MEDIUM, LARGE, EXTRALARGE
}

public class EnumMapDemo {
    public static void main(String[] args) {
        // Create an EnumMap
        EnumMap<Size, Integer> enumMap = new EnumMap<>(Size.class);

        // Add key-value pairs to the EnumMap
        enumMap.put(Size.SMALL, 1);
        enumMap.put(Size.MEDIUM, 2);
        enumMap.put(Size.LARGE, 3);

        // Display the EnumMap
        System.out.println("EnumMap: " + enumMap); // Output: {SMALL=1, MEDIUM=2, LARGE=3}

        // Get the value associated with a specific key
        int mediumValue = enumMap.get(Size.MEDIUM);
        System.out.println("Value for MEDIUM: " + mediumValue); // Output: 2

        // Remove an entry
        enumMap.remove(Size.SMALL);
        System.out.println("EnumMap after removing SMALL: " + enumMap); // Output: {MEDIUM=2, LARGE=3}

        // Iterating over the EnumMap
        System.out.println("Iterating over EnumMap:");
        for (Map.Entry<Size, Integer> entry : enumMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
