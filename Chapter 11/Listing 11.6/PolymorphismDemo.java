
/**
 * Output:
 * Created on: Tue Jun 30 03:14:03 EDT 2020. Color is red
 * Created on: Tue Jun 30 03:14:03 EDT 2020. Color is black
 *
 * @author martinfall
 */
public class PolymorphismDemo {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Display circle and rectangle properties
        displayObject(new CircleFromSimpleGeometricObject(1, "red", false));
        displayObject(new RectangleFromSimpleGeometricObject(1, 1, "black", true));
    }

    public static void displayObject(SimpleGeometricObject object) {
        System.out.println("Created on: " + object.getDateCreated()
                + ". Color is " + object.getColor());
    }
}
