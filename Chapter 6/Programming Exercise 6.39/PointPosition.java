
import java.util.Scanner;

/**
 * ﻿(Geometry: point position) Programming Exercise 3.32 shows how to test
 * whether a point is on the left side of a directed line, on the right, or on
 * the same line. Write the methods with the following headers: (see methods
 * defined below).
 *
 * ﻿Write a program that prompts the user to enter the three points for p0, p1,
 * and p2 and displays whether p2 is on the left of the line from p0 to p1,
 * right, the same line, or on the line segment. Here are some sample runs:
 *
 * Enter three points for p0, p1, and p2: 1 1 2 2 1.5 1.5 (1.5, 1.5) is on the
 * line segment from (1.0, 1.0) to (2.0, 2.0)
 *
 * Enter three points for p0, p1, and p2: 1 1 2 2 3 3 (3.0, 3.0) is on the same
 * line from (1.0, 1.0) to (2.0, 2.0)
 *
 * Enter three points for p0, p1, and p2: 1 1 2 2 1 1.5 (1.0, 1.5) is on the
 * left side of the line from (1.0, 1.0) to (2.0, 2.0)
 *
 * Enter three points for p0, p1, and p2: 1 1 2 2 1 -1 (1.0, -1.0) is on the
 * right side of the line from (1.0, 1.0) to (2.0, 2.0)
 *
 * @author martinfall
 */
public class PointPosition {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter three points from p0, p1, and p2
        System.out.print("Enter three points for p0, p1, and p2: ");

        // Collect input from user
        // Point p0 (x0, y0)
        double x0 = input.nextDouble();
        double y0 = input.nextDouble();
        //// Point p1 (x1, y1)
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        // Point p2 (x2, y2)
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        String format = "﻿(%.1f, %.1f) is on the %s from (%.1f, %.1f) to (%.1f, %.1f)";
        System.out.printf(format, x2, y2, printPointPosition(x0, y0, x1, y1, x2, y2),
                x0, y0, x1, y1);

    }

    /**
     * Print the position of the point in relation to the line
     *
     * @param x0
     * @param y0
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static String printPointPosition(
            double x0, double y0,
            double x1, double y1,
            double x2, double y2) {
        String str = "";

        if (leftOfTheLine(x0, y0, x1, y1, x2, y2)) {
            str = "left side of the line";
        } else if (rightOfTheLine(x0, y0, x1, y1, x2, y2)) {
            str = "right side of the line";
        } else if (onTheLineSegment(x0, y0, x1, y1, x2, y2)) {
            str = "line segment";
        } else if (onTheSameLine(x0, y0, x1, y1, x2, y2)) {
            str = "same line";
        }
        return str;
    }

    /**
     * ﻿Return true if point (x2, y2) is on the left side of the directed line
     * from (x0, y0) to (x1, y1)
     *
     * @param x0
     * @param y0
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static boolean leftOfTheLine(
            double x0, double y0,
            double x1, double y1,
            double x2, double y2) {

        return getDeterminant(x0, y0, x1, y1, x2, y2) > 0;
    }

    /**
     * ﻿Return true if point (x2, y2) is on the right side of the directed line
     * from (x0, y0) to (x1, y1)
     *
     * @param x0
     * @param y0
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static boolean rightOfTheLine(
            double x0, double y0,
            double x1, double y1,
            double x2, double y2) {

        return getDeterminant(x0, y0, x1, y1, x2, y2) < 0;
    }

    /**
     * Return true if point (x2, y2) is on the same line from (x0, y0) to (x1,
     * y1)
     *
     * @param x0
     * @param y0
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static boolean onTheSameLine(
            double x0, double y0,
            double x1, double y1,
            double x2, double y2) {
        return getDeterminant(x0, y0, x1, y1, x2, y2) == 0;
    }

    /**
     * Return true if point (x2, y2) is on the line segment from (x0, y0) to
     * (x1, y1)
     *
     * @param x0
     * @param y0
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static boolean onTheLineSegment(
            double x0, double y0,
            double x1, double y1,
            double x2, double y2) {
        return getDeterminant(x0, y0, x1, y1, x2, y2) == 0
                && (x2 > x0) && (x2 < x1)
                && (y2 > y0) && (y2 < y1);
    }

    /**
     * Calculate the determinant
     *
     * @param x0
     * @param y0
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static double getDeterminant(
            double x0, double y0,
            double x1, double y1,
            double x2, double y2) {
        return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
    }
}
