
import java.util.Scanner;

/**
 * (Sort three numbers) Write a method with the following header to display
 * three numbers in increasing order:
 *
 * public static void displaySortedNumbers(double num1, double num2, double
 * num3)
 *
 * Write a test program that prompts the user to enter three numbers and
 * invokes the method to display them in increasing order.
 */
/**
 *
 * @author martinfall
 */
public class SortThreeNumbersIf {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter three numbers
        System.out.print("Enter three numbers: ");
        double num1 = input.nextDouble();
        double num2 = input.nextDouble();
        double num3 = input.nextDouble();

        displaySortedNumbers(num1, num2, num3);
    }

    /**
     * Display three numbers in increasing order. This implementation doesn't
     * use any conditional statements.
     *
     * @param num1
     * @param num2
     * @param num3
     */
    public static void displaySortedNumbers(double num1, double num2, double num3) {
        if (num1 < num2) {
            if (num2 < num3) {
                System.out.println(num1 + " " + num2 + " " + num3);
            } else {
                if (num1 < num3) {
                    System.out.println(num1 + " " + num3 + " " + num2);
                } else {
                    System.out.println(num3 + " " + num1 + " " + num2);
                }
            }
        } else {
            if (num2 < num3) {
                if (num1 < num3) {
                    System.out.println(num2 + " " + num1 + " " + num3);
                } else {
                    System.out.println(num2 + " " + num3 + " " + num1);
                }
            } else {
                System.out.println(num3 + " " + num2 + " " + num1);
            }
        }
    }
}
