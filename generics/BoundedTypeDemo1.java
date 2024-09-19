// A generic class with a bounded type parameter
// Stats is a generic Class
// What can go inside T? Any class which extends Number class
// Number class is built-in java
class Stats<T extends Number> {
    T[] nums; // Array of type T

    // Constructor that accepts an array of type T
    Stats(T[] nums) {
        this.nums = nums;
    }

    // Method to calculate the average of the numbers
    double average() {
        double sum = 0.0;
        for (T num : nums) {
            sum += num.doubleValue(); // Works because T is a subclass of Number
        }
        return sum / nums.length;
    }
}

public class BoundedTypeDemo1 {
    public static void main(String[] args) {
        Integer[] intNums = { 1, 2, 3, 4, 5 };
        Stats<Integer> intStats = new Stats<>(intNums);
        System.out.println("Average of intNums: " + intStats.average());

        Double[] doubleNums = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        Stats<Double> doubleStats = new Stats<>(doubleNums);
        System.out.println("Average of doubleNums: " + doubleStats.average());

        // This will NOT work because String does not extend Number
        String[] strNums = {"1", "2", "3", "4", "5"};
        // The following line will cause a compile-time error
         Stats<String> strStats = new Stats<>(strNums); // Error: String does not extend Number
    }
}
