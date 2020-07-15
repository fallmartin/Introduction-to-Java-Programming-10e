
import java.util.Scanner;

/**
 * (NumberFormatException) Write the bin2Dec(String binaryString) method to
 * convert a binary string into a decimal number. Implement the bin2Dec method
 * to throw a NumberFormatException if the string is not a binary string.
 *
 * Output:
 * Enter a binary string: 11110001
 * Converting 11110001 into a decimal number...
 * 241
 *
 * Enter a binary string: 11110001F
 * Converting 11110001F into a decimal number...
 * Invalid Input: 11110001F
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
        bin2Dec(binaryString);

    }

    /**
     *
     * @param binaryString
     * @throws NumberFormatException
     */
    public static void bin2Dec(String binaryString)
            throws NumberFormatException {
        try {
            System.out.println(Integer.parseInt(binaryString, 2));
        } catch (NumberFormatException ex) {
            System.out.println("Invalid Input: " + binaryString);
        }
    }
}
