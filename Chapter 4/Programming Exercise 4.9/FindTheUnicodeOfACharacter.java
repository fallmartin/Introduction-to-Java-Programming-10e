
/**
 * (Find the Unicode of a character) Write a program that receives a character
 * and displays its Unicode. Here is a sample run:
 *
 * Enter a character: E
 * The Unicode for the character E is 69
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class FindTheUnicodeOfACharacter {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter a character
        System.out.print("Enter a character: ");
        String temp = input.nextLine();
        
        // Grab the character from the input
        char c = temp.charAt(0);
        
        // Display the results
        System.out.println("The Unicode for the character "
                + c + " is " + (int) c);
        
    }
}
