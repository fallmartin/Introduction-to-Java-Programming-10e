
/**
 * Output:
 * Radius 		Area
 * 1.0		3.141592653589793
 * 2.0		12.566370614359172
 * 3.0		28.274333882308138
 * 4.0		50.26548245743669
 * 5.0		78.53981633974483
 *
 * Radius is 6.0
 * n is 5
 *
 * @author martinfall
 */
public class TestPassObject {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a circle object with radius 1
        CircleWithPrivateDataFields myCircle = new CircleWithPrivateDataFields(1);

        // Print areas for radius 1, 2, 3, 4, and 5.
        int n = 5;
        printAreas(myCircle, n);

        // See myCircle.radius and times
        System.out.println("\nRadius is " + myCircle.getRadius());
        System.out.println("n is " + n);
    }

    private static void printAreas(CircleWithPrivateDataFields c, int times) {
        System.out.println("Radius \t\tArea");

        while (times >= 1) {
            System.out.println(c.getRadius() + "\t\t" + c.getArea());
            c.setRadius(c.getRadius() + 1);
            times--;
        }
    }
}
