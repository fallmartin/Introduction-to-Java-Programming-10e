
import java.util.Scanner;

/**
 * (Longest common prefix) Write a program that prompts the user to enter two
 * strings and displays the largest common prefix of the two strings. Here are
 * some sample runs:
 *
 * Enter the first string: Welcome to C++ Enter the second string: Welcome to
 * programming The common prefix is Welcome to
 *
 * Enter the first string: Atlanta Enter the second string: Macon Atlanta and
 * Macon have no common prefix
 *
 * Output: 
 * Enter the first string: Welcome to C++ 
 * Enter the first string: Welcome to programming 
 * The common prefix is Welcome to
 *
 * Enter the first string: Atlanta 
 * Enter the first string: Macon 
 * Atlanta and Macon have no common prefix
 */
/**
 *
 * @author martinfall
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        // Create an empty string object
        String tmp = "";
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the first string
        System.out.print("Enter the first string: ");
        String str1 = input.nextLine();

        // Prompt the user to enter the second string
        System.out.print("Enter the first string: ");
        String str2 = input.nextLine();

        // Exit the program if the first character of each string is not the same
        if (str1.charAt(0) != str2.charAt(0)) {
            // Display the message that there is no prefix
            System.out.println(str1 + " and " + str2 + " have no common prefix");
            System.exit(0); // Exit the program without error
        }

        // Make sure that str1 holds the longest of the strings
        if (str1.length() <= str2.length()) {
            tmp = str1;
            str1 = str2;
            str2 = tmp;
        }

        // Clear the contents of tmp
        tmp = "";

        // Loop through the longest string to find out the longest common prefix
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                tmp += str1.charAt(i);
            } else {
                break;
            }
        }

        // Display the longest common prefix
        System.out.println("The common prefix is " + tmp);
    }
}
