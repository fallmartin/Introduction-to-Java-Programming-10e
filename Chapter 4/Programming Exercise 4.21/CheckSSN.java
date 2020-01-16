
/**
 * Write a program that prompts the user to enter a Social Security number in the
 * format DDD-DD-DDDD, where D is a digit. Your program should check whether the
 * input is valid. Here are sample runs:
 *
 * Enter a SSN: 232-23-5435
 * 232-23-5435 is a valid social security number
 *
 * Enter a SSN: 23-23-5435
 * 23-23-5435 is an invalid social security number
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class CheckSSN {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a SSN
        System.out.print("Enter a SSN: ");
        String ssn = input.nextLine();

        // Check if the string is a valid social security number
        boolean isValid = false;

        if ((ssn.length() == 11)
                && (Character.isDigit(ssn.charAt(0)))
                && (Character.isDigit(ssn.charAt(1)))
                && (Character.isDigit(ssn.charAt(2)))
                && (ssn.charAt(3) == '-')
                && (Character.isDigit(ssn.charAt(4)))
                && (Character.isDigit(ssn.charAt(5)))
                && (ssn.charAt(6) == '-')
                && (Character.isDigit(ssn.charAt(7)))
                && (Character.isDigit(ssn.charAt(8)))
                && (Character.isDigit(ssn.charAt(9)))
                && (Character.isDigit(ssn.charAt(10)))) {
            isValid = true;
        }

        if (isValid) {
            System.out.println(ssn + " is a valid social security number");
        } else {
            System.out.println(ssn + " is an invalid social security number");
        }
    }
}
