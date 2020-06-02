
import java.util.Scanner;

/**
 * (Check Sudoku solution) Listing 8.4 checks whether a solution is valid by
 * checking whether every number is valid in the board. Rewrite the program by
 * checking whether every row, every column, and every small box has the numbers
 * 1 to 9.
 *
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

        /*
        9 6 3 1 7 4 2 5 8
        1 7 8 3 2 5 6 4 9
        2 5 4 6 8 9 7 3 1
        8 2 1 4 3 7 5 9 6
        4 9 6 8 5 2 3 1 7
        7 3 5 9 6 1 8 2 4
        5 8 9 7 1 3 4 6 2
        3 1 7 2 4 6 9 8 5
        6 4 2 5 9 8 1 7 3
         */
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
     * Check if every row, every column, and every small box has the numbers 1
     * to 9.
     *
     * @param grid
     * @return
     */
    public static boolean isValid(int[][] grid) {
        return checkRows(grid) && checkColumns(grid) && checkSmallBoxes(grid);
    }

    /**
     * Check if every row has the numbers 1 to 9.
     *
     * @param grid
     * @return
     */
    public static boolean checkRows(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            // Create an array of 9 elements
            int[] checker = new int[9];

            // Assign 1 to checker[value of element at row/column]
            for (int column = 0; column < grid[row].length; column++) {
                // if the value of row/column is between 1 and 9
                if (grid[row][column] >= 1 && grid[row][column] <= 9) {
                    checker[grid[row][column] - 1] = 1;
                }
            }

            // If the contents of checker are not all 1s, return false
            for (int i = 0; i < checker.length; i++) {
                if (checker[i] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check if every column has the numbers 1 to 9.
     *
     * @param grid
     * @return
     */
    public static boolean checkColumns(int[][] grid) {
        for (int column = 0; column < grid[0].length; column++) {
            // Create an array of 9 elements
            int[] checker = new int[9];

            // Assign 1 to checker[value of element at row/column]
            for (int row = 0; row < grid.length; row++) {
                // if the value of row/column is between 1 and 9
                if (grid[row][column] >= 1 && grid[row][column] <= 9) {
                    checker[grid[row][column] - 1] = 1;
                }
            }

            // If the contents of checker are not all 1s, return false
            for (int i = 0; i < checker.length; i++) {
                if (checker[i] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check each of the 9 3-by-3 squares
     *
     * @param grid
     * @return
     */
    public static boolean checkSmallBoxes(int[][] grid) {

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                // Create an array of 9 elements
                int[] checker = new int[9];

                for (int row = i; row < i + 3; row++) {
                    for (int column = j; column < j + 3; column++) {
                        // System.out.print((grid[row][column] - 1) + " ");
                        // System.out.println(Arrays.toString(checker));

                        // if the value of row/column is between 1 and 9
                        if (grid[row][column] >= 1 && grid[row][column] <= 9) {
                            checker[grid[row][column] - 1] = 1;
                        }
                    }
                }
                // System.out.println(Arrays.toString(checker));   
                // If the contents of checker are not all 1s, return false
                for (int k = 0; k < checker.length; k++) {
                    if (checker[k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
