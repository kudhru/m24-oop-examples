class Animal {
    // Final method - cannot be overridden
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Animal2 {
    // Final method - cannot be overridden
    void drink() {
        System.out.println("New Animal is eating");
    }
}

// class Dog extends Animal, Animal2 {
    // void eat() {
    //     System.out.println("Dog is eating");
    // }
// }

class Dog extends Animal {
    void eat() {
        System.out.println("Dog is eating");
    }
}

class GermanShepherd extends Dog {
    // Attempt to override eat() will cause a compile-time error
    // void eat() {
    //     System.out.println("German Shepherd is eating");
    // }
}

class FinalMethodOverriding {
    public static void main(String args[]) {
        Dog dog = new Dog();
        dog.eat(); 

        // Dog germanShepherd = new GermanShepherd();
        // germanShepherd.eat(); 

        // Animal g = new GermanShepherd();
        // g.eat();
    }
}