/*
(Physics: finding runway length) Given an airplane’s acceleration a and take-off
speed v, you can compute the minimum runway length needed for an airplane to
take off using the following formula:

length = v^2 / 2a

Write a program that prompts the user to enter v in meters/second (m/s) and the
acceleration a in meters/second squared (m/s2), and displays the minimum runway
length.

Here is a sample run:

Enter speed and acceleration: 60 3.5
The minimum runway length for this airplane is 514.286

Actual output:
Enter speed and acceleration: 60 3.5
The minimum runway length for this airplane is 514.2857142857143
 */

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class FindRunwayLength {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter speed and acceleration
        System.out.print("Enter speed and acceleration: ");
        double speed = input.nextDouble();
        double acceleration = input.nextDouble();
        
        // Calculate the minimum ruway length for this airplane
        double length = Math.pow(speed, 2) / (2 * acceleration);
        
        // Display the results
        System.out.println("The minimum runway length for this airplane is " + 
                length);
    }
}
