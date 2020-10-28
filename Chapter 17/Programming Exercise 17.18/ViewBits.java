
import java.io.*;
import java.util.Scanner;

/**
 * (View bits) Write the following method that displays the bit representation
 * for the last byte in an integer:
 *
 * public static String getBits(int value)
 *
 * For a hint, see Programming Exercise 5.44. Write a program that prompts the
 * user to enter a file name, reads bytes from the file, and displays each
 * byte’s binary representation.
 *
 * @author martinfall
 */
public class ViewBits {

    /**
     * Main method.
     *
     * @param args
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args)
            throws FileNotFoundException, IOException {

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
                // Create a file input stream
                BufferedInputStream input
                = new BufferedInputStream(new FileInputStream(file));) {
            int value;
            // Reads a byte of data from this input stream in the while loop
            // and detect EOF
            while ((value = input.read()) != -1) {
                System.out.println(getBits(value));
            }
        }
    }

    /**
     * Displays the bit representation for the last byte in an integer.
     *
     * @param value
     * @return
     */
    public static String getBits(int value) {
        int bitMask = 1; // 00000001
        String bitString = ""; // String to hold bits

        for (int i = 7; i >= 0; i--) {
            // Shift the bit at position i to the least significant position
            int temp = value >> i;

            // Compare the shifted value in temp and bit mask using bitwise AND
            int bit = temp & bitMask;

            // Update the string with the resulting 1 or 0.
            bitString = bitString + bit;
        }
        return bitString;
    }
}
