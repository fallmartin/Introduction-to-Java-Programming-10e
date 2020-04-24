
/**
 * (Mersenne prime) A prime number is called a Mersenne prime if it can be written
 * in the form 2^p - 1 for some positive integer p. Write a program that finds all
 * Mersenne primes with p <= 31 and displays the output as follows:
 *
 * p         2^p - 1
 * --------------------
 * 2         3
 * 3         7
 * 5         31
 * 7         127
 * 13        8191
 * 17        131071
 * 19        524287
 * 31        2147483647
 *
 * @author martinfall
 */
public class MersennePrime {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        printMarsennePrimes(31);
    }

    /**
     * Print Marsenne primes
     *
     * @param numberOfMarsennePrimes
     */
    public static void printMarsennePrimes(int numberOfMarsennePrimes) {
        // Print table header
        System.out.printf("%-10s%-10s%n", "p", "2^p - 1");
        System.out.println("--------------------");

        // Print table body
        for (int i = 2; i <= numberOfMarsennePrimes; i++) {
            if (isPrime(getMarsennePrime(i))) {
                System.out.printf("%-10s%-10s%n", i, getMarsennePrime(i));
            }
        }
    }

    /**
     * Return 2^p - 1 for p
     *
     * @param p
     * @return
     */
    public static int getMarsennePrime(int p) {
        return (int) (Math.pow(2, p) - 1);
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
