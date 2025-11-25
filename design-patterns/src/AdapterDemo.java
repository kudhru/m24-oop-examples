public class AdapterDemo {

    // ===== Target interface (what Canvas expects) =====
    interface Shape {
        void draw();
    }

    // A normal shape (just to show it works)
    static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Circle");
        }
    }

    // ===== Adaptee (legacy class we cannot change) =====
    static class LegacyRectangle {
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

    // ===== Object Adapter: implements Shape, wraps LegacyRectangle =====
    static class RectangleAdapter implements Shape {

        private final LegacyRectangle rectangle;

        // We accept x,y,width,height to match typical Shape thinking
        public RectangleAdapter(int x, int y, int width, int height) {
            // convert to (x1, y1, x2, y2) for LegacyRectangle
            this.rectangle = new LegacyRectangle(x, y, x + width, y + height);
        }

        @Override
        public void draw() {
            // Adapt Shape.draw() to LegacyRectangle.drawRectangle()
            rectangle.drawRectangle();
        }
    }

    // ===== Canvas: existing code that works with Shape only =====
    static class Canvas {
        public static void drawShape(Shape shape) {
            System.out.println("Canvas: preparing to draw...");
            shape.draw();
            System.out.println("Canvas: done.\n");
        }
    }

    public static void main(String[] args) {

        // ------- This part compiles and runs fine -------
        Circle circle = new Circle();
        Canvas.drawShape(circle);

        // ------- This would NOT compile (uncomment and see) -------
        // LegacyRectangle legacyRect = new LegacyRectangle(10, 20, 40, 60);
        // Canvas.drawShape(legacyRect); // ❌ incompatible types

        // ------- With Adapter: now it works -------
        Shape rect = new RectangleAdapter(10, 20, 30, 40);
        Canvas.drawShape(rect);
    }
}
