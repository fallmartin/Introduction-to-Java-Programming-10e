
/**
 * (Phone key pads) The international standard letter/number mapping found on the
 * telephone is shown below:
 *
 * Write a program that prompts the user to enter a letter and displays its
 * corresponding number.
 *
 * Enter a letter: A
 * The corresponding number is 2
 *
 * Enter a letter: a
 * The corresponding number is 2
 *
 * Enter a letter: +
 * + is an invalid input
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class PhoneKeyPads {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a letter
        System.out.print("Enter a letter: ");
        String letter = input.nextLine();

        // Store the letter in a char variable
        char ch = letter.charAt(0);

        // Convert ch to upper case to limit test cases to upper case chars
        ch = Character.toUpperCase(ch);

        if (ch >= 'A' && ch <= 'Z') {
            if (ch < 'D') {
                System.out.println("The corresponding number is 2");
            } else if (ch >= 'D' && ch < 'G') {
                System.out.println("The corresponding number is 3");
            } else if (ch >= 'G' && ch < 'J') {
                System.out.println("The corresponding number is 4");
            } else if (ch >= 'J' && ch < 'M') {
                System.out.println("The corresponding number is 5");
            } else if (ch >= 'M' && ch < 'P') {
                System.out.println("The corresponding number is 6");
            } else if (ch >= 'P' && ch < 'T') {
                System.out.println("The corresponding number is 7");
            } else if (ch >= 'T' && ch < 'W') {
                System.out.println("The corresponding number is 8");
            } else if (ch >= 'W' && ch <= 'Z') {
                System.out.println("The corresponding number is 9");
            }
        } else {
            System.out.println(ch + " is an invalid input");
        }
    }
}
