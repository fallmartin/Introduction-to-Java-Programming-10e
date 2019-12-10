
/**
 * Write a program that prompts the user to enter a weight in pounds and height
 * in inches and displays the BMI. Note that one pound is 0.45359237 kilograms
 * and one inch is 0.0254 meters.
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class ComputeAndInterpretBMI {

    public static void main(String[] args) {
        // declare constant variables
        final double KILOGRAMS_PER_POUND = 0.45359237;
        final double METERS_PER_INCH = 0.0254;

        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a weight in pounds
        System.out.print("Enter weight in pounds: ");
        double weightInPounds = input.nextDouble();

        // Prompt the user to enter a height in inches
        System.out.print("Enter height in inches: ");
        double heightInInches = input.nextDouble();

        // Convert the weight from pounds into kilograms
        double weightInKilograms = weightInPounds * KILOGRAMS_PER_POUND;

        // Convert the height from inches into meters
        double heightInMeters = heightInInches * METERS_PER_INCH;

        // Calculate the BMI
        double BodyMassIndex
                = weightInKilograms / Math.pow(heightInMeters, 2);

        // Display the results
        System.out.println("BMI is " + BodyMassIndex);

        //BMI < 18.5 Underweight
        //18.5 ≤ BMI < 25.0 Normal
        //25.0 ≤ BMI < 30.0 Overweight
        //30.0 ≤ BMI Obese
        if (BodyMassIndex < 18.5) {
            System.out.println("Underweight");
        } else if (BodyMassIndex < 25) {
            System.out.println("Normal");
        } else if (BodyMassIndex < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}
