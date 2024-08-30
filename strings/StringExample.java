public class StringExample {
    public static void main(String[] args) {
        // Sample String
        String str = "Hello, World!";

                int length = str.length();
        System.out.println("Length of the string: " + length);

        // 2. charAt(): Returns the character at the specified index
        char ch = str.charAt(7);
        System.out.println("Character at index 7: " + ch);

        // 3. substring(): Returns a substring from the string
        String substr = str.substring(7);
        System.out.println("Substring from index 7: " + substr);

        String substr2 = str.substring(0, 5);
        System.out.println("Substring from index 0 to 5: " + substr2);

        // 4. indexOf(): Returns the index of the first occurrence of the specified character or substring
        int index = str.indexOf('W');
        System.out.println("Index of 'W': " + index);

        int index2 = str.indexOf("World");
        System.out.println("Index of 'World': " + index2);

        // 5. toUpperCase(): Converts all characters in the string to uppercase
        String upper = str.toUpperCase();
        System.out.println("Uppercase: " + upper);

        // 6. toLowerCase(): Converts all characters in the string to lowercase
        String lower = str.toLowerCase();
        System.out.println("Lowercase: " + lower);

        // 7. replace(): Replaces all occurrences of a character or substring with another character or substring
        String replaced = str.replace('l', 'x');
        System.out.println("Replace 'l' with 'x': " + replaced);

        String replaced2 = str.replace("World", "Java");
        System.out.println("Replace 'World' with 'Java': " + replaced2);

        // 8. equals(): Compares two strings for equality
        boolean isEqual = str.equals("Hello, World!");
        System.out.println("Is equal to 'Hello, World!': " + isEqual);

        // 9. equalsIgnoreCase(): Compares two strings for equality, ignoring case
        boolean isEqualIgnoreCase = str.equalsIgnoreCase("hello, world!");
        System.out.println("Is equal to 'hello, world!' ignoring case: " + isEqualIgnoreCase);

        // 10. startsWith(): Checks if the string starts with the specified prefix
        boolean startsWith = str.startsWith("Hello");
        System.out.println("Starts with 'Hello': " + startsWith);

        // 11. endsWith(): Checks if the string ends with the specified suffix
        boolean endsWith = str.endsWith("World!");
        System.out.println("Ends with 'World!': " + endsWith);

        // 12. contains(): Checks if the string contains the specified sequence of characters
        boolean contains = str.contains("World");
        System.out.println("Contains 'World': " + contains);

        // 13. split(): Splits the string based on a regular expression and returns an array of substrings
        String[] parts = str.split(", ");
        System.out.println("Split by ', ':");
        for (String part : parts) {
            System.out.println(part);
        }

        // 14. trim(): Removes leading and trailing whitespace
        String strWithSpaces = "   Hello, World!   ";
        String trimmed = strWithSpaces.trim();
        System.out.println("Trimmed string: '" + trimmed + "'");

        // 15. valueOf(): Converts different data types to string
        int number = 100;
        String strNumber = String.valueOf(number);
        System.out.println("String value of 100: " + strNumber);

        // 16. concat(): Concatenates two strings
        String greeting = "Hello";
        String name = "John";
        String fullGreeting = greeting.concat(", ").concat(name).concat("!");
        System.out.println("Concatenated string: " + fullGreeting);
    }
}