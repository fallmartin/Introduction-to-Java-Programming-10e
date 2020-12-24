
import java.util.*;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * (Game: the 24-point card game) The 24-point game is to pick any 4 cards from
 * 52 cards, as shown in Figure 20.19. Note that the Jokers are excluded. Each
 * card represents a number. An Ace, King, Queen, and Jack represent 1, 13, 12,
 * and 11, respectively. You can click the Shuffle button to get four new cards.
 * Enter an expression that uses the four numbers from the four selected cards.
 * Each number must be used once and only once. You can use the operators
 * (addition, subtraction, multiplication, and division) and parentheses in the
 * expression. The expression must evaluate to 24. After entering the
 * expression, click the Verify button to check whether the numbers in the
 * expression are currently selected and whether the result of the expression is
 * correct. Display the verification in a label before the Shuffle button.
 * Assume that images are stored in files named 1.png, 2.png, . . . , 52.png, in
 * the order of spades, hearts, diamonds, and clubs. So, the first 13 images are
 * for spades 1, 2, 3, . . . , and 13.
 *
 * @author martinfall
 */
public class TwentyFourPoint extends Application {

    private static final double WIDTH = 360;
    private static final double HEIGHT = 200;
    GridPane paneForCards = new GridPane();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Pick any 4 cards from the deck of cards generated above
        ImageView[] hand = getNewHand();

        // Construct a grid of the hand
        paintHand(hand);

        // Create the pane for the shuffle button and label
        HBox paneForShuffle = new HBox();
        paneForShuffle.setAlignment(Pos.CENTER_RIGHT);
        paneForShuffle.setPadding(new Insets(0, 0, 10, 0));
        paneForShuffle.setSpacing(10);

        Button btShuffle = new Button("Shuffle");
        Label lblMessage = new Label("Testing");
        paneForShuffle.getChildren().addAll(lblMessage, btShuffle);

        // Create the pane for the user input
        HBox paneForInput = new HBox();
        paneForInput.setAlignment(Pos.CENTER);
        paneForInput.setPadding(new Insets(10, 0, 0, 0));
        paneForInput.setSpacing(10);

        Label lblVerify = new Label("Enter an expression: ");
        TextField tfExpression = new TextField();
        Button btVerify = new Button("Verify");
        paneForInput.getChildren().addAll(lblVerify, tfExpression, btVerify);

        // 
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));
        pane.setTop(paneForShuffle);
        pane.setCenter(paneForCards);
        pane.setBottom(paneForInput);

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
            shuffle(pane);
        });

        /**
         * Event handler for the Verify button.
         */
        btVerify.setOnAction(e -> {
            // If the digits entered in the expression match the cards in pane
            if (matchDigits(tfExpression.getText())) {
                // Evaluate the expression and update the label
                lblMessage.setText(evaluateExpression(tfExpression.getText())
                        ? "Correct" : "Incorrect result");

            } else {
                lblMessage.setText("The numbers in the expressions don't\n"
                        + " match the numbers in the set");
            }
        });
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Returns any 4 cards from a passed array of 52-cards. Note that the Jokers
     * are excluded.
     *
     * @param cards
     * @return
     */
    private ImageView[] getNewHand() {
        // Create a new list of cards as image views
        ArrayList<ImageView> cards = getCards();

        // Createa a new hand as an array
        ImageView[] hand = new ImageView[4];

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
        return hand;
    }

    /**
     * Returns a full-deck of cards implemented as an array list of image views.
     * Note that the Jokers are excluded.
     *
     * @return
     */
    private ArrayList<ImageView> getCards() {
        ArrayList<ImageView> cards = new ArrayList<>(52);
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
    private void paintHand(ImageView[] hand) {
        // Clear the grid pane and add the cards to it
        paneForCards.getChildren().clear(); // Clear the grid pane
        paneForCards.setAlignment(Pos.CENTER);
        paneForCards.setGridLinesVisible(false); // Hide grid lines
        paneForCards.setHgap(10);
        for (int i = 0; i < hand.length; i++) {
            paneForCards.addRow(0, hand[i]);
        }
        // return paneForCards;
    }

    private boolean matchDigits(String expression) {
        // Create a list of card values and a list of user provided digits
        ArrayList<Integer> cards = new ArrayList<>();
        ArrayList<Integer> input = new ArrayList<>();

        // Build the list of card values
        for (Node node : paneForCards.getChildren()) {
            if (node instanceof ImageView) {
                String[] url = ((ImageView) node).getImage().getUrl().split("/");
                String fileName = url[url.length - 1].split(".png")[0];
                cards.add(Integer.parseInt(fileName) % 13 == 0
                        ? 13
                        : Integer.parseInt(fileName) % 13);
            }
        }
        // System.out.println(cards); // cards to console

        // Build the list of user provided digits
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            input.add(Integer.parseInt(matcher.group()));
        }
        // System.out.println(input); // input to console

        // Perform a difference set operation on cards and input
        ArrayList<Integer> cardsClone = (ArrayList<Integer>) cards.clone();
        cardsClone.removeAll(input);
        // System.out.println(cardsClone);// set difference to console

        // return true if the the union of the 2 sets of equal size (cards and 
        // input) is an empty set
        return cardsClone.isEmpty() && input.size() == 4;
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
        // System.out.println("Shuffle");
        pane.getChildren().remove(pane.getCenter()); // Clear the pane
        ImageView[] hand = getNewHand();
        paintHand(hand);
        pane.setCenter(paneForCards);

        return paneForCards;
    }

    /**
     * Inserts blanks around (, ), +, -, /, and *.
     *
     * @param s
     * @return
     */
    private String insertBlanks(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')'
                    || s.charAt(i) == '+' || s.charAt(i) == '-'
                    || s.charAt(i) == '*' || s.charAt(i) == '/') {
                result += " " + s.charAt(i) + " ";
            } else {
                result += s.charAt(i);
            }
        }

        return result;
    }

    /**
     * Process an operator: take an operator from the operatorStack and apply it
     * on the operands in the operandStack.
     *
     * @param operandStack
     * @param operatorStack
     */
    public static void processAnOperator(
            Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();

        if (op == '+') { // process +
            operandStack.push(op2 + op1);
        } else if (op == '-') { // process -
            operandStack.push(op2 - op1);
        } else if (op == '*') { // process *
            operandStack.push(op2 * op1);
        } else if (op == '/') { // process /
            operandStack.push(op2 / op1);
        }
    }

    private boolean evaluateExpression(String expression) {
        // System.out.println("Verifying " + expression);
        // Create operandStack to store operands
        Stack<Integer> operandStack = new Stack<>(); // Operand stack [1 - 13]

        // Create operatorStack to store operators
        Stack<Character> operatorStack = new Stack<>(); // Operator stack [+-*/()]

        // Add spaces around (, ), +, -, *, / to facilitate regex split
        expression = insertBlanks(expression);
        String[] tokens = expression.split("\\s+");

        // Phase 1: scan tokens
        for (String token : tokens) {
            if (token.length() == 0) { // Blank space
                // Unnecessary continue statement left for ease of understanding
                continue; // Back to the while loop to extract the next token
            } else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                // Process all +, -, *, / in the top of the operator stack
                while (!operatorStack.isEmpty()
                        && (operatorStack.peek() == '+'
                        || operatorStack.peek() == '-'
                        || operatorStack.peek() == '*'
                        || operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }

                // Push the + or - operator into the operator stack
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                // Process all the *, / in the top of the operator stack
                while (!operatorStack.isEmpty()
                        && (operatorStack.peek() == '*'
                        || operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }

                // Push the * or / operator into the operator stack
                operatorStack.push(token.charAt(0));
            } else if (token.trim().charAt(0) == '(') {
                operatorStack.push('('); // Push '(' to stack
            } else if (token.trim().charAt(0) == ')') {
                // Process all the operators in the stack until seeing '('
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }

                operatorStack.pop(); // Pop the '(' symbol from the stack
            } else { // An operand scanned
                // Push an operand to the stack
                // operandStack.push(new Integer(token)); // deprecated
                operandStack.push(Integer.valueOf(token));
            }
        }

        // Phase 2: process all the remaining operators in the stack
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }

        // Return the result
        return operandStack.pop() == 24; // Quod Erat Demonstrandum
    }
}
