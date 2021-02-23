package sudoku;

import java.util.Scanner;

/**
 * (Game: recursive Sudoku) Write a recursive solution for the Sudoku problem.
 *
 * Output:
 * 
 * Enter a Sudoku puzzle:
 * 5 0 0 0 0 0 0 0 9
 * 0 0 9 3 0 0 0 0 0
 * 0 2 7 0 0 0 1 0 0
 * 4 0 0 5 0 0 3 0 8
 * 0 1 0 0 0 6 0 5 7
 * 0 0 3 0 0 0 9 0 0
 * 9 0 0 0 4 5 0 0 3
 * 1 0 0 0 7 0 0 0 0
 * 0 0 0 0 0 0 6 0 5
 * 
 * The solution is found:
 * 5 3 1 7 6 2 8 4 9
 * 6 4 9 3 8 1 5 7 2
 * 8 2 7 4 5 9 1 3 6
 * 4 9 6 5 1 7 3 2 8
 * 2 1 8 9 3 6 4 5 7
 * 7 5 3 8 2 4 9 6 1
 * 9 6 2 1 4 5 7 8 3
 * 1 8 5 6 7 3 2 9 4
 * 3 7 4 2 9 8 6 1 5
 *
 * @author martinfall
 */
public class Sudoku {

    public static void main(String[] args) {
        // Read a Sudoku puzzle
        int[][] grid = readAPuzzle();

        if (!isValid(grid)) {
            System.out.println("Invalid input");
        } else if (recursiveSearch(grid)) {
            System.out.println("\nThe solution is found:");
            printGrid(grid);
        } else {
            System.out.println("No solution");
        }
    }

    /**
     * Read a Sudoku puzzle from the keyboard. Empty cells are represented by a
     * 0 value for convenience.
     */
    public static int[][] readAPuzzle() {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a Sudoku puzzle:");
        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = input.nextInt();
            }
        }

        return grid;
    }

    /**
     * Obtain a list of free cells from the puzzle.
     *
     * @param grid
     * @return
     */
    public static int[][] getFreeCellList(int[][] grid) {
        // Determine the number of free cells 
        int numberOfFreeCells = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    numberOfFreeCells++;
                }
            }
        }

        // Store free cell positions into freeCellList 
        int[][] freeCellList = new int[numberOfFreeCells][2];
        int count = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    freeCellList[count][0] = i;
                    freeCellList[count++][1] = j;
                }
            }
        }

        return freeCellList;
    }

    /**
     * Print the values in the grid.
     *
     * @param grid
     */
    public static void printGrid(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Search for a solution.
     */
    public static boolean search(int[][] grid) {
        int[][] freeCellList = getFreeCellList(grid); // Free cells
        if (freeCellList.length == 0) {
            return true; // "No free cells");
        }
        int k = 0; // Start from the first free cell      
        while (true) {
            int i = freeCellList[k][0];
            int j = freeCellList[k][1];
            if (grid[i][j] == 0) {
                grid[i][j] = 1; // Fill the free cell with number 1
            }
            if (isValid(i, j, grid)) {
                if (k + 1 == freeCellList.length) { // No more free cells 
                    return true; // A solution is found
                } else { // Move to the next free cell
                    k++;
                }
            } else if (grid[i][j] < 9) {
                // Fill the free cell with the next possible value
                grid[i][j] = grid[i][j] + 1;
            } else { // free cell grid[i][j] is 9, backtrack
                while (grid[i][j] == 9) {
                    if (k == 0) {
                        return false; // No possible value
                    }
                    grid[i][j] = 0; // Reset to free cell
                    k--; // Backtrack to the preceding free cell
                    i = freeCellList[k][0];
                    j = freeCellList[k][1];
                }

                // Fill the free cell with the next possible value, 
                // search continues from this free cell at k
                grid[i][j] = grid[i][j] + 1;
            }
        }
    }

    public static boolean recursiveSearch(int[][] grid) {
        // Store the free cells in an int array
        int[][] freeCellList = getFreeCellList(grid);

        // Return true if there are no free cells
        if (freeCellList.length == 0) {
            return true;
        } else {
            // Call the recursive helper method if there are valid free cells
            int i = 0, j = 0;
            return recursiveSearchHelper(i, j, grid);
        }
    }

    private static boolean recursiveSearchHelper(int i, int j, int[][] grid) {
        // Stop on the last cell of the sudoku board at index 8, 8
        if (i == 8 && j == 8) { // Base case or stopping condition
            return true;
        }

        // If the column is greater than index 8, move to the start of next row
        if (j == 9) {
            i++;
            j = 0;
        }

        // Skip cells that already contain a value
        if (grid[i][j] != 0) {
            return recursiveSearchHelper(i, j + 1, grid);
        }

        // Try all possible values [1 - 9] at the current position
        for (int number = 1; number <= 9; number++) {
            grid[i][j] = number;

            // If the new number is valid at i, j, consider the next column
            if (isValid(i, j, grid)) {
                if (recursiveSearchHelper(i, j + 1, grid)) {
                    return true;
                }
            }

            // Reset the current value if not true value is returned
            grid[i][j] = 0; // Pseudo-backtracking
        }
        return false;
    }

    /**
     * Check whether grid[i][j] is valid in the grid
     */
    public static boolean isValid(int i, int j, int[][] grid) {
        // Check whether grid[i][j] is valid at the i's row
        for (int column = 0; column < 9; column++) {
            if (column != j && grid[i][column] == grid[i][j]) {
                return false;
            }
        }

        // Check whether grid[i][j] is valid at the j's column
        for (int row = 0; row < 9; row++) {
            if (row != i && grid[row][j] == grid[i][j]) {
                return false;
            }
        }

        // Check whether grid[i][j] is valid in the 3 by 3 box
        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
                if (!(row == i && col == j) && grid[row][col] == grid[i][j]) {
                    return false;
                }
            }
        }

        return true; // The current value at grid[i][j] is valid
    }

    /**
     * Check whether the fixed cells are valid in the grid
     */
    public static boolean isValid(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] < 0 || grid[i][j] > 9
                        || (grid[i][j] != 0 && !isValid(i, j, grid))) {
                    return false;
                }
            }
        }

        return true; // The fixed cells are valid
    }
}
