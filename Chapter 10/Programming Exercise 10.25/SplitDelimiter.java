
import java.util.Arrays;

/**
 * (New string split method) The split method in the String class returns an
 * array of strings consisting of the substrings split by the delimiters.
 * However, the delimiters are not returned. Implement the following new method
 * that returns an array of strings consisting of the substrings split by the
 * matching delimiters, including the matching delimiters.
 *
 * public static String[] split(String s, String regex)
 *
 * For example, split("ab#12#453", "#") returns ab, #, 12, #, 453 in an array of
 * String, and split("a?b?gf#e", "[?#]") returns a, ?, b, ?, gf, #, and e in an
 * array of String.
 *
 * Output:
 * Splitting ab#12#453: [ab, #, 12, #, 453]
 * Splitting a?b?gf#e: [a, ?, b, ?, gf, #, e]
 *
 * @author martinfall
 */
public class SplitDelimiter {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // returns ab, #, 12, #, 453
        System.out.print("Splitting ab#12#453: ");
        String[] array = SplitDelimiter.split("ab#12#453", "#");
        System.out.println(Arrays.toString(array));

        // returns a, b, ?, b, gf, #, e
        System.out.print("Splitting a?b?gf#e: ");
        array = SplitDelimiter.split("a?b?gf#e", "[?#]");
        System.out.println(Arrays.toString(array));
    }

    /**
     * Split the string and return an array including the delimiters.
     *
     * @param s
     * @param regex
     * @return
     */
    public static String[] split(String s, String regex) {
        String[] array = new String[s.length()];

        // [ab, #, 12, #, 453]
        if (regex.length() == 1) { // If the regex contains only one delimiter
            int index = 0; // array index
            String temp = ""; // temp string

            // For each character in s
            for (int i = 0; i < s.length(); i++) {
                // If the character is not a delimiter
                if (s.charAt(i) != regex.charAt(0)) {
                    // Add the character to temp
                    temp = temp + s.charAt(i);
                } else { // If the character is a delimiter
                    array[index++] = temp; // Add temp to array at index + 1
                    // index++;
                    array[index++] = regex.charAt(0) + ""; // Add the delimiter to array
                    // index++;
                    temp = ""; // Reset temp
                }
            }
            array[index] = temp;

        } // [a, ?, b, ?, gf, #, e]
        else {
            // Local variables
            String temp = ""; // temp string
            int index = 0; // array index
            int delimiterIndex = 0; // delimiter index

            // Loop through s one character at a time
            for (int i = 0; i < s.length(); i++) {
                // If the character is not a delimiter
                if (isNotDelimeter(s.charAt(i), regex)) {
                    temp = temp + s.charAt(i); // Add to the temp string
                    delimiterIndex++; // Increment delimiterIndex
                } else { // If the character is a delimiter
                    array[index++] = temp; // add temp to array
                    // index++;
                    // Add delimiter to array
                    array[index++] = s.charAt(delimiterIndex) + "";
                    // index++;
                    temp = ""; // reset temp 
                    // Increment delimiter index
                    delimiterIndex++;
                }
            }
            array[index] = temp; // Add trailing temp to array
        }
        return cleanArray(array); // return an array devoid of nulls
    }

    /**
     * Clean the array from any trailing nulls.
     *
     * @param array
     * @return
     */
    public static String[] cleanArray(String[] array) {
        int index = 0;

        // count the number of nonempty array elements
        for (String s : array) {
            if (s != null) {
                index++;
            }
        }

        // Create a new String array as long as index
        String[] cleanArray = new String[index];
        // Copy elements from array into cleanedArray
        System.arraycopy(array, 0, cleanArray, 0, cleanArray.length);

        // Return the clean array
        return cleanArray;
    }

    /**
     * Returns true if the character is not a delimiter.
     *
     * @param c
     * @param regex
     * @return
     */
    public static boolean isNotDelimeter(char c, String regex) {
        for (int i = 1; i < regex.length() - 1; i++) {
            if (c == regex.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
