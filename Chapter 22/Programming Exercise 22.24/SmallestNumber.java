package smallestnumber;

import java.util.*;

/**
 * (Find the smallest number) Write a method that uses the divide-and-conquer
 * approach to find the smallest number in a list.
 *
 * Output:
 * [38, 89, 86, 46, 36, 17, 73, 99, 66, 17,
 * 83, 48, 16, 17, 87, 47, 96, 87, 16, 39,
 * 88, 59, 87, 83, 12, 98, 2, 69, 37, 77,
 * 77, 51, 29, 94, 76, 82, 82, 7, 87, 46,
 * 18, 36, 27, 87, 93, 25, 22, 45, 63, 85,
 * 90, 76, 70, 13, 75, 36, 9, 52, 46, 50,
 * 19, 55, 79, 41, 65, 62, 51, 75, 18, 91,
 * 71, 74, 12, 55, 32, 51, 53, 83, 60, 48,
 * 6, 84, 67, 67, 29, 19, 7, 82, 70, 45,
 * 86, 96, 82, 6, 97, 38, 23, 65, 63, 38]
 *
 * min(list) = 2
 * Collections.min(list) = 2
 *
 * [30, 92, 77, 9, 67, 69, 23, 54, 52, 79,
 * 50, 34, 72, 30, 69, 10, 38, 29, 73, 28,
 * 89, 60, 84, 71, 66, 23, 91, 91, 74, 70,
 * 6, 50, 27, 71, 10, 38, 92, 79, 86, 27,
 * 6, 49, 35, 34, 63, 64, 35, 21, 42, 50,
 * 53, 25, 83, 75, 48, 45, 37, 12, 62, 17,
 * 22, 42, 47, 87, 19, 59, 67, 78, 61, 16,
 * 40, 85, 8, 98, 97, 55, 88, 10, 5, 28,
 * 50, 55, 84, 89, 53, 90, 9, 54, 98, 90,
 * 80, 41, 37, 20, 47, 23, 81, 66, 44, 26]
 *
 * min(list) = 5
 * Collections.min(list) = 5
 *
 * @author martinfall
 */
public class SmallestNumber {

    private static int SIZE = 100;

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new random number generator
        Random r = new Random();

        // Create a list of randomly generate integer objects
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            list.add(r.nextInt(SIZE));
        }

        printList(list);

        // Display the results on the console
        System.out.println("\n\nmin(list) = " + min(0, list.size() - 1, list));
        System.out.println("Collections.min(list) = " + Collections.min(list));
    }

    public static void printList(ArrayList<Integer> list) {
        if (list.size() <= 5) {
            System.out.println(list);
        } else {
            // Display the list to the console
            System.out.print("[");
            for (int i = 0; i < SIZE; i++) {
                if (i == list.size() - 1) {
                    System.out.printf("%d", list.get(i));
                } else {
                    System.out.printf("%d, ", list.get(i));
                }

                // 10 numbers per line
                if ((i + 1) % 10 == 0 && i != list.size() - 1) {
                    System.out.println();
                }
            }

            System.out.print("]");
        }
    }

    public static int min(int low, int high, ArrayList<Integer> list) {
        if (low == high) {
            return list.get(low);
        }
        if (high - low == 1) {
            return Math.min(list.get(low), list.get(high));
        }

        int mid = low + (high - low) / 2;

        int number1 = min(low, mid, list);
        int number2 = min(mid + 1, high, list);
        return Math.min(number1, number2);
    }
}
