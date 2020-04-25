
import java.util.Scanner;

/**
 * (Geometry: area of a regular polygon) A regular polygon is an n-sided polygon
 * in which all sides are of the same length and all angles have the same degree
 * (i.e., the polygon is both equilateral and equiangular). The formula for
 * computing the area of a regular polygon is
 *
 * Area = (n * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / n));
 *
 * ﻿Write a method that returns the area of a regular polygon using the
 * following header:
 *
 * public static double area(int n, double side)
 *
 * Write a main method that prompts the user to enter the number of sides and
 * the side of a regular polygon and displays its area. Here is a sample run:
 *
 * ﻿Enter the number of sides: 5 Enter the side: 6.5 The area of the polygon is
 * 72.69017017488385
 *
 * @author martinfall
 */
public class RegularPolygonArea {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the number of sides
        System.out.println("﻿Enter the number of sides: ");
        int n = input.nextInt();

        // Prompt the user to enter the side
        System.out.println("Enter the side: ");
        double side = input.nextDouble();

        // String format
        String format = "The area of the polygon is %.14f";

        System.out.printf(format, area(n, side));
    }

    /**
     * Return the area of a regular polygon
     *
     * @param n
     * @param side
     * @return
     */
    public static double area(int n, double side) {
        return (n * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / n));
    }
}
