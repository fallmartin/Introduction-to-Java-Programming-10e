
/**
 * ﻿(Twin primes) Twin primes are a pair of prime numbers that differ by 2.
 * For example, 3 and 5 are twin primes, 5 and 7 are twin primes, and 11 and 13
 * are twin primes. Write a program to find all twin primes less than 1,000.
 * Display the output as follows:
 *
 * (3, 5)
 * (5, 7)
 * ...
 *
 * @author martinfall
 */
public class TwinPrimes {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        int counter = 0; // Declare and initialize a counter variable

        for (int i = 2; i <= 1000; i++) {
            printTwinPrimes(i);
        }
    }

    /**
     * Print twin primes
     *
     * @param number
     */
    public static void printTwinPrimes(int number) {
        int num1 = number;
        int num2 = number + 2;
        String format = "(%d, %d)%n";

        if (isPrime(num1) && isPrime(num2)) {
            System.out.printf(format, num1, num2);
        }
    }

    /**
     * Check if number is prime
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
}
