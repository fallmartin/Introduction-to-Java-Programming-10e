
import java.util.ArrayList;
import java.util.Scanner;

/**
 * (Combine two lists) Write a method that returns the union of two array lists
 * of integers using the following header:
 *
 * public static ArrayList<Integer> union( ArrayList<Integer> list1,
 * ArrayList<Integer> list2) 
 *
 * For example, the union of two array lists {2, 3, 1, 5} and {3, 4, 6} is
 * {2, 3, 1, 5, 3, 4, 6}. Write a test program that prompts the user to enter
 * two lists, each with five integers, and displays their union. The numbers are
 * separated by exactly one space in the output. Here is a sample run:
 *
 * Enter five integers for list1: 3 5 45 4 3
 * Enter five integers for list2: 33 51 5 4 13
 * The combined list is 3 5 45 4 3 33 51 5 4 13
 *
 * Output:
 * Enter five integers for list1: 3 5 45 4 3
 * Enter five integers for list2: 33 51 5 4 13
 * The combined list is 3 5 45 4 3 33 51 5 4 13
 *
 * @author martinfall
 */
public class CombineTwoLists {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object.
        Scanner input = new Scanner(System.in);

        // Create 2 ArrayList variables for list1 and list2.
        System.out.print("Enter five integers for list1: ");
        ArrayList<Integer> list1 = collectInput(input);
        System.out.print("Enter five integers for list2: ");
        ArrayList<Integer> list2 = collectInput(input);

        ArrayList<Integer> list = union(list1, list2);

        System.out.println("The combined list is " + printArrayList(list));

    }

    /**
     * Returns the union of two array lists of integers.
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> combinedList = new ArrayList<>();

        // Add the elements of list1 to combinedList
        for (int n : list1) {
            combinedList.add(n);
        }

        // Add the elements of list2 to combinedList
        for (int n : list2) {
            combinedList.add(n);
        }

        return combinedList;
    }

    /**
     * Populate the list using a Scanner object.
     *
     * @param input
     * @return
     */
    public static ArrayList<Integer> collectInput(Scanner input) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(input.nextInt());
        }

        return list;
    }

    /**
     *
     * @param list
     * @return
     */
    public static String printArrayList(ArrayList<Integer> list) {
        String s = "";

        for (int num : list) {
            s = s + num + " ";
        }

        return s;
    }
}
