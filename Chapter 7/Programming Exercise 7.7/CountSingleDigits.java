
/**
 * (Count single digits) Write a program that generates 100 random integers between
 * 0 and 9 and displays the count for each number. (Hint: Use an array of ten
 * integers, say counts, to store the counts for the number of 0s, 1s, ..., 9s.)
 *
 * Output:
 *
 * The digit 0 appears 11 times.
 * The digit 1 appears 11 times.
 * The digit 2 appears 7 times.
 * The digit 3 appears 16 times.
 * The digit 4 appears 8 times.
 * The digit 5 appears 7 times.
 * The digit 6 appears 13 times.
 * The digit 7 appears 4 times.
 * The digit 8 appears 13 times.
 * The digit 9 appears 10 times.
 *
 * @author martinfall
 */
public class CountSingleDigits {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        final int NUMBER_OF_INTEGERS = 100;
        // Generate 100 random integers between 0 and 9
        int[] populatedArray = generate100RandomIntegers(NUMBER_OF_INTEGERS);

        // Count each instance of each digit
        int[] counterArray = countEachInteger(populatedArray);

        // Display the count for each number
        printResults(counterArray);
    }

    /**
     * Generate 100 random integers
     *
     * @param NUMBER_OF_INTEGERS
     * @return
     */
    public static int[] generate100RandomIntegers(int NUMBER_OF_INTEGERS) {
        int[] array = new int[NUMBER_OF_INTEGERS];

        for (int i = 0; i < NUMBER_OF_INTEGERS; i++) {
            array[i] = (int) (Math.random() * 10);
            // System.out.println(array[i]);
        }
        return array;
    }

    /**
     * Count each instance of each digit between 0 and 9
     *
     * @param populatedArray
     * @return
     */
    public static int[] countEachInteger(int[] populatedArray) {
        int[] array = new int[10];

        for (int i = 0; i < populatedArray.length; i++) {
            array[populatedArray[i]]++;
        }

        return array;
    }

    /**
     * Print the results
     *
     * @param counterArray
     */
    public static void printResults(int[] counterArray) {
        String format = "The digit %d appears %d times.%n";

        for (int i = 0; i < counterArray.length; i++) {
            System.out.printf(format, i, counterArray[i]);
        }
    }
}
