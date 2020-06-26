
import java.math.BigInteger;

/**
 * (Square numbers) Find the first ten square numbers that are greater than
 * Long.MAX_VALUE. A square number is a number in the form of n^2. For example,
 * 4, 9, and 16 are square numbers. Find an efficient approach to run your
 * program fast.
 *
 * Output:
 * 9223372037000250000
 * 9223372043074251001
 * 9223372049148252004
 * 9223372055222253009
 * 9223372061296254016
 * 9223372067370255025
 * 9223372073444256036
 * 9223372079518257049
 * 9223372085592258064
 * 9223372091666259081
 *
 * @author martinfall
 */
public class SquareNumbers {

    public static void main(String[] args) {
        // Create a new BigInteger object equal to Long.MAX_VALUE for comparison
        BigInteger number = new BigInteger(Long.toString(Long.MAX_VALUE));

        // Find the square root of number and save it in a long variable
        long sqrt = (long) Math.sqrt(Long.MAX_VALUE);

        // Create a new BigInteger object equal to value of sqrt for incrementing
        BigInteger n = new BigInteger(Long.toString(sqrt));

        // Declare a variable to keep track of numbers found
        int count = 0;

        // Find the first 10 square numbers that are greater than Long.MAX_VALUE
        while (count < 10) {
            if (n.multiply(n).compareTo(number) == 1) {
                System.out.println(n.multiply(n)); // Print the number to console
                count++; // Increment the counter
            }
            // Increment number by 1
            n = n.add(BigInteger.ONE);
        }
    }
}
