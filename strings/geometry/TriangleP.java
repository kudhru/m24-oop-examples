package geometry;

public class TriangleP {
    private double base, height;

    public TriangleP(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double area() {
        return 0.5 * base * height;
    }
}
