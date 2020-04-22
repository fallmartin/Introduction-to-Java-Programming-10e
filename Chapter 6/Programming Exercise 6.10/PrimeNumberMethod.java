
/**
 * ﻿(Use the isPrime Method) Listing 6.7, PrimeNumberMethod.java, provides the
 * isPrime(int number) method for testing whether a number is prime. Use this
 * method to find the number of prime numbers less than 10000.
 *
 * @author martinfall
 */
public class PrimeNumberMethod {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        int count = 0;
        
        for (int i = 1; i < 10000; i++) {
            if (isPrime(i)) {
                System.out.printf("%5d", i);
                count++;
                // Print a new line every 10 numbers
            if (count % 10 == 0) {
                System.out.println();
            }
            }
        }
    }

    /**
     * Check whether number is prime (Method from Listing 6.7)
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
}
