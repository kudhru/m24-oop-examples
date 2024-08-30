class Animal {
    String name;
    Animal(String n) {
        name = n;
    }
    void eat() {
        System.out.println(name + " eats.");
    }
}

class Mammal extends Animal {
    int age;
    Mammal(String n, int a) {
        super(n);
        age = a;
    }
    void move() {
        System.out.println(name + " moves.");
    }
}

class Dog extends Mammal {
    String breed;
    Dog(String n, int a, String b) {
        super(n, a);
        breed = b;
    }
    void bark() {
        System.out.println(name + " barks.");
    }
}

public class MultilevelHierarchyExample {
    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy", 3, "Golden Retriever");
        
        myDog.eat();   // Inherited from Animal
        myDog.move();  // Inherited from Mammal
        myDog.bark();  // Defined in Dog
    }
}