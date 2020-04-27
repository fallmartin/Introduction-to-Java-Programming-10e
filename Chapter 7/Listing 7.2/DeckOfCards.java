
/**
 *
 * @author martinfall
 */
public class DeckOfCards {

    public static void main(String[] args) {
        // Declare an array ref var, create the array, and assign its ref to ref var
        int[] deck = new int[52];
        
        // Suits and ranks array initializers
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King"};
        
        // Initialize the cards
        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }
        
        // Shuffle the deck of cards
        for (int i = 0; i < deck.length; i++) {
            // Generate a random index between the first and last index
            int index = (int) (Math.random() * deck.length);
            
            // Swap the cards
            int temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }
        
        // Display the first 4 cards
        for (int i = 0; i < 4; i++) {
            String suit = suits[deck[i] / 13];
            String rank = ranks[deck[i] % 13];
            System.out.println("Card number " + deck[i] + ": "
            + rank + " of " + suit);
        }
    }
}
