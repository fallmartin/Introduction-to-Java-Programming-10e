
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
public class RecursivePalindromeUsingSubstring {

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        } else if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        } else {
            return isPalindrome(s.substring(1, s.length() - 1));
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Is moon a palindrome? "
                + isPalindrome("moon"));
        System.out.println("Is noon a palindrome? "
                + isPalindrome("noon"));
        System.out.println("Is a a palindrome? " + isPalindrome("a"));
        System.out.println("Is aba a palindrome? "
                + isPalindrome("aba"));
        System.out.println("Is ab a palindrome? " + isPalindrome("ab"));
    }
}
