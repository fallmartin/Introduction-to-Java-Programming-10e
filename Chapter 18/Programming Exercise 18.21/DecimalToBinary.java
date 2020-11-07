
import java.util.Scanner;

/**
 * (Decimal to binary) Write a recursive method that converts a decimal number
 * into a binary number as a string. The method header is:
 *
 * public static String dec2Bin(int value)
 *
 * Write a test program that prompts the user to enter a decimal number and
 * displays its binary equivalent.
 *
 * Output:
 * Enter a decimal number: 11032020
 * The binary equivalent of 11032020 is 00000000000101010000101010111010100
 *
 * @author martinfall
 */
public class DecimalToBinary {

    /**
     * Converts a decimal number into a binary number as a string.
     *
     * @param value
     * @return
     */
    public static String dec2Bin(int value) {
        return dec2Bin(value, "");
    }

    /**
     * Recursive helper method with auxiliary parameter.
     *
     * @param value
     * @param binaryStr
     * @return
     */
    public static String dec2Bin(int value, String binaryStr) {
        if (binaryStr.length() == (8 * 4 + 3)) {
            return binaryStr;
        } else {
            return dec2Bin(value / 2, Integer.toString(value % 2) + binaryStr);
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int value = input.nextInt();

        System.out.println("The binary equivalent of " + value
                + " is " + dec2Bin(value));
    }
}
