class Outer {
    // Nested interface
    public interface Check {
        boolean test(int num);
    }
}

class Test implements Outer.Check {
    public boolean test(int num) {
        return num > 0;
    }
}

public class NestedInterfaceDemo {
    public static void main(String[] args) {
        Outer.Check checker = new Test();
        
        if (checker.test(10)) {
            System.out.println("10 is positive.");
        } else {
            System.out.println("10 is not positive.");
        }
    }
}