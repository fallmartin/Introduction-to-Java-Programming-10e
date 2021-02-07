package convexhull;

import java.awt.geom.Point2D;
import java.util.*;

/**
 * (Geometry: gift-wrapping algorithm for finding a convex hull) Section 22.10.1
 * introduced the gift-wrapping algorithm for finding a convex hull for a set of
 * points. Assume that the Java’s coordinate system is used for the points.
 * Implement the algorithm using the following method:
 *
 * Return the points that form a convex hull
 * public static ArrayList<Point2D> getConvexHull(double[][] s)
 *
 *
 * Point2D is defined in Section 9.6.
 * Write a test program that prompts the user to enter the set size and the
 * points and displays the points that form a convex hull. Here is a sample run:
 *
 * How many points are in the set? 6
 * Enter 6 points: 1 2.4 2.5 2 1.5 34.5 5.5 6 6 2.4 5.5 9
 * The convex hull is
 * (1.5, 34.5) (5.5, 9.0) (6.0, 2.4) (2.5, 2.0) (1.0, 2.4)
 *
 * Output:
 * How many points are in the set? 6
 * Enter 6 points: 1 2.4 2.5 2 1.5 34.5 5.5 6 6 2.4 5.5 9
 * The convex hull is
 * (1.5, 34.5) (5.5, 9.0) (6.0, 2.4) (2.5, 2.0) (1.0, 2.4)
 *
 * @author martinfall
 */
public class ConvexHull {

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Accept input for number of points in the set
        System.out.print("How many points are in the set? ");
        int numberOfPoints = input.nextInt();

        // Create a points two-dimensional array
        double[][] s = new double[numberOfPoints][2];

        // Accept input for points x and y coordinates
        System.out.printf("Enter %d points: ", numberOfPoints);
        for (int i = 0; i < numberOfPoints; i++) {
            s[i][0] = input.nextDouble();
            s[i][1] = input.nextDouble();
        }

        ArrayList<Point2D> convexHull = getConvexHull(s);
        System.out.println("The convex hull is");
        for (Point2D p : convexHull) {
            System.out.printf("(%.1f, %.1f) ", p.getX(), p.getY());
        }

        // Terminate the current line 
        System.out.println();
    }

    /**
     * Return the points that form a convex hull.
     *
     * @param s
     * @return
     */
    public static ArrayList<Point2D> getConvexHull(double[][] s) {

        /*
         * Step 1: Given a list of points S, let the points in S be labeled s0,
         * s1, ..., sk. Select the rightmost lowest point in S. As shown in
         * Figure 22.9a, h0 is such a point. Add h0 to list H. (H is initially
         * empty. H will hold all points in the convex hull after the algorithm
         * is finished.) Let t0 be h0.
         */
        // Convert the double array to a list
        ArrayList<Point2D> S = new ArrayList<>();
        for (double[] xy : s) {
            S.add(new Point2D.Double(xy[0], xy[1]));
        }

        // Comparator that sorts on Y (rightmost) then on X (lowest) in reverse
        Comparator<Point2D> comparator = Comparator
                .comparing(Point2D::getY)
                .thenComparing(Point2D::getX).reversed();

        // Sort a copy of points using the comparactor above
        ArrayList<Point2D> throwaway = new ArrayList<>(S);
        throwaway.sort(comparator);

        // Select the rightmost lowest point h0 in S
        Point2D h0 = throwaway.get(0);

        // Create an array list H to hold all points in the convex hull
        ArrayList<Point2D> H = new ArrayList<>();

        // Add h0 to H
        H.add(h0);

        /*
         * Step 2: Let t1 be s0.
         * For every point p in S,
         * if p is on the right side of the direct line from t0 to t1, then let
         * t1 be p.
         *
         * (After Step 2, no points lie on the right side of the direct line
         * from t0 to t1, as shown in Figure 22.9b.)
         * Step 3: If t1 is h0 (see Figure 22.9d), the points in H form a convex
         * hull for S. Otherwise, add t1 to H, let t0 be t1, and go back to Step
         * 2 (see Figure 22.9c).
         */
        // Let t0 be h0
        // Point2D t0 = (Point2D) h0.clone(); // Deep or shallow copy?
        Point2D t0 = h0;

        // Display S, h0, and t0 to console
        // System.out.println("S: " + S);
        // Boolean flag and index k
        boolean isConvexHull = false;
        int k = 0;

        //
        while (!isConvexHull && k < S.size()) {
            // Let t1 be s0
            Point2D t1 = S.get(k);

            for (Point2D p : S) {
                if (isValid(t0, t1, p)) {
                    t1 = p;
                }
            }

            if (t1 == h0) {
                isConvexHull = true;
            } else {
                H.add(t1);
                t0 = t1;
                k++;
            }
        }

        return H;
    }

    /**
     * Returns true if p is on the right side of the line from t0 to t1. The
     * method uses a determinant value to determine the position of point p in
     * relation to the line from t0 to t1.
     *
     * @param t0
     * @param t1
     * @param p
     * @return
     */
    public static boolean isValid(Point2D t0, Point2D t1, Point2D p) {
        double x0 = t0.getX();
        double y0 = t0.getY();
        double x1 = t1.getX();
        double y1 = t1.getY();
        double x2 = p.getX();
        double y2 = p.getY();

        return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) > 0;
    }
}
