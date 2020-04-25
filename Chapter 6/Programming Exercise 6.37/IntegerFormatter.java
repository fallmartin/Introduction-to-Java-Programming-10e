
/**
 * ﻿(Format an integer) Write a method with the following header to format the
 * integer with the specified width.
 *
 * public static String format(int number, int width)
 *
 * The method returns a string for the number with one or more prefix 0s. The size
 * of the string is the width. For example, format(34, 4) returns 0034 and
 * format(34, 5) returns 00034. If the number is longer than the width, the method
 * ﻿returns the string representation for the number. For example, format(34, 1)
 * returns 34.
 *
 * Output:
 *
 * 0034
 * 00034
 * 34
 *
 * @author martinfall
 */
public class IntegerFormatter {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(format(34, 4));
        System.out.println(format(34, 5));
        System.out.println(format(34, 1));
    }

    /**
     * Format the integer with the specified width
     *
     * @param number
     * @param width
     * @return
     */
    public static String format(int number, int width) {
        String numString = Integer.toString(number);

        if (numString.length() < width) {
            while (numString.length() < width) {
                numString = "0" + numString;
            }
        }

        return numString;
    }
}
