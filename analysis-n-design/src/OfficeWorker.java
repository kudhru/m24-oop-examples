/*
1. Dependency (Uses-A Relationship)
Dependency signifies that one class uses another class, typically temporarily, to perform a specific task. 
This relationship is often achieved through: 
- Method Parameters: Passing an object of the dependent class as an argument to a method of the relying class.
- Local Variables: Creating an instance of the dependent class within a method of the relying class.
 */

class Printer {
    void printDocument(String doc) {
        System.out.println("Printing document: " + doc);
    }
}

class OfficeWorker {
    void doWork() {
        Printer printer = new Printer(); // Dependency via local variable
        printer.printDocument("ProjectReport.pdf");
        System.out.println("Work completed.");
    }

    void printSpecificDocument(Printer printer, String doc) { // Dependency via method parameter
        printer.printDocument(doc);
    }
}