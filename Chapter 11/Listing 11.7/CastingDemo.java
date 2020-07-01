
/**
 * Output:
 * The circle are is 3.141592653589793
 * The circle diameter is 2.0
 * The rectangle area is 1.0
 *
 * @author martinfall
 */
public class CastingDemo {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create and initialize two objects
        Object object1 = new CircleFromSimpleGeometricObject(1);
        Object object2 = new RectangleFromSimpleGeometricObject(1, 1);

        // Display circle and rectangle
        displayObject(object1);
        displayObject(object2);
    }

    public static void displayObject(Object object) {
        if (object instanceof CircleFromSimpleGeometricObject) {
            System.out.println("The circle are is "
                    + ((CircleFromSimpleGeometricObject) object).getArea());
            System.out.println("The circle diameter is "
                    + ((CircleFromSimpleGeometricObject) object).getDiameter());
        } else if (object instanceof RectangleFromSimpleGeometricObject) {
            System.out.println("The rectangle area is "
                    + ((RectangleFromSimpleGeometricObject) object).getArea());
        }
    }
}
