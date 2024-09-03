// Abstract superclass
abstract class Shape {
    double dim1, dim2;

    Shape(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    // Abstract method
    abstract double area();
}

// Subclass Rectangle
class Rectangle extends Shape {
    Rectangle(double a, double b) {
        super(a, b);
    }

    // Implementing abstract method
    double area() {
        return dim1 * dim2;
    }
}

// Subclass Triangle
class Triangle extends Shape {
    Triangle(double a, double b) {
        super(a, b);
    }

    // Implementing abstract method
    double area() {
        return dim1 * dim2 / 2;
    }
}

// Demonstration of Abstract Classes
class AbstractClassExample {
    public static void main(String args[]) {
        Shape shapeRef;  // Abstract class reference
        
        shapeRef = new Rectangle(10, 5);
        System.out.println("Area of Rectangle: " + shapeRef.area());

        shapeRef = new Triangle(10, 5);
        System.out.println("Area of Triangle: " + shapeRef.area());

        // Shape shape = new Shape(10, 5); // will throw an error
    }
}