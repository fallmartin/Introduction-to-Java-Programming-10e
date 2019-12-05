/*
(Financial application: calculate tips) Write a program that reads the subtotal 
and the gratuity rate, then computes the gratuity and total. For example, if the 
user enters 10 for subtotal and 15% for gratuity rate, the program displays $1.5 
as gratuity and $11.5 as total. 

Here is a sample run:

Enter the subtotal and a gratuity rate: 10 15
The gratuity is $1.5 and total is $11.5
 */

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class CalculateTips {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter the subtotal and a gratuity rate
        System.out.print("Enter the subtotal and a gratuity rate: ");
        double subtotal = input.nextDouble();
        double gratuityRate = input.nextDouble();
        
        // Calculate the gratuity and total
        double gratuity = subtotal * gratuityRate / 100.0;
        double total = subtotal + gratuity;
        
        // Display the results
        System.out.println("The gratuity is $" + gratuity + 
                " and total is $" + total);
    }
}
