
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * (Replace words) Write a program that replaces all occurrences of a word with
 * a new word in all the files under a directory, recursively. Pass the
 * parameters from the command line as follows:
 *
 * java ReplaceWords dirName oldWord newWord
 *
 * @author martinfall
 */
public class ReplaceWords {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Check command line parameter usage
        if (args.length != 3) {
            System.out.println("Usage: java ReplaceWords dirName oldWord newWord");
            System.out.println(1);
        }

        // Check if the parameter dirName exists and is a directory
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("Source directory " + args[0] + " does not exist");
            System.exit(2);
        }

        if (!file.isDirectory()) {
            System.out.println("Source directory " + args[0] + " is not a directory");
            System.exit(3);
        }

        // Display the results
        replaceWords(file, args[1], args[2]);
        System.out.println("Replacement complete.");
    }

    /**
     * Finds all occurrences of a word in all the files under a directory,
     * recursively.
     *
     * @param file
     * @param oldWord
     * @param newWord
     */
    public static void replaceWords(File file, String oldWord, String newWord) {
        /**
         * The file object is verified to be a directory before this method is
         * called, so we can skip this here.
         */

        File[] files = file.listFiles(); // List the directory contents

        for (File currentFile : files) { // For each object in the array
            if (currentFile.isDirectory()) {
                replaceWords(currentFile, oldWord, newWord); // Recursive call
            } else { // Base call or stopping condition
                try (Scanner input = new Scanner(currentFile);) { // try-with-resources
                    String str = "";

                    // Build a string from the file's contents
                    while (input.hasNext()) {
                        str += input.nextLine();
                    }

                    // If the string contains oldWord
                    if (str.contains(oldWord)) {
                        // Build a new string with newWord and assign it to str
                        String replaceAll = str.replaceAll(oldWord, newWord);
                        str = replaceAll;

                        // Create a new print writer object
                        try (PrintWriter output = new PrintWriter(currentFile)) {
                            output.write(str); // Write str to the output
                        }
                    }
                } catch (IOException ex) { // Handle any IO exceptions 
                    System.out.println(ex);
                }
            }
        }
    }
}
