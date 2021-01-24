
import java.util.*;

/**
 * Output:
 * Enter first integer: 2525
 * Enter second integer: 125
 * The greatest common divisor for 2525 and 125 is 25
 *
 * Enter first integer: 3
 * Enter second integer: 3
 * The greatest common divisor for 3 and 3 is 3
 *
 * @author martinfall
 */
public class GCDEuclid {

    /**
     * Find GCD for integers m and n.
     *
     * @param m
     * @param n
     * @return
     */
    public static int gcd(int m, int n) {
        int gcd = 1;

        if (m % n == 0) {
            return n;
        } else {
            return gcd(n, m % n);
        }

    }

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two integers
        System.out.print("Enter first integer: ");
        int m = input.nextInt();
        System.out.print("Enter second integer: ");
        int n = input.nextInt();

        System.out.println("The greatest common divisor for " + m + " and "
                + n + " is " + gcd(m, n));
    }
}
