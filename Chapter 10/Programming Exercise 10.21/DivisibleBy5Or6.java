
import java.math.BigInteger;

/**
 * (Divisible by 5 or 6) Find the first ten numbers greater than Long.MAX_VALUE
 * that are divisible by 5 or 6.
 *
 * Output:
 * 9223372036854775810
 * 9223372036854775812
 * 9223372036854775815
 * 9223372036854775818
 * 9223372036854775820
 * 9223372036854775824
 * 9223372036854775825
 * 9223372036854775830
 * 9223372036854775835
 * 9223372036854775836
 *
 * @author martinfall
 */
public class DivisibleBy5Or6 {

    public static void main(String[] args) {
        // Create a new BigInteger object and assign Long.MAX_VALUE to it
        BigInteger b = new BigInteger(Long.toString(Long.MAX_VALUE));

        // Declare a new counter variable of type int
        int counter = 0;

        // While counter is less than 10
        while (counter < 10) {
            if (isDivisibleBy5(b) || isDivisibleBy6(b)) {
                System.out.println(b); // Print the number to console
                counter++; // Increment the counter
            }
            b = b.add(BigInteger.ONE); // Increment b
        }
    }

    /**
     * Returns true if the BigInteger is divisible by 5.
     *
     * @param b
     * @return
     */
    public static boolean isDivisibleBy5(BigInteger b) {
        return (b.remainder(new BigInteger("5")).equals(BigInteger.ZERO));
    }

    /**
     * Returns true if the BigInteger is divisible by 6.
     *
     * @param b
     * @return
     */
    public static boolean isDivisibleBy6(BigInteger b) {
        return (b.remainder(new BigInteger("6")).equals(BigInteger.ZERO));
    }
}
