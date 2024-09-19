// A generic interface
interface MinMax<T extends Comparable<T>> {
    T min();
    T max();
}

// A class that implements the generic interface
class MyClass<T extends Comparable<T>> implements MinMax<T> {
    T[] vals;

    MyClass(T[] o) {
        vals = o;
    }

    // Implement the min method
    public T min() {
        T v = vals[0];
        for (T val : vals) {
            if (val.compareTo(v) < 0) {
                v = val;
            }
        }
        return v;
    }

    // Implement the max method
    public T max() {
        T v = vals[0];
        for (T val : vals) {
            if (val.compareTo(v) > 0) {
                v = val;
            }
        }
        return v;
    }
}

public class GenInterfaceDemo {
    public static void main(String[] args) {
        Integer[] nums = {3, 6, 2, 8, 6};
        MyClass<Integer> intObj = new MyClass<>(nums);
        System.out.println("Min value: " + intObj.min());  // Output: 2
        System.out.println("Max value: " + intObj.max());  // Output: 8

        Character[] chars = {'b', 'r', 'p', 'w'};
        MyClass<Character> charObj = new MyClass<>(chars);
        System.out.println("Min value: " + charObj.min());  // Output: b
        System.out.println("Max value: " + charObj.max());  // Output: w
    }
}
