
import java.math.BigInteger;

/**
 * (Large prime numbers) Write a program that finds five prime numbers larger
 * than Long.MAX_VALUE.
 *
 * Note: This is not an efficient solution, but the logic is satisfactory.
 *
 * @author martinfall
 */
public class findPrime {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a BigInteger to hold Long.MAX_VALUE
        BigInteger b = new BigInteger(Long.toString(Long.MAX_VALUE));

        // Create a new variable to keep track of primes found
        int numberOfPrimes = 0;

        while (numberOfPrimes < 5) { // while the desired number of primes is not reached
            if (isPrime(b)) { // If the number is prime
                System.out.println(b); // Display to the console
                numberOfPrimes++; // Increment the number of primes
            }
            b = b.add(BigInteger.ONE); // Increment b
        }
    }

    /**
     * Returns true if a BigInteger number is prime
     *
     * @param b
     * @return
     */
    public static boolean isPrime(BigInteger b) {
        // for (int divisor = 2; divisor < b / 2; divisor++)
        for (BigInteger divisor = new BigInteger("2");
                divisor.compareTo(b.divide(new BigInteger("2"))) == -1;
             // I may need to add || divisor.compareTo(b.divide(new BigInteger("2"))) == 0 to include the uppderlimit b / 2
                divisor = divisor.add(BigInteger.ONE)) {
            if (b.divide(divisor).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
    }
}
