
/**
 * (Hex to binary) Write a program that prompts the user to enter a hex digit and
 * displays its corresponding binary number. Here is a sample run:
 *
 * Enter a hex digit: B
 * The binary value is 1011
 *
 * Enter a hex digit: G
 * G is an invalid input
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class HexToBinary {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a hex digit
        System.out.print("Enter a hex digit: ");
        String hex = input.nextLine();

        // 0 is 48, 9 is 57, A is 65, and F is 70
        int decimal = (int) hex.charAt(0);

        // Check if 48 <= decimal <= 57 OR // Check if 65 <= decimal <= 70
        if ((decimal >= 48 && decimal <= 57) || (decimal >= 65 && decimal <= 70)) {
            System.out.println("The binary value is "
                    + Integer.toBinaryString(Integer.parseInt(hex, 16)));
        } else {
            System.out.println(hex + " is an invalid input");
        }
    }
}
