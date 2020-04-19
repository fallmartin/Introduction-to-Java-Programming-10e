
import java.util.Scanner;

/**
 * Output:
 * Enter a hex number: AF71
 * The decimal value for hex number AF71 is 44913
 */
/**
 *
 * @author martinfall
 */
public class Hex2Dec {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a hex number: ");
        String hex = input.nextLine();

        System.out.println("The decimal value for hex number " + hex
                + " is " + hexToDecimal(hex.toUpperCase()));
    }

    /**
     * Convert hex number to a decimal number
     *
     * @param hex
     * @return
     */
    public static int hexToDecimal(String hex) {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexToCharDecimal(hexChar);
        }
        return decimalValue;
    }

    /**
     * Convert hex character to decimal
     *
     * @param ch
     * @return
     */
    public static int hexToCharDecimal(char ch) {
        if (ch >= 'A' && ch <= 'F') {
            return 10 + ch - 'A';
        } else { // ch is '0', '1', '2', ... , or '9'
            return ch - '0';
        }
    }
}
