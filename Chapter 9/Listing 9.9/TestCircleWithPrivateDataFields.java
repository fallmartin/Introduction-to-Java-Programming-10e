
/**
 * Output:
 * The area of the circle of radius 5.0 is 78.53981633974483
 * The area of the circle of radius 5.5 is 95.03317777109125
 * The number of objects created is 1
 *
 * @author martinfall
 */
public class TestCircleWithPrivateDataFields {

    public static void main(String[] args) {
        // Create a circle witha radius 5
        CircleWithPrivateDataFields myCircle = new CircleWithPrivateDataFields(5.0);

        System.out.println("The area of the circle of radius "
                + myCircle.getRadius() + " is " + myCircle.getArea());

        // Increase myCircle's radius by 10%
        myCircle.setRadius(myCircle.getRadius() * 1.1);
        System.out.println("The area of the circle of radius "
                + myCircle.getRadius() + " is " + myCircle.getArea());

        System.out.println("The number of objects created is "
                + CircleWithPrivateDataFields.getNumberOfObjects());
    }
}
