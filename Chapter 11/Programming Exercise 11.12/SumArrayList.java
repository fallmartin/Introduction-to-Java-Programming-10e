
import java.util.ArrayList;
import java.util.Scanner;

/**
 * (Sum ArrayList) Write the following method that returns the sum of all
 * numbers
 * in an ArrayList:
 *
 * public static double sum(ArrayList<Double> list)
 *
 * Write a test program that prompts the user to enter 5 numbers, stores them in
 * an array list, and displays their sum.
 *
 * Output:
 * Enter 5 numbers: 2.3 1.7 7.12 6.0 3.45
 * Sum of all numbers in the list: 20.57
 *
 * @author martinfall
 */
public class SumArrayList {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object.
        Scanner input = new Scanner(System.in);

        // Create a new ArrayList
        ArrayList<Double> list = new ArrayList<>();

        // Promt the user to enter 5 numbers.
        System.out.print("Enter 5 numbers: ");

        // Store 5 user entries in the array list
        for (int i = 0; i < 5; i++) {
            list.add(input.nextDouble());
        }

        // Display the sum of all numbers in the ArrayList
        System.out.println("Sum of all numbers in the list: " + sum(list));
    }

    /**
     * Returns the sum of all numbers in an ArrayList.
     *
     * @param list
     * @return 
     */
    public static double sum(ArrayList<Double> list) {
        double sum = 0;

        for (double d : list) {
            sum += d;
        }
        return sum;
    }
}
