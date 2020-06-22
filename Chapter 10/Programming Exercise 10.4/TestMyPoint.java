
/**
 *  Write a test program that creates the two points (0, 0) and (10, 30.5) and
 * displays the distance between them.
 *
 * Output:
 * The distance between (0.0, 0.0) and (10.0, 30.5) is 32.09750769140807
 *
 * @author martinfall
 */
public class TestMyPoint {

    public static void main(String[] args) {
        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(10, 30.5);
        System.out.println("The distance between " + printPoint(p1) + " and "
                + printPoint(p2) + " is " + p1.distance(p2));
    }

    private static String printPoint(MyPoint point) {
        return "(" + point.getX() + ", " + point.getY() + ")";
    }
}
