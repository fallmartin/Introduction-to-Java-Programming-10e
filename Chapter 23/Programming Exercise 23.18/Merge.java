package mergeanimation;

import java.util.Arrays;
import java.util.Random;

/**
 * (Merge animation) Write a program that animates the merge of two sorted
 * lists. Create two arrays, list1 and list2, each of which consists of 8 random
 * numbers from 1 to 999. The array elements are displayed, as shown in Figure
 * 23.22a. Clicking the Step button causes the program to move an element from
 * list1 or list2 to temp. Clicking the Reset button creates two new random
 * arrays for a new start. When the algorithm is finished, clicking the Step
 * button displays a message to inform the user.
 *
 * @author martinfall
 */
public class Merge {

    // Data fields of the Merge class
    // Arrays
    private int[] list1;
    private int[] list2;
    private int[] temp;

    // Indices of array
    private int current1;
    private int current2;
    private int current3;

    /**
     * Default constructor of the Merge class.
     */
    Merge() {
        initDataFields(); // Initialize the arrays and indices
        printArrays(); // Print the contents of arrays to the console
    }

    /**
     * Initializes two sorted lists of 8 random integers in the 1 - 999 range
     * (list1 and list2), a temp list containing the result of merging list1 and
     * list2, and indices to keep track of our positions in each array
     * (current1, current2, and current3).
     */
    private void initDataFields() {
        /*
         * Generate 2 sorted integer arrays of length 8 containing random
         * numbers in the 1 to 999 range
         */
        list1 = generateList();
        list2 = generateList();

        // Generate a blank integer array of lenght 16
        temp = new int[16];

        // Initialize the indices to 0
        current1 = 0; // Index of list1
        current2 = 0; // Index of list2
        current3 = 0; // Index of temp
    }

    /**
     * Returns a sorted array of random numbers from 1 to 999.
     *
     * @return
     */
    private int[] generateList() {
        int[] list = new int[8];
        Random random = new Random();

        for (int i = 0; i < list.length; i++) {
            list[i] = 1 + random.nextInt(998);
        }

        Arrays.sort(list);

        return list;
    }

    /**
     * Prints the contents and current indices of list1, list2, and the merged
     * array list.
     */
    private void printArrays() {
        // list1 and the index of the element at this step
        System.out.println(
                String.format("%n%-12s", "current1=" + (current1 - 1))
                + "\tlist1=" + Arrays.toString(list1));

        // list2 and the index of the element at this step
        System.out.println(
                String.format("%-12s", "current2=" + (current2 - 1))
                + "\tlist2=" + Arrays.toString(list2));

        // list and the index of the element at this step
        System.out.println(
                String.format("%-12s", "current3=" + (current3 - 1))
                + "\ttemp=" + Arrays.toString(temp));
    }

    /**
     * Returns true if the two arrays are not fully merged.
     *
     * @return
     */
    public boolean hasSteps() {
        return !(current1 >= list1.length
                && current2 >= list2.length
                && current3 >= temp.length);
    }

    /**
     * Take a step in the merging animation.
     */
    public void step() {
        // If both indices are in the 0 to length range
        if (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2]) {
                temp[current3++] = list1[current1++];
            } else {
                temp[current3++] = list2[current2++];
            }
        } // If only list1's index is in the 0 to length range
        else if (current1 < list1.length && current2 >= list2.length) {
            temp[current3++] = list1[current1++];
        } // If only list2's index is in the 0 to length range
        else if (current2 < list2.length && current1 >= list1.length) {
            temp[current3++] = list2[current2++];
        } // If both indices are out of range
        else if (current1 >= list1.length && current2 >= list2.length) {
            System.out.println("Merging successfully completed!");
        }

        printArrays();
    }

    /**
     * Reset the merging animation.
     */
    public void reset() {
        // Reinitialize the data fields of the object
        initDataFields();
        printArrays();
    }

    /**
     * Returns a String of the element at index i in list.
     *
     * @param list
     * @param i
     * @return
     */
    public static String getElement(int[] list, int i) {
        return Integer.toString(list[i]);
    }

    /**
     * Returns the string representation of the number at index i in list1.
     *
     * @param i
     * @return
     */
    public String getList1ElementAt(int i) {
        return Integer.toString(list1[i]);
    }

    /**
     * Returns the string representation of the number at index i in list2.
     *
     * @param i
     * @return
     */
    public String getList2ElementAt(int i) {
        return Integer.toString(list2[i]);
    }

    /**
     * Returns the string representation of the number at index i in temp.
     *
     * @param i
     * @return
     */
    public String getTempElementAt(int i) {
        return Integer.toString(temp[i]);
    }

    /**
     * Returns list1.
     *
     * @return
     */
    public int[] getList1() {
        return list1;
    }

    /**
     * Returns list2.
     *
     * @return
     */
    public int[] getList2() {
        return list2;
    }

    /**
     * Returns temp.
     *
     * @return
     */
    public int[] getTemp() {
        return temp;
    }

    /**
     * Returns current1.
     *
     * @return
     */
    public int getCurrent1() {
        return current1;
    }

    /**
     * Returns current2.
     *
     * @return
     */
    public int getCurrent2() {
        return current2;
    }

    /**
     * Returns current3.
     *
     * @return
     */
    public int getCurrent3() {
        return current3;
    }

}
