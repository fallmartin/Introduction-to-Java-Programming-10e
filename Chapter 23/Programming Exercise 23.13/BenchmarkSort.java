package benchmarksort;

import java.util.*;

/**
 * (Execution time for sorting) Write a program that obtains the execution time
 * of selection sort, bubble sort, merge sort, quick sort, heap sort, and radix
 * sort for input size 50,000, 100,000, 150,000, 200,000, 250,000, and 300,000.
 * Your program should create data randomly and print a table like this:
 *
 * (Hint: You can use the following code template to obtain the execution time.)
 *
 * long startTime = System.currentTimeMillis();
 * perform the task;
 * long endTime = System.currentTimeMillis();
 * long executionTime = endTime - startTime;
 *
 * The text gives a recursive quick sort. Write a nonrecursive version in this
 * exercise.
 *
 * @author martinfall
 */
public class BenchmarkSort {

    // Data fields
    private static final int[] inputSizes
            = {50_000, 100_000, 150_000, 200_000, 250_000, 300_000};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Print the table header
        printHeader();

        // For each one of the input sizes in the input sizes array
        for (int size : inputSizes) {
            // Construct and populate an array of integers with random values
            Integer[] list = generateArray(size);

            /*
             * Long array to store the execution times of selection sort,
             * bubble sort, insertion sort, merge sort, quick sort, heap sort,
             * and radix sort (in that order).
             */
            long[] times = new long[7];
            int timesIndex = 0; // Index of the times array

            /*
             * SELECTION SORT
             */
            // Copy the list
            Integer[] copy = list.clone();

            // Start the clock
            long startTime = System.currentTimeMillis();

            SelectionSort.selectionSort(copy); // Perform the task

            // Stop the clock
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            times[timesIndex++] = executionTime;

            /*
             * BUBBLE SORT
             */
            // Copy the list
            copy = list.clone();

            // Start the clock
            startTime = System.currentTimeMillis();

            BubbleSort.bubbleSort(copy); // Perform the task

            // Stop the clock
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            times[timesIndex++] = executionTime;

            /*
             * INSERTION SORT
             */
            // Copy the list
            copy = list.clone();

            // Start the clock
            startTime = System.currentTimeMillis();

            InsertionSort.insertionSort(copy); // Perform the task

            // Stop the clock
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            times[timesIndex++] = executionTime;

            /*
             * MERGE SORT
             */
            // Copy the list
            copy = list.clone();

            // Start the clock
            startTime = System.currentTimeMillis();

            MergeSort.mergeSort(copy); // Perform the task

            // Stop the clock
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            times[timesIndex++] = executionTime;

            /*
             * ITERATIVE QUICK SORT
             */
            // Copy the list
            copy = list.clone();

            // Start the clock
            startTime = System.currentTimeMillis();

            IterativeQuickSort.iterativeQuickSort(copy); // Perform the task

            // Stop the clock
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            times[timesIndex++] = executionTime;

            /*
             * HEAP SORT
             */
            // Copy the list
            copy = list.clone();

            // Start the clock
            startTime = System.currentTimeMillis();

            HeapSort.heapSort(copy); // Perform the task

            // Stop the clock
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            times[timesIndex++] = executionTime;

            /*
             * RADIX SORT
             */
            // Copy the list
            copy = list.clone();

            // Start the clock
            startTime = System.currentTimeMillis();

            RadixSort.radixSort(copy); // Perform the task

            // Stop the clock
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            times[timesIndex] = executionTime; // No need to increment timesIndex

            // Unformatted results
            // System.out.println(Arrays.toString(times));
            printRow(size, times);
        }
    }

    public static void printHeader() {
        printLine();
        System.out.println("| Array      | Selection  | Bubble     | Insertion  | Merge      | Quick      | Heap       | Radix      |");
        System.out.println("| Size       | Sort       | Sort       | Sort       | Sort       | Sort       | Sort       | Sort       |");
        printLine();
    }

    public static void printLine() {
        System.out.println("+------------+------------+------------+------------+------------+------------+------------+------------+");
    }

    /**
     * Generate an integer array of n parameter size;
     *
     * @param n
     * @return
     */
    public static Integer[] generateArray(int n) {
        Integer[] list = new Integer[n];
        for (int i = 0; i < n; i++) {
            // list[i] = new Random().nextInt();
            list[i] = new Random().nextInt(1000);
        }
        return list;
    }

    private static void printRow(int size, long[] times) {
        String format = "|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%n";
        System.out.printf(format,
                size,
                times[0], // Selection sort
                times[1], // Bubble sort
                times[2], // Insertion sort
                times[3], // Merge sort
                times[4], // Iterative quick sort
                times[5], // Heap
                times[6]); // Radix
        printLine();
    }
}
