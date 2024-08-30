// Superclass
class Animal {
    public void eat() {
        System.out.println("This animal eats food.");
    }
}

// Subclass
class Dog extends Animal {
    public void eat() {  // Method overriding
        System.out.println("The dog eats kibble.");
    }

    public void bark() {
        System.out.println("The dog barks.");
    }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        Animal myAnimal = new Dog(); // Superclass reference to a subclass object
        myAnimal.eat();  // Calls the Dog's overridden method

        // myAnimal.bark(); // Uncommenting this line will cause a compile-time error
    }
}
