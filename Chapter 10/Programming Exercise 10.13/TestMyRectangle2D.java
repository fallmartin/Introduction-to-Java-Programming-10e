
/**
 * Write a test program that creates a MyRectangle2D object
 * r1 (new MyRectangle2D(2, 2, 5.5, 4.9)), displays its area and perimeter, and
 * displays the result of r1.contains(3, 3),
 * r1.contains(new MyRectangle2D(4, 5, 10.5, 3.2)), and
 * r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)).
 *
 * Output:
 * The area of r1 is 26.950000000000003
 * The perimeter of r1 is 20.8
 * r1 contains (3, 3)? true
 * r1 contains new MyRectangle2D(4, 5, 10.5, 3.2)? true
 * r1 overlaps new MyRectangle2D(3, 5, 2.3, 5.4))? false
 *
 * @author martinfall
 */
public class TestMyRectangle2D {

    public static void main(String[] args) {

        // Create a new MyRectangle2D object at (2, 2) with width 5.5 and height 4.9
        MyRectangle2D r1 = new MyRectangle2D(2, 2, 5.5, 4.9);

        // Display r1's area and perimeter
        System.out.println("The area of r1 is " + r1.getArea());
        System.out.println("The perimeter of r1 is " + r1.getPerimeter());

        // Display the result of r1.contains(3, 3)
        System.out.println("r1 contains (3, 3)? " + r1.contains(3, 3));

        // Display the result of r1.contains(new MyRectangle2D(4, 5, 10.5, 3.2))
        System.out.println("r1 contains new MyRectangle2D(4, 5, 10.5, 3.2)? "
                + r1.contains(new MyRectangle2D(4, 5, 10.5, 3.2)));

        // Display the result of r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4))
        System.out.println("r1 overlaps new MyRectangle2D(3, 5, 2.3, 5.4))? "
                + r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)));
    }
}
