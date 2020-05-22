
import java.util.Scanner;

/**
 * (Pattern recognition: consecutive four equal numbers) Write the following
 * method that tests whether the array has four consecutive numbers with the
 * same value.
 *
 * public static boolean isConsecutiveFour(int[] values)
 *
 * Write a test program that prompts the user to enter a series of integers and
 * displays if the series contains four consecutive numbers with the same value.
 * Your program should first prompt the user to enter the input size—i.e., the
 * number of values in the series. Here are sample runs:
 *
 * Enter the number of values: 8 
 * Enter the values: 3 4 5 5 5 5 4 5 
 * The list has consecutive fours
 *
 * Enter the number of values: 9 
 * Enter the values: 3 4 5 5 6 5 5 4 5 
 * The list has no consecutive fours
 *
 * @author martinfall
 */
public class PatternRecognition {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the number fo values
        System.out.print("Enter the number of values: ");
        int length = input.nextInt();

        // Populate array
        System.out.print("Enter the values: ");
        int[] values = new int[length];
        for (int i = 0; i < values.length; i++) {
            values[i] = input.nextInt();
        }

        System.out.println("The list has "
                + (isConsecutiveFour(values) ? "" : "no ") + "consecutive fours");
    }

    public static boolean isConsecutiveFour(int[] values) {
        for (int i = 0; i < values.length - 4; i++) {
            int counter = 0;
            for (int j = 0; j < 4; j++) {
                if (values[i] == values[j]) {
                    counter++;
                }
            }
            if (counter == 4) {
                return true;
            }
        }
        return false;
    }
}
