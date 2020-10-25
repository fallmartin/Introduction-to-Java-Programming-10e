
import java.io.*;

/**
 * (Split files) Suppose you want to back up a huge file (e.g., a 10-GB AVI
 * file) to a CD-R. You can achieve it by splitting the file into smaller pieces
 * and backing up these pieces separately. Write a utility program that splits a
 * large file into smaller ones using the following command:
 *
 * java Exercise17_10 SourceFile numberOfPieces
 *
 * The command creates the files SourceFile.1, SourceFile.2, . . . ,
 * SourceFile.n, where n is numberOfPieces and the output files are about the
 * same size.
 *
 * @author martinfall
 */
public class SplitFiles {

    /**
     * Main method.
     *
     * @param args[0] sourceFile
     * @param args[1] numberOfPieces
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String[] args)
            throws FileNotFoundException, IOException {

        // Check command-line parameter usage
        if (args.length != 2) {
            System.out.println("Usage: java SplitFiles SourceFile numberOfPieces");
            System.exit(1);
        }

        // Check if source file exists
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist.");
            System.exit(2);
        }

        try (
                // Create a buffered input stream
                BufferedInputStream input
                = new BufferedInputStream(new FileInputStream(args[0]));) {

            // Determine the size of the file and the resulting split files
            long size = input.available();
            int numberOfPieces = Integer.parseInt(args[1]);
            long splitFileSize = (long) Math.ceil(1.0 * size / numberOfPieces);

            // Some console magic
            System.out.printf("Size: %,d bytes %n", size);
            System.out.printf("Number of pieces: %d %n", numberOfPieces);
            System.out.printf("Size per piece: %,d bytes %n", splitFileSize);

            // Iterate through the number of pieces
            for (int i = 1; i <= numberOfPieces; i++) {
                try (
                        // Create a buffered output stream 
                        BufferedOutputStream output
                        = new BufferedOutputStream(
                                new FileOutputStream(args[0] + "." + i));) {
                    // Declare a counter variable to keep track of copied files
                    int byteCounter = 0;
                    // Declare a value var to copy bytes from input to output
                    int value;

                    // While the split file size is right and not at EOF
                    while (byteCounter++ < splitFileSize
                            && (value = input.read()) != -1) {
                        output.write(value);
                    }
                }
            }
        }
    }
}
