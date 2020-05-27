
import java.util.Arrays;

/**
 * (Compute the weekly hours for each employee) Suppose the weekly hours for all
 * employees are stored in a two-dimensional array. Each row records an
 * employee’s seven-day work hours with seven columns. For example, the
 * following array stores the work hours for eight employees. Write a program
 * that displays employees and their total hours in decreasing order of the
 * total hours.
 *
 *          Su M T W Th F Sa
 * Employee 0 2 4 3 4 5 8 8
 * Employee 1 7 3 4 3 3 4 4
 * Employee 2 3 3 4 3 3 2 2
 * Employee 3 9 3 4 7 3 4 1
 * Employee 4 3 5 4 3 6 3 8
 * Employee 5 3 4 4 6 3 4 4
 * Employee 6 3 7 4 8 3 8 4
 * Employee 7 6 3 5 9 2 7 9
 *
 * Output:
 *
 * Employee 2 worked 20.0 hours.
 * Employee 1 worked 28.0 hours.
 * Employee 5 worked 28.0 hours.
 * Employee 3 worked 31.0 hours.
 * Employee 4 worked 32.0 hours.
 * Employee 0 worked 34.0 hours.
 * Employee 6 worked 37.0 hours.
 * Employee 7 worked 41.0 hours.
 *
 * @author martinfall
 */
public class WeeklyHoursForEachEmployee {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new array
        double[][] array
                = {{2, 4, 3, 4, 5, 8, 8},
                {7, 3, 4, 3, 3, 4, 4},
                {3, 3, 4, 3, 3, 2, 2},
                {9, 3, 4, 7, 3, 4, 1},
                {3, 5, 4, 3, 6, 3, 8},
                {3, 4, 4, 6, 3, 4, 4},
                {3, 7, 4, 8, 3, 8, 4},
                {6, 3, 5, 9, 2, 7, 9}};

        // Display the array
        displayArray(array);

        // Calculate total hours for each employee
        double[][] hoursWorked = calculateHours(array);

        // Sort the array
        bubbleSort(hoursWorked);

        // Display the results
        printResults(hoursWorked);
    }

    /**
     * Display the original array of daily worked hours in a 2D matrix format
     *
     * @param array
     */
    public static void displayArray(double[][] array) {
        // Display the array
        System.out.println("\t\tSu\tM\tT\tW\tTh\tF\tSa");
        for (int row = 0; row < array.length; row++) {
            System.out.print("Employee " + row + "\t");
            for (int column = 0; column < array[row].length; column++) {
                System.out.print((int) array[row][column] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Calculate the hours worked by each employee
     *
     * @param array
     * @return
     */
    public static double[][] calculateHours(double[][] array) {
        // Create an array to store weekly employee hours total
        double[][] hoursWorked = new double[array.length][2];

        for (int row = 0; row < array.length; row++) {
            // Total variable
            double total = 0;

            for (int column = 0; column < array[row].length; column++) {
                total += array[row][column];
            }
            hoursWorked[row][0] = row;
            hoursWorked[row][1] = total;
        }

        return hoursWorked;
    }

    /**
     * Selection sort the array of hours worked by each employee
     *
     * @param array
     */
    public static void selectionSort(double[][] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex][1] > array[j][1]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                double[] temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    /**
     * Bubble sort the array of hours worked by each employee
     *
     * @param array
     */
    public static void bubbleSort(double[][] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j][1] > array[j + 1][1]) {
                    double[] temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Print the hours worked by each employee as sorted
     *
     * @param array
     */
    public static void printResults(double[][] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.println("Employee " + (int) (array[i][0]) + " worked "
                    + array[i][1] + " hours.");
        }
    }
}
