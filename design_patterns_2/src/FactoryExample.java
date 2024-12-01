// Shape Interface
interface Shape {
    void draw();
}

// Concrete Implementations
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// Factory Class
class ShapeFactory {
    // Factory Method
    public static Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        switch (shapeType.toLowerCase()) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "square":
                return new Square();
            default:
                return null;
        }
    }
}

// Testing the Shape Factory
public class FactoryExample {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape("circle");
        Shape rectangle = ShapeFactory.getShape("rectangle");
        Shape square = ShapeFactory.getShape("square");

        circle.draw();      // Output: Drawing a Circle
        rectangle.draw();   // Output: Drawing a Rectangle
        square.draw();      // Output: Drawing a Square
    }
}
