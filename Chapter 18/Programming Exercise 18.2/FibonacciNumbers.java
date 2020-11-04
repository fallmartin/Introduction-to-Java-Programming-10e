
import java.util.Scanner;

/**
 * (Fibonacci numbers) Rewrite the fib method in Listing 18.2 using iterations.
 * Hint: To compute fib(n) without recursion, you need to obtain fib(n - 2) and
 * fib(n - 1) first. Let f0 and f1 denote the two previous Fibonacci numbers.
 * The current Fibonacci number would then be f0 + f1.
 *
 * Write a test program that prompts the user to enter an index and displays its
 * Fibonacci number.
 *
 * Output:
 * Enter an index: 27
 * The Fibonacci number at index 27 is 196418
 *
 * @author martinfall
 */
public class FibonacciNumbers {

    private static int currentFib;

    public static long fib(int n) {
        int f0 = 0;
        int f1 = 1;

        for (int i = 1; i < n; i++) {
            // Current Fibonacci sequence number
            currentFib = f0 + f1;

            // Update the two previous values of the sequence internally
            f0 = f1;
            f1 = currentFib;
        }

        return currentFib;
    }

    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index: ");
        int index = input.nextInt();

        // The display the Fibonacci number at that index
        System.out.println("The Fibonacci number at index "
                + index + " is " + fib(index));
    }
}
