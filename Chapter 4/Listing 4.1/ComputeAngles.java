/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class ComputeAngles {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter three points
        System.out.print("Enter three points: ");

        // Collect the input from the user
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();

        // Compute the three sides
        // Compute the distance a between p2 and p3
        double a = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));

        // Compute the distance b between p3 and p1
        double b = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));

        // Compute the distance c between p1 and p2
        double c = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

        // Compute the three angles
        double A = Math.acos((a * a - b * b - c * c) / (-2 * b * c));
        double B = Math.acos((b * b - a * a - c * c) / (-2 * a * c));
        double C = Math.acos((c * c - b * b - a * a) / (-2 * a * b));

        // Display the results
        System.out.println("The three angles are "
                + Math.toDegrees(A) + " "
                + Math.toDegrees(B) + " "
                + Math.toDegrees(C));
    }
}
