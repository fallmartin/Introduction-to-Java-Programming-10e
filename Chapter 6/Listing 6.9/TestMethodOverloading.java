/** 
 * Output:
 * The maximum of 3 and 4 is 4
 * The maximum of 3.0 and 5.4 is 5.4
 * The maximum of 3.0, 5.4, and 10.14 is 10.14
 */

/**
 *
 * @author martinfall
 */
public class TestMethodOverloading {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Invoke the max method with two int parameters
        System.out.println("The maximum of 3 and 4 is "
                + max(3, 4));

        // Invoke the max method with two double parameters
        System.out.println("The maximum of 3.0 and 5.4 is "
                + max(3.0, 5.4));

        // Invoke the max method with three double parameters
        System.out.println("The maximum of 3.0, 5.4, and 10.14 is "
                + max(3.0, 5.4, 10.14));
    }

    /**
     * Return the max of two integer values
     *
     * @param num1
     * @param num2
     * @return
     */
    public static int max(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }
    }

    /**
     * Return the max of two double values
     *
     * @param num1
     * @param num2
     * @return
     */
    public static double max(double num1, double num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }
    }

    /**
     * Return the max of three double values
     *
     * @param num1
     * @param num2
     * @param num3
     * @return
     */
    public static double max(double num1, double num2, double num3) {
        return max(max(num1, num2), num3);
    }
}
