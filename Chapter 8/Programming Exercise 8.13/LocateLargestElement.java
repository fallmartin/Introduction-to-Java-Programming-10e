
import java.util.Scanner;

/**
 * (Locate the largest element) Write the following method that returns the
 * location of the largest element in a two-dimensional array.
 *
 * public static int[] locateLargest(double[][] a)
 *
 * The return value is a one-dimensional array that contains two elements. These
 * two elements indicate the row and column indices of the largest element in
 * the
 * two-dimensional array. Write a test program that prompts the user to enter a
 * two-dimensional array and displays the location of the largest element in the
 * array. Here is a sample run:
 *
 * Enter the number of rows and columns of the array: 3 4
 * Enter the array:
 * 23.5 35 2 10
 * 4.5 3 45 3.5
 * 35 44 5.5 9.6
 * The location of the largest element is at (1, 2)
 *
 * @author martinfall
 */
public class LocateLargestElement {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to nter the number of rows and columns of the array
        System.out.print("Enter the number of rows and columns of the array: ");
        int rows = input.nextInt();
        int columns = input.nextInt();

        // Create and populate the array
        double[][] array = populateArray(rows, columns);

        // Print results
        printResults(findLargestElement(array));
    }

    public static double[][] populateArray(int rows, int columns) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Create a new array
        double[][] array = new double[rows][columns];

        // Populate the array
        System.out.println("Enter the array: ");
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                array[row][column] = input.nextDouble();
            }
        }
        return array; // Return the populated array
    }

    public static int[] findLargestElement(double[][] array) {
        // two elements indicate the row and column indices of the largest element
        int[] coordinates = new int[2];
        // Starting pointt
        coordinates[0] = 0;
        coordinates[1] = 0;

        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                if (array[row][column] > array[coordinates[0]][coordinates[1]]) {
                    coordinates[0] = row;
                    coordinates[1] = column;
                }
            }
        }

        return coordinates;
    }

    public static void printResults(int[] coordinates) {
        String format = "The location of the largest element is at (%d, %d)%n";
        System.out.printf(format, coordinates[0], coordinates[1]);
    }
}
