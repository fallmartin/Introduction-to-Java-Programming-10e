
import java.util.Random;

/**
 * (Sum the areas of geometric objects) Write a method that sums the areas of
 * all the geometric objects in an array. The method signature is:
 *
 * public static double sumArea(GeometricObject[] a)
 *
 * Write a test program that creates an array of four objects (two circles and
 * two rectangles) and computes their total area using the sumArea method.
 *
 * Output:
 * The area of class Rectangle is 448.0
 * The area of class Circle is 11309.733552923255
 * The area of class Circle is 27171.63486089812
 * The area of class Circle is 706.8583470577034
 *
 * The sum of the areas of array elements is 39636.22676087908
 *
 * @author martinfall
 */
public class TestSumArea {

    public static void main(String[] args) {
        // Create an array of four GeometricObject objects
        GeometricObject[] array = new GeometricObject[4];

        for (int i = 0; i < array.length; i++) {
            // Generate a random integer between 0-2 (not inclusive)
            int random = new Random().nextInt(2);

            // Switch the random number generated above
            switch (random) {
                case 0: // If 0, create a new Rectangle object
                    int width = new Random().nextInt(100);
                    int height = new Random().nextInt(100);
                    array[i] = new Rectangle(width, height);
                    break;
                case 1: // If 1, create a new Circle object
                    int radius = new Random().nextInt(100);
                    array[i] = new Circle(radius);
                    break;
                default:
                    // Inside default should never been seen
                    break;
            }
        }

        // Display individual areas of each object in the array
        for (int i = 0; i < array.length; i++) {
            System.out.println("The area of " + array[i].getClass() + " is "
                    + array[i].getArea());
        }

        // Print a new line
        System.out.println();

        // Display sum of areas of geometric objects
        System.out.println("The sum of the areas of array elements is "
                + sumArea(array));
    }

    /**
     * Sums the areas of all the geometric objects in an array.
     *
     * @param a
     * @return
     */
    public static double sumArea(GeometricObject[] a) {
        double sum = 0;

        for (GeometricObject obj : a) {
            sum += obj.getArea();
        }
        return sum;
    }
}
