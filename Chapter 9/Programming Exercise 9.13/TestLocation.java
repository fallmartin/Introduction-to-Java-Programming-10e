
import java.util.Scanner;

/**
 * Output:
 *
 * Enter the number of rows and columns in the array: 3 4
 * Enter the array:
 * 23.5 35 2 10
 * 4.5 3 45 3.5
 * 35 44 5.5 9.6
 *
 * The location of the largest element is 45.000000 at (1, 2)
 *
 * @author martinfall
 */
public class TestLocation {

    public static void main(String[] args) {

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the number of rows and columns in the array
        System.out.print("Enter the number of rows and columns in the array: ");

        // Create a new array
        double[][] array = new double[input.nextInt()][input.nextInt()];

        // Prompt the user to enter each element of the array
        System.out.println("Enter the array: ");
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                array[row][column] = input.nextDouble();
            }
        }

        // Locate the largest element in the two-dimensional array
        Location location = locateLargest(array);

        // Display the result
        String format = "%nThe location of the largest element is %f at (%d, %d)%n";
        System.out.printf(format, location.maxValue, location.row, location.column);
    }

    public static Location locateLargest(double[][] a) {
        Location location = new Location();
        int r = 0, c = 0;
        double max = a[r][c];

        for (int row = 0; row < a.length; row++) {
            for (int column = 0; column < a[row].length; column++) {
                if (a[row][column] > max) {
                    r = row;
                    c = column;
                    max = a[row][column];
                }
            }
        }

        location.row = r;
        location.column = c;
        location.maxValue = max;

        return location;
    }
}
