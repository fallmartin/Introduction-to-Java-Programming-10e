
import java.util.Arrays;

/**
 * (Sort two-dimensional array) Write a method to sort a two-dimensional array
 * using the following header:
 *
 * public static void sort(int m[][])
 *
 * The method performs a primary sort on rows and a secondary sort on columns.
 * For example, the following array
 *
 * {{4, 2},{1, 7},{4, 5},{1, 2},{1, 1},{4, 1}}
 *
 * will be sorted to
 *
 * {{1, 1},{1, 2},{1, 7},{4, 1},{4, 2},{4, 5}}.
 *
 * Output:
 * [[4, 2], [1, 7], [4, 5], [1, 2], [1, 1], [4, 1]]
 * [[1, 1], [1, 2], [1, 7], [4, 1], [4, 2], [4, 5]]
 *
 * @author martinfall
 */
public class SortTwoDimensionalArray {

    public static void main(String[] args) {
        int[][] m = {{4, 2}, {1, 7}, {4, 5}, {1, 2}, {1, 1}, {4, 1}};

        System.out.println(Arrays.deepToString(m));
        sort(m);

        System.out.println(Arrays.deepToString(m));
    }

    /**
     * Sort a two-dimensional array
     *
     * @param m
     */
    public static void sort(int m[][]) {
        // Sort the rows by first element using selection sort
        for (int i = 0; i < m.length - 1; i++) {
            int minRow = i;
            for (int j = i + 1; j < m.length; j++) {
                if (m[minRow][0] >= m[j][0]) {
                    minRow = j;
                }
            }
            if (minRow != i) {
                int[] temp = m[minRow];
                m[minRow] = m[i];
                m[i] = temp;
            }
        }

        // Sort rows by second element also using selections sort
        for (int i = 0; i < m.length - 1; i++) {
            int row = m[i][0];
            for (int j = i + 1; j < m.length; j++) {
                if (m[i][0] == m[j][0]) {
                    if (m[i][1] > m[j][1]) {
                        int temp = m[i][1];
                        m[i][1] = m[j][1];
                        m[j][1] = temp;
                    }
                }
            }
        }
    }
}
