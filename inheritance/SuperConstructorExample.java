// Superclass
class Animal {
    String name;
    int age;

    // Parameterized constructor
    Animal(String n, int a) {
        name = n;
        age = a;
        System.out.println("Animal constructor called.");
    }

//    Animal() {
//        name = "";
//        age = -1;
//    }

    void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Subclass
class Dog extends Animal {
    String breed;

    // Constructor of subclass using super to call superclass constructor
    Dog(String n, int a, String b) {
        // super(n, a);  // Calls Animal's constructor
        breed = b;
        System.out.println("Dog constructor called.");
    }

    void displayDetails() {
        displayInfo();  // Inherited method
        System.out.println("Breed: " + breed);
    }
}

public class SuperConstructorExample {
    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy", 3, "Golden Retriever");
        myDog.displayDetails();
    }
}