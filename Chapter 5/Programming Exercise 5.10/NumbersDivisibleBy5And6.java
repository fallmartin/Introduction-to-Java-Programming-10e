
/**
 * ﻿(Find numbers divisible by 5 and 6) Write a program that displays all the
 * numbers from 100 to 1,000, ten per line, that are divisible by 5 and 6.
 * Numbers are separated by exactly one space.
 *
 * Output:
 *
 * 120 150 180 210 240 270 300 330 360 390
 * 420 450 480 510 540 570 600 630 660 690
 * 720 750 780 810 840 870 900 930 960 990
 */
/**
 *
 * @author martinfall
 */
public class NumbersDivisibleBy5And6 {

    public static void main(String[] args) {
        // Constant variables
        final int NUMBERS_PER_LINE = 10;
        final int STARTING_NUMBER = 100;
        final int ENDING_NUMBER = 1000;

        int counter = 0; // counter variables to determine new line insertions

        // Loop through all the numbers from 100 to 1,000
        for (int i = STARTING_NUMBER; i <= ENDING_NUMBER; i++) {
            if (i % 5 == 0 && i % 6 == 0) {
                System.out.print(i + " ");
                counter++;
                if (counter % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }
}
