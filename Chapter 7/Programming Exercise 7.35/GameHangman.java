
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Game: hangman) Write a hangman game that randomly generates a word and
 * prompts the user to guess one letter at a time, as shown in the sample run.
 * Each letter in the word is displayed as an asterisk. When the user makes a
 * correct guess, the actual letter is then displayed. When the user finishes a
 * word, display the number of misses and ask the user whether to continue to
 * play with another word. Declare an array to store words, as follows:
 *
 * @author martinfall
 */
public class GameHangman {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Flag String to test if player wants to keep playing
        String answer = "y";

        // Play rounds of Hangman until the user enters n
        do {
            playHangman();
            System.out.println("Do you want to guess another word? Enter y or n >");
            answer = input.nextLine();
        } while (answer.equals("y"));

    }

    /**
     * Play a single round of hangman.
     */
    public static void playHangman() {
        // Randomly generate a word
        String word = generateWord();

        // Corvert the word to an array
        char[] wordArray = word.toCharArray();

        // Create a maskedWordArray array filled with * the same length as word
        char[] maskedWordArray = new char[word.length()];
        Arrays.fill(maskedWordArray, '*');

        // Display the word to be guessed and the * array
        System.out.println(word);
        System.out.println(maskedWordArray);

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Local variables for misses
        int misses = 0;

        // While the word is not fully guessed
        while (isNotEqual(wordArray, maskedWordArray)) {
            // Flag to increment misses if true
            char[] beforeGuess = new char[maskedWordArray.length];
            System.arraycopy(maskedWordArray, 0, beforeGuess, 0, maskedWordArray.length);

            // Prompt the user to enter a letter in word
            System.out.print("(Guess) Enter a letter in word ");
            printArray(maskedWordArray);
            System.out.print(" > ");

            // Collect a guess from the user
            char guess = input.nextLine().charAt(0);

            // If the guess is already found
            if (alreadyFound(maskedWordArray, guess)) {
                System.out.print("\t");
                System.out.print(guess);
                System.out.println(" is already in the word");
            }

            // Loop through the word and check the guess
            for (int i = 0; i <= wordArray.length - 1; i++) {
                if (wordArray[i] == guess) { // if not found and in array
                    // Update maskedWordArray array
                    maskedWordArray[i] = guess;
                }
            }

            // If the masked word did not change, increment misses
            if (!isNotEqual(beforeGuess, maskedWordArray)) {
                misses++;
            }
        }

        // Display guessed word and misses
        System.out.print("The word is ");
        printArray(maskedWordArray);
        System.out.print(". You missed " + misses + " time\n");

    }

    /**
     * Returns true if the guess is already in the word and unmasked
     *
     * @param maskedWordArray
     * @param guess
     * @return
     */
    public static boolean alreadyFound(char[] maskedWordArray, char guess) {
        for (char letter : maskedWordArray) {
            if (letter == guess) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a word picked randomly from a list of word
     *
     * @return
     */
    public static String generateWord() {
        String[] words = {"monkey", "rooster", "dog", "pig", "rat", "ox", "tiger",
            "rabbit", "dragon", "snake", "horse", "horse", "sheep"};
        return words[(int) (Math.random() * words.length)];
    }

    /**
     * Print a character array
     *
     * @param ch
     */
    public static void printArray(char[] ch) {
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i]);
        }
    }

    /**
     * Compares 2 character arrays and returns false if they are equal and true
     * if they are not equal
     *
     * @param wordArray
     * @param maskedWordArray
     * @return
     */
    public static boolean isNotEqual(char[] wordArray, char[] maskedWordArray) {
        for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i] != maskedWordArray[i]) {
                return true;
            }
        }
        return false;
    }
}
