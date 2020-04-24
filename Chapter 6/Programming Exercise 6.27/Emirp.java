
/**
 * ﻿(Emirp) An emirp (prime spelled backward) is a nonpalindromic prime number
 * whose reversal is also a prime. For example, 17 is a prime and 71 is a prime,
 * so 17 and 71 are emirps. Write a program that displays the first 100 emirps.
 * Display 10 numbers per line, separated by exactly one space, as follows:
 *
 * 13 17 31 37 71 73 79 97 107 113
 * 149 157 167 179 199 311 337 347 359 389
 * ...
 *
 * @author martinfall
 */
public class Emirp {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Print the first 100 emirps
        printEmirps(100);
    }

    public static void printEmirps(int numberOfEmirps) {
        final int NUMBER_OF_EMIRPS_PER_LINE = 10; // Emirps per line
        int count = 0; // Declare and initialize a counter variable
        int number = 2; // Starting number

        while (count <= numberOfEmirps) {
            if (isEmirp(number)) {
                count++;
                if (count % NUMBER_OF_EMIRPS_PER_LINE == 0) {
                    System.out.printf("%d%n", number);
                } else {
                    System.out.printf("%d ", number);
                }
            }
            number++;
        }
    }

    /**
     * Check if number is Emirp
     *
     * @param number
     * @return
     */
    public static boolean isEmirp(int number) {
        return isPrime(number) && isPrime(reverse(number)) && !isPalindrome(number);
    }

    /**
     * Check whether number is prime
     *
     * @param number
     * @return
     */
    public static boolean isPrime(int number) {
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check whether number is palindrome
     *
     * @param number
     * @return
     */
    public static boolean isPalindrome(int number) {
        String str = Integer.toString(number);

        for (int i = 0, j = str.length() - 1; i < str.length() && j >= 0; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Reverse the number
     *
     * @param number
     * @return
     */
    public static int reverse(int number) {
        String str = "";

        while (number > 0) {
            str = str + (number % 10);
            number /= 10;
        }

        return (Integer.parseInt(str));
    }
}
