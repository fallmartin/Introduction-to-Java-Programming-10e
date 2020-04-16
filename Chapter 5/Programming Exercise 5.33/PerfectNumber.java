
/**
 * ﻿(Perfect number) A positive integer is called a perfect number if it is equal to
 * the sum of all of its positive divisors, excluding itself. For example, 6 is the first
 * perfect number because 6 = 3 + 2 + 1. The next is 28 = 14 + 7 + 4 + 2
 * + 1. There are four perfect numbers less than 10,000. Write a program to find all
 * these four numbers.
 *
 * Output:
 * 1 + 2 + 3 = 6
 * 1 + 2 + 4 + 7 + 14 = 28
 * 1 + 2 + 4 + 8 + 16 + 31 + 62 + 124 + 248 = 496
 * 1 + 2 + 4 + 8 + 16 + 32 + 64 + 127 + 254 + 508 + 1016 + 2032 + 4064 = 8128
 * There are 4 perfect numbers less than 10,000.
 */
/**
 *
 * @author martinfall
 */
public class PerfectNumber {

    public static void main(String[] args) {

        // Create and initialize a counter for perfect numbers;
        int counter = 0;

        // Create a loop that iterates from 1 to 10000
        for (int number = 1; number <= 10000; number++) {
            // Declare a local variable sum and initialize it to 0
            int sum = 0;

            // Create a string and initialize it to null
            String s = "";

            // Find the positive divisors of number and add them to sum
            for (int divisor = 1; divisor < number; divisor++) { // up to and not including the number itself
                if (number % divisor == 0) {
                    s += (divisor == 1) ? divisor : " + " + divisor;
                    sum += divisor;
                }
            }

            // Compare sum and number for perfectness
            if (sum == number) {
                System.out.println(s + " = " + number);
                counter++;
            }
        }
        System.out.println("There are " + counter + " perfect numbers less than 10,000.");
    }
}
