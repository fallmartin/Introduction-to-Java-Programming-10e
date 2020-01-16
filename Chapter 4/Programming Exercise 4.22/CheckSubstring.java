
/**
 * Write a program that prompts the user to enter two strings and reports whether
 * the second string is a substring of the first string.
 *
 * Enter string s1: ABCD
 * Enter string s2: BC
 * BC is a substring of ABCD
 *
 * Enter string s1: ABCD
 * Enter string s2: BDC
 * BDC is not a substring of ABCD
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class CheckSubstring {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter string s1
        System.out.print("Enter string s1: ");
        String s1 = input.nextLine();

        // Prompt the user to enter string s2
        System.out.print("Enter string s2: ");
        String s2 = input.nextLine();

        System.out.println(s2 + " is " + (s1.contains(s2) ? "" : "not ")
                + "a substring of " + s1);
    }
}
