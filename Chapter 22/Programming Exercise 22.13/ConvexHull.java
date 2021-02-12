package convexhullanimation;

import java.util.*;
import javafx.scene.shape.Circle;

/**
 * The class ConvexHull contains the static method getConvexHull that returns an
 * array list of MyPoint objects that represents the convex hull of the points
 * in s.
 *
 * @author martinfall
 */
public class ConvexHull {

    /**
     * Return the points that form a convex hull.
     *
     * @param s
     * @return
     */
    public static ArrayList<MyPoint> getConvexHull(ArrayList<MyPoint> S) {
        /**
         * Step 1: Given a list of points S, select the rightmost lowest point
         * and name it p0. As shown in Figure 22.10a, p0 is such a point.
         */
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
    protected static class MyPoint
            extends Circle // Extends the Circle class of JavaFX
            implements Comparable<MyPoint> { // Implements comparable<MyPoint>

        double x, y;
        boolean keep; // keep if true, discard if false

        MyPoint rightMostLowestPoint;

        MyPoint(double x, double y) {
            this.x = x;
            this.y = y;
            keep = true;
            
            // Circle constructor
            setCenterX(x);
            setCenterY(y);
            setRadius(5);
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
            // If the current theta is less than the theta at point o
            if (getTheta() < o.getTheta()) {
                return -1;
            } // If the current theta is greater than the theta at point o
            else if (getTheta() > o.getTheta()) {
                return 1;
            } else { // If two points have the same theta
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
