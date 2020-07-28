
/**
 * (Demonstrate the benefits of encapsulation) Rewrite the Rational class in
 * Listing 13.13 using a new internal representation for the numerator and
 * denominator. Create an array of two integers as follows:
 *
 * private long[] r = new long[2];
 *
 * Use r[0] to represent the numerator and r[1] to represent the denominator. The
 * signatures of the methods in the Rational class are not changed, so a client
 * application that uses the previous Rational class can continue to use this new
 * Rational class without being recompiled.
 *
 * @author martinfall
 */
public class Rational extends Number implements Comparable<Rational> {

    // Data fields for numerator and denominator
    private long[] r = new long[2];

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
        r[0] = ((denominator > 1) ? 1 : -1) * numerator / gcd;
        r[1] = Math.abs(denominator) / gcd;
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
        return r[0];
    }

    /**
     * Returns denominator.
     *
     * @return
     */
    public long getDenominator() {
        return r[1];
    }

    /**
     * Adds a rational number to this rational.
     *
     * @param secondRational
     * @return
     */
    public Rational add(Rational secondRational) {
        long n = getNumerator() * secondRational.getDenominator()
                + getDenominator() * secondRational.getNumerator();
        long d = getDenominator() * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /**
     * Subtracts a rational number to this rational.
     *
     * @param secondRational
     * @return
     */
    public Rational subtract(Rational secondRational) {
        long n = getNumerator() * secondRational.getDenominator()
                - getDenominator() * secondRational.getNumerator();
        long d = getDenominator() * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /**
     * Multiply a rational number by this rational.
     *
     * @param secondRational
     * @return
     */
    public Rational multiply(Rational secondRational) {
        long n = getNumerator() * secondRational.getNumerator();
        long d = getDenominator() * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /**
     * Divide a rational number by this rational.
     *
     * @param secondRational
     * @return
     */
    public Rational divide(Rational secondRational) {
        long n = getNumerator() * secondRational.getDenominator();
        long d = getDenominator() * secondRational.getNumerator();
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        if (getDenominator() == 1) {
            return getNumerator() + "";
        } else if (getNumerator() == 0) {
            return 0 + "";
        } else {
            return getNumerator() + "/" + getDenominator();
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
        return getNumerator() * 1.0 / getDenominator();
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
