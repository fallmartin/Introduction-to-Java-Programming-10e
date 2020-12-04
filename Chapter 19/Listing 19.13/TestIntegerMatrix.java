
/**
 * Test Integer matrix.
 *
 * Output:
 *
 * m1 + m2 is
 * 1 2 3      1 1 1     2 3 4
 * 4 5 6  +   2 2 2  =  6 7 8
 * 1 1 1      0 0 0     1 1 1
 *
 * m1 * m2 is
 * 1 2 3      1 1 1     5 5 5
 * 4 5 6  *   2 2 2  =  14 14 14
 * 1 1 1      0 0 0     3 3 3
 *
 * @author martinfall
 */
public class TestIntegerMatrix {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create Integer arrays m1 and m2
        Integer[][] m1 = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {1, 1, 1}};
        Integer[][] m2 = new Integer[][]{{1, 1, 1}, {2, 2, 2}, {0, 0, 0}};

        // Create an instance of IntegerMatrix
        IntegerMatrix integerMatrix = new IntegerMatrix();

        System.out.println("\nm1 + m2 is ");
        GenericMatrix.printResult(m1, m2, integerMatrix.addMatrix(m1, m2), '+');

        System.out.println("\nm1 * m2 is ");
        GenericMatrix.printResult(m1, m2, integerMatrix.multiplyMatrix(m1, m2), '*');
    }
}
