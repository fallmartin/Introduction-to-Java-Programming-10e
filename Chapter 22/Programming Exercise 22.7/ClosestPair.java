package closestpair;

import java.util.*;

/**
 * (Closest pair of points) Section 22.8 introduced an algorithm for finding the
 * closest pair of points using a divide-and-conquer approach. Implement the
 * algorithm to meet the following requirements:
 *
 * ■ Define the classes Point and CompareY in the same way as in Programming
 * Exercise 20.4.
 *
 * ■ Define a class named Pair with the data fields p1 and p2 to represent two
 * points, and a method named getDistance() that returns the distance between
 * the two points.
 *
 * ■ Implement the following methods:
 *
 * Return the distance of the closest pair of points
 * public static Pair getClosestPair(double[][] points)
 *
 * Return the distance of the closest pair of points
 * public static Pair getClosestPair(Point[] points)
 *
 * Return the distance of the closest pair of points in
 * pointsOrderedOnX[low..high]. This is a recursive method. pointsOrderedOnX and
 * pointsOrderedOnY are not changed in the subsequent recursive calls.
 * public static Pair distance(Point[] pointsOrderedOnX, int low, int high,
 * Point[] pointsOrderedOnY)
 *
 * Compute the distance between two points p1 and p2
 * public static double distance(Point p1, Point p2)
 *
 * Compute the distance between points (x1, y1) and (x2, y2)
 * public static double distance(double x1, double y1, double x2, double y2)
 *
 * Output:
 * The closest points are (1.37, 29.67) and (1.61, 29.31)
 * The distance between the two points is 0.4326661530556812
 *
 * @author martinfall
 */
public class ClosestPair {

    // The constant number of points to generate
    public static final int NUMBER_OF_POINTS = 100;

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create and populate an array of 100 points
        Point[] points = new Point[NUMBER_OF_POINTS];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point();
        }

        // Find the closest pair of points
        // System.out.println(Pair.bruteForceClosestPair(points));
        System.out.println(Pair.getClosestPair(points));
    }
}
