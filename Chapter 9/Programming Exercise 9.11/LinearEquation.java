
/**
 * (Algebra: 2 * 2 linear equations) Design a class named LinearEquation for a
 * 2 * 2 system of linear equations:
 * ax + by = e
 * cx + dy = f
 * x = (ed - bf) / (ad - bc)
 * y = (af - ec) / (ad - bc)
 *
 * The class contains:
 * ■ Private data fields a, b, c, d, e, and f.
 * ■ A constructor with the arguments for a, b, c, d, e, and f.
 * ■ Six getter methods for a, b, c, d, e, and f.
 * ■ A method named isSolvable() that returns true if ad - bc is not 0.
 * ■ Methods getX() and getY() that return the solution for the equation.
 *
 * Draw the UML diagram for the class and then implement the class. Write a test
 * program that prompts the user to enter a, b, c, d, e, and f and displays the
 * result. If ad - bc is 0, report that “The equation has no solution.”
 * See Programming Exercise 3.3 for sample runs.
 *
 * @author martinfall
 */
public class LinearEquation {

    // Private data fields a, b, c, d, e, and f.
    private double a, b, c, d, e, f;

    // A constructor with the arguments for a, b, c, d, e, and f.
    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    // Six getter methods for a, b, c, d, e, and f.
    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getE() {
        return e;
    }

    public double getF() {
        return f;
    }

    public double getDenominator() {
        return getA() * getD() - getB() * getC();
    }

    // A method named isSolvable() that returns true if ad - bc is not 0.
    public boolean isSolvable() {
        if (getDenominator() == 0) {
            return false;
        }
        return true;
    }

    // Methods getX() and getY() that return the solution for the equation.
    // x = (ed - bf) / (ad - bc)
    public double getX() {
        return (getE() * getD() - getB() * getF()) / getDenominator();
    }

    // y = (af - ec) / (ad - bc)
    public double getY() {
        return (getA() * getF() - getE() * getC()) / getDenominator();
    }
}
