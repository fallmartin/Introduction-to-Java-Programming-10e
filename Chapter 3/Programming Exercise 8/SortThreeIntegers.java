
/**
 * Write a program that prompts the user to enter three integers and display the
 * integers in non-decreasing order.
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class SortThreeIntegers {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompts the user to enter three integers
        System.out.print("Enter three integers: ");

        // Collect user input
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        int number3 = input.nextInt();

        // Sort the integers
        // Case 1
        // If number1 > number2 and number1 > number3, then test number2 and number3
        // If number 3 > number2, then display number2 number3 number1
        // If number2 > number3, then display number3 number2 number1
        if (number1 > number2 && number1 > number3) {
            if (number3 > number2) {
                System.out.println(number2 + " " + number3 + " " + number1);
            } else if (number2 > number3) {
                System.out.println(number3 + " " + number2 + " " + number1);
            }
        } // Case 2
        // If number2 > number1 and number2 > number3, then test number1 and number3
        // If number 1 > number3, then display number3 number1 number2
        // If number3 > number1, then display number1 number3 number2
        else if (number2 > number1 && number2 > number3) {
            if (number1 > number3) {
                System.out.println(number3 + " " + number1 + " " + number2);
            } else if (number3 > number1) {
                System.out.println(number1 + " " + number3 + " " + number2);
            }
        } // Case 3
        // If number3 > number1 and number3 > number2, then test number1 and number2
        // If number 1 > number2, then display number2 number1 number3
        // If number2 > number1, then display number1 number2 number3
        else if (number3 > number1 && number3 > number2) {
            if (number1 > number2) {
                System.out.println(number2 + " " + number1 + " " + number3);
            } else if (number2 > number1) {
                System.out.println(number1 + " " + number2 + " " + number3);
            }
        }
    }
}
