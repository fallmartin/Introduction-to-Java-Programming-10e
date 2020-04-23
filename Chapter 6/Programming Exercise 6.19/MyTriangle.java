
import java.util.Scanner;

/**
 * (The MyTriangle class) Create a class named MyTriangle that contains the
 * following two methods:
 *
 * Return true if the sum of any two sides is greater than the third side.
 * public static boolean isValid(double side1, double side2, double side3)
 *
 * Return the area of the triangle. public static double area(double side1,
 * double side2, double side3)
 *
 * ﻿Write a test program that reads three sides for a triangle and computes the
 * area if the input is valid. Otherwise, it displays that the input is invalid.
 * The formula for computing the area of a triangle is given in Programming
 * Exercise 2.19.
 *
 * @author martinfall
 *
 *
 */
public class MyTriangle {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter three sides
        System.out.print("Enter three sides: ");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        // If the input is valid
        if (isValid(side1, side2, side3)) {
            System.out.println("The area of the triangle is "
                    + area(side1, side2, side3));
        } else { // The input is not valid
            System.out.println("The input is not valid.");
        }
    }

    /**
     * Return true if the sum of any two sides is greater than the third side.
     *
     * @param side1
     * @param side2
     * @param side3
     * @return
     */
    public static boolean isValid(double side1, double side2, double side3) {
        if ((side1 + side2) > side3
                || (side2 + side3) > side1
                || (side1 + side3) > side2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Return the area of the triangle.
     *
     * @param side1
     * @param side2
     * @param side3
     * @return
     */
    public static double area(double side1, double side2, double side3) {
        // Calculate s
        double s = (side1 + side2 + side3) / 2;

        // Calculate the area of the triangle
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

        return area;
    }
}
