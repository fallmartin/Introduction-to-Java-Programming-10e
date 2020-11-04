
/**
 * (Sum series) Write a recursive method to compute the following series:
 *
 * m(i) = 1/2 + 2/3 + ... + i / (i + 1)
 *
 * Write a test program that displays m(i) for i = 1, 2, . . ., 10.
 *
 * Output:
 *m(1) = 0.5
 * m(2) = 1.1666666666666665
 * m(3) = 1.9166666666666665
 * m(4) = 2.7166666666666663
 * m(5) = 3.5500000000000003
 * m(6) = 4.4071428571428575
 * m(7) = 5.2821428571428575
 * m(8) = 6.171031746031747
 * m(9) = 7.071031746031745
 * m(10) = 7.9801226551226545
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
        return m(i, 1.0 / 2);
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
            return m(i - 1, result + i / (i + 1.0));
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
