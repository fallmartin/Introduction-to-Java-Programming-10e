
import java.math.BigDecimal;

/**
 * (Approximate e) Programming Exercise 5.26 approximates e using the following
 * series:
 *
 * e = 1 + 1 / 1! + 1 / 2! + 1 / 3! + 1 / 4! + ... + 1 / i!
 *
 * In order to get better precision, use BigDecimal with 25 digits of precision
 * in the computation. Write a program that displays the e value for i = 100,
 * 200, ... , and 1000.
 *
 * Output:
 * For i = 100, e = 2.71828182845904523624
 * For i = 200, e = 2.71828182845904523724
 * For i = 300, e = 2.71828182845904523824
 * For i = 400, e = 2.71828182845904523924
 * For i = 500, e = 2.71828182845904524024
 * For i = 600, e = 2.71828182845904524124
 * For i = 700, e = 2.71828182845904524224
 * For i = 800, e = 2.71828182845904524324
 * For i = 900, e = 2.71828182845904524424
 * For i = 1000, e = 2.71828182845904524524
 *
 * @author martinfall
 */
public class ApproximateE {

    public static void main(String[] args) {
        for (int i = 100; i <= 1000; i = i + 100) {
            System.out.print("For i = " + i + ", e = ");
            // double e = 0;
            BigDecimal e = new BigDecimal(0);
            for (int j = 0; j <= i; j++) {
                // e += 1.0 / (factorial(j));
                e = e.add((BigDecimal.ONE).divide(factorial(new BigDecimal(j)), 20, BigDecimal.ROUND_UP));
            }
            System.out.println(e);
        }
    }

    public static BigDecimal factorial(BigDecimal number) {
        if (number.equals(BigDecimal.ZERO)) {
            return BigDecimal.ONE;
        } else {
            // return number * factorial (number - 1);
            return number.multiply(factorial(number.subtract(BigDecimal.ONE)));
        }
    }
}
