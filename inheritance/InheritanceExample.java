// Superclass
class Animal {
    String name;       // Member variable
    static int age = 10;
    void eat() {
        System.out.println(name + " eats food.");
    }
}

// Subclass
class Dog extends Animal {
    String breed;      // Additional member variable
    int age;
    void bark() {
        System.out.println(name + " the " + breed + " barks.");
        System.out.println(" Age " + age);
        System.out.println(" Age " + Animal.age);
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.name = "Buddy";
        myDog.breed = "Golden Retriever";

        myDog.eat();   // Inherited method
        myDog.bark();  // Subclass method
    }
}