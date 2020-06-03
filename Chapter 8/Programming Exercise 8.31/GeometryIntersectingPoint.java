
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Geometry: intersecting point) Write a method that returns the intersecting
 * point of two lines. The intersecting point of the two lines can be found by
 * using the formula shown in Programming Exercise 3.25.
 *
 * Assume that (x1, y1) and (x2, y2) are the two points on line 1 and (x3, y3)
 * and
 * (x4, y4) are on line 2. The method header is
 *
 * public static double[] getIntersectingPoint(double[][] points)
 *
 * The points are stored in a 4-by-2 two-dimensional array points with
 * (points[0][0], points[0][1]) for (x1, y1). The method returns the
 * intersecting
 * point or null if the two lines are parallel. Write a program that prompts
 * the user to enter four points and displays the intersecting point.
 * See Programming Exercise 3.25 for a sample run.
 *
 * Output:
 * Enter x1, y1, x2, y2, x3, y3, x4, y4: 2 2 5 -1.0 4.0 2.0 -1.0 -2.0
 * x is 2.89 and y is -1.11
 *
 * Enter x1, y1, x2, y2, x3, y3, x4, y4: 2 2 7 6.0 4.0 2.0 -1.0 -2.0
 * The equation has no solutions.
 *
 * @author martinfall
 */
public class GeometryIntersectingPoint {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Create a new array to store points
        double[][] points = new double[4][2];

        // Prompt the user to entter four pointts
        System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
        for (int row = 0; row < points.length; row++) {
            for (int column = 0; column < points[row].length; column++) {
                points[row][column] = input.nextDouble();
            }
        }

        // Display the intersecting point
        double[] solution = getIntersectingPoint(points);
        System.out.printf("x is %.2f and y is %.2f%n", solution[0], solution[1]);
    }

    public static double[] getIntersectingPoint(double[][] points) {
        // (x1, y1)
        double x1 = points[0][0];
        double y1 = points[0][1];

        // (x2, y2)
        double x2 = points[1][0];
        double y2 = points[1][1];

        // (x3, y3)
        double x3 = points[2][0];
        double y3 = points[2][1];

        // (x4, y4)
        double x4 = points[3][0];
        double y4 = points[3][1];

        // (y1 - y2)x - (x1 - x2)y = (y1 - y2)x1 - (x1 - x2)y1
        // (y3 - y4)x - (x3 - x4)y = (y3 - y4)x3 - (x3 - x4)y3
        double a = y1 - y2;
        double b = x1 - x2;
        double e = (y1 - y2) * x1 - (x1 - x2) * y1;

        double c = y3 - y4;
        double d = x3 - x4;
        double f = (y3 - y4) * x3 - (x3 - x4) * y3;

        // Solve the linear equation using Cramer’s rule
        // x = (e * d - b * f) / (a * d - b * c)
        // y = (a * f - e * c) / (a * d - b * c)
        // Create an array for x and y solution coordinates
        double[] solution = new double[2];

        // If the equation has no solutions, the two lines are parallel
        if ((a * d - b * c) == 0) {
            // The two lines are parallel
            System.out.println("The equation has no solutions.");
            System.exit(0); // Exit without an error code
        } else {
            // Calculate x and y and store in the solution array
            solution[0] = (e * d - b * f) / (a * d - b * c);
            solution[1] = (a * f - e * c) / (a * d - b * c);
        }
        // System.out.println(Arrays.toString(solution));
        return solution;
    }
}
