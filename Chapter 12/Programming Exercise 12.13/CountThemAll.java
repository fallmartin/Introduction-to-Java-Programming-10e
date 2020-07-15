
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * (Count characters, words, and lines in a file) Write a program that will
 * count the number of characters, words, and lines in a file. Words are
 * separated by whitespace characters. The file name should be passed as a
 * command-line argument, as shown in Figure 12.13.
 * 
 * Output:
 * java CountThemAll CountThemAll.java
 * File CountThemAll.java has
 * 1312 characters
 * 235 words
 * 61 lines
 *
 * @author martinfall
 */
public class CountThemAll {

    public static void main(String[] args) throws FileNotFoundException {
        // Counter variables for characters, words, and lines
        int characters = 0, words = 0, lines = 0;

        // Check command line parameter usage
        if (args.length != 1) {
            System.out.println("Usage: java CountThemAll [file name].java");
            System.exit(1);
        }

        // Create a new File object
        File file = new File(args[0]);

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }

        // Create input file and count characters and words
        try (Scanner input = new Scanner(file);) {
            while (input.hasNext()) {
                String token = input.next();
                // Count characters
                characters += token.length();
                // Count words
                words++; // Assuming that each token is a word
            }
        }

        // Create input file and count lines
        try (Scanner input = new Scanner(file);) {
            while (input.hasNext()) {
                String token = input.nextLine();
                // Count lines
                lines++;
            }
        }

        // Display results
        System.out.println("File " + args[0] + " has");
        System.out.println(characters + " characters");
        System.out.println(words + " words");
        System.out.println(lines + " lines");
    }
}
