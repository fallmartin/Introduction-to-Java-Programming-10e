
import java.util.Scanner;

/**
 * (Geometry: area of a triangle) Write a method that returns the area of a
 * triangle using the following header:
 *
 * public static double getTriangleArea(double[][] points)
 *
 * The points are stored in a 3-by-2 two-dimensional array points with points[0]
 * [0] and points[0][1] for (x1, y1). The triangle area can be computed using
 * the formula in Programming Exercise 2.19. The method returns 0 if the three
 * points are on the same line. Write a program that prompts the user to enter
 * three points of a triangle and displays the triangle's area. Here is a sample
 * run of the program:
 *
 * Enter x1, y1, x2, y2, x3, y3: 2.5 2 5 -1.0 4.0 2.0
 * The area of the triangle is 2.25
 *
 * Enter x1, y1, x2, y2, x3, y3: 2 2 4.5 4.5 6 6
 * The three points are on the same line
 *
 * @author martinfall
 */
public class AreaOfATriangle {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Create a points array
        double[][] points = new double[3][2];

        // Prompt the user to enter three points of a triangle
        System.out.print("Enter x1, y1, x2, y2, x3, y3: ");
        for (int row = 0; row < points.length; row++) {
            for (int column = 0; column < points[row].length; column++) {
                points[row][column] = input.nextDouble();
            }
        }

        // Display the triangle's area
        double area = getTriangleArea(points);

        if (area == 0) {
            System.out.println("The three points are on the same line");
        } else {
            System.out.printf("The area of the triangle is %.2f%n", area);
        }
    }

    /**
     * Calculate the area of a triangle
     *
     * @param points
     * @return
     */
    public static double getTriangleArea(double[][] points) {
        // (x1, y1)
        double x1 = points[0][0];
        double y1 = points[0][1];

        // (x2, y2)
        double x2 = points[1][0];
        double y2 = points[1][1];

        // (x3, y3)
        double x3 = points[2][0];
        double y3 = points[2][1];

        // If the points are collinear, return 0
        if ((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) == 0) {
            return 0;
        }

        // Calculate side 1
        double side1 = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

        // Calculate side2
        double side2 = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));

        // Calculate side3
        double side3 = Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow((y1 - y3), 2));

        // Calculate s
        double s = (side1 + side2 + side3) / 2;

        // Calculate the area of the triangle
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

        return area;
    }
}
