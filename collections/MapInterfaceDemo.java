import java.util.HashMap;
import java.util.Map;

public class MapInterfaceDemo {
    public static void main(String[] args) {
        // Create a HashMap (which implements the Map interface)
        HashMap<String, Integer> map = new HashMap<>();

        // Add key-value pairs to the map
        map.put("Apple", 50);
        map.put("Banana", 30);
        map.put("Cherry", 20);
        map.put("Cherry", 40);
        System.out.println(map.capacity());

        // Display the map
        System.out.println("Initial Map: " + map); // Output: {Apple=50, Banana=30, Cherry=20}

        // Get the value for a specific key
        int applePrice = map.get("Apple");
        System.out.println("Price of Apple: " + applePrice); // Output: 50

        // Remove a key-value pair
        map.remove("Banana");
        System.out.println("Map after removing Banana: " + map); // Output: {Apple=50, Cherry=20}

        // Check if a key is present in the map
        boolean containsCherry = map.containsKey("Cherry");
        System.out.println("Contains Cherry: " + containsCherry); // Output: true

        // Display all keys and values
        System.out.println("Keys: " + map.keySet()); // Output: [Apple, Cherry]
        System.out.println("Values: " + map.values()); // Output: [50, 20]
    }
}
