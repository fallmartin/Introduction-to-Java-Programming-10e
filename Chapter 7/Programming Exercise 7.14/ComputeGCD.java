
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Computing gcd) Write a method that returns the gcd of an unspecified number
 * of integers. The method header is specified as follows:
 *
 * public static int gcd(int... numbers)
 *
 * Write a test program that prompts the user to enter five numbers, invokes the
 * method to find the gcd of these numbers, and displays the gcd.
 *
 * @author martinfall
 */
public class ComputeGCD {

    /**
     * Main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        int[] array = new int[5];
        
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        
        // Display the result
        System.out.println("The gcd of " + Arrays.toString(array) + " is " +
                gcd(array));
    }
    
    /**
     * Determine the gcd of an unspecified number of integers
     *
     * @param numbers
     * @return
     */
    public static int gcd(int... numbers) {
        int gcd = 1; // Starting gcd is 1
        boolean flag; // Boolean flag 

        for (int i = 2; i < findMin(numbers); i++) {
            flag = true;

            for (int number : numbers) {
                if (number % i != 0) {
                    flag = false; // Not a gcd
                }
            }

            if (flag) {
                gcd = i;
            }
        }

        return gcd;
    }

    /**
     * Find the smallest number in the array
     *
     * @param numbers
     * @return
     */
    public static int findMin(int... numbers) {
        Arrays.sort(numbers); // Sort the array
        return numbers[0]; // Return the first element of the array
    }
}
