
import java.util.Scanner;

/**
 * (Geometry: same line?) Programming Exercise 6.39 gives a method for testing
 * whether three points are on the same line. Write the following method to test
 * whether all the points in the array points are on the same line.
 *
 * public static boolean sameLine(double[][] points)
 *
 * Write a program that prompts the user to enter five points and displays
 * whether
 * they are on the same line. Here are sample runs:
 *
 * Enter five points: 3.4 2 6.5 9.5 2.3 2.3 5.5 5 -5 4
 * The five points are not on the same line
 *
 * Enter five points: 1 1 2 2 3 3 4 4 5 5
 * The five points are on the same line
 *
 * @author martinfall
 */
public class SameLineGeometry {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create an array
        double[][] points = createArray();

        System.out.println("The five points are"
                + (onTheSameLine(points) ? "" : " not") + " on the same line");
    }

    /**
     * Create an array and populate it with user input
     *
     * @return
     */
    public static double[][] createArray() {
        // Create a new array
        double[][] points = new double[5][2];

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter five points
        System.out.print("Enter five points: ");
        for (int row = 0; row < points.length; row++) {
            for (int column = 0; column < points[row].length; column++) {
                points[row][column] = input.nextDouble();
            }
        }
        return points;
    }

    /**
     * Check if points are on the same line
     *
     * @param points
     * @return
     */
    public static boolean onTheSameLine(double[][] points) {
        for (int i = 0; i < points.length - 2; i++) {
            if (getDeterminant(points[i][0], points[i][1], points[i + 1][0],
                    points[i + 1][1], points[i + 2][0], points[i + 2][1]) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculate the determinant
     *
     * @param x0
     * @param y0
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static double getDeterminant(
            double x0, double y0,
            double x1, double y1,
            double x2, double y2) {
        return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
    }
}
