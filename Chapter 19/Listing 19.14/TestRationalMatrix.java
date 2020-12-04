
/**
 * Test Rational matrix.
 *
 * Output:
 *
 * m1 + m2 is
 * 1/5 1/6 1/7      1/6 1/7 1/8     11/30 13/42 15/56
 * 2/5 1/3 2/7  +   1/3 2/7 1/4  =  11/15 13/21 15/28
 * 3/5 1/2 3/7      1/2 3/7 3/8     11/10 13/14 45/56
 *
 * m1 * m2 is
 * 1/5 1/6 1/7      1/6 1/7 1/8     101/630 101/735 101/840
 * 2/5 1/3 2/7  *   1/3 2/7 1/4  =  101/315 202/735 101/420
 * 3/5 1/2 3/7      1/2 3/7 3/8     101/210 101/245 101/280
 *
 * @author martinfall
 */
public class TestRationalMatrix {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create two Rational arrays m1 and m2
        Rational[][] m1 = new Rational[3][3];
        Rational[][] m2 = new Rational[3][3];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                m1[i][j] = new Rational(i + 1, j + 5);
                m2[i][j] = new Rational(i + 1, j + 6);
            }
        }

        // Create an instance of RationalMatrix
        RationalMatrix rationalMatrix = new RationalMatrix();

        System.out.println("\nm1 + m2 is ");
        GenericMatrix.printResult(
                m1, m2, rationalMatrix.addMatrix(m1, m2), '+');

        System.out.println("\nm1 * m2 is ");
        GenericMatrix.printResult(
                m1, m2, rationalMatrix.multiplyMatrix(m1, m2), '*');
    }
}
