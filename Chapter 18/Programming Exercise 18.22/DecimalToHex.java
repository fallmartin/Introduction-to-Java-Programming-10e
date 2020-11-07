
import java.util.Scanner;

/**
 * (Decimal to hex) Write a recursive method that converts a decimal number into
 * a hex number as a string. The method header is:
 *
 * public static String dec2Hex(int value)
 *
 * Write a test program that prompts the user to enter a decimal number and
 * displays its hex equivalent.
 *
 * Output:
 * Enter a decimal number: 2147483647
 * The hex equivalent of 2147483647 is 0x7FFFFFFF
 *
 * @author martinfall
 */
public class DecimalToHex {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal number: "); // User prompt
        int value = input.nextInt();
        input.close(); // Close the scanner

        // Display the results
        System.out.println("The hex equivalent of "
                + value + " is " + dec2Hex(value));
    }

    /**
     * Converts a decimal number into a hex number as a string.
     *
     * @param value
     * @return
     */
    public static String dec2Hex(int value) {
        return dec2Hex(value, ""); // Call auxiliary method
    }

    /**
     * Recursive helper method with auxiliary parameter.
     *
     * @param value
     * @param hexStr
     * @return
     */
    public static String dec2Hex(int value, String hexStr) {
        if (hexStr.length() == 8) { // Base case
            return "0x" + hexStr.toUpperCase();
        } else {
            String str = digitOrLetter(value % 16);
            return dec2Hex(value / 16, str + hexStr);
        }
    }

    /**
     * Return A-F if i is between 10 and 15.
     *
     * @param i
     * @return
     */
    public static String digitOrLetter(int i) {
        return Integer.toHexString(i);
    }
}
