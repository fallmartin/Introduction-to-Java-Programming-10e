
import java.util.Scanner;

/**
 * ﻿(Palindrome integer) Write the methods with the following headers
 *
 * // Return the reversal of an integer, i.e., reverse(456) returns 654 public
 * static int reverse(int number)
 *
 * // Return true if number is a palindrome public static boolean
 * isPalindrome(int number)
 *
 * Use the reverse method to implement isPalindrome. A number is a palindrome if
 * its reversal is the same as itself. Write a test program that prompts the
 * user to enter an integer and reports whether the integer is a palindrome.
 */
/**
 *
 * @author martinfall
 */
public class PalindromeInteger {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter an integer
        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        System.out.println("The number " + number + " is"
                + (isPalindrome(number) ? " " : " not ") + "a palindrome");
    }

    /**
     * Return the reversal of an integer, i.e., reverse(456) returns 654
     *
     * @param number
     * @return
     */
    public static int reverse(int number) {
        String reverse = "";

        while (number > 0) {
            reverse = reverse + number % 10;
            number /= 10;
        }

        return Integer.parseInt(reverse);
    }

    /**
     * Return true if number is a palindrome
     *
     * @param number
     * @return
     */
    public static boolean isPalindrome(int number) {
        return reverse(number) == number;
    }
}
