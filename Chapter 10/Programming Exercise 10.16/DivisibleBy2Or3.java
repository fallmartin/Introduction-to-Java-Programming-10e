
import java.math.BigInteger;

/**
 * (Divisible by 2 or 3) Find the first ten numbers with 50 decimal digits that
 * are divisible by 2 or 3.
 *
 * Output:
 * 10000000000000000000000000000000000000000000000000
 * 10000000000000000000000000000000000000000000000002
 * 10000000000000000000000000000000000000000000000004
 * 10000000000000000000000000000000000000000000000005
 * 10000000000000000000000000000000000000000000000006
 * 10000000000000000000000000000000000000000000000008
 * 10000000000000000000000000000000000000000000000010
 * 10000000000000000000000000000000000000000000000011
 * 10000000000000000000000000000000000000000000000012
 * 10000000000000000000000000000000000000000000000014
 *
 * @author martinfall
 */
public class DivisibleBy2Or3 {

    public static void main(String[] args) {
        // Create a new BigInteger object with the value of the lowest number with
        // 50 decimal digits
        BigInteger number = new BigInteger("1000000000000000000000000000000000000"
                + "0000000000000");

        // Create a counter to keep track of numbers that satisfy our conditions
        int count = 0;

        // Perform as many check as necessary to find 10 numbers
        while (count < 10) {
            if (number.remainder(new BigInteger("2")).equals(BigInteger.ZERO)
                    || number.remainder(new BigInteger("3")).equals(BigInteger.ZERO)) {
                System.out.println(number); // Print the number to console
                count++; // Increment the counter
            }
            // Add one to the BigInteger number
            number = number.add(BigInteger.ONE);
        }
    }
}
