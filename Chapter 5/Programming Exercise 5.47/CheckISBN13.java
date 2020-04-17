
import java.util.Scanner;

/**
 * Business: check ISBN-13) ISBN-13 is a new standard for indentifying books. It
 * uses 13 digits d1d2d3d4d5d6d7d8d9d10d11d12d13. The last digit d13 is a
 * checksum, which is calculated from the other digits using the following
 * formula: 10 - (d1 + 3d2 + d3 + 3d4 + d5 + 3d6 + d7 + 3d8 + d9 + 3d10 + d11 +
 * 3d12)%10 If the checksum is 10, replace it with 0. Your program should read
 * the input as a string. Here are sample runs: see textbook
 *
 * Output:
 * Enter the first 12 digits of an ISBN-13 as a string: 978013213079
 * The ISBN-13 number is 9780132130790
 */
/**
 *
 * @author martinfall
 */
public class CheckISBN13 {

    public static void main(String[] args) {
        // Create a variable to hold the checksum
        int checksum = 0;

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the first 12 isbn of an ISBN-13
        System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
        String isbn = input.nextLine();
        // System.out.println("Number of characters in isbn: " + isbn.length());

        if (isbn.length() != 12) {
            System.out.println(isbn + " is an invalid input");
        } else {
            for (int i = 0; i < isbn.length(); i++) {
                // System.out.println(i + " % 2 == 0 is " + (i % 2 == 0)); // Test even/odd status
                checksum += i % 2 == 0
                        ? Integer.parseInt(Character.toString(isbn.charAt(i))) // Covert to string using toString method
                        : 3 * Integer.parseInt(isbn.charAt(i) + ""); // Convert to string by using string concatenation
            }
            // Put the finishing touches on checksum
            checksum = 10 - (checksum % 10);
            
            // System.out.println(checksum); // Print checksum
            if (checksum == 10) {
                checksum = 0; // If the checksum is 10, replace it with 0. 
            }
            // System.out.println(checksum); // Print checksum after the check
            System.out.println("The ISBN-13 number is " + isbn + checksum);
        }
    }
}
