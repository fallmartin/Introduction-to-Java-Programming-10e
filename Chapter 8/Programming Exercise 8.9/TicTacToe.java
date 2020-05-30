
import java.util.Scanner;

/**
 * (Game: play a tic-tac-toe game) In a game of tic-tac-toe, two players take
 * turns marking an available cell in a 3 * 3 grid with their respective tokens
 * (either X or O). When one player has placed three tokens in a horizontal, or
 * diagonal row on the grid, the game is over and that player has won. A draw
 * (no winner) occurs when all the cells on the grid have been filled with
 * tokens and neither player has achieved a win. Create a program for playing
 * tic-tac-toe. The program prompts two players to enter an X token and O token
 * alternately. Whenever a token is entered, the program redisplays the board on
 * the console and determines the status of the game (win, draw, or continue).
 *
 * @author martinfall
 */
public class TicTacToe {

    public static void main(String[] args) {
        // Create a new board
        String[][] grid = new String[3][3];

        // Print the grid
        printGrid(grid);

        do {

            // Play X
            playXTurn(grid);

            if (!checkDraw(grid)) // Play O - computer
            {
                playOTurn(grid);
            }

            // Print the grid
            printGrid(grid);
        } while (!checkGrid(grid));

    }

    /**
     * Take square coordinate for X and place X in grid
     *
     * @param grid
     */
    public static void playXTurn(String[][] grid) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a row and a column for player X
        System.out.print("Enter a row (0, 1, or 2) for player X: ");
        int rowX = input.nextInt();
        System.out.print("Enter a column (0, 1, or 2) for player X: ");
        int columnX = input.nextInt();

        // Mark the square on the grid for X
        markSquareX(rowX, columnX, grid);

        // Print the grid
        // printGrid(grid);
    }

    /**
     * Take square coordinate for O and place O in grid
     *
     * @param grid
     */
    public static void playOTurn(String[][] grid) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a row and a column for player O
        // System.out.print("Enter a row (0, 1, or 2) for player O: ");
        // int rowO = input.nextInt();
        // System.out.print("Enter a column (0, 1, or 2) for player O: ");
        // int columnO = input.nextInt();
        // Randomly generate the coordinates for new O
        int rowO = (int) (Math.random() * 3);
        int columnO = (int) (Math.random() * 3);

        // Mark the square on the grid for O
        markSquareO(rowO, columnO, grid);

        // Print the grid
        // printGrid(grid);
    }

    /**
     * Print the grid to console
     *
     * @param grid
     */
    public static void printGrid(String[][] grid) {
        System.out.println("-------------");
        for (int row = 0; row < grid.length; row++) {
            System.out.print("| ");
            for (int column = 0; column < grid[row].length; column++) {
                // System.out.print(grid[row][column] + " | " );
                System.out.print(printSquare(row, column, grid) + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    /**
     * Helper method for printGrid that prints the contents of square from row
     * and length
     *
     * @param row
     * @param column
     * @param grid
     * @return
     */
    public static String printSquare(int row, int column, String[][] grid) {
        return grid[row][column] == null ? " " : grid[row][column];
    }

    /**
     * Mark the square with X
     *
     * @param row
     * @param column
     * @param grid
     */
    public static void markSquareX(int row, int column, String[][] grid) {
        if (grid[row][column] == null) {
            grid[row][column] = "X";
        }
    }

    /**
     * Mark the square with O
     *
     * @param row
     * @param column
     * @param grid
     */
    public static void markSquareO(int row, int column, String[][] grid) {
        if (grid[row][column] == null) {
            grid[row][column] = "O";
        } else {
            playOTurn(grid);
        }
    }

    /**
     * Check for horizontal win
     *
     * @param grid
     * @return
     */
    public static boolean checkRow(String[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            if (grid[row][0] != null && grid[row][1] != null && grid[row][2] != null) {
                if (grid[row][0].equals(grid[row][1]) && grid[row][0].equals(grid[row][2])) {
                    // Print winner
                    System.out.println(grid[row][0] + " player won");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check for vertical win
     *
     * @param grid
     * @return
     */
    public static boolean checkColumn(String[][] grid) {
        for (int column = 0; column < grid[0].length; column++) {
            if (grid[0][column] != null && grid[1][column] != null && grid[2][column] != null) {
                if (grid[0][column].equals(grid[1][column]) && grid[0][column].equals(grid[2][column])) {
                    // Print winner
                    System.out.println(grid[0][column] + " player won");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check diagonal win from left to right
     *
     * @param grid
     * @return
     */
    public static boolean checkDiagonalLeftToRight(String[][] grid) {
        if (grid[0][0] != null && grid[1][1] != null && grid[2][2] != null) {
            if (grid[0][0].equals(grid[1][1]) && grid[0][0].equals(grid[2][2])) {
                // Print winner
                System.out.println(grid[0][0] + " player won");
                return true;
            }
        }

        return false;
    }

    /**
     * Check diagonal win from right to left
     *
     * @param grid
     * @return
     */
    public static boolean checkDiagonalRightToLeft(String[][] grid) {
        if (grid[2][0] != null && grid[1][1] != null && grid[0][2] != null) {
            if (grid[2][0].equals(grid[1][1]) && grid[2][0].equals(grid[0][2])) {
                // Print winner
                System.out.println(grid[2][0] + " player won");
                return true;
            }
        }

        return false;
    }

    /**
     * Check the grid for horizontal, vertical, diagonal win or draw
     *
     * @param grid
     * @return
     */
    public static boolean checkGrid(String[][] grid) {
        return checkRow(grid)
                || checkColumn(grid)
                || checkDiagonalLeftToRight(grid)
                || checkDiagonalRightToLeft(grid)
                && !checkDraw(grid);
    }

    /**
     * Check if all squares are occupied
     *
     * @param grid
     * @return
     */
    public static boolean checkDraw(String[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == null) {
                    return false;
                }
            }
        }
        return true;
    }

}
