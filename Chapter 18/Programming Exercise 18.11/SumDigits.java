
import java.util.Scanner;

/**
 * (Sum the digits in an integer using recursion) Write a recursive method that
 * computes the sum of the digits in an integer. Use the following method
 * header:
 *
 * public static int sumDigits(long n)
 *
 * For example, sumDigits(234) returns 2 + 3 + 4 = 9. Write a test program that
 * prompts the user to enter an integer and displays its sum.
 *
 * Output:
 * Enter an integer: 234
 * The sum of the digits in 234 is
 * 4 + 3 + 2 = 9
 *
 * @author martinfall
 */
public class SumDigits {

    /**
     * Returns the sum of the digits in an integer n.
     *
     * @param n
     * @return
     */
    public static int sumDigits(long n) {
        return sumDigits(n, 0); // Call auxiliary method.
    }

    /**
     * Recursive helper method with auxiliary parameter sum.
     *
     * @param n
     * @param sum
     * @return
     */
    public static int sumDigits(long n, int sum) {
        if (n / 10 == 0) { // Base call
            System.out.print(n + " = ");
            return sum + (int) n;
        } else {
            int remainder = (int) (n % 10);
            System.out.print(remainder + " + ");
            return sumDigits(n / 10, sum + remainder);
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
        System.out.print("Enter an integer: ");
        long n = input.nextLong();

        System.out.println("The sum of the digits in " + n + " is ");
        int sum = sumDigits(n);
        System.out.println(sum);
    }
}
