
import java.util.Scanner;

/**
 * (Pattern recognition: four consecutive equal numbers) Write the following
 * method that tests whether a two-dimensional array has four consecutive
 * numbers
 * of the same value, either horizontally, vertically, or diagonally.
 *
 * public static boolean isConsecutiveFour(int[][] values)
 *
 * Write a test program that prompts the user to enter the number of rows and
 * columns of a two-dimensional array and then the values in the array and
 * displays true if the array contains four consecutive numbers with the same
 * value. Otherwise, display false. Here are some examples of the true cases:
 *
 * @author martinfall
 */
public class PatternRecognition {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] values = new int[6][7];

        for (int row = 0; row < values.length; row++) {
            for (int column = 0; column < values[row].length; column++) {
                values[row][column] = input.nextInt();
            }
        }

        System.out.println(isConsecutiveFour(values));
    }

    /**
     * Check for four consecutive equal numbers in the matrix
     *
     * @param values
     * @return
     */
    public static boolean isConsecutiveFour(int[][] values) {
        return checkHorizontal(values)
                || checkVertical(values)
                || checkDiagonalLeftToRight(values)
                || checkDiagonalRightToLeft(values);
    }

    /**
     * Check for four consecutive equal numbers in each row
     *
     * @param values
     * @return
     */
    public static boolean checkHorizontal(int[][] values) {
        for (int row = 0; row < values.length; row++) {
            for (int column = 0; column < values.length - 3; column++) {
                int counter = 0;

                int testValue = values[row][column];
                for (int i = column; i < column + 4; i++) {
                    if (values[row][i] == testValue) {
                        counter++;
                    }
                }

                if (counter == 4) {
                    System.out.println(testValue
                            + " starting at (" + row + ", " + column + ")");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check for four consecutive equal numbers in each column
     *
     * @param values
     * @return
     */
    public static boolean checkVertical(int[][] values) {
        for (int column = 0; column < values[0].length; column++) {
            for (int row = 0; row < values.length - 3; row++) {
                int counter = 0;
                int testValue = values[row][column];

                for (int i = row; i < row + 4; i++) {
                    if (values[i][column] == testValue) {
                        counter++;
                    }
                }

                if (counter == 4) {
                    System.out.println(testValue
                            + " starting at (" + row + ", " + column + ")");
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
     * @param values
     * @return
     */
    public static boolean checkDiagonalLeftToRight(int[][] values) {
        for (int row = 0; row < values.length - 3; row++) {
            for (int column = 0; column < values[row].length - 3; column++) {
                int counter = 0;
                int testValue = values[row][column];

                for (int i = row, j = column; i < row + 4; i++, j++) {

                    if (values[i][j] == testValue) {
                        counter++;
                    }
                }

                if (counter == 4) {
                    System.out.println(testValue
                            + " starting at (" + row + ", " + column + ")");
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
     * @param values
     * @return
     */
    public static boolean checkDiagonalRightToLeft(int[][] values) {
        for (int row = values.length - 1; row > values.length - 3; row--) {
            for (int column = 0; column < values[row].length - 3; column++) {
                int counter = 0;
                int testValue = values[row][column];

                for (int i = row, j = column; i > row - 4; i--, j++) {
                    if (values[i][j] == testValue) {
                        counter++;
                    }
                }

                if (counter == 4) {
                    System.out.println(testValue
                            + " starting at (" + row + ", " + column + ")");
                    return true;
                }
            }
        }
        return false;
    }
}
