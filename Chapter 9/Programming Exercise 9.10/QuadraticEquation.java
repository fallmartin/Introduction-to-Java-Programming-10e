
/**
 * (Algebra: quadratic equations) Design a class named QuadraticEquation for
 * a quadratic equation ax2 + bx + x = 0. The class contains:
 *
 * ■ Private data fields a, b, and c that represent three coefficients.
 * ■ A constructor for the arguments for a, b, and c.
 * ■ Three getter methods for a, b, and c.
 * ■ A method named getDiscriminant() that returns the discriminant, which is
 * b2 - 4ac.
 * ■ The methods named getRoot1() and getRoot2() for returning two roots of
 * the equation
 * r1 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a
 * r2 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a
 *
 * These methods are useful only if the discriminant is nonnegative. Let these
 * methods return 0 if the discriminant is negative.
 *
 * Draw the UML diagram for the class and then implement the class. Write a test
 * program that prompts the user to enter values for a, b, and c and displays the
 * result based on the discriminant. If the discriminant is positive, display the
 * two roots. If the discriminant is 0, display the one root. Otherwise, display
 * “The equation has no roots.” See Programming Exercise 3.1 for sample runs.
 *
 * @author martinfall
 */
public class QuadraticEquation {

    // Private data fields a, b, and c that represent three coefficients.
    private double a;
    private double b;
    private double c;

    // A constructor for the arguments for a, b, and c.
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Three getter methods for a, b, and c.
    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    // A method named getDiscriminant() that returns the discriminant, which is 
    // b^2 - 4ac.
    public double getDiscriminant() {
        return Math.pow(getB(), 2) - 4 * getA() * getC();
    }

    // The methods named getRoot1() and getRoot2() for returning two roots of
    // the equation
    // r1 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a
    // r2 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a
    //
    // These methods are useful only if the discriminant is nonnegative. Let these
    // methods return 0 if the discriminant is negative.
    public double getRoot1() {
        if (getDiscriminant() < 0) {
            return 0;
        }
        return (-getB() + Math.sqrt(Math.pow(getB(), 2) - 4 * getA() * getC()))
                / 2 * getA();
    }

    public double getRoot2() {
        if (getDiscriminant() < 0) {
            return 0;
        }
        return (-getB() - Math.sqrt(Math.pow(getB(), 2) - 4 * getA() * getC()))
                / 2 * getA();
    }
}
