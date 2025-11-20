class Namer {
	//base class extended by two child classes
	protected String last; //split name
	protected String first; //stored here
	
	public String getFirst() {
		return first; //return first name
	}
	
	public String getLast() {
		return last; //return last name
	}
}

class FirstFirst extends Namer {
	//extracts first name from last name when separated by a space
	public FirstFirst(String s) {
		int i = s.lastIndexOf(" "); //find sep space

		if (i > 0) {
			first = s.substring(0, i).trim();
			last = s.substring(i + 1).trim();
		} else {
			first = ""; // if no space
			last = s; // put all in last name
		}
	}
}

class LastFirst extends Namer {
	// extracts last name from first name when separated by a comma
	public LastFirst(String s) {
		int i = s.indexOf(","); //find comma
		
		if (i > 0) {
			last = s.substring(0, i).trim();
			first = s.substring(i + 1).trim();
		} else {
			last = s; //if no comma,
			first = ""; //put all in last name
		}
	}
}

class NamerFactory {
	//Factory decides which class to return based on presence of a comma
	public Namer getNamer(String entry) {
		//comma determines name order
		int i = entry.indexOf(",");
		if (i > 0)
			return new LastFirst(entry);
		else
			return new FirstFirst(entry);
	}
}

public class FactoryDemo2 {
    public static void main(String[] args) {
        NamerFactory factory = new NamerFactory();

        // Example 1: Name with a comma (Last, First format)
        String name1 = "Doe, John";
        Namer namer1 = factory.getNamer(name1);
        System.out.println("Input: \"" + name1 + "\"");
        System.out.println("First Name: " + namer1.getFirst());
        System.out.println("Last Name: " + namer1.getLast());
        System.out.println();

        // Example 2: Name with a space (First Last format)
        String name2 = "Jane Smith";
        Namer namer2 = factory.getNamer(name2);
        System.out.println("Input: \"" + name2 + "\"");
        System.out.println("First Name: " + namer2.getFirst());
        System.out.println("Last Name: " + namer2.getLast());
        System.out.println();

        // Example 3: Name with only a space
        String name3 = "One Name";
        Namer namer3 = factory.getNamer(name3);
        System.out.println("Input: \"" + name3 + "\"");
        System.out.println("First Name: " + namer3.getFirst());
        System.out.println("Last Name: " + namer3.getLast());
        System.out.println();

        // Example 4: Name with only a comma (Edge case)
        String name4 = "Single,Name";
        Namer namer4 = factory.getNamer(name4);
        System.out.println("Input: \"" + name4 + "\"");
        System.out.println("First Name: " + namer4.getFirst());
        System.out.println("Last Name: " + namer4.getLast());
        System.out.println();
    }
}
