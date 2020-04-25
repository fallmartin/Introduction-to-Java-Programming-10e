
/**
 * (Generate random characters) Use the methods in RandomCharacter in Listing
 * 6.10 to print 100 uppercase letters and then 100 single digits, printing ten
 * per line.
 *
 * @author martinfall
 */
public class RandomCharacter {

    /**
     * Main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Print 100 uppercase letters
        for (int i = 1; i <= 100; i++) {
            System.out.printf("%c ", getRandomUpperCaseLetter());
            if (i % 10 == 0) {
                System.out.println();
            }
        }
        
        // Print 100 single digits
        for (int i = 1; i <= 100; i++) {
            System.out.printf("%c ", getRandomDigitCharacter());
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }
    
    /**
     * Generate a random character between ch1 and ch2
     *
     * @param ch1
     * @param ch2
     * @return
     */
    public static char getRandomCharacter(char ch1, char ch2) {
        return (char) (ch1 + Math.random() * (ch2 - ch1 + 1));
    }

    /**
     * Generate a random uppercase letter
     *
     * @return
     */
    public static char getRandomUpperCaseLetter() {
        return getRandomCharacter('A', 'Z');
    }

    /**
     * Generate a random single digit character
     *
     * @return
     */
    public static char getRandomDigitCharacter() {
        return getRandomCharacter('0', '9');
    }
}
