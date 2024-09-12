class Outer {
    int outer_x = 100;

    void test() {
        // Define a local inner class inside a method
        class Inner {
            void display() {
                System.out.println("display: outer_x = " + outer_x);
            }
        }

        Inner inner = new Inner();  // Create an instance of the local inner class
        inner.display();  // Call method of the local inner class
    }
}

public class LocalInnerClassDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();
    }
}
