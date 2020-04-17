
import java.util.Scanner;

/**
 * ﻿(Reverse a string) Write a program that prompts the user to enter a string
 * and displays the string in reverse order.
 *
 * Output:
 * Enter a string: ABCDEFG
 * The reversed string is GFEDCBA
 *
 */
/**
 *
 * @author martinfall
 */
public class ReverseAString {

    public static void main(String[] args) {
        // Create a String object to hold the new string
        String newString = "";
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String userInput = input.nextLine();

        for (int i = 0; i < userInput.length(); i++) {
            // Grab the first character and add it to the beginning of the new string
            // Repeat this going up the user input and prepending the new string
            newString = userInput.substring(i, i + 1) + newString;
        }
        // Display the new string
        System.out.println("The reversed string is " + newString);
    }
}
