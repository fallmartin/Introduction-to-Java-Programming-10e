
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Identical arrays) The arrays list1 and list2 are identical if they have the
 * same contents. Write a method that returns true if list1 and list2 are
 * identical, using the following header:
 *
 * public static boolean equals(int[] list1, int[] list2)
 *
 * Write a test program that prompts the user to enter two lists of integers and
 * displays whether the two are identical. Here are the sample runs. Note that
 * the first number in the input indicates the number of the elements in the
 * list. This number is not part of the list.
 *
 * @author martinfall
 */
public class IdenticalArrays {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter list1
        System.out.print("Enter list1: ");
        int[] list1 = createList(input);

        // Prompt the user to enter list2
        System.out.print("Enter list2: ");
        int[] list2 = createList(input);

        // Check if list1 and list2 are strictly identical arrays
        System.out.println("Two lists are " + (equals(list1, list2) ? "" : "not ") + "identical");
    }

    public static int[] createList(Scanner input) {
        // Collect array length
        int length = input.nextInt();

        // Create array
        int[] list = new int[length];

        // Populate array
        for (int i = 0; i < list.length; i++) {
            list[i] = input.nextInt();
        }

        return list;
    }

    public static boolean equals(int[] list1, int[] list2) {
        Arrays.sort(list1);
        Arrays.sort(list2);

        // Check array lengths
        if (list1.length != list2.length) {
            return false;
        }

        for (int i = 0; i < list1.length; i++) {
            if (list1[i] != list2[i]) {
                return false;
            }
        }

        return true;
    }
}
