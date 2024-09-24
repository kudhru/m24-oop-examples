// Program illustrating automatic type promotion in expressions
class TypePromotionDemo {
    public static void main(String[] args) {
        // Example 1: Automatic promotion of byte to int
        byte b1 = 40;
        byte b2 = 50;
        // b1 and b2 are promoted to int before multiplication
        int result = b1 * b2;
        System.out.println("Result of byte multiplication (promoted to int): " + result);  // Output: 2000

        // Example 2: Mixing int and float
        int i = 100;
        float f = 25.5f;
        // i is promoted to float before addition, then result is stored in double
        double dResult = i + f;
        System.out.println("Result of int + float (promoted to float): " + dResult);  // Output: 125.5

        // Example 3: Mixing int, long, and double
        long l = 50000L;
        double d = 0.1234;
        // l is promoted to double before the multiplication
        double finalResult = i * l + d;
        System.out.println("Result of int * long + double (promoted to double): " + finalResult);  // Output: 500001234.0

        // Example 4: Automatic promotion with char
        char c = 'A';  // ASCII value of 'A' is 65
        int charResult = c + i;  // char is promoted to int before addition
        System.out.println("Result of char + int (promoted to int): " + charResult);  // Output: 165
    }
}
