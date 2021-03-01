package sudoku;

import java.util.*;

/**
 *
 * @author martinfall
 */
public class Sudoku {

    private static final ArrayList<Integer[][]> solutions = new ArrayList<>();

    public Sudoku(Integer[][] grid) {
        solutions.clear();
        solve(grid);
    }

    public static void solve(Integer[][] grid) {
        Integer[][] freeCellList = getFreeCellList(grid);
        if (freeCellList.length == 0) {
            solutions.add(deepCopy(grid));
            // printGrid(grid);
        }

        int k = 0;
        solve(k, grid, freeCellList);
    }

    public static void solve(int k, Integer[][] grid, Integer[][] freeCellList) {

        int i = freeCellList[k][0];
        int j = freeCellList[k][1];

        for (int number = 1; number <= 9; number++) {
            grid[i][j] = number;
            if (isValid(i, j, grid) && k + 1 != freeCellList.length) {
                solve(k + 1, grid, freeCellList);
            }

            if (k + 1 == freeCellList.length
                    && isValid(grid)) {
                solutions.add(deepCopy(grid));
                // printGrid(grid);
            }

            grid[i][j] = 0;
        }

    }

    public static ArrayList<Integer[][]> getSolutions() {
        return solutions;
    }

    public static Integer[][] getFreeCellList(Integer[][] grid) {
        int numberOfFreeCells = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    numberOfFreeCells++;
                }
            }
        }

        Integer[][] freeCellsList = new Integer[numberOfFreeCells][2];

        int index = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    freeCellsList[index][0] = i;
                    freeCellsList[index++][1] = j;
                }
            }
        }

        return freeCellsList;
    }

    /**
     * Prints the Sudoku grid to the console.
     *
     * @param grid
     */
    public static void printGrid(Integer[][] grid) {
        System.out.println("-----------------");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Returns true if the grid is valid.
     *
     * @param grid
     * @return
     */
    public static boolean isValid(Integer[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] < 0
                        || grid[i][j] > 9
                        || (grid[i][j] != 0 && !isValid(i, j, grid))) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Returns true if the grid is valid at i, j.
     *
     * @param i
     * @param j
     * @param grid
     * @return
     */
    public static boolean isValid(int i, int j, Integer[][] grid) {
        for (int column = 0; column < 9; column++) {
            if (column != j && Objects.equals(grid[i][column], grid[i][j])) {
                return false;
            }
        }

        for (int row = 0; row < 9; row++) {
            if (row != i && Objects.equals(grid[row][j], grid[i][j])) {
                return false;
            }
        }

        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
                if (!(row == i && col == j)
                        && Objects.equals(grid[row][col], grid[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Returns a deep copy of the parameter array.
     *
     * @param grid
     * @return
     */
    public static Integer[][] deepCopy(Integer[][] grid) {
        Integer[][] copy = new Integer[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                copy[i][j] = grid[i][j];
            }
        }

        return copy;
    }
}
