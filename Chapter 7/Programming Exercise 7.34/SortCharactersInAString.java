
import java.util.Scanner;


/**
 * (Sort characters in a string) Write a method that returns a sorted string using
 * the following header:
 *
 * public static String sort(String s)
 *
 * For example, sort("acb") returns abc.
 *
 * Write a test program that prompts the user to enter a string and displays the
 * sorted string.
 *
 * @author martinfall
 */
public class SortCharactersInAString {
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter a string
        System.out.print("Enter a string to be sorted: ");
        String s = input.nextLine();
        
        //Display the sorted results
        System.out.print("The sorted string is ");
        System.out.println(sort(s));
    }

    public static String sort(String s) {
        // Convert s to char array 
        char[] ch = s.toCharArray();
        
        // Selection sort
        for (int i = 0; i < ch.length - 1; i++) {
            int currentMinIndex = i;
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[currentMinIndex] > ch[j]) {
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                char temp = ch[i];
                ch[i] = ch[currentMinIndex];
                ch[currentMinIndex] = temp;
            }
        }
        return String.valueOf(ch); // Return the String value of the ch array
    }
}
