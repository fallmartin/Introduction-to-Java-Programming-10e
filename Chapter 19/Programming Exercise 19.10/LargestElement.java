
import java.util.*;

/**
 * (Largest element in ArrayList) Write the following method that returns the
 * largest element in an ArrayList:
 *
 * public static <E extends Comparable<E>> E max(ArrayList<E> list)
 *
 * Output:
 * 521	447	555	723	344	213	499	688	811	812
 * 776	947	744	450	127	917	263	484	657	741
 * 904	254	695	467	240	974	498	850	563	109
 * 240	392	787	195	107	715	830	238	659	945
 * 614	775	684	108	481	257	18	8	633	998
 * 104	410	238	712	297	192	311	849	573	623
 * 600	592	765	188	846	673	842	523	381	39
 * 336	461	370	504	384	642	61	797	98	691
 * 69	900	153	770	728	461	969	56	378	917
 * 316	363	546	130	401	410	165	956	646	487
 *
 * The maximum element is 998
 *
 * @author martinfall
 */
public class LargestElement {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new ArrayList of 100 random Integer objects
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(1000));
        }

        // Print the ArrayList to console
        for (int i = 1; i <= list.size(); i++) {
            System.out.print(list.get(i - 1) + "\t");
            if (i % 10 == 0) {
                System.out.println();
            }
        }

        System.out.println(); // Formatting line
        System.out.println("The maximum element is " + max(list));
    }

    /**
     * Returns the largest element in an ArrayList.
     *
     * @param <E>
     * @param list
     * @return
     */
    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        E o = list.get(0); // The starting point is the first element in list

        for (E element : list) {
            if (element.compareTo(o) >= 1) {
                o = element;
            }
        }
        return o;
    }
}
