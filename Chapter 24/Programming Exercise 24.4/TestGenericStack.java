package genericstack;

import java.util.Arrays;

/**
 * (Use the GenericStack class) Write a program that displays the first 50 prime
 * numbers in descending order. Use a stack to store the prime numbers.
 *
 * Output:
 * 50 primes found!
 * ------------------------------------------------------------------------------
 * 229	227	223	211	199	197	193	191	181	179
 * 173	167	163	157	151	149	139	137	131	127
 * 113	109	107	103	101	97	89	83	79	73
 * 71	67	61	59	53	47	43	41	37	31
 * 29	23	19	17	13	11	7	5	3	2
 *
 * @author martinfall
 */
public class TestGenericStack {

    public static void main(String[] args) {
        GenericStack<Integer> nPrimes = getNPrimes(50);
        printStack(nPrimes);
    }

    /**
     * Returns a stack of n primes.
     *
     * @param n the number of primes to return
     * @return a stack of n primes
     */
    private static GenericStack<Integer> getNPrimes(int n) {
        // Declare and initialize a starting max value to establish the range
        int maxValue = 2;

        // Repeatedly look for a number of found primes LTE to n
        while (countPrimesUpTo(maxValue) < n) {
            // If not found, double maxValue
            // For larger sets, may be optimal to do maxValue * maxValue
            maxValue = maxValue * 2;
        }

        // Build the stack of n primes with maxValue as upper bound
        GenericStack<Integer> primes = getNPrimes(n, maxValue);

        return primes; // return the stack to the caller method
    }

    /**
     * Returns the number of primes up to n.
     *
     * @param n the inclusive upper bound of the search range [2 - n] for primes
     * @return the number of primes found up to n
     */
    private static int countPrimesUpTo(int n) {
        // Declare and initialize a sieve of Eratosthenes
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true); // initialize to true

        // Mark multiples of primes as false
        for (int k = 2; k <= n / k; k++) {
            if (primes[k]) {
                for (int i = k; i <= n / k; i++) {
                    primes[k * i] = false; // k * i is not prime
                }
            }
        }

        // Count the found primes
        int found = 0;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                found++;
            }
        }

        // Return the number of primes found up to n
        return found;
    }

    /**
     * Returns a stack of n primes up to maxValue range.
     *
     * @param n
     * @param maxValue
     * @return
     */
    private static GenericStack<Integer> getNPrimes(int n, int maxValue) {
        // If the number of primes is larger than the max value
        if (n > maxValue) {
            // Throw an illegal state exception
            throw new IllegalStateException();
        }

        // Sieve of Eratosthenes
        boolean[] primes = new boolean[maxValue + 1];
        Arrays.fill(primes, true);

        for (int k = 2; k <= maxValue / k; k++) {
            if (primes[k]) {
                for (int i = k; i <= maxValue / k; i++) {
                    primes[k * i] = false;
                }
            }
        }

        // Build the stack of primes
        GenericStack<Integer> stack = new GenericStack<>();
        int found = 0;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                found++;
                stack.push(i);
            }
            if (stack.getSize() == n) {
                break;
            }
        }

        return stack; // return the stack to the caller method
    }

    public static <E> void printStack(GenericStack<E> stack) {
        int primesPerLine = 10;
        String spacer = "\t";

        System.out.println(stack.getSize() + " primes found!");

        String line = "";
        for (int i = 0; i <= 77; i++) {
            line += '-';
        }

        System.out.println(line);

        while (stack.getSize() > 0) {
            System.out.print(stack.pop());

            if (stack.getSize() % primesPerLine == 0) {
                System.out.println();
            } else {
                System.out.print(spacer);
            }
        }
    }
}
