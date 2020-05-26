
import java.util.Scanner;

/**
 * Output:
 *
 * Enter a Sudoku puzzle solution: 
 * 9 6 3 1 7 4 2 5 8 
 * 1 7 8 3 2 5 6 4 9 
 * 2 5 4 6 8 9 7 3 1 
 * 8 2 1 4 3 7 5 9 6 
 * 4 9 6 8 5 2 3 1 7 
 * 7 3 5 9 6 1 8 2 4 
 * 5 8 9 7 1 3 4 6 2 
 * 3 1 7 2 4 6 9 8 5 
 * 6 4 2 5 9 8 1 7 3 
 * Valid Solution
 *
 * @author martinfall
 */
public class CheckSudokuSolution {

    public static void main(String[] args) {
        // Read a Sudoku solution
        int[][] grid = readASolution();

        System.out.println(isValid(grid) ? "Valid Solution" : "Invalid Solution");
    }

    /**
     * Read a Sudoku solution from the console
     *
     * @return
     */
    public static int[][] readASolution() {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a Sudoku puzzle solution: ");
        int[][] grid = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = input.nextInt();
            }
        }

        return grid;
    }

    /**
     * Check whether a solution is valid
     *
     * @param grid
     * @return
     */
    public static boolean isValid(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9 || !isValid(i, j, grid)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check whether grid[i][j] is valid in the grid
     *
     * @param i
     * @param j
     * @param grid
     * @return
     */
    public static boolean isValid(int i, int j, int[][] grid) {
        // Check whether grid[i][j] is unique in i's rows
        for (int column = 0; column < 9; column++) {
            if (column != j && grid[i][column] == grid[i][j]) {
                return false;
            }
        }

        // Check whether grid[i][j] is unique in j's column
        for (int row = 0; row < 9; row++) {
            if (row != i && grid[row][j] == grid[i][j]) {
                return false;
            }
        }

        // Check whether grid[i][j] is unique in the 3-by-3 box
        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
                if (row != i && col != j && grid[row][col] == grid[i][j]) {
                    return false;
                }
            }
        }
        return true; // The current value at grid[i][j] is valid
    }
}
