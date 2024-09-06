interface A {
    void method1();
}

interface B extends A {
    void method2();
}

class MyClass implements B {
    public void method1() {
        System.out.println("Implementing method1");
    }

    public void method2() {
        System.out.println("Implementing method2");
    }
}

public class InterfaceInheritanceDemo {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.method1();  // From interface A
        obj.method2();  // From interface B
    }
}
