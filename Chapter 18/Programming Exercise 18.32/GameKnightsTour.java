
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * (Game: Knight’s Tour) The Knight’s Tour is an ancient puzzle. The objective
 * is to move a knight, starting from any square on a chessboard, to every other
 * square once, as shown in Figure 18.15a. Note that the knight makes only
 * L-shaped moves (two spaces in one direction and one space in a perpendicular
 * direction). As shown in Figure 18.15b, the knight can move to eight squares.
 * Write a program that displays the moves for the knight, as shown in Figure
 * 18.15c. When you click a cell, the knight is placed at the cell. This cell
 * will be starting point for the knight. Clicking the Solve button to display
 * the path for a solution.
 *
 * (Hint: A brute-force approach for this problem is to move the knight from one
 * square to another available square arbitrarily. Using such an approach, your
 * program will take a long time to finish. A better approach is to employ some
 * heuristics. A knight has two, three, four, six, or eight possible moves,
 * depending on its location. Intuitively, you should attempt to move the knight
 * to the least accessible squares first and leave those more accessible squares
 * open, so there will be a better chance of success at the end of the search.)
 *
 * Assumptions:
 * 1. The user will always select a starting square before clicking the Solve
 * button
 * 2. The user will restart the program to solve a new knight's tour problem
 * with a different starting square
 *
 * Sample output:
 * Solved!
 * Square{row=4, column=1}
 * Square{row=6, column=0}
 * Square{row=7, column=2}
 * Square{row=6, column=4}
 * Square{row=7, column=6}
 * Square{row=5, column=7}
 * Square{row=6, column=5}
 * Square{row=7, column=7}
 * Square{row=5, column=6}
 * Square{row=7, column=5}
 * Square{row=6, column=7}
 * Square{row=4, column=6}
 * Square{row=2, column=7}
 * Square{row=0, column=6}
 * Square{row=1, column=4}
 * Square{row=0, column=2}
 * Square{row=1, column=0}
 * Square{row=2, column=2}
 * Square{row=0, column=1}
 * Square{row=2, column=0}
 * Square{row=1, column=2}
 * Square{row=0, column=0}
 * Square{row=2, column=1}
 * Square{row=4, column=0}
 * Square{row=6, column=1}
 * Square{row=7, column=3}
 * Square{row=5, column=2}
 * Square{row=7, column=1}
 * Square{row=5, column=0}
 * Square{row=3, column=1}
 * Square{row=4, column=3}
 * Square{row=6, column=2}
 * Square{row=7, column=0}
 * Square{row=5, column=1}
 * Square{row=3, column=0}
 * Square{row=1, column=1}
 * Square{row=0, column=3}
 * Square{row=1, column=5}
 * Square{row=0, column=7}
 * Square{row=2, column=6}
 * Square{row=4, column=7}
 * Square{row=3, column=5}
 * Square{row=1, column=6}
 * Square{row=0, column=4}
 * Square{row=2, column=3}
 * Square{row=4, column=2}
 * Square{row=5, column=4}
 * Square{row=6, column=6}
 * Square{row=7, column=4}
 * Square{row=5, column=5}
 * Square{row=6, column=3}
 * Square{row=4, column=4}
 * Square{row=3, column=6}
 * Square{row=1, column=7}
 * Square{row=0, column=5}
 * Square{row=2, column=4}
 * Square{row=3, column=2}
 * Square{row=1, column=3}
 * Square{row=3, column=4}
 * Square{row=5, column=3}
 * Square{row=4, column=5}
 * Square{row=3, column=3}
 * Square{row=2, column=5}
 * Square{row=3, column=7}
 *
 * @author martinfall
 */
public class GameKnightsTour extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {

        // Create a new chessboard and add it to a stack pane
        Chessboard chessboard = new Chessboard();
        StackPane chessboardPane = new StackPane(chessboard);

        // Create the solve button
        Button btSolve = new Button("Solve");

        // Create a border pane for the chessboard and the solve button
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));
        pane.setCenter(chessboardPane);
        pane.setBottom(btSolve);
        BorderPane.setAlignment(btSolve, Pos.CENTER);
        BorderPane.setMargin(btSolve, new Insets(5));

        // Event handler for the solve button
        btSolve.setOnAction(e -> {
            chessboard.tour();
            Polyline path = new Polyline();
            ObservableList<Double> points = path.getPoints();
            points.addAll(chessboard.paint());

            chessboardPane.getChildren().add(path);
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Game - Knight's Tour"); // Set the stage title
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
        Application.launch(args);
    }

    /**
     * Represents a square on the chessboard.
     */
    public class Square extends Pane {

        // Private instance data field members
        private int row;
        private int column;
        private static final int SIDE = 50;
        private boolean visited = false; // Initial value is false

        // private final Color N = Color.WHITE;
        // private final Color V = Color.LIGHTCYAN;
        private Rectangle square = new Rectangle();
        private ImageView ivKnight = new ImageView("chess-knight.png");

        /**
         * Creates a square with row and column parameters.
         *
         * @param row
         * @param column
         */
        public Square(int row, int column) {
            // Set the row and column
            this.row = row;
            this.column = column;

            // Construct the square with side, stroke, and fill properties
            square.setWidth(SIDE);
            square.setHeight(SIDE);

            // Customize the knight icon
            ivKnight.setFitWidth(SIDE - 10);
            ivKnight.setFitHeight(SIDE - 10);
            ivKnight.setPreserveRatio(true);
            ivKnight.setX(5);
            ivKnight.setY(5);

            getChildren().add(square); // Add the square to pane

            // Event handler for placing a knight on the chessboard
            setOnMouseClicked(e -> {
                if (!visited) {
                    setVisited(true);
                    getChildren().add(ivKnight);
                } else {
                    setVisited(false);
                    getChildren().remove(ivKnight);
                }
            });
        }

        /**
         * Returns the square's row and column as int array.
         *
         * @return
         */
        public int[] getRowColumn() {
            return new int[]{row, column};
        }

        /**
         * Sets a square column and row from the passed parameters.
         *
         * @param row
         * @param column
         */
        public void setRowColumn(int row, int column) {
            this.row = row;
            this.column = column;
        }

        /**
         * Returns true if the square is visited and false otherwise.
         *
         * @return
         */
        public boolean isVisited() {
            return visited;
        }

        /**
         * Sets the value of visited to the passed parameter.
         *
         * @param visited
         */
        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        @Override
        public String toString() {
            return "Square{" + "row=" + row + ", column=" + column + '}';
        }
    }

    /**
     * Represents a conventional 8 x 8 chessboard.
     */
    public class Chessboard extends GridPane {

        // List of moves
        ArrayList<Square> list = new ArrayList<>();

        // Local instance data fields
        private final Color DARK_SQUARE = Color.rgb(209, 139, 70);
        private final Color LIGHT_SQUARE = Color.rgb(254, 206, 158);

        // Private instance data field members
        /**
         * Changing the number to a large SIZE value or an odd SIZE value throws
         * a GlassHelper error: classNameStrs == NULL.
         */
        private static final int SIZE = 8; // Even numbers only for some reason
        
        private Square[][] chessboard = new Square[SIZE][SIZE];
        private int counter = 0; // counter of moves to help establish base case

        /**
         * No-args constructors constructs a SIZE x SIZE chessboard.
         */
        public Chessboard() {
            boolean checker = true;
            for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
                for (int columnIndex = 0; columnIndex < SIZE; columnIndex++) {
                    Square currentSquare = new Square(rowIndex, columnIndex);
                    if (checker) {
                        currentSquare.square.setFill(LIGHT_SQUARE);
                        checker = !checker;
                    } else {
                        currentSquare.square.setFill(DARK_SQUARE);
                        checker = !checker;
                    }
                    // Add the square to the chessboard int array
                    chessboard[rowIndex][columnIndex]
                            = currentSquare;
                    // Add the square to the GUI
                    add(chessboard[rowIndex][columnIndex],
                            columnIndex, rowIndex);

                }
                if (SIZE % 2 == 0) {
                    checker = !checker;
                }
            }
        }

        /**
         * Returns the square at rowIndex, columnIndex.
         *
         * @param rowIndex
         * @param columnIndex
         * @return
         */
        public Square getSquare(int rowIndex, int columnIndex) {
            Square square = null;

            for (Node node : getChildren()) {
                if (GridPane.getRowIndex(node) == rowIndex
                        && GridPane.getColumnIndex(node) == columnIndex) {
                    square = ((Square) node);
                }
            }
            return square;
        }

        /**
         * Returns an array of possible moves from the selected square.
         *
         * @param square
         * @return
         */
        public int[][] getMoves(Square square) {
            // Create a new two-dimensional int array
            int[][] moves = new int[8][3];

            // Convenience local variables
            int rowIndex = square.getRowColumn()[0];
            int columnIndex = square.getRowColumn()[1];

            // Possible moves in clockwise order with the origin in the center
            moves[0][0] = rowIndex - 2;
            moves[0][1] = columnIndex + 1;

            moves[1][0] = rowIndex - 1;
            moves[1][1] = columnIndex + 2;

            moves[2][0] = rowIndex + 1;
            moves[2][1] = columnIndex + 2;

            moves[3][0] = rowIndex + 2;
            moves[3][1] = columnIndex + 1;

            moves[4][0] = rowIndex + 2;
            moves[4][1] = columnIndex - 1;

            moves[5][0] = rowIndex + 1;
            moves[5][1] = columnIndex - 2;

            moves[6][0] = rowIndex - 1;
            moves[6][1] = columnIndex - 2;

            moves[7][0] = rowIndex - 2;
            moves[7][1] = columnIndex - 1;

            // Populate the last element in row, column, moves array with the
            // number of possible moves from a valid current move.
            for (int i = 0; i < moves.length; i++) {
                if (isValid(moves[i][0], moves[i][1])) {
                    moves[i][2] = lookAhead(moves[i][0], moves[i][1]);
                } else {
                    moves[i][2] = -1;
                }
            }

            // Sort the array by ascending order of fewest onward moves
            // System.out.println(Arrays.deepToString(moves));
            sort(moves);
            // System.out.println(Arrays.deepToString(moves));

            // Return the sorted moves array
            return moves;
        }

        /**
         * Returns true is the square is valid, as defined as within legal
         * bounds and not visited.
         *
         * @param square
         * @return
         */
        public boolean isValid(Square square) {
            // Convenience local variables
            int rowIndex = square.getRowColumn()[0];
            int columnIndex = square.getRowColumn()[1];

            return isValid(rowIndex, columnIndex);
        }

        /**
         * Returns true if the square at row and column arguments is valid.
         * Validity is determined by bounds for row and column pairs, as well as
         * visited status.
         *
         * @param rowIndex
         * @param columnIndex
         * @return
         */
        public boolean isValid(int rowIndex, int columnIndex) {
            // Check if row is out of bounds
            if (rowIndex < 0 || rowIndex >= SIZE) {
                return false;
            }

            // Check if column is out of bounds
            if (columnIndex < 0 || columnIndex >= SIZE) {
                return false;
            }

            // Check if the square is visited
            if (getSquare(rowIndex, columnIndex).isVisited()) {
                return false;
            }

            // Return true if no false conditions occur
            return true;
        }

        /**
         * Returns the starting square in the chessboard.
         *
         * @return
         */
        public Square getStartingSquare() {
            // Create a reference var for the starting square
            Square start = null;

            for (Square[] rowOfSquares : chessboard) {
                for (Square square : rowOfSquares) {
                    if (square.isVisited()) {
                        start = square;
                        break;
                    }
                }
            }

            // Clear the list of moves and add the starting square
            list.clear();
            list.add(start);

            return start;
        }

        /**
         * Recursive method that returns an two-dimensional array of row, column
         * pairs that represents the knight's tour on the chessboard.
         *
         * @return
         */
        public boolean tour() {
            // Create an int array for row, column pairs
            int[][] moves = new int[8][3];

            // Obtain starting square and fill moves array with possible moves
            Square start = getStartingSquare();
            if (start != null) {
                moves = getMoves(start);
            }

            // Return a boolean value from a call to auxiliary recursive method
            return tour(moves); // Call auxiliary method
        }

        /**
         * Recursive helper method with auxiliary parameter moves.
         *
         * @param moves
         * @return
         */
        public boolean tour(int[][] moves) {
            // SIZE * SIZE squares arranged in SIZE rows and SIZE columns
            if (counter == (SIZE * SIZE) - 1) { // Base case
                System.out.println("Solved!");

                // Display the moves to the console
                for (Square s : list) {
                    System.out.println(s.toString());
                }

                return true;
            } else {
                // System.out.println(counter);
                for (int[] move : moves) {
                    int rowIndex = move[0];
                    int columnIndex = move[1];
                    int numberOfMoves = move[2];

                    if (isValid(rowIndex, columnIndex) && numberOfMoves >= 0) {
                        markVisited(rowIndex, columnIndex);
                        counter++;
                        list.add(new Square(rowIndex, columnIndex));

                        if (tour(getMoves(new Square(rowIndex, columnIndex)))) {
                            return true;
                        } else {
                            markUnvisited(rowIndex, columnIndex);
                            counter--;
                            list.remove(new Square(rowIndex, columnIndex));
                        }
                    }
                }
            }
            return false;
        }

        /**
         * Marks a square as visited.
         *
         * @param rowIndex
         * @param columnIndex
         */
        public void markVisited(int rowIndex, int columnIndex) {
            Square square = getSquare(rowIndex, columnIndex);
            square.setVisited(true);
        }

        /**
         * Marks a square as not visited.
         *
         * @param rowIndex
         * @param columnIndex
         */
        public void markUnvisited(int rowIndex, int columnIndex) {
            Square square = getSquare(rowIndex, columnIndex);
            square.setVisited(false);
        }

        /**
         * Warnsdorff's rule is a heuristic for finding a single knight's tour.
         * The knight is moved so that it always proceeds to the square from
         * which the knight will have the fewest onward moves. When calculating
         * the number of onward moves for each candidate square, we do not count
         * moves that revisit any square already visited. It is possible to have
         * two or more choices for which the number of onward moves is equal;
         * there are various methods for breaking such ties, including one
         * devised by Pohl[18] and another by Squirrel and Cull.[19]
         *
         * Wikipedia: https://en.wikipedia.org/wiki/Knight%27s_tour
         *
         * @param rowIndex
         * @param columnIndex
         * @return
         */
        public int lookAhead(int rowIndex, int columnIndex) {
            int[][] moves = new int[8][2];

            moves[0][0] = rowIndex - 2;
            moves[0][1] = columnIndex + 1;

            moves[1][0] = rowIndex - 1;
            moves[1][1] = columnIndex + 2;

            moves[2][0] = rowIndex + 1;
            moves[2][1] = columnIndex + 2;

            moves[3][0] = rowIndex + 2;
            moves[3][1] = columnIndex + 1;

            moves[4][0] = rowIndex + 2;
            moves[4][1] = columnIndex - 1;

            moves[5][0] = rowIndex + 1;
            moves[5][1] = columnIndex - 2;

            moves[6][0] = rowIndex - 1;
            moves[6][1] = columnIndex - 2;

            moves[7][0] = rowIndex - 2;
            moves[7][1] = columnIndex - 1;

            int validMoves = 0;

            for (int[] move : moves) {
                if (isValid(move[0], move[1])) {
                    validMoves++;
                }
            }

            return validMoves;
        }

        /**
         * Sort the array by ascending order of fewest onward moves using a
         * selection sort algorithm.
         *
         * @param moves
         */
        public void sort(int[][] moves) {
            for (int i = 0; i < moves.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < moves.length; j++) {
                    if (moves[j][2] < moves[minIndex][2]) {
                        minIndex = j;
                    }
                }
                int[] temp = moves[minIndex];
                moves[minIndex] = moves[i];
                moves[i] = temp;
            }
        }

        /**
         * Create a polyline as a collection of points extracted from the list
         * of moves.
         *
         * @return
         */
        public ObservableList<Double> paint() {
            // Create a new path pane
            Pane pane = new Pane();
            pane.setMinSize(Square.SIDE * SIZE, Square.SIDE * SIZE);

            // Create a new polyline
            Polyline tour = new Polyline();

            // Create a new observable list to populate from the list of moves
            ObservableList<Double> points = tour.getPoints();

            // For each square in the list of moves
            for (Square square : list) {
                // Determine x and y
                double x = (square.column * Square.SIDE) + (Square.SIDE / 2);
                double y = (square.row * Square.SIDE) + (Square.SIDE / 2);

                // Add x and y to the observable list of points
                points.addAll(x, y);
            }

            return points;
        }
    }
}
