
/**
 * ﻿(Summation) Write a program to compute the following summation.
 * 1 / (1 + √2) + 1 / (√2 + √3) + 1 / (√3 + √4) + ... + 1 / (√624 + √625)
 */

/**
 *
 * @author martinfall
 */
public class Summation {

    public static void main(String[] args) {
        double sum = 0; // Delare and initialize sum at 0
        for (int i = 1, j = 2; j <= 625; i++, j++) { // Loop through 1 to 625 included
            sum += (Math.pow((Math.sqrt(i) + Math.sqrt(j)), -1)); // Maths
        }
        System.out.println("Summation: " + sum); // Print the result to console
    }
}
