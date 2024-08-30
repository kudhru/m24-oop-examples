// Superclass
class Animal {
    String name;
    Animal() {
        System.out.println("Animal constructor called.");
    }
}

// Subclass 1
class Mammal extends Animal {
    Mammal() {
        System.out.println("Mammal constructor called.");
    }
}

// Subclass 2
class Dog extends Mammal {
    Dog() {
        System.out.println("Dog constructor called.");
    }
}

public class ConstructorExecutionExample {
    public static void main(String[] args) {
        Dog myDog = new Dog();
    }
}