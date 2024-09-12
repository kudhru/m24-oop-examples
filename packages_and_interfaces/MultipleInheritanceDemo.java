interface InterfaceA {
    default void show() {
        System.out.println("InterfaceA default method");
    }
}
//interface InterfaceB {
//    default void show() {
//        System.out.println("InterfaceB default method");
//    }
//}

interface InterfaceB extends InterfaceA{
    default void show() {
        System.out.println("InterfaceB default method");
    }
}

class MyClassCustom implements InterfaceB {
    // Must resolve the conflict between InterfaceA and InterfaceB
    public void show() {
        System.out.println("MyClass custom method");
//        InterfaceA.super
//        InterfaceA.super.show();
        InterfaceB.super.show();
//        InterfaceB.show();
//        super.show();
    }
}

public class MultipleInheritanceDemo {
    public static void main(String[] args) {
        MyClassCustom obj = new MyClassCustom();
        obj.show();  // Resolves to MyClass's own implementation
        // InterfaceA.super.show();
    }
}
