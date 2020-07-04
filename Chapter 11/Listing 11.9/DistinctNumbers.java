
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Output:
 * Enter integers (input ends with 0): 1 2 3 2 1 6 3 4 5 4 5 1 2 3 0
 * 1 2 3 6 4 5
 *
 * @author martinfall
 */
public class DistinctNumbers {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter integers (input ends with 0): ");
        int value;

        do {
            value = input.nextInt(); // Read a value from the input
            if (!list.contains(value) && value != 0) {
                list.add(value); // Add the value if it is not in the list
            }
        } while (value != 0);

        // Display the distinct numbers
        // System.out.println(list.toString());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
