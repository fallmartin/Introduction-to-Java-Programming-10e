
import java.util.Date;

/**
 *
 * @author martinfall
 */
public class House implements Cloneable, Comparable<House> {

    private int id;
    private double area;
    private java.util.Date whenBuilt;

    public House(int id, double area) {
        this.id = id;
        this.area = area;
        whenBuilt = new Date();
    }

    public int getId() {
        return id;
    }

    public double getArea() {
        return area;
    }

    public Date getWhenBuilt() {
        return whenBuilt;
    }

    /**
     * Override the protected clone method defined in the Object class, and
     * strengthen its accessibility.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Perform a shallow copy
        House houseClone = (House) super.clone();
        // Deep copy on whenBuilt
        houseClone.whenBuilt = (java.util.Date) (whenBuilt.clone());
        return houseClone;
    }

    @Override // Implement the compareTo method defined in Comparable
    public int compareTo(House o) {
        if (area > o.getArea()) {
            return 1;
        } else if (area < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
}
