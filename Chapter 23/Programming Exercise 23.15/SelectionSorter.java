package selectionsort;

import java.util.*;

/**
 * (Selection sort animation) Write a program that animates the selection sort
 * algorithm.Create an array that consists of 20 distinct numbers from 1 to 20
 * in a random order.The array elements are displayed in a histogram, as shown
 * in Figure 23.20a. Clicking the Step button causes the program to perform an
 * iteration of the outer loop in the algorithm and repaints the histogram for
 * the new array. Color the last bar in the sorted subarray. When the algorithm
 * is finished, display a message to inform the user. Clicking the Reset button
 * creates a new random array for a new start. (You can easily modify the
 * program to animate the insertion algorithm.)
 *
 * @author martinfall
 */
public class SelectionSorter {

    // 
    private int[] array;
    private int index;

    /**
     * Constructs a default SelectionSort object from an unsorted array.
     */
    public SelectionSorter() {
        // Initialize the index data field
        index = 0;

        // Generate a shuffled array of integer values in the 1 to 20 range
        array = generateArray();
    }

    /**
     * Prints the array to the console.
     */
    public final void printArrayToConsole() {
        // Display the array to console
        System.out.println("array=" + Arrays.toString(array));
    }

    /**
     * Iterates through the array from index i one time.
     *
     * @param i
     * @return min - the index of a smallest value in the unsorted subarray [i -
     * len-1]
     */
    public final int iterate(int i) {
        int min = i;

        for (int curr = i + 1; curr < array.length; curr++) {
            if (array[min] > array[curr]) {
                min = curr;
            }
        }

        return min;
    }

    /**
     * Replaces the value at min with the value at i.
     *
     * @param min
     * @param i
     */
    public final void swap(int min, int i) {
        int tempElement = array[min];
        array[min] = array[i];
        array[i] = tempElement;
    }

    /**
     * Returns a new SelectionSorter object.
     *
     * @return
     */
    public final SelectionSorter reset() {
        return new SelectionSorter();
    }

    /**
     * Returns a shuffled array of the number 1 through 20.
     *
     * @return
     */
    private int[] generateArray() {
        // Create a new Integer array
        int[] tempArray = new int[20];

        // Populate it with values in the 1 to 20 range
        for (int i = 1; i <= 20; i++) {
            tempArray[i - 1] = i;
        }

        // Shuffle the array
        for (int i = 0; i < tempArray.length; i++) {
            int randomIndex = (int) (Math.random() * tempArray.length);

            // Swap the values at i and randomIndex
            int temp = tempArray[i];
            tempArray[i] = tempArray[randomIndex];
            tempArray[randomIndex] = temp;
        }

        // Return the array to the caller method
        return tempArray;
    }

    /**
     * Returns the value of the index.
     *
     * @return
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets the value of the index.
     *
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Returns the array.
     *
     * @return
     */
    public int[] getArray() {
        return array;
    }

}
