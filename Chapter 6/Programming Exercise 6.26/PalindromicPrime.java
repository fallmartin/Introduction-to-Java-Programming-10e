
/**
 * ﻿(Palindromic prime) A palindromic prime is a prime number and also palindromic.
 * For example, 131 is a prime and also a palindromic prime, as are 313 and 757.
 * Write a program that displays the first 100 palindromic prime numbers. Display
 * 10 numbers per line, separated by exactly one space, as follows:
 *
 * 2 3 5 7 11 101 131 151 181 191
 * 313 353 373 383 727 757 787 797 919 929
 * ...
 *
 * @author martinfall
 */
public class PalindromicPrime {

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
        return Integer.parseInt(reverse(number)) == number;
    }
    
    public static String reverse(int number) {
        String str = "";
        
        while (number > 0) {
            str = str + (number % 10);
            number /= 10;
        }
        
        return str;
    }
}
