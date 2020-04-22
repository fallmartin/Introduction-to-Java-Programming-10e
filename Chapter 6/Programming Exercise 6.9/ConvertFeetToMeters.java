
/**
 * ﻿(Conversions between feet and meters) Write a class that contains the following
 * two methods:
 *
 * Convert from feet to meters
 * public static double footToMeter(double foot)
 *
 * Convert from meters to feet
 * public static double meterToFoot(double meter)
 *
 * The formula for the conversion is:
 *
 * meter = 0.305 * foot
 * foot = 3.279 * meter
 *
 * Write a test program that invokes these methods to display the following tables:
 * see textbook for example
 *
 * @author martinfall
 */
public class ConvertFeetToMeters {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        displayTableHeader();
        displayTableBody();
    }

    /**
     * Convert from feet to meters
     *
     * @param foot
     * @return
     */
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    /**
     * Convert from meters to feet
     *
     * @param meter
     * @return
     */
    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

    private static void displayTableHeader() {
        System.out.printf("%-15s%-15s%-10s%-15s%-15s%n",
                "Feet", "Meters", "|", "Meters", "Feet");
        for (int i = 0; i < 72; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static void displayTableBody() {
        for (double foot = 1, meter = 20; // Initial statement
                foot <= 10 && meter <= 65; // Loop continuation condition
                foot++, meter += 5) { // Action after each iteration or update
            System.out.printf("%-15.1f%-15.3f%-10s%-15.1f%-15.3f%n",
                    foot, footToMeter(foot),
                    "|",
                    meter, meterToFoot(meter));
        }
        System.out.println();
    }
}
