// Superclass
class Animal {
    String name = "Animal";

    void sound() {
        System.out.println("This animal makes a sound.");
    }
}

// Subclass
class Dog extends Animal {
    String name = "Dog";

    @Override
    void sound() {  // Overriding the method
        System.out.println("The dog barks.");
    }

    void showDetails() {
        System.out.println("Name from Dog class: " + name);
        System.out.println("Name from Animal class: " + super.name);

        sound();           // Calls Dog's overridden method
        super.sound();     // Calls Animal's method
    }
}

public class SuperUsageExample {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.showDetails();
    }
}