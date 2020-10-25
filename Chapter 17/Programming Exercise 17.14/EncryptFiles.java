
import java.io.*;
import java.util.Scanner;

/**
 * (Encrypt files) Encode the file by adding 5 to every byte in the file. Write
 * a program that prompts the user to enter an input file name and an output
 * file name and saves the encrypted version of the input file to the output
 * file.
 *
 * @author martinfall
 */
public class EncryptFiles {

    /**
     * Main method.
     *
     * @param args
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
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
                output.write(value + 5);
            }
        }
    }
}
