
import java.util.*;

/**
 * (Maximum increasingly ordered subsequence) Write a program that prompts the
 * user to enter a string and displays the maximum increasingly ordered sub-
 * sequence of characters. Analyze the time complexity of your program. Here is
 * a sample run:
 *
 * Enter a string: Welcome
 * Welo
 *
 * Verbose Output:
 * Enter a string: Welcome
 * From index 0: [W, e, l, o]
 * From index 1: [e, l, o]
 * From index 2: [l, o]
 * From index 3: [c, o]
 * From index 4: [o]
 * From index 5: [m]
 * From index 6: [e]
 * Welo
 *
 * Formatted Output:
 * Enter a string: Welcome
 * Welo
 *
 * Time complexity: O(n^2)
 * The outer for loop executes n times at most. The inner for loop executes n -
 * 1 times at most.
 *
 * @author martinfall
 */
public class Subsequence {

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a scanner and accept input from user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        // Create an linked list to hold the max sequence
        LinkedList<Character> max = new LinkedList<>();

        // Create an linked list to hold the current sequence and add the first char
        LinkedList<Character> curr = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            // Clear curr and add the character at index i
            curr.clear();
            curr.add(str.charAt(i));

            // For each character in the input string
            for (int j = i + 1; j < str.length(); j++) {
                // If next character is greater, add to substring curr
                if (curr.getLast() < str.charAt(j)) {
                    curr.add(str.charAt(j));
                }
            }

            // Uncomment the line below to see each substring at each pass
            System.out.println("From index " + i + ": " + curr);
            // Test the size of the linked lists and update max accordingly
            if (max.size() < curr.size()) {
                max.clear();
                max.addAll(curr);
            }
        }

        // Display the results
        max.forEach(c -> System.out.print(c));
        System.out.println(); // Line separator
    }
}
