/*
(Cost of driving) Write a program that prompts the user to enter the distance to
drive, the fuel efficiency of the car in miles per gallon, and the price per gallon,
and displays the cost of the trip. 

Here is a sample run:

Enter the driving distance: 900.5
Enter miles per gallon: 25.5
Enter price per gallon: 3.55
The cost of driving is $125.36

Actual output:
Enter the driving distance: 900.5
Enter miles per gallon: 25.5
Enter price per gallon: 3.55
The cost of driving is $125.36372549019606
 */

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class TripCost {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the driving distance
        System.out.print("Enter the driving distance: ");
        double drivingDistance = input.nextDouble();

        // Prompt the user to enter the miles per gallon
        System.out.print("Enter miles per gallon: ");
        double milesPerGallon = input.nextDouble();

        // Prompt the user to enter the price per gallon
        System.out.print("Enter price per gallon: ");
        double pricePerGallon = input.nextDouble();

        // Calculate the cost of driving
        double costOfDriving = drivingDistance * pricePerGallon / milesPerGallon;

        // Display the result
        System.out.println("The cost of driving is $" + costOfDriving);
    }
}
