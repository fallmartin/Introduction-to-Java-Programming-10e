
/**
 * Output:
 * The maximum of 5 and 2 is 5
 */
/**
 *
 * @author martinfall
 */
public class TestMax {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Declare i, j, and k variables
        int i = 5;
        int j = 2;
        int k = max(i, j);

        // Display the results
        System.out.println("The maximum of " + i + " and " + j + " is " + k);
    }

    /**
     * Returns the max of two numbers
     *
     * @param num1
     * @param num2
     * @return
     */
    public static int max(int num1, int num2) {
        // Declare a result variable
        int result;

        if (num1 > num2) {
            result = num1;
        } else {
            result = num2;
        }

        return result;
    }
}
