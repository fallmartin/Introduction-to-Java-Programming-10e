
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * (InputMismatchException) Write a program that prompts the user to read
 * two integers and displays their sum. Your program should prompt the user to
 * read the number again if the input is incorrect.
 *
 * Output:
 * Enter the first integer: 321
 * Enter the second integer: w
 * Wrong Input!
 * Enter the second integer: 329
 * 321 + 329 = 650
 *
 * @author martinfall
 */
public class SumOfTwoIntegers {

    public static void main(String[] args) {
        // Constant number of operands
        final int NUMBER_OF_OPERANDS = 2;
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Create an int array to hold operands
        int[] operands = new int[NUMBER_OF_OPERANDS];
        int counter = 0;

        do {
            try {
                System.out.print("Enter the "
                        + (counter == 0 ? "first" : "second") + " integer: ");
                operands[counter] = input.nextInt();
                counter++;
            } catch (InputMismatchException ex) {
                input.nextLine(); // Advance the Scanner to the next line
                // System.out.println(ex);
                System.out.println("Wrong Input!");
            }
        } while (counter < NUMBER_OF_OPERANDS);

        // Display the result
        System.out.println(operands[0] + " + " + operands[1] + " = "
                + (operands[0] + operands[1]));
    }
}
