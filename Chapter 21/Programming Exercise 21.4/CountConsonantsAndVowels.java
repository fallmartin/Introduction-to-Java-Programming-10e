
import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * (Count consonants and vowels) Write a program that prompts the user to enter
 * a text file name and displays the number of vowels and consonants in the
 * file. Use a set to store the vowels A, E, I, O, and U.
 *
 * Output:
 * MLK.txt contains 4407 consonants and 2791 vowels
 *
 * @author martinfall
 */
public class CountConsonantsAndVowels {

    /**
     * Main method.
     *
     * @param args
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        int vowels = 0;
        int consonants = 0;
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Ener a text file name: ");
        String filename = input.nextLine();

        // Check if the file exists
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("The file " + file.getName() + " does not exist.");
            System.exit(1);
        }

        // Create a set of vowels
        Set<Character> vowelSet = new HashSet<>(
                Arrays.asList('A', 'E', 'I', 'O', 'U'));

        // Read the contents of file to a string
        String text = Files.readString(Paths.get(file.toURI()));

        for (int i = 0; i < text.length(); i++) {
            Character curr = Character.toUpperCase(text.charAt(i));

            if (Character.isLetter(curr)) {
                if (vowelSet.contains(curr)) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        // Display the results
        String results = String.format("%s contains %d consonants and %d vowels",
                file.getName(), consonants, vowels);
        System.out.println(results);
    }
}
