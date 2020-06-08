
/**
 * Output:
 * The area of the circle of radius 1.0 is 6.283185307179586
 * The area of the circle of radius 25.0 is 157.07963267948966
 * The area of the circle of radius 125.0 is 785.3981633974482
 * The area of the circle of radius 100.0 is 628.3185307179587
 *
 * @author martinfall
 */
public class TestSimpleCircle {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a circle with radius 1
        SimpleCircle circle1 = new SimpleCircle();
        System.out.println("The area of the circle of radius "
                + circle1.radius + " is " + circle1.getArea());

        // Create a circle with radius 25
        SimpleCircle circle2 = new SimpleCircle(25);
        System.out.println("The area of the circle of radius "
                + circle2.radius + " is " + circle2.getArea());

        // Create a circle with radius 125
        SimpleCircle circle3 = new SimpleCircle(125);
        System.out.println("The area of the circle of radius "
                + circle3.radius + " is " + circle3.getArea());

        // Modify circle radius
        circle2.radius = 100;
        // or circle2.setRadius(100);
        System.out.println("The area of the circle of radius "
                + circle2.radius + " is " + circle2.getArea());
    }
}

// Define the circle class with two constructors
class SimpleCircle {

    double radius;

    // no-arg constructor
    /**
     * Construct a circle with radius 1
     */
    SimpleCircle() {
        radius = 1;
    }

    // second constructor
    /**
     * Construct a circle with a specified radius
     */
    SimpleCircle(double newRadius) {
        radius = newRadius;
    }

    /**
     * Return the area of this circle
     */
    double getArea() {
        return 2 * radius * Math.PI;
    }

    /**
     * Set a new radius for this circle
     */
    void setRadius(double newRadius) {
        radius = newRadius;
    }
}
