
import java.util.Scanner;

/**
 * Output:
 * 
 * Day 0's average temperature is 77.77083333333336
 * Day 0's average humidity is 0.9295833333333331
 * Day 1's average temperature is 77.31250000000003
 * Day 1's average humidity is 0.9295833333333331
 * Day 2's average temperature is 77.64583333333336
 * Day 2's average humidity is 0.9295833333333331
 * Day 3's average temperature is 77.64583333333336
 * Day 3's average humidity is 0.9295833333333331
 * Day 4's average temperature is 77.64583333333336
 * Day 4's average humidity is 0.9295833333333331
 * Day 5's average temperature is 77.64583333333336
 * Day 5's average humidity is 0.9295833333333331
 * Day 6's average temperature is 77.64583333333336
 * Day 6's average humidity is 0.9295833333333331
 * Day 7's average temperature is 77.68750000000003
 * Day 7's average humidity is 0.9295833333333331
 * Day 8's average temperature is 77.64583333333336
 * Day 8's average humidity is 0.9295833333333331
 * Day 9's average temperature is 79.3541666666667
 * Day 9's average humidity is 0.9124999999999998
 * @author martinfall
 */
public class Weather {
    public static void main(String[] args) {
        final int NUMBER_OF_DAYS = 10;
        final int NUMBER_OF_HOURS = 24;
        double[][][] data = new double[NUMBER_OF_DAYS][NUMBER_OF_HOURS][2];
        
        Scanner input = new Scanner(System.in);
        // Read input using input redirection from a file
        for (int k = 0; k < NUMBER_OF_DAYS * NUMBER_OF_HOURS; k++) {
            int day = input.nextInt();
            int hour = input.nextInt();
            double temperature = input.nextDouble();
            double humidity = input.nextDouble();
            data[day - 1][hour - 1][0] = temperature;
            data[day - 1][hour - 1][1] = humidity;
        }
        
        // Find the average daily temperature and humidity
        for (int i = 0; i < NUMBER_OF_DAYS; i++) {
            double dailyTemperatureTotal = 0, dailyHumidityTotal = 0;
            for (int j = 0; j < NUMBER_OF_HOURS; j++) {
                dailyTemperatureTotal += data[i][j][0];
                dailyHumidityTotal += data[i][j][1];
            }
            
        // Display result
        System.out.println("Day " + i + "'s average temperature is "
        + dailyTemperatureTotal / NUMBER_OF_HOURS);
        System.out.println("Day " + i + "'s average humidity is "
        + dailyHumidityTotal / NUMBER_OF_HOURS);
        } 
    }
}
