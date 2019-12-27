
/**
 * (Game: pick a card) Write a program that simulates picking a card from a deck
 * of 52 cards. Your program should display the rank (Ace, 2, 3, 4, 5, 6, 7, 8, 9,
 * 10, Jack, Queen, King) and suit (Clubs, Diamonds, Hearts, Spades) of the card.
 * Here is a sample run of the program:
 *
 * The card you picked is Jack of Hearts
 */
/**
 *
 * @author martinfall
 */
public class GamePickACard {

    static String printRank(int rank) {
        switch (rank) {
            case 0:
                return "Ace";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return Integer.toString(rank); // Catch errors
        }
    }

    static String printSuit(int suit) {
        switch (suit) {
            case 0:
                return "Clubs";
            case 1:
                return "Diamonds";
            case 2:
                return "Hearts";
            case 3:
                return "Spades";
            default:
                return Integer.toString(suit); // Catch errors
        }
    }

    public static void main(String[] args) {
        // Generate a number between 1 and 13 for the rank
        int rank = (int) ((Math.random() * 13) + 1);

        // Generate a number between 0 and 3 for the suit
        int suit = (int) (Math.random() * 4);

        System.out.println("The card you picked is "
                + printRank(rank) + " of " + printSuit(suit));
    }
}
