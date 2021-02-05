package closestpair;

import java.util.*;

/**
 * Represents a Pair of points and a method named getDistance() that returns the
 * distance between the two points.
 *
 * @author martinfall
 */
public class Pair {

    private Point p1;
    private Point p2;

    /**
     * No-args constructor of the Pair class.
     *
     * @param p1
     * @param p2
     */
    public Pair(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Returns the distance between the pair of points.
     *
     * @return
     */
    public double getDistance() {
        return distance(p1, p2);
    }

    /**
     * Compute the distance between two points p1 and p2.
     *
     * @param p1
     * @param p2
     * @return
     */
    public static double distance(Point p1, Point p2) {
        return distance(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    /**
     * Compute the distance between points (x1, y1) and (x2, y2).
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    /**
     * Return the distance of the closest pair of points in
     * pointsOrderedOnX[low..high]. This is a recursive method. pointsOrderedOnX
     * and pointsOrderedOnY are not changed in the subsequent recursive calls.
     *
     * @param pointsOrderedOnX
     * @param low
     * @param high
     * @param pointsOrderedOnY
     * @return
     */
    public static Pair distance(Point[] pointsOrderedOnX, int low, int high,
            Point[] pointsOrderedOnY) {
        /**
         * Step 2: Divide S into two subsets, S1 and S2, of equal size using the
         * midpoint in the sorted list. Let the midpoint be in S1. Recursively
         * find the closest pair in S1 and S2. Let d1 and d2 denote the distance
         * of the closest pairs in the two subsets, respectively.
         */
        // Zero or one point in the array
        if (low >= high) {
            return null;
        } // Two points in the array
        else if (low + 1 == high) {
            return new Pair(pointsOrderedOnX[low], pointsOrderedOnX[high]);
        }

        // Find the midpoint in the sorted list
        int midpoint = (low + high) / 2;

        // Recursively find the closest pair in the left and right half-arrays
        // The midpoing is in the left subset S1 
        Pair leftPair = distance(pointsOrderedOnX, low, midpoint, pointsOrderedOnY);
        Pair rightPair = distance(pointsOrderedOnX, midpoint + 1, high, pointsOrderedOnY);

        // Find the pair of points with the shortest distance between left and right
        Pair p = null;
        double d = 0;

        // If no pairs exist on the left and right sides
        if (leftPair == null && rightPair == null) {
            d = Double.MAX_VALUE;
        } // If the left pair is null, the right side is the shortest
        else if (leftPair == null) {
            p = rightPair;
            d = rightPair.getDistance();
        } // If the right pair is null, the left side is the shortest
        else if (rightPair == null) {
            p = leftPair;
            d = leftPair.getDistance();
        } // Compare the pairs and return the one with the shortest distance 
        else {
            p = (leftPair.getDistance() <= rightPair.getDistance())
                    ? leftPair
                    : rightPair;
            d = Math.min(leftPair.getDistance(), rightPair.getDistance());
        }

        // Create two array lists stripL and stripR to hold the points
        ArrayList<Point> stripL = new ArrayList<>();
        ArrayList<Point> stripR = new ArrayList<>();

        // LISTING 22.9 Algorithm for Obtaining stripL and stripR
        // 1 for each point p in pointsOrderedOnY
        // 2    if (p is in S1 and mid.x – p.x <= d)
        // 3        append p to stripL;
        // 4    else if (p is in S2 and p.x - mid.x <= d) 
        // 5        append p to stripR;
        for (int i = 0; i < pointsOrderedOnY.length; i++) {
            if ((pointsOrderedOnY[i].getX() <= pointsOrderedOnX[midpoint].getX())
                    && (pointsOrderedOnX[midpoint].getX() - pointsOrderedOnY[i].getX() <= d)) {
                stripL.add(pointsOrderedOnY[i]);
            } else {
                stripR.add(pointsOrderedOnY[i]);
            }
        }

        // LISTING 22.10 Algorithm for Finding the Closest Pair in Step 3
        // d = min(d1, d2); handled on line 115
        int r = 0; // r is the index of a point in stripR

        // for each point p in stripL
        for (int i = 0; i < stripL.size(); i++) {
            // Skip the points in stripR below p.y - d
            while (r < stripR.size()
                    && stripR.get(r).getY() < stripL.get(i).getY() - d) {
                r++;
            }

            int r1 = r;

            while (r1 < stripR.size()
                    && Math.abs(stripR.get(r1).getY() - stripL.get(i).getY()) <= d) {
                if (distance(stripL.get(i), stripR.get(r1)) < d) {
                    d = distance(stripL.get(i), stripR.get(r1));
                    p = new Pair(stripL.get(i), stripR.get(r1));
                }
                r1++;
            }
        }

        // Return the closest pair of points
        return p;
    }

    /**
     * Return the distance of the closest pair of points.
     *
     * @param points
     * @return
     */
    public static Pair getClosestPair(double[][] points) {
        // Create an array of Point objects
        Point[] pointsArray = new Point[points.length];

        // Copy the contents of points into pointsArray at Point reference types
        for (int i = 0; i < pointsArray.length; i++) {
            pointsArray[i] = new Point(points[i][0], points[i][1]);
        }
        return getClosestPair(pointsArray);
    }

    /**
     * Return the distance of the closest pair of points.
     *
     * @param points
     * @return
     */
    public static Pair getClosestPair(Point[] points) {
        /**
         * Step 1: Sort the points in increasing order of x-coordinates. For the
         * points with the same x-coordinates, sort on y-coordinates. This
         * results in a sorted list S of points.
         */
        // Clone points and sort in increasing order of x-coordinates
        Point[] pointsOrderedOnX = points.clone();
        Arrays.sort(pointsOrderedOnX);

        // // Clone points and sort in increasing order of y-coordinates
        Point[] pointsOrderedOnY = points.clone();
        Arrays.sort(pointsOrderedOnY, new CompareY());

        // Local convenience variables for low and high
        int low = 0;
        int high = points.length - 1;

        return distance(pointsOrderedOnX, low, high, pointsOrderedOnY);
    }

    @Override // Override the toString method of the Object class
    public String toString() {
        return "The closest points are " + p1 + " and " + p2
                + "\nThe distance between the two points is " + distance(p1, p2);
    }
}
