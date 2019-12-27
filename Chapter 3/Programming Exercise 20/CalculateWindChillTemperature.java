
/**
 * (Science: wind-chill temperature) Programming Exercise 2.17 gives a formula to
 * compute the wind-chill temperature. The formula is valid for temperatures in
 * the range between −58ºF and 41ºF and wind speed greater than or equal to 2.
 *
 * Write a program that prompts the user to enter a temperature and a wind speed.
 * The program displays the wind-chill temperature if the input is valid;
 * otherwise, it displays a message indicating whether the temperature and/or
 * wind speed is invalid.
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

        // Test the input
        if (outsideTemperatureInFahrenheit > -58
                && outsideTemperatureInFahrenheit < 41
                && windSpeed >= 2) {
            // Calculate the wind-chill temperature
            double windChillTemperature = 35.74 + 0.6215 * outsideTemperatureInFahrenheit
                    - 35.75 * Math.pow(windSpeed, 0.16)
                    + 0.4275 * outsideTemperatureInFahrenheit * Math.pow(windSpeed, 0.16);

            // Display the results
            System.out.println("The wind chill index is " + windChillTemperature);
        } else {
            if (outsideTemperatureInFahrenheit < -58
                    || outsideTemperatureInFahrenheit > 41) {
                System.out.println("The temperature is invalid");
            }
            if (windSpeed <= 2) {
                System.out.println("The wind speed is invalid");
            }
        }
    }
}
