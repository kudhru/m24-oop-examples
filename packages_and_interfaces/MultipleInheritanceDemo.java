interface InterfaceA {
    default void show() {
        System.out.println("InterfaceA default method");
    }
}
interface InterfaceB {
    default void show() {
        System.out.println("InterfaceB default method");
    }
}

class MyClass implements InterfaceA, InterfaceB {
    // Must resolve the conflict between InterfaceA and InterfaceB
    public void show() {
        System.out.println("MyClass custom method");
        InterfaceA.super.show();
    }
}

public class MultipleInheritanceDemo {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.show();  // Resolves to MyClass's own implementation
        // InterfaceA.super.show();
    }
}
