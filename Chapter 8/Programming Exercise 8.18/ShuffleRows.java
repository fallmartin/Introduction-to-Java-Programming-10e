
import java.util.Arrays;

/**
 * (Shuffle rows) Write a method that shuffles the rows in a two-dimensional int
 * array using the following header:
 *
 * public static void shuffle(int[][] m)
 *
 * Write a test program that shuffles the following matrix:
 *
 * int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
 *
 * @author martinfall
 */
public class ShuffleRows {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
        System.out.println(Arrays.deepToString(m));

        // Shuffle array
        shuffle(m);
        System.out.println(Arrays.deepToString(m));
    }

    /**
     * Shuffle the rows in a two-dimensional int array
     *
     * @param m
     */
    public static void shuffle(int[][] m) {
        for (int row = 0; row < m.length; row++) {
            // Generate a random index
            int randomIndex = (int) (Math.random() * m.length);

            // Swap the row at the current index with the one at the random index
            int[] temp = m[row];
            m[row] = m[randomIndex];
            m[randomIndex] = temp;
        }
    }
}
