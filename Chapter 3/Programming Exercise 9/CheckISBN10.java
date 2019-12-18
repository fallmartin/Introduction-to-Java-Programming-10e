
/**
 * (Business: check ISBN-10) An ISBN-10 (International Standard Book Number)
 * consists of 10 digits: d1d2d3d4d5d6d7d8d9d10. The last digit, d10, is a
 * checksum, which is calculated from the other nine digits using the
 * following formula:
 *
 * (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5
 * + d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9) % 11
 *
 * If the checksum is 10, the last digit is denoted as X according to the ISBN-10
 * convention. Write a program that prompts the user to enter the first 9 digits
 * and displays the 10-digit ISBN (including leading zeros). Your program should
 * read the input as an integer. Here are sample runs:
 *
 * Enter the first 9 digits of an ISBN as integer: 013601267
 * The ISBN-10 number is 0136012671
 *
 * Enter the first 9 digits of an ISBN as integer: 013031997
 * The ISBN-10 number is 013031997X
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class CheckISBN10 {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the first 9 digits
        System.out.print("Enter the first 9 digits of an ISBN as integer: ");

        // Collect the input from the user
        int isbm = input.nextInt();

        // Calculate and display the checksum digit
        // Declare variables
        int sum = 0, checksum, temp;
        temp = isbm;

        // Declare and initialize i and go through a while loop 9 times
        int i = 9;
        while (i > 1) {
            // System.out.print(isbm % 10);
            sum += (temp % 10) * i;
            temp = temp / 10;
            i--;
        }

        // Perform the modulo operation
        checksum = sum % 11;

        // Display the ISBN
        System.out.print("The ISBN-10 number is ");
        if (checksum == 10) {
            System.out.println(String.format("%09d", isbm) + "X");
        } else {
            System.out.println(String.format("%09d", isbm) + checksum);
        }

    }
}
