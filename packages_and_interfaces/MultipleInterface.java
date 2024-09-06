interface Printable {
    int a = 5;
    void print();
    default void sameMethod() {
        System.out.println("Inside Printable");
    }
}

interface Showable {
    int a = 10;
    void show();
    void sameMethod();
    // default void sameMethod() {
    //     System.out.println("Inside Showable");
    // }
}

class Document implements Printable, Showable {
    public void print() {
        System.out.println("Printing document");
    }

    public void show() {
        System.out.println("Showing document");
    }

    public void sameMethod() {
        System.out.println("a = " + Printable.a);
        System.out.println("a = " + Showable.a);
    }


}

public class MultipleInterface {
    public static void main(String[] args) {
        Document doc = new Document();
        doc.print();  // Calls print method
        doc.show();   // Calls show method
        doc.sameMethod();
        // Printable.sameMethod();
    }
}
