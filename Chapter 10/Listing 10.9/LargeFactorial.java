
import java.math.*;

/**
 * Output:
 * 50! is
 * 30414093201713378043612608166064768844377641568960512000000000000
 *
 * @author martinfall
 */
public class LargeFactorial {

    public static void main(String[] args) {
        System.out.println("50! is \n" + factorial(50));
    }

    public static BigInteger factorial(long n) {
        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            result = result.multiply(new BigInteger(i + ""));
        }

        return result;
    }
}
