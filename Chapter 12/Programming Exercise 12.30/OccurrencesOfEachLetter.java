
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * (Occurrences of each letter) Write a program that prompts the user to enter
 * a file name and displays the occurrences of each letter in the file. Letters
 * are case-insensitive. Here is a sample run:
 *
 * Enter a filename: Lincoln.txt
 * Number of A's: 56
 * Number of B's: 134
 * ...
 * Number of Z's: 9
 *
 * Output:
 * Enter a filename: Lincoln.txt
 * Number of A's: 102
 * Number of B's: 15
 * Number of C's: 31
 * Number of D's: 60
 * Number of E's: 169
 * Number of F's: 27
 * Number of G's: 30
 * Number of H's: 81
 * Number of I's: 68
 * Number of J's: 0
 * Number of K's: 3
 * Number of L's: 42
 * Number of M's: 13
 * Number of N's: 77
 * Number of O's: 93
 * Number of P's: 15
 * Number of Q's: 1
 * Number of R's: 81
 * Number of S's: 47
 * Number of T's: 128
 * Number of U's: 22
 * Number of V's: 24
 * Number of W's: 28
 * Number of X's: 0
 * Number of Y's: 11
 * Number of Z's: 0
 *
 * @author martinfall
 */
public class OccurrencesOfEachLetter {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a filename
        System.out.print("Enter a filename: ");

        // Create a new File object with user input
        File file = new File(input.nextLine());

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File does not exist");
            System.exit(1);
        }

        // Create an int array to serve as counter for occurrences of each letter
        int[] alphabet = new int[26];

        // Create input file
        try (Scanner in = new Scanner(file);) {
            while (in.hasNext()) {
                // Grab the next line from in and convert it to lower case
                String line = in.nextLine().toLowerCase();

                // Remove all characters from the string that are not letters
                line = line.replaceAll("[^a-z]", "");

                // Update alphabet array to reflect occurrences
                for (int i = 0; i < line.length(); i++) {
                    alphabet[(int) line.charAt(i) - 97]++; // Increment array at i
                }
            }
        }

        //Display results
        for (int i = 0; i < alphabet.length; i++) {
            System.out.printf("Number of %C's: %d%n",
                    (char) (i + 97), alphabet[i]);
        }
    }
}
