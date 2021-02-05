package closestpair;

import java.util.*;

/**
 * Comparator class to compare Point objects on Y, then on X.
 *
 * @author martinfall
 */
public class CompareY implements Comparator<Point> {

    @Override // Override the compare method in the Comparator interface
    public int compare(Point p1, Point p2) {
        if (p1.getY() > p2.getY()) {
            return 1;
        } else if (p1.getY() == p2.getY()) {
            if (p1.getX() > p2.getX()) {
                return 1;
            } else if (p1.getX() == p2.getX()) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}
