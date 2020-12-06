
import java.util.*;

/**
 * (Sort ArrayList) Write the following method that sorts an ArrayList:
 *
 * public static <E extends Comparable<E>> void sort(ArrayList<E> list)
 *
 * Output:
 * Unsorted Array
 * 843	135	701	611	889	225	229	495	873	817
 * 787	832	837	778	680	898	639	346	262	967
 * 684	974	589	216	160	356	180	826	15	752
 * 904	292	477	822	27	29	140	878	292	698
 * 464	462	782	141	632	905	296	401	538	437
 * 26	450	923	187	766	233	475	31	594	645
 * 241	455	617	829	328	792	744	986	549	819
 * 68	674	44	967	637	159	702	544	599	22
 * 233	910	878	354	572	112	227	217	798	279
 * 447	295	986	87	402	662	336	920	505	607
 *
 * Sorted Array
 * 15	22	26	27	29	31	44	68	87	112
 * 135	140	141	159	160	180	187	216	217	225
 * 227	229	233	233	241	262	279	292	292	295
 * 296	328	336	346	354	356	401	402	437	447
 * 450	455	462	464	475	477	495	505	538	544
 * 549	572	589	594	599	607	611	617	632	637
 * 639	645	662	674	680	684	698	701	702	744
 * 752	766	778	782	787	792	798	817	819	822
 * 826	829	832	837	843	873	878	878	889	898
 * 904	905	910	920	923	967	967	974	986	986
 *
 * @author martinfall
 */
public class Sort {

    // Constant data field
    private static final int BOUND = 1000;

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create an Integer array
        ArrayList<Integer> list = new ArrayList<>();

        // Fill the array with random values from 0 (inclusive) to 1000 (exclusive)
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(BOUND));
        }

        // Print the array to the console
        System.out.println("\nUnsorted Array");
        printArray(list);

        // Sort the list
        sort(list);

        // Print the array to the console
        System.out.println("\nSorted Array");
        printArray(list);
    }

    /**
     * Display the array to the console.
     *
     * @param list
     */
    public static <E> void printArray(ArrayList<E> list) {
        for (int i = 1; i <= list.size(); i++) {
            System.out.print(list.get(i - 1) + "\t");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    /**
     * Sorts an ArrayList.
     *
     * @param <E>
     * @param list
     */
    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            E currentMin = list.get(i);
            int currentMinIndex = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (currentMin.compareTo(list.get(j)) >= 1) {
                    currentMin = list.get(j);
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i) {
                Collections.swap(list, i, currentMinIndex);
            }
        }
    }
}
