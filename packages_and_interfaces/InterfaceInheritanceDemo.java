interface A {
    void method1();
}

//interface B extends A {
//    void method2();
//}

class MyClassCustom1 implements A {
    public void method1() {
        System.out.println("Implementing method1");
    }

    public void method2() {
        System.out.println("Implementing method2");
    }
}

public class InterfaceInheritanceDemo {
    public static void main(String[] args) {
        MyClassCustom1 obj = new MyClassCustom1();
        obj.method1();  // From interface A
        obj.method2();  // From interface B
    }
}
