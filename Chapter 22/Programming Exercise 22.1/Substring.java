
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
 * Output:
 * Enter a string: abcabcdgabxy
 * Using an index-based algorithm: abcdg
 * Using an substring-based algorithm: abcdg
 *
 * Enter a string: abcabcdgabmnsxy
 * Using an index-based algorithm: abmnsxy
 * Using an substring-based algorithm: abmnsxy
 *
 * Algorithm Analysis:
 * T(n) = O(n^2).
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
        // Create a scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        /**
         * Input: abcabcdgabxy
         * Output: abcdg
         *
         * Input: abcabcdgabmnsxy
         * Output: abmnsxy
         */
        String max = ""; // The max variable holds the longest substring

        /**
         * The for loop executes at most n times, where n is the length of the
         * string. Inside the for loop, the max method is called at most n
         * times, if the string input is in consecutively decreasing order.
         */
        // Local variables to extract the substring after the algorithm is done
        int start = 0;
        int end = 0;

        for (int i = 0; i < str.length(); i++) {
            int endIndex = max2(str, i);

            if (end - start < endIndex - i) {
                start = i;
                end = endIndex + 1;
            }

            i = endIndex;
        }

        System.out.print("Using an index-based algorithm: ");
        System.out.println(str.substring(start, end));

        /**
         * The for loop executes at most n times, where n is the length of the
         * string. Inside the for loop, the max method is called at most n
         * times, if the string input is in consecutively decreasing order.
         */
        for (int i = 0; i < str.length(); i++) {
            String temp = max(str, i); // Find a substring and store it in temp

            // Compare its length to the length of max and update accordingly
            if (max.length() < temp.length()) {
                max = temp;
            }
        }

        // Display the result to the console
        System.out.print("Using an substring-based algorithm: ");
        System.out.println(max);
    }

    /**
     * Returns the maximum consecutive increasingly ordered substring in a
     * string from the given start index.
     *
     * Worst-case input time complexity T(n) = O(n).
     * The for loop executes at most n - startIndex + 1 times. Each statement
     * inside the for loop has a time complexity of O(1).
     *
     * @param str
     * @param startIndex
     * @return
     */
    public static String max(String str, int startIndex) {
        // Create a temp string and assign to it the character at startIndex
        String temp = String.valueOf(str.charAt(startIndex));
        // System.out.println(temp);

        // For each remaining character in the string
        for (int i = startIndex + 1; i < str.length(); i++) {
            // If the character is increasing, concatenate it to the temp str
            if (str.charAt(startIndex) < str.charAt(i)) {
                temp += str.charAt(i);
                // System.out.println(temp);
            } else { // Break out of the loop when the if condition is false
                break;
            }
        }

        // System.out.println("---");
        // Return temp to the caller method.
        return temp;
    }

    /**
     * Returns the end index of the maximum consecutive increasingly ordered
     * substring in a string from the given start index.
     *
     * Worst-case input time complexity T(n) = O(n).
     * The for loop executes at most n - startIndex + 1 times. Each statement
     * inside the for loop has a time complexity of O(1).
     *
     * @param str
     * @param startIndex
     * @return
     */
    public static int max2(String str, int startIndex) {
        int endIndex = startIndex;

        for (int i = startIndex + 1; i < str.length(); i++) {
            if (str.charAt(i - 1) < str.charAt(i)) {
                endIndex++;
            } else {
                return endIndex;
            }
        }
        return endIndex;
    }
}
