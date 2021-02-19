package largestblock;

import java.util.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * (Largest block) The problem for finding a largest block is described in
 * Programming Exercise 8.35. Design a dynamic programming algorithm for solving
 * this problem in O(n^2) time. Write a test program that displays a 10-by-10
 * square matrix, as shown in Figure 22.14a. Each element in the matrix is 0 or
 * 1, randomly generated with a click of the Refresh button. Display each number
 * centered in a text field. Use a text field for each entry. Allow the user to
 * change the entry value. Click the Find Largest Block button to find a largest
 * square submatrix that consists of 1s. Highlight the numbers in the block, as
 * shown in Figure 22.14b.
 *
 * Console Output:
 *
 * The unprocessed array of 0s and 1s
 * 1 1 0 0 0 0 0 1 1 0
 * 1 1 1 0 1 1 1 0 0 0
 * 1 0 0 1 0 1 0 0 1 0
 * 1 1 1 1 1 0 0 0 1 1
 * 1 1 0 1 0 0 0 1 1 1
 * 1 0 1 1 0 0 1 1 1 0
 * 0 1 1 1 0 1 0 0 0 1
 * 1 1 1 1 0 1 0 1 1 0
 * 1 1 1 0 1 0 0 1 1 1
 * 1 1 0 1 1 1 0 0 1 0
 *
 * The transformed array
 * 1 2 0 0 0 0 0 1 2 0
 * 1 2 3 0 1 2 3 0 0 0
 * 1 0 0 1 0 1 0 0 1 0
 * 1 2 3 4 5 0 0 0 1 2
 * 1 2 0 1 0 0 0 1 2 3
 * 1 0 1 2 0 0 1 2 3 0
 * 0 1 2 3 0 1 0 0 0 1
 * 1 2 3 4 0 1 0 1 2 0
 * 1 2 3 0 1 0 0 1 2 3
 * 1 2 0 1 2 3 0 0 1 0
 *
 * Finding the largest block in the matrix
 * Block of size 2 with top right edge at (0, 1)
 * Block of size 2 with top right edge at (3, 1)
 * Block of size 2 with top right edge at (3, 9)
 * Block of size 2 with top right edge at (4, 8)
 * Block of size 2 with top right edge at (5, 3)
 * Block of size 2 with top right edge at (6, 2)
 * Block of size 2 with top right edge at (6, 3)
 * Block of size 3 with top right edge at (7, 1)
 * Block of size 2 with top right edge at (7, 2)
 * Block of size 2 with top right edge at (7, 8)
 * Block of size 2 with top right edge at (8, 1)
 * Winner: (0, 0) with a size of 2
 *
 * The unprocessed array of 0s and 1s
 * 1 1 0 0 0 0 0 1 1 0
 * 1 1 1 0 1 1 1 0 0 0
 * 1 0 0 1 0 1 0 0 1 0
 * 1 1 1 1 1 0 0 0 1 1
 * 1 1 1 1 1 0 0 1 1 1
 * 1 1 1 1 1 0 1 1 1 0
 * 0 1 1 1 0 1 0 0 0 1
 * 1 1 1 1 0 1 0 1 1 0
 * 1 1 1 0 1 0 0 1 1 1
 * 1 1 0 1 1 1 0 0 1 0
 *
 * The transformed array
 * 1 2 0 0 0 0 0 1 2 0
 * 1 2 3 0 1 2 3 0 0 0
 * 1 0 0 1 0 1 0 0 1 0
 * 1 2 3 4 5 0 0 0 1 2
 * 1 2 3 4 5 0 0 1 2 3
 * 1 2 3 4 5 0 1 2 3 0
 * 0 1 2 3 0 1 0 0 0 1
 * 1 2 3 4 0 1 0 1 2 0
 * 1 2 3 0 1 0 0 1 2 3
 * 1 2 0 1 2 3 0 0 1 0
 *
 * Finding the largest block in the matrix
 * Block of size 2 with top right edge at (0, 1)
 * Block of size 3 with top right edge at (3, 1)
 * Block of size 4 with top right edge at (3, 2)
 * Block of size 3 with top right edge at (3, 3)
 * Block of size 3 with top right edge at (3, 4)
 * Block of size 2 with top right edge at (3, 9)
 * Block of size 2 with top right edge at (4, 1)
 * Block of size 2 with top right edge at (4, 2)
 * Block of size 3 with top right edge at (4, 3)
 * Block of size 2 with top right edge at (4, 4)
 * Block of size 2 with top right edge at (4, 8)
 * Block of size 2 with top right edge at (5, 2)
 * Block of size 3 with top right edge at (5, 3)
 * Block of size 2 with top right edge at (6, 2)
 * Block of size 2 with top right edge at (6, 3)
 * Block of size 3 with top right edge at (7, 1)
 * Block of size 2 with top right edge at (7, 2)
 * Block of size 2 with top right edge at (7, 8)
 * Block of size 2 with top right edge at (8, 1)
 * Winner: (3, 1) with a size of 3
 *
 * The unprocessed array of 0s and 1s
 * 1 1 0 0 0 0 0 1 1 0
 * 1 1 1 0 1 1 1 0 0 0
 * 1 0 0 1 0 1 0 0 1 0
 * 1 1 1 1 1 0 0 0 1 1
 * 1 1 1 1 1 0 0 1 1 1
 * 1 1 1 1 1 0 1 1 1 0
 * 0 1 1 1 1 1 0 0 0 1
 * 1 1 1 1 0 1 0 1 1 0
 * 1 1 1 0 1 0 0 1 1 1
 * 1 1 0 1 1 1 0 0 1 0
 *
 * The transformed array
 * 1 2 0 0 0 0 0 1 2 0
 * 1 2 3 0 1 2 3 0 0 0
 * 1 0 0 1 0 1 0 0 1 0
 * 1 2 3 4 5 0 0 0 1 2
 * 1 2 3 4 5 0 0 1 2 3
 * 1 2 3 4 5 0 1 2 3 0
 * 0 1 2 3 4 5 0 0 0 1
 * 1 2 3 4 0 1 0 1 2 0
 * 1 2 3 0 1 0 0 1 2 3
 * 1 2 0 1 2 3 0 0 1 0
 *
 * Finding the largest block in the matrix
 * Block of size 2 with top right edge at (0, 1)
 * Block of size 3 with top right edge at (3, 1)
 * Block of size 4 with top right edge at (3, 2)
 * Block of size 3 with top right edge at (3, 3)
 * Block of size 4 with top right edge at (3, 4)
 * Block of size 2 with top right edge at (3, 9)
 * Block of size 2 with top right edge at (4, 1)
 * Block of size 2 with top right edge at (4, 2)
 * Block of size 3 with top right edge at (4, 3)
 * Block of size 3 with top right edge at (4, 4)
 * Block of size 2 with top right edge at (4, 8)
 * Block of size 2 with top right edge at (5, 2)
 * Block of size 3 with top right edge at (5, 3)
 * Block of size 2 with top right edge at (5, 4)
 * Block of size 2 with top right edge at (6, 2)
 * Block of size 2 with top right edge at (6, 3)
 * Block of size 3 with top right edge at (7, 1)
 * Block of size 2 with top right edge at (7, 2)
 * Block of size 2 with top right edge at (7, 8)
 * Block of size 2 with top right edge at (8, 1)
 * Winner: (3, 1) with a size of 4
 *
 * @author martinfall
 */
public class LargestBlock extends Application {

    // Data fields
    private Matrix matrixPane = new Matrix();

    // Row and column address of the largest block and its size
    private int largestSize = 0;
    private int startRow = -1;
    private int startColumn = -1;

    // Square backgrounds
    // For 1 values
    private final BackgroundFill LIGHTBLUE = new BackgroundFill(
            Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY);
    private Background ONES = new Background(LIGHTBLUE);

    // For 0 values
    private final BackgroundFill WHITE = new BackgroundFill(
            Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
    private final Background ZEROS = new Background(WHITE);

    // Background fill ref var for largest block
    private final BackgroundFill GOLD = new BackgroundFill(
            Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY);
    private final Background LARGEST = new Background(GOLD);

    @Override // Override the start method in the Application abstract class
    public void start(Stage stage) throws Exception {
        // Create the buttons needed to refresh and find a solution
        Button btRefresh = new Button("Refresh");
        Button btFind = new Button("Find Largest Block");

        // Create the pane for user input
        HBox paneForInput = new HBox();
        paneForInput.getChildren().addAll(btRefresh, btFind);
        paneForInput.setAlignment(Pos.CENTER);
        paneForInput.setSpacing(5);
        paneForInput.setPadding(new Insets(10, 0, 0, 0));

        // Create a new border pane for the matrix and buttons
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));
        pane.setCenter(matrixPane);
        pane.setBottom(paneForInput);

        // Create a new Scene and add it to the stage
        Scene scene = new Scene(pane);
        stage.setTitle("Largest Block Animation"); // Set the stage title
        stage.setScene(scene); // Specify the scene to be used on this stage
        stage.show(); // Set the visibility of stage to true to display window
        stage.setResizable(true); // The stage is not resizable by the user

        // Event handlers for the Refresh and Find Largest Block buttons
        btRefresh.setOnAction(e -> {

            matrixPane = new Matrix();
            pane.setCenter(matrixPane);

            // Reset the data fields for largest block size and row, column
            largestSize = 0;
            startRow = -1;
            startColumn = -1;
        });

        btFind.setOnAction(e -> {

            // Reset the data fields for largest block size and row, column
            largestSize = 0;
            startRow = -1;
            startColumn = -1;

            // Call the findLargestBlock method
            matrixPane.findLargestBlock();
            matrixPane.paintLargestBlock(startRow, startColumn, largestSize);
        });
    }

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Represents a 10-by-10 square matrix.
     */
    class Matrix extends GridPane {

        int[][] matrix = new int[10][10];

        /**
         * Constructs a square matrix of size 10-by-10.
         */
        public Matrix() {
            for (int rowIndex = 0; rowIndex < 10; rowIndex++) {
                for (int columnIndex = 0; columnIndex < 10; columnIndex++) {
                    Square square = new Square(rowIndex, columnIndex);
                    add(square, columnIndex, rowIndex);
                }
            }

            // Set the value of the property gridLinesVisible to true or false
            setGridLinesVisible(false);

            // Set the value of the hgap and vgap properties
            setHgap(5);
            setVgap(5);
        }

        /**
         * Display the matrix to the console.
         */
        private void printMatrix() {
            for (int[] i : matrix) {
                for (int j : i) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }

        /**
         * Returns an primitive data type array of integer values representing
         * the GUI matrix.
         *
         * @return
         */
        private void fillArray() {
            // Local variables
            matrix = new int[10][10];
            int row = 0;
            int column = 0;

            // Fill the int array matrix with the contents of the grip pane
            Iterator<Node> iterator = matrixPane.getChildren().iterator();
            while (iterator.hasNext() && row < 10 && column < 10) {
                // Current square
                Square square = (Square) iterator.next();

                // Update the matrix
                matrix[row][column] = Integer.parseInt(square.getText());

                // Increment the column
                column++;

                // If at the end of a row, move to the next row and reset the column
                if (column == 10) {
                    row++;
                    column = 0;
                }
            }
        }

        /**
         * Update the array to reflect the number of sequential 1 values at each
         * position of each row.
         */
        private void transformArray() {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 1; j < matrix[i].length; j++) {
                    if (matrix[i][j] > 0 && matrix[i][j - 1] > 0) {
                        matrix[i][j] = matrix[i][j - 1] + 1;
                    }
                }
            }
        }

        /**
         * Returns the largest block.
         */
        private void findLargestBlock() {

            // Step 1: Fill the matrix array of int values with the contents of the grid pane
            fillArray();
            System.out.println("\nThe unprocessed array of 0s and 1s");
            printMatrix(); // Display the console

            // Step 2: repopulate the array by updating 1s to their consecutive 
            // count value, such that a row 0 0 1 1 1 0 0 1 1 0 become the new 
            // row 0 0 1 2 3 0 0 1 2 0.
            // We start at column 1, because a 1 at column 0 will always be 1.
            transformArray();
            System.out.println("\nThe transformed array");
            printMatrix(); // Display the console

            // Step 3: Look at each non-zero value n of the transformed matrix
            System.out.println("\nFinding the largest block in the matrix");
            for (int row = 0; row < matrix.length; row++) {
                for (int column = 0; column < matrix[row].length; column++) {
                    // If the value at the curr pos is larger than 1
                    if (matrix[row][column] >= 2) {
                        // Determine the biggest block at the current pos
                        check(row, column);
                    }
                }
            }

            // Step 4: Paint the largest block on the pane
            System.out.printf("Winner: (%d, %d) with a size of %d%n",
                    startRow, startColumn, largestSize);
        }

        private int check(int row, int column) {
            // Initialize a counter variable to 0
            int count = 0;

            // Memorize the row and column
            int i = row;
            int j = column;

            // Initialize an array list of sequential values in the same column
            ArrayList<Integer> array = new ArrayList<>();

            // Count the number of values >= 2 (possible blocks) in the same column
            while (row < matrix.length && matrix[row][column] >= 2) {
                // Add the current value to the array
                array.add(matrix[row][column]);

                count++; // Increment the counter
                row++; // Look in the next row
            }

            // Display the contents of the array to the console
            // System.out.println("array=" + array);
            /**
             * Find the largest block possible in the shape described by the
             * array The shape is a right justified stack of rectangles whose
             * length is determined by the number of sequential nonzero values
             */
            // Boolean flag to break out of the while loop if count >= 2
            boolean flag = true;

            // Consider all possible blocks starting at 2 x 2
            int size = 2; // Starting size incremented until it fails a check

            // Find the largest block at the current position
            if (count >= 2) {
                // Largest number in the array
                int max = Collections.max(array);

                while (flag && size <= max) { // && count < max???
                    // Check each array member and throw the flag if no block at size
                    // for (int k = 0; k < size && k < array.size(); k++) {
                    for (int k = 0; k < size; k++) {
                        if (!(size <= array.get(k))) {
                            flag = false;
                            size--;
                            break;
                        }
                    }

                    // Adjust size to reflect the current conditions
                    // if (flag == true && size < array.size()) {
                    if (flag == true && size + 1 <= array.size()) {
                        size++; // Increment size if the previous size exists
                    } else { // Otherwise
                        // size--; // Decrement size and break out of the loop

                        // Update the data fields size, startRow, and endRow
                        if (size > largestSize) {
                            largestSize = size;
                            startRow = i;
                            startColumn = j - largestSize + 1;
                        }

                        break;
                    }
                    // System.out.println("Current size is " + size);
                }

                System.out.printf("Block of size %d with top right edge at (%d, %d)%n", size, i, j);
                clearLargestBlock(); // Clear any previous markings

            }

            return size;
        }

        /**
         * Clears the previous marking of a largest block from the pane if it
         * exists.
         */
        private void clearLargestBlock() {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    clearSquare(i, j);
                }
            }
        }

        /**
         * Clear a single square by resetting its background to default.
         *
         * @param row
         * @param column
         */
        private void clearSquare(int row, int column) {
            for (Node node : getChildren()) {
                if (((Square) node).row == row
                        && ((Square) node).column == column) {
                    Square square = (Square) node;
                    if (square.getText().equals("1")) {
                        square.setBackground(ONES);
                    } else {
                        square.setBackground(ZEROS);
                    }
                }
            }
        }

        /**
         * Paint the largest block on the pane with the provided row, column,
         * and size.
         *
         * @param row
         * @param column
         * @param size
         */
        private void paintLargestBlock(int row, int column, int size) {
            for (int i = row; i < row + size; i++) {
                for (int j = column; j < column + size; j++) {
                    paintSquare(i, j);
                }
            }
        }

        /**
         * Paints a single square at the given row and column of the pane.
         *
         * @param row
         * @param column
         */
        private void paintSquare(int row, int column) {
            for (Node node : getChildren()) {
                if (((Square) node).row == row
                        && ((Square) node).column == column) {
                    ((Square) node).setBackground(LARGEST);
                }
            }
        }
    }

    /**
     * Square of a matrix pane.
     */
    class Square extends TextField {

        // Class constants to override the preferred width and height properties
        private static final double PREF_WIDTH = 30;
        private static final double PREF_HEIGHT = 30;

        // Square row and column address
        int row;
        int column;

        // Each element is a randomly generated value of 0 or 1 in the constructor
        // private int element;
        /**
         * No-args class constructor.
         */
        public Square(int row, int column) {
            this.row = row;
            this.column = column;

            setText((int) (Math.random() * 2) + "");
            setAlignment(Pos.CENTER);
            setPrefSize(PREF_WIDTH, PREF_HEIGHT);

            // Initial paint with appropriate background
            if (getText().equals("1")) {
                setBackground(ONES);
            } else {
                setBackground(ZEROS);
            }

            // Add a listener to the text property to fill the background
            textProperty().addListener(observable -> {
                if (textProperty().getValue().equals("1")) {
                    setBackground(ONES);
                } else {
                    setBackground(ZEROS);
                }
            });
        }
    }
}
