class Generic<T> {
    T ob; // ob is of type T

    Generic(T o) {
        ob = o;
    }

    T getOb() {
        return ob;
    }
}


public class GenericDemo1 {
    public static void main(String[] args) {
        Generic<Integer> iOb = new Generic<>(88); // No need for casting
        int value = iOb.getOb(); // No cast required
        System.out.println("Value: " + value);

        Generic<String> strOb = new Generic<>("Hello");
        String str = strOb.getOb(); // No cast required
        System.out.println("Value: " + str);

        // This is illegal and will result in a compile-time error
//         Generic<int> intOb = new Generic<int>(53); // Error: Can't use primitive type

        Generic<Integer> intOb = new Generic<>(100);
        Generic<String> strOb = new Generic<>("Hello");

        // The following line will cause a compile-time error
        intOb = strOb; // Error: Incompatible types

        Generic<Integer> integerObject1 = new Generic<>(100);
        Generic<Integer> integerObject2 = new Generic<>(200);

        integerObject1 = integerObject2;
    }
}
