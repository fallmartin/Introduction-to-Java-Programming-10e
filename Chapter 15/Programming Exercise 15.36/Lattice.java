
import java.util.ArrayList;

/**
 *
 * @author martinfall
 */
public class Lattice {

    /*
     * Data Fields
     */
    // Size of the matrix is SIZE X SIZE
    private static int SIZE = 0;

    // Size of each side is LENGTH pixels
    private static final int LENGTH = 20;

    // Square matrix
    private static final double WIDTH = SIZE * LENGTH;
    private static final double HEIGHT = SIZE * LENGTH;

    // Boolean matrix of lattice vertices
    private boolean[][] visited = initMatrix();

    /**
     * No-args constructor of the Lattice class.
     */
    public Lattice(int n) {
        SIZE = n;
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
     * Returns true if the walk ends in a dead-end path.
     *
     * @param SIZE
     */
    private boolean endsInDeadEndPath() {

        // Reset the Boolean matrix
        visited = initMatrix();

        // Current row variables
        int currentRow = SIZE / 2;
        int currentColumn = SIZE / 2;

        // Generate the first possible valid steps
        ArrayList<int[]> validSteps = getValidSteps(currentRow, currentColumn);

        do {
            // Pick a random next step
            int[] chosenStep
                    = validSteps.get((int) (Math.random() * validSteps.size()));

            currentRow = chosenStep[0];
            currentColumn = chosenStep[1];

            // Update the Boolean matrix
            visited[currentRow][currentColumn] = true;

            // Generate the next possible valid steps
            validSteps = getValidSteps(currentRow, currentColumn);

            // Break out of the loop if we are at a boundary (dead-end)
            if (isLastStep(currentRow, currentColumn)) {
                // This is the condition that we're tracking
                break;
            }
            if (validSteps.isEmpty()) {
                return true;
            }
        } while (!validSteps.isEmpty());

        return false;
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
         * row -1, col
         * row, col - 1 row, col row, col + 1
         * row + 1, col
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

    public void getDeadEndPathProbability() {
        int deadEndPathCounter = 0;

        for (int i = 0; i < 10000; i++) {
            if (endsInDeadEndPath()) {
                deadEndPathCounter++;
            }
        }

        String message = String.format("For a lattice of size %d, the "
                + "probability of dead-end paths is %.2f%%", SIZE, (deadEndPathCounter / 10000.0) * 100);
        System.out.println(message);
    }
}
