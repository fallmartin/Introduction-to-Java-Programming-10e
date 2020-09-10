
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;

/**
 *
 * @author martinfall
 */
public class Lattice extends Pane {

    /* Data Fields */
    // Size of the matrix is SIZE X SIZE
    private static final int SIZE = 16;

    // Size of each side is LENGTH pixels
    private static final int LENGTH = 20;

    // Square matrix
    private static final double WIDTH = SIZE * LENGTH;
    private static final double HEIGHT = SIZE * LENGTH;

    // Boolean matrix of lattice vertices
    private boolean[][] visited = initMatrix();

    public Lattice() {
        // minimum width and height of matrix
        setMinSize(WIDTH, WIDTH);

        // Draw the grid in the pane
        drawGrid();
    }

    /**
     * Draw the grid system on the pane.
     */
    private void drawGrid() {
        // Local variables for drawing horizontal and vertical lines of lattice
        double startX = 0;
        double startY = 0;

        // Draw vertical lines
        for (int i = 0; i < SIZE + 1; i++) {
            Line line = new Line(startX, startY, startX, HEIGHT);
            line.setStroke(Color.LIGHTGRAY);
            getChildren().add(line);
            startX += LENGTH;
        }

        // Reset x
        startX = 0;

        // Draw horizontal lines
        for (int i = 0; i < SIZE + 1; i++) {
            Line line = new Line(startX, startY, WIDTH, startY);
            line.setStroke(Color.LIGHTGRAY);
            getChildren().add(line);
            startY += LENGTH;
        }
    }

    /**
     * Initialize a Boolean matrix for visited vertices.
     *
     * @return
     */
    private boolean[][] initMatrix() {
        // Create a new boolean array 
        visited = new boolean[SIZE + 1][SIZE + 1];

        // Starting point is the center of the lattice
        visited[SIZE / 2][SIZE / 2] = true;

        return visited;
    }

    /**
     * Prints the Boolean matrix of visited vertices to the console.
     */
    private void printMatrix() {
        for (int row = 0; row < visited.length; row++) {
            for (int column = 0; column < visited[row].length; column++) {
                // System.out.print(visited[row][column] ? 1 : 0);
                if (visited[row][column]) {
                    Circle dot = new Circle(2, Color.DEEPSKYBLUE);
                    dot.setCenterX(LENGTH * row);
                    dot.setCenterY(LENGTH * column);
                    getChildren().add(dot);

                }
            }
        }
    }

    /**
     * Draws a possible path on the pane following the program requirements.
     */
    public void walk() {
        /* Initial GUI and T/F matrix setups */
        // Clear the pane
        getChildren().clear();
        // Redraw the grid in the pane
        drawGrid();
        visited = initMatrix(); // Reset the Boolean matrix

        // Current row variables
        int currentRow = SIZE / 2;
        int currentColumn = SIZE / 2;

        // Create a new polyline for the path and add the starting point
        Polyline path = new Polyline();
        path.getPoints().addAll(
                (double) currentRow * LENGTH,
                (double) currentColumn * LENGTH);

        // Generate the first possible valid steps
        ArrayList<int[]> validSteps = getValidSteps(currentRow, currentColumn);

        do {
            // Pick a random next step
            int[] chosenStep
                    = validSteps.get((int) (Math.random() * validSteps.size()));

            // Build the path
            path.getPoints().addAll(
                    (double) chosenStep[0] * LENGTH,
                    (double) chosenStep[1] * LENGTH);

            // Display the randomly chosen next step the the console
            System.out.println("Random next step: " + Arrays.toString(chosenStep));
            System.out.println(); // Formatting line

            // Update the current row and column
            currentRow = chosenStep[0];
            currentColumn = chosenStep[1];

            // Update the T/F matrix
            visited[currentRow][currentColumn] = true;

            // Generate the next possible valid steps
            validSteps = getValidSteps(currentRow, currentColumn);

            // Break out of the loop if we are at a boundary
            if (isLastStep(currentRow, currentColumn)) {
                System.out.println("We've hit a boundary! Walk done!");
                break;
            }
        } while (!validSteps.isEmpty());

        if (validSteps.isEmpty()) {
            System.out.println("No more possible steps are possible. Walk done!");
            System.out.println(Arrays.deepToString(validSteps.toArray()));
        }

        // Display the visited vertices
        getChildren().add(path);
        // printMatrix();
    }

    /**
     * Generates an array list of pairs of coordinates for possible valid steps.
     *
     * @param currentRow
     * @param currentColumn
     * @return
     */
    private ArrayList<int[]> getValidSteps(int currentRow, int currentColumn) {
        // Array to hold all possible steps from a given point
        ArrayList<int[]> validSteps = new ArrayList<>();

        /*
        * Possible values for steps are between 4 and 0
        *                  row -1, col
        * row, col - 1     row, col        row, col + 1
        *                  row + 1, col
         */
        // Explore possible steps in the same row
        for (int i = -1; i <= 1; i++) {
            if (isValidStep(currentRow + i, currentColumn)) {
                int[] coordinates = new int[2];
                coordinates[0] = currentRow + i;
                coordinates[1] = currentColumn;
                validSteps.add(coordinates);
            }
        }

        // Explore possible steps in the same column
        for (int i = -1; i <= 1; i++) {
            if (isValidStep(currentRow, currentColumn + i)) {
                int[] coordinates = new int[2];
                coordinates[0] = currentRow;
                coordinates[1] = currentColumn + i;
                validSteps.add(coordinates);
            }
        }

        // Display possible steps to the console
        String message = String.format("Possible valid steps from [%d, %d]:",
                currentRow, currentColumn);
        System.out.println(message);

        for (int[] XY : validSteps) {
            System.out.println(Arrays.toString(XY));
        }

        return validSteps;
    }

    /**
     * Returns true if the coordinates produce a valid step.
     *
     * @param row
     * @param column
     * @return
     */
    private boolean isValidStep(int row, int column) {

        // Return true if the indices are in the right range 
        if (row >= 0 && row <= SIZE
                && column >= 0 && column <= SIZE
                // and the element at row, column is false
                && visited[row][column] == false) {
            return true;
        }
        return false; // Return false otherwise
    }

    /**
     * Returns true if the coordinates are at the boundaries of the lattice.
     *
     * @param currentRow
     * @param currentColumn
     * @return
     */
    private boolean isLastStep(int currentRow, int currentColumn) {
        return currentRow == 0
                || currentRow == SIZE
                || currentColumn == 0
                || currentColumn == SIZE;
    }
}
