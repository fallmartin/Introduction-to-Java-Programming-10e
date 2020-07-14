
import java.util.Random;
import java.util.Scanner;

/**
 * (ArrayIndexOutOfBoundsException) Write a program that meets the following
 * requirements:
 *
 * ■ Creates an array with 100 randomly chosen integers.
 * ■ Prompts the user to enter the index of the array, then displays the
 * corresponding element value. If the specified index is out of bounds, display
 * the message Out of Bounds.
 *
 * Output:
 * Enter the index of the array: 111
 * Out of Bounds
 * Enter the index of the array: 111
 * Out of Bounds
 * Enter the index of the array: 4
 * Corresponding element value: 683
 *
 * @author martinfall
 */
public class OutOfBounds {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Constant variable for the number of randomly chosen integers
        final int NUMBER_OF_INTEGERS = 100;

        // Creates an array with 100 randomly chosen integers
        int[] array = createArray(NUMBER_OF_INTEGERS);

        // Uncomment the following line to display array to console
        // System.out.println(Arrays.toString(array));
        do {
            try {
                // Prompt the user to enter the index of the array
                System.out.print("Enter the index of the array: ");

                int index = input.nextInt();

                // Display result
                System.out.println("Corresponding element value: " + array[index]);
                break;
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Out of Bounds");
            }
        } while (true);

    }

    public static int[] createArray(int numberOfElements) {
        Random r = new Random();
        int[] array = new int[numberOfElements];
        int upperbound = 1000; // Arbitrary upper limit for random int values 0-100

        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(upperbound);
        }
        return array;
    }
}
