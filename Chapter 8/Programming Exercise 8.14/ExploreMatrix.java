
/**
 * (Explore matrix) Write a program that prompts the user to enter the length of a
 * square matrix, randomly fills in 0s and 1s into the matrix, prints the matrix,
 * and finds the rows, columns, and diagonals with all 0s or 1s. Here is a sample
 * run of the program:
 *
 * Enter the size for the matrix: 4
 * 0111
 * 0000
 * 0100
 * 1111
 * All 0s on row 1
 * All 1s on row 3
 * No same numbers on a column
 * No same numbers on the major diagonal
 * No same numbers on the sub-diagonal
 *
 * Output:
 * 1110
 * 1001
 * 0000
 * 0011
 * All 0s on row 2
 * No same numbers on a column
 * No same numbers on the major diagonal
 * All 0s on the sub-diagonal
 *
 * 1111
 * 1010
 * 1101
 * 1011
 * All 1s on row 0
 * All 1s on column 0
 * No same numbers on the major diagonal
 * All 1s on the sub-diagonal
 *
 * @author martinfall
 */
public class ExploreMatrix {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] array = createArray(4);
        printArray(array);
        exploreArray(array);
    }

    /**
     * Create an array of size specified in parameters
     *
     * @param size
     * @return
     */
    public static int[][] createArray(int size) {
        // Create a new array 
        int[][] array = new int[size][size];

        // Randomly fills in 0s and 1s into the matrix
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                array[row][column] = (int) (Math.random() * 2);
            }
        }
        return array;
    }

    /**
     * Print the array
     *
     * @param array
     */
    public static void printArray(int[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                System.out.print(array[row][column]);
            }
            System.out.println();
        }
    }

    /**
     * Find the rows, columns, and diagonals with all 0s or 1s
     *
     * @param array
     */
    public static void exploreArray(int[][] array) {
        findRows(array);
        findColumns(array);
        findMajorDiagonal(array);
        findSubDiagonal(array);
    }

    /**
     * Find all 0s or 1s in rows
     *
     * @param array
     */
    public static void findRows(int[][] array) {
        int found = 0;
        for (int row = 0; row < array.length; row++) {
            int testValue = array[row][0];
            int counter = 0;

            for (int column = 0; column < array[row].length; column++) {
                if (array[row][column] == testValue) {
                    counter++;
                }
            }
            if (counter == array[row].length) {
                System.out.printf("All %ds on row %d%n", testValue, row);
                found++;
            }
        }
        if (found == 0) {
            System.out.println("No same numbers on a row");
        }
    }

    /**
     * Find all 0s or 1s in columns
     *
     * @param array
     */
    public static void findColumns(int[][] array) {
        int found = 0;
        for (int column = 0; column < array[0].length; column++) {
            int testValue = array[column][0];
            int counter = 0;

            for (int row = 0; row < array.length; row++) {
                if (array[row][column] == testValue) {
                    counter++;
                }
            }
            if (counter == array[column].length) {
                System.out.printf("All %ds on column %d%n", testValue, column);
                found++;
            }
        }
        if (found == 0) {
            System.out.println("No same numbers on a column");
        }
    }

    /**
     * Find all 0s or 1s in the major diagonal
     *
     * @param array
     */
    public static void findMajorDiagonal(int[][] array) {
        int found = 0;
        int testValue = array[0][0];
        int counter = 0;

        for (int row = 0; row < array.length; row++) {
            if (array[row][row] == testValue) {
                counter++;
            }
        }
        if (counter == array.length) {
            System.out.printf("All %ds on the major diagonal%n", testValue);
            found++;
        }
        if (found == 0) {
            System.out.println("No same numbers on the major diagonal");
        }
    }

    /**
     * Find all 0s or 1s in the sub-diagonal
     *
     * @param array
     */
    public static void findSubDiagonal(int[][] array) {
        int found = 0;
        int testValue = array[array.length - 1][0];
        int counter = 0;

        // 3 0      2 1     1 2     0 3
        for (int row = array.length - 1; row >= 0; row--) {
            if (array[row][array.length - row - 1] == testValue) {
                counter++;
            }
        }
        if (counter == array.length) {
            System.out.printf("All %ds on the sub-diagonal%n", testValue);
            found++;
        }
        if (found == 0) {
            System.out.println("No same numbers on the sub-diagonal");
        }
    }
}
