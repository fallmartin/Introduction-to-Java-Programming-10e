
/**
 * Output:
 * 
 * Is moon a palindrome? false
 * Is noon a palindrome? true
 * Is a a palindrome? true
 * Is aba a palindrome? true
 * Is ab a palindrome? false
 *
 * @author martinfall
 */
public class RecursivePalindrome {

    /**
     * Recursive method.
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    /**
     * Recursive helper method for the isPalindrome(String s) method.
     *
     * @param s
     * @param low
     * @param high
     * @return
     */
    public static boolean isPalindrome(String s, int low, int high) {
        if (high <= low) { // Base case
            return true;
        } else if (s.charAt(low) != s.charAt(high)) { // Base case
            return false;
        } else {
            return isPalindrome(s, low + 1, high - 1);
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Is moon a palindrome? " + isPalindrome("moon"));
        System.out.println("Is noon a palindrome? " + isPalindrome("noon"));
        System.out.println("Is a a palindrome? " + isPalindrome("a"));
        System.out.println("Is aba a palindrome? " + isPalindrome("aba"));
        System.out.println("Is ab a palindrome? " + isPalindrome("ab"));
    }
}
