
import java.math.BigInteger;

/**
 * (Mersenne prime) A prime number is called a Mersenne prime if it can be
 * written in the form 2^p - 1 for some positive integer p. Write a program that
 * finds all Mersenne primes with p less than or equal to 100 and displays the
 * output as shown below.
 *
 * p 2^p – 1
 * 2 3
 * 3 7
 * 5 31
 *
 * (Hint: You have to use BigInteger to store the number, because it is too big
 * to be stored in long. Your program may take several hours to run.)
 *
 * Output:
 * p	2^p - 1
 * 3.0
 * 7.0
 * 31.0
 * 127.0
 * 2047.0
 * 8191.0
 * 131071.0
 * 524287.0
 * 8388607.0
 * 5.36870911E8
 * 2.147483647E9
 * 1.37438953471E11
 * 2.199023255551E12
 * 8.796093022207E12
 * 1.40737488355327E14
 * 9.007199254740991E15
 * 5.7646075230342349E17
 * 2.305843009213694E18
 * 1.4757395258967641E20
 * 2.3611832414348226E21
 * 9.44473296573929E21
 * 6.044629098073146E23
 * 9.671406556917033E24
 * 6.1897001964269014E26
 * 1.5845632502852868E29
 *
 * @author martinfall
 */
public class MersennePrime {

    public static void main(String[] args) {
        // Print the title
        System.out.println("p\t\t2^p - 1");

        // Print the results
        for (int p = 2; p <= 100; p++) {
            if (isPrime(p)) {
                System.out.println(String.valueOf(Math.pow(2, p) - 1));
            }
        }
    }

    /**
     * Returns true if the number p is prime
     *
     * @param p
     * @return
     */
    public static boolean isPrime(int p) {
        // If p = 2, return true
        if (p == 2) {
            return true;
        }
        // If the number is divisible by an integer ranging between 2 and p - 1
        for (int divisor = 2; divisor < p; divisor++) {
            if (p % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
