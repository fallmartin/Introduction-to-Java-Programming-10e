
import java.util.*;

/**
 * (Maximum element in a two-dimensional array) Write a generic method that
 * returns the maximum element in a two-dimensional array.
 *
 * public static <E extends Comparable<E>> E max(E[][] list)
 *
 * Output:
 * 26.54	9.84	0.33	13.85	54.75	1.58	6.4	58.91	18.15	4.28
 * 0.29	12.73	0.82	80.51	30.82	2.53	13.47	10.57	19.12	63.76
 * 59.47	9.93	39.08	56.7	8.79	48.75	51.06	1.36	45.19	61.88
 * 25.98	86.3	48.65	26.88	2.74	41.06	7.12	1.49	28.79	4.8
 * 32.95	74.07	25.34	75.42	2.43	45.68	20.88	35.34	24.6	30.21
 * 3.46	0.23	15.64	2.99	5.16	0.82	21.54	56.36	16.02	7.81
 * 38.57	13.38	21.62	16.65	23.77	63.44	25.71	3.79	0.99	9.91
 * 2.77	3.18	9.78	11.52	12.6	2.0	51.16	6.34	10.8	7.47
 * 15.73	56.35	59.25	15.65	4.53	3.13	31.69	13.47	57.72	1.82
 * 6.91	42.45	0.41	3.95	37.28	32.44	31.61	0.72	34.9	27.8
 * The maximum element is 86.3
 *
 * @author martinfall
 */
public class MaximumElement2D {

    private final static int ROWS = 10;
    private final static int COLUMNS = 10;

    public static void main(String[] args) {
        // Create a new two-dimensional array
        Double[][] array = new Double[ROWS][COLUMNS];

        // Populate the two-dimensional array with double values
        Random random = new Random();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                array[i][j]
                        = ((int) (random.nextDouble() * random.nextInt(10000)))
                        / 100.00;
            }
        }

        // Display the array to console
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("The maximum element is " + max(array));
    }

    public static <E extends Comparable<E>> E max(E[][] list) {
        E o = list[0][0];

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j].compareTo(o) >= 1) {
                    o = list[i][j];
                }
            }
        }
        return o;
    }
}
