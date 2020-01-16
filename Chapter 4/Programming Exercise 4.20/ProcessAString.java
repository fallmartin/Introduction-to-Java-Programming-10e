
/**
 * (Process a string) Write a program that prompts the user to enter a string and
 * displays its length and its first character.
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class ProcessAString {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter a string
        System.out.print("Enter a sting: ");
        String str = input.nextLine();
        
        // Display the string's length
        System.out.println("The string's length is " + str.length());
        
        // Display the string's first character
        System.out.println("The string's first character is " + str.charAt(0));
    }
}
