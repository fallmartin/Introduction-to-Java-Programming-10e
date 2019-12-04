/*
Write a program that reads a number in feet, converts it to meters, 
and displays the result. One foot is 0.305 meter. 

Here is a sample run:

Enter a value for feet: 16.5
16.5 feet is 5.0325 meters
 */

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class ConvertFeetIntoMeters {
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter a value for feet
        System.out.print("Enter a value for feet: ");
        double feet = input.nextDouble();
        
        // Convert feet into meters
        double meters = feet * 0.305;
        
        // Display the results
        System.out.println(feet + " feet is " + meters + " meters");
    }
}
