
/**
 * (Points nearest to each other) Listing 8.3 gives a program that finds two
 * points in a two-dimensional space nearest to each other. Revise the program
 * so
 * that it finds two points in a three-dimensional space nearest to each other.
 * Use a two-dimensional array to represent the points. Test the program using
 * the
 * following points:
 *
 * double[][] points = {{-1, 0, 3}, {-1, -1, -1}, {4, 1, 1},
 * {2, 0.5, 9}, {3.5, 2, -1}, {3, 1.5, 3}, {-1.5, 4, 2},
 * {5.5, 4, -0.5}};
 *
 * The formula for computing the distance between two points (x1, y1, z1) and
 * (x2, y2, z2) is (see textbook).
 *
 * The closest two points are (4.0, 1.0, 1.0) and (3.5, 2.0, -1.0)
 *
 * @author martinfall
 */
public class NearestTwoPoints {

    public static void main(String[] args) {

        // Create an array for points
        double[][] points
                = {{-1, 0, 3},
                {-1, -1, -1},
                {4, 1, 1},
                {2, 0.5, 9},
                {3.5, 2, -1},
                {3, 1.5, 3},
                {-1.5, 4, 2},
                {5.5, 4, -0.5}};

        // p1 and p2 are the indices in the points' array
        int p1 = 0, p2 = 1; // Initial two points
        double shortestDistance = distance(points[p1][0], points[p1][1], points[p1][2],
                points[p2][0], points[p2][1], points[p2][2]); // Initialize shortest distance

        // Compute the distance for every two points
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = distance(points[i][0], points[i][1], points[i][2],
                        points[j][0], points[j][1], points[j][2]); // Find distance

                if (shortestDistance > distance) {
                    p1 = i; // Update p1
                    p2 = j; // Update p2
                    shortestDistance = distance; // Update shortestDistance
                }
            }
        }

        // Display result
        System.out.println("The closest two points are "
                + "(" + points[p1][0] + ", " + points[p1][1] + ", " + points[p1][2] + ") and ("
                + points[p2][0] + ", " + points[p2][1] + ", " + points[p2][2] + ")");
    }

    /**
     * Compute the distance between two points (x1, y1, z1) and (x2, y2, z2)
     *
     * @param x1
     * @param y1
     * @param z1
     * @param x2
     * @param y2
     * @param z2
     * @return
     */
    public static double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt(Math.pow((x2 - x1), 2)
                + Math.pow((y2 - y1), 2)
                + Math.pow((z2 - z1), 2));
    }

}
