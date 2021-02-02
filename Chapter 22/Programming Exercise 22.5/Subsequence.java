
import java.util.*;

/**
 * (Same-number subsequence) Write an O(n) program that prompts the user to
 * enter a sequence of integers ending with 0 and finds the longest subsequence
 * with the same number. Here is a sample run of the program:
 *
 * Enter a series of numbers ending with 0:
 * 2 4 4 8 8 8 8 2 4 4 0
 * The longest same number sequence starts at index 3 with 4 values of 8
 *
 * Time Complexity: O(n)
 * The algorithm executes at most n times. We can optimize it by updating i to
 * the index of the last element in temp at each pass. We can also use a
 * divide-and-conquer approach that divides the list in two sublists of equal
 * size, finding the longest sequence in each, then checking if the left and
 * right strips at the tail and head of each list contain a sequence.
 *
 * Output:
 * Enter a series of numbers ending with 0:
 * 1 2 3 4 5 6 7 8 9 9 9 9 9 0
 * The longest same number sequence starts at index 8 with 5 values of 9
 *
 * Enter a series of numbers ending with 0:
 * 2 4 4 8 8 8 8 2 4 4 0
 * The longest same number sequence starts at index 3 with 4 values of 8
 *
 * @author martinfall
 */
public class Subsequence {

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a scanner
        Scanner input = new Scanner(System.in);

        // Create two linked list to preserve the insertion order of our input
        // and use the getLast method to retrieve most recently added element
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();

        // Accept user input
        System.out.println("Enter a series of numbers ending with 0:");
        int number = input.nextInt(); // First entry
        while (number != 0) { // While input is not equal to 0
            list.add(number);
            number = input.nextInt();
        }

        // Uncomment the line below to see list in console
        // System.out.println("list: " + list);
        // Local variables for index, count, and value
        int index = 0;
        int count = 0;

        // 1 2 3 4 5 6 7 8 9 9 9 9 9 0
        /**
         * i: 0 1 2 3 4 5 6 7 8 9 X
         * n: 2 4 4 8 8 8 8 2 4 4 0
         */
        // Optimize the for loop by caching size
        // For each number in the input list
        for (int i = 0, size = list.size(); i < size; i++) {
            // If temp is empty
            if (temp.isEmpty()) {
                temp.add(list.get(i));
            } // If temp is not empty 
            else {
                // If last num in temp equals num in list at i
                if (Objects.equals(temp.getLast(), list.get(i))) {
                    temp.add(list.get(i));

                    if (i == size - 1) {
                        // System.out.println("\ntemp size = " + temp.size());
                        // System.out.println(temp);

                        // Check if temp size is larger than count
                        if (count < temp.size()) {
                            count = temp.size();
                            index = i - count + 1; // + 1 because at last pos
                        }
                    }
                } // If last num in temp is not equal to num in list at i
                else {
                    // System.out.println("\ntemp size = " + temp.size());
                    // System.out.println(temp);

                    // Check if temp size is larger than count
                    if (count < temp.size()) {
                        count = temp.size();
                        index = i - count; // see note above why not + 1
                    }

                    temp.clear();
                    temp.add(list.get(i));
                }
            }
        }

        int value = list.get(index);
        System.out.println(format(index, count, value));
    }

    public static String format(int index, int count, int value) {
        return String.format("The longest same number sequence starts "
                + "at index %d with %d values of %d", index, count, value);
    }
}
