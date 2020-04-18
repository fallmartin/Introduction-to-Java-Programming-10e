
import java.util.Scanner;

/**
 * (Count uppercase letters) Write a program that prompts the user to enter a
 * string and displays the number of the uppercase letters in the string.
 *
 * Enter a string: Welcome to Java The number of uppercase letters is 2
 * 
 * Output:
 * Enter a string: Welcome to Java
 * The number of uppercase letters is 2
 */
/**
 *
 * @author martinfall
 */
public class CountUppercaseLetters {

    public static void main(String[] args) {
        // Create a counter variables for upper case letters
        int uppercase = 0;
        
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                uppercase++;
            }
        }
        System.out.println("The number of uppercase letters is " + uppercase);
    }
}
