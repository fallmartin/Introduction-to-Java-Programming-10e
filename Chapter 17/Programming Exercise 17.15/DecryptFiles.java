
import java.io.*;
import java.util.Scanner;

/**
 * (Decrypt files) Suppose a file is encrypted using the scheme in Programming
 * Exercise 17.14. Write a program to decode an encrypted file. Your program
 * should prompt the user to enter an input file name for the encrypted file and
 * an output file name for the unencrypted version of the input file.
 *
 * @author martinfall
 */
public class DecryptFiles {

    /**
     * Main method.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Create a new Scanner 
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter an input file name
        System.out.print("Enter an input file name: ");
        String inputFileName = scanner.nextLine();

        // Prompt the user to enter an input file name
        System.out.print("Enter an output file name: ");
        String outputFileName = scanner.nextLine();

        try (
                // Create buffered input and output streams
                BufferedInputStream input
                = new BufferedInputStream(new FileInputStream(inputFileName));
                BufferedOutputStream output
                = new BufferedOutputStream(new FileOutputStream(outputFileName));) {
            int value;

            while ((value = input.read()) != -1) {
                output.write(value - 5);
            }
        }
    }
}
