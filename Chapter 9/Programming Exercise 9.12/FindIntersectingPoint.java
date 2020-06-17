
import java.util.Scanner;

/**
 * Output:
 * Enter x1, y1, x2, y2, x3, y3, x4, y4: 2 2 5 -1.0 4.0 2.0 -1.0 -2.0
 * The intersecting point is at (2.88889, 1.11111)
 *
 * Enter x1, y1, x2, y2, x3, y3, x4, y4: 2 2 7 6.0 4.0 2.0 -1.0 -2.0
 * The two lines are parallel
 *
 * @author martinfall
 */
public class FindIntersectingPoint {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter x1, y1, x2, y2, x3, y3, x4, y4
        System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();
        double x4 = input.nextDouble();
        double y4 = input.nextDouble();

        // (y1 - y2)x - (x1 - x2)y = (y1 - y2)x1 - (x1 - x2)y1
        // (y3 - y4)x - (x3 - x4)y = (y3 - y4)x3 - (x3 - x4)y3
        double a = y1 - y2;
        double b = -(x1 - x2);
        double c = y3 - y4;
        double d = -(x3 - x4);
        double e = (y1 - y2) * x1 - (x1 - x2) * y1;
        double f = (y3 - y4) * x3 - (x3 - x4) * y3;

        // Create a new LinearEquation object
        LinearEquation le = new LinearEquation(a, b, c, d, e, f);
        String format = "The intersecting point is at (%.5f, %.5f)";

        if (le.isSolvable()) {
            System.out.printf(format, le.getX(), le.getY());
        } else {
            System.out.println("The two lines are parallel");
        }
    }
}
