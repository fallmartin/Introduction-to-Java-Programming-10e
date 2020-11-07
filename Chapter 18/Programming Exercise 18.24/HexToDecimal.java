
import java.util.Scanner;

/**
 * (Hex to decimal) Write a recursive method that parses a hex number as a
 * string into a decimal integer. The method header is:
 *
 * public static int hex2Dec(String hexString)
 *
 * Write a test program that prompts the user to enter a hex string and displays
 * its decimal equivalent.
 *
 * Output:
 * Enter a hex string: 7FFFFFFF
 * Decimal equivalent: 2147483647
 *
 * @author martinfall
 */
public class HexToDecimal {

    /**
     * Parses a hex number as a string into a decimal integer.
     *
     * @param hexString
     * @return
     */
    public static int hex2Dec(String hexString) {
        return hex2Dec(hexString, hexString.length() - 1);
    }

    /**
     * Recursive helper method with auxiliary parameter high.
     *
     * @param hexString
     * @param high
     * @return
     */
    public static int hex2Dec(String hexString, int high) {
        if (high < 0) { // Base case
            return 0;
        } else {
            int value = Integer.parseInt(
                    hexString.charAt(hexString.length() - 1 - high) + "", 16);
            return (value * (int) (Math.pow(16, high)))
                    + hex2Dec(hexString, high - 1);
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a Scanner with try-with-resources to prevent mem leak
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter a hex string: ");
            String hexString = input.nextLine();

            // Display the decimal equivalent
            System.out.println("Decimal equivalent: " + hex2Dec(hexString));
        }
    }
}
