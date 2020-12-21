
import java.util.*;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 * (Game: hangman) Programming Exercise 7.35 presents a console version of the
 * popular hangman game. Write a GUI program that lets a user play the game. The
 * user guesses a word by entering one letter at a time, as shown in Figure
 * 20.18. If the user misses seven times, a hanging man swings. Once a word is
 * finished, the user can press the Enter key to continue to guess another word.
 *
 * @author martinfall
 */
public class HangmanPane extends Pane {

    /**
     * General data fields.
     */
    private static final double WIDTH = 600;
    private static final double HEIGHT = 600;

    private List<Character> missed;
    private String word;
    private char[] wordArray;
    private char[] maskedWordArray;

    /**
     * GUI data fields.
     */
    // The gallows (base, trunk, branch)
    private Arc base;
    private Line trunk, branch;

    // The hangman (rope, head, torse, left and right arms and legs.
    private Line rope, torso, leftArm, rightArm, leftLeg, rightLeg;
    private Circle head;

    // Game label for masked word, misses, and new game option
    private Label label = new Label();

    /**
     * Constructs a Hangman game.
     */
    public HangmanPane() {
        // Set the application's preferred size and label properties
        setPrefSize(WIDTH, HEIGHT);

        // Start a game
        word = generateWord(); // Returns a random word from an array of words
        startGame();

        // Event handler that handles key typed on an instance of HangmanPane
        setOnKeyTyped(e -> {
            char guess = e.getCharacter().charAt(0);
            if (guess != '\n' && guess != '\r') {
                playTurn(guess);
            }
        });

        // swing();
    }

    /**
     * Animates the figure after the game ends.
     */
    private void swing() {;
        Group group = new Group(rope, head, torso,
                leftArm, rightArm, leftLeg, rightLeg);

        getChildren().add(group);

        Rotate rotation = new Rotate();
        rotation.setPivotX(350);
        rotation.setPivotY(50);
        group.getTransforms().add(rotation);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(rotation.angleProperty(), 20,
                                Interpolator.EASE_OUT)),
                new KeyFrame(Duration.seconds(1),
                        new KeyValue(rotation.angleProperty(), -20,
                                Interpolator.EASE_OUT)));
        timeline.setAutoReverse(true);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void drawRightLeg() {
        rightLeg = new Line(350, 280, 400, 340);
        rightLeg.setStroke(Color.BLUE);
        rightLeg.setStrokeWidth(2);
        getChildren().add(rightLeg);
    }

    private void drawLeftLeg() {
        leftLeg = new Line(350, 280, 300, 340);
        leftLeg.setStroke(Color.BLUE);
        leftLeg.setStrokeWidth(2);
        getChildren().add(leftLeg);
    }

    private void drawRightArm() {
        rightArm = new Line(350, 180, 400, 230);
        rightArm.setStroke(Color.BLUE);
        rightArm.setStrokeWidth(2);
        getChildren().add(rightArm);
    }

    private void drawLeftArm() {
        leftArm = new Line(350, 180, 300, 230);
        leftArm.setStroke(Color.BLUE);
        leftArm.setStrokeWidth(2);
        getChildren().add(leftArm);
    }

    private void drawTorso() {
        torso = new Line(350, 180, 350, 280);
        torso.setStroke(Color.BLUE);
        torso.setStrokeWidth(2);
        getChildren().add(torso);
    }

    private void drawHead() {
        head = new Circle(350, 150, 30);
        head.setFill(Color.TRANSPARENT);
        head.setStroke(Color.BLUE);
        head.setStrokeWidth(2);
        getChildren().add(head);
    }

    private void drawRope() {
        rope = new Line(350, 50, 350, 120);
        rope.setStroke(Color.BLUE);
        rope.setStrokeWidth(2);
        getChildren().add(rope);
    }

    /**
     * Initializes the GUI.
     */
    private void initGUI() {

        getChildren().clear();

        base = new Arc(150, 550, 120, 50, 0, 180);
        base.setType(ArcType.OPEN);
        base.setFill(Color.TRANSPARENT);
        base.setStroke(Color.BLACK);
        base.setStrokeWidth(4);

        trunk = new Line(150, 500, 150, 50);
        trunk.setStroke(Color.BLACK);
        trunk.setStrokeWidth(4);

        branch = new Line(150, 50, 350, 50);
        branch.setStroke(Color.BLACK);
        branch.setStrokeWidth(4);

        getChildren().addAll(base, trunk, branch, label);
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
     * @return
     */
    public static String printArray(char[] ch) {
        String s = "";
        for (int i = 0; i < ch.length; i++) {
            s += ch[i];
        }
        return s;
    }

    /**
     * Compares 2 character arrays and returns false if they are equal (and true
     * if they are not equal).
     *
     * @param array1
     * @param array2
     * @return
     */
    public static boolean isNotEqual(char[] array1, char[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return true;
            }
        }
        return false;
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

    private void startGame() {
        // Initialize the label and list of missed character entries
        label = new Label();
        label.setFont(new Font(15));
        label.setLayoutX(WIDTH * 0.5);
        label.setLayoutY(HEIGHT * 0.75);

        missed = new ArrayList<>();

        // Initialize the GUI
        initGUI(); // Displays the gallows in a pane

        // Corvert the word to an array
        wordArray = word.toCharArray();

        // Create a maskedWordArray array filled with * the same length as word
        maskedWordArray = new char[word.length()];
        Arrays.fill(maskedWordArray, '*');

        // Display the masked word and missed letters in the label
        setLabel(maskedWordArray);
    }

    /**
     * Play a turn of the Hangman game.
     *
     * @param guess
     */
    private void playTurn(char guess) {
        boolean foundChar = false;
        boolean missedChar = false;
        // If the word is not fully guessed
        if (isNotEqual(wordArray, maskedWordArray)) {
            // Take a snapshot of the masked word array before a guess
            char[] before = new char[maskedWordArray.length];
            System.arraycopy(maskedWordArray, 0,
                    before, 0, maskedWordArray.length);

            if (alreadyFound(maskedWordArray, guess)) {
                foundChar = true;
            }

            if (missed.contains(guess)) {
                missedChar = true;
            }

            // Loop through the word and check the guess
            for (int i = 0; i <= wordArray.length - 1; i++) {
                // If the guess is in the word array
                if (wordArray[i] == guess) {
                    // Update the masked word array
                    maskedWordArray[i] = guess;
                }
            }

            // If the masked word array did not change
            if (!isNotEqual(before, maskedWordArray)
                    && !foundChar && !missedChar) {
                // Add guess to the missed array list
                missed.add(guess);

                // Draw the corresponding part in the pane
                switch (missed.size()) {
                    case 1:
                        drawRope();
                        break;
                    case 2:
                        drawHead();
                        break;
                    case 3:
                        drawTorso();
                        break;
                    case 4:
                        drawLeftArm();
                        break;
                    case 5:
                        drawRightArm();
                        break;
                    case 6:
                        drawLeftLeg();
                        break;
                    case 7:
                        drawRightLeg();
                        break;
                }
            }

            // Display the masked word and missed letters in the label
            setLabel(maskedWordArray);

            // If the user has 7 misses, start a new game
            if (missed.size() == 7) {
                newGame();
            }
        }
    }

    /**
     * Update the label with successful and missed character entries.
     *
     * @param maskedWordArray
     */
    private void setLabel(char[] maskedWordArray) {
        label.setText("Guess a word: " + printArray(maskedWordArray)
                + "\nMissed letters: " + missed.toString());
    }

    /**
     * Starts a new game.
     */
    private void newGame() {
        // Update the label
        label.setText("The word is: " + printArray(wordArray)
                + "\nTo continue the game, press ENTER");
        swing();

        // If user presses ENTER after getting 7 misses
        setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                word = generateWord(); // Returns a random word from an array of words
                startGame();
            }
        });
    }

}
