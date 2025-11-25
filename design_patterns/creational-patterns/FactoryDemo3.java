// Namer is now an interface
interface Namer1 {
    // Interface defines the contract that implementing classes must fulfill
    String getFirstName();
    String getLastName();
}

class FirstFirst1 implements Namer1 {
    // extract first name from last name when separated by a space
    private String last; //split name
    private String first; //stored here

    public FirstFirst1(String s) {
        int i = s.lastIndexOf(" "); //find sep space

        if (i > 0) {
            first = s.substring(0, i).trim();
            last = s.substring(i + 1).trim();
        } else {
            first = ""; // if no space
            last = s; // put all in last name
        }
    }

    @Override
    public String getFirstName() {
        return first;
    }

    @Override
    public String getLastName() {
        return last;
    }
}

class LastFirst1 implements Namer1 {
    // extracts last name from first name when separated by a comma
    private String last; //split name
    private String first; //stored here

    public LastFirst1(String s) {
        int i = s.indexOf(","); //find comma
        
        if (i > 0) {
            last = s.substring(0, i).trim();
            first = s.substring(i + 1).trim();
        } else {
            last = s; //if no comma,
            first = ""; //put all in last name
        }
    }

    @Override
    public String getFirstName() {
        return first;
    }

    @Override
    public String getLastName() {
        return last;
    }
}

class NamerFactory1 {
    // Factory decides which class to return based on presence of a comma
    public Namer1 getNamer(String entry) {
        //comma determines name order
        int i = entry.indexOf(",");
        if (i > 0)
            return new LastFirst1(entry);
        else
            return new FirstFirst1(entry);
    }
    
    // Now getFirst() and getLast() methods are defined in the factory, 
    // calling the specific implementation methods provided by the 'Namer' interface.
    public String getFirst(Namer1 namerInstance) {
        return namerInstance.getFirstName();
    }
    
    public String getLast(Namer1 namerInstance) {
        return namerInstance.getLastName();
    }
}

public class FactoryDemo3 {
    public static void main(String[] args) {
        NamerFactory1 factory = new NamerFactory1();

        // Example 1: Name with a comma (Last, First format)
        String name1 = "Doe, John";
        Namer1 namer1 = factory.getNamer(name1);
        System.out.println("Input: \"" + name1 + "\"");
        // Accessing methods via the factory
        System.out.println("First Name: " + factory.getFirst(namer1));
        System.out.println("Last Name: " + factory.getLast(namer1));
        System.out.println();

        // Example 2: Name with a space (First Last format)
        String name2 = "Jane Smith";
        Namer1 namer2 = factory.getNamer(name2);
        System.out.println("Input: \"" + name2 + "\"");
        // Accessing methods via the factory
        System.out.println("First Name: " + factory.getFirst(namer2));
        System.out.println("Last Name: " + factory.getLast(namer2));
        System.out.println();

        // Example 3: Name with only a space
        String name3 = "One Name";
        Namer1 namer3 = factory.getNamer(name3);
        System.out.println("Input: \"" + name3 + "\"");
        System.out.println("First Name: " + factory.getFirst(namer3));
        System.out.println("Last Name: " + factory.getLast(namer3));
        System.out.println();

        // Example 4: Name with only a comma (Edge case)
        String name4 = "Single,Name";
        Namer1 namer4 = factory.getNamer(name4);
        System.out.println("Input: \"" + name4 + "\"");
        System.out.println("First Name: " + factory.getFirst(namer4));
        System.out.println("Last Name: " + factory.getLast(namer4));
        System.out.println();
    }
}
