// A simple generic class
class Gen<T> {
    T ob; // Declare an object of type T

    // Constructor that accepts an object of type T
    Gen(T o) {
        ob = o;
    }

    // Return the object
    T getOb() {
        return ob;
    }

    // Show the type of T
    void showType() {
        System.out.println("Type of T is " + ob.getClass().getName());
    }
}

public class GenericDemo {
    public static void main(String[] args) {
        // Create a Gen object for Integer
        Gen<Integer> iOb = new Gen<>(88);
        iOb.showType(); // Output: Type of T is java.lang.Integer
        System.out.println("Value: " + iOb.getOb());

        // Create a Gen object for String
        Gen<String> strOb = new Gen<>("Generics Test");
        strOb.showType(); // Output: Type of T is java.lang.String
        System.out.println("Value: " + strOb.getOb());

        // This is illegal and will result in a compile-time error
        // Gen<int> intOb = new Gen<int>(53); // Error: Can't use primitive type

        // Correct usage with wrapper class Integer
        Gen<Integer> intOb = new Gen<>(53); // Autoboxing of primitive int to Integer
        System.out.println("Value: " + intOb.getOb());

        Gen<Integer> intOb = new Gen<>(100);
        Gen<String> strOb = new Gen<>("Hello");

        // The following line will cause a compile-time error
         intOb = strOb; // Error: Incompatible types
    }
}