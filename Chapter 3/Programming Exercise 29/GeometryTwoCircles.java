
/**
 * (Geometry: two circles) Write a program that prompts the user to enter the
 * center coordinates and radii of two circles and determines whether the second
 * circle is inside the first or overlaps with the first, as shown in Figure 3.10.
 * (Hint: circle2 is inside circle1 if the distance between the two
 * centers <= |r1 - r2| and circle2 overlaps circle1 if the distance between the
 * two centers <= r1 + r2. Test your program to cover all cases.)
 *
 * Here are the sample runs:
 *
 * Enter circle1's center x-, y-coordinates, and radius: 0.5 5.1 13
 * Enter circle2's center x-, y-coordinates, and radius: 1 1.7 4.5
 * circle2 is inside circle1
 *
 * Enter circle1's center x-, y-coordinates, and radius: 3.4 5.7 5.5
 * Enter circle2's center x-, y-coordinates, and radius: 6.7 3.5 3
 * circle2 overlaps circle1
 *
 * Enter circle1's center x-, y-coordinates, and radius: 3.4 5.5 1
 * Enter circle2's center x-, y-coordinates, and radius: 5.5 7.2 1
 * circle2 does not overlap circle1
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class GeometryTwoCircles {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter circle1's center x-, y-coordinates, and radius
        System.out.print("Enter circle1's center x-, y-coordinates, and radius: ");

        // Collect input for circle1 from the user
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double r1 = input.nextDouble();

        // Prompt the user to enter circle1's center x-, y-coordinates, and radius
        System.out.print("Enter circle1's center x-, y-coordinates, and radius: ");

        // Collect input for circle2 from the user
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double r2 = input.nextDouble();

        // Calculate the distance between points p1 = (x1, x2) and p2 = (x2, y2)
        // The formula is 
        // distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 -y1), 2))
        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

        // Determine if one cirle is inside another circle
        if (distance <= Math.abs(r1 - r2)) {
            System.out.println("circle2 is inside circle1");
        } else if (distance <= (r1 + r2)) { // Determine if the 2 circle overlap
            System.out.println("circle2 overlaps circle1");
        } else { // No overlap
            System.out.println("circle2 does not overlap circle1");
        }
    }
}
