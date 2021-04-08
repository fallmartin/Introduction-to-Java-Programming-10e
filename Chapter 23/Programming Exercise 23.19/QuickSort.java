package quicksort;

import java.util.*;

/**
 * (Quick sort partition animation) Write a program that animates the partition
 * for a quick sort. The program creates a list that consists of 20 random
 * numbers from 1 to 999. The list is displayed, as shown in Figure 23.22b.
 * Clicking the Step button causes the program to move low to the right or high
 * to the left, or swap the elements at low and high. Clicking the Reset button
 * creates a new list of random numbers for a new start. When the algorithm is
 * finished, clicking the Step button displays a message to inform the user.
 *
 * @author martinfall
 */
public class QuickSort {

    // Data fields
    // Class constants
    private static final int LIST_SIZE = 20;
    private static final int MIN_ELEMENT = 1;
    private static final int MAX_ELEMENT = 999;

    // list of 20 random numbers from 1 to 999
    private int[] list; // Initialized in the initializeList method

    // Indices for traversing and partitioning the list
    private final int first = 0;
    private final int last = LIST_SIZE - 1;
    private int low = 1;
    private int high = last;

    // The pivot element and its index
    // Initialized in the getPivotIndex method
    private int pivot;
    private int pivotIndex;

    // Initialize bit field constants
    public static final int STARTING_POINT = 0; // 0000
    public static final int LOW_FOUND = 1; // 0001
    public static final int HIGH_FOUND = 3; // 0011
    public static final int PIVOT_MOVED_DONE = 7; // 0111

    // Data field status keeps track of where we are in the algorithm
    private int status; // Initialized in the initializeList method

    /**
     * Default constructor of the QuickSort class.
     *
     * Initializes the list with 20 random numbers from 1 to 999, then selects
     * the median of the first, middle, and last elements as a pivot and swaps
     * it with the first position in the list.
     */
    public QuickSort() {
        // Initialize the list data field
        list = initList();

        // CONSOLE
        System.out.println("list=" + Arrays.toString(list) + "\n");

        // Initialize the pivot and pivot index data fields
        initPivot();

        // Set the status to no steps taken yet
        status = STARTING_POINT;
    }

    /**
     * Returns a list that consists of 20 random numbers from 1 to 999.
     *
     * @return
     */
    private int[] initList() {
        // Create a new Random object
        Random random = new Random();

        // Create and populate a new int array with random number from 1 to 999
        int[] tempList = new int[LIST_SIZE];
        for (int i = 0; i < LIST_SIZE; i++) {
            tempList[i] = MIN_ELEMENT + random.nextInt(MAX_ELEMENT);
        }

        // Return the temporary list to the caller method
        return tempList;
    }

    /**
     * Returns the index of the median of first, last, and middle element in
     * list that is then chosen as the pivot.
     *
     * @return
     */
    private void initPivot() {
        // Create an array of ints with first, middle, and last elements
        int[] pivots = {
            list[first], // list[0] - first element in the list
            list[(last - first) / 2], // list[9] - middle element in the list 
            list[last]}; // list[19] - last element in the list

        // CONSOLE
        System.out.println("pivots=" + Arrays.toString(pivots));

        // Sort the array of potential pivots
        Arrays.sort(pivots);

        // The median element in the sorted array is the pivot
        pivot = pivots[1]; // Initialize the pivot

        // Initialize the pivot index field
        if (list[first] == pivot) {
            pivotIndex = first; // first
        } else if (list[last] == pivot) {
            pivotIndex = last;
        } else {
            pivotIndex = (last - first) / 2;
        }

        // CONSOLE
        System.out.println("pivot=" + pivot);
        System.out.println("pivotIndex=" + pivotIndex + "\n");

        // Select a pivot, initialize pivot and pivot index field, move to first
        movePivotToFirst();
    }

    /**
     * Moves the pivot element to index 0 in preparation of the partition.
     *
     * @param pivotIndex
     */
    private void movePivotToFirst() {
        // CONSOLE
        System.out.println("List before moving the pivot");
        System.out.println("list=" + Arrays.toString(list) + "\n");

        // If the index of the pivot is not 0
        if (pivotIndex != first) {
            // Position the pivot at the start of the list
            int temp = list[0];
            list[0] = list[pivotIndex];
            list[pivotIndex] = temp;
        }

        pivotIndex = 0; // Update the pivot index

        // CONSOLE
        System.out.println("List after moving the pivot");
        System.out.println("list=" + Arrays.toString(list) + "\n");
    }

    /**
     * Moves the low index to the next possible value.
     */
    public void moveLow() {
        while (low <= high && list[low] <= pivot) {
            low++;
        }
    }

    /**
     * Moves the high index to the next possible value.
     */
    public void moveHigh() {
        while (low <= high && list[high] > pivot) {
            high--;
        }
    }

    /**
     * Performs one single valid swap.
     */
    public void swap() {
        if (low < high) {
            int temp = list[low];
            list[low] = list[high];
            list[high] = temp;
        }
    }

    /**
     * Moves the pivot to its post-partition place.
     */
    public void movePivot() {
        if (first < high && list[high] >= pivot) {
            high--;
        }

        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            pivotIndex = high;
            high = first;
        }
    }

    /**
     * Returns true if low is less than high.
     *
     * @return
     */
    public boolean hasMoves() {
        return low < high;
    }

    /**
     * Returns the status of the quick sort object.
     *
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the status of the quick sort object.
     *
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Prints the contents of the data fields.
     */
    public void print() {
        System.out.println("low=" + low);
        System.out.println("high=" + high);
        System.out.println("pivot=" + pivot);
        System.out.println("pivotIndex=" + pivotIndex);
        System.out.println("list=" + Arrays.toString(list));
        System.out.println(printStatus() + "\n");
    }

    /**
     * Returns a status message.
     *
     * @return
     */
    public String printStatus() {
        String statusMessage = "";

        switch (status) {
            case 0:
                // STARTING_POINT
                statusMessage = "Start partitioning";
                break;

            case 1:
                // LOW_FOUND
                statusMessage = "list[low] <= pivot?\n"
                        + list[low] + " is not <= " + pivot;
                break;

            case 3:
                // HIGH_FOUND
                statusMessage = "list[high] > pivot?\n"
                        + list[high] + " is not > " + pivot;
                break;

            case 7:
                // PIVOT_MOVED_DONE
                statusMessage = "The pivot " + pivot + " has moved to index "
                        + pivotIndex + "\nTask completed!";
                break;
        }

        return statusMessage;
    }

    /**
     * Returns the list.
     *
     * @return
     */
    public int[] getList() {
        return list;
    }

    /**
     * Returns the value of the low index variable.
     *
     * @return
     */
    public int getLow() {
        return low;
    }

    /**
     * Returns the value of the high index variable.
     *
     * @return
     */
    public int getHigh() {
        return high;
    }

    /**
     * Returns the value of the pivot index variable.
     *
     * @return
     */
    public int getPivotIndex() {
        return pivotIndex;
    }

}
