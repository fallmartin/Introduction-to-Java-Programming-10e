
/**
 * (Business: check ISBN-10) Rewrite the Programming Exercise 3.9 by entering the
 * ISBN number as a string.
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class BusinessCheckISBN10 {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the first 9 digits
        System.out.print("Enter the first 9 digits of an ISBN as integer: ");

        // Collect the input from the user
        String isbmTemp = input.next();
        
        int isbm = Integer.parseInt(isbmTemp);

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
