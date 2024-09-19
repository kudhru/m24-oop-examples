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
class Gen2<T> extends Gen<T> {
    Gen2(T o) {
        super(o);
    }

    // Additional method in the subclass
    void showType() {
        System.out.println("Type of T is " + ob.getClass().getName());
    }
}
public class GenericClassHierarchyDemo1 {
    public static void main(String[] args) {
        // Create a Gen2 object for Integer
        Gen2<Integer> intOb = new Gen2<>(100);
        intOb.showType();  // Output: Type of T is java.lang.Integer
        System.out.println("Value: " + intOb.getOb());

        // Create a Gen2 object for String
        Gen2<String> strOb = new Gen2<>("Hello Generics");
        strOb.showType();  // Output: Type of T is java.lang.String
        System.out.println("Value: " + strOb.getOb());
    }
}
