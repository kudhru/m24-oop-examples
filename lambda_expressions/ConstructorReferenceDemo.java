@FunctionalInterface
interface MyFactory {
    MyClass create(String name);
}

class MyClass {
    String name;

    MyClass(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Name: " + name);
    }
}

public class ConstructorReferenceDemo {
    public static void main(String[] args) {
        MyFactory factory1 = (name) -> new MyClass(name);
        // Creating a new instance using the method reference
        MyClass myClassInstance1 = factory1.create("Lambda Constructor");
        myClassInstance1.display(); // Output: Name: Lambda Constructor

        // Using constructor reference
        MyFactory factory2 = MyClass::new;

        // Creating a new instance using the method reference
        MyClass myClassInstance2 = factory2.create("Constructor Reference");
        myClassInstance2.display(); // Output: Name: Lambda Constructor
    }
}
