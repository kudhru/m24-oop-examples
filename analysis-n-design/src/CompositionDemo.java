/*
3. Composition (Has-A Relationship - Strong)
Composition is a stronger "has-a" relationship where the contained object's lifecycle is managed by 
the containing object. 
If the container is destroyed, the contained object is also destroyed.

Instance Variable (Creation within Constructor): The composed object is typically created within 
the constructor of the composing object, making its lifecycle dependent on the composing object.

*/

class Engine {
    void start() {
        System.out.println("Engine started.");
    }
}

class Car {
    Engine engine; // Composition: Car has an Engine

    public Car() {
        this.engine = new Engine(); // Engine is created and managed by Car
    }

    void drive() {
        engine.start();
        System.out.println("Car is driving.");
    }
}

public class CompositionDemo {
	public void main() {
		// Client code
		Car myCar = new Car(); // Creating a Car also creates its Engine
		myCar.drive();
		// If myCar is destroyed, its engine instance is also effectively gone.
	}
}
