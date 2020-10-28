
import java.io.*;
import java.util.Scanner;

/**
 * (View hex) Write a program that prompts the user to enter a file name, reads
 * bytes from the file, and displays each byte’s hex representation. (Hint: You
 * can first convert the byte value into an 8-bit string, then convert the bit
 * string into a two-digit hex string.)
 *
 * Sample output:
 * Bit string: 01001001 --> Hex string: 0x44
 * Bit string: 00100000 --> Hex string: 0x22
 * Bit string: 01100001 --> Hex string: 0x66
 * Bit string: 01101101 --> Hex string: 0x6d
 *
 * @author martinfall
 */
public class ViewHex {

    public static void main(String[] args) throws IOException {
        // Create a scanner
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a file name
        System.out.print("Enter a file name: ");
        File file = new File(scanner.nextLine());

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("The file " + file.getName() + " does not exist.");
            System.exit(0);
        }

        try (
                // Create a buffered input stream
                BufferedInputStream input
                = new BufferedInputStream(new FileInputStream(file));) {
            // Value variable to hold byte as read from input stream
            int value;

            // Reads a byte of data from this input stream in the while loop
            // and detect EOF
            while ((value = input.read()) != -1) {
                System.out.println("Hex string: " + viewHex(value));
            }
        }
    }

    /**
     * Displays the hex representation of the byte value.
     *
     * @param value
     * @return
     */
    public static String viewHex(int value) {
        /**
         * Convert the byte value into an 8-bit string.
         */
        int bitMask = 1; // 0000 0001
        String bitString = ""; // The returned string that we will build below

        for (int i = 7; i >= 0; i--) {
            // Shift the bit at i to the least significant bit position
            int temp = value >> i;

            // Determine the value of the LSB position using bitwise AND
            int bit = temp & bitMask;

            // Update the string
            bitString = bitString + bit;
        }
        // Optional line in console
        System.out.print("Bit string: " + bitString + " --> ");

        /**
         * Convert the bit string into a two-digit hex string.
         */
        // Break the bit string in two groupings of four bits
        String firstGroup = bitString.substring(0, 4);
        String secondGroup = bitString.substring(4);

        // Convert each grouping to an integer
        int firstGroupToInt = Integer.parseInt(firstGroup, 2);
        int secondGroupToInt = Integer.parseInt(secondGroup, 2);

        String hexString = buildHexString(firstGroupToInt, secondGroupToInt);

        /**
         * Using the toHexString method of the Integer class.
         */
        // Uncomment the line below to see result in console
        // System.out.println(value + " -> 0x" + Integer.toHexString(value));
        return hexString;
    }

    public static String buildHexString(int firstGroupToInt, int secondGroupToInt) {
        String hexString = "0x";

        hexString = switch (firstGroupToInt) {
            case 10 ->
                hexString + 'a';
            case 11 ->
                hexString + 'b';
            case 12 ->
                hexString + 'c';
            case 13 ->
                hexString + 'd';
            case 14 ->
                hexString + 'e';
            case 15 ->
                hexString + 'f';
            default ->
                hexString + firstGroupToInt;
        };

        hexString = switch (secondGroupToInt) {
            case 10 ->
                hexString + 'a';
            case 11 ->
                hexString + 'b';
            case 12 ->
                hexString + 'c';
            case 13 ->
                hexString + 'd';
            case 14 ->
                hexString + 'e';
            case 15 ->
                hexString + 'f';
            default ->
                hexString + firstGroupToInt;
        };

        return hexString;
    }
}
