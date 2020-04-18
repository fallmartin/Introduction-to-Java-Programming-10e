
import java.util.Scanner;

/**
 * (Count vowels and consonants) Assume letters A, E, I, O, and U as the
 * vowels. Write a program that prompts the user to enter a string and displays
 * the number of vowels and consonants in the string.
 *
 * Enter a string: Programming is fun The number of vowels is 5 The number of
 * consonants is 11
 * 
 * Output:
 * Enter a string: Programming is fun
 * The number of vowels is 5
 * The number of consonants is 11
 */
/**
 *
 * @author martinfall
 */
public class CountVowelsAndConsonants {

    public static void main(String[] args) {
        // Create counter variables for vowels and consonants
        int vowels = 0, consonants = 0;
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String str = input.nextLine().toUpperCase();

        // System.out.println(str); // Testing the toUpperCase method of the String class

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // Switch characters at index i
            switch (c) {
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    vowels++; // Increment the vowels counter
                    break;
                case ' ':
                    break; // Skip white spaces
                default:
                    consonants++; // Increment the consonants counter
                    break;
            }
        }
        // Display the number of vowels and consonants
        System.out.println("The number of vowels is " + vowels);
        System.out.println("The number of consonants is " + consonants);
    }
}
