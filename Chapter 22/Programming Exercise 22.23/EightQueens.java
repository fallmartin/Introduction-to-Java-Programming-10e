package eightqueens;

import java.util.*;

/**
 * (Game: multiple Eight Queens solution) Write a program to display all
 * possible solutions for the Eight Queens puzzle in a scroll pane, as shown in
 * Figure 22.16. For each solution, put a label to denote the solution number.
 * (Hint: Place all solution panes into an HBox and place this one pane into a
 * ScrollPane.)
 *
 * @author martinfall
 */
public class EightQueens {

    private static final ArrayList<Integer[]> solutions = new ArrayList<>();

    private static final int N = 8;

    /**
     * No-args constructor of the EightQueens class returns an instance of the
     * class with all possible solutions. For N = 8, the number of solutions is
     * 92.
     */
    public EightQueens() {
        /*
         * The int array queens is used to represent the position of each queen
         * on the board. The index k of the int value represents the row, and
         * the content of queens[k] represents the column.
         */
        Integer[] queens = new Integer[N];

        // Prime the array with -1, since an index can not be negative
        Arrays.fill(queens, -1);

        // Solve the problem
        solve(queens);
    }

    public static void solve(Integer[] queens) {
        int k = 0;

        // Call the recursive helper method with paramter k, 
        // where k is the current row
        solve(queens, k);
    }

    private static void solve(Integer[] queens, int k) {
        // Base condition 
        if (k == N) {
            // Add the solution to the array of solutions
            solutions.add(queens.clone());
        }

        for (int i = 0; i < N; i++) {
            // if no two queens threaten each other
            if (isSafe(k, i, queens)) {
                // place queen on the current square
                queens[k] = i;

                // recursively solve for the next row
                solve(queens, k + 1);

                // backtrack and remove the queen from the current square
                queens[k] = -1;
            }
        }
    }

    private static boolean isSafe(int row, int column, Integer[] queens) {
        for (int i = 1; i <= row; i++) {
            if (queens[row - i] == column // Check column
                    || queens[row - i] == column - i // Check upleft diagonal
                    || queens[row - i] == column + i) { // Check upright diagonal
                return false;
            }
        }
        return true;
    }

    private static void printQueens(Integer[] queens) {
        // Create and populate a char array 
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '-';
            }
        }

        // Position the queens at the indice pairs in queens array
        for (int n = 0; n < N; n++) {
            if (queens[n] != -1) {
                board[n][queens[n]] = 'Q';
            }
        }

        // Print the results on the console
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<Integer[]> getSolutions() {
        return solutions;
    }
}
