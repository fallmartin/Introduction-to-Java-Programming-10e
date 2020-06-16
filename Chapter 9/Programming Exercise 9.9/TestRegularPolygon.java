
/**
 * Write a test program that creates three RegularPolygon objects, created using
 * the no-arg constructor, using RegularPolygon(6, 4), and using
 * RegularPolygon(10, 4, 5.6, 7.8). For each object, display its perimeter and area.
 *
 * Output:
 * Polygon A:
 * Area: 0.43301270189221946
 * Perimeter: 3.0
 *
 * Polygon B:
 * Area: 41.569219381653056
 * Perimeter: 24.0
 *
 * Polygon C:
 * Area: 123.10734148701015
 * Perimeter: 40.0
 *
 * @author martinfall
 */
public class TestRegularPolygon {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create three RegularPolygon objects to specifications
        RegularPolygon A = new RegularPolygon();
        RegularPolygon B = new RegularPolygon(6, 4);
        RegularPolygon C = new RegularPolygon(10, 4, 5.6, 7.8);

        // Display the perimeter and area for each polygon created above
        System.out.println("Polygon A: ");
        System.out.println("Area: " + A.getArea());
        System.out.println("Perimeter: " + A.getPerimeter());

        // New line for better legibility 
        System.out.println();

        System.out.println("Polygon B: ");
        System.out.println("Area: " + B.getArea());
        System.out.println("Perimeter: " + B.getPerimeter());

        // New line for better legibility 
        System.out.println();

        System.out.println("Polygon C: ");
        System.out.println("Area: " + C.getArea());
        System.out.println("Perimeter: " + C.getPerimeter());
    }
}
