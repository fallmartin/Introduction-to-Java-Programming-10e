
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * (Process scores in a text file) Suppose that a text file contains an
 * unspecified number of scores separated by blanks. Write a program that
 * prompts the user to enter the file, reads the scores from the file, and
 * displays their total and average.
 *
 * Output:
 * Enter the file name: numbers.txt
 * Total: 210.00
 * Average: 10.50
 *
 * @author martinfall
 */
public class ProcessScores {

    public static void main(String[] args) throws FileNotFoundException {
        int counter = 0;
        double total = 0;

        // Prompt the user to enter the file
        System.out.print("Enter the file name: ");
        String filename = new Scanner(System.in).nextLine();

        // Create a new File object
        File file = new File(filename);

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("Source file " + filename + " does not exist");
            System.exit(1);
        }

        // Create input file, read the scores, and calculate total and number of scores
        try (Scanner input = new Scanner(file);) {
            while (input.hasNext()) {
                int score = input.nextInt();
                total += score;
                counter++;
            }
        }

        // Display the total and average
        System.out.printf("Total: %.2f%n", total);
        System.out.printf("Average: %.2f%n", (total / counter));
    }
}
