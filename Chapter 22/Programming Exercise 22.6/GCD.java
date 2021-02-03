package gcd;

import java.util.*;

/**
 * (Execution time for GCD) Write a program that obtains the execution time for
 * finding the GCD of every two consecutive Fibonacci numbers from the index 40
 * to index 45 using the algorithms in Listings 22.3 and 22.4.
 *
 * (Hint: You can use the following code template to obtain the execution time.)
 *
 * long startTime = System.currentTimeMillis();
 * perform the task;
 * long endTime = System.currentTimeMillis();
 * long executionTime = endTime - startTime;
 *
 * @author martinfall
 */
public class GCD {

    // Data fields
    private static final long[] GCDresults = new long[6];
    private static final long[] GCDEuclidresults = new long[6];

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a long array to store Fibonacci numbers index 40 to 46
        long[] fib = new long[7];

        // Generate the Fibonacci numbers from index 40 to index 46
        // The pairs of consecutive Fibonacci numbers are 
        // (f(40), f(41))
        // (f(41), f(42))
        // (f(42), f(43))
        // (f(43), f(44))
        // (f(44), f(45))
        // (f(45), f(46))
        for (int i = 40, j = 0; i <= 46; i++, j++) {
            fib[j] = fib(i);
        }

        // Uncomment the following statement to display fib to console
        // System.out.println(Arrays.toString(fib));
        for (int i = 0, n = fib.length - 1; i < n; i++) {
            /**
             * Find the execution time of the GCD algorithm.
             */
            // Start the timer
            long startTime = System.currentTimeMillis();

            // Perform the calculations for gcd and gcdEuclid
            long gcd = gcd(fib[i + 1], fib[i]);
            // System.out.println(gcd);

            // Stop the timer and calculate the execution time
            long endTime = System.currentTimeMillis();
            long executionTimeGCD = endTime - startTime;

            /**
             * Find the execution time of the GCD Euclid algorithm.
             */
            // Start the timer
            startTime = System.currentTimeMillis();

            // Perform the calculations for gcd and gcdEuclid
            long gcdEuclid = gcdEuclid(fib[i + 1], fib[i]);
            // System.out.println(gcdEuclid);

            // Stop the timer and calculate the execution time
            endTime = System.currentTimeMillis();
            long executionTimeGCDEuclid = endTime - startTime;

            // Add the results to the corresponding arrays
            GCDresults[i] = executionTimeGCD;
            GCDEuclidresults[i] = executionTimeGCDEuclid;
        }

        /**
         * Display the results as a table.
         *
         *
         */
        // Display the first row
        System.out.printf("%24s|", " ");
        for (int i = 40; i < 46; i++) {
            System.out.printf("%8d", i);
        }
        System.out.println();

        // Display the line separator
        for (int i = 0; i < 75; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Listing 22.3 GCD results
        System.out.print("Listing 22.3 GCD\t|");
        for (int i = 0; i < GCDresults.length; i++) {
            System.out.printf("%8d", GCDresults[i]);
        }
        System.out.println();

        // Listing 22.4 GCDEuclid results
        System.out.print("Listing 22.4 GCDEuclid\t|");
        for (int i = 0; i < GCDEuclidresults.length; i++) {
            System.out.printf("%8d", GCDEuclidresults[i]);
        }
        System.out.println();
    }

    /**
     * The method for finding the Fibonacci number.
     *
     * @param n
     * @return
     */
    public static long fib(long n) {
        long f0 = 0; // for f(0)
        long f1 = 1; // for f(1)
        long f2 = 1; // for f(2)

        if (n == 0) {
            return f0;
        } else if (n == 1) {
            return f1;
        } else if (n == 2) {
            return f2;
        }

        for (int i = 3; i <= n; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f0 + f1;
        }

        return f2;
    }

    /**
     * Find gcd for integers m and n.
     *
     * @param m
     * @param n
     * @return
     */
    public static long gcd(long m, long n) {
        long gcd = 1;

        if (m % n == 0) {
            return n;
        }

        for (long k = n / 2; k >= 1; k--) {
            if (m % k == 0 && n % k == 0) {
                gcd = k;
                break;
            }
        }

        return gcd;
    }

    /**
     * Find gcd for integers m and n.
     *
     * @param m
     * @param n
     * @return
     */
    public static long gcdEuclid(long m, long n) {
        if (m % n == 0) {
            return n;
        } else {
            return gcdEuclid(n, m % n);
        }
    }
}
