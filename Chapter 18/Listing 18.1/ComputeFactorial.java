
import java.util.Scanner;

/**
 * Output:
 *
 * Enter a nonnegative integer: 4
 * Factorial of 4 is 24
 *
 * @author martinfall
 */
public class ComputeFactorial {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a nonnegative integer: ");
        int n = input.nextInt();

        // Display factorial
        System.out.println("Factorial of " + n + " is " + factorial(n));
    }

    /**
     * Return the factorial for the specified number.
     *
     * @param n
     * @return
     */
    public static long factorial(int n) {
        if (n == 0) { // Base case
            return 1;
        } else {
            return n * factorial(n - 1); // Recursive call
        }
    }
}
