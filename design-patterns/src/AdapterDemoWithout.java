// Canvas code written long ago – cannot change now
interface Shape {
    void draw();
}

class Circle implements Shape1 {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Canvas {
    // Framework method – expects Shape
    public static void drawShape(Shape1 shape) {
        System.out.println("Canvas: preparing to draw...");
        shape.draw();
        System.out.println("Canvas: done.\n");
    }
}

// Legacy library – you are not allowed to modify this code
class LegacyRectangle {
    private int x1, y1; // top-left
    private int x2, y2; // bottom-right

    public LegacyRectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1; this.y1 = y1;
        this.x2 = x2; this.y2 = y2;
    }

    public void drawRectangle() {
        System.out.println("LegacyRectangle: drawing from (" + x1 + "," + y1 +
                ") to (" + x2 + "," + y2 + ")");
    }
}

public class AdapterDemoWithout {

    public static void main(String[] args) {
        Circle circle = new Circle();
        Canvas.drawShape(circle);  // ✅ works

        LegacyRectangle1 rect = new LegacyRectangle1(10, 20, 40, 60);
        Canvas.drawShape(rect);    // ❌ DOES NOT COMPILE
    }
}
