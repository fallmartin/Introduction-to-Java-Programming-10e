
import java.util.Scanner;

/**
 * (Geometry: the bounding rectangle) A bounding rectangle is the minimum
 * rectangle that encloses a set of points in a two-dimensional plane, as shown
 * in Figure 10.24d. Write a method that returns a bounding rectangle for a set
 * of points in a two-dimensional plane, as follows:
 *
 * public static MyRectangle2D getRectangle(double[][] points)
 *
 * The Rectangle2D class is defined in Programming Exercise 10.13. Write a
 * test program that prompts the user to enter five points and displays the
 * bounding
 * rectangle’s center, width, and height. Here is a sample run:
 *
 * Enter five points: 1.0 2.5 3 4 5 6 7 8 9 10
 * The bounding rectangle's center (5.0, 6.25), width 8.0, height 7.5
 *
 * Output:
 * Enter five points: 1.0 2.5 3 4 5 6 7 8 9 10
 * The bounding rectangle's center (5.00, 6.25), width 8.0, height 7.5
 *
 * @author martinfall
 */
public class TestMyRectangle2D {

    public static void main(String[] args) {
        // Create an array of x- and y-coordinates named points
        double[][] points = new double[5][2];

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter five points
        System.out.print("Enter five points: ");

        // Populate the array
        for (int i = 0; i < points.length; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
        }

        // Pass array points to getRectangle and save the Rectangle2D object that
        // the method returns to a variable boundingRectangle
        MyRectangle2D boundingRectangle = getRectangle(points);

        // Display the results
        System.out.println(boundingRectangle.toString());

    }

    /**
     * The method that returns a bounding rectangle for a set of points in a
     * two-dimensional plane
     *
     * @param points
     * @return
     */
    public static MyRectangle2D getRectangle(double[][] points) {
        double lowestX = points[0][0];
        double largestX = points[0][0];
        double lowestY = points[0][1];
        double largestY = points[0][1];

        // Find the lowest and highest values for x
        for (int row = 0; row < points.length; row++) {
            if (lowestX > points[row][0]) {
                lowestX = points[row][0];
            }

            if (largestX < points[row][0]) {
                largestX = points[row][0];
            }
        }

        // Find the lowest and highest values of y
        for (int row = 0; row < points.length; row++) {
            if (lowestY > points[row][1]) {
                lowestY = points[row][1];
            }

            if (largestY < points[row][1]) {
                largestY = points[row][1];
            }
        }

        // Declare variables to hold the parameters passed to create a rectable object
        double width = largestX - lowestX;
        double height = largestY - lowestY;
        double x = lowestX + (width / 2);
        double y = lowestY + (height / 2);

        return new MyRectangle2D(x, y, width, height);
    }
}
