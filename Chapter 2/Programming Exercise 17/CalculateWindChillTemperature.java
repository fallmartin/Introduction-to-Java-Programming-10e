/*
(Science: wind-chill temperature) How cold is it outside? The temperature alone
is not enough to provide the answer. Other factors including wind speed, relative
humidity, and sunshine play important roles in determining coldness outside.
In 2001, the National Weather Service (NWS) implemented the new wind-chill
temperature to measure the coldness using temperature and wind speed. The
formula is

twc = 35.74 + 0.6215 * outsideTemperatureInFahrenheit - 
        35.75 * Math.pow(windSpeed, 0.16) + 
        0.4275 * outsideTemperatureInFahrenheit * Math.pow(windSpeed, 0.16)

where ta is the outside temperature measured in degrees Fahrenheit and v is the
speed measured in miles per hour. twc is the wind-chill temperature. The formula
cannot be used for wind speeds below 2 mph or temperatures below -58 ºF or
above 41ºF.

Write a program that prompts the user to enter a temperature between -58 ºF and
41ºF and a wind speed greater than or equal to 2 and displays the wind-chill temperature.
Use Math.pow(a, b) to compute v0.16. 

Here is a sample run:

Enter the temperature in Fahrenheit between -58°F and 41°F: 5.3
Enter the wind speed (>=2) in miles per hour: 6
The wind chill index is -5.56707

Actual output:
Enter the temperature in Fahrenheit between -58°F and 41°F: 5.3
Enter the wind speed (>=2) in miles per hour: 6
The wind chill index is -5.567068455881625
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class CalculateWindChillTemperature {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the temperature in Fahrenheit 
        // between -58°F and 41°F: 
        System.out.print("Enter the temperature in Fahrenheit between -58°F and 41°F: ");
        double outsideTemperatureInFahrenheit = input.nextDouble();

        // Prompt the user to enter the wind speed (>=2) in miles per hour: 
        System.out.print("Enter the wind speed (>=2) in miles per hour: ");
        double windSpeed = input.nextDouble();

        // Calculate the wind-chill temperature
        double windChillTemperature = 35.74 + 0.6215 * outsideTemperatureInFahrenheit
                - 35.75 * Math.pow(windSpeed, 0.16)
                + 0.4275 * outsideTemperatureInFahrenheit * Math.pow(windSpeed, 0.16);

        // Display the results
        System.out.println("The wind chill index is " + windChillTemperature);
    }
}
