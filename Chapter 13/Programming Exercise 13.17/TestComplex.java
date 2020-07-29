
import java.util.Scanner;

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
public class TestComplex {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the first complex number
        System.out.print("Enter the first complex number: ");
        Complex c1 = new Complex(input.nextDouble(), input.nextDouble());

        // Prompt the user to enter the second complex number
        System.out.print("Enter the second complex number: ");
        Complex c2 = new Complex(input.nextDouble(), input.nextDouble());

        // Display the results of add, subtract, multiply, divide, and abs methods
        System.out.println(c1 + " + " + c2 + " = " + c1.add(c2));
        System.out.println(c1 + " - " + c2 + " = " + c1.subtract(c2));
        System.out.println(c1 + " * " + c2 + " = " + c1.multiply(c2));
        System.out.println(c1 + " / " + c2 + " = " + c1.divide(c2));
        System.out.println("|" + c1 + "|" + " = " + c1.abs());
        System.out.println("|" + c2 + "|" + " = " + c2.abs());

        try {
            // Create a new Complex obj ref var and assign to it the cloned value of c1
            Complex c3 = (Complex) c1.clone();
            System.out.println("c1 is " + c1);
            System.out.println("c3 is " + c3);
            System.out.println("c1.equals(c3) is " + c1.equals(c3));
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex);
        }
    }
}
