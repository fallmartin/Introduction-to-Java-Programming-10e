
/**
 * Output:
 * java.lang.IllegalArgumentException: Radius cannot be negative
 * Number of objects created: 1
 *
 * @author martinfall
 */
public class TestCircleWithException {

    public static void main(String[] args) {
        try {
            CircleWithException c1 = new CircleWithException(5);
            CircleWithException c2 = new CircleWithException(-5);
            CircleWithException c3 = new CircleWithException(0);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }

        System.out.println("Number of objects created: "
                + CircleWithException.getNumberOfObjects());
    }
}
