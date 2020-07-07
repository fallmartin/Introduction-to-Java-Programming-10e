
import java.util.ArrayList;
import java.util.Scanner;

/**
 * (Area of a convex polygon) A polygon is convex if it contains any line
 * segments that connects two points of the polygon. Write a program that
 * prompts the user to enter the number of points in a convex polygon, then
 * enter the points clockwise, and display the area of the polygon. Here is a
 * sample run of the program:
 *
 * Enter the number of the points: 7
 * Enter the coordinates of the points:
 * -12 0 -8.5 10 0 11.4 5.5 7.8 6 -5.5 0 -7 -3.5 -3.5
 * The total area is 250.075
 *
 * Note: The area in the textbook is different from the one I obtained. I
 * checked my results online at https://rechneronline.de/pi/simple-polygon.php.
 * The output is correct according to that and 2 other online calculators.
 *
 * Output:
 * Enter the number of points: 7
 * Enter the coordinates of the points:
 * -12 0 -8.5 10 0 11.4 5.5 7.8 6 -5.5 0 -7 -3.5 -3.5
 * The total area is 232.575
 * The total perimeter is 59.419
 *
 * @author martinfall
 */
public class AreaOfAConvexPolygon {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object.
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the number of points
        System.out.print("Enter the number of points: ");
        int points = input.nextInt();

        // Create 2 array lists to hold the x- and y-values of the points
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();

        // Prompt the user to enter the coordinates of the points
        System.out.println("Enter the coordinates of the points: ");

        for (int i = 0; i < points; i++) {
            x.add(input.nextDouble());
            y.add(input.nextDouble());
        }

        // Display the area of the convex polygon
        System.out.printf("The total area is %.3f%n", calculateArea(x, y, points));
        // Display the perimeter of the convex polygon
        System.out.printf("The total perimeter is %.3f%n", calculatePerimeter(x, y, points));
    }

    /**
     * Returns the area of a convex polygon using Gauss's area formula or
     * shoelace formula (https://en.wikipedia.org/wiki/Shoelace_formula)
     *
     * @param x
     * @param y
     * @param points
     * @return
     */
    public static double calculateArea(ArrayList<Double> x, ArrayList<Double> y, int points) {
        double area = 0;

        for (int i = 0; i < points; i++) {
            area += Math.abs(x.get(i) * y.get(i + 1 < points ? i + 1 : 0)
                    - y.get(i) * x.get(i + 1 < points ? i + 1 : 0)) / 2;
        }

        return area;
    }

    /**
     * Returns the perimeter of a convex polygon.
     *
     * @param x
     * @param y
     * @param points
     * @return
     */
    public static double calculatePerimeter(ArrayList<Double> x, ArrayList<Double> y, int points) {
        double perimeter = 0;

        for (int i = 0; i < points; i++) {
            perimeter += Math.sqrt(Math.pow(x.get(i + 1 < points ? i + 1 : 0) - x.get(i), 2)
                    + Math.pow(y.get(i + 1 < points ? i + 1 : 0) - y.get(i), 2));
        }

        return perimeter;
    }
}
