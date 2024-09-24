// Program demonstrating Java's automatic type conversions (widening)
// and failed conversions that need explicit casting
class AutoConversionDemo {
    public static void main(String[] args) {
        // Successful automatic conversions (Widening)
        byte byteVal = 100;
        short shortVal = byteVal;  // byte to short (automatic widening)
        int intVal = shortVal;     // short to int (automatic widening)
        long longVal = intVal;     // int to long (automatic widening)
        float floatVal = longVal;  // long to float (automatic widening)
        double doubleVal = floatVal; // float to double (automatic widening)

        // Displaying the values
        System.out.println("Automatic conversions:");
        System.out.println("byte to short: " + shortVal);
        System.out.println("short to int: " + intVal);
        System.out.println("int to long: " + longVal);
        System.out.println("long to float: " + floatVal);
        System.out.println("float to double: " + doubleVal);

        // Conversions that do NOT work without explicit casting
        // Uncommenting these lines will cause a compile-time error

        // byte byteFromInt = intVal;  // int to byte (narrowing, needs cast)
        // float floatFromDouble = doubleVal;  // double to float (narrowing, needs cast)
        // char charFromInt = intVal;  // int to char (incompatible types, needs cast)

        // Correcting the above with explicit casting
        byte byteFromInt = (byte) intVal;  // int to byte (explicit narrowing)
        float floatFromDouble = (float) doubleVal;  // double to float (explicit narrowing)
        char charFromInt = (char) intVal;  // int to char (explicit narrowing)

        // Displaying the values after explicit casting
        System.out.println("\nConversions with explicit casting:");
        System.out.println("int to byte (with cast): " + byteFromInt);
        System.out.println("double to float (with cast): " + floatFromDouble);
        System.out.println("int to char (with cast): " + charFromInt);

        double d = 123.45;
        int x = (int) d;  // Casting double to int, fractional part is lost
        System.out.println(x);  // Output: 123
    }
}
