
import java.util.Scanner;

/**
 * (Fibonacci series) Modify Listing 18.2, ComputeFibonacci.java, so that the
 * program finds the number of times the fib method is called. (Hint: Use a
 * static variable and increment it every time the method is called.)
 *
 * Output:
 * Enter an index for a Fibonacci number: 4
 * The Fibonacci number at index 4 is 3
 * The method fib was called 9 times.
 *
 * @author martinfall
 */
public class FibonacciSeries {

    // Declare a static variable counter
    static int counter = 0;

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
        // Display the number of times the method fib was called
        System.out.println("The method fib was called " + counter + " times.");
    }

    /**
     * Returns the Fibonacci number for the index.
     *
     * @param index
     * @return
     */
    public static long fib(int index) {
        // Increment the counter every time the method fib is called
        counter++;
        if (index == 0) { // Base case
            return 0;
        } else if (index == 1) { // Base case
            return 1;
        } else { // Reduction and recursive calls
            return fib(index - 2) + fib(index - 1);
        }
    }
}
