/*
(Geometry: distance of two points) Write a program that prompts the user to enter
two points (x1, y1) and (x2, y2) and displays their distance between them.
The formula for computing the distance is 

Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2))

Note that you can use Math.pow(a, 0.5) to compute the square root of a. 

Here is a sample run:

Enter x1 and y1: 1.5 -3.4
Enter x2 and y2: 4 5
The distance between the two points is 8.764131445842194

Actual output:
Enter x1 and y1: 1.5 -3.4
Enter x2 and y2: 4 5
The distance between the two points is 8.764131445842194
 */

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class FindTheDistanceBetweenTwoPoints {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter x1 and y1
        System.out.print("Enter x1 and y1: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();

        // Prompt the user to enter x2 and y2
        System.out.print("Enter x2 and y2: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        // Calculate the distance between the two points
        double distanceBetweenTwoPoints
                = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

        // Display the results
        System.out.println("The distance between the two points is "
                + distanceBetweenTwoPoints);
    }
}
