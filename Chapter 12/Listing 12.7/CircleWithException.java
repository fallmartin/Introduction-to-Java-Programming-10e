
/**
 *
 * @author martinfall
 */
public class CircleWithException {

    /**
     * The radius of the circle
     */
    private double radius;

    /**
     * The number of the objects created
     */
    private static int numberOfObjects = 0;

    /**
     * Construct a circle with radius 1.
     */
    public CircleWithException() {
        this(1.0);
    }

    /**
     * Construct a circle with a specified radius.
     *
     * @param newRadius
     */
    public CircleWithException(double newRadius) {
        setRadius(newRadius);
        numberOfObjects++;
    }

    /**
     * Returns radius.
     *
     * @return
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets a new radius.
     *
     * @param newRadius
     */
    public void setRadius(double newRadius) throws IllegalArgumentException {
        if (newRadius >= 0) {
            radius = newRadius;
        } else {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
    }

    /**
     * Returns numberOfObjects.
     *
     * @return
     */
    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    /**
     * Return the area of this circle.
     *
     * @return
     */
    public double findArea() {
        return radius * radius * Math.PI;
    }
}
