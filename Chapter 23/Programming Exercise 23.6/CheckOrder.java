package checkorder;

import java.util.*;

/**
 * (Check order) Write the following overloaded methods that check whether an
 * array is ordered in ascending order or descending order. By default, the
 * method checks ascending order. To check descending order, pass false to the
 * ascending argument in the method.
 *
 * public static boolean ordered(int[] list)
 * public static boolean ordered(int[] list, boolean ascending)
 * public static boolean ordered(double[] list)
 * public static boolean ordered(double[] list, boolean ascending)
 * public static <E extends Comparable<E>> boolean ordered(E[] list)
 * public static <E extends Comparable<E>> boolean ordered (E[] list, boolean
 * ascending)
 * public static <E> boolean ordered(E[] list, Comparator<? super E> comparator)
 * public static <E> boolean ordered(E[] list, Comparator<? super E> comparator,
 * boolean ascending)
 *
 * Output:
 * Testing ordered(int[] list)
 * true
 * false
 *
 * Testing ordered(int[] list, boolean ascending)
 * true
 * false
 * false
 * true
 *
 * Testing ordered(double[] list)
 * true
 * false
 *
 * Testing ordered(double[] list, boolean ascending)
 * true
 * false
 * false
 * true
 *
 * Testing ordered(E[] list)
 * true
 * false
 *
 * Testing ordered(E[] list, boolean ascending)
 * true
 * false
 * false
 * true
 *
 * Testing ordered(E[] list, Comparator<? super E> comparator)
 * true
 * false
 * false
 * true
 *
 * Testing ordered(E[] list, Comparator<? super E> comparator, boolean
 * ascending)
 * true
 * false
 * false
 * true
 * false
 * true
 * true
 * false
 *
 * @author martinfall
 */
public class CheckOrder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] intListAsc = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] intListDsc = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        double[] doubleListAsc = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
        double[] doubleListDsc = {10.0, 9.0, 8.0, 7.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0};

        String[] stringListAsc = {"A", "B", "C"};
        String[] stringListDsc = {"C", "B", "A"};

        // Testing ordered(int[] list)
        System.out.println("Testing ordered(int[] list)");
        System.out.println(ordered(intListAsc)); // true
        System.out.println(ordered(intListDsc)); // false

        // Testing ordered(int[] list, boolean ascending)
        System.out.println("\nTesting ordered(int[] list, boolean ascending)");
        System.out.println(ordered(intListAsc, true)); // true
        System.out.println(ordered(intListAsc, false)); // false
        System.out.println(ordered(intListDsc, true)); // false
        System.out.println(ordered(intListDsc, false)); // true

        // Testing ordered(double[] list)
        System.out.println("\nTesting ordered(double[] list)");
        System.out.println(ordered(doubleListAsc)); // true
        System.out.println(ordered(doubleListDsc)); // false

        // Testing ordered(double[] list, boolean ascending)
        System.out.println("\nTesting ordered(double[] list, boolean ascending)");
        System.out.println(ordered(doubleListAsc, true)); // true
        System.out.println(ordered(doubleListAsc, false)); // false
        System.out.println(ordered(doubleListDsc, true)); // false
        System.out.println(ordered(doubleListDsc, false)); // true

        // Testing ordered(E[] list)
        System.out.println("\nTesting ordered(E[] list)");
        System.out.println(ordered(stringListAsc)); // true
        System.out.println(ordered(stringListDsc)); // false

        // Testing ordered(E[] list, boolean ascending)
        System.out.println("\nTesting ordered(E[] list, boolean ascending)");
        System.out.println(ordered(stringListAsc, true)); // true
        System.out.println(ordered(stringListAsc, false)); // false
        System.out.println(ordered(stringListDsc, true)); // false
        System.out.println(ordered(stringListDsc, false)); // true

        // Create ascending (default) and descending (reversed) comparators
        DefaultComparator<String> defaultComparator = new DefaultComparator<>();
        Comparator<String> reversedComparator = defaultComparator.reversed();

        // Testing ordered(E[] list, Comparator<? super E> comparator)
        System.out.println("\nTesting ordered(E[] list, Comparator<? super E> comparator)");
        System.out.println(ordered(stringListAsc, defaultComparator)); // true
        System.out.println(ordered(stringListDsc, defaultComparator)); // false
        System.out.println(ordered(stringListAsc, reversedComparator)); // false
        System.out.println(ordered(stringListDsc, reversedComparator)); // true

        // Testing ordered(E[] list, Comparator<? super E> comparator, boolean ascending)
        System.out.println("\nTesting ordered(E[] list, Comparator<? super E> comparator, boolean ascending)");
        System.out.println(ordered(stringListAsc, defaultComparator, true)); // true
        System.out.println(ordered(stringListAsc, defaultComparator, false)); // false
        System.out.println(ordered(stringListAsc, reversedComparator, true)); // false
        System.out.println(ordered(stringListAsc, reversedComparator, false)); // true
        System.out.println(ordered(stringListDsc, defaultComparator, true)); // true
        System.out.println(ordered(stringListDsc, defaultComparator, false)); // false
        System.out.println(ordered(stringListDsc, reversedComparator, true)); // false
        System.out.println(ordered(stringListDsc, reversedComparator, false)); // true
    }

    /**
     * PASSED TESTS.
     *
     * @param list
     * @return
     */
    public static boolean ordered(int[] list) {
        return ordered(list, true); // Default is true.
    }

    /**
     * PASSED TESTS.
     *
     * @param list
     * @param ascending
     * @return
     */
    public static boolean ordered(int[] list, boolean ascending) {
        Integer[] listIntegers = new Integer[list.length];
        for (int i = 0; i < list.length; i++) {
            listIntegers[i] = list[i];
        }

        if (ascending) {
            return ordered(listIntegers);
        } else {
            return ordered(listIntegers, false);
        }
    }

    /**
     * PASSED TESTS.
     *
     * @param list
     * @return
     */
    public static boolean ordered(double[] list) {
        return ordered(list, true); // Default is true.
    }

    /**
     * PASSED TESTS.
     *
     * @param list
     * @param ascending
     * @return
     */
    public static boolean ordered(double[] list, boolean ascending) {
        Double[] listDoubles = new Double[list.length];
        for (int i = 0; i < list.length; i++) {
            listDoubles[i] = list[i];
        }

        if (ascending) {
            return ordered(listDoubles);
        } else {
            return ordered(listDoubles, false);
        }
    }

    /**
     * PASSED TESTS.
     *
     * @param <E>
     * @param list
     * @return
     */
    public static <E extends Comparable<E>> boolean ordered(E[] list) {
        return ordered(list, true);
    }

    /**
     * PASSED TESTS.
     *
     * @param <E>
     * @param list
     * @param ascending
     * @return
     */
    public static <E extends Comparable<E>> boolean ordered(E[] list, boolean ascending) {
        DefaultComparator<E> comparator = new DefaultComparator<>();

        if (ascending) {
            return ordered(list, comparator);
        } else {
            return ordered(list, comparator, false);
        }
    }

    /**
     * PASSED TESTS.
     *
     * @param <E>
     * @param list
     * @param comparator
     * @return
     */
    public static <E> boolean ordered(E[] list, Comparator<? super E> comparator) {
        return ordered(list, comparator, true);
    }

    /**
     *
     * @param <E>
     * @param list
     * @param comparator
     * @param ascending
     * @return
     */
    public static <E> boolean ordered(E[] list, Comparator<? super E> comparator, boolean ascending) {
        if (list.length == 0 || list.length == 1) {
            return true;
        }

        if (ascending) {
            for (int i = 1; i < list.length; i++) {
                if (comparator.compare(list[i - 1], list[i]) > 0) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < list.length; i++) {
                if (comparator.compare(list[i - 1], list[i]) < 0) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Generic class DefaultComparator implements the Comparator interface to
     * compare arguments of type E.
     *
     * @param <E>
     */
    public static class DefaultComparator<E extends Comparable<E>> implements Comparator<E> {

        @Override
        public int compare(E o1, E o2) {
            if (o1.compareTo(o2) > 0) {
                return 1;
            } else if (o1.compareTo(o2) < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
