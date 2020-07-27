
/**
 * (Enable GeometricObject comparable) Modify the GeometricObject class to
 * implement the Comparable interface, and define a static max method in the
 * GeometricObject class for finding the larger of two GeometricObject objects.
 * Draw the UML diagram and implement the new GeometricObject class. Write a test
 * program that uses the max method to find the larger of two circles and the
 * larger of two rectangles.
 *
 * Output:
 * Largest circle area: 50.26548245743669
 * Largest rectangle area: 4.0
 *
 * @author martinfall
 */
public class TestGeometricObject {

    public static void main(String[] args) {
        // Create two Circle objects
        GeometricObject c1 = new Circle(2);
        GeometricObject c2 = new Circle(4);
        // Display the largest of the two Circle objects
        Circle largestCircle = (Circle) GeometricObject.max(c1, c2);
        System.out.println("Largest circle area: " + largestCircle.getArea());

        // Create two Rectangle objects
        GeometricObject r1 = new Rectangle(1, 1);
        GeometricObject r2 = new Rectangle(2, 2);
        // Display the largest of the two Rectangle objects
        Rectangle largestRectangle = (Rectangle) GeometricObject.max(r1, r2);
        System.out.println("Largest rectangle area: " + largestRectangle.getArea());
    }
}
