interface MyInterface {
    void method1();
    void method2();
}

abstract class Incomplete implements MyInterface {
//    abstract public void method1();
    public void method1() {
        System.out.println("method1 is implemented.");
    }
    public void method2() {
        System.out.println("method2 is implemented.");
    }
//    abstract public void method3();
    // method2 is not implemented, so this class is abstract
}

class Complete extends Incomplete {
    public void method3() {
        System.out.println("method3 is now implemented.");
    }
}

public class TestPartialImplementation {
    public static void main(String[] args) {
        Complete obj = new Complete();
        obj.method1();
        obj.method2();
        obj.method3();
    }
}
