class Outer {
    int outer_x = 100;

    void test() {
        Inner inner = new Inner();
        inner.display();
    }

    // This is an inner class
    static class Inner {
        void display() {
            Outer outer = new Outer();
            System.out.println("display: outer_x = " + outer.outer_x);
        }
    }
}

class StaticNestedClassDemo {
    public static void main(String args[]) {
        Outer outer = new Outer();
        outer.test();
    }
}
