
/**
 * (Conversions between Celsius and Fahrenheit) Write a class that contains the
 * following two methods:
 *
 * Convert from Celsius to Fahrenheit
 * public static double celsiusToFahrenheit(double celsius)
 *
 * Convert from Fahrenheit to Celsius
 * public static double fahrenheitToCelsius(double fahrenheit)
 *
 * ﻿The formula for the conversion is:
 * fahrenheit = (9.0 / 5) * celsius + 32
 * celsius = (5.0 / 9) * (fahrenheit – 32)
 *
 * ﻿Write a test program that invokes these methods to display the following tables:
 * see textbook for example
 */
/**
 *
 * @author martinfall
 */
public class ConvertCelsiusToFahrenheit {

    public static void main(String[] args) {
        displayTableHeader();
        displayTableBody();

    }

    /**
     * Convert from Celsius to Fahrenheit
     *
     * @param celsius
     * @return
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (9.0 / 5) * celsius + 32;
    }

    /**
     * Convert from Fahrenheit to Celsius
     *
     * @param fahrenheit
     * @return
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (5.0 / 9) * (fahrenheit - 32);
    }

    /**
     * Display table header
     */
    public static void displayTableHeader() {
        System.out.printf("%-15s%-15s%-10s%-15s%-15s%n",
                "Celsius", "Fahrenheit", "|", "Fahrenheit", "Celsius");
        for (int i = 0; i < 72; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Display table body
     */
    public static void displayTableBody() {
        for (double celsius = 40, fahrenheit = 120; // Initial statement
                celsius >= 31 && fahrenheit >= 30; // Loop continuation condition
                celsius -= 1, fahrenheit -= 10) { // Action after each iteration or update
            System.out.printf("%-15.1f%-15.1f%-10s%-15.1f%-15.2f%n",
                    celsius, celsiusToFahrenheit(celsius),
                    "|",
                    fahrenheit, fahrenheitToCelsius(fahrenheit));
        }
        System.out.println();
    }
}
