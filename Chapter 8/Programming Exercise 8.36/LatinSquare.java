
import java.util.Scanner;

/**
 * (Latin square) A Latin square is an n-by-n array filled with n different
 * Latin letters, each occurring exactly once in each row and once in each
 * column. Write a program that prompts the user to enter the number n and the
 * array of characters, as shown in the sample output, and checks if the input
 * array is a Latin square. The characters are the first n characters starting
 * from A.
 *
 * Enter number n: 4
 * Enter 4 rows of letters separated by spaces:
 * A B C D
 * B A D C
 * C D B A
 * D C A B
 * The input array is a Latin square
 *
 * Enter number n: 3
 * Enter 3 rows of letters separated by spaces:
 * A F D
 * Wrong input: the letters must be from A to C
 *
 * @author martinfall
 */
public class LatinSquare {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Create an array and populate it with user input
        String[][] square = getInput(input);

        // Uncomment the statment below to display the square to console
        // displaySquare(square);
        // Check if the input array is a Latin square
        if (isLatinSquare(square)) {
            System.out.println("The input array is a Latin square");
        }
    }

    /**
     * Collect input from user and store it into a returned array
     *
     * @param input
     * @return
     */
    public static String[][] getInput(Scanner input) {
        // Prompt the user to enter the number of rows in the matrix
        System.out.print("Enter number n: ");
        int n = input.nextInt();

        // Create an array
        String[][] m = new String[n][n];

        // Prompt the user to enter the matrix row by row
        System.out.println("Enter " + n + " rows of letters separated by spaces: ");
        for (int row = 0; row < m.length; row++) {
            for (int column = 0; column < m[row].length; column++) {
                m[row][column] = input.next();

                if (!checkInput(m[row][column], n)) {
                    System.out.println("Wrong input: "
                            + "the letters must be from A to " + (char) ('A' + n - 1));
                    // Exit with code zero to indicate normal termination
                    System.exit(0);
                }
            }
        }

        // Return the array
        return m;
    }

    /**
     * Print the square to console
     *
     * @param m
     */
    public static void displaySquare(String[][] m) {
        System.out.println();

        for (int row = 0; row < m.length; row++) {
            for (int column = 0; column < m[row].length; column++) {
                System.out.print(m[row][column] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Check if the input is between A and A + n - 1
     *
     * @param string
     * @param n
     * @return
     */
    public static boolean checkInput(String string, int n) {
        if (string.charAt(0) >= 'A' && string.charAt(0) <= ('A' + n - 1)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Loop through the square matrix element by element and check if each
     * element satisfies the requirements of a Latin square
     *
     * @param m
     * @return
     */
    public static boolean isLatinSquare(String[][] m) {
        for (int row = 0; row < m.length; row++) {
            for (int column = 0; column < m[row].length; column++) {
                if (!isValidValue(row, column, m)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check if the value at m[row][column] occurs once in each row and once in
     * each column
     *
     * @param row
     * @param column
     * @param m
     * @return
     */
    public static boolean isValidValue(int row, int column, String[][] m) {
        int count = 0;

        // Look at the current row
        for (String str : m[row]) {
            if (str.equals(m[row][column])) {
                count++;
            }
        }

        // Look at the current column
        for (int i = 0; i < m.length; i++) {
            if (m[row][i].equals(m[row][column])) {
                count++;
            }
        }

        if (count != 2) {
            return false;
        }

        return true;
    }
}
