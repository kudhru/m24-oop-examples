// Generic class before erasure
class Gen<T> {
    // Declare a variable of type T
    T ob;

    // Constructor that accepts a reference of type T
    Gen(T o) {
        ob = o;
    }

    // Return the object of type T
    T getob() {
        return ob;
    }

    // Show type of T
    void showType() {
        System.out.println("Type of T is: " + ob.getClass().getName());
    }
}

// Generic class after erasure
class Gen {
    Object ob; // Type erased to Object

    Gen(Object o) {
        ob = o;
    }

    Object getob() {
        return ob;
    }

    void showType() {
        System.out.println("Type of T is: " + ob.getClass().getName());
    }
}

public class GenericsErasureDemo {
    public static void main(String[] args) {
        // Create a Gen object for Integer
        Gen<Integer> intOb = new Gen<>(88);

        // Display type and value for intOb
        intOb.showType();
        int intValue = intOb.getob();
        System.out.println("Value: " + intValue);

        System.out.println();

        // Create a Gen object for String
        Gen<String> strOb = new Gen<>("Generics Test");

        // Display type and value for strOb
        strOb.showType();
        String strValue = strOb.getob();
        System.out.println("Value: " + strValue);
    }
}
