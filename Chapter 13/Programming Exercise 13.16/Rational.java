
/**
 * (Create a rational-number calculator) Write a program similar to Listing 7.9,
 * Calculator.java. Instead of using integers, use rationals, as shown in
 * Figure 13.10a. You will need to use the split method in the String class,
 * introduced in Section 10.10.3, Replacing and Splitting Strings, to retrieve
 * the numerator string and denominator string, and convert strings into integers
 * using the Integer.parseInt method.
 *
 * FIGURE 13.10 (a) The program takes three arguments (operand1, operator, and
 * operand2) from the command line and displays the expression and the result of
 * the arithmetic operation. (b) A complex number can be interpreted as a point
 * in a plane.
 *
 * @author martinfall
 */
public class Rational extends Number implements Comparable<Rational> {

    // Data fields for numerator and denominator
    private long numerator = 0;
    private long denominator = 1;

    /**
     * Constructs a Rational number with default properties.
     *
     */
    public Rational() {
        this(0, 1);
    }

    /**
     * Constructs a rational with specified numerator and denominator.
     *
     * @param numerator
     * @param denominator
     */
    public Rational(long numerator, long denominator) {
        long gcd = gcd(numerator, denominator);
        this.numerator = ((denominator > 1) ? 1 : -1) * numerator / gcd;
        this.denominator = Math.abs(denominator) / gcd;
    }

    /**
     * Finds the GCD of two numbers.
     *
     * @param n
     * @param d
     * @return
     */
    private static long gcd(long n, long d) {
        long n1 = Math.abs(n);
        long n2 = Math.abs(d);
        int gcd = 1;

        for (int k = 1; k <= n1 && k <= n2; k++) {
            if (n1 % k == 0 && n2 % k == 0) {
                gcd = k;
            }
        }
        return gcd;
    }

    /**
     * Returns numerator.
     *
     * @return
     */
    public long getNumerator() {
        return numerator;
    }

    /**
     * Returns denominator.
     *
     * @return
     */
    public long getDenominator() {
        return denominator;
    }

    /**
     * Adds a rational number to this rational.
     *
     * @param secondRational
     * @return
     */
    public Rational add(Rational secondRational) {
        long n = numerator * secondRational.getDenominator()
                + denominator * secondRational.getNumerator();
        long d = denominator * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /**
     * Subtracts a rational number to this rational.
     *
     * @param secondRational
     * @return
     */
    public Rational subtract(Rational secondRational) {
        long n = numerator * secondRational.getDenominator()
                - denominator * secondRational.getNumerator();
        long d = denominator * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /**
     * Multiply a rational number by this rational.
     *
     * @param secondRational
     * @return
     */
    public Rational multiply(Rational secondRational) {
        long n = numerator * secondRational.getNumerator();
        long d = denominator * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /**
     * Divide a rational number by this rational.
     *
     * @param secondRational
     * @return
     */
    public Rational divide(Rational secondRational) {
        long n = numerator * secondRational.getDenominator();
        long d = denominator * secondRational.getNumerator();
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return numerator + "";
        } else if (numerator == 0) {
            return numerator + "";
        } else {
            return numerator + "/" + denominator;
        }
    }

    @Override
    public boolean equals(Object other) {
        return (this.subtract((Rational) (other))).getNumerator() == 0;
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
        return numerator * 1.0 / denominator;
    }

    @Override // Implement the compareTo method in Comparable
    public int compareTo(Rational o) {
        if (this.subtract(o).getNumerator() > 0) {
            return 1;
        } else if (this.subtract(o).getNumerator() < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
