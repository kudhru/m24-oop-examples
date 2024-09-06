interface Drawable {
    void draw();
}

class Circle implements Drawable {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Drawable {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

public class InterfaceClass {
    public static void main(String[] args) {
        Drawable shape;  // Interface reference
        
        shape = new Circle();
        shape.draw();   // Calls Circle's draw method
        
        shape = new Rectangle();
        shape.draw();   // Calls Rectangle's draw method
    }
}
