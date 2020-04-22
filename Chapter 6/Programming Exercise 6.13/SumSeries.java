
/**
 * ﻿(Sum series) Write a method to compute the following series:
 * m(i) = 1/2 + 2/3 + ... + i / (i + 1)
 * Write a test program that displays the following table: see textbook
 *
 * @author martinfall
 */
public class SumSeries {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.printf("%-20s%-20s%n", "i", "m(i)");
        System.out.println("--------------------------");
        for (int i = 1; i <= 20; i++) {
            System.out.printf("%-20d%-20.4f%n", i, sumSeries(i));
        }
    }

    /**
     * Compute the series m(i) = 1/2 + 2/3 + ... + i/(i+1)
     *
     * @param number
     * @return
     */
    public static double sumSeries(int number) {
        double m = 0;
        for (double i = 1, j = 2; i <= number; i++, j++) {
            m += i / j;
        }
        return m;
    }
}
