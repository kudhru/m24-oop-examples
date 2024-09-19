// A non-generic class with a generic method
class GenMethodDemo {

    // A generic method that checks if an item exists in an array
    static <T> boolean isIn(T item, T[] array) {
        for (T element : array) {
            if (element.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test with Integer array
        Integer[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(isIn(3, nums));  // Output: true
        System.out.println(isIn(6, nums));  // Output: false

        // Test with String array
        String[] words = { "apple", "banana", "cherry" };
        System.out.println(isIn("banana", words));  // Output: true
        System.out.println(isIn("grape", words));   // Output: false
    }
}
