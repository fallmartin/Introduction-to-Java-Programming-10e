
import java.util.Scanner;

/**
 * Write a test program that prompts the user to enter values for a, b, and c
 * and displays the result based on the discriminant. If the discriminant is
 * positive, display the two roots. If the discriminant is 0, display the one
 * root. Otherwise, display “The equation has no roots.”
 *
 * See Programming Exercise 3.1 for sample runs.
 *
 * @author martinfall
 */
public class TestQuadraticEquation {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a, b, and c
        System.out.print("Enter a, b, and c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        // Create a new QuadraticEquation object
        QuadraticEquation q = new QuadraticEquation(a, b, c);
        
        if (q.getDiscriminant() > 0) {
            System.out.println("Root 1: " + q.getRoot1());
            System.out.println("Root 2: " + q.getRoot2());
        } else if (q.getDiscriminant() == 0) {
            System.out.println("Root: " + q.getRoot1());
        } else {
            System.out.println("The equation has no roots.");
        }
    }
}
