/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class HexDigit2Dec {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a hex digit: ");
        String hexString = input.nextLine();

        // Check if the hex string has exactly one character
        if (hexString.length() != 1) {
            System.out.println("You must enter exactly one character");
            System.exit(1);
        }

        // Display decimal value for the hex digit
        char ch = hexString.charAt(0);

        if (ch >= 'A' && ch <= 'F') {
            int value = ch - 'A' + 10;
            System.out.println("The decimal value for hex digit "
                    + ch + " is " + value);
        } else if (Character.isDigit(ch)) {
            System.out.println("The decimal value for hex digit "
                    + ch + " is " + ch);
        } else {
            System.out.println(ch + " is an invalid input");
        }
    }
}
