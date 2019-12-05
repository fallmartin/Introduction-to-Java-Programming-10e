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
public class SumTheDigitsInAnInteger {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter a number between 0 and 1000
        System.out.print("Enter a number between 0 and 1000: ");
        int number = input.nextInt();
        
        // Convert int to string
        String numberString = Integer.toString(number);
        
        // Declare variable sum to hold the sum of digits of integer
        int sum = 0;
        
        // Sum the digits of the integer entered by the user
        for (int i = 0; i < numberString.length(); i ++) {
            sum += Character.getNumericValue(numberString.charAt(i));
        } 
        
        // Display the results
        System.out.println("The sum of the digits is " + sum);
    }
}
