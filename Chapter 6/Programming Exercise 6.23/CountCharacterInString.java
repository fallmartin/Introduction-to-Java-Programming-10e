
import java.util.Scanner;

/**
 * (Occurrences of a specified character) Write a method that finds the number
 * of occurrences of a specified character in a string using the following
 * header:
 *
 * public static int count(String str, char a)
 *
 * ﻿For example, count("Welcome", 'e') returns 2. Write a test program that
 * prompts the user to enter a string followed by a character and displays the
 * number of occurrences of the character in the string.
 *
 * Output:
 * Enter a string: Welcome to the best day of your life!
 * Enter a character: e
 * The character e occurs 5 times in (Welcome to the best day of your life!)
 *
 * @author martinfall
 */
public class CountCharacterInString {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        // Prompt the user to enter a character
        System.out.print("Enter a character: ");
        char a = input.next().charAt(0);

        System.out.println("The character " + a + " occurs "
                + count(str, a) + " times in (" + str + ")");
    }

    /**
     * Find the number of occurrences of a specified character in a string.
     *
     * @param str
     * @param a
     * @return
     */
    public static int count(String str, char a) {
        int count = 0; // Declare and initialize a counter variable

        // Loop through the string one character at a time
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a) {
                // System.out.println(str.charAt(i));
                count++;
            }
        }
        return count;
    }
}
