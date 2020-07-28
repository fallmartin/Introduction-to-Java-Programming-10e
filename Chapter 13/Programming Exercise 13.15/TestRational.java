
import java.math.BigInteger;

/**
 * (Use BigInteger for the Rational class) Redesign and implement the Rational
 * class in Listing 13.13 using BigInteger for the numerator and denominator.
 *
 * Output:
 * 1
 * 1/2
 * 1
 * 2
 *
 * @author martinfall
 */
public class TestRational {

    public static void main(String[] args) {
        // Create 4 Rational objects with the new BigInteger constructor
        Rational r1 = new Rational(new BigInteger("2"), new BigInteger("2"));
        Rational r2 = new Rational(new BigInteger("2"), new BigInteger("4"));
        Rational r3 = new Rational(new BigInteger("4"), new BigInteger("4"));
        Rational r4 = new Rational(new BigInteger("4"), new BigInteger("2"));

        // Display the 4 Rational objects to the console
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
    }
}
