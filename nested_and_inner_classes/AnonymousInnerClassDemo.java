interface MyInterface {
    void display();
}

public class AnonymousInnerClassDemo {
    public static void main(String[] args) {
        // Anonymous inner class implementing MyInterface
        MyInterface obj = new MyInterface() {
//            @Override
            public void display() {
                System.out.println("This is an anonymous inner class");
            }
        };

        obj.display();  // Call the method of the anonymous inner class
    }
}
