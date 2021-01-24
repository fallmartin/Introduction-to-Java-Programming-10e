
import java.util.*;

/**
 * Output:
 * Enter an index for the Fibonacci number: 6
 * Fibonacci number at index 6 is 8
 *
 * Enter an index for the Fibonacci number: 7
 * Fibonacci number at index 7 is 13
 *
 * @author martinfall
 */
public class ImprovedFibonacci {

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index for the Fibonacci number: ");
        int index = input.nextInt();

        // Find and display the Fibonacci number
        System.out.println(
                "Fibonacci number at index " + index + " is " + fib(index));
    }

    /**
     * The method for finding the Fibonacci number
     *
     * @param index
     * @return
     */
    public static long fib(int n) {
        long f0 = 0; // For f(0)
        long f1 = 1; // For f(1)
        long f2 = 1; // For f(2)

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
}
