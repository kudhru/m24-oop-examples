class Outer {
    int outer_x;

    void test() {
        System.out.println(outer_x);
        Inner inner = new Inner();
        inner.display();
    }

    // This is an inner class
    class Inner {
        void display() {
            System.out.println("display: outer_x = " + outer_x);
        }
    }

    class Inner2 extends Inner {
        void display() {
            System.out.println("display: outer_x = " + outer_x);
        }
    }
}

class Outer2 extends Outer {
    int outer_x;

    void test() {
        System.out.println("Inside Outer 2");
        Inner inner = new Inner();
        inner.display();
    }

    // This is an inner class
    class Inner {
        void display() {
            System.out.println("display inside extended Outer class: outer_x = " + outer_x);
        }
    }

    class Inner2 extends Inner {
        void display() {
            System.out.println("display: outer_x = " + outer_x);
        }
    }
}

class InnerClassDemo {
    public static void main(String args[]) {
        Outer outer = new Outer();
        outer.outer_x = 20;
        outer.test();

        Outer2 outer2 = new Outer2();
        outer2.test();
    }
}
