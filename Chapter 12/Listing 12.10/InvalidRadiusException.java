
/**
 *
 * @author martinfall
 */
public class InvalidRadiusException extends Exception {

    private double radius;

    /**
     * Construct an exception.
     *
     * @param radius
     */
    public InvalidRadiusException(double radius) {
        super("Invalid radius " + radius);
        this.radius = radius;
    }

    /**
     * Returns the radius.
     *
     * @return
     */
    public double getRadius() {
        return radius;
    }
}
