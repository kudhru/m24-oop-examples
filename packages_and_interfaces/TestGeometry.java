// package packages_and_interfaces;

import geometry.CircleP;
import geometry.RectangleP;
import geometry.TriangleP;
// import geometry.*;

public class TestGeometry {
    public static void main(String[] args) {
        CircleP circle = new CircleP(5.0);
        RectangleP rectangle = new RectangleP(10, 5);
        TriangleP triangle = new TriangleP(8, 4);

        System.out.println("Circle Area: " + circle.area());
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Triangle Area: " + triangle.area());
    }
}
