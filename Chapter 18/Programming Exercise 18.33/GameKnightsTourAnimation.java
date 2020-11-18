
import java.util.ArrayList;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
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
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Game: Knight’s Tour animation) Write a program for the Knight’s Tour
 * problem. Your program should let the user move a knight to any starting
 * square and click the Solve button to animate a knight moving along the path,
 * as shown in Figure 18.16.
 *
 * Console Output Sample:
 * Solved!
 * Square{row=4, column=4}
 * Square{row=3, column=6}
 * Square{row=1, column=7}
 * Square{row=0, column=5}
 * Square{row=1, column=3}
 * Square{row=0, column=1}
 * Square{row=2, column=0}
 * Square{row=3, column=2}
 * Square{row=4, column=0}
 * Square{row=6, column=1}
 * Square{row=7, column=3}
 * Square{row=6, column=5}
 * Square{row=7, column=7}
 * Square{row=5, column=6}
 * Square{row=7, column=5}
 * Square{row=6, column=7}
 * Square{row=4, column=6}
 * Square{row=2, column=7}
 * Square{row=0, column=6}
 * Square{row=2, column=5}
 * Square{row=3, column=7}
 * Square{row=1, column=6}
 * Square{row=0, column=4}
 * Square{row=1, column=2}
 * Square{row=0, column=0}
 * Square{row=2, column=1}
 * Square{row=0, column=2}
 * Square{row=1, column=0}
 * Square{row=3, column=1}
 * Square{row=5, column=0}
 * Square{row=7, column=1}
 * Square{row=5, column=2}
 * Square{row=6, column=0}
 * Square{row=7, column=2}
 * Square{row=6, column=4}
 * Square{row=7, column=6}
 * Square{row=5, column=7}
 * Square{row=4, column=5}
 * Square{row=2, column=4}
 * Square{row=0, column=3}
 * Square{row=1, column=1}
 * Square{row=3, column=0}
 * Square{row=5, column=1}
 * Square{row=7, column=0}
 * Square{row=6, column=2}
 * Square{row=7, column=4}
 * Square{row=6, column=6}
 * Square{row=5, column=4}
 * Square{row=3, column=3}
 * Square{row=4, column=1}
 * Square{row=5, column=3}
 * Square{row=3, column=4}
 * Square{row=4, column=2}
 * Square{row=6, column=3}
 * Square{row=5, column=5}
 * Square{row=4, column=3}
 * Square{row=2, column=2}
 * Square{row=1, column=4}
 * Square{row=2, column=6}
 * Square{row=0, column=7}
 * Square{row=1, column=5}
 * Square{row=2, column=3}
 * Square{row=3, column=5}
 * Square{row=4, column=7}
 * List size: 128
 * 225.0
 * 225.0
 * 325.0
 * 175.0
 * 375.0
 * 75.0
 * 275.0
 * 25.0
 * 175.0
 * 75.0
 * 75.0
 * 25.0
 * 25.0
 * 125.0
 * 125.0
 * 175.0
 * 25.0
 * 225.0
 * 75.0
 * 325.0
 * 175.0
 * 375.0
 * 275.0
 * 325.0
 * 375.0
 * 375.0
 * 325.0
 * 275.0
 * 275.0
 * 375.0
 * 375.0
 * 325.0
 * 325.0
 * 225.0
 * 375.0
 * 125.0
 * 325.0
 * 25.0
 * 275.0
 * 125.0
 * 375.0
 * 175.0
 * 325.0
 * 75.0
 * 225.0
 * 25.0
 * 125.0
 * 75.0
 * 25.0
 * 25.0
 * 75.0
 * 125.0
 * 125.0
 * 25.0
 * 25.0
 * 75.0
 * 75.0
 * 175.0
 * 25.0
 * 275.0
 * 75.0
 * 375.0
 * 125.0
 * 275.0
 * 25.0
 * 325.0
 * 125.0
 * 375.0
 * 225.0
 * 325.0
 * 325.0
 * 375.0
 * 375.0
 * 275.0
 * 275.0
 * 225.0
 * 225.0
 * 125.0
 * 175.0
 * 25.0
 * 75.0
 * 75.0
 * 25.0
 * 175.0
 * 75.0
 * 275.0
 * 25.0
 * 375.0
 * 125.0
 * 325.0
 * 225.0
 * 375.0
 * 325.0
 * 325.0
 * 225.0
 * 275.0
 * 175.0
 * 175.0
 * 75.0
 * 225.0
 * 175.0
 * 275.0
 * 225.0
 * 175.0
 * 125.0
 * 225.0
 * 175.0
 * 325.0
 * 275.0
 * 275.0
 * 175.0
 * 225.0
 * 125.0
 * 125.0
 * 225.0
 * 75.0
 * 325.0
 * 125.0
 * 375.0
 * 25.0
 * 275.0
 * 75.0
 * 175.0
 * 125.0
 * 275.0
 * 175.0
 * 375.0
 * 225.0
 * 0
 * Line[startX=225.0, startY=225.0, endX=325.0, endY=175.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 1
 * Line[startX=325.0, startY=175.0, endX=375.0, endY=75.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 2
 * Line[startX=375.0, startY=75.0, endX=275.0, endY=25.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 3
 * Line[startX=275.0, startY=25.0, endX=175.0, endY=75.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 4
 * Line[startX=175.0, startY=75.0, endX=75.0, endY=25.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 5
 * Line[startX=75.0, startY=25.0, endX=25.0, endY=125.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 6
 * Line[startX=25.0, startY=125.0, endX=125.0, endY=175.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 7
 * Line[startX=125.0, startY=175.0, endX=25.0, endY=225.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 8
 * Line[startX=25.0, startY=225.0, endX=75.0, endY=325.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 9
 * Line[startX=75.0, startY=325.0, endX=175.0, endY=375.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 10
 * Line[startX=175.0, startY=375.0, endX=275.0, endY=325.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 11
 * Line[startX=275.0, startY=325.0, endX=375.0, endY=375.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 12
 * Line[startX=375.0, startY=375.0, endX=325.0, endY=275.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 13
 * Line[startX=325.0, startY=275.0, endX=275.0, endY=375.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 14
 * Line[startX=275.0, startY=375.0, endX=375.0, endY=325.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 15
 * Line[startX=375.0, startY=325.0, endX=325.0, endY=225.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 16
 * Line[startX=325.0, startY=225.0, endX=375.0, endY=125.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 17
 * Line[startX=375.0, startY=125.0, endX=325.0, endY=25.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 18
 * Line[startX=325.0, startY=25.0, endX=275.0, endY=125.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 19
 * Line[startX=275.0, startY=125.0, endX=375.0, endY=175.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 20
 * Line[startX=375.0, startY=175.0, endX=325.0, endY=75.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 21
 * Line[startX=325.0, startY=75.0, endX=225.0, endY=25.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 22
 * Line[startX=225.0, startY=25.0, endX=125.0, endY=75.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 23
 * Line[startX=125.0, startY=75.0, endX=25.0, endY=25.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 24
 * Line[startX=25.0, startY=25.0, endX=75.0, endY=125.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 25
 * Line[startX=75.0, startY=125.0, endX=125.0, endY=25.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 26
 * Line[startX=125.0, startY=25.0, endX=25.0, endY=75.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 27
 * Line[startX=25.0, startY=75.0, endX=75.0, endY=175.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 28
 * Line[startX=75.0, startY=175.0, endX=25.0, endY=275.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 29
 * Line[startX=25.0, startY=275.0, endX=75.0, endY=375.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 30
 * Line[startX=75.0, startY=375.0, endX=125.0, endY=275.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 31
 * Line[startX=125.0, startY=275.0, endX=25.0, endY=325.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 32
 * Line[startX=25.0, startY=325.0, endX=125.0, endY=375.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 33
 * Line[startX=125.0, startY=375.0, endX=225.0, endY=325.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 34
 * Line[startX=225.0, startY=325.0, endX=325.0, endY=375.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 35
 * Line[startX=325.0, startY=375.0, endX=375.0, endY=275.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 36
 * Line[startX=375.0, startY=275.0, endX=275.0, endY=225.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 37
 * Line[startX=275.0, startY=225.0, endX=225.0, endY=125.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 38
 * Line[startX=225.0, startY=125.0, endX=175.0, endY=25.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 39
 * Line[startX=175.0, startY=25.0, endX=75.0, endY=75.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 40
 * Line[startX=75.0, startY=75.0, endX=25.0, endY=175.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 41
 * Line[startX=25.0, startY=175.0, endX=75.0, endY=275.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 42
 * Line[startX=75.0, startY=275.0, endX=25.0, endY=375.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 43
 * Line[startX=25.0, startY=375.0, endX=125.0, endY=325.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 44
 * Line[startX=125.0, startY=325.0, endX=225.0, endY=375.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 45
 * Line[startX=225.0, startY=375.0, endX=325.0, endY=325.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 46
 * Line[startX=325.0, startY=325.0, endX=225.0, endY=275.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 47
 * Line[startX=225.0, startY=275.0, endX=175.0, endY=175.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 48
 * Line[startX=175.0, startY=175.0, endX=75.0, endY=225.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 49
 * Line[startX=75.0, startY=225.0, endX=175.0, endY=275.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 50
 * Line[startX=175.0, startY=275.0, endX=225.0, endY=175.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 51
 * Line[startX=225.0, startY=175.0, endX=125.0, endY=225.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 52
 * Line[startX=125.0, startY=225.0, endX=175.0, endY=325.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 53
 * Line[startX=175.0, startY=325.0, endX=275.0, endY=275.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 54
 * Line[startX=275.0, startY=275.0, endX=175.0, endY=225.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 55
 * Line[startX=175.0, startY=225.0, endX=125.0, endY=125.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 56
 * Line[startX=125.0, startY=125.0, endX=225.0, endY=75.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 57
 * Line[startX=225.0, startY=75.0, endX=325.0, endY=125.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 58
 * Line[startX=325.0, startY=125.0, endX=375.0, endY=25.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 59
 * Line[startX=375.0, startY=25.0, endX=275.0, endY=75.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 60
 * Line[startX=275.0, startY=75.0, endX=175.0, endY=125.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 61
 * Line[startX=175.0, startY=125.0, endX=275.0, endY=175.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 * 62
 * Line[startX=275.0, startY=175.0, endX=375.0, endY=225.0, stroke=0x000000ff,
 * strokeWidth=1.0]
 *
 * @author martinfall
 */
public class GameKnightsTourAnimation extends Application {

    private ImageView ivKnight = new ImageView("chess-knight.png");

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
//            Polyline path = new Polyline();
//            ObservableList<Double> points = path.getPoints();
//            points.addAll(chessboard.paint());
//
//            chessboardPane.getChildren().add(path);
            Pane animationPane = chessboard.animate(chessboard.paint());
            chessboardPane.getChildren().add(animationPane);

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
        // private ImageView ivKnight = new ImageView("chess-knight.png");

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

            // System.out.println("List size: " + list.size());
            // System.out.println("KeyFrames array size: " + ((SIZE * SIZE) - 1));
            return points;
        }

        public Pane animate(ObservableList<Double> list) {
            // Animation duration per keyframe
            Duration drtn = Duration.millis(500);

            // The list size is double the number of squares on the board
            System.out.println("List size: " + list.size());

            // Local index for populating the keyframes array
            int kfsIndex = 0;

            // Convert the observable list to an array of primitive double values
            double[] array = new double[list.size()];
            for (int i = 0;
                    i < list.size();
                    i++) {
                array[i] = list.get(i); // Unboxing not necessary here
            }

            // Display the contents of the array for verification purposes
            for (double d : array) {
                System.out.println(d);
            }

//            ImageView ivKnight = new ImageView("chess-knight.png");
//            ivKnight.setX(array[0] - Square.SIDE / 2);
//            ivKnight.setY(array[1] - Square.SIDE / 2);
            // Create a new pane for the animation and add the knight icon
            Pane pane = new Pane();
            pane.setMinSize(Square.SIDE * SIZE, Square.SIDE * SIZE);
            pane.getChildren().add(ivKnight);

            /**
             * For a 8 x 8 chessboard, the knight makes 63 (8 * 8 - 1) moves
             * from a starting position on the board to complete an "open tour"
             * which does not finish at a position a knight move away from the
             * starting square.
             */
            // Populate the array of kfs
            KeyFrame[] kfs = new KeyFrame[(SIZE * SIZE) - 1];
            double startX = array[0];
            double startY = array[1];
            for (int i = 2; i < array.length; i = i + 2) {
                Line line = new Line(startX, startY, // Start X and Y
                        array[i], array[i + 1]); // End X and Y

                // Current kfsIndex value and line toString to console
                System.out.println(kfsIndex);
                System.out.println(line);

                kfs[kfsIndex] = new KeyFrame(drtn.multiply(kfsIndex), kfsIndex + "",
                        e -> {
                            PathTransition pt = new PathTransition();
                            pt.setDuration(drtn);
                            pt.setPath(line);
                            pt.setNode(ivKnight);
                            pt.setInterpolator(Interpolator.LINEAR);
                            pt.setOrientation(PathTransition.OrientationType.NONE);
                            pt.play();

                            // Add the line to the pane
                            pane.getChildren().add(line);
                        });

                // Update the start X and Y values and increment the kfs index
                startX = array[i];
                startY = array[i + 1];
                kfsIndex++;
            }

            // Timeline declaration and property initialization
            Timeline timeline = new Timeline(kfs);

            timeline.setAutoReverse(false);
            timeline.setCycleCount(1);
            timeline.setRate(1);
            timeline.play();

            return pane;
        }

    }
}
