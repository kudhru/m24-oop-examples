interface MyInterface {
    void display();
    void print();
}

//class MyInterfaceClass implements MyInterface {
//    void display(){
//        System.out.println("Usual way of implementing interfaces");
//    }
//}
//
//public class AnonymousInnerClassDemo {
//    public static void main(String[] args) {
//
//        MyInterface obj = new MyInterfaceClass();
//        obj.display();  // Call the method of the anonymous inner class
//    }
//}


public class AnonymousInnerClassDemo {
    public static void main(String[] args) {
        // Anonymous inner class implementing MyInterface
        MyInterface obj = new MyInterface() {
//            @Override
            public void display() {
                System.out.println("This is an anonymous inner class");
            }
            public void print() {
                System.out.println("This is an anonymous inner class");
            }
        };

        obj.display();  // Call the method of the anonymous inner class
    }
}

