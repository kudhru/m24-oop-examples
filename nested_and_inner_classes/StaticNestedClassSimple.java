class OuterClass {
    private int instanceVar = 10;
    static int staticVar = 20;

//    static void printVariables() {
//        System.out.println(staticVar); // This works as we are trying to access a static variable
//        System.out.println(instanceVar); // This doesn't work as we are trying to access a non-static variable
//    }

    static void printVariables(OuterClass non_static_object) {
        System.out.println(staticVar); // This works as we are trying to access a static variable
//        System.out.println(instanceVar); // This doesn't work as we are trying to access a non-static variable
        System.out.println(non_static_object.instanceVar);
    }

    static class StaticNestedClass {

//        void accessMembers() {
//            System.out.println(staticVar);         // Can access static member
//            System.out.println(instanceVar); // Does not work
//
//        }

        void accessMembers(OuterClass outer) {
            System.out.println(staticVar);         // Can access static member
            System.out.println(outer.instanceVar); // Now it can access non-static member
        }
    }
}

public class StaticNestedClassSimple {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass(); // Create an instance of the outer class
        OuterClass.printVariables(outer);
//        OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
////        nested.accessMembers();
//        nested.accessMembers(outer); // Pass the outer instance to access non-static members

    }
}