
import java.math.BigInteger;

/**
 * (Convert decimals to fractions) Write a program that prompts the user to
 * enter a decimal number and displays the number in a fraction. Hint: read the
 * decimal number as a string, extract the integer part and fractional part from
 * the string, and use the BigInteger implementation of the Rational class in
 * Programming Exercise 13.15 to obtain a rational number for the decimal
 * number. Here are some sample runs:
 *
 * Enter a decimal number: 3.25
 * The fraction number is 13/4
 *
 * Enter a decimal number: -0.45452
 * The fraction number is -11363/25000
 *
 * @author martinfall
 */
public class Rational extends Number implements Comparable<Rational> {

    // BigInteger constants for 0, 1, and -1
    private static final BigInteger NEGATIVE_ONE = new BigInteger("-1");
    private static final BigInteger ZERO = new BigInteger("0");
    private static final BigInteger ONE = new BigInteger("1");

    // Data fields for numerator and denominator
    private BigInteger numerator = ZERO;
    private BigInteger denominator = ONE;

    /**
     * Constructs a Rational number with default properties.
     *
     */
    public Rational() {
        this(ZERO, ONE);
    }

    /**
     * Constructs a rational with specified numerator and denominator.
     *
     * @param numerator
     * @param denominator
     */
    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = gcd(numerator, denominator);
        this.numerator = ((denominator.compareTo(ZERO) == 1) ? ONE : NEGATIVE_ONE)
                .multiply(numerator).divide(gcd);
        this.denominator = denominator.abs().divide(gcd);
    }

    /**
     * Finds the GCD of two numbers.
     *
     * @param n
     * @param d
     * @return
     */
    private static BigInteger gcd(BigInteger n, BigInteger d) {
        BigInteger n1 = n.abs();
        BigInteger n2 = d.abs();
        BigInteger gcd = ONE;

        for (int k = 1; k <= n1.intValue() && k <= n2.intValue(); k++) {
            if (n1.intValue() % k == 0 && n2.intValue() % k == 0) {
                gcd = new BigInteger(k + "");
            }
        }
        return gcd;
    }

    /**
     * Returns numerator.
     *
     * @return
     */
    public BigInteger getNumerator() {
        return numerator;
    }

    /**
     * Returns denominator.
     *
     * @return
     */
    public BigInteger getDenominator() {
        return denominator;
    }

    /**
     * Adds a rational number to this rational.
     *
     * @param secondRational
     * @return
     */
    public Rational add(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator())
                .add(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /**
     * Subtracts a rational number to this rational.
     *
     * @param secondRational
     * @return
     */
    public Rational subtract(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator())
                .subtract(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /**
     * Multiply a rational number by this rational.
     *
     * @param secondRational
     * @return
     */
    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /**
     * Divide a rational number by this rational.
     *
     * @param secondRational
     * @return
     */
    public Rational divide(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        if (numerator.equals(ONE) && denominator.equals(ONE)) {
            return "1";
        } else if (denominator.equals(ONE)) {
            return numerator + "";
        } else if (numerator.equals(ZERO)) {
            return ZERO.toString();
        } else {
            return numerator + "/" + denominator;
        }
    }

    @Override
    public boolean equals(Object other) {
        return (this.subtract((Rational) (other))).getNumerator().equals(ZERO);
    }

    @Override // Implement the abstract intValue method in Number
    public int intValue() {
        return (int) doubleValue();
    }

    @Override // Implement the abstract longValue method in Number
    public long longValue() {
        return (long) doubleValue();
    }

    @Override // Implement the abstract floatValue method in Number
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override // Implement the doubleValue method in Number
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    @Override // Implement the compareTo method in Comparable
    public int compareTo(Rational o) {
        if (this.subtract(o).getNumerator().compareTo(ZERO) == 1) {
            return 1;
        } else if (this.subtract(o).getNumerator().compareTo(ZERO) == -1) {
            return -1;
        } else {
            return 0;
        }
    }
}
