
import java.util.Scanner;

/**
 * ﻿(Check password) Some websites impose certain rules for passwords. Write a
 * method that checks whether a string is a valid password. Suppose the password
 * rules are as follows:
 *
 * - A password must have at least eight characters. - A password consists of
 * only letters and digits. - A password must contain at least two digits.
 *
 * Write a program that prompts the user to enter a password and displays Valid
 * Password if the rules are followed or Invalid Password otherwise.
 *
 * @author martinfall
 */
public class CheckPassword {

    final static int MINIMUM_PASSWORD_LENGTH = 8;

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a password: ");
        String password = input.nextLine();

        // Check password and print validity
        System.out.println(checkPassword(password) ? "Valid password" : "Invalid password");
    }

    /**
     * Check if the string entered is a valid password
     *
     * @param password
     */
    public static boolean checkPassword(String password) {
        if (isValidLength(password)
                && isOnlyLettersAndDigits(password)
                && isAtLeastTwoDigits(password)) {
            return true;
        }
        return false;
    }

    /**
     * Check if the password is the right length
     *
     * @param password
     * @return
     */
    public static boolean isValidLength(String password) {
        return password.length() >= MINIMUM_PASSWORD_LENGTH;
    }

    /**
     * Check if the password has only letters and digits
     *
     * @param password
     * @return
     */
    public static boolean isOnlyLettersAndDigits(String password) {
        boolean flag = true;

        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * Check if the password has two digits minimum
     *
     * @param password
     * @return
     */
    public static boolean isAtLeastTwoDigits(String password) {
        int digitCount = 0;
        
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                digitCount++;
            }
        }
        return (digitCount >= 2);
    }
}
