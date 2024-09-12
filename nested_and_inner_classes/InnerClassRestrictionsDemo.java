class Outer {
    int outer_x = 100;

    void test() {
        Inner inner = new Inner();
        inner.display();
    }

    // This is an inner class
    class Inner {
        int y = 10;  // y is local to Inner

        void display() {
            System.out.println("display: outer_x = " + outer_x);
        }
    }

    // Outer class trying to access y of Inner class (will cause error)
    void showy() {
         System.out.println(y);  // Error: y not known here!
    }
}

public class InnerClassRestrictionsDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();  // This works as the inner class accesses outer_x

         outer.showy();
    }
}
