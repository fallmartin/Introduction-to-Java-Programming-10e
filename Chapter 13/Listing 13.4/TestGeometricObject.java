
/**
 * The two objects have the same area? false
 *
 * The area is 78.53981633974483
 * The perimeter is 31.41592653589793
 *
 * The area is 15.0
 * The perimeter is 16.0
 *
 * @author martinfall
 */
public class TestGeometricObject {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create two geometric objects
        GeometricObject geoObject1 = new Circle(5);
        GeometricObject geoObject2 = new Rectangle(5, 3);

        System.out.println("The two objects have the same area? "
                + equalArea(geoObject1, geoObject2));

        // Display circle
        displayGeometricObject(geoObject1);

        // Display rectangle
        displayGeometricObject(geoObject2);
    }

    /**
     * A method for comparing the areas of two geometric objects
     *
     * @param geoObject1
     * @param geoObject2
     * @return
     */
    public static boolean equalArea(
            GeometricObject geoObject1, GeometricObject geoObject2) {
        return geoObject1.getArea() == geoObject2.getArea();
    }

    /**
     * A method for displaying a geometric object
     *
     * @param object
     */
    public static void displayGeometricObject(GeometricObject object) {
        System.out.println();
        System.out.println("The area is " + object.getArea());
        System.out.println("The perimeter is " + object.getPerimeter());
    }
}
