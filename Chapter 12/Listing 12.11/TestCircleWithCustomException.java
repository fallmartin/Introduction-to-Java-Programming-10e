
/**
 * Output:
 * InvalidRadiusException: Invalid radius -5.0
 * Number of objects created: 1
 *
 * @author martinfall
 */
public class TestCircleWithCustomException {

    public static void main(String[] args) {
        try {
            new CircleWithCustomException(5);
            new CircleWithCustomException(-5);
            new CircleWithCustomException(0);
        } catch (InvalidRadiusException ex) {
            System.out.println(ex);
        }

        System.out.println("Number of objects created: "
                + CircleWithCustomException.getNumberOfObjects());
    }
}

class CircleWithCustomException {

    // The radius of the circle
    private double radius;

    // The number of objects created
    private static int numberOfObjects = 0;

    /**
     * Construct a circle with radius 1.
     */
    public CircleWithCustomException() throws InvalidRadiusException {
        this(1.0);
    }

    /**
     * Construct a circle with a specified radius.
     */
    public CircleWithCustomException(double newRadius)
            throws InvalidRadiusException {
        setRadius(newRadius);
        numberOfObjects++;
    }

    /**
     * Returns radius.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets a new radius.
     */
    public void setRadius(double newRadius) throws InvalidRadiusException {
        if (newRadius >= 0) {
            radius = newRadius;
        } else {
            throw new InvalidRadiusException(newRadius);
        }
    }

    /**
     * Returns the number of objects created.
     */
    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    /**
     * Returns the area of this circle.
     */
    public double findArea() {
        return getRadius() * getRadius() * Math.PI;
    }
}
