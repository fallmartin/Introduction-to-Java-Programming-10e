
/**
 * (Execution time) Write a program that randomly generates an array of 100,000
 * integers and a key. Estimate the execution time of invoking the linearSearch
 * method in Listing 7.6. Sort the array and estimate the execution time of
 * invoking the binarySearch method in Listing 7.7. You can use the following
 * code template to obtain the execution time:
 *
 * long startTime = System.currentTimeMillis(); perform the task; long endTime =
 * System.currentTimeMillis(); long executionTime = endTime - startTime;
 *
 * Assumption: the integers that the programs generate are in the 0 to 99,999
 * range
 *
 * @author martinfall
 */
public class ExecutionTime {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        /* DECLARE AND CREATE A NEW ARRAY */
        final int NUMBER_OF_INTEGERS = 100000;
        int[] list = new int[NUMBER_OF_INTEGERS];
        int index = 0; // For printing the returned index

        /* GENERATE A KEY AND POPULATE THE ARRAY */
        // Generate a key
        int key = generateKey(list);
        // Populate the array
        list = generateArray(list);

        /* LINEAR SEARCH EXECUTION TIME */
        long startTime = System.currentTimeMillis();
        index = linearSearch(list, key);
        long endTime = System.currentTimeMillis();
        // Execution time
        long executionTime = endTime - startTime;

        System.out.print("Execution time of invoking the linearSearch method "
                + "in milliseconds:");
        System.out.println(executionTime);
        System.out.println(index);

        /* SELECTION SORT EXECUTION TIME */
        startTime = System.currentTimeMillis();
        selectionSort(list);
        endTime = System.currentTimeMillis();
        // Execution time
        executionTime = endTime - startTime;

        System.out.print("Execution time of invoking the selectionSort method "
                + "in milliseconds:");
        System.out.println(executionTime);

        /* BINARY SEARCH EXECUTION TIME */
        // Call binary search after sorting the array in the method calls above
        startTime = System.currentTimeMillis();
        index = binarySearch(list, key);
        endTime = System.currentTimeMillis();
        // Execution time
        executionTime = endTime - startTime;

        System.out.print("Execution time of invoking the binarySearch method "
                + "in milliseconds:");
        System.out.println(executionTime);
        System.out.println(index);
    }

    /**
     * Populate an array with the given number of integers
     *
     * @param list
     * @return
     */
    public static int[] generateArray(int[] list) {
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random() * list.length);
        }
        return list;
    }

    /**
     * Generate a key in the given range
     *
     * @return
     */
    public static int generateKey(int[] list) {
        return (int) (Math.random() * list.length);
    }

    /**
     * Search for key in list using linear search
     *
     * @param list
     * @param key
     * @return
     */
    public static int linearSearch(int[] list, int key) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Sort an array using a selection sort algorithm
     *
     * @param list
     */
    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            // Find the minimum in the list array 
            int currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) { // I thought that >= was required, but no
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            // Swap values if a smaller number was found
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    /**
     * Search for key in list using binary search
     *
     * @param list
     * @param key
     * @return
     */
    public static int binarySearch(int[] list, int key) {
        int low = 0; // Set low to the first element
        int high = list.length - 1; // Set high to the last element

        while (high >= low) { // While high is greater than or equal to low
            int mid = low + ((high - low) / 2); // Calculate mid

            if (key < list[mid]) { // If key comes before mid
                high = mid - 1;
            } else if (key == list[mid]) { // If key is mid
                return mid;
            } else {
                low = mid + 1; // If key comes after mid
            }
        }
        return -(low + 1); // The key was not found and high < low
    }
}
