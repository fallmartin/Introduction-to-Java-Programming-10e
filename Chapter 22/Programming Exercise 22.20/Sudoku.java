package sudoku;

import java.util.*;

/**
 * (Game: multiple Sudoku solutions) The complete solution for the Sudoku
 * problem is given in Supplement VI.A. A Sudoku problem may have multiple
 * solutions. Modify Sudoku.java in Supplement VI.A to display the total number
 * of the solutions. Display two solutions if multiple solutions exist.
 *
 * Output:
 * 
 * Enter a Sudoku puzzle:
 * 2 9 5 7 4 3 8 6 1
 * 4 3 1 8 6 5 9 0 0
 * 8 7 6 1 9 2 5 4 3
 * 3 8 7 4 5 9 2 1 6
 * 6 1 2 3 8 7 4 9 5
 * 5 4 9 2 1 6 7 3 8
 * 7 6 3 5 2 4 1 8 9
 * 9 2 8 6 7 1 3 5 4
 * 1 5 4 9 3 8 6 0 0
 *
 * Number of solutions found: 2
 *
 * 2 9 5 7 4 3 8 6 1
 * 4 3 1 8 6 5 9 2 7
 * 8 7 6 1 9 2 5 4 3
 * 3 8 7 4 5 9 2 1 6
 * 6 1 2 3 8 7 4 9 5
 * 5 4 9 2 1 6 7 3 8
 * 7 6 3 5 2 4 1 8 9
 * 9 2 8 6 7 1 3 5 4
 * 1 5 4 9 3 8 6 7 2
 *
 * 2 9 5 7 4 3 8 6 1
 * 4 3 1 8 6 5 9 7 2
 * 8 7 6 1 9 2 5 4 3
 * 3 8 7 4 5 9 2 1 6
 * 6 1 2 3 8 7 4 9 5
 * 5 4 9 2 1 6 7 3 8
 * 7 6 3 5 2 4 1 8 9
 * 9 2 8 6 7 1 3 5 4
 * 1 5 4 9 3 8 6 2 7
 *
 * @author martinfall
 */
public class Sudoku {

    // The solutions array lists holds all of the solutions for this configuration
    private static ArrayList<Integer[][]> solutions = new ArrayList<>();

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Read a Sudoku puzzle
        int[][] grid = readAPuzzle();

        if (!isValid(grid)) {
            System.out.println("Invalid input");
        } else if (!search(grid).isEmpty()) {
            System.out.println("\nNumber of solutions found: "
                    + solutions.size());

            Iterator<Integer[][]> iterator = solutions.iterator();
            while (iterator.hasNext()) {
                System.out.println(); // Formatting line
                printGrid(iterator.next());
            }
        } else {
            System.out.println("No solution");
        }
    }

    /**
     * Read a Sudoku puzzle from the keyboard.
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
    public static void printGrid(Integer[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Search for a solution.
     *
     * @param grid
     * @return
     */
    public static ArrayList<Integer[][]> search(int[][] grid) {

        int[][] freeCellList = getFreeCellList(grid); // Free cells

        if (freeCellList.length == 0) {
            solutions.add(convert(grid));
            return solutions;
        }

        int k = 0; // Start from the first free cell

        while (true) {
            int i = freeCellList[k][0];
            int j = freeCellList[k][1];

            if (grid[i][j] == 0) {
                grid[i][j] = 1; // Fill the free cell with number 1
            }

            // Boolean flag initialized to false
            boolean flag = false;

            if (isValid(i, j, grid)) {
                flag = true; // Set the flag to true if the cell is valid

                if (k + 1 == freeCellList.length) { // No more free cells 
                    solutions.add(convert(grid)); // Store the current solution
                    flag = false; // A solution is found but don't stop
                } else { // Move to the next free cell
                    k++; // Increment k
                }
            }

            if (!flag) {
                if (grid[i][j] < 9) {
                    // Fill the free cell with the next possible value
                    grid[i][j] = grid[i][j] + 1;
                } else { // free cell grid[i][j] is 9, backtrack
                    while (grid[i][j] == 9) {
                        if (k == 0) {
                            return solutions;
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
    }

    /**
     * Check whether grid[i][j] is valid in the grid.
     *
     * @param i
     * @param j
     * @param grid
     * @return
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
     * Check whether the fixed cells are valid in the grid.
     *
     * @param grid
     * @return
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

    /**
     * Returns an Integer[][] array converted from the int[][] array grid.
     *
     * @param grid
     * @return
     */
    private static Integer[][] convert(int[][] grid) {
        Integer[][] converted = new Integer[9][9];

        // Populate the converted array
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                converted[i][j] = grid[i][j];
            }
        }

        return converted; // Return the Integer[][] array
    }
}
