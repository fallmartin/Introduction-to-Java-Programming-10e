
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class ComputeFibonacci {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index for a Fibonacci number: ");
        int index = input.nextInt();

        // Find and display the Fibonacci number
        System.out.println("The Fibonacci number at index "
                + index + " is " + fib(index));
    }

    /**
     * Returns the Fibonacci number for the index.
     *
     * @param index
     * @return
     */
    public static long fib(int index) {
        if (index == 0) { // Base case
            return 0;
        } else if (index == 1) { // Base case
            return 1;
        } else { // Reduction and recursive calls
            return fib(index - 2) + fib(index - 1);
        }
    }
}
