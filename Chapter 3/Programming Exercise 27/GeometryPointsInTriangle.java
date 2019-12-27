
/**
 * (Geometry: points in triangle?) Suppose a right triangle is placed in a plane
 * as shown below. The right-angle point is placed at (0, 0), and the other two
 * points are placed at (200, 0), and (0, 100). Write a program that prompts the
 * user to enter a point with x- and y-coordinates and determines whether the
 * point is inside the triangle. Here are the sample runs:
 *
 * Enter a point's x- and y-coordinates: 100.5 25.5
 * The point is in the triangle
 *
 * Enter a point's x- and y-coordinates: 100.5 50.5
 * The point is not in the triangle
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class GeometryPointsInTriangle {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a point's x- and y-coordinates
        System.out.print("Enter a point's x- and y-coordinates: ");

        // Collect input from the user
        double x = input.nextDouble();
        double y = input.nextDouble();

        // Three inequalities to fulfill for the point to be in the triangle
        // Point is above the x-axis (y > 0)
        // Point is to the right of the y-axis (x > 0)
        // Point is above the hypotenuse y < 100 - x / 2
        if (x > 0 && y > 0 && y < (100 - x / 2)) {
            System.out.println("The point is in the triangle");
        } else {
            System.out.println("The point is not in the triangle");
        }
    }
}
