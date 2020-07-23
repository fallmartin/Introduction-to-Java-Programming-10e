
/**
 *
 * @author martinfall
 */
public class ComparableRectangle
        extends Rectangle implements Comparable<ComparableRectangle> {

    /**
     * Construct a ComparableRectangle with specified properties
     *
     * @param width
     * @param height
     */
    public ComparableRectangle(double width, double height) {
        super(width, height);
    }

    @Override // Implement the compareTo method defined in Comparable
    public int compareTo(ComparableRectangle o) {
        if (getArea() > o.getArea()) {
            return 1;
        } else if (getArea() < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override // Implement the toString method in GeometricObject
    public String toString() {
        return super.toString() + " Area: " + getArea();
    }

}
