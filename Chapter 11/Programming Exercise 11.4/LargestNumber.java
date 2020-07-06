
import java.util.Scanner;
import java.util.ArrayList;

/**
 * (Maximum element in ArrayList) Write the following method that returns the
 * maximum value in an ArrayList of integers. The method returns null if the
 * list is null or the list size is 0.
 *
 * public static Integer max(ArrayList<Integer> list)
 *
 * Write a test program that prompts the user to enter a sequence of numbers
 * ending with 0, and invokes this method to return the largest number in the
 * input.
 *
 * Output:
 * Enter a sequence of numbers ending with 0: 3 5 95 4 15 34 3 6 5 0
 * The maximum value in the sequence is 95
 *
 * @author martinfall
 */
public class LargestNumber {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object.
        Scanner input = new Scanner(System.in);

        // Create a new ArrayList reference variable, a new ArrayList object, and
        // assign it to the reference variable
        ArrayList<Integer> list = new ArrayList<>();

        // Declare a primitive data type value
        int value;

        // Prompt the user to enter a sequence of numbers ending with 0
        System.out.print("Enter a sequence of numbers ending with 0: ");

        // Sample input: 3 5 95 4 15 34 3 6 5 0
        do {
            value = input.nextInt();
            if (value != 0) {
                list.add(value);
                // System.out.println(list);
            }
        } while (value != 0);

        System.out.println("The maximum value in the sequence is " + max(list));
    }

    /**
     * Returns the maximum value in an ArrayList of integers. The method returns
     * null if the list is null or the list size is 0.
     *
     * @param list
     * @return
     */
    public static Integer max(ArrayList<Integer> list) {
        if (!list.isEmpty()) {
            int max = list.get(0);
            for (int e : list) {
                if (max < e) {
                    max = e;
                }
            }
            return max;
        }
        return null;
    }
}
