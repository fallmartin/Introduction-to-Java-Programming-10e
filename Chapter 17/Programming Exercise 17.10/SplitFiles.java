
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

            // Determine the file size, file size per piece, and file size of
            // the last piece, since not all numbers divide without a remainder
            long size = input.available();
            int numberOfPieces = Integer.parseInt(args[1]);
            long sizePerPiece = size / numberOfPieces;
            long delta = size % sizePerPiece;
            long sizeOfLastPiece = sizePerPiece + delta;

            // Declare a counter variable to keep track of copied files
            int byteCounter = 0;
            // Declare a value variable to copy bytes from input to output
            int value;

            System.out.printf("Size: %,d bytes %n", size);
            System.out.printf("Number of pieces: %d %n", numberOfPieces);
            System.out.printf("Size per piece: %,d bytes %n", sizePerPiece);
            System.out.printf("Size of last piece: %,d bytes %n", sizeOfLastPiece);

            for (int i = 1; i <= numberOfPieces; i++) {
                // Handle the last file with an early if statement 
                if (i == numberOfPieces) {
                    // While the byte counter is not up to size and value is not -1
                    while ((value = input.read()) != -1) {
                        try (
                                // Create a buffered output stream 
                                BufferedOutputStream output
                                = new BufferedOutputStream(
                                        new FileOutputStream(args[0] + "." + i));) {
                            // 
                            output.write(value);
                            byteCounter++;
                        }
                    }
                } else {
                    // While the byte counter is not up to size and value is not -1
                    while (byteCounter < sizePerPiece
                            && (value = input.read()) != -1) {
                        try (
                                // Create a buffered output stream 
                                BufferedOutputStream output
                                = new BufferedOutputStream(
                                        new FileOutputStream(args[0] + "." + i));) {
                            // 
                            output.write(value);
                            byteCounter++;
                        }
                    }
                }

                // Display the number of bytes in each split file
                System.out.printf("%,d bytes in %s %n",
                        byteCounter, args[0] + "." + i);
                // Reset the bytes counter
                byteCounter = 0;
            }
        }
    }
}
