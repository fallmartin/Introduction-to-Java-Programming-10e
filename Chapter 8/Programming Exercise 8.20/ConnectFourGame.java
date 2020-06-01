
import java.util.Scanner;

/**
 * (Game: connect four) Connect four is a two-player board game in which the
 * players alternately drop colored disks into a seven-column, six-row
 * vertically
 * suspended grid, as shown below.
 *
 * The objective of the game is to connect four same-colored disks in a row, a
 * column, or a diagonal before your opponent can do likewise. The program
 * prompts
 * two players to drop a red or yellow disk alternately. In the preceding
 * figure,
 * the red disk is shown in a dark color and the yellow in a light color.
 * Whenever
 * a disk is dropped, the program redisplays the board on the console and
 * determines the status of the game (win, draw, or continue). Here is a sample
 * run:
 *
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * ———————————————
 * Drop a red disk at column (0–6): 0
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * |R| | | | | | |
 * ———————————————
 * Drop a yellow disk at column (0–6): 3
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * |R| | |Y| | | |
 * . . .
 * . . .
 * . . .
 * Drop a yellow disk at column (0–6): 6
 * | | | | | | | |
 * | | | | | | | |
 * | | | |R| | | |
 * | | | |Y|R|Y| |
 * | | |R|Y|Y|Y|Y|
 * |R|Y|R|Y|R|R|R|
 * ———————————————
 * The yellow player won
 *
 * @author martinfall
 */
public class ConnectFourGame {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Boolean flag
        boolean hasWinner = false;

        // Create a new matrix to simulate the board
        int[][] board = new int[6][7];

        // Print the board to the console
        printBoard(board);

        // do-while loop until a winner is found
        while (!hasWinner) {
            // Prompt the red player to drop a RED disk
            System.out.print("Drop a red disk at column (0–6): ");
            int red = input.nextInt();

            dropDisk(red, board, "R"); // Drop a disk on the board
            printBoard(board); // Print the board
            // Check for winner
            if (isConnectFour(board)) {
                hasWinner = true;
                break;
            }

            // Prompt the yellow player to drop a YELLOW disk
            System.out.print("Drop a yellow disk at column (0–6): ");
            int yellow = input.nextInt();

            dropDisk(yellow, board, "Y"); // Drop a disk on the board
            printBoard(board); // Print the board
            if (isConnectFour(board)) {
                hasWinner = true;
                break;
            }
        }

    }

    /**
     * Print the entire board to the console
     *
     * @param board
     */
    public static void printBoard(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            System.out.print("|");
            for (int column = 0; column < board[row].length; column++) {
                printSquare(row, column, board);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("———————————————");
    }

    /**
     * Print the contents of a square on the board
     *
     * @param row
     * @param column
     * @param board
     */
    public static void printSquare(int row, int column, int[][] board) {
        switch (board[row][column]) {
            case 0:
                System.out.print(" ");
                break;
            case 1:
                System.out.print("Y");
                break;
            case 2:
                System.out.print("R");
                break;
        }
    }

    /**
     * Drop a disk in the user-specified column of the game board
     *
     * Method can be modified to ask user to drop another disk if a
     * column is full
     *
     * @param column
     * @param board
     * @param color
     */
    public static void dropDisk(int column, int[][] board, String color) {
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][column] == 0) {
                board[row][column] = (color.equals("Y") ? 1 : 2);
                break;
            } else if (board[row][column] != 0 && row == 0) {
                System.out.println("The row is full. Pick another row next turn.");
            }
        }
    }

    /**
     * Check for four consecutive equal numbers in the matrix
     *
     * @param board
     * @return
     */
    public static boolean isConnectFour(int[][] board) {
        return checkHorizontal(board)
                || checkVertical(board)
                || checkDiagonalLeftToRight(board)
                || checkDiagonalRightToLeft(board);
    }

    /**
     * Check for four consecutive equal numbers in each row
     *
     * @param board
     * @return
     */
    public static boolean checkHorizontal(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length - 3; column++) {
                int counter = 0;

                int testValue = board[row][column];

                if (testValue != 0) {
                    for (int i = column; i < column + 4; i++) {
                        if (board[row][i] == testValue) {
                            counter++;
                        }
                    }
                }

                if (checkCounter(counter, testValue)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check for four consecutive equal numbers in each column
     *
     * @param board
     * @return
     */
    public static boolean checkVertical(int[][] board) {
        for (int column = 0; column < board[0].length; column++) {
            for (int row = 0; row < board.length - 3; row++) {
                int counter = 0;
                int testValue = board[row][column];

                if (testValue != 0) {
                    for (int i = row; i < row + 4; i++) {
                        if (board[i][column] == testValue) {
                            counter++;
                        }
                    }
                }

                if (checkCounter(counter, testValue)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check for four consecutive equal numbers on the diagonal from left to
     * right
     *
     * @param board
     * @return
     */
    public static boolean checkDiagonalLeftToRight(int[][] board) {
        for (int row = 0; row < board.length - 3; row++) {
            for (int column = 0; column < board[row].length - 3; column++) {
                int counter = 0;
                int testValue = board[row][column];

                if (testValue != 0) {
                    for (int i = row, j = column; i < row + 4; i++, j++) {

                        if (board[i][j] == testValue) {
                            counter++;
                        }
                    }
                }

                if (checkCounter(counter, testValue)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check for four consecutive equal numbers on the diagonal from right to
     * left
     *
     * @param board
     * @return
     */
    public static boolean checkDiagonalRightToLeft(int[][] board) {
        for (int row = board.length - 1; row > board.length - 3; row--) {
            for (int column = 0; column < board[row].length - 3; column++) {
                int counter = 0;
                int testValue = board[row][column];

                if (testValue != 0) {
                    for (int i = row, j = column; i > row - 4; i--, j++) {
                        if (board[i][j] == testValue) {
                            counter++;
                        }
                    }
                }

                if (checkCounter(counter, testValue)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check the counter to see if 4 consecutive numbers were found
     *
     * @param counter
     * @param testValue
     * @return
     */
    public static boolean checkCounter(int counter, int testValue) {
        if (counter == 4) {
            System.out.printf("The %s player won%n", (testValue == 1) ? "yellow" : "red");
            return true;
        }
        return false;
    }
}
