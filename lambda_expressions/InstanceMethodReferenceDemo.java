@FunctionalInterface
interface StringOperation {
    void perform(String str);
}

public class InstanceMethodReferenceDemo {

    // Instance method to be referenced
    public void display(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        InstanceMethodReferenceDemo demo = new InstanceMethodReferenceDemo();

        StringOperation operation1 = (message) -> demo.display(message);
        operation1.perform("Normal Lambda Expression");
        // Using method reference for an instance method
        StringOperation operation2 = demo::display;
        operation2.perform("Instance Method Reference!"); // Output: Instance Method Reference!
    }
}
