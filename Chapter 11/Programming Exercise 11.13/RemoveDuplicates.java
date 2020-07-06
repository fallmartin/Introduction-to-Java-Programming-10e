
import java.util.ArrayList;
import java.util.Scanner;

/**
 * (Remove duplicates) Write a method that removes the duplicate elements from
 * an array list of integers using the following header:
 *
 * public static void removeDuplicate(ArrayList<Integer> list)
 *
 * Write a test program that prompts the user to enter 10 integers to a list and
 * displays the distinct integers separated by exactly one space. Here is a
 * sample run:
 *
 * Enter ten integers: 34 5 3 5 6 4 33 2 2 4
 * The distinct integers are 34 5 3 6 4 33 2
 *
 * Output:
 * Enter ten integers: 34 5 3 5 6 4 33 2 2 4
 * The distinct integers are 34 5 3 6 4 33 2
 *
 * @author martinfall
 */
public class RemoveDuplicates {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object.
        Scanner input = new Scanner(System.in);

        // Create a new ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        // Promt the user to enter ten integers.
        System.out.print("Enter ten integers: ");

        // Store 10 user entries in the array list
        for (int i = 0; i < 10; i++) {
            list.add(input.nextInt());
        }

        removeDuplicate(list);

        // Display the list to console
        System.out.print("The distinct integers are " + printArrayList(list));

    }

    /**
     * Removes the duplicate elements from an array list of integers.
     *
     * @param list
     */
    public static void removeDuplicate(ArrayList<Integer> list) {
        // Create a new array list
        ArrayList<Integer> temp = new ArrayList<>();

        // Copy unique elements of list into temp
        for (int n : list) {
            if (!temp.contains(n)) {
                temp.add(n);
            }
        }

        // Clear list
        list.clear();

        // Copy temp back into list one element at a time
        for (int n : temp) {
            list.add(n);
        }
    }

    public static String printArrayList(ArrayList<Integer> list) {
        String s = "";

        for (int num : list) {
            s = s + num + " ";
        }

        return s;
    }
}
