
/**
 * Write a program that randomly fills in 0s and 1s into a 4-by-4 matrix, prints
 * the matrix, and finds the first row and column with the most 1s. Here is a
 * sample run of the program:
 *
 * 0011
 * 0011
 * 1101
 * 1010
 * The largest row index: 2
 * The largest column index: 2
 *
 * @author martinfall
 */
public class LargestRowAndColumn {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = generateMatrix();
        printMatrix(matrix);
        System.out.println("The largest row index: " + largestRowIndex(matrix));
        System.out.println("The largest column index: " + largestColumnIndex(matrix));
    }

    /**
     * Generate the matrix
     *
     * @return
     */
    public static int[][] generateMatrix() {
        int[][] matrix = new int[4][4];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = (int) (Math.random() * 2);
            }
        }
        return matrix;
    }

    /**
     * Print the matrix
     *
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column]);
            }
            System.out.println();
        }
    }

    /**
     * Find the largest row index
     *
     * @param matrix
     * @return
     */
    public static int largestRowIndex(int[][] matrix) {
        int index = 0;
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            int temp = 0;

            for (int column = 0; column < matrix[row].length; column++) {
                temp += matrix[row][column];
            }

            if (temp > sum) {
                sum = temp;
                index = row;
            }
        }
        return index;
    }

    /**
     * Find the largest column index
     *
     * @param matrix
     * @return
     */
    public static int largestColumnIndex(int[][] matrix) {
        int index = 0;
        int sum = 0;

        for (int column = 0; column < matrix[0].length; column++) {
            int temp = 0;
            for (int row = 0; row < matrix.length; row++) {
                temp += matrix[row][column];
            }

            if (temp > sum) {
                sum = temp;
                index = column;
            }
        }

        return index;
    }
}
