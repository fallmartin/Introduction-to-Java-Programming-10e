
/**
 * (Palindrome number) Write a program that prompts the user to enter a
 * three-digit integer and determines whether it is a palindrome number.
 * A number is palindrome if it reads the same from right to left and from left
 * to right. Here is a sample run of this program:
 *
 * Enter a three-digit integer: 121
 * 121 is a palindrome
 *
 * Enter a three-digit integer: 123
 * 123 is not a palindrome
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a three-digit integer
        System.out.print("Enter a three-digit integer: ");

        // Collect input from the user
        int number = input.nextInt();
        int temp = number;

        int number1 = temp % 10;
        temp /= 10;

        int number2 = temp % 10;
        temp /= 10;

        int number3 = temp % 10;

        if (number1 == number3) {
            System.out.println(number + " is a palindrome");
        } else {
            System.out.println(number + " is not a palindrome");
        }
    }
}
