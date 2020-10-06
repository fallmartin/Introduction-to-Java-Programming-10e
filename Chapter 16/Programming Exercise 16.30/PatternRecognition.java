
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * (Pattern recognition: consecutive four equal numbers) Write a GUI program for
 * Programming Exercise 8.19, as shown in Figure 16.49a–b. Let the user enter
 * the numbers in the text fields in a grid of 6 rows and 7 columns. The user
 * can click the Solve button to highlight a sequence of four equal numbers, if
 * it exists. Initially, the values in the text fields are filled with numbers
 * from 0 to 9 randomly.
 *
 * @author martinfall
 */
public class PatternRecognition extends Application {

    private static final int ROWS = 6;
    private static final int COLUMNS = 7;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // 
        Grid grid = new Grid();

        // Create a new scene and place it in the pane
        Scene scene = new Scene(grid);
        primaryStage.setTitle("PatternRecognition"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        // primaryStage.setResizable(false); // Make the stage non-resizeable
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public class Grid extends BorderPane {

        // Create the label to display the solved message
        Label lblSolved = new Label();

        // Create a new grid pane
        private GridPane pane = new GridPane();

        // Create the Solve button
        private final Button btSolve = new Button("Solve");

        // Create a corresponding parallel array of integers
        int[][] values = new int[ROWS][COLUMNS];

        // List of solution row and column coordinate pairs in the grid pane
        List<int[]> solution = new ArrayList<>();

        /**
         * No-args constructor of the Grid class. Constructs a grid of squares
         * as specified by the program requirements.
         */
        public Grid() {
            // Set padding, H and V gaps
            pane.setPadding(new Insets(10));
            pane.setHgap(2);
            pane.setVgap(2);

            // Populate the pane and update the int array correspondingly
            for (int row = 0; row < ROWS; row++) {
                for (int column = 0; column < COLUMNS; column++) {
                    // Create a new square object
                    Square square = new Square();
                    // Update values
                    values[row][column] = square.getNumber();
                    // Add the square to the pane
                    pane.add(square, column, row);
                }
            }

            // Add the label, grid pane, and button to the border pane
            setTop(lblSolved);
            setCenter(pane);
            setBottom(btSolve);

            // UI customizations
            setAlignment(lblSolved, Pos.CENTER);
            setAlignment(btSolve, Pos.CENTER);
            setPadding(new Insets(10));

            // Event handler for the Solve button
            btSolve.setOnAction(e -> {
                refresh();
                isConsecutiveFour();
                // System.out.println(isConsecutiveFour());
            });
        }

        /**
         * Update the text in the squares and the integer array internally.
         */
        private void refresh() {
            clearSolution(solution);
            setTextInSquares(); // Call this method first!
            updateGridAndValues(); // Call this method second!
        }

        /**
         * Update all squares internally to reflect changes in the grid pane.
         */
        private void setTextInSquares() {
            for (Node node : pane.getChildren()) {
                // Temporary square object to hold the node for manipulation
                Square square = (Square) node;

                // Obtain the value in the text field and assign it to number
                int number = Integer.parseInt(square.tfSquare.getText());

                // Set the number internally in square
                square.setNumber(number);
            }
        }

        /**
         * Update the integer array to reflect changes in the grid pane.
         */
        private void updateGridAndValues() {
            for (int row = 0; row < ROWS; row++) {
                for (int column = 0; column < COLUMNS; column++) {
                    values[row][column] = getNumberFromSquare(row, column);
                }
                // Uncomment the following statement to see values in console
                // System.out.println(Arrays.toString(values[row]));
            }
            System.out.println();
        }

        /**
         * Private helper method that returns the number in a given square.
         *
         * @param row
         * @param column
         * @return
         */
        private int getNumberFromSquare(int row, int column) {
            int number = -1; // Sentinel value

            // Enhanced for loop to iterate through the contents of pane
            for (Node node : pane.getChildren()) {
                if (row == GridPane.getRowIndex(node)
                        && column == GridPane.getColumnIndex(node)) {
                    Square square = (Square) node; // Temp node
                    number = square.getNumber(); // Update number
                }
            }
            // Return number
            return number;
        }

        /**
         * Check for four consecutive equal numbers in the matrix
         *
         * @param values
         * @return
         */
        private boolean isConsecutiveFour() {

            // Check all possible combinations
            return checkHorizontal()
                    || checkVertical()
                    || checkDiagonalLeftToRight()
                    || checkDiagonalRightToLeft();
        }

        /**
         * Check for four consecutive equal numbers in each row
         *
         * @param values
         * @return
         */
        private boolean checkHorizontal() {
            for (int row = 0; row < ROWS; row++) {
                for (int column = 0; column < COLUMNS - 3; column++) {
                    int counter = 0;

                    int testValue = values[row][column];
                    for (int i = column; i < column + 4; i++) {
                        if (values[row][i] == testValue) {
                            counter++;

                            // Update the list of solutions
                            updateSolution(row, i);
                        }
                    }

                    // Accounting for 4 or more consecutive finds
                    if (counter >= 4) {
                        System.out.println(testValue
                                + " starting at (" + row + ", " + column + ")");

                        // Trim the solution to the last 4 consecutive finds
                        trimSolution();
                        paintSolution(solution);

                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * Check for four consecutive equal numbers in each column
         *
         * @param values
         * @return
         */
        private boolean checkVertical() {
            for (int column = 0; column < COLUMNS; column++) {
                for (int row = 0; row < ROWS - 3; row++) {
                    int counter = 0;
                    int testValue = values[row][column];

                    for (int i = row; i < row + 4; i++) {
                        if (values[i][column] == testValue) {
                            counter++;

                            // Update the list of solutions
                            updateSolution(i, column);
                        }
                    }

                    // Accounting for 4 or more consecutive finds
                    if (counter >= 4) {
                        System.out.println(testValue
                                + " starting at (" + row + ", " + column + ")");

                        // Trim the solution to the last 4 consecutive finds
                        trimSolution();
                        paintSolution(solution);

                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * Check for four consecutive equal numbers on the diagonal from left to
         * right
         *
         * @param values
         * @return
         */
        private boolean checkDiagonalLeftToRight() {
            for (int row = 0; row < ROWS - 3; row++) {
                for (int column = 0; column < COLUMNS - 3; column++) {
                    int counter = 0;
                    int testValue = values[row][column];

                    for (int i = row, j = column; i < row + 4; i++, j++) {

                        if (values[i][j] == testValue) {
                            counter++;

                            // Update the list of solutions
                            updateSolution(i, j);
                        }
                    }

                    // Accounting for 4 or more consecutive finds
                    if (counter >= 4) {
                        System.out.println(testValue
                                + " starting at (" + row + ", " + column + ")");

                        // Trim the solution to the last 4 consecutive finds
                        trimSolution();
                        paintSolution(solution);

                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * Check for four consecutive equal numbers on the diagonal from right
         * to
         * left
         *
         * @param values
         * @return
         */
        private boolean checkDiagonalRightToLeft() {
            for (int row = ROWS - 1; row > ROWS - 3; row--) {
                for (int column = 0; column < COLUMNS - 3; column++) {
                    int counter = 0;
                    int testValue = values[row][column];

                    for (int i = row, j = column; i > row - 4; i--, j++) {
                        if (values[i][j] == testValue) {
                            counter++;

                            // Update the list of solutions
                            updateSolution(i, j);
                        }
                    }

                    // Accounting for more than 4 consecutive finds
                    if (counter >= 4) {
                        System.out.println(testValue
                                + " starting at (" + row + ", " + column + ")");

                        // Trim the solution to the last 4 consecutive finds
                        trimSolution();
                        paintSolution(solution);

                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * Trims the solution to the last 4 consecutive numbers.
         */
        private void trimSolution() {
            if (solution.size() > 4) {
                int size = solution.size();
                solution = solution.subList(size - 4, size);
            } else if (solution.size() < 4) {
                solution.clear();
            }
            System.out.println(Arrays.deepToString(solution.toArray()));
        }

        /**
         * Update the solution list with all possible values
         *
         * @param i
         * @param j
         */
        private void updateSolution(int i, int j) {
            // Create an integer array for the pair of row-column coordinates
            int[] rowColumn = {i, j};
            // Add the pair to the solution list
            solution.add(rowColumn);
        }

        /**
         * Remove the previously drawn borders.
         *
         * @param list
         */
        private void clearSolution(List<int[]> list) {
            // Remove the previous borders
            for (int[] rowColumn : list) {
                for (Node node : pane.getChildren()) {
                    if (GridPane.getRowIndex(node) == rowColumn[0]
                            && GridPane.getColumnIndex(node) == rowColumn[1]) {
                        ((Square) node).clearBorder();
                    }
                }
            }
        }

        /**
         * Paint the solution in the visual components as specified by the
         * project requirements.
         *
         * @param list
         */
        private void paintSolution(List<int[]> list) {

            List<int[]> solution = list;

            // Paint the solution grid squares accordingly
            for (int[] rowColumn : list) {
                for (Node node : pane.getChildren()) {
                    if (GridPane.getRowIndex(node) == rowColumn[0]
                            && GridPane.getColumnIndex(node) == rowColumn[1]) {
                        Square square = (Square) node;
                        square.setSolutionBorder();
                    }
                }
            }
        }
    }

    private class Square extends StackPane {

        // Create a text field
        private TextField tfSquare = new TextField();

        // Integer variable for the number contained in the text field
        private int number;

        // Border customization for the text field
        private BorderStroke borderStroke = new BorderStroke(
                Color.LIGHTGRAY,
                BorderStrokeStyle.SOLID,
                new CornerRadii(5),
                new BorderWidths(1));

        private BorderStroke solutionBorderStroke = new BorderStroke(
                Color.RED,
                BorderStrokeStyle.SOLID,
                new CornerRadii(5),
                new BorderWidths(2));

        private Border border = new Border(borderStroke);
        private Border solutionBorder = new Border(solutionBorderStroke);

        /**
         * No-args constructor creates a Square object with a random number in
         * the 0-9 range.
         */
        public Square() {
            tfSquare.setPrefSize(30, 30);
            tfSquare.setAlignment(Pos.CENTER);
            tfSquare.setBorder(border);

            number = (int) (Math.random() * 9);
            tfSquare.setText(Integer.toString(number));

            getChildren().add(tfSquare);
        }

        /**
         * Returns the number in the square.
         *
         * @return
         */
        public int getNumber() {
            return number;
        }

        /**
         * Updates the number in the square.
         *
         * @param number
         */
        public void setNumber(int number) {
            this.number = number;
        }

        /*
         * Reset the border of text fields to the default gray border.
         */
        private void clearBorder() {
            tfSquare.setBorder(border);
        }

        /*
         * Reset the border of text fields to the default gray border.
         */
        private void setSolutionBorder() {
            tfSquare.setBorder(solutionBorder);
        }
    }
}
