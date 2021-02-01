
import java.util.*;

/**
 * (Pattern matching) Write a program that prompts the user to enter two strings
 * and tests whether the second string is a substring of the first string.
 * Suppose the neighboring characters in the string are distinct. (Don’t use the
 * indexOf method in the String class.) Analyze the time complexity of your
 * algorithm. Your algorithm needs to be at least O(n) time. Here is a sample
 * run of the program:
 *
 * Enter a string s1: Welcome to Java
 * Enter a string s2: come
 * matched at index 3
 *
 * Output:
 * Enter a string s1: PatternMatching.java
 * Enter a string s2: chin
 * matched at index 10
 *
 * Time Complexity: O(n)
 * The for loop in the getIndex method executes n times, where n is the length
 * of the string s1. Inside the for loop are 2 if statements that have an order
 * of magnitude of O(1) or constant time.
 *
 * @author martinfall
 */
public class PatternMatching {

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a scanner
        Scanner input = new Scanner(System.in);

        // Accept user input for stringss1 and s2
        System.out.print("Enter a string s1: ");
        String s1 = input.nextLine();
        System.out.print("Enter a string s2: ");
        String s2 = input.nextLine();

        System.out.println("matched at index " + getIndex(s1, s2));
    }

    /**
     * Returns the index of s2 in s1 or -1 if no match is found.
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int getIndex(String s1, String s2) {
        // For each character in s1
        for (int i = 0; i < s1.length(); i++) {
            // If char at i is equal to the first char of s2
            // and a potential solution exists from that index
            if (s1.charAt(i) == s2.charAt(0) && i + s2.length() < s1.length()) {
                // Build a substring of length s2 from s1 and compare to s2
                String curr = s1.substring(i, i + s2.length());
                // Return index i if curr and s2 are equal
                if (curr.equals(s2)) {
                    return i;
                }
            }
        }

        // Return -1 if no match is found
        return -1;
    }
}
