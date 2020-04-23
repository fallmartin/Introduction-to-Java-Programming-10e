
import java.util.Scanner;

/**
 * ﻿(Math: approximate the square root) There are several techniques for
 * implementing the sqrt method in the Math class. One such technique is known
 * as the Babylonian method. It approximates the square root of a number, n, by
 * repeatedly performing a calculation using the following formula:
 *
 * nextGuess = (lastGuess + n / lastGuess) / 2
 *
 * When nextGuess and lastGuess are almost identical, nextGuess is the
 * approximated square root. The initial guess can be any positive value (e.g.,
 * 1). This value will be the starting value for lastGuess. If the difference
 * between nextGuess and lastGuess is less than a very small number, such as
 * 0.0001, you can claim that nextGuess is the approximated square root of n. If
 * not, nextGuess becomes lastGuess and the approximation process continues.
 * Implement the following method that returns the square root of n.
 *
 * public static double sqrt(long n)
 *
 * @author martinfall
 */
public class SquareRoot {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a number n
        System.out.print("Enter a number: ");
        long n = input.nextLong();

        // Display the result
        System.out.println("The square root of " + n + " is " + sqrt(n));
        System.out.println(Math.sqrt(n)); // Test the answer
    }

    /**
     * Approximate the square root of n
     *
     * @param n
     * @return
     */
    public static double sqrt(long n) {
        long lastGuess = 1;
        long nextGuess = (lastGuess + n / lastGuess) / 2;

        while (Math.abs(nextGuess - lastGuess) > 0.0001) {
            lastGuess = nextGuess;
            nextGuess = (lastGuess + n / lastGuess) / 2;
        }

        return nextGuess;
    }
}
