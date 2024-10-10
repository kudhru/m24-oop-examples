interface InterfaceA {
    default void show() {
        System.out.println("InterfaceA default method");
    }
    default void show2() {
        System.out.println("InterfaceA default method 2");
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

class MyClassCustom implements InterfaceA {
    // Must resolve the conflict between InterfaceA and InterfaceB
    public void show() {
        System.out.println("MyClass custom method");
        InterfaceA.super.show();
        show2();
        this.show2();
        InterfaceA.super.show2();
//        InterfaceA.super
//        InterfaceA.super.show();
//        InterfaceB.super.show();
//        InterfaceA object = new InterfaceA() {
//            public void show() {
//                System.out.println("MyClass custom method");
//            }
//        };
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
