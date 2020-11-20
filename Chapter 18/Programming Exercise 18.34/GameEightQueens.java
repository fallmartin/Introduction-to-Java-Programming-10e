
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * (Game: Eight Queens) The Eight Queens problem is to find a solution to place
 * a queen in each row on a chessboard such that no two queens can attack each
 * other. Write a program to solve the Eight Queens problem using recursion and
 * display the result as shown in Figure 18.17.
 *
 * One way to solve this puzzle is to drop a queen randomly on the first row,
 * then solve recursively.
 *
 * Heuristic: This is a heuristic search solution to the eight queens puzzle.
 * The program first places one queen on each row on a random column. Then it
 * repeatedly moves the queen with the most conflicts to another column with the
 * least possible conflicts. After moving a number of queens around without
 * finding a solution, the program will restart from a random placement.
 * http://www.quitebasic.com/prj/puzzle/eight-queens-heuristic/
 *
 * The Wikipedia article on the Eight Queens puzzle offers many other possible
 * methods for solving this problem.
 * https://en.wikipedia.org/wiki/Eight_queens_puzzle
 *
 * @author martinfall
 */
public class GameEightQueens extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create a new chessboard and add it to a stack pane
        Chessboard chessboard = new Chessboard();

        // Create a scene and place it in the stage
        Scene scene = new Scene(chessboard);
        primaryStage.setTitle("Game - Eight Queens"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizable
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args); // Launch the Application
    }

    /**
     * Represents a square on the chessboard. A square has a row and a column,
     * and can contain a queen.
     */
    public static class Square extends Pane {

        // Private instance data field members
        private int row; // The square's row on the board
        private int column; // The square's column on the board
        private static final int SIDE = 50; // The side in pixels of each square
        private final Rectangle square = new Rectangle(); // GUI rectangle
        private final ImageView ivQueen = new ImageView("chess-queen.png");
        private boolean occupied = false; // Boolean flag for queen in square

        /**
         * Constructs a square with row and column parameters.
         *
         * @param row
         * @param column
         */
        public Square(int row, int column) {
            // Set the row and column of square interally
            this.row = row;
            this.column = column;

            // Construct the square with side, stroke, and fill properties
            square.setWidth(SIDE);
            square.setHeight(SIDE);

            // Customize the knight icon
            ivQueen.setFitWidth(SIDE - 10);
            ivQueen.setFitHeight(SIDE - 10);
            ivQueen.setPreserveRatio(true);
            ivQueen.setX(5);
            ivQueen.setY(5);

            getChildren().addAll(square); // Add the square to pane
        }

        /**
         * Returns the square's row and column as an int array [row, column].
         *
         * @return
         */
        public int[] getRowColumn() {
            return new int[]{row, column};
        }

        /**
         * Sets the row and column of the square to the passed parameters.
         *
         * @param row
         * @param column
         */
        public void setRowColumn(int row, int column) {
            this.row = row;
            this.column = column;
        }

        /**
         * Returns occupied if the square contains a queen piece.
         *
         * @return
         */
        public boolean isOccupied() {
            return occupied;
        }

        /**
         * Sets a queen piece on the calling square object.
         *
         */
        public void placeQueen() {
            getChildren().add(ivQueen);
            this.occupied = true;
        }

        /**
         * Removes a queen piece on the calling square object.
         *
         */
        public void removeQueen() {
            getChildren().remove(ivQueen);
            this.occupied = false;
        }

        @Override // Override the toString method of the Object class
        public String toString() {
            return "Queen @ (" + row + ", " + column + ")";
        }
    }

    /**
     * Represents a conventional 8 x 8 chessboard.
     */
    public static class Chessboard extends GridPane {

        // Local instance data fields
        private final int SIZE = 8; // Chessboard size is 8 x 8
        private int counter; // Counts successfully placed queens

        private final Color DARK_SQUARE = Color.rgb(209, 139, 70);
        private final Color LIGHT_SQUARE = Color.rgb(254, 206, 158);
        private boolean[][] chessboard; // Board
        private Square[][] chessboardGUI = new Square[SIZE][SIZE]; // Board GUI

        /**
         * No-args constructors constructs a SIZE x SIZE chessboard.
         */
        public Chessboard() {
            // Initialize the counter and the chessboard in the constructor
            this.counter = 0;
            this.chessboard = new boolean[SIZE][SIZE];

            // Drop a random first queen on the first row
            int randomColumn = (int) (Math.random() * SIZE);
            chessboard[0][randomColumn] = true;
            counter++;

            // Solve the puzzle and paint it to GUI
            solve();
            paint();

            // Optionally, show the results on the console
            /*for (boolean[] line : chessboard) {
            for (boolean square : line) {
            System.out.print((square ? "X" : "-") + " ");
            }
            System.out.println();
            }*/
        }

        /**
         * Solves the Eight Queens puzzle recursively.
         *
         * @return
         */
        private boolean solve() {
            if (counter == SIZE) { // Base case
                return true;
            } else {
                // Loop through each square on the board
                for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
                    for (int columnIndex = 0; columnIndex < SIZE; columnIndex++) {
                        // If valid, set true and increment counter
                        if (isValid(rowIndex, columnIndex)) {
                            chessboard[rowIndex][columnIndex] = true;
                            counter++;

                            // Solve for remaining queens until base case reached
                            if (solve()) {
                                return true;
                            } else {
                                // Otherwise set false and decrement counter
                                chessboard[rowIndex][columnIndex] = false;
                                counter--;
                            }
                        }
                    }
                }
            }
            return false;
        }

        /**
         * Returns true if the placement doesn't cause any conflicts on the
         * chessboard.
         *
         * @param rowIndex
         * @param columnIndex
         * @return
         */
        private boolean isValid(int rowIndex, int columnIndex) {
            // Look for conflicts horizontally on rowIndex
            for (int column = 0; column < SIZE; column++) {
                if (chessboard[rowIndex][column]) {
                    return false;
                }
            }

            // Look for conflicts vertically on columnIndex
            for (int row = 0; row < SIZE; row++) {
                if (chessboard[row][columnIndex]) {
                    return false;
                }
            }

            // Check the falling diagonal from top left to bottom right
            int i = rowIndex;
            int j = columnIndex;
            while (i > 0 && j > 0) {
                i--;
                j--;
            }

            for (; i < SIZE && j < SIZE; i++, j++) {
                // System.out.println(i + ", " + j);
                if (chessboard[i][j]) {
                    return false;
                }
            }

            // Check the rising diagonal from bottom left to top right
            i = rowIndex;
            j = columnIndex;
            while (i < SIZE - 1 && j > 0) {
                i++;
                j--;
            }

            for (; i >= 0 && j < SIZE; i--, j++) {
                if (i == SIZE || j == SIZE) {
                    System.out.println(i + ", " + j);
                }
                if (chessboard[i][j]) {
                    return false;
                }
            }

            return true;
        }

        /**
         * Translate the Boolean array solution to a visual representation.
         */
        private void paint() {
            boolean checker = true;
            for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
                for (int columnIndex = 0; columnIndex < SIZE; columnIndex++) {
                    // Create a new instance of square
                    Square currentSquare = new Square(rowIndex, columnIndex);
                    if (checker) {
                        currentSquare.square.setFill(LIGHT_SQUARE);
                        checker = !checker;
                    } else {
                        currentSquare.square.setFill(DARK_SQUARE);
                        checker = !checker;
                    }

                    // Add the square to the chessboard int array
                    chessboardGUI[rowIndex][columnIndex] = currentSquare;
                    // Place a queen if the value at row, column is true
                    if (chessboard[rowIndex][columnIndex]) {
                        currentSquare.placeQueen();
                    }
                    // Add the square to the GUI
                    add(chessboardGUI[rowIndex][columnIndex], columnIndex, rowIndex);
                }

                // Alternate colors for squares
                if (SIZE % 2 == 0) {
                    checker = !checker;
                }
            }
        }
    }

}
