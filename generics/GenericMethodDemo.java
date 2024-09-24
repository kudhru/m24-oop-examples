// A non-generic class with a generic method
class GenericMethodDemo {

    // A generic method that checks if an item exists in an array
    static <T> T isIn(T item, T[] array) {
        System.out.println(item.getClass().getName());
        System.out.println(array.getClass().getName());
        for (T element : array) {
//            if (element.equals(item)) {
//                return true;
//            }
            System.out.println("inside for loop: " + element);
            if (element.equals("banana")) {
                return item;
            }
        }
        return item;
    }

    public static void main(String[] args) {
        // Test with Integer array
        Integer[] nums = { 1, 2, 3, 4, 5 };
//        System.out.println(isIn(3, nums));  // Output: true
//        System.out.println(isIn(6, nums));  // Output: false
//                System.out.println(isIn(3.0, nums));  // Output: true
        System.out.println(isIn("banana", nums));  // Output: true

        // Test with String array
//        String[] words = { "apple", "banana", "cherry" };
//        System.out.println(isIn("banana", words));  // Output: true
//        System.out.println(isIn("grape", words));   // Output: false
        Integer firstInt = 4;
        String firstString = "Hello World";
//        System.out.println( 4 == 4.0);
//        System.out.println( firstInt.equals(firstString));
//        System.out.println( firstInt == firstString);
    }
}
