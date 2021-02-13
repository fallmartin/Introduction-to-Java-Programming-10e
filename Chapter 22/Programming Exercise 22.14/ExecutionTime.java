package executiontime;

import java.text.NumberFormat;
import java.util.*;

/**
 * (Execution time for prime numbers) Write a program that obtains the execution
 * time for finding all the prime numbers less than 8,000,000, 10,000,000,
 * 12,000,000, 14,000,000, 16,000,000, and 18,000,000 using the algorithms in
 * Listings 22.5–22.7. Your program should print a table like this:
 *
 * @author martinfall
 */
public class ExecutionTime {

    public static void main(String[] args) {

        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);

        // Print the table header to console
        System.out.printf("%14s|", " ");
        for (int i = 8_000_000; i <= 18_000_000; i += 2_000_000) {
            System.out.printf("%14s", nf.format(i));
        }

        // Print a border under the main header
        System.out.println();
        for (int i = 0; i < 99; i++) {
            System.out.print("-");
        }

        System.out.println(); // New line delimiter

        // LISTING 22.5 PrimeNumbers.java
        System.out.printf("%14s|", "Listing 22.5");
        
        // Print values of execution time for each case
        for (int i = 8_000_000; i <= 18_000_000; i += 2_000_000) {
            long start = System.currentTimeMillis();
            prime5(i);
            long end = System.currentTimeMillis();
            // System.out.println(end - start);
            // System.out.printf("%14s", nf.format(end - start));
            System.out.printf("%14s", end - start);
        }
        System.out.println();

        // LISTING 22.6 EfficientPrimeNumbers.java
        System.out.printf("%14s|", "Listing 22.6");
        
        // Print values of execution time for each case
        for (int i = 8_000_000; i <= 18_000_000; i += 2_000_000) {
            long start = System.currentTimeMillis();
            prime6(i);
            long end = System.currentTimeMillis();
            // System.out.println(end - start);
            // System.out.printf("%14s", nf.format(end - start));
            System.out.printf("%14s", end - start);
        }
        System.out.println();

        // LISTING 22.7 SieveOfEratosthenes.java
        System.out.printf("%14s|", "Listing 22.7");
        
        // Print values of execution time for each case
        for (int i = 8_000_000; i <= 18_000_000; i += 2_000_000) {
            long start = System.currentTimeMillis();
            prime7(i);
            long end = System.currentTimeMillis();
            // System.out.println(end - start);
            // System.out.printf("%14s", nf.format(end - start));
            System.out.printf("%14s", end - start);
        }
        System.out.println();
    }

    /**
     * LISTING 22.5 PrimeNumbers.java
     *
     * @param n
     */
    public static void prime5(int n) {
        // Number to be tested for primeness
        int number = 2;

        // Repeatedly find prime numbers
        while (number < n) {
            // Assume that number is prime
            boolean isPrime = true;

            // Test if the current number is prime
            for (int divisor = 2; divisor <= (int) (Math.sqrt(n)); divisor++) {
                if (number % divisor == 0) { // If true, number is not prime
                    isPrime = false; // Set isPrime to false
                    break; // Break out of the for loop
                }
            }

            number++; // Check if the next number is prime
        }
    }

    /**
     * LISTING 22.6 EfficientPrimeNumbers.java
     *
     * @param n
     */
    public static void prime6(int n) {
        // A list to hold prime numbers
        List<Integer> list = new java.util.ArrayList<>();

        int number = 2; // A number to be tested for primeness
        int squareRoot = 1; // Check whether number <= squareRoot

        // Repeatedly find prime numbers
        while (number < n) {
            // Assume that number is prime
            boolean isPrime = true;

            if (squareRoot * squareRoot < number) {
                squareRoot++;
            }

            // Test if the current number is prime
            for (int k = 0; k < list.size() && list.get(k) <= squareRoot; k++) {
                if (number % list.get(k) == 0) { // If true, number is not prime
                    isPrime = false; // Set isPrime to false
                    break; // Break out of the for loop
                }
            }

            number++; // Check if the next number is prime
        }
    }

    /**
     * LISTING 22.7 SieveOfEratosthenes.java
     *
     * @param n
     */
    public static void prime7(int n) {
        boolean[] primes = new boolean[n + 1]; // Prime number sieve

        // Initialize primes[i] to true
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int k = 2; k <= n / 2; k++) {
            if (primes[k]) {
                for (int i = k; i <= n / k; i++) {
                    primes[k * i] = false; // k * i is not prime
                }
            }
        }
    }
}
