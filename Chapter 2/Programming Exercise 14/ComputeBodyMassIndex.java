/*
(Health application: computing BMI) Body Mass Index (BMI) is a measure of
health on weight. It can be calculated by taking your weight in kilograms and
dividing by the square of your height in meters. Write a program that prompts the
user to enter a weight in pounds and height in inches and displays the BMI. Note
that one pound is 0.45359237 kilograms and one inch is 0.0254 meters. 

Here is a sample run:

Enter weight in pounds: 95.5
Enter height in inches: 50
BMI is 26.8573

Actual output:
Enter weight in pounds: 95.5
Enter height in inches: 50
BMI is 26.857257942215885

*/

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class ComputeBodyMassIndex {
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter weight in pounds
        System.out.print("Enter weight in pounds: ");
        double weightInPounds = input.nextDouble();
        
        // Prompt the user to enter height in inches
        System.out.print("Enter height in inches: ");
        double heightInInches = input.nextDouble();
        
        // Convert weight from pounds to kilograms
        double weightInKilograms = weightInPounds * 0.45359237;
        
        // Convert height from inches to meters
        double heightInMeters = heightInInches * 0.0254;
        
        // Compute the Body Mass Index
        double bodyMassIndex = weightInKilograms / Math.pow(heightInMeters, 2);

        // Display the result
        System.out.println("BMI is " + bodyMassIndex);
    }
}
