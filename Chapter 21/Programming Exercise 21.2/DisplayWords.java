
import java.io.*;
import java.util.*;

/**
 * 21.2 (Display nonduplicate words in ascending order) Write a program that
 * reads words from a text file and displays all the nonduplicate words in
 * ascending order. The text file is passed as a command-line argument.
 *
 * @author martinfall
 */
public class DisplayWords {

    /**
     * Main method.
     *
     * @param args
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Check command-line parameter usage
        if (args.length != 1) {
            System.out.println("Incorrect usage.");
            System.out.println("java DisplayWords path/to/file.txt");
            System.exit(1);
        }

        // Check if the file exists
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("The file " + args[0] + " does not exist.");
            System.exit(2);
        }

        try (Scanner input = new Scanner(file)) {
            // Create a new tree set to store nonduplicate words
            TreeSet<String> words = new TreeSet<>();

            // Populate the tree set
            while (input.hasNext()) {
                String word = input.next();
                word = word.replaceAll("[^a-zA-Z]+", "").toLowerCase();
                words.add(word);
            }

            // Display the results
            for (String word : words) {
                System.out.println(word);
            }
        }
    }
}
