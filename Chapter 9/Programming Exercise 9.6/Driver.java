
import java.util.Arrays;
import java.util.Random;

/**
 * Write a test program that measures the execution time of sorting 100,000
 * numbers using selection sort
 *
 * Output:
 * Starting stopwatch
 * Stopwatch stopped
 * Elapsed time: 7563
 *
 * @author martinfall
 */
public class Driver {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Stopwatch object
        Stopwatch s = new Stopwatch();

        // Create a Random object to generate random elements for int array
        Random r = new Random();

        // Create an array of int type with length 100,000
        int[] arr = new int[100000];

        // Populate arraw with random integers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(1000000); // Not specified
            // Comment the statement above and uncomment the one below for
            // unbound random int generation
            // arr[i] = r.nextInt();
        }

        // Display the randomly populated array
        // System.out.println(Arrays.toString(arr));
        // Start the stopwatch
        System.out.println("Starting stopwatch");
        s.start();

        // Selection sort
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }

        // Stop the stopwatch
        s.stop();
        System.out.println("Stopwatch stopped");

        // Display the sorted populated array
        // System.out.println(Arrays.toString(arr));
        // Get the elapsed time
        System.out.println("Elapsed time: " + s.getElapsedTime());
    }
}
