// Superclass
class Animal {
    public String name;        // Accessible everywhere
    protected int age;         // Accessible in subclass and same package
    private String species;    // Not accessible in subclass

    public void eat() {
        System.out.println(name + " eats food.");
    }

    private void sleep() {
        System.out.println(name + " sleeps.");
    }

    // Public method to access private member
    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }
}

// Subclass
class Dog extends Animal {
    public String breed;

    public void bark() {
        System.out.println(name + " the " + breed + " barks.");
    }

    public void showDetails() {
        System.out.println("Name: " + name);  // Accessible
        System.out.println("Age: " + age);    // Accessible
        // System.out.println("Species: " + species); // Not accessible directly
        System.out.println("Species: " + getSpecies()); // Accessible through a public method
    }
}

public class MemberAccessExample {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.name = "Buddy";
        myDog.age = 3;
        myDog.breed = "Golden Retriever";
        
        // Setting species using the public method
        myDog.setSpecies("Canine");

        myDog.eat();        // Inherited method
        myDog.bark();       // Subclass method
        myDog.showDetails(); // Display details, including the private species accessed through a method
    }
}
