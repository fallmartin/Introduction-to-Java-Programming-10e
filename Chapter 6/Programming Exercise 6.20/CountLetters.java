
import java.util.Scanner;


/**
 * ﻿(Count the letters in a string) Write a method that counts the number of
 * letters in a string using the following header:
 *
 * public static int countLetters(String s)
 *
 * Write a test program that prompts the user to enter a string and displays the
 * number of letters in the string.
 * 
 * Output:
 * Enter a string: Programming_Exercise_6_20
 * There are 19 letters in the string.
 *
 * @author martinfall
 */
public class CountLetters {

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
        String s = input.nextLine();
        
        // Display the number of letters in the string
        System.out.println("There are " + countLetters(s) + " letters in the string.");
    }

    /**
     * Count and return the number of letters in a string s
     *
     * @param s
     * @return
     */
    public static int countLetters(String s) {
        int count = 0; // Declare and initialize counter

        // Test each char in s using the wrapper class Character
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
