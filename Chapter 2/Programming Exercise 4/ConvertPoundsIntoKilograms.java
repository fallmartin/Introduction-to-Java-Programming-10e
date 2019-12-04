/*
Write a program that converts pounds into kilograms. The program prompts the 
user to enter a number in pounds, converts it to kilograms, and displays the 
result. One pound is 0.454 kilograms. 

Here is a sample run:

Enter a number in pounds: 55.5
55.5 pounds is 25.197 kilograms
 */

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class ConvertPoundsIntoKilograms {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter a number in pounds
        System.out.print("Enter a number in pounds: ");
        double pounds = input.nextDouble();
        
        // Convert pounds into kilograms
        double kilograms = pounds * 0.454;
        
        // Display the results
        System.out.println(pounds + " pounds is " + kilograms + " kilograms");
    }
}
