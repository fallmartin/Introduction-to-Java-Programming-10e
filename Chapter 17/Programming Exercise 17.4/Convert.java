
import java.io.*;

/**
 * (Convert a text file into UTF) Write a program that reads lines of characters
 * from a text file and writes each line as a UTF-8 string into a binary file.
 * Display the sizes of the text file and the binary file. Use the following
 * command to run the program:
 *
 * java Exercise17_04 Welcome.java Welcome.utf
 *
 * Output:
 * java Convert Convert.java ConvertUTF.utf
 * Conversion complete.
 * Source file: 2587
 * Target file: 2663
 *
 * @author martinfall
 */
public class Convert {

    /**
     *
     * @param args[0] sourceFile
     * @param args[1] targetFile
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // Check command line parameter usage
        if (args.length != 2) {
            System.out.println(
                    "Usage: java Convert sourceFile.java targetFile.utf");
            System.exit(1);
        }

        // Check if the source file exists
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println(
                    "The source file " + args[0] + " does not exist.");
            System.exit(2);
        }

        // Check if the target file exists
        File targetFile = new File(args[1]);
        if (targetFile.exists()) {
            System.out.println(
                    "The traget file " + args[1] + " already exists.");
            System.exit(3);
        }

        try (
                // Create a scanner for the source file
                 BufferedReader input
                = new BufferedReader(new FileReader(args[0])); //
                // Create a data output stream for the target file
                  DataOutputStream output
                = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(args[1])));) {
            String line;
            while ((line = input.readLine()) != null) {
                output.writeUTF(line);
            }
        }

        try (
                // Create a file input stream for each file to access the available 
                // method that returns the availabe number of bytes to read in each
                 FileInputStream source = new FileInputStream(args[0]); //
                  FileInputStream target = new FileInputStream(args[1]);) {

            // Display the size of each file
            System.out.println("Conversion complete.");
            System.out.println("Source file: " + source.available());
            System.out.println("Target file: " + target.available());
        }
    }
}
