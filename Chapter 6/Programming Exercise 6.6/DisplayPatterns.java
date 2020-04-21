
/**
 * ﻿(Display patterns) Write a method to display a pattern as follows:
 *               1
 *             2 1
 *           3 2 1
 *             ...
 * n n-1 ... 3 2 1
 * The method header is public static void displayPattern(int n)
 *
 * Output:
 *                                    1
 *                                2   1
 *                            3   2   1
 *                        4   3   2   1
 *                    5   4   3   2   1
 *                6   5   4   3   2   1
 *            7   6   5   4   3   2   1
 *        8   7   6   5   4   3   2   1
 *    9   8   7   6   5   4   3   2   1
 */
/**
 *
 * @author martinfall
 */
public class DisplayPatterns {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        displayPattern(9);
    }

    /**
     * Display the pattern
     *
     * @param n
     */
    public static void displayPattern(int n) {
        for (int i = 1; i <= n; i++) {
            // Print blanks
            for (int blanks = 0; blanks < n - i; blanks++) {
                System.out.print("    ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.printf("%4d", j);
            }
            System.out.println();
        }
    }
}
