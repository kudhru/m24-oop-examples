class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // // Override toString() to provide a meaningful string representation
    @Override
    public String toString() {
        // System.out.println(super.toString());
        return super.toString() + ".   Animal [name=" + name + ", age=" + age + "]";
    }

    // // Override equals() to compare Animal objects by name and age
    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj) return true;
    //     if (obj == null || getClass() != obj.getClass()) return false;
    //     Animal animal = (Animal) obj;
    //     return age == animal.age && name.equals(animal.name);
    // }
}

class ObjectClassExample {
    public static void main(String args[]) {
        Animal a1 = new Animal("Dog", 5);
        // Animal a2 = new Animal("Dog", 5);
        // Animal a3 = new Animal("Cat", 3);

        System.out.println(a1.toString());  // Outputs: Animal [name=Dog, age=5]
        // System.out.println(a1.equals(a2));  // Outputs: true
        // System.out.println(a1.equals(a3));  // Outputs: false
    }
}
