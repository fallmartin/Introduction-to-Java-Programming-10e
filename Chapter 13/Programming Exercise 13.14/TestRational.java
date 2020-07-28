
/**
 * Output:
 * 4/5 + 4/5 = 8/5
 * 4/5 - 4/5 = 0
 * 4/5 x 4/5 = 16/25
 * 4/5 ÷ 4/5 = 1
 *
 * @author martinfall
 */
public class TestRational {

    public static void main(String[] args) {
        // Create a new Rational object
        Rational r = new Rational(4, 5);

        // A few method calls on members of Rational
        System.out.println(r + " + " + (new Rational(4, 5) + "")
                + " = " + (r.add(new Rational(4, 5))));
        System.out.println(r + " - " + (new Rational(4, 5) + "")
                + " = " + (r.subtract(new Rational(4, 5))));
        System.out.println(r + " x " + (new Rational(4, 5) + "")
                + " = " + (r.multiply(new Rational(4, 5))));
        System.out.println(r + " ÷ " + (new Rational(4, 5) + "")
                + " = " + (r.divide(new Rational(4, 5))));
    }
}
