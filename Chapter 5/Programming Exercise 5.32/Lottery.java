
import java.util.Scanner;

/**
 * ﻿(Game: lottery) Revise Listing 3.8, Lottery.java, to generate a lottery of a
 * two digit number. The two digits in the number are distinct. (Hint: Generate
 * the first digit. Use a loop to continuously generate the second digit until
 * it is different from the first digit.)
 */
/**
 *
 * @author martinfall
 */
public class Lottery {

    public static void main(String[] args) {
        // Set a boolean flag assuming that the digits are equal to true
        boolean digitsAreEqual = true;

        // Generate the first lottery digit
        int digit1 = (int) (Math.random() * 10);

        // Declare and initialize the secong lottery digit to -1
        int digit2 = -1; // initiate digit to -1

        // While the flag is true 
        while (digitsAreEqual) {
            digit2 = (int) (Math.random() * 10); // Generate the 2nd digit
            if (digit1 != digit2) { // If the digits are different
                digitsAreEqual = false; // Set the flag to false
            }
        }

        // Display the lottery generated number for testing purposes
        System.out.println("The lottery number is " + digit1 + digit2);

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a guess
        System.out.print("Enter your lottery pick (two digits): ");
        int guess = input.nextInt();

        // Get digits from guess
        int guess1 = guess / 10;
        int guess2 = guess % 10;

        // Display the randomly generated lottery number for testing purposes
        // System.out.println("The lottery number is " + digit1 + digit2);
        // Display the guess entered by the user for testing purposes
        // System.out.println("The guess is " + guess1 + guess2);
        // Compare the guess to the system generated number
        if (guess1 == digit1
                && guess2 == digit2) { // If the numbers are equal
            System.out.println("Exact match: you win $10,000");
        } else if (guess1 == digit2
                && guess2 == digit1) { // If the digits are equal but not in order
            System.out.println("Match all digits: you win $3,000");
        } else if (guess1 == digit1
                || guess1 == digit2
                || guess2 == digit1
                || guess2 == digit2) { // If one digit is matched
            System.out.println("Match one digit: you win $1,000");
        } else { // If there is no match
            System.out.println("Sorry, no match");
        }
    }
}
