/*
(Physics: acceleration) Average acceleration is defined as the change of velocity
divided by the time taken to make the change, as shown in the following formula:

a = (v1 - v0) / t

Write a program that prompts the user to enter the starting velocity v0 in meters/
second, the ending velocity v1 in meters/second, and the time span t in seconds,
and displays the average acceleration. 

Here is a sample run:

Enter v0, v1, and t: 5.5 50.9 4.5
The average acceleration is 10.0889

Actual output is as follows:
Enter v0, v1, and t: 5.5 50.9 4.5
The average acceleration is 10.088888888888889
*/

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class CalculateAverageAcceleration {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter v0, v1, and t
        System.out.print("Enter v0, v1, and t: ");
        double v0 = input.nextDouble();
        double v1 = input.nextDouble();
        double t = input.nextDouble();
        
        // Compute the average acceleration
        double averageAcceleration = (v1 - v0) / t;
        
        System.out.println("The average acceleration is " + averageAcceleration);
    }
}
