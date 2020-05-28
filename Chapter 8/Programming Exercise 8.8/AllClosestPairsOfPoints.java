
import java.util.Scanner;

/**
 * (All closest pairs of points) Revise Listing 8.3, FindNearestPoints.java, to
 * display all closest pairs of points with the same minimum distance. Here is
 * a sample run:
 *
 * Enter the number of points: 8
 * Enter 8 points: 0 0 1 1 -1 -1 2 2 -2 -2 -3 -3 -4 -4 5 5
 * The closest two points are (0.0, 0.0) and (1.0, 1.0)
 * The closest two points are (0.0, 0.0) and (-1.0, -1.0)
 * The closest two points are (1.0, 1.0) and (2.0, 2.0)
 * The closest two points are (-1.0, -1.0) and (-2.0, -2.0)
 * The closest two points are (-2.0, -2.0) and (-3.0, -3.0)
 * The closest two points are (-3.0, -3.0) and (-4.0, -4.0)
 * Their distance is 1.4142135623730951
 *
 * @author martinfall
 */
public class AllClosestPairsOfPoints {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the number of points
        System.out.print("Enter the number of points: ");
        int numberOfPoints = input.nextInt();

        // Create an array to store points
        double[][] points = new double[numberOfPoints][2];
        System.out.print("Enter " + numberOfPoints + " points: ");
        for (int i = 0; i < points.length; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
        }

        // p1 and p2 are the indices in the points' array
        int p1 = 0, p2 = 1; // Initial two points
        double shortestDistance = distance(points[p1][0], points[p1][1],
                points[p2][0], points[p2][1]); // Initialize shortest distance

        // Compute the distance for every two points
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = distance(points[i][0], points[i][1],
                        points[j][0], points[j][1]); // Find distance

                if (shortestDistance > distance) {
                    p1 = i; // Update p1
                    p2 = j; // Update p2
                    shortestDistance = distance; // Update shortestDistance
                }
            }
        }

        // Display all closest pairs of points with the same minimum distance
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = distance(points[i][0], points[i][1],
                        points[j][0], points[j][1]); // Find distance

                if (distance(points[i][0], points[i][1]
                        , points[j][0], points[j][1]) == shortestDistance) {
                    System.out.println("The closest two points are "
                            + "(" + points[i][0] + ", " + points[i][1] + ") and ("
                            + points[j][0] + ", " + points[j][1] + ")");

                }
            }
        }

        System.out.println("Their distance is " + shortestDistance);
    }

    /**
     * Compute the distance between two points (x1, y1) and (x2, y2)
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}
