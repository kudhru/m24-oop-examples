package geometry;

public class RectangleP {
    private double width, height;

    public RectangleP(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }
}
