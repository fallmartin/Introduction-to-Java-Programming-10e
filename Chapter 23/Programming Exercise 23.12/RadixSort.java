package radixsort;

import java.util.*;

/**
 * (Radix sort) Write a program that randomly generates 1,000,000 integers and
 * sorts them using radix sort.
 *
 * Sample output:
 * [998, 97, 103, 286, 12, 574, 468, 417, 355, 1]
 * [1, 12, 97, 103, 286, 355, 417, 468, 574, 998]
 *
 * @author martinfall
 */
public class RadixSort {

    // private static final int SIZE = 1_000_000;
    private static final int SIZE = 100;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Randomly generate 1,000,000 integers
         */
        // Create a new random object
        Random r = new Random();

        // Remember the largest number
        Integer largestNumber = 0;

        // Create an integer array
        Integer[] integers = new Integer[SIZE];
        for (int i = 0; i < integers.length; i++) {
            Integer randomNumber = r.nextInt(1000);
            integers[i] = randomNumber;

            if (largestNumber < randomNumber) {
                largestNumber = randomNumber;
            }
        }

        // Display the integers to the console
        System.out.println(Arrays.toString(integers));

        // Number of passes of the bucket sort algorithm with a sliding radix
        int maxDigits = largestNumber.toString().length();
        int radixIndex = maxDigits - 1; // 0-based and non-inclusive

        // System.out.println("Number of digits of the largest number: " + maxDigits);
        // System.out.println("Starting radix index: " + radixIndex);
        // Sort the integer array using radix sort
        while (radixIndex >= 0) {
            // Create an array of arraylists for our buckets
            ArrayList<Integer>[] buckets = new ArrayList[10]; // from 0 to 9

            // System.out.println("The radix index is " + radixIndex);
            // System.out.println("--------------------------");
            // Distribute the elements from list to buckets
            for (int i = 0; i < integers.length; i++) {
                // Build a left zero padded string from the current integer
                StringBuilder number = new StringBuilder();
                while (number.length()
                        < maxDigits - integers[i].toString().length()) {
                    number.append(0);
                }
                number.append(integers[i]);

                // Uncomment the line below to display the number to console
                // System.out.println(number);
                // Extract the key at the current radix
                int key = Integer.parseInt(number.charAt(radixIndex) + "");
                // System.out.println(key); // Print the key to the console

                // Instantiate the bucket at key if needed
                if (buckets[key] == null) {
                    buckets[key] = new ArrayList<>();
                }

                // Add the number to the bucket
                buckets[key].add(integers[i]);
            }

            // Now move the elements from the buckets back to list
            int k = 0; // k is the list index
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    for (int j = 0; j < buckets[i].size(); j++) {
                        integers[k] = buckets[i].get(j);
                        k++;
                    }
                }
            }

            radixIndex--; // Decrement the radix index
        }

        // Display the integers to the console
        System.out.println(Arrays.toString(integers));
    }
}
