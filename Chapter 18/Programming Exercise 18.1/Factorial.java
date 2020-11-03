
import java.util.Scanner;
import java.math.BigInteger;

/**
 * (Factorial) Using the BigInteger class introduced in Section 10.9, you can
 * find the factorial for a large number (e.g., 100!). Implement the factorial
 * method using recursion. Write a program that prompts the user to enter an
 * integer and displays its factorial.
 *
 * Output:
 * Enter an integer: 100
 * Factorial of 100 is
 * 93326215443944152681699238856266700490715968264381621468592963895217599993229
 * 91560894146397615651828625369792082722375825118521091686400000000000000000000
 * 0000
 *
 *
 * @author martinfall
 */
public class Factorial {

    /**
     * Recursive method.
     *
     * @param number
     * @return
     */
    public static BigInteger factorial(int number) {
        // Convert the number to a BigInteger
        BigInteger biNumber = new BigInteger(Integer.toString(number));

        // Call auxiliary method.
        return factorial(biNumber, BigInteger.ONE);
    }

    /**
     * Tail recursive helper method with auxiliary parameters.
     *
     * @param number
     * @param i
     * @return
     */
    public static BigInteger factorial(BigInteger number, BigInteger result) {

        if (number.compareTo(BigInteger.ZERO) == 0) {
            return result;
        } else {
            return factorial(number.subtract(BigInteger.ONE),
                    number.multiply(result));
        }
    }

    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        // Display factorial
        System.out.println("Factorial of " + number + " is "
                + factorial(number));
    }
}
