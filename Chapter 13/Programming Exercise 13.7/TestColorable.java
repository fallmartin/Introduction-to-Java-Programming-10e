
import java.util.Random;

/**
 * (The Colorable interface) Design an interface named Colorable with a void
 * method named howToColor(). Every class of a colorable object must implement
 * the Colorable interface. Design a class named Square that extends
 * GeometricObject and implements Colorable. Implement howToColor to
 * display the message Color all four sides.
 *
 * Draw a UML diagram that involves Colorable, Square, and GeometricObject.
 * Write a test program that creates an array of five GeometricObjects. For each
 * object in the array, display its area and invoke its howToColor method if it
 * is colorable.
 *
 * Output:
 * The area of this class Circle object is 314.1592653589793
 *
 * The area of this class Square object is 49.0
 * Color all four sides.
 *
 * The area of this class Square object is 49.0
 * Color all four sides.
 *
 * The area of this class Square object is 49.0
 * Color all four sides.
 *
 * The area of this class Circle object is 314.1592653589793
 *
 * @author martinfall
 */
public class TestColorable {

    public static void main(String[] args) {
        // Create a new GeometricObject array
        GeometricObject[] array = new GeometricObject[5];

        for (int i = 0; i < 5; i++) {
            // Generate a random integer between 0 and 2 (not inclusive)
            int random = new Random().nextInt(2);

            switch (random) {
                case 0: // Circle
                    array[i] = new Circle(10);
                    break;
                case 1: // Square
                    array[i] = new Square(7);
                    break;
                default:
                    System.out.println("You're in the default case...");
                    break;
            }
        }

        for (GeometricObject o : array) {
            System.out.println("The area of this " + o.getClass()
                    + " object is " + o.getArea());
            if (o instanceof Colorable) {
                ((Colorable) o).howToColor();
            }
            System.out.println();
        }
    }
}
