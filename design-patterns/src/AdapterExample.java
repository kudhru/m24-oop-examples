// Target interface: what client code expects
interface Shape1 {
    void draw();
}

// Adaptee: existing/legacy class with a different interface
class LegacyRectangle1 {
    private int x1, y1; // top-left
    private int x2, y2; // bottom-right

    public LegacyRectangle1(int x1, int y1, int x2, int y2) {
        this.x1 = x1; this.y1 = y1;
        this.x2 = x2; this.y2 = y2;
    }

    // Legacy method
    public void drawRectangle() {
        System.out.println("Drawing rectangle from (" + x1 + "," + y1 +
                ") to (" + x2 + "," + y2 + ")");
    }
}

// ===== 1. CLASS ADAPTER (extends Adaptee, implements Target) =====
class RectangleClassAdapter extends LegacyRectangle1 implements Shape1 {

    public RectangleClassAdapter(int x, int y, int width, int height) {
        // convert (x, y, width, height) to (x1, y1, x2, y2)
        super(x, y, x + width, y + height);
    }

    @Override
    public void draw() {
        // Adapt Shape.draw() to LegacyRectangle.drawRectangle()
        drawRectangle(); // inherited from LegacyRectangle
    }
}

// ===== 2. OBJECT ADAPTER (has-a Adaptee, implements Target) =====
class RectangleObjectAdapter implements Shape1 {

    private LegacyRectangle1 rectangle; // composition

    public RectangleObjectAdapter(int x, int y, int width, int height) {
        this.rectangle = new LegacyRectangle1(x, y, x + width, y + height);
    }

    @Override
    public void draw() {
        // Delegate to the adaptee
        rectangle.drawRectangle();
    }
}

public class AdapterExample {
    // ===== Client code to test both adapters =====
    public static void main(String[] args) {

        // Using CLASS ADAPTER
        Shape1 classAdapterShape = new RectangleClassAdapter(10, 20, 30, 40);
        System.out.println("Using Class Adapter:");
        classAdapterShape.draw();

        // Using OBJECT ADAPTER
        Shape1 objectAdapterShape = new RectangleObjectAdapter(50, 60, 70, 80);
        System.out.println("Using Object Adapter:");
        objectAdapterShape.draw();
    }
}
