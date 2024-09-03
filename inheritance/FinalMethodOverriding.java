class Animal {
    // Final method - cannot be overridden
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    final void eat() {
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
        // Dog dog = new Dog();
        // dog.eat(); 

        // Dog germanShepherd = new GermanShepherd();
        // germanShepherd.eat(); 

        Animal g = new GermanShepherd();
        g.eat();
    }
}