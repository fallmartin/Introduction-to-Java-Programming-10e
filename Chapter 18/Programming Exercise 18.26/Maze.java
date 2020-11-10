
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * (Create a maze) Write a program that will find a path in a maze, as shown in
 * Figure 18.13a. The maze is represented by an 8 * 8 board. The path must meet
 * the following conditions:
 *
 * ■ The path is between the upper-left corner cell and the lower-right corner
 * cell in the maze.
 *
 * ■ The program enables the user to place or remove a mark on a cell. A path
 * consists of adjacent unmarked cells. Two cells are said to be adjacent if
 * they are horizontal or vertical neighbors, but not if they are diagonal
 * neighbors.
 *
 * ■ The path does not contain cells that form a square. The path in Figure
 * 18.13b, for example, does not meet this condition. (The condition makes a
 * path easy to identify on the board.)
 *
 * @author martinfall
 */
public class Maze extends Application {

    // Data fields
    private static final int BOARD_SIZE = 8;

    /**
     * Individual cell in a 8 * 8 board.
     */
    public class Cell extends StackPane {

        // Data fields
        private static final int SIDE = 50;
        // private boolean path = false;
        private boolean marked = false;

        private Rectangle cell;
        private Line line1;
        private Line line2;

        /**
         * No-args constructor.
         */
        public Cell() {
            // Create a new rectangle with properties
            cell = new Rectangle();
            cell.setWidth(SIDE);
            cell.setHeight(SIDE);
            cell.setFill(Color.WHITE);
            cell.setStroke(Color.BLACK);

            // Add the rectangle to the stack pane
            getChildren().add(cell);

            // Register an event handler to process mouse clicks
            setOnMouseClicked(e -> {
                markCell();
            });
        }

        /**
         * Helper method for the mouse clicked event handler. Marks/unmarks a
         * cell.
         */
        private void markCell() {
            if (marked == false) {
                marked = true; // Update marked

                // Cell marked by a two crossed lines
                line1 = new Line(5, 5, SIDE - 5, SIDE - 5);
                line2 = new Line(5, SIDE - 5, SIDE - 5, 5);

                line1.setStrokeWidth(2);
                line2.setStrokeWidth(2);

                // Change the cell fill
                cell.setFill(Color.YELLOW);

                // Add the lines to the cell
                getChildren().addAll(line1, line2);
            } else {
                marked = false; // Update marked

                // Change the cell fill
                cell.setFill(Color.WHITE);

                // Remove the lines from the pane
                this.getChildren().removeAll(line1, line2);
            }
            // Uncomment the line below to see clicked cell children in console
            // System.out.println(getChildren());
        }
    }

    /**
     * BOARD_SIZE * BOARD_SIZE board filled with cells.
     */
    public class Board extends GridPane {

        // Data fields
        char[][] path = new char[BOARD_SIZE][BOARD_SIZE];
        ArrayList<int[]> list = new ArrayList();

        /**
         * No-args constructor.
         */
        public Board() {
            // Create the board for the game
            for (int rowIndex = 0; rowIndex < BOARD_SIZE; rowIndex++) {
                for (int columnIndex = 0; columnIndex < BOARD_SIZE; columnIndex++) {
                    Cell square = new Cell();
                    add(square, columnIndex, rowIndex);
                }
            }

            // Some UI tweaks
            setPadding(new Insets(10));
        }

        /**
         * Recursive method to find a path.
         *
         * @return
         */
        public boolean findPath() {
            System.out.println("Find path...\n");

            // Start with an empty path and list of moves
            path = new char[BOARD_SIZE][BOARD_SIZE];
            list = new ArrayList();

            processPathArray(); // Process the path array for X marks

            // Possible moves from row 0, column 0 
            int[][] moves = getMoves(0, 0);
            return findPath(moves); // Call auxiliary method
        }

        /**
         * Recursive helper method with auxiliary parameters rowIndex and
         * columnIndex.
         *
         * @param moves
         */
        public boolean findPath(int[][] moves) {
            // Base case
            if (path[BOARD_SIZE - 1][BOARD_SIZE - 1] == 'P') {
                printPathArray();
                System.out.println("Legal path found.\n");

                // Print path to console
                for (int[] move : list) {
                    System.out.print(Arrays.toString(move) + " ");
                }
                System.out.println();
                return true; // Return true to the caller recursive method
            } else {
                // For each possible move
                for (int[] move : moves) {
                    int currentRow = move[0];
                    int currentColumn = move[1];

                    // Check if the move satisfies the program requirements
                    if (isValidCell(currentRow, currentColumn)) {
                        // If yes, set P and add move to list
                        path[currentRow][currentColumn] = 'P';
                        list.add(new int[]{currentRow, currentColumn});

                        if (findPath(getMoves(currentRow, currentColumn))) {
                            // Find path for possible moves at current cell
                            return true;
                        } else {
                            // Unset P placement are remove move from list
                            path[currentRow][currentColumn] = 'O';
                            list.remove(list.size() - 1);
                        }
                    }
                }
            }
            return false;
        }

        /**
         * Clear path path.
         */
        public void clearPath() {
            System.out.println("Clear path...");

            // Start with an empty path and list of moves
            path = new char[BOARD_SIZE][BOARD_SIZE];
            list.clear();

            processPathArray(); // Process the path array for X marks
            path[0][0] = 'O'; // Unset the starting point
        }

        /**
         * Updates the int array representative of the board with 0s as possible
         * avenues to path and 1s as marked cells.
         */
        public void processPathArray() {
            for (int rowIndex = 0; rowIndex < BOARD_SIZE; rowIndex++) {
                for (int columnIndex = 0; columnIndex < BOARD_SIZE; columnIndex++) {

                    // Obtain the cell at rowIndex, columnIndex
                    Cell cell = getCellFromGrid(rowIndex, columnIndex);

                    // update the path array if the cell is marked
                    if (cell.marked == true) {
                        path[rowIndex][columnIndex] = 'X';
                    } else {
                        path[rowIndex][columnIndex] = 'O';
                    }
                }
            }

            // Starting cell value
            path[0][0] = 'P';
        }

        public void paint() {
            for (int rowIndex = 0; rowIndex < BOARD_SIZE; rowIndex++) {
                for (int columnIndex = 0; columnIndex < BOARD_SIZE; columnIndex++) {
                    // Obtain the cell at rowIndex, columnIndex
                    Cell cell = getCellFromGrid(rowIndex, columnIndex);

                    switch (path[rowIndex][columnIndex]) {
                        case 'P' ->
                            cell.cell.setFill(Color.DARKRED);
                        case 'X' ->
                            cell.cell.setFill(Color.YELLOW);
                        default ->
                            cell.cell.setFill(Color.WHITE);
                    }
                }
            }
        }

        /**
         * Updates the int array representative of the board with 0s as possible
         * avenues to path and 1s as marked cells.
         */
        public void printPathArray() {
            for (int rowIndex = 0; rowIndex < BOARD_SIZE; rowIndex++) {
                for (int columnIndex = 0; columnIndex < BOARD_SIZE; columnIndex++) {
                    System.out.print(path[rowIndex][columnIndex] + " ");
                }
                System.out.println();
            }
        }

        /**
         * Returns the cell at rowIndex, columnIndex.
         *
         * @param rowIndex
         * @param columnIndex
         * @return
         */
        public Cell getCellFromGrid(int rowIndex, int columnIndex) {
            Cell cell = new Cell();

            for (Node node : getChildren()) {
                if (GridPane.getRowIndex(node) == rowIndex
                        && GridPane.getColumnIndex(node) == columnIndex) {
                    cell = ((Cell) node);
                }
            }
            return cell;
        }

        public boolean isValidCell(int rowIndex, int columnIndex) {
            // Check if row is out of bounds
            if (rowIndex < 0 || rowIndex >= BOARD_SIZE) {
                return false;
            }

            // Check if column is out of bounds
            if (columnIndex < 0 || columnIndex >= BOARD_SIZE) {
                return false;
            }

            // Check if the cell is X
            if (path[rowIndex][columnIndex] == 'X') {
                return false;
            }

            // Check if the cell is P
            if (path[rowIndex][columnIndex] == 'P') {
                return false;
            }

            // Four possible squares can be made with each addition to path
            // Square 1
            if (rowIndex > 0 && columnIndex < BOARD_SIZE - 1
                    && path[rowIndex - 1][columnIndex] == 'P'
                    && path[rowIndex - 1][columnIndex + 1] == 'P'
                    && path[rowIndex][columnIndex + 1] == 'P') {
                return false;
            }

            // Square 2
            if (rowIndex > 0 && columnIndex > 0
                    && path[rowIndex - 1][columnIndex] == 'P'
                    && path[rowIndex - 1][columnIndex - 1] == 'P'
                    && path[rowIndex][columnIndex - 1] == 'P') {
                return false;
            }

            // Square 3
            if (rowIndex < BOARD_SIZE - 1 && columnIndex < BOARD_SIZE - 1
                    && path[rowIndex][columnIndex + 1] == 'P'
                    && path[rowIndex + 1][columnIndex + 1] == 'P'
                    && path[rowIndex + 1][columnIndex] == 'P') {
                return false;
            }

            // Square 4
            if (rowIndex < BOARD_SIZE - 1 && columnIndex > 0
                    && path[rowIndex][columnIndex - 1] == 'P'
                    && path[rowIndex + 1][columnIndex - 1] == 'P'
                    && path[rowIndex + 1][columnIndex] == 'P') {
                return false;
            }

            // If not square exist with the addition of P at rowIndex, columnIndex
            return true;
        }

        public int[][] getMoves(int rowIndex, int columnIndex) {
            // Create a new array
            int[][] moves = new int[4][2];

            moves[0][0] = rowIndex + 1;
            moves[0][1] = columnIndex;
            moves[1][0] = rowIndex;
            moves[1][1] = columnIndex + 1;
            moves[2][0] = rowIndex - 1;
            moves[2][1] = columnIndex;
            moves[3][0] = rowIndex;
            moves[3][1] = columnIndex - 1;

            return moves;
        }
    }

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create a new board
        Board board = new Board();

        // Create the Find Path and Clear Path buttons
        Button btFindPath = new Button("Find Path");
        Button btClearPath = new Button("Clear Path");

        // Add the buttons the an HBox
        HBox paneForButtons = new HBox(10);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setPadding(new Insets(10));
        paneForButtons.getChildren().addAll(btFindPath, btClearPath);

        // Register event handlers with buttons
        btFindPath.setOnAction(e -> {
            board.findPath();
            board.paint();
        });
        btClearPath.setOnAction(e -> {
            board.clearPath();
            board.paint();
        });

        // Create a new border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(board);
        pane.setBottom(paneForButtons);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Maze"); // Set the stage title
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
}
