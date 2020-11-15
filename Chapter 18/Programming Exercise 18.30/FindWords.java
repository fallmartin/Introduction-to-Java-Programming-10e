
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * (Find words) Write a program that finds all occurrences of a word in all the
 * files under a directory, recursively. Pass the parameters from the command
 * line as follows:
 *
 * java Exercise18_30 dirName word
 *
 * @author martinfall
 */
public class FindWords {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Check command line parameter usage
        if (args.length != 2) {
            System.out.println("Usage: java FindWords dirName word");
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

        int counter = countWord(file, args[1]);

        // Display the results
        System.out.println("The word " + args[1] + " occurs " + counter + " times.");
    }

    /**
     * Finds all occurrences of a word in all the files under a directory,
     * recursively.
     *
     * @param file
     * @param word
     * @return
     */
    public static int countWord(File file, String word) {
        /**
         * The file object is verified to be a directory before this method is
         * called, so we can skip this here.
         */
        int counter = 0;

        File[] files = file.listFiles(); // List the directory contents

        for (File f : files) { // For each object in the array
            if (f.isDirectory()) {
                counter += countWord(f, word); // Recursive call
            } else { // Base call or stopping condition
                try (Scanner input = new Scanner(f);) {
                    while (input.hasNext()) {
                        if (input.next().equals(word)) {
                            counter++;
                        }
                    }
                } catch (FileNotFoundException ex) {
                    System.out.println(ex);
                }
            }

        }

        return counter;
    }
}
