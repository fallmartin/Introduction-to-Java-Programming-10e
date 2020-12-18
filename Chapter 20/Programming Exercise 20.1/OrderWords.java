
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * (Display words in ascending alphabetical order) Write a program that reads
 * words from a text file and displays all the words (duplicates allowed) in
 * ascending alphabetical order. The words must start with a letter. The text
 * file is passed as a command-line argument.
 *
 * @author martinfall
 */
public class OrderWords {

    /**
     * Main method.
     *
     * @param args
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Check command-line parameter usage
        if (args.length > 1) {
            System.out.println("Usage: java OrderWords filename.txt");
            System.exit(1); // Exit gracefully
        }

        // Check if the file exists
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("The file " + args[0] + " does not exist.");
            System.exit(2); // Exit gracefully
        }

        // Try-with-resources to manage a scanner that will read tokens from file
        try (Scanner scanner = new Scanner(file)) {
            // Create a new priority queue 
            Queue<String> queue = new PriorityQueue<>();

            // While the scanner has next, offer tokens to the queue
            while (scanner.hasNext()) {
                queue.offer(scanner.next());
            }

            // We have to poll, otherwise heap-like behavior is displayed by the iterator
            while (!queue.isEmpty()) {
                System.out.println(queue.poll());
            }
        }
    }
}
