package largestblock;

/**
 * Console Output:
 *
 * The application executed the findLargestBlock method 2394 times to find a
 * randomly generated matrix with a largest block of size 4.
 * ...
 *
 * 0 1 0 1 0 0 0 0 1 1
 * 1 1 0 1 1 0 0 1 0 1
 * 0 0 0 0 1 1 1 1 1 0
 * 0 0 0 1 1 0 1 1 0 0
 * 1 1 1 1 0 1 0 1 0 0
 * 1 1 1 1 1 1 0 1 1 0
 * 1 1 1 1 0 1 1 0 1 0
 * 1 1 1 1 0 1 1 0 0 0
 * 0 0 0 0 0 1 0 0 1 1
 * 1 1 0 1 0 1 1 1 0 0
 * The largest block size is 4 at (4, 0)
 *
 * counter = 2394
 *
 * @author martinfall
 */
public class LargestBlockNoGUI {

    private static final int SIZE = 10;
    private static int[][] matrix = new int[SIZE][SIZE];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int counter = 0;
        int size = 0;

        while (size < 4) {
            initMatrix();
            printMatrix();
            size = findLargestBlock();
            counter++;
        }

        System.out.println("counter = " + counter);
    }

    public static void initMatrix() {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = (int) (Math.random() * 2);
            }
        }
    }

    public static void printMatrix() {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    public static int findLargestBlock() {
        int largestSize = 0;
        int largestRow = -1;
        int largestColumn = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                int currSize = findBlock(row, column);
                if (largestSize < currSize) {
                    largestSize = currSize;
                    largestRow = row;
                    largestColumn = column;
                }
            }
        }

        System.out.print("The largest block size is " + largestSize);
        System.out.println(" at (" + largestRow + ", " + largestColumn + ")\n");

        return largestSize;
    }

    public static int findBlock(int row, int column) {
        int size = 1;
        boolean flag = true;

        while (flag
                && row + size < matrix.length
                && column + size < matrix[row].length) {
            for (int i = row; i < row + size; i++) {
                for (int j = column; j < column + size; j++) {
                    if (matrix[i][j] == 0) {
                        flag = false;
                    }
                }
            }
            if (flag == true) {
                size++;
            } else {
                // System.out.println("size = " + --size);
                // System.out.println("flag = " + flag);
                break;
            }
        }
        return --size;
    }

}
