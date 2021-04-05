package radixsorter;

import java.util.*;

/**
 * (Radix sort animation) Write a program that animates the radix sort
 * algorithm. Create an array that consists of 20 random numbers from 0 to
 * 1,000. The array elements are displayed, as shown in Figure 23.21. Clicking
 * the Step button causes the program to place a number in a bucket. The number
 * that has just been placed is displayed in red. Once all the numbers are
 * placed in the buckets, clicking the Step button collects all the numbers from
 * the buckets and moves them back to the array. When the algorithm is finished,
 * clicking the Step button displays a message to inform the user. Clicking the
 * Reset button creates a new random array for a new start.
 *
 * @author martinfall
 */
public class RadixSorter {

    /**
     * List data fields
     *
     * @param list - a list of random integers in the 0 to bound range
     * @param listIndex - the index of the current element in the list
     *
     * @param size - the size of the list
     * @param bound - the noninclusive upper bound of possible integer values
     * @param maxNumberOfDigits - the maximum number of digits for the largest
     * number in the list
     */
    private ArrayList<Integer> list;
    private int listIndex;

    private final int size = 20; // The list has 20 elements
    private final int bound = 1000; // The noninculsive upper bound is 1000
    private int maxNumberOfDigits;

    /**
     * Buckets data fields
     *
     * @param buckets - array list of array lists of integers
     * @param bucketIndex - the index of the current bucket
     * @param bucketElementIndex - the index of the current element in the
     * current bucket
     * @param initialCapacity - the initial capacity of the buckets collection
     */
    private ArrayList<ArrayList<Integer>> buckets;
    private int bucketIndex;
    private int bucketElementIndex;
    private final int initialCapacity = 10;

    // Place value index
    private int placeValueIndex;

    /*
     * Create an array of indices.
     *
     * index[0] - index of the current element in the list
     * index[1] - index of the current bucket
     * index[2] - index of the current element in the current bucket
     */
    int[] indices = new int[3];

    /**
     * Default constructor of the RadixSorter class.
     */
    public RadixSorter() {
        /**
         * Initialize the indices used to paint the current element in the list
         * and the buckets to -1.
         */
        Arrays.fill(indices, -1);
        // System.out.println(Arrays.toString(indices));

        // Initialize the list, bucket, and bucket element index variables
        listIndex = 0;
        bucketIndex = 0;
        bucketElementIndex = 0;

        // Initialize the list data field
        this.list = initList(size, bound);

        // Initialize the buckets' array lists
        this.buckets = initBuckets(initialCapacity);

        // Initialize the max number of digits data field
        this.maxNumberOfDigits = getMaxNumberOfDigits(bound);

        // The index of the current place value
        placeValueIndex = maxNumberOfDigits - 1;
    }

    /**
     * Builds an array list of randomly generated numbers ranging from 0 to the
     * value of the parameter bound.
     *
     * @param bound
     * @return
     */
    private ArrayList<Integer> initList(int size, int bound) {
        // Construct an empty list with the specified initial capacity of SIZE
        ArrayList<Integer> tempList = new ArrayList<>(size);

        // Initialize and populate the list with random integer values < BOUND
        for (int i = 0; i < size; i++) {
            tempList.add(new Random().nextInt(bound));
        }

        return tempList;
    }

    /**
     * Returns an initialized array list of blank integer array lists.
     *
     * @param initialCapacity
     * @return
     */
    private ArrayList<ArrayList<Integer>> initBuckets(int initialCapacity) {
        ArrayList<ArrayList<Integer>> tempBuckets = new ArrayList<>(initialCapacity);
        for (int i = 0; i < initialCapacity; i++) {
            tempBuckets.add(new ArrayList<>());
        }

        return tempBuckets;
    }

    /**
     * Returns the maximum number of digits possible that are less than the
     * value of bound.
     *
     * If bound is 1000, the greatest possible number that is less than bound is
     * 999, therefore the maximum number of digits possible is 3.
     */
    private int getMaxNumberOfDigits(int bound) {
        return Integer.toString(bound - 1).length();
    }

    /**
     * Returns a string representation of an integer left-padded with 0.
     *
     * @param number
     * @return
     */
    private String padLeft(Integer number) {
        // Create a new string builder
        StringBuilder builder = new StringBuilder();

        // Add maximumn number of digits - number lenght 0s to string builder
        while (builder.length()
                < maxNumberOfDigits - Integer.toString(number).length()) {
            builder.append("0");
        }

        // Add the number to the end of the builder
        builder.append(number);

        // Return the string builder to the caller method as a string
        return builder.toString();
    }

    /**
     * Take a step.
     */
    public void step() {
        // Build a 0 left-padded string from the current element of list
        String numberString = padLeft(list.get(listIndex));

        // Extract the bucket index (key) from the current integer
        bucketIndex
                = Integer.parseInt(numberString.charAt(placeValueIndex) + "");

        // Add the current element to the bucket at index key
        buckets.get(bucketIndex).add(list.get(listIndex));
        bucketElementIndex = buckets.get(bucketIndex).size() - 1;

        // Initialize the index trio
        indices[0] = listIndex;
        indices[1] = bucketIndex;
        indices[2] = bucketElementIndex;

        // Print data to console
        // printDetails();
        // Index management
        if (listIndex < size - 1) {
            listIndex++;
        } else {
            list.clear();
            int k = 0;
            for (int i = 0; i < buckets.size(); i++) {
                if (!buckets.get(i).isEmpty()) {
                    for (int j = 0; j < buckets.get(i).size(); j++) {
                        list.add(k++, buckets.get(i).get(j));
                    }
                }
            }

            buckets = initBuckets(initialCapacity);
            listIndex = 0;
            placeValueIndex--;
        }
    }

    public boolean hasSteps() {
        return placeValueIndex >= 0;
    }

    public void reset() {

        // Reset the list and bucket index
        listIndex = 0;
        bucketIndex = 0;
        bucketElementIndex = 0;

        // Initialize the list data field
        this.list = initList(size, bound);

        // Initialize the buckets
        this.buckets = initBuckets(initialCapacity);

        // Initialize the max number of digits data field
        this.maxNumberOfDigits = getMaxNumberOfDigits(bound);

        // The index of the current place value
        placeValueIndex = maxNumberOfDigits - 1;

        // Reset the index array
        indices = new int[3];

        printDetails();
    }

    /**
     * Returns an array of indices (list index at 0, bucket index at 1, and
     * bucket element index at 2.
     *
     * @return
     */
    public int[] getIndices() {
        return indices;
    }

    /**
     * Returns the list of integers.
     *
     * @return
     */
    public ArrayList<Integer> getList() {
        return list;
    }

    /**
     * Returns the index of the current element in the list.
     *
     * @return
     */
    public int getListIndex() {
        return listIndex;
    }

    /**
     * Returns the array list of buckets.
     *
     * @return
     */
    public ArrayList<ArrayList<Integer>> getBuckets() {
        return buckets;
    }

    /**
     * Returns the index of the bucket containing the current element.
     *
     * @return
     */
    public int getBucketIndex() {
        return bucketIndex;
    }

    /**
     * Returns the index of the current element in the current bucket.
     *
     * @return
     */
    public int getBucketElementIndex() {
        return bucketElementIndex;
    }

    /**
     * Print the list, buckets, and indices of various elements to the con sole.
     */
    private void printDetails() {
        System.out.println("list=" + list);
        System.out.println("buckets=" + buckets);
        System.out.println(Arrays.toString(indices));
        System.out.println();
    }

}
