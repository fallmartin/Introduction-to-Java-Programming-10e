
import java.util.Scanner;

/**
 * (Algebra: vertex form equations) The equation of a parabola can be expressed
 * in either standard form (y = ax^2 + bx + c) or vertex form (y = a(x - h)^2 +
 * k). Write a program that prompts the user to enter a, b, and c as integers in
 * standard form and displays h and k in the vertex form. Here are some sample
 * runs.
 *
 * Enter a, b, c: 1 3 1
 * h is -3/2 k is -5/4
 *
 * Enter a, b, c: 2 3 4
 * h is -3/4 k is 23/8
 *
 * @author martinfall
 */
public class VertexFromEquations {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a, b, c
        System.out.print("Enter a, b, c: ");
        Rational a = new Rational(input.nextInt(), 1);
        Rational b = new Rational(input.nextInt(), 1);
        Rational c = new Rational(input.nextInt(), 1);

        // Solve for h and k
        Rational h = new Rational(-b.getNumerator(), 2 * a.getNumerator());
        Rational k = c.subtract(
                new Rational(a.getNumerator() * b.getNumerator() * b.getNumerator(),
                        4 * a.getNumerator() * a.getNumerator()));

        // Display results
        System.out.printf("h is %s k is %s%n", h, k);
    }
}
