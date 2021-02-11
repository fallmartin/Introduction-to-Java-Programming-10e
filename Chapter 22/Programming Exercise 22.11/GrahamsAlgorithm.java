package grahamsalgorithm;

import java.util.*;

/**
 * (Geometry: Graham’s algorithm for finding a convex hull) Section 22.10.2
 * introduced Graham’s algorithm for finding a convex hull for a set of points.
 * Assume that the Java’s coordinate system is used for the points. Implement
 * the algorithm using the following method: (See Liang p.856).
 *
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
 * The rightmost lowest point is (1.5, 34.5)
 *
 * S: [(1.5, 34.5), (5.5, 9.0), (5.5, 6.0), (6.0, 2.4), (2.5, 2.0), (1.0, 2.4)]
 *
 * H: [(1.5, 34.5), (5.5, 9.0), (5.5, 6.0)]
 *
 * Finding the convex hull...
 *
 * t1: (5.5, 6.0)
 * t2: (5.5, 9.0)
 * pi: (6.0, 2.4)
 * Popping the top element off stack H
 * H: [(1.5, 34.5), (5.5, 9.0)]
 *
 * t1: (5.5, 9.0)
 * t2: (1.5, 34.5)
 * pi: (6.0, 2.4)
 * Pushing (6.0, 2.4) to H
 *
 * t1: (6.0, 2.4)
 * t2: (5.5, 9.0)
 * pi: (2.5, 2.0)
 * Pushing (2.5, 2.0) to H
 *
 * t1: (2.5, 2.0)
 * t2: (6.0, 2.4)
 * pi: (1.0, 2.4)
 * Pushing (1.0, 2.4) to H
 *
 * Done: [(1.5, 34.5), (5.5, 9.0), (6.0, 2.4), (2.5, 2.0), (1.0, 2.4)]
 *
 * The convex hull is
 * (1.5, 34.5) (5.5, 9.0) (6.0, 2.4) (2.5, 2.0) (1.0, 2.4)
 *
 * @author martinfall
 */
public class GrahamsAlgorithm {

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner
        try ( Scanner input = new Scanner(System.in)) {
            // Accept input for the number of points
            System.out.print("How many points are in the set? ");
            int numberOfPoints = input.nextInt();

            // Create a two-dimensional array of type double to store points
            double[][] s = new double[numberOfPoints][2];

            // Accept input for the coordinates x and y of each point
            System.out.printf("Enter %d points: ", numberOfPoints);
            for (int i = 0; i < numberOfPoints; i++) {
                s[i][0] = input.nextDouble();
                s[i][1] = input.nextDouble();
            }

            // Display the points to the console
            ArrayList<MyPoint> convexHull = getConvexHull(s);

            // Display the results to the console
            System.out.println("\nThe convex hull is");
            for (MyPoint point : convexHull) {
                System.out.print(point + " ");
            }
            System.out.println(); // The program exits here. 
        }
    }

    /**
     * Return the points that form a convex hull.
     *
     * @param s
     * @return
     */
    public static ArrayList<MyPoint> getConvexHull(double[][] s) {
        /**
         * Step 1: Given a list of points S, select the rightmost lowest point
         * and name it p0. As shown in Figure 22.10a, p0 is such a point.
         */
        // Convert the double array to a list
        ArrayList<MyPoint> S = new ArrayList<>();
        for (double[] xy : s) {
            S.add(new MyPoint(xy[0], xy[1]));
        }

        // Select the rightmost lowest point and name it p0
        MyPoint p0 = getRightMostLowestPoint(S);

        // Remove p0 from S
        S.remove(p0);

        // Display p0 to the console
        System.out.println("The rightmost lowest point is " + p0);

        // Set the rightMostLowestPoint value in each remaining point
        for (MyPoint p : S) {
            p.setRightMostLowestPoint(p0);
        }

        /**
         * Step 2: Sort the points in S angularly along the x-axis with p0 as
         * the center, as shown in Figure 22.10b. If there is a tie and two
         * points have the same angle, discard the one that is closer to p0. The
         * points in S are now sorted as p0, p1, p2, ..., pn-1.
         */
        // Sort the array list S
        Collections.sort(S);

        // Remove the points that are marked to be deleted
        ArrayList<MyPoint> copyS = new ArrayList<>(S);
        for (MyPoint point : copyS) {
            if (point.keep == false) {
                S.remove(point);
            }
        }

        // Insert p0 at the start of the list S as required
        S.add(0, p0);

        // Print the sorted array list to the console
        System.out.println("\nS: " + S);

        /**
         * Step 3: Push p0, p1, and p2 into stack H. (After the algorithm
         * finishes, H contains all the points in the convex hull.)
         */
        Stack<MyPoint> H = new Stack<>();
        H.push(S.get(0)); // p0
        H.push(S.get(1)); // p1
        H.push(S.get(2)); // p2

        // Display H to the console
        System.out.println("\nH: " + H + "\n");
        System.out.println("Finding the convex hull...\n");

        /**
         * Step 4: see Liang p.874 for algorithm steps.
         */
        int i = 3;
        while (i < S.size()) {
            // Let t1 and t2 be the top first and second element in stack H
            MyPoint t1 = H.get(H.size() - 1);
            MyPoint t2 = H.get(H.size() - 2);

            System.out.println("t1: " + t1);
            System.out.println("t2: " + t2);

            // If pi is on the left side of the direct line from t2 to t1
            MyPoint pi = S.get(i);
            System.out.println("pi: " + pi);

            // isValid returns true if cross product is negative, which means
            // that pi on the left side of the direct line from t2 to t1
            if (isValid(t2, t1, pi)) {
                // Push pi to H
                System.out.println("Pushing " + pi + " to H");
                H.push(pi);
                System.out.println();
                i++; // Consider the next point in S.
            } else {
                // Pop the top element off stack H
                System.out.println("Popping the top element off stack H");
                H.pop();
                System.out.println("H: " + H + "\n");
            }
        }

        /**
         * Step 5: The points in H form a convex hull.
         */
        System.out.println("Done: " + H);
        return new ArrayList<>(H);
    }

    /**
     * Returns the rightmost lowest element in the array list of MyPoint
     * objects.
     *
     * @param S
     * @return
     */
    private static MyPoint getRightMostLowestPoint(ArrayList<MyPoint> S) {
        // Sort S list according to the order induced by the comparator
        S.sort(new Comparator<MyPoint>() {
            @Override
            public int compare(MyPoint o1, MyPoint o2) {
                if (o1.y > o2.y) {
                    return -1;
                } else if (o1.y < o2.y) {
                    return 1;
                } else {
                    if (o1.x > o2.x) {
                        return -1;
                    } else if (o1.x < o2.x) {
                        return 1;
                    }
                }
                return 0;
            }
        });

        // Return the first element in the sorted list
        return S.get(0);
    }

    /**
     * Return true is pi is left of the line formed by t2 and t1.
     *
     * @param t2
     * @param t1
     * @param pi
     * @return
     */
    private static boolean isValid(MyPoint t2, MyPoint t1, MyPoint pi) {
        return (pi.y - t2.y) * (t1.x - t2.x) < (pi.x - t2.x) * (t1.y - t2.y);
    }

    /**
     * MyPoint is a static inner class.
     */
    private static class MyPoint implements Comparable<MyPoint> {

        double x, y;
        boolean keep; // keep if true, discard if false

        MyPoint rightMostLowestPoint;

        MyPoint(double x, double y) {
            this.x = x;
            this.y = y;
            keep = true;
        }

        public void setRightMostLowestPoint(MyPoint p) {
            rightMostLowestPoint = p;
        }

        /**
         * Returns the measure of the angle formed by the x-axis and the point
         * in degrees.
         *
         * @return
         */
        public double getTheta() {
            double dy = rightMostLowestPoint.y - y; // delta y
            double dx = x - rightMostLowestPoint.x; // delta x
            double theta = Math.atan2(dy, dx);
            theta *= 180 / Math.PI;
            return theta;
        }

        public double getDistance() {
            double x2 = rightMostLowestPoint.x;
            double y2 = rightMostLowestPoint.y;
            return Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
        }

        @Override // Override the compareTo method of the Comparable interface
        public int compareTo(MyPoint o) {
            /**
             * Implement it to compare this point with point o angularly along
             * the x-axis with rightMostLowestPoint as the center, as shown in
             * Figure 22.10b. By implementing the Comparable interface, you can
             * use the Array.sort method to sort the points to simplify coding.
             */
            if (getTheta() < o.getTheta()) {
                return -1;
            } else if (getTheta() > o.getTheta()) {
                return 1;
            } else { // If two points have the same angle
                // Mark the closest one to p0 for deletion by setting keep to false
                MyPoint closest = getDistance() < o.getDistance() ? this : o;
                closest.keep = false;
                return 0;
            }
        }

        @Override // Override the toString method of the Object class
        public String toString() {
            return String.format("(%.1f, %.1f)", x, y);
        }
    }
}
