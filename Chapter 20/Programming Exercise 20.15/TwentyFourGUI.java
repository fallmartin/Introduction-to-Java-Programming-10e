
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author martinfall
 */
public class TwentyFourGUI extends Application {

    // Initialize an empty hand
    private ImageView[] hand = new ImageView[4];

    // Create a new list of cards as image views
    private ArrayList<ImageView> cards = getCards();

    // Create a grid pane to hold the cards
    private GridPane paneForCards = new GridPane();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Randomly pick 4 cards from the deck of cards
        getNewHand();

        // Display the hand in a grid pane
        paintHand();

        // Create the pane for the shuffle button and label
        HBox paneForShuffle = new HBox();
        paneForShuffle.setAlignment(Pos.CENTER_RIGHT);
        paneForShuffle.setPadding(new Insets(0, 0, 10, 0));
        paneForShuffle.setSpacing(10);

        Button btSolution = new Button("Find Solution");
        TextField tfSolution = new TextField();
        Button btShuffle = new Button("Shuffle");
        paneForShuffle.getChildren().addAll(btSolution, tfSolution, btShuffle);

        // Create the pane for the user input
        HBox paneForInput = new HBox();
        paneForInput.setAlignment(Pos.CENTER);
        paneForInput.setPadding(new Insets(10, 0, 0, 0));
        paneForInput.setSpacing(10);

        Label lblVerify = new Label("Enter an expression: ");
        TextField tfExpression = new TextField();
        Button btVerify = new Button("Verify");
        paneForInput.getChildren().addAll(lblVerify, tfExpression, btVerify);

        // Create a pane for all the nodes created thus far, 
        // except the label for verification result
        BorderPane centerPane = new BorderPane();
        centerPane.setPadding(new Insets(10));
        centerPane.setTop(paneForShuffle);
        centerPane.setCenter(paneForCards);
        centerPane.setBottom(paneForInput);

        // Create a label for verification results
        Label lblMessage = new Label();
        lblMessage.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.YELLOWGREEN,
                                CornerRadii.EMPTY,
                                Insets.EMPTY)));

        // Border pane with the label for verification result at the bottom
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(0, 0, 10, 0)); //
        pane.setCenter(centerPane);
        pane.setBottom(lblMessage); //

        // Create a new Scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.setTitle("24-Point Card Game"); // Set the stage title
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizable

        /**
         * Event handler for the Shuffle button. Removes the node from the
         * center, draw a new hand, and create a new pane for the cards in that
         * hand. Finally, set the new pane in the center of the border pane.
         */
        btShuffle.setOnAction(e -> {
            tfSolution.clear();
            tfExpression.clear();
            shuffle(centerPane);
        });

        /**
         * Event handler for the Verify button.
         */
        btVerify.setOnAction(e -> {
            // If the digits entered in the expression match the cards in pane
            if (matchDigits(tfExpression.getText())) {
                // Evaluate the expression and update the label
                lblMessage.setText(
                        TwentyFour.evaluateExpression(tfExpression.getText())
                        ? "Correct"
                        : "Incorrect result");

            } else {
                lblMessage.setText("The numbers in the expressions don't"
                        + " match the numbers in the set");
            }
        });

        /**
         * Event handler for the Find Solution button.
         */
        btSolution.setOnAction(e -> {
            TwentyFour game = new TwentyFour(getCardValues());
            game.solve();
            tfSolution.setText(game.getRandomSolution());
        });
    }

    /**
     * Returns any 4 cards from a passed array of 52-cards. Note that the Jokers
     * are excluded.
     *
     * @param cards
     * @return
     */
    private void getNewHand() {
        // Shuffle the deck and pull a card four times
        for (int i = 0; i < 4; i++) {
            Collections.shuffle(cards); // Shuffle the deck

            // Prevent duplicate cards from exisiting in the array
            ImageView card = cards.get(0); // Draw the top card
            while (Arrays.asList(hand).contains(card)) {
                Collections.shuffle(cards); // Shuffle the deck
                card = cards.get(0); // Draw the top card
            }
            hand[i] = card; // Variable assignment
        }
    }

    /**
     * Returns a full-deck of cards implemented as an array list of image views.
     * Note that the Jokers are excluded.
     *
     * @return
     */
    private ArrayList<ImageView> getCards() {
        cards = new ArrayList<>(52);
        for (int i = 1; i <= 52; i++) {
            ImageView imageView = new ImageView("cards/" + i + ".png");
            imageView.setFitHeight(72);
            imageView.setFitHeight(96);
            cards.add(imageView);
        }
        return cards;
    }

    /**
     * Returns a grid pane with 4 cards. Note that the Jokers are excluded.
     *
     * @param hand
     * @return
     */
    private void paintHand() {
        // Clear the grid pane and add the cards to it
        paneForCards.getChildren().clear();
        paneForCards.setAlignment(Pos.CENTER);
        paneForCards.setHgap(10);

        for (int i = 0; i < hand.length; i++) {
            paneForCards.addRow(0, hand[i]);
        }
    }

    /**
     * Clears the pane for cards, obtains a new hand, and sets the new hand in
     * the center of the grid pane.
     *
     * @param pane
     * @param paneForCards
     * @return
     */
    private GridPane shuffle(BorderPane pane) {
        getNewHand();
        paintHand();
        pane.setCenter(paneForCards);

        return paneForCards;
    }

    private boolean matchDigits(String expression) {
        // Create an Integer array for card values in the pane
        ArrayList<Integer> cards = getCardValues();
        Collections.sort(cards);
        // System.out.println(cards);

        // Create an Integer array for input values from user
        ArrayList<Integer> inputs = getInputValues(expression);
        Collections.sort(inputs);
        // System.out.println(inputs);

        return (cards.size() == inputs.size()) && (compare(cards, inputs));
    }

    private ArrayList<Integer> getCardValues() {
        ArrayList<Integer> digits = new ArrayList<>();

        for (Node node : paneForCards.getChildren()) {
            if (node instanceof ImageView) {
                String[] url = ((ImageView) node).getImage().getUrl().split("/");
                String fileName = url[url.length - 1].split(".png")[0];
                digits.add(Integer.parseInt(fileName) % 13 == 0
                        ? 13
                        : Integer.parseInt(fileName) % 13);
            }
        }
        return digits;
    }

    private ArrayList<Integer> getInputValues(String expression) {
        ArrayList<Integer> digits = new ArrayList<>();

        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            digits.add(Integer.parseInt(matcher.group()));
        }

        return digits;
    }

    private boolean compare(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        for (int i = 0; i < arr1.size(); i++) {
            if (!Objects.equals(arr1.get(i), arr2.get(i))
                    || Objects.isNull(arr1.get(i))
                    || Objects.isNull(arr2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
