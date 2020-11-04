
/**
 * (Sum series) Write a recursive method to compute the following series:
 *
 * m(i) = 1/3 + 2/5 + 3/7 + 4/9 + 5/11 + 6/13 + ... + i/(2i + 1)
 *
 * Write a test program that displays m(i) for i = 1, 2, . . ., 10.
 *
 * Output:
 * m(1) = 0.3333333333333333
 * m(2) = 0.7333333333333334
 * m(3) = 1.1619047619047618
 * m(4) = 1.6063492063492064
 * m(5) = 2.060894660894661
 * m(6) = 2.5224331224331222
 * m(7) = 2.9890997890997886
 * m(8) = 3.4596880243939063
 * m(9) = 3.9333722349202223
 * m(10) = 4.409562711110699
 *
 * @author martinfall
 */
public class SumSeries {

    /**
     * Returns the sum of the elements in the series up to index i.
     *
     * @param i
     * @return
     */
    public static double m(int i) {
        return m(i, 1.0 / 3);
    }

    /**
     * Recursive helper method with auxiliary parameters.
     *
     * @param i
     * @param result
     * @return
     */
    public static double m(int i, double result) {
        if (i == 1) {
            return result;
        } else {
            return m(i - 1, result + i / (2.0 * i + 1));
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("m(" + i + ") = " + m(i));
        }
    }
}
