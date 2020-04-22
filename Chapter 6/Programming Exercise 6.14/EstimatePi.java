
/**
 * ﻿Write a method that returns m(i) for a given i and write a test program that
 * displays the following table:
 *
 * @author martinfall
 */
public class EstimatePi {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Display table headers
        System.out.printf("%-20s%-20s%n", "i", "m(i)");
        System.out.println("----------------------------------------");

        // Display table body
        for (int i = 1; i <= 901; i = i + 100) {
            System.out.printf("%-20d%-20.4f%n", i, m(i));
        }
    }

    /**
     * Compute the series
     *
     * @param i
     * @return
     */
    public static double m(int number) {
        double m = 0;

        for (int i = 1; i <= number; i++) {
            m += Math.pow(-1, (i + 1)) / (2 * i - 1);
        }

        return 4 * m;
    }
}
