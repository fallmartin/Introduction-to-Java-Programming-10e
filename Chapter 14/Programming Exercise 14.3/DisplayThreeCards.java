
import java.util.Arrays;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * (Display three cards) Write a program that displays three cards randomly
 * selected from a deck of 52, as shown in Figure 14.43c. The card image files
 * are named 1.png, 2.png, …, 52.png and stored in the image/card directory.
 * All three cards are distinct and selected randomly. Hint: You can select
 * random cards by storing the numbers 1–52 to an array list, perform a random
 * shuffle introduced in Section 11.12, and use the first three numbers in the
 * array list as the file names for the image.
 *
 * @author martinfall
 */
public class DisplayThreeCards extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create a new grid pane (Options are FlowPane, HBox, GridPane)
        GridPane pane = new GridPane();
        pane.setHgap(5); // 5 pixel horizontal gap
        pane.setPadding(new Insets(5, 5, 5, 5)); // Pane padding

        // Populate an int array with values for three cards
        int[] cards = getCards();

        // Add cards to pane
        for (int i = 0; i < cards.length; i++) {
            // Create a new image view
            ImageView imageView = new ImageView("cards/" + cards[i] + ".png");
            
            // Set fit width and heightt for bigger cards in the page
            imageView.setFitWidth(144);
            imageView.setFitHeight(192);
            
            // Add the image to the pane at column i and row 0
            pane.add(imageView, i, 0);
        }

        // Create a Scene, add scene to stage, and show stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_14_03");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public int[] getCards() {
        // Array of int values of cards from 1-52
        int[] fullDeck = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
            14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
            27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
            40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52};

        // Uncomment lines 34 and 41 to see deck before and after shuffle
        // System.out.println(Arrays.toString(fullDeck));
        // Empty array for three cards to return
        int[] threeCards = new int[3];

        // Shuffle the deck
        shuffle(fullDeck);
        // System.out.println(Arrays.toString(fullDeck));

        // Add the first three cards of the shuffled array to threeCards
        for (int i = 0; i < 3; i++) {
            threeCards[i] = fullDeck[i];
        }

        return threeCards;
    }

    public void shuffle(int[] fullDeck) {
        for (int i = 0; i < fullDeck.length; i++) {
            for (int j = i + 1; j < fullDeck.length - 1; j++) {
                int randomIndex = new Random().nextInt(52);
                int temp = fullDeck[i];
                fullDeck[i] = fullDeck[randomIndex];
                fullDeck[randomIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
