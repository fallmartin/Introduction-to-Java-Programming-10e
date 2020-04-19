
/**
 * Before invoking the swap method, num1 is 1 and num2 is 2
	Inside the swap method
		Before swapping, n1 is 1 and n2 is 2
		After swapping, n1 is 2 and n2 is 1
After invoking the swap method, num1 is 1 and num2 is 2
 */
/**
 *
 * @author martinfall
 */
public class TestPassByValue {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Declare and initialize variables
        int num1 = 1;
        int num2 = 2;

        System.out.println("Before invoking the swap method, num1 is " + num1
                + " and num2 is " + num2);

        // Invoke the swap method to attempt to swap two variables
        swap(num1, num2); // false swap

        System.out.println("After invoking the swap method, num1 is " + num1
                + " and num2 is " + num2);
    }

    public static void swap(int n1, int n2) {
        System.out.println("\tInside the swap method");
        System.out.println("\t\tBefore swapping, n1 is " + n1 + " and n2 is " + n2);

        // swap n1 with n2
        int temp = n1;
        n1 = n2;
        n2 = temp;

        System.out.println("\t\tAfter swapping, n1 is " + n1 + " and n2 is " + n2);
    }
}
