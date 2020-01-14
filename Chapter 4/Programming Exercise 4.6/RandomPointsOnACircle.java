
/**
 * Write a program that generates three random points on a circle centered at
 * (0, 0) with radius 40 and display three angles in a triangle formed by these
 * three points, as shown in Figure 4.7a.
 * (Hint: Generate a random angle a in radians between 0 and 2p, as shown in
 * Figure 4.7b and the point determined by this angle is (r*cos(a), r*sin(a)).)
 * 
 * Output format:
 * The angle at point (-35.58, 18.28) is 51.29 degrees
 * The angle at point (38.48, -10.90) is 44.40 degrees
 * The angle at point (-19.03, -35.18) is 84.31 degrees
 */
/**
 *
 * @author martinfall
 */
public class RandomPointsOnACircle {

    public static void main(String[] args) {
        // x = r * cos(α) and y = r * sin(α)
        double radius = 40.0;

        // Generate 3 random angles
        double angle1 = Math.toRadians(Math.random() * 361);
        double angle2 = Math.toRadians(Math.random() * 361);
        double angle3 = Math.toRadians(Math.random() * 361);

        // Calculate x and y for point at angle1
        double x1 = radius * Math.cos(angle1);
        double y1 = radius * Math.sin(angle1);
        //System.out.println("(" + x1 + ", " + y1 + ")");
        //System.out.println(Math.pow(x1, 2) + Math.pow(y1, 2));

        // Calculate x and y for point at angle2
        double x2 = radius * Math.cos(angle2);
        double y2 = radius * Math.sin(angle2);
        //System.out.println("(" + x2 + ", " + y2 + ")");
        //System.out.println(Math.pow(x2, 2) + Math.pow(y2, 2));

        // Calculate x and y for point at angle3
        double x3 = radius * Math.cos(angle3);
        double y3 = radius * Math.sin(angle3);
        //System.out.println("(" + x3 + ", " + y3 + ")");
        //System.out.println(Math.pow(x3, 2) + Math.pow(y3, 2));

        // Calculate the three sides of the triangle formed by the points above
        double side1 = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double side2 = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        double side3 = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));

        // Display the sides for testing purposes
        // System.out.printf("%f, %f, %f\n", side1, side2, side3);

        // Use the law of cosines to calculate angle A at point 1
        // cos(A) =  (b^2 + c^2 − a^2)/2bc
        // side1 is c, side2 is a, side3 is b
        double A = Math.toDegrees(Math.acos(
                (side3 * side3 + side1 * side1 - side2 * side2)
                / (2 * side1 * side3)));

        // use the law of cosines to calculate angle B at point 2
        // cos(B) =  (c^2 + a^2 − b^2)/2ca
        // side1 is c, side2 is a, side3 is b
        double B = Math.toDegrees(Math.acos(
                (side1 * side1 + side2 * side2 - side3 * side3)
                / (2 * side1 * side2)));

        // use the law of cosines to calculate angle C at point 3
        // cos(C) =  (a^2 + b^2 − c^2)/2ab
        // side1 is c, side2 is a, side3 is b
        double C = Math.toDegrees(Math.acos(
                (side2 * side2 + side3 * side3 - side1 * side1)
                / (2 * side2 * side3)));

        // Display the results 
        //System.out.println(A);
        //System.out.println(B);
        //System.out.println(C);

        // Use the properties of the sum of the angles of a triangle to check results
        // A + B + C = 180 degrees
        //System.out.println((int) (A + B + C));
        System.out.printf("The angle at point (%.2f, %.2f) is %.2f degrees\n", x1, y1, A);
        System.out.printf("The angle at point (%.2f, %.2f) is %.2f degrees\n", x2, y2, B);
        System.out.printf("The angle at point (%.2f, %.2f) is %.2f degrees\n", x3, y3, C);
    }
}
