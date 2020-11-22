
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * (Game: Eight Queens) The Eight Queens problem is to find a solution to place
 * a queen in each row on a chessboard such that no two queens can attack each
 * other. Write a program to solve the Eight Queens problem using recursion and
 * display the result as shown in Figure 18.17. This solution to the problem
 * does not use recursion, but iteratively "repairs" each row until a solution
 * is reached. This greedy algorithm is not guaranteed to produce a result every
 * time, so a reset is implemented.
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
 * Output:
 * run:
 * Initial Queen drop...
 * . . . Q . . . .
 * . . . . . . . Q
 * . . . . Q . . .
 * . . . . . . Q .
 * . Q . . . . . .
 * . . . Q . . . .
 * . Q . . . . . .
 * . . . . Q . . .
 * Q @ (0, 3) has 2 conflicts.
 * Q @ (1, 7) has 1 conflicts.
 * Q @ (2, 4) has 1 conflicts.
 * Q @ (3, 6) has 1 conflicts.
 * Q @ (4, 1) has 2 conflicts.
 * Q @ (5, 3) has 2 conflicts.
 * Q @ (6, 1) has 1 conflicts.
 * Q @ (7, 4) has 2 conflicts.
 *
 * Testing ASC sort...
 * . . . Q . . . .
 * . . . . . . . Q
 * . . . . Q . . .
 * . . . . . . Q .
 * . Q . . . . . .
 * . . . Q . . . .
 * . Q . . . . . .
 * . . . . Q . . .
 * Q @ (1, 7) has 1 conflicts.
 * Q @ (2, 4) has 1 conflicts.
 * Q @ (3, 6) has 1 conflicts.
 * Q @ (6, 1) has 1 conflicts.
 * Q @ (4, 1) has 2 conflicts.
 * Q @ (5, 3) has 2 conflicts.
 * Q @ (0, 3) has 2 conflicts.
 * Q @ (7, 4) has 2 conflicts.
 *
 * Testing DSC sort...
 * . . . Q . . . .
 * . . . . . . . Q
 * . . . . Q . . .
 * . . . . . . Q .
 * . Q . . . . . .
 * . . . Q . . . .
 * . Q . . . . . .
 * . . . . Q . . .
 * Q @ (4, 1) has 2 conflicts.
 * Q @ (5, 3) has 2 conflicts.
 * Q @ (0, 3) has 2 conflicts.
 * Q @ (7, 4) has 2 conflicts.
 * Q @ (1, 7) has 1 conflicts.
 * Q @ (2, 4) has 1 conflicts.
 * Q @ (3, 6) has 1 conflicts.
 * Q @ (6, 1) has 1 conflicts.
 *
 * Solving and the solution is...
 * . . . . . . Q .
 * Q . . . . . . .
 * . . Q . . . . .
 * . . . . . . . Q
 * . . . . . Q . .
 * . . . Q . . . .
 * . Q . . . . . .
 * . . . . Q . . .
 * Q @ (3, 7) has 0 conflicts.
 * Q @ (0, 6) has 0 conflicts.
 * Q @ (2, 2) has 0 conflicts.
 * Q @ (4, 5) has 0 conflicts.
 * Q @ (6, 1) has 0 conflicts.
 * Q @ (1, 0) has 0 conflicts.
 * Q @ (5, 3) has 0 conflicts.
 * Q @ (7, 4) has 0 conflicts.
 *
 * @author martinfall
 */
public class EightQueensNoGUI extends Application {

    private static final int SIZE = 8;
    private static boolean[][] chessboard;
    private static int[][] queens;

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        System.out.println("Initial Queen drop...");
        dropQueens();
        printQueens();

        System.out.println("\nTesting ASC sort...");
        sortQueensAsc();
        printQueens();

        System.out.println("\nTesting DSC sort...");
        sortQueensDsc();
        printQueens();

        System.out.println("\nSolving and the solution is...");
        solve();
        printQueens();
    }

    /**
     * Main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Solve the Eight Queens puzzle
     */
    public void solve() {
        // Count the number of tries after an inition queen drop
        int tries = 0;

        // While the puzzle is not solved
        while (!isSolved()) {
            // Obtain the number of conflicts for the first queen in queens
            int currentConflict = queens[0][2];

            // For each queen in quees with an equal number of conflicts
            for (int[] queen : queens) {
                if (queen[2] == currentConflict) {
                    moveQueen(queen); // Move the queen to a better column
                    sortQueensDsc(); // Sort the array by dsc by conflict
                }
            }

            // Increment tries at every pass
            tries++;
            // After 50 unsuccesful attempts, drop 8 new queens are retry
            if (tries == 50) {
                tries = 0;
                dropQueens();
            }
        }
    }

    /**
     * Returns true if no queen on the board has a conflict.
     *
     * @return
     */
    public boolean isSolved() {
        for (int[] queen : queens) {
            if (queen[2] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Drops one queen per row at a randomly generated column.
     */
    public void dropQueens() {
        // Initialize the chessboard and queens arrays
        chessboard = new boolean[SIZE][SIZE];
        queens = new int[SIZE][3];

        // For each row, generate a column and update chessboard and queens
        for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
            int columnIndex = (int) (Math.random() * SIZE);
            chessboard[rowIndex][columnIndex] = true;
            // Set the conflict at -1 for each queen
            queens[rowIndex] = new int[]{rowIndex, columnIndex, -1};
        }

        // Iterate through the chessboard and update conflicts for each queen
        for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
            for (int columnIndex = 0; columnIndex < SIZE; columnIndex++) {
                if (chessboard[rowIndex][columnIndex]) {
                    queens[rowIndex][2] = getConflicts(rowIndex, columnIndex);
                }
            }
        }
    }

    /**
     * Displays the queens placements to the console.
     */
    public void printQueens() {
        for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
            for (int columnIndex = 0; columnIndex < SIZE; columnIndex++) {
                System.out.print(chessboard[rowIndex][columnIndex] ? " Q " : " . ");
            }
            System.out.println();
        }

        // Display the number of conflicts for each queen
        for (int[] queen : queens) {
            System.out.println("Q @ (" + queen[0] + ", " + queen[1] + ") has "
                    + queen[2] + " conflicts.");
        }
    }

    /**
     * Sorts the array of queens in ASC order by number of conflicts.
     */
    public void sortQueensAsc() {
        for (int i = 0; i < SIZE - 1; i++) {
            int min = i;

            for (int j = i + 1; j < SIZE; j++) {
                if (queens[min][2] > queens[j][2]) {
                    min = j;
                }
            }

            int[] temp = queens[min];
            queens[min] = queens[i];
            queens[i] = temp;
        }
    }

    /**
     * Sorts the array of queens in DSC order by number of conflicts.
     */
    public void sortQueensDsc() {
        for (int i = SIZE - 1; i > 0; i--) {
            int max = i;

            for (int j = i - 1; j >= 0; j--) {
                if (queens[max][2] > queens[j][2]) {
                    max = j;
                }
            }

            int[] temp = queens[max];
            queens[max] = queens[i];
            queens[i] = temp;
        }
    }

    /**
     * Moves a queen to an optimally less conflicted column on the same row.
     *
     * @param queen
     */
    public void moveQueen(int[] queen) {
        // Local variables for the row, column, and conflicts of a queen
        int currentRow = queen[0];
        int currentColumn = queen[1];
        int currentConflicts = queen[2];

        // Variable for the index of a better suited column with less conflicts
        int betterColumn = -1;

        // Loop through the columns on the same row
        for (int column = 0; column < SIZE; column++) {
            if (column != currentColumn
                    && getConflicts(currentRow, column) < currentConflicts) {
                betterColumn = column;
            }
        }

        // If a better placement exists, update queen and the chessboard
        if (betterColumn != -1 && betterColumn != currentColumn) {
            queen[0] = currentRow;
            queen[1] = betterColumn;
            queen[2] = getConflicts(currentRow, betterColumn);

            chessboard[currentRow][currentColumn] = false;
            chessboard[currentRow][betterColumn] = true;
        } else { // Else move it to a random column on the same row
            betterColumn = (int) (Math.random() * SIZE);

            // Update queen and the chessboard
            queen[0] = currentRow;
            queen[1] = betterColumn;
            queen[2] = getConflicts(currentRow, betterColumn);

            chessboard[currentRow][currentColumn] = false;
            chessboard[currentRow][betterColumn] = true;
        }
    }

    /**
     * Returns the number of conflicts at current row and column.
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    public int getConflicts(int rowIndex, int columnIndex) {
        int conflicts = 0; // Counter for the number of conflicts

        // Check horizontally (row)
        for (int column = 0; column < SIZE; column++) {
            if (chessboard[rowIndex][column] && column != columnIndex) {
                conflicts++; // Increment conflicts
            }
        }

        // Check vertically (column)
        for (int row = 0; row < SIZE; row++) {
            if (chessboard[row][columnIndex] && row != rowIndex) {
                conflicts++; // Increment conflicts
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
            if (chessboard[i][j] && i != rowIndex && j != columnIndex) {
                conflicts++;
            }
        }

        // Check the rising diagonal from bottom left to top right
        i = rowIndex;
        j = columnIndex;
        while (i < SIZE - 1 && j > 0) { // SIDE - 1!
            i++;
            j--;
        }

        for (; i >= 0 && j < SIZE; i--, j++) {
            if (chessboard[i][j] && i != rowIndex && j != columnIndex) {
                conflicts++;
            }
        }

        return conflicts;
    }
}
