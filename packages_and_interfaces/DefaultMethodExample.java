interface MyInterface {
    int a = 5;
    void method1();   // abstract method
    int method2();   // abstract method

    // This is a default method with a body
    default void defaultMethod() {
        System.out.println("This is the default method implementation");
    }
}

// Implementing class
class MyClass implements MyInterface {
    int a = 10;
    public void method1() {
        // a = 10;
        // a++;
        System.out.println("a = " + MyInterface.a);
        System.out.println("Implementation of method1");
    }

    public int method2() {
        return a;
    }

    // void defaultMethod(int a) {
    //     System.out.println("This is the default method implementation");
    // }
}

public class DefaultMethodExample {
    public static void main(String[] args) {
        MyClassCustom obj = new MyClassCustom();
        obj.method1();          // Calls implemented method1
        obj.defaultMethod();    // Calls the default method from the interface
    }
}