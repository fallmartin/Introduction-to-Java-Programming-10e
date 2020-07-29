
import java.math.BigInteger;

/**
 * (Use the Rational class) Write a program that computes the following
 * summation
 * series using the Rational class:
 *
 * 1/2 + 2/3 + 3/4 + ... + 98/99 + 99/100
 *
 * You will discover that the output is incorrect because of integer overflow
 * (too large). To fix this problem, see Programming Exercise 13.15.
 *
 * @author martinfall
 */
public class SummationSeries {

    public static void main(String[] args) {

        // Create a new Rational object for the result of the summation series
        // The initial value of results is the first term of the summation (1/2)
        Rational result = new Rational();

        /**
         * Remember that BigInteger objects are immutable, so
         * i.add(BigInteger.ONE) wouldn't work. We have to assign the result of
         * that statement to i, thus creating a new BigInteger object.
         */
//        for (BigInteger i = BigInteger.ONE; // i = 1
//                i.compareTo(new BigInteger("100")) < 0; // i < 100
//                i = i.add(BigInteger.ONE)) { // i++
//            result = result.add(new Rational(i, i.add(BigInteger.ONE)));
//        }
        for (int i = 1; i < 100; i++) {
            result = result.add(new Rational(
                    new BigInteger(i + ""), new BigInteger((i + 1) + "")));
        }

        // Display the result of the summation series in a decimal format
        System.out.println(result.getNumerator().divide(result.getDenominator()));
    }
}
