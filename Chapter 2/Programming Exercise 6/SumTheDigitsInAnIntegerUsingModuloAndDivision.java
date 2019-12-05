/*
(Sum the digits in an integer) Write a program that reads an integer between 0 and
1000 and adds all the digits in the integer. For example, if an integer is 932, the
sum of all its digits is 14.

Hint: Use the % operator to extract digits, and use the / operator to remove the
extracted digit. For instance, 932 % 10 = 2 and 932 / 10 = 93.

Here is a sample run:

Enter a number between 0 and 1000: 999
The sum of the digits is 27
 */

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class SumTheDigitsInAnIntegerUsingModuloAndDivision {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter a number between 0 and 1000
        System.out.print("Enter a number between 0 and 1000: ");
        int number = input.nextInt();
        
        // Process the number entered by the user
        int ones = number % 10; // Extract the digit in the ones place
        
        // Divide number by 10 to remove the extra digit
        number /= 10;
        
        int tens = number % 10; // Extract the digit in the tens place
        
        // Divide number by 10 to remove the extra digit
        number /= 10;
        
        int hundreds = number % 10; // Extract the digit in the hundreds place
        
        // Create a variable sum to hold the sum of integer digits
        int sum = hundreds + tens + ones;
        
        // Display the results
        System.out.println("The sum of the digits is " + sum);
    }
}
