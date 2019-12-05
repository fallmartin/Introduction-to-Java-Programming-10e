/*
(Geometry: area of a triangle) Write a program that prompts the user to enter
three points (x1, y1), (x2, y2), (x3, y3) of a triangle and displays its area.
The formula for computing the area of a triangle is

s = (side1 + side2 + side3)/2
area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3))

Here is a sample run:
Enter three points for a triangle: Ï
The area of the triangle is 33.6

Actual output:
Enter three points for a triangle: 1.5 -3.4 4.6 5 9.5 -3.4
The area of the triangle is 33.600000000000016
 */

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class TriangleArea {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter three points for a triangle
        System.out.print("Enter three points for a triangle: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();

        // Calculate side 1
        double side1 = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

        // Calculate side2
        double side2 = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));

        // Calculate side3
        double side3 = Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow((y1 - y3), 2));

        // Calculate s
        double s = (side1 + side2 + side3) / 2;

        // Calculate the area of the triangle
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

        // Display the result
        System.out.println("The area of the triangle is " + area);

    }
}
