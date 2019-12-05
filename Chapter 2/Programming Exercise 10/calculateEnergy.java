/*
(Science: calculating energy) Write a program that calculates the energy needed
to heat water from an initial temperature to a final temperature. Your program
should prompt the user to enter the amount of water in kilograms and the initial
and final temperatures of the water. The formula to compute the energy is

Q = M * (finalTemperature – initialTemperature) * 4184

where M is the weight of water in kilograms, temperatures are in degrees Celsius,
and energy Q is measured in joules. 

Here is a sample run:

Enter the amount of water in kilograms: 55.5
Enter the initial temperature: 3.5
Enter the final temperature: 10.5
The energy needed is 1625484.0
*/

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class calculateEnergy {
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter the amount of water in kilograms
        System.out.print("Enter the amount of water in kilograms: ");
        double kilograms = input.nextDouble();
        
        // Prompt the user to enter the initial temperature
        System.out.print("Enter the initial temperature: ");
        double initialTemperature = input.nextDouble();
        
        // Prompt the user to enter the final temperature
        System.out.print("Enter the final temperature: ");
        double finalTemperature = input.nextDouble();
        
        // Calculate the energy
        double energy = kilograms * (finalTemperature - initialTemperature) * 4184;
        
        // Display the results
        System.out.println("The energy needed is " + energy);
    }
}
