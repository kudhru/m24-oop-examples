public class StringLiteralDemo {
    public static void main(String[] args) {
        String word1 = "abcd";
        word1.toUpperCase();
        System.out.println(word1.hashCode());
        String word2 = "xyz";
        System.out.println(word2.hashCode());
        String word3 = "xyz";
        System.out.println(word3.hashCode());
        String result = word1.concat(word2);
        System.out.println(result.hashCode());
        result += word3;
        System.out.println(result.hashCode());
    }
}
