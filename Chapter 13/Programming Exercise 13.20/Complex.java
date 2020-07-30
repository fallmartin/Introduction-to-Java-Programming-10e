
/**
 * (Math: The Complex class) A complex number is a number in the form a + bi,
 * where a and b are real numbers and i is the square root of -1 (imaginary
 * number). The numbers a and b are known as the real part and imaginary part of
 * the complex number, respectively. You can perform addition, subtraction,
 * multiplication, and division for complex numbers using the following
 * formulas:
 *
 * a + bi + c + di = (a + c) + (b + d)i
 * a + bi - (c + di) = (a - c) + (b - d)i
 * (a + bi)*(c + di) = (ac - bd) + (bc + ad)i
 * (a + bi)/(c + di) = (ac + bd)/(c2 + d2) + (bc - ad)i/(c2 + d2)
 *
 * You can also obtain the absolute value for a complex number using the
 * following
 * formula:
 *
 * | a + bi | = Math.sqrt(a^2 + b^2)
 *
 * (A complex number can be interpreted as a point on a plane by identifying the
 * (a,b) values as the coordinates of the point. The absolute value of the
 * complex number corresponds to the distance of the point to the origin, as
 * shown in Figure 13.10b.)
 *
 * Design a class named Complex for representing complex numbers and the
 * methods add, subtract, multiply, divide, and abs for performing complex
 * number
 * operations, and override toString method for returning a string
 * representation
 * for a complex number. The toString method returns (a + bi) as a
 * string. If b is 0, it simply returns a. Your Complex class should also
 * implement the Cloneable interface.
 *
 * Provide three constructors Complex(a, b), Complex(a), and Complex().
 * Complex() creates a Complex object for number 0 and Complex(a) creates
 * a Complex object with 0 for b. Also provide the getRealPart() and
 * getImaginaryPart() methods for returning the real and imaginary part of the
 * complex number, respectively.
 *
 * Write a test program that prompts the user to enter two complex numbers and
 * displays the result of their addition, subtraction, multiplication, division,
 * and absolute value. Here is a sample run:
 *
 * Enter the first complex number: 3.5 5.5
 * Enter the second complex number: -3.5 1
 * (3.5 + 5.5i) + (-3.5 + 1.0i) = 0.0 + 6.5i
 * (3.5 + 5.5i) - (-3.5 + 1.0i) = 7.0 + 4.5i
 * (3.5 + 5.5i) * (-3.5 + 1.0i) = -17.75 + -13.75i
 * (3.5 + 5.5i) / (-3.5 + 1.0i) = -0.5094 + -1.7i
 * |(3.5 + 5.5i)| = 6.519202405202649
 *
 * Output:
 * Enter the first complex number: 3.5 5.5
 * Enter the second complex number: -3.5 1
 * (3.5 + 5.5i) + (-3.5 + 1.0i) = (0.0 + 6.5i)
 * (3.5 + 5.5i) - (-3.5 + 1.0i) = (7.0 + 4.5i)
 * (3.5 + 5.5i) * (-3.5 + 1.0i) = (-17.75 + -15.75i)
 * (3.5 + 5.5i) / (-3.5 + 1.0i) = (-0.5094339622641509 + -1.7169811320754718i)
 * |(3.5 + 5.5i)| = 6.519202405202649
 * |(-3.5 + 1.0i)| = 3.640054944640259
 * c1 is (3.5 + 5.5i)
 * c3 is (3.5 + 5.5i)
 * c1.equals(c3) is true
 *
 * @author martinfall
 */
public class Complex implements Cloneable {

    // Private vars for real part and imaginary part of the complex number
    private double a;
    private double b;

    /**
     * Creates a Complex object for number 0.
     */
    public Complex() {
        this(0, 0);
    }

    /**
     * Creates a Complex object with 0 for b.
     *
     * @param a
     */
    public Complex(double a) {
        this(a, 0);
    }

    /**
     * Creates a Complex object with values a and b.
     *
     * @param a
     * @param b
     */
    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Returns a.
     *
     * @return
     */
    public double getRealPart() {
        return a;
    }

    /**
     * Returns b.
     *
     * @return
     */
    public double getImaginaryPart() {
        return b;
    }

    /**
     * Adds a complex number to this complex number.
     *
     * @param c
     * @return
     */
    public Complex add(Complex c) {
        // a + bi + c + di = (a + c) + (b + d)i
        return new Complex(a + c.a, b + c.b);
    }

    /**
     * Subtracts a complex number from this complex number.
     *
     * @param c
     * @return
     */
    public Complex subtract(Complex c) {
        // a + bi - (c + di) = (a - c) + (b - d)i
        return new Complex(a - c.a, b - c.b);
    }

    /**
     * Multiply a complex number by this complex number.
     *
     * @param c
     * @return
     */
    public Complex multiply(Complex c) {
        // (a + bi)*(c + di) = (ac - bd) + (bc + ad)i
        return new Complex(a * c.a - b * c.b, b * c.a + a * c.b);
    }

    /**
     * Divide a complex number by this complex number.
     *
     * @param c
     * @return
     */
    public Complex divide(Complex c) {
        // (a + bi)/(c + di) = (ac + bd)/(c^2 + d^2) + (bc - ad)i/(c^2 + d^2)
        return new Complex(
                (a * c.a + b * c.b) / (Math.pow(c.a, 2) + Math.pow(c.b, 2)),
                (b * c.a - a * c.b) / (Math.pow(c.a, 2) + Math.pow(c.b, 2)));
    }

    /**
     * Returns the the absolute value for a complex number.
     *
     * @return
     */
    public double abs() {
        // | a + bi | = Math.sqrt(a^2 + b^2)
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    @Override // The toString method returns (a + bi) as a string.
    public String toString() {
        return "(" + a + " + " + b + "i)";
    }

    @Override
    /**
     * Override the protected clone method defined in the Object class, and
     * strengthen its accessibility
     */
    public Object clone() throws CloneNotSupportedException {
        // Perform a shallow copy
        return super.clone(); // no fields of object type
    }

    @Override // Override the equals method defined in the Object class
    public boolean equals(Object obj) {
        return a == ((Complex) obj).a && b == ((Complex) obj).b;
    }

}
