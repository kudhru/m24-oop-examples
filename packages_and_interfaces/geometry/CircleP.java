package geometry;

public class CircleP {
    private double radius;

    public CircleP(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}