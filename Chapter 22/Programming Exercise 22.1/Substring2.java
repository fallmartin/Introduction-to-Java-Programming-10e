
import java.util.*;

/**
 * (Maximum consecutive increasingly ordered substring) Write a program that
 * prompts the user to enter a string and displays the maximum consecutive
 * increasingly ordered substring. Analyze the time complexity of your program.
 * Here is a sample run:
 *
 * Enter a string:abcabcdgabxy
 * abcdg
 *
 * Enter a string: abcabcdgabmnsxy
 * abmnsxy
 *
 * Time complexity: O(n).
 * The for loop determines the time complexity of this algorithm. The contents
 * of the for block are simple statements with a time complexity of O(1). For a
 * worst-case input, the algorithm is bound by the length n of the string.
 *
 * @author martinfall
 */
public class Substring {

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a Scanner and collect user input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        // Create two linked lists for the max and current substrings
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> curr = new LinkedList<>();

        // Find the maximum consecutive increasingly ordered substring
        // curr.size() > 1 && 
        for (int i = 0; i < str.length(); i++) {
            // If curr is not empty and the last character in curr is > char at i
            if (!curr.isEmpty() && str.charAt(i) < curr.getLast()) {
                curr.clear(); // Clear the list
            }

            // Add char at i to curr
            curr.add(str.charAt(i));

            // if curr is larger than max, update max accordingly
            if (curr.size() > max.size()) {
                max.clear();
                max.addAll(curr);
            }
        }

        // Display the results
        max.forEach(ch -> System.out.print(ch));
        System.out.println();
    }
}
