// Superclass
class Animal {
    void sound() {
        System.out.println("Some generic animal sound");
    }
}

// Subclass Dog
class Dog extends Animal {
    void sound() {
        super.sound();
        System.out.println("Bark");
    }
}

// Subclass Cat
class Cat extends Animal {
    void sound() {
        System.out.println("Meow");
    }
}

// Subclass Cow
class Cow extends Animal {
    void sound() {
        System.out.println("Moo");
    }
}

class DynamicMethodDispatch {

    // Method that takes Animal reference as a parameter
    static void makeAnimalSound(Animal animal) {
        animal.sound();  // Calls the appropriate sound() method
    }

    public static void main(String args[]) {
        Animal aDog = new Dog();
        Animal aCat = new Cat();
        Animal aCow = new Cow();

        // Using the same method to make different animals sound
        makeAnimalSound(aDog);  // Outputs: Bark
        // makeAnimalSound(aCat);  // Outputs: Meow
        // makeAnimalSound(aCow);  // Outputs: Moo
        // makeAnimalSound(new Dog());
    }
}