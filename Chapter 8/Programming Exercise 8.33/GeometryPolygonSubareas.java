
import java.util.Arrays;
import java.util.Scanner;

// The intersection point is at 0.6, -0.25. I'm missing the neg sign on the y
// I found the mistake in the formula transposing for Cramer's rule
/**
 * (Geometry: polygon subareas) A convex 4-vertex polygon is divided into four
 * triangles, as shown in Figure 8.9.
 *
 * Write a program that prompts the user to enter the coordinates of four
 * vertices and displays the areas of the four triangles in increasing order.
 * Here is a
 * sample run:
 *
 * Enter x1, y1, x2, y2, x3, y3, x4, y4:
 * -2.5 2 4 4 3 -2 -2 -3.5
 * The areas are 6.17 7.96 8.08 10.42
 *
 * Output:
 * Enter x1, y1, x2, y2, x3, y3, x4, y4:
 * -2.5 2 4 4 3 -2 -2 -3.5
 * [0.5977011494252874, 0.25287356321839083]
 * The areas are 7.43 8.08 8.33 8.78
 *
 * Corrected Output:
 * Enter x1, y1, x2, y2, x3, y3, x4, y4:
 * -2.5 2 4 4 3 -2 -2 -3.5
 * The areas are 6.17 7.96 8.08 10.42
 *
 * @author martinfall
 */
public class GeometryPolygonSubareas {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Create an array to store user-entered points
        double[][] points = new double[4][2];

        // Prompt the user to enter x1, y1, x2, y2, x3, y3, x4, y4
        System.out.println("Enter x1, y1, x2, y2, x3, y3, x4, y4:");
        for (int row = 0; row < points.length; row++) {
            for (int column = 0; column < points[row].length; column++) {
                points[row][column] = input.nextDouble();
            }
        }

        double[] areas = getPolygonSubareas(points);

        // System.out.println(Arrays.toString(areas));
        displayAreas(areas);
    }

    public static double[] getPolygonSubareas(double[][] points) {
        // v1(x1, y1)
        double x1 = points[0][0];
        double y1 = points[0][1];

        // v2(x2, y2)
        double x2 = points[1][0];
        double y2 = points[1][1];

        // v3(x3, y3)
        double x3 = points[2][0];
        double y3 = points[2][1];

        // v4(x4, y4)
        double x4 = points[3][0];
        double y4 = points[3][1];

        // vi(xi, yi)
        double[] solution = getIntersectingPoint(points);
        double xi = solution[0];
        double yi = solution[1];
        // System.out.println(Arrays.toString(solution));

        // Display intersecting point
        // System.out.println(Arrays.toString(solution));
        // Create 4 points arrays of 3 points to pass to getTriangleArea method
        // v1 v2 vi
        double[][] triangle1 = new double[3][2];
        triangle1[0][0] = x1;
        triangle1[0][1] = y1;
        triangle1[1][0] = x2;
        triangle1[1][1] = y2;
        triangle1[2][0] = xi;
        triangle1[2][1] = yi;

        // v2 v3 vi
        double[][] triangle2 = new double[3][2];
        triangle2[0][0] = x2;
        triangle2[0][1] = y2;
        triangle2[1][0] = x3;
        triangle2[1][1] = y3;
        triangle2[2][0] = xi;
        triangle2[2][1] = yi;

        // v3 v4 vi
        double[][] triangle3 = new double[3][2];
        triangle3[0][0] = x3;
        triangle3[0][1] = y3;
        triangle3[1][0] = x4;
        triangle3[1][1] = y4;
        triangle3[2][0] = xi;
        triangle3[2][1] = yi;

        // v4 v1 vi
        double[][] triangle4 = new double[3][2];
        triangle4[0][0] = x4;
        triangle4[0][1] = y4;
        triangle4[1][0] = x1;
        triangle4[1][1] = y1;
        triangle4[2][0] = xi;
        triangle4[2][1] = yi;

        // Create an array to store areas
        double[] areas = new double[4];

        areas[0] = getTriangleArea(triangle1);
        areas[1] = getTriangleArea(triangle2);
        areas[2] = getTriangleArea(triangle3);
        areas[3] = getTriangleArea(triangle4);

        // Sort the areas
        sort(areas);

        return areas;
    }

    /**
     * Return the intersecting point of points in the points array
     *
     * @param points
     * @return
     */
    public static double[] getIntersectingPoint(double[][] points) {
        // Careful with the assignment of points here
        // Make sure that the lines P1-P3 and P2-P4 intersect
        // (x1, y1)
        double x1 = points[0][0];
        double y1 = points[0][1];

        // (x2, y2)
        double x2 = points[1][0];
        double y2 = points[1][1];

        // (x3, y3)
        double x3 = points[2][0];
        double y3 = points[2][1];

        // (x4, y4)
        double x4 = points[3][0];
        double y4 = points[3][1];

        // Display points
        // String format = "(%f, %f)%n";
        // System.out.printf(format, x1, y1);
        // System.out.printf(format, x2, y2);
        // System.out.printf(format, x3, y3);
        // System.out.printf(format, x4, y4);
        // (y1 - y2)x - (x1 - x2)y = (y1 - y2)x1 - (x1 - x2)y1
        // (y3 - y4)x - (x3 - x4)y = (y3 - y4)x3 - (x3 - x4)y3
        double a = y1 - y3;
        double b = - 1 * (x1 - x3);
        double e = (y1 - y3) * x1 - (x1 - x3) * y1;

        double c = y2 - y4;
        double d = - 1 * (x2 - x4);
        double f = (y2 - y4) * x2 - (x2 - x4) * y2;

        // System.out.println("a  =  " + a);
        // System.out.println("b  =  " + b);
        // System.out.println("e  =  " + e);
        // System.out.println("c  =  " + c);
        // System.out.println("d  =  " + d);
        // System.out.println("f  =  " + f);
        // Solve the linear equation using Cramer’s rule
        // x = (e * d - b * f) / (a * d - b * c)
        // y = (a * f - e * c) / (a * d - b * c)
        // Create an array for x and y solution coordinates
        double[] solution = new double[2];

        // If the equation has no solutions, the two lines are parallel
        if ((a * d - b * c) == 0) {
            // The two lines are parallel
            System.out.println("The equation has no solutions.");
            System.exit(0); // Exit without an error code
        } else {
            // Calculate x and y and store in the solution array
            solution[0] = (e * d - b * f) / (a * d - b * c);
            solution[1] = (a * f - e * c) / (a * d - b * c);
        }
        // System.out.println(Arrays.toString(solution));
        return solution;
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

    /**
     * Sort the areas array using bubble sort
     *
     * @param areas
     */
    public static void sort(double[] areas) {
        for (int i = 0; i < areas.length - 1; i++) {
            for (int j = 0; j < areas.length - 1 - i; j++) {
                if (areas[j] > areas[j + 1]) {
                    double temp = areas[j];
                    areas[j] = areas[j + 1];
                    areas[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Display the areas
     *
     * @param areas
     */
    public static void displayAreas(double[] areas) {
        System.out.print("The areas are ");

        String format = "%.2f ";

        for (int i = 0; i < areas.length; i++) {
            System.out.printf(format, areas[i]);
        }
    }
}
