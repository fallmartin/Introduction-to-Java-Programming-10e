
import java.util.Scanner;

/**
 * ﻿(Decimal to binary) Write a program that prompts the user to enter a decimal
 * integer and displays its corresponding binary value. Don’t use Java’s
 * Integer.toBinaryString(int) in this program.
 *
 * Output: 
 * Enter a decimal integer: 5432 
 * Binary number: 1010100111000
 */
/**
 *
 * @author martinfall
 */
public class DecimalToBinary {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a decimal integer
        System.out.print("Enter a decimal integer: ");
        int decimal = input.nextInt();

        // Variable holds a copy of decimal
        int copy = decimal;

        // Convert the integer to a binary string
        // Start by creating a String var initialized with ""
        String binary = "";

        while (decimal > 0) {
            String s = Integer.toString(decimal % 2);
            //binary += s; // Doesnt work because it concatenates to end of string
            binary = s + binary.substring(0); // Prepend s to binary string at 0
            decimal /= 2; // Divide decimal by 2
        }

        // Use  Java’s Integer.toBinaryString(int) for testing
        //System.out.println(Integer.toBinaryString(copy));
        // Display the corresponding binary value
        System.out.println("Binary number: " + binary);
    }
}
