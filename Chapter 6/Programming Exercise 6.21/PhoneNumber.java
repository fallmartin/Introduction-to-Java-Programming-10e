
import java.util.Scanner;


/**
 * (Phone keypads) The international standard letter/number mapping for telephones
 * is shown in Programming Exercise 4.15. Write a method that returns a number,
 * given an uppercase letter, as follows:
 *
 * int getNumber(char uppercaseLetter)
 *
 * Write a test program that prompts the user to enter a phone number as a string.
 * The input number may contain letters. The program translates a letter (uppercase
 * or lowercase) to a digit and leaves all other characters intact. Here is a
 * sample run of the program:
 *
 * Enter a string: 1-800-Flowers
 * 1-800-3569377
 *
 * ﻿Enter a string: 1800flowers
 * 18003569377
 *
 * @author martinfall
 */
public class PhoneNumber {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        
        // Test each character in the string
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                System.out.print(getNumber(str.charAt(i)));
            } else {
                System.out.print(str.charAt(i));
            }
        }
    }

    /**
     * Translate a letter into a digit
     *
     * @param uppercaseLetter
     * @return
     */
    public static int getNumber(char uppercaseLetter) {
        // Convert uppercaseLetter to upper case to limit test cases to upper case chars
        uppercaseLetter = Character.toUpperCase(uppercaseLetter);

        // Translate the letter to a digit
        if (uppercaseLetter >= 'A' && uppercaseLetter <= 'Z') {
            if (uppercaseLetter < 'D') {
                return 2;
            } else if (uppercaseLetter >= 'D' && uppercaseLetter < 'G') {
                return 3;
            } else if (uppercaseLetter >= 'G' && uppercaseLetter < 'J') {
                return 4;
            } else if (uppercaseLetter >= 'J' && uppercaseLetter < 'M') {
                return 5;
            } else if (uppercaseLetter >= 'M' && uppercaseLetter < 'P') {
                return 6;
            } else if (uppercaseLetter >= 'P' && uppercaseLetter < 'T') {
                return 7;
            } else if (uppercaseLetter >= 'T' && uppercaseLetter < 'W') {
                return 8;
            } else if (uppercaseLetter >= 'W' && uppercaseLetter <= 'Z') {
                return 9;
            } else {
                return -1;
            }
        } else {
            System.out.println(uppercaseLetter + " is an invalid input");
            return -1;
        } // Return -1 if the input is invalid
    }
}
