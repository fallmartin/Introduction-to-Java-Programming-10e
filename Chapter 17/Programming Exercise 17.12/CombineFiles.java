
import java.io.*;
import java.util.Arrays;

/**
 * (Combine files) Write a utility program that combines the files together into
 * a new file using the following command:
 *
 * java CombineFiles SourceFile1 . . . SourceFilen TargetFile
 *
 * The command combines SourceFile1, . . . , and SourceFilen into TargetFile.
 *
 * @author martinfall
 */
public class CombineFiles {

    /**
     * Main method
     *
     * @param args
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args)
            throws FileNotFoundException, IOException {

        /**
         * Check command-line parameter usage assuming a minimum of 3
         * parameters, such as 2 source files to combine and 1 target file
         */
        if (args.length < 3) { // 2 source files to combine and 1 target file
            System.out.println("Usage: java CombineFiles "
                    + "SourceFile1 ... SourceFilen TargetFile");
            System.exit(1);
        }

        // Check if the target file already exists
        File targetFile = new File(args[args.length - 1]);
        if (targetFile.exists()) {
            System.out.println("Target file " + targetFile + " already exists.");
            System.exit(2);
        }

        // Process the args array of string to create an array of source files
        File[] sourceFiles = new File[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            sourceFiles[i] = new File(args[i]);
        }

        // Display the target file and source files to the console
        System.out.println("Target file: " + targetFile.getName());
        System.out.println("Source files: " + Arrays.toString(sourceFiles));

        // Check if the source files are all there
        for (File sourceFile : sourceFiles) {
            if (!sourceFile.exists()) {
                System.out.println(sourceFile.getName() + " does not exist.");
                System.exit(3);
            }
        }

        // The fun stuff
        try (
                // Create a random access file
                BufferedOutputStream output
                = new BufferedOutputStream(
                        new FileOutputStream(targetFile, true));) {
            // Value var to hold input as it is read from source file
            int value;

            // Process the file array
            for (File sourceFile : sourceFiles) {
                try (
                        // Create a buffered input stream
                        BufferedInputStream input
                        = new BufferedInputStream(
                                new FileInputStream(sourceFile));) {
                    while ((value = input.read()) != -1) {
                        output.write(value);
                    }
                }
            }
        }
    }
}
