
/**
 * (Game: pick four cards) Write a program that picks four cards from a deck of
 * 52 cards and computes their sum. An Ace, King, Queen, and Jack represent 1,
 * 13, 12, and 11, respectively. Your program should display the number of picks
 * that yields the sum of 24.
 *
 * Output:
 * Jack of Hearts
 * 8 of Clubs
 * 2 of Hearts
 * 5 of Hearts
 * Current sum: 26
 *
 * Queen of Spades
 * 6 of Clubs
 * 4 of Clubs
 * 3 of Spades
 * Current sum: 25
 *
 * 6 of Clubs
 * 10 of Diamonds
 * 9 of Spades
 * 3 of Hearts
 * Current sum: 28
 *
 * 4 of Diamonds
 * 3 of Hearts
 * 4 of Diamonds
 * Jack of Spades
 * Current sum: 22
 *
 * Ace of Hearts
 * 5 of Clubs
 * 3 of Diamonds
 * 9 of Clubs
 * Current sum: 18
 *
 * Queen of Diamonds
 * Queen of Clubs
 * 6 of Hearts
 * Queen of Hearts
 * Current sum: 42
 *
 * King of Spades
 * 3 of Diamonds
 * King of Spades
 * 10 of Hearts
 * Current sum: 39
 *
 * 2 of Clubs
 * 5 of Hearts
 * 4 of Spades
 * 7 of Clubs
 * Current sum: 18
 *
 * Ace of Diamonds
 * 6 of Diamonds
 * 8 of Spades
 * 9 of Spades
 * Current sum: 24
 *
 * It took 9 tries to get the sum of 24
 *
 * @author martinfall
 */
public class GamePickFourCards {

    public static void main(String[] args) {
        // Deck of cards array
        final int N = 52;
        int[] deck = new int[N];

        // Create an array to store picks
        int[] picks = new int[4];

        // Display the array
        // System.out.println(Arrays.toString(picks));
        int sum = 0;
        long tries = 0;

        while (sum != 24) {
            // Reset the sum variable
            sum = 0;
            // Increment tries
            tries++;

            // Pick 4 cards out of N
            pickFourCards(picks, N);

            // Print the picks to console
            showPickedCards(picks);

            // Process the picks and return their sum
            sum = processPicks(picks, sum);
        }

        // Display the array
        // System.out.println(Arrays.toString(picks));
        System.out.println("It took " + tries + " tries to get the sum of " + sum);
    }

    /**
     * Process the picked cards into values that can be added to determine the
     * sum
     *
     * @param picks
     * @param sum
     * @return
     */
    public static int processPicks(int[] picks, int sum) {
        // Process the array and add card value to sum iteratively
        for (int i = 0; i < picks.length; i++) {
            int value = (picks[i] % 13) + 1;
            // System.out.println(value);
            sum += value;
        }
        // Print the current sum
        System.out.println("Current sum: " + sum + "\n");

        return sum;
    }

    /**
     * Print the ranks and suits of the randomly picked cards
     *
     * @param picks
     */
    public static void showPickedCards(int[] picks) {
        // Suits and ranks array initializers
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King"};

        // Display the current 4 cards
        for (int i = 0; i < picks.length; i++) {
            String suit = suits[picks[i] / 13];
            String rank = ranks[picks[i] % 13];
            System.out.println(rank + " of " + suit);
        }
    }

    /**
     * Pick 4 random cards out of N elements
     *
     * @param picks
     * @param N
     */
    public static void pickFourCards(int[] picks, final int N) {
        // Populate the array with random picks
        for (int i = 0; i < picks.length; i++) {
            picks[i] = (int) (Math.random() * N);
        }
    }
}
