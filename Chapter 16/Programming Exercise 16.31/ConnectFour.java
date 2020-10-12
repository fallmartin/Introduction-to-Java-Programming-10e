
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Game: connect four) Programming Exercise 8.20 enables two players to play
 * the connect-four game on the console. Rewrite a GUI version for the program,
 * as shown in Figure 16.49c. The program enables two players to place red and
 * yellow discs in turn. To place a disk, the player needs to click an available
 * cell. An available cell is unoccupied and its downward neighbor is occupied.
 * The program flashes the four winning cells if a player wins and reports no
 * winners if all cells are occupied with no winners.
 *
 * Reminder: 1 for YELLOW and 2 for RED
 *
 * Areas of Improvement:
 * Can improve the program by keeping track of the last filled row from the
 * bottom up, and only searching for consecutive four numbers from the lowest
 * row to the highest occupied row.
 *
 * @author martinfall
 */
public class ConnectFour extends Application {

    // Boolean flag data field to record a winner
    boolean hasWinner = false;

    // Create a new label
    Label lblWinner = new Label();

    @Override // Override the start method of the Application class
    public void start(Stage primaryStage) throws Exception {

        // Create a new board
        Board board = new Board();

        // Create a button to reset the game
        Button btReset = new Button("Reset");

        // Create a new border pane and add the stack pane to center
        BorderPane pane = new BorderPane();
        pane.setTop(lblWinner);
        pane.setCenter(board);
        pane.setBottom(btReset);

        // Some pane visual adjustments
        BorderPane.setAlignment(lblWinner, Pos.CENTER);
        BorderPane.setAlignment(btReset, Pos.CENTER);

        btReset.setOnAction(e -> {
            pane.setCenter(new Board());
            lblWinner.setText("");
            hasWinner = false;
        });

        // Create a new scene and place it in the pane
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Connect Four"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizeable
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private class Board extends GridPane {

        // Rows and columns data fields
        private final int ROWS = 6;
        private final int COLUMNS = 7;

        // Boolean flag
        boolean turnFlag = true; // Used to track whose turn it is.

        // Two-dimensional integer array to track player's moves
        private int[][] values = new int[ROWS][COLUMNS];

        // Create two array lists for the colors solutions
        List<int[]> solution = new ArrayList<>();

        Background background = new Background(
                new BackgroundFill(Color.rgb(40, 117, 223),
                        CornerRadii.EMPTY,
                        Insets.EMPTY));

        public Board() {
            // Make some UI customization
            setBackground(background);
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(10));

            // Fill the array with empty discs
            for (int row = 0; row < ROWS; row++) {
                for (int column = 0; column < COLUMNS; column++) {
                    // Create a new disc
                    Disc disc = new Disc();

                    // Add the disc to the board game
                    add(disc, column, row);

                    // Register an event handler on mouse clicked
                    disc.setOnMouseClicked(e -> {
                        if (hasWinner == false) {
                            // System.out.println(e.getSource());
                            Disc currentDisc = (Disc) e.getSource();

                            // If the player clicked on a valid placement
                            if (isValid(disc)) {
                                // Play the corresponding color turn
                                if (turnFlag) {
                                    currentDisc.setYellow();
                                } else {
                                    currentDisc.setRed();
                                }
                                turnFlag = !turnFlag; // Change the turn color

                                // Update the board tracker integer array
                                updateValues(currentDisc);

                                // Print the board tracker to the console
                                // printValues();
                                //
                                isConnectFour(currentDisc);

                                // Check for four consecutive same color discs
                            } else {
                                // Uncomment the following line to see invalid moves
                                System.out.println("Not a valid placement.");
                            }
                        } else {
                            System.out.println("Game over!");
                            if (hasWinner == false) {
                                lblWinner.setText("No winner! Try again.");
                            }
                        }
                    });
                }
            }
        }

        private boolean isValid(Disc disc) {
            boolean unoccupiedCell = false;
            boolean occupiedDownwardNeighbor = false;

            // Obtain the row and column indices of disc
            int row = GridPane.getRowIndex(disc);
            int column = GridPane.getColumnIndex(disc);

            // Check if the cell is unoccupied
            for (Node node : getChildren()) {
                if (GridPane.getRowIndex(node) == row
                        && GridPane.getColumnIndex(node) == column) {
                    if (((Disc) node).isEmpty()) {
                        unoccupiedCell = true;
                    }
                }
            }

            // Check if the cell's downward neighbor is occupied or the last row
            if (row + 1 == ROWS) { // The very last row at the bottom
                occupiedDownwardNeighbor = true;
            } else { // Check if the cell below is occupied
                for (Node node : getChildren()) {
                    if (GridPane.getRowIndex(node) == row + 1
                            && GridPane.getColumnIndex(node) == column) {
                        if (!((Disc) node).isEmpty()) {
                            occupiedDownwardNeighbor = true;
                        }
                    }
                }
            }

            return unoccupiedCell && occupiedDownwardNeighbor;
        }

        private void updateValues(Disc disc) {
            // Obtain the row and column indices of disc
            int row = GridPane.getRowIndex(disc);
            int column = GridPane.getColumnIndex(disc);

            values[row][column] = disc.getColor();
        }

        private void printValues() {
            System.out.println(); // Formatting line
            for (int row = 0; row < ROWS; row++) {
                for (int column = 0; column < COLUMNS; column++) {
                    System.out.print(values[row][column] + " ");
                }
                System.out.println(); // Formatting line
            }
            System.out.println(); // Formatting line
        }

        private void flash(List<int[]> list) {
            // Set the global boolean flag to true
            hasWinner = true;

            // Display a message to console
            System.out.println("ANIMATION TIME!");

            // Apply a fade transition to the four consecutive colors
            for (int[] rowColumn : list) {
                for (Node node : getChildren()) {
                    if (GridPane.getRowIndex(node) == rowColumn[0]
                            && GridPane.getColumnIndex(node) == rowColumn[1]) {
                        FadeTransition fade = new FadeTransition();
                        fade.setAutoReverse(true);
                        fade.setDuration(Duration.millis(500));
                        fade.setCycleCount(Timeline.INDEFINITE);
                        fade.setNode(((Disc) node));
                        fade.setFromValue(0.5);
                        fade.setToValue(1.0);
                        fade.setByValue(0.1);
                        fade.play();
                    }
                }
            }
        }

        private void isConnectFour(Disc disc) {
            int row = GridPane.getRowIndex(disc);
            int column = GridPane.getColumnIndex(disc);
            int testColor = values[row][column];

            /**
             * Look for four consecutive colors horizontally.
             */
            // Create a counter initialized at 0
            int counter = 0;

            for (int j = (column - 3 < 0 ? 0 : column - 3);
                    j < (column + 4 < COLUMNS ? column + 4 : COLUMNS);
                    j++) {
                if (values[row][j] == testColor) {
                    // Increment the counter
                    counter++;
                    System.out.println("Horizontal counter: " + counter);

                    // Add row and j to the solution array list
                    int[] rowColumn = new int[2];
                    rowColumn[0] = row;
                    rowColumn[1] = j;
                    solution.add(rowColumn);

                    if (counter == 4) {
                        // Console winner display
                        System.out.println((testColor == 1 ? "Yellow" : "Red") + " wins!");
                        System.out.println(Arrays.deepToString(solution.toArray()));

                        // Flash winner
                        flash(solution);

                        // Update the label
                        lblWinner.setText((testColor == 1 ? "Yellow" : "Red") + " wins!");
                    }
                } else {
                    counter = 0;
                    solution.clear();
                }
            }

            // Flush the solution list
            solution.clear();

            /**
             * Look for four consecutive colors vertically.
             *
             * Note to self: index - 3 when index = 3 is 0, so when we evaluate
             * index - 3 so less than or equal is equivalent to just (less
             * than). I decided to keep just the less than to keep it
             * symmetrical in form.
             */
            // Reset the counter before checking vertically
            counter = 0;
            for (int i = (row - 3 < 0 ? 0 : row - 3);
                    i < (row + 4 < ROWS ? row + 4 : ROWS);
                    i++) {
                if (values[i][column] == testColor) {
                    // Increment the counter
                    counter++;
                    System.out.println("Vertical counter: " + counter);

                    // Add row and j to the solution array list
                    int[] rowColumn = new int[2];
                    rowColumn[0] = i;
                    rowColumn[1] = column;
                    solution.add(rowColumn);

                    if (counter == 4) {
                        System.out.println((testColor == 1 ? "Yellow" : "Red") + " wins!");
                        System.out.println(Arrays.deepToString(solution.toArray()));

                        // Flash winner
                        flash(solution);

                        // Update the label
                        lblWinner.setText((testColor == 1 ? "Yellow" : "Red") + " wins!");
                    }
                } else {
                    counter = 0;
                    solution.clear();
                }
            }

            // Flush the solution list
            solution.clear();

            /**
             * Look for four consecutive colors in the TLBR diagonal.
             *
             * For clarity, I will refer to the top-left bottom-right diagonal
             * as TLBR, and the bottom-left top-right diagonal as BLTR for the
             * remainder of this exercise.
             */
            // Reset the counter before checking TLBR diagonal
            counter = 0;

            // Variables for the starting and ending row, column pairs
            int startRow = row;
            int startColumn = column;
            int endRow = row;
            int endColumn = column;

            boolean flag = false;

            // Starting row, column pair
            for (int i = 3; i >= 0 && flag == false; i--) {
                if (startRow - i >= 0 && startColumn - i >= 0) {
                    startRow -= i;
                    startColumn -= i;
                    flag = true; // Raise the flag
                }
            }

            // Set the flag back to false
            flag = false;

            // Ending row, column pair
            for (int i = 3; i >= 0 && flag == false; i--) {
                if (endRow + i < ROWS && endColumn + i < COLUMNS) {
                    endRow += i;
                    endColumn += i;
                    flag = true;
                }
            }

            // Check the predetermined range
            for (int i = startRow, j = startColumn;
                    i <= endRow && j <= endColumn;
                    i++, j++) {
                if (values[i][j] == testColor) {
                    // Increment the counter
                    counter++;
                    System.out.println("TLBR counter: " + counter);

                    // Add row and j to the solution array list
                    int[] rowColumn = new int[2];
                    rowColumn[0] = i;
                    rowColumn[1] = j;
                    solution.add(rowColumn);

                    if (counter == 4) {
                        System.out.println((testColor == 1 ? "Yellow" : "Red") + " wins!");
                        System.out.println(Arrays.deepToString(solution.toArray()));

                        // Flash winner
                        flash(solution);

                        // Update the label
                        lblWinner.setText((testColor == 1 ? "Yellow" : "Red") + " wins!");
                    }
                } else {
                    counter = 0;
                    solution.clear();
                }
            }

            // Flush the solution list
            solution.clear();

            /**
             * Look for four consecutive colors in the BLTR diagonal.
             */
            // Reset the counter before checking BLTR diagonal
            counter = 0;
            // Set the flag back to false
            flag = false;

            // Variables for the starting and ending row, column pairs
            startRow = row;
            startColumn = column;
            endRow = row;
            endColumn = column;

            // Starting row, column pair
            for (int i = 3; i >= 0 && flag == false; i--) {
                if (startRow - i >= 0 && startColumn + i < COLUMNS) {
                    startRow -= i;
                    startColumn += i;
                    flag = true; // Raise the flag
                }
            }

            // Uncomment to display the start row and column in the console
            // System.out.printf("Start at (%d, %d)%n", startRow, startColumn);
            // Set the flag back to false
            flag = false;

            // Ending row, column pair
            for (int i = 3; i >= 0 && flag == false; i--) {
                if (endRow + i < ROWS && endColumn - i >= 0) {
                    endRow += i;
                    endColumn -= i;
                    flag = true;
                }
            }

            // Uncomment to display the end row and column in the console
            // System.out.printf("Finish at (%d, %d)%n", endRow, endColumn);
            // Check the predetermined range
            for (int i = startRow, j = startColumn;
                    i <= endRow && j >= endColumn;
                    i++, j--) {
                // System.out.printf("(%d, %d)%n", i, j);

                if (values[i][j] == testColor) {
                    // Increment the counter
                    counter++;
                    System.out.println("BLTR counter: " + counter);

                    // Add row and j to the solution array list
                    int[] rowColumn = new int[2];
                    rowColumn[0] = i;
                    rowColumn[1] = j;
                    solution.add(rowColumn);

                    if (counter == 4) {
                        System.out.println((testColor == 1 ? "Yellow" : "Red") + " wins!");
                        System.out.println(Arrays.deepToString(solution.toArray()));

                        // Flash the winner
                        flash(solution);

                        // Update the label
                        lblWinner.setText((testColor == 1 ? "Yellow" : "Red") + " wins!");
                    }
                } else {
                    counter = 0;
                    solution.clear();
                }
            }

            // Flush the solution list
            solution.clear();
            // Print a formatting line to the console
            System.out.println();
        }
    }

    private class Disc extends Circle {

        private final Color EMPTY = Color.rgb(18, 59, 115);
        private final Color RED = Color.rgb(254, 0, 0);
        private final Color YELLOW = Color.rgb(255, 240, 1);
        private final Color FLASHING = Color.rgb(96, 251, 249);
        private final Color color = EMPTY;

        private final double RADIUS = 20.0;

        public Disc() {
            setRadius(RADIUS);
            setFill(EMPTY);
            setStroke(Color.BLACK);
        }

        public void setEmpty() {
            setFill(EMPTY);
        }

        public void setYellow() {
            setFill(YELLOW);
        }

        public void setRed() {
            setFill(RED);
        }

        public boolean isEmpty() {
            if (getFill().equals(EMPTY)) {
                return true;
            }
            return false;
        }

        /**
         * Return 1 for YELLOW and 2 for RED.
         *
         * @return
         */
        public int getColor() {
            if (getFill() == YELLOW) {
                return 1;
            } else {
                return 2;
            }
        }
    }
}
