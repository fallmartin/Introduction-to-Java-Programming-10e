
/**
 * ﻿(Find the largest n such that n3 < 12,000) Use a while loop to find the largest
 * integer n such that n3 is less than 12,000.
 *
 * Output:
 * The largest n such that n^3 < 12,000 is 22
 *
 */
/**
 *
 * @author martinfall
 */
public class LargestN {

    public static void main(String[] args) {
        final int LIMIT = 12000;
        int n = 1; // Easy to determine that n > 100 since 100^2 = 10,000
        while (Math.pow(n, 3) < LIMIT) {
            n++;
        }
        System.out.println("The largest n such that n^3 < 12,000 is " + (n - 1));
    }
}
