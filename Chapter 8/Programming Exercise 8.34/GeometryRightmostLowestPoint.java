
import java.util.Scanner;

/**
 * (Geometry: rightmost lowest point) In computational geometry, often you need
 * to find the rightmost lowest point in a set of points. Write the following
 * method that returns the rightmost lowest point in a set of points.
 *
 * public static double[] getRightmostLowestPoint(double[][] points)
 *
 * Write a test program that prompts the user to enter the coordinates of six
 * points and displays the rightmost lowest point. Here is a sample run:
 *
 * Enter 6 points: 1.5 2.5 -3 4.5 5.6 -7 6.5 -7 8 1 10 2.5
 * The rightmost lowest point is (6.5, -7.0)
 *
 * Output:
 * Enter 6 points: 1.5 2.5 -3 4.5 5.6 -7 6.5 -7 8 1 10 2.5
 * The rightmost lowest point is (6.5, -7.0)
 *
 * @author martinfall
 */
public class GeometryRightmostLowestPoint {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the coordinates of six points
        System.out.print("Enter 6 points: ");

        // Create an array and populate it with user input
        double[][] points = new double[6][2];
        for (int row = 0; row < points.length; row++) {
            for (int column = 0; column < points[row].length; column++) {
                points[row][column] = input.nextDouble();
            }
        }

        // Pass the array to getRightmostLowestPoint and ave returned point in an array
        double[] point = getRightmostLowestPoint(points);

        // Display the result in the required format
        String format = "The rightmost lowest point is (%.1f, %.1f)%n";
        System.out.printf(format, point[0], point[1]);
    }

    public static double[] getRightmostLowestPoint(double[][] points) {
        double[] point = points[0];

        for (double[] element : points) {
            if (element[1] <= point[1]) {
                if (element[0] > point[0]) {
                    point = element;
                }
            }
        }

        return point;
    }
}
