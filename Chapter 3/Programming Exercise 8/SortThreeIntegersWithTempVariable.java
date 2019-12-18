
/**
 * Write a program that prompts the user to enter three integers and display the
 * integers in non-decreasing order.
 */

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class SortThreeIntegersWithTempVariable {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompts the user to enter three integers
        System.out.print("Enter three integers: ");

        // Collect user input
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        int number3 = input.nextInt();

        // Sort the numbers using a temp variable
        int temp;

        if (number1 > number2 || number1 > number3) {
            if (number1 > number2) {
                temp = number1;
                number1 = number2;
                number2 = temp;
            }
            if (number1 > number3) {
                temp = number1;
                number1 = number3;
                number3 = temp;
            }
        }
        if (number2 > number3) {
            temp = number2;
            number2 = number3;
            number3 = temp;
        }

        // Display numbers in non-decreasing order
        System.out.println(number1 + " " + number2 + " " + number3);
    }
}
