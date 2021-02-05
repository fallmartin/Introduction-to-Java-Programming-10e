package closestpair;

import java.util.*;

/**
 * Represents a Point on a two-dimensional plane with coordinates x and y values
 * in the 1 - 100 range.
 *
 * @author martinfall
 */
public class Point implements Comparable<Point> {

    private double x;
    private double y;

    /**
     * The no-args constructor of the Point class generates random x and y
     * values in the 1 - 100 range.
     */
    public Point() {
        // Values of x and y rounded to 2 decimal places for convenience
        x = ((int) (Math.random() * new Random().nextInt(100) * 100)) / 100.0;
        y = ((int) (Math.random() * new Random().nextInt(100) * 100)) / 100.0;
    }

    /**
     * Construct a Point object with coordinates x and y from given parameters.
     *
     * @param x
     * @param y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
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

    @Override // Override the toString method of the Object class
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
