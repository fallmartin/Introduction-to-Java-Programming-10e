
import java.util.Scanner;
import javafx.geometry.Point2D;

/**
 * Output:
 * Enter point1's x-, y-coordinates: 1.5 5.5
 * Enter point2's x-, y-coordinates: -5.3 -4.4
 * p1 is Point2D [x = 1.5, y = 5.5]
 * p2 is Point2D [x = -5.3, y = -4.4]
 * The distance between p1 and p2 is 12.010412149464313
 *
 * @author martinfall
 */
public class TestPoint2D {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter point1's x-, y-coordinates: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        System.out.print("Enter point2's x-, y-coordinates: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        Point2D p1 = new Point2D(x1, y1);
        Point2D p2 = new Point2D(x2, y2);
        System.out.println("p1 is " + p1.toString());
        System.out.println("p2 is " + p2.toString());
        System.out.println("The distance between p1 and p2 is " + p1.distance(p2));
    }
}
