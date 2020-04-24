/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martinfall
 */
public class PalindromePrimeWithoutReverse {

    public static void main(String[] args) {
        // Display the first 100 palindromic prime numbers
        printPalindromePrimes(100);
    }

    /**
     * Print palindrome primes
     *
     * @param numberOfPalindromePrimes
     */
    public static void printPalindromePrimes(int numberOfPalindromePrimes) {
        final int NUMBER_OF_PALINDROME_PRIMES_PER_LINE = 10; // numbers per line
        int count = 0; // count the number of primes
        int number = 2; // first prime to be tested

        while (count <= numberOfPalindromePrimes) {
            if (isPrime(number) && isPalindrome(number)) {
                count++; // Incremen the count variable

                if (count % NUMBER_OF_PALINDROME_PRIMES_PER_LINE == 0) {
                    System.out.printf("%-7d%n", number);
                } else {
                    System.out.printf("%-7d", number);
                }
            }
            number++; // Check the next number
        }
    }

    /**
     * Check whether number is prime
     *
     * @param number
     * @return
     */
    public static boolean isPrime(int number) {
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) { // If true, number is not prime
                return false; // Number is not a prime
            }
        }
        return true; // Number is prime
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
}
