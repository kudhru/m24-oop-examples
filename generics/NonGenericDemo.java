class NonGen {
    Object ob; // ob is of type Object

    NonGen(Object o) {
        ob = o;
    }

    Object getOb() {
        return ob;
    }
}

public class NonGenericDemo {
    public static void main(String[] args) {
        NonGen iOb = new NonGen(88); // Autoboxing to Integer
        int value = (Integer) iOb.getOb(); // Cast required

        NonGen iOb1 = new NonGen("hello"); // Autoboxing to Integer
        int value2 = (Integer) iOb1.getOb(); // Run time error
        String value3 = (Integer) iOb1.getOb(); // Compile time error

//        Integer value = iOb.getOb(); // Cast required
//        int value1 = iOb.getOb(); // Cast required
        System.out.println("Value: " + value);

        NonGen strOb = new NonGen("Hello");
        String str = (String) strOb.getOb(); // Cast required
        System.out.println("Value: " + str);
    }
}
