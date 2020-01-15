
/**
 * uppose a pentagon is centered at (0, 0) with one point at the 0 o’clock
 * position, as shown in Figure 4.7c. Write a program that prompts the user to
 * enter the radius of the bounding circle of a pentagon and displays the
 * coordinates of the five corner points on the pentagon. Here is a sample run:
 *
 * Enter the radius of the bounding circle: 100
 * The coordinates of five points on the pentagon are
 * (95.1057, 30.9017)
 * (0.000132679, 100)
 * (-95.1056, 30.9019)
 * (-58.7788, -80.9015)
 * (58.7782, -80.902)
 * 
 * Actual output:
 * Enter the radius of the bounding circle: 100
 * The coordinates of five points on the pentagon are
 * (95.1057, 30.9017)
 * (0.0000, 100.0000)
 * (-95.1057, 30.9017)
 * (-58.7785, -80.9017)
 * (58.7785, -80.9017)
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class CornerPointCoordinates {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the radius of the bounding circle
        System.out.print("Enter the radius of the bounding circle: ");

        // Collect input from the user
        double radius = input.nextDouble();
        
        // Some assumptions
        // The five triangles contained inside the the pentagon connect at (0, 0)
        // and have a 72 degrees angle at that point of contact (360 / 5 = 72)

        // Point 1
        double x1 = radius * Math.cos(Math.toRadians(90 - 72));
        double y1 = radius * Math.sin(Math.toRadians(90 - 72));

        // Point 2
        double x2 = radius * Math.cos(Math.toRadians(90));
        double y2 = radius * Math.sin(Math.toRadians(90));

        // Point 3
        double x3 = radius * Math.cos(Math.toRadians(90 + 72));
        double y3 = radius * Math.sin(Math.toRadians(90 + 72));

        // Point 4
        double x4 = radius * Math.cos(Math.toRadians(270 - 36));
        double y4 = radius * Math.sin(Math.toRadians(270 - 36));

        // Point 5
        double x5 = radius * Math.cos(Math.toRadians(270 + 36));
        double y5 = radius * Math.sin(Math.toRadians(270 + 36));

        // Display the results
        System.out.println("The coordinates of five points on the pentagon are");
        System.out.printf("(%.4f, %.4f)\n", x1, y1);
        System.out.printf("(%.4f, %.4f)\n", x2, y2);
        System.out.printf("(%.4f, %.4f)\n", x3, y3);
        System.out.printf("(%.4f, %.4f)\n", x4, y4);
        System.out.printf("(%.4f, %.4f)\n", x5, y5);
    }
}
