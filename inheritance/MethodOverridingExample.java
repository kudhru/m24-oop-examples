// Superclass
class Animal {
    void sound() {
        System.out.println("This animal makes a sound.");
    }
}

// Subclass
class Dog extends Animal {
    @Override
    void sound() {  // Overriding the superclass method
        System.out.println("The dog barks.");
    }
}

public class MethodOverridingExample {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        myAnimal.sound();  // Calls the Animal's sound method

        Dog myDog = new Dog();
        myDog.sound();  // Calls the Dog's overridden sound method
    }
}