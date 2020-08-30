
import java.util.Random;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 *
 * @author martinfall
 */
public class CardPane extends GridPane {

    public CardPane() {
        setHgap(10);
        setPadding(new Insets(10));
        setAlignment(Pos.CENTER);

        // Populate an int array with values for three cards
        int[] cards = getCards();

        // Add cards to pane
        for (int i = 0; i < cards.length; i++) {
            // Create a new image view
            ImageView imageView = new ImageView("card/" + cards[i] + ".png");

            // Set fit width and heightt for bigger cards in the page
            imageView.setFitWidth(72);
            imageView.setFitHeight(96);

            // Add the image to the pane at column i and row 0
            add(imageView, i, 0);
        }

    }

    private int[] getCards() {
        // Array of int values of cards from 1-52
        int[] fullDeck = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
            14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
            27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
            40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52};

        // Uncomment lines 34 and 41 to see deck before and after shuffle
        // System.out.println(Arrays.toString(fullDeck));
        // Empty array for three cards to return
        int[] fourCards = new int[4];

        // Shuffle the deck
        shuffle(fullDeck);
        // System.out.println(Arrays.toString(fullDeck));

        // Add the first three cards of the shuffled array to threeCards
        for (int i = 0; i < fourCards.length; i++) {
            fourCards[i] = fullDeck[i];
        }

        return fourCards;
    }

    private void shuffle(int[] fullDeck) {
        for (int i = 0; i < fullDeck.length; i++) {
            for (int j = i + 1; j < fullDeck.length - 1; j++) {
                int randomIndex = new Random().nextInt(52);
                int temp = fullDeck[i];
                fullDeck[i] = fullDeck[randomIndex];
                fullDeck[randomIndex] = temp;
            }
        }
    }
}
