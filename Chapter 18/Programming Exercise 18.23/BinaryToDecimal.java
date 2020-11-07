
import java.util.Scanner;

/**
 * (Binary to decimal) Write a recursive method that parses a binary number as a
 * string into a decimal integer. The method header is:
 *
 * public static int bin2Dec(String binaryString)
 *
 * Write a test program that prompts the user to enter a binary string and
 * displays its decimal equivalent.
 *
 * Output:
 * Enter a binary string: 101010000101010111010100
 * Decimal equivalent: 11032020
 *
 * @author martinfall
 */
public class BinaryToDecimal {

    /**
     * Parses a binary number as a string into a decimal integer.
     *
     * @param binaryString
     * @return
     */
    public static int bin2Dec(String binaryString) {
        return bin2Dec(binaryString, binaryString.length() - 1); // Call auxiliary method
    }

    /**
     * Recursive helper method with auxiliary parameter decimal.
     *
     * @param binaryString
     * @param high
     * @return
     */
    public static int bin2Dec(String binaryString, int high) {
        if (high < 0) {
            return 0;
        } else {
            int value = binaryString.charAt(binaryString.length() - 1 - high) == '1'
                    ? (int) Math.pow(2, high) : 0;
            return value + bin2Dec(binaryString, high - 1);
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Try-with-resources to autoclose the scanner
        try (
                // Create a Scanner
                Scanner input = new Scanner(System.in);) {
            System.out.print("Enter a binary string: ");
            String binaryString = input.nextLine();

            System.out.println("Decimal equivalent: " + bin2Dec(binaryString));
        }
    }
}
