
/**
 * Write a test program that creates a Triangle2D objects t1 using the constructor
 * new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3), new MyPoint(5, 3.5)),
 * displays its area and perimeter, and displays the result of t1.contains(3, 3),
 * r1.contains(new Triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1),
 * new MyPoint(1, 3.4))), and t1.overlaps(new Triangle2D(new MyPoint(2, 5.5),
 * new MyPoint(4, -3), MyPoint(2, 6.5))).
 *
 * Output:
 * The area of t1 is 0.02500000000000299
 * The perimeter of t1 is 5.831182352959913
 * t1 contains (3, 3)? false
 * t1 contains the triangle at points (2.9, 2), (4, 1), (1, 3.4)? false
 * t1 overlaps the triangle at (2, 5.5), (4, -3), (2, 6.5)? true
 *
 * @author martinfall
 */
public class TestTriangle2D {

    public static void main(String[] args) {
        // Create a Triangle2D object t1
        Triangle2D t1
                = new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3), new MyPoint(5, 3.5));

        // Display the area and perimeter of t1
        System.out.println("The area of t1 is " + t1.getArea());
        System.out.println("The perimeter of t1 is " + t1.getPerimeter());

        // Display the results of t1.contains(3, 3)
        System.out.println("t1 contains (3, 3)? " + t1.contains(new MyPoint(3, 3)));

        // Display the result of 
        // r1.contains(new Triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1), MyPoint(1, 3.4)))
        System.out.println("t1 contains the triangle at points (2.9, 2), (4, 1), (1, 3.4)? "
                + t1.contains(
                        new Triangle2D(
                                new MyPoint(2.9, 2),
                                new MyPoint(4, 1),
                                new MyPoint(1, 3.4))));

        // t1.overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint(4, -3), MyPoint(2, 6.5)))
        System.out.println("t1 overlaps the triangle at (2, 5.5), (4, -3), (2, 6.5)? "
                + t1.overlaps(
                        new Triangle2D(
                                new MyPoint(2, 5.5),
                                new MyPoint(4, -3),
                                new MyPoint(2, 6.5))));
    }
}
