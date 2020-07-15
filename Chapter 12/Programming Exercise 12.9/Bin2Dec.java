
import java.util.Scanner;

/**
 * (BinaryFormatException) Exercise 12.7 implements the bin2Dec method to throw
 * a BinaryFormatException if the string is not a binary string. Define a custom
 * exception called BinaryFormatException. Implement the bin2Dec method to throw
 * a BinaryFormatException if the string is not a binary string.
 *
 * @author martinfall
 */
public class Bin2Dec {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object.
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter binary string.
        System.out.print("Enter a binary string: ");
        String binaryString = input.next();

        // Convert the binary string into a decimal number and display it to console
        System.out.println("Converting " + binaryString + " into a decimal number...");
        try {
            System.out.println(bin2Dec(binaryString));
        } catch (BinaryFormatException ex) {
            System.out.println("Invalid Input\n" + ex.toString());
        }
    }

    /**
     * Converts a binary number into a decimal number.
     *
     * @param binaryString
     * @throws BinaryFormatException
     * @throws NumberFormatException
     */
    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        for (char c : binaryString.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new BinaryFormatException(binaryString);
            }
        }
        return Integer.parseInt(binaryString, 2);
    }
}
