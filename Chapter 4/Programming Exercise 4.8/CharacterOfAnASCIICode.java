
/**
 * (Find the character of an ASCII code) Write a program that receives an
 * ASCII code (an integer between 0 and 127) and displays its character.
 * Here is a sample run:
 *
 * Enter an ASCII code: 69
 * The character for ASCII code 69 is E
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class CharacterOfAnASCIICode {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter an ASCII code
        System.out.print("Enter an ASCII code: ");
        int asciiCode = input.nextInt();

        // Display results
        System.out.println("The character for ASCII code "
                + asciiCode + " is " + (char) asciiCode);
    }
}
