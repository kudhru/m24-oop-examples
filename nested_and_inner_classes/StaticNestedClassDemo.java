class Outer {
    static int outer_x = 100;

    static void test() {
        Inner inner = new Inner();
//        inner.display();
//        Inner.display();
    }

    // This is an inner class
    static class Inner {
        void display() {
//            Outer outer = new Outer();
//            System.out.println("display: outer_x = " + outer.outer_x);
            System.out.println("display: outer_x = " + outer_x);
        }
    }
}

class StaticNestedClassDemo {
    public static void main(String args[]) {
//        Outer outer = new Outer();
//        outer.test();
//        Outer.Inner.display();
//        Outer.test();
//        Outer.Inner
        Outer.Inner.display();
    }
}
