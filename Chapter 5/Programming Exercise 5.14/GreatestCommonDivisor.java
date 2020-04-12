
import java.util.Scanner;

/**
 * ﻿(Compute the greatest common divisor) Another solution for Listing 5.9 to
 * find the greatest common divisor of two integers n1 and n2 is as follows:
 * First find d to be the minimum of n1 and n2, then check whether d, d-1, d-2,
 * ..., 2, or 1 is a divisor for both n1 and n2 in this order. The first such
 * common divisor is the greatest common divisor for n1 and n2. Write a program
 * that prompts the user to enter two positive integers and displays the gcd.
 *
 * Output:
 *
 * Enter two positive integers separated by a space: 56 74
 * The greatest common divisor of 56 and 74 is 2
 */
/**
 *
 * @author martinfall
 */
public class GreatestCommonDivisor {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        int gcd = 1; // Create a var to hold gcd and initalize it to 1

        // Prompt the user to enter two positive integers
        System.out.print("Enter two positive integers separated by a space: ");

        // Declare two variables of type int to hold the user's entries
        int n1 = input.nextInt();
        int n2 = input.nextInt();

        // Create variable d and assign to it the minimum of n1 and n2
        int d = n1 > n2 ? n2 : n1;

        while (d > 0) {
            if (n1 % d == 0 && n2 % d == 0) {
                gcd = d;
                break;
            }
            d--;
        }

        System.out.println("The greatest common divisor of " + n1 + " and " + n2
                + " is " + gcd);
    }
}
