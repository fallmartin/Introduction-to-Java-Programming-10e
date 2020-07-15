
import java.util.Scanner;

/**
 * (HexFormatException) Exercise 12.6 implements the hex2Dec method to
 * throw a NumberFormatException if the string is not a hex string. Define
 * a custom exception called HexFormatException. Implement the hex2Dec
 * method to throw a HexFormatException if the string is not a hex string.
 *
 * Output:
 * Enter a hex number: FFFFFF
 * The decimal value for hex number FFFFFF is 16777215
 *
 * Enter a hex number: FFFFFG
 * HexFormatException: FFFFFG is not a valid hex string.
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

        // Throw an exception if hex is not a hex string
        try {
            hex2Dec(hex);
        } catch (HexFormatException ex) {
            System.out.println(ex);
            System.exit(0);
        }

        System.out.println("The decimal value for hex number "
                + hex + " is " + hexToDecimal(hex.toUpperCase()));
    }

    public static int hexToDecimal(String hex) {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }

        return decimalValue;
    }

    public static int hexCharToDecimal(char ch) {
        if ('A' <= ch && ch <= 'F') {
            return 10 + ch - 'A';
        } else // ch is '0', '1', ..., or '9'
        {
            return ch - '0';
        }
    }

    public static void hex2Dec(String hex) throws HexFormatException {
        // Regular expression to check if the String is a hex string
        // ^            Start of line.
        // [0-9A-F]     Character class: Any character in 0 to 9, or in A to F.
        // +            Quantifier: One or more of the above.
        // $            End of line.
        // ^[0-9A-Fa-f]+$ if you want to allow both upper and lowercase A-F

        String regex = "^[0-9A-Fa-f]+$";

        if (!hex.matches(regex)) {
            throw new HexFormatException(hex);
        }
    }
}
