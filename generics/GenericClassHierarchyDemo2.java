// A simple generic class
class Gen<T> {
    T ob;  // Declare an object of type T

    Gen(T o) {
        ob = o;
    }

    T getOb() {
        return ob;
    }
}
// A subclass of Gen with the same type parameter T
// A subclass that adds its own type parameter
class Gen2<T, V> extends Gen<T> {
    V ob2;  // Declare a second object of type V

    Gen2(T o, V o2) {
        super(o);
        ob2 = o2;
    }

    V getOb2() {
        return ob2;
    }
}

public class GenericClassHierarchyDemo2 {
    public static void main(String[] args) {
        // Create a Gen2 object with two types: String and Integer
        Gen2<String, Integer> obj = new Gen2<>("Hello", 99);
        System.out.println(obj.getOb());  // Output: Hello
        System.out.println(obj.getOb2());  // Output: 99
    }
}

