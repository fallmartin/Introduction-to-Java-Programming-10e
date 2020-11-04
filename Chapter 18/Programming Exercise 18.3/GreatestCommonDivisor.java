
import java.util.Scanner;

/**
 * (Compute greatest common divisor using recursion) The gcd(m, n) can also
 * be defined recursively as follows:
 *
 * - If m % n is 0, gcd(m, n) is n.
 * - Otherwise, gcd(m, n) is gcd(n, m % n).
 *
 * Write a recursive method to find the GCD. Write a test program that prompts
 * the user to enter two integers and displays their GCD.
 *
 * Output:
 * Enter two integers: 12 10
 * The greatest common divisor of 12 and 10 is 2
 *
 * @author martinfall
 */
public class GreatestCommonDivisor {

    /**
     * Returns the GCD of m and n.
     *
     * @param m
     * @param n
     * @return
     */
    public static int gcd(int m, int n) {
        if (m % n == 0) { // Base call
            return n;
        } else {
            return gcd(n, m % n); // Reduction and recursive call
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        int m = input.nextInt();
        int n = input.nextInt();

        System.out.println("The greatest common divisor of " + m + " and " + n
                + " is " + gcd(m, n));
    }
}
