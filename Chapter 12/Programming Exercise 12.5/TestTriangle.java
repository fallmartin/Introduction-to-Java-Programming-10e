
/**
 * Output:
 * Triangle: side1 = 1.0, side2 = 1.0, side3 = 1.0
 * Triangle: side1 = 2.0, side2 = 4.0, side3 = 3.0
 * IllegalTriangleException: Invalid Triangle
 *
 * @author martinfall
 */
public class TestTriangle {

    public static void main(String[] args) {
        try {
            // Create a Triangle object with the default no-args constructor
            Triangle triangle1 = new Triangle();
            System.out.println(triangle1.toString());
        } catch (IllegalTriangleException ex) {
            System.out.println(ex);
        }

        try {
            // Create a Triangle object with valid values
            Triangle triangle2 = new Triangle(2.0, 4.0, 3.0);
            System.out.println(triangle2.toString());
        } catch (IllegalTriangleException ex) {
            System.out.println(ex);
        }

        try {
            // Create a Triangle object with invalid values
            Triangle triangle3 = new Triangle(1.0, 2.0, 3.0);
            System.out.println(triangle3.toString());
        } catch (IllegalTriangleException ex) {
            System.out.println(ex);
        }
    }
}
