
import java.util.Scanner;

/**
 * (Central city) Given a set of cities, the central city is the city that has
 * the shortest total distance to all other cities. Write a program that prompts
 * the user to enter the number of the cities and the locations of the cities
 * (coordinates), and finds the central city and its total distance to all other
 * cities.
 *
 * Enter the number of cities: 5
 * Enter the coordinates of the cities:
 * 2.5 5 5.1 3 1 9 5.4 54 5.5 2.1
 * The central city is at (2.5, 5.0)
 * The total distance to all other cities is 60.81
 *
 * Output:
 * Enter the number of cities: 5
 * Enter the coordinates of the cities:
 * 2.5 5 5.1 3 1 9 5.4 54 5.5 2.1
 * The central city is at (2.5, 5.0)
 * The total distance to all other cities is 60.81
 *
 * @author martinfall
 */
public class CentralCity {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Create a new array
        double[][] cities = createArray(input);

        // Find the central point's index and total distance to all other cities
        double result[] = findShortestDistance(cities);

        int index = (int) result[0];
        double shortestTotalDistance = result[1];

        // Display the results
        displayResults(index, shortestTotalDistance, cities);
    }

    /**
     * Find the central point in the array of coordinates
     *
     * @param cities
     * @return
     */
    public static double[] findShortestDistance(double[][] cities) {
        // Shortest totalDistance index and value
        double[] result = new double[2];

        // Set the index to -1
        int index = -1;
        // Set the shortest distance to the largest possible value for a double data type
        double shortestTotalDistance = Double.MAX_VALUE;

        // Loop through all points in the cities array
        for (int i = 0; i < cities.length; i++) {
            double totalDistance = 0;
            for (int j = 0; j < cities.length; j++) {
                totalDistance += java.awt.geom.Point2D.distance(cities[i][0], cities[i][1], // x1, y1
                        cities[j][0], cities[j][1]); // x2, y2
            }

            if (totalDistance < shortestTotalDistance) {
                index = i;
                shortestTotalDistance = totalDistance;
            }
        }
        result[0] = index;
        result[1] = shortestTotalDistance;

        return result;
    }

    /**
     * Create the array using the scanner object created in main
     *
     * @param input
     * @return
     */
    public static double[][] createArray(Scanner input) {
        // Prompt the user to enter the number of cities
        System.out.print("Enter the number of cities: ");

        // Create a new array
        double[][] cities = new double[input.nextInt()][2];

        // Populate the array
        System.out.println("Enter the coordinates of the cities:");
        for (int row = 0; row < cities.length; row++) {
            for (int column = 0; column < cities[row].length; column++) {
                cities[row][column] = input.nextDouble();
            }
        }
        return cities;
    }

    /**
     * Display the results to console in the specified format
     *
     * @param index
     * @param shortestTotalDistance
     * @param cities
     */
    public static void displayResults(int index, double shortestTotalDistance, double[][] cities) {
        System.out.printf("The central city is at (%.1f, %.1f)%n",
                cities[index][0], cities[index][1]);
        System.out.printf("The total distance to all other cities is %.2f%n", shortestTotalDistance);
    }
}
