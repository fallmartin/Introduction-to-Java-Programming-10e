
import java.util.*;

/**
 * (Sort points in a plane) Write a program that meets the following
 * requirements:
 *
 * ■ Define a class named Point with two data fields x and y to represent a
 * point’s x- and y-coordinates. Implement the Comparable interface for
 * comparing the points on x-coordinates. If two points have the same
 * x-coordinates, compare their y-coordinates.
 *
 * ■ Define a class named CompareY that implements Comparator<Point>. Implement
 * the compare method to compare two points on their y-coordinates. If two
 * points have the same y-coordinates, compare their x-coordinates.
 *
 * ■ Randomly create 100 points and apply the Arrays.sort method to display the
 * points in increasing order of their x-coordinates and in increasing order of
 * their y-coordinates, respectively.
 *
 * Output with 10 randomly generated points:
 *
 * ORDER OF CREATION
 * (35.62, 13.67)
 * (19.51, 4.47)
 * (91.79, 3.8)
 * (33.95, 1.95)
 * (1.35, 52.14)
 * (11.47, 76.26)
 * (2.72, 22.64)
 * (18.28, 56.6)
 * (6.74, 42.02)
 * (86.11, 38.68)
 *
 * INCREASING ORDER OF X-COORDINATES
 * (1.35, 52.14)
 * (2.72, 22.64)
 * (6.74, 42.02)
 * (11.47, 76.26)
 * (18.28, 56.6)
 * (19.51, 4.47)
 * (33.95, 1.95)
 * (35.62, 13.67)
 * (86.11, 38.68)
 * (91.79, 3.8)
 *
 * INCREASING ORDER OF Y-COORDINATES
 * (33.95, 1.95)
 * (91.79, 3.8)
 * (19.51, 4.47)
 * (35.62, 13.67)
 * (2.72, 22.64)
 * (86.11, 38.68)
 * (6.74, 42.02)
 * (1.35, 52.14)
 * (18.28, 56.6)
 * (11.47, 76.26)
 *
 * @author martinfall
 */
class CompareY implements Comparator<Point> {

    @Override
    public int compare(Point p1, Point p2) {
        if (p1.getY() > p2.getY()) {
            return 1;
        } else if (p1.getY() == p2.getY()) {
            if (p1.getX() > p2.getX()) {
                return 1;
            } else if (p1.getX() == p2.getX()) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

}

class Point implements Comparable<Point> {

    private double x;
    private double y;

    /**
     * The no-args constructor of the Point class generates random x and y
     * values in the 1 - 100 range.
     */
    public Point() {
        // Arbitrary decision for each value of x and y to have a scale of 2
        x = ((int) (Math.random() * new Random().nextInt(100) * 100)) / 100.0;
        y = ((int) (Math.random() * new Random().nextInt(100) * 100)) / 100.0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override // Override the compareTo method of the Comparable<T> interface
    public int compareTo(Point o) {
        if (x > o.getX()) {
            return 1;
        } else if (x == o.getX()) {
            if (y > o.getY()) {
                return 1;
            } else if (y == o.getY()) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}

public class SortPoints {

    private final static int NUMBER_OF_POINTS = 100;

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {

        // Randomly create 100 points
        Point[] points = new Point[NUMBER_OF_POINTS];
        for (int i = 0; i < NUMBER_OF_POINTS; i++) {
            points[i] = new Point();
        }

        /**
         * Apply the Arrays.sort method to display the points in increasing
         * order of their x-coordinates and in increasing order of their
         * y-coordinates, respectively.
         */
        System.out.println("ORDER OF CREATION");
        printPoints(points);
        System.out.println(); // Line separator

        System.out.println("INCREASING ORDER OF X-COORDINATES");
        Arrays.sort(points);
        printPoints(points);
        System.out.println(); // Line separator

        System.out.println("INCREASING ORDER OF Y-COORDINATES");
        Arrays.sort(points, new CompareY());
        printPoints(points);
    }

    /**
     * Display the points in the console.
     *
     * @param points
     */
    static void printPoints(Point[] points) {
        for (Point p : points) {
            System.out.println("(" + p.getX() + ", " + p.getY() + ")");
        }
    }
}
