
/**
 * The lowercase letters are:
 * j s v s h q g y b i s g t g y j v b o z
 * q r s y i d e k o s z k l n p o a a i q
 * u n k h e g p c e c l t h a f a w e f x
 * w e v j o z d a d j c u e h x z b p h g
 * u n i p s y w d d y t g q i v q a d i q
 *
 * The occurrences of each letter are:
 * 6 a 3 b 3 c 6 d 6 e 2 f 6 g 5 h 6 i 4 j
 * 3 k 2 l 0 m 3 n 4 o 4 p 6 q 1 r 6 s 3 t
 * 3 u 4 v 3 w 2 x 5 y 4 z
 *
 * @author martinfall
 */
public class CountLettersInArray {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Declare and create an array
        char[] chars = createArray();

        // Display the array
        System.out.println("The lowercase letters are: ");
        displayArray(chars);

        // Count the occurrences of each letter
        int[] counts = countLetters(chars);

        // Display counts
        System.out.println();
        System.out.println("The occurrences of each letter are:");
        displayCounts(counts);
    }

    /**
     * Create an array of characters
     *
     * @return
     */
    public static char[] createArray() {
        // Declare an array of characters and create it
        char[] chars = new char[100];

        // Create lowercase letters randomly and assign them to the array
        for (int i = 0; i < chars.length; i++) {
            chars[i] = RandomCharacter.getRandomLowerCaseLetter();
        }

        // Return the array
        return chars;
    }

    /**
     * Display the array of characters
     *
     * @param chars
     */
    public static void displayArray(char[] chars) {
        // Display the characters in the array 20 on each line
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + (((i + 1) % 20 == 0) ? "\n" : " "));
        }
    }

    /**
     * Count the occurrences of each letter
     *
     * @param chars
     * @return
     */
    public static int[] countLetters(char[] chars) {
        // Declare and create an array of 26 int
        int[] counts = new int[26];

        // For each lowercase letter in the array, count it
        for (int i = 0; i < chars.length; i++) {
            counts[chars[i] - 'a']++;
        }

        return counts;
    }

    /**
     * Display counts
     *
     * @param counts
     */
    public static void displayCounts(int[] counts) {
        for (int i = 0; i < counts.length; i++) {
            if ((i + 1) % 10 == 0) {
                System.out.println(counts[i] + " " + (char) (i + 'a'));
            } else {
                System.out.print(counts[i] + " " + (char) (i + 'a') + " ");
            }
        }
    }
}
