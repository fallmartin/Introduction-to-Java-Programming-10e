
import java.util.*;

/**
 * (Generic binary search) Implement the following method using binary search.
 *
 * public static <E extends Comparable<E>> int binarySearch(E[] list, E key)
 *
 * Output:
 * Unsorted Array
 * 383	697	858	839	597	245	685	265	443	530
 * 698	29	15	152	391	965	923	538	175	736
 * 210	781	173	591	13	804	872	484	543	760
 * 402	339	81	852	716	490	866	430	642	717
 * 903	954	286	194	491	529	596	603	43	86
 * 289	617	569	769	641	686	346	933	332	771
 * 630	420	508	352	12	58	133	978	343	542
 * 297	302	33	173	631	444	395	161	799	294
 * 78	391	333	384	745	686	840	594	215	595
 * 702	185	76	210	566	652	612	495	633	257
 *
 * Sorted Array
 * 12	13	15	29	33	43	58	76	78	81
 * 86	133	152	161	173	173	175	185	194	210
 * 210	215	245	257	265	286	289	294	297	302
 * 332	333	339	343	346	352	383	384	391	391
 * 395	402	420	430	443	444	484	490	491	495
 * 508	529	530	538	542	543	566	569	591	594
 * 595	596	597	603	612	617	630	631	633	641
 * 642	652	685	686	686	697	698	702	716	717
 * 736	745	760	769	771	781	799	804	839	840
 * 852	858	866	872	903	923	933	954	965	978
 * 
 * Binary searching for 86
 * The index of 86 is 10
 *
 * @author martinfall
 */
public class GenericBinarySearch {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create an Integer array
        Integer[] list = new Integer[100];

        // Fill the array with random values from 0 (inclusive) to 1000 (exclusive)
        Random random = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = random.nextInt(1000);
        }

        // Print the array to the console
        System.out.println("\nUnsorted Array");
        printArray(list);

        // Sort the list
        list = sort(list);

        // Print the array to the console
        System.out.println("\nSorted Array");
        printArray(list);

        System.out.println("Binary searching for " + list[10]);
        System.out.println("The index of " + list[10] + " is "
                + binarySearch(list, list[10]));
    }

    /**
     * Display the array to the console.
     *
     * @param list
     */
    public static <E> void printArray(E[] list) {
        for (int i = 1; i <= list.length; i++) {
            System.out.print(list[i - 1] + "\t");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    /**
     * Returns the index of key in the list or -1 if not found.
     *
     * @param <E>
     * @param list
     * @param key
     * @return
     */
    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
        int low = 0;
        int high = list.length - 1;

        while (high >= low) {
            int mid = low + (high - low) / 2;

            if (key.compareTo(list[mid]) == 0) {
                return mid;
            } else if (key.compareTo(list[mid]) >= 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Returns a sorted list using selection sort.
     *
     * @param <E>
     * @param list
     * @return
     */
    public static <E extends Comparable<E>> E[] sort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            E currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin.compareTo(list[j]) >= 1) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            if (i != currentMinIndex) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
        return list;
    }
}
