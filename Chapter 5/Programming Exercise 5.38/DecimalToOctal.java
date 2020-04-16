
import java.util.Scanner;


/**
 * ﻿(Decimal to octal) Write a program that prompts the user to enter a decimal
 * integer and displays its corresponding octal value. Don’t use Java’s Integer
 * .toOctalString(int) in this program.
 */

/**
 *
 * @author martinfall
 */
public class DecimalToOctal {

    public static void main(String[] args) {
// Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a decimal integer
        System.out.print("Enter a decimal integer: ");
        int decimal = input.nextInt();

        // Variable holds a copy of decimal
        int copy = decimal;

        // Convert the integer to a octal string
        // Start by creating a String var initialized with ""
        String octal = "";

        while (decimal > 0) {
            String s = Integer.toString(decimal % 8);
            //binary += s; // Doesnt work because it concatenates to end of string
            octal = s + octal.substring(0); // Prepend s to octal string at 0
            decimal /= 8; // Divide decimal by 8
        }

        // Use  Java’s Integer.toOctalString(int) for testing
        // System.out.println("Octal number: " + Integer.toOctalString(copy));
        // Display the corresponding binary value
        System.out.println("Octal number: " + octal);
    }
}
