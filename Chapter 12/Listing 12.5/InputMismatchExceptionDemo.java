
import java.util.*;

/**
 * Output:
 * Enter an integer: 3.5
 * Try again. (Incorrect input: an integer is required)
 * Enter an integer: a
 * Try again. (Incorrect input: an integer is required)
 * Enter an integer: /
 * Try again. (Incorrect input: an integer is required)
 * Enter an integer: 4
 * The number entered is 4
 *
 * @author martinfall
 */
public class InputMismatchExceptionDemo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continueInput = true;

        do {
            try {
                System.out.print("Enter an integer: ");
                int number = input.nextInt();

                // Display the result
                System.out.println("The number entered is " + number);

                continueInput = false;
            } catch (InputMismatchException ex) {
                System.out.println("Try again. (Incorrect input: an integer is required)");
                input.nextLine(); // Discard input
            }
        } while (continueInput);
    }
}
