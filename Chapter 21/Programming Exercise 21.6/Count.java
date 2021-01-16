
import java.util.*;
import java.util.Map.Entry;

/**
 * (Count the occurrences of numbers entered) Write a program that reads an
 * unspecified number of integers and finds the one that has the most
 * occurrences. The input ends when the input is 0. For example, if you entered
 * 2 3 40 3 5 4 –3 3 3 2 0, the number 3 occurred most often. If not one but
 * several numbers have the most occurrences, all of them should be reported.
 * For example, since 9 and 3 appear twice in the list 9 30 3 9 3 2 4, both
 * occurrences should be reported.
 *
 * Output:
 * Enter unspecified number of integers below
 * --- The input ends when the input is 0 ---
 * 2 3 40 3 5 4 -3 3 3 2 0
 * 3
 *
 * Enter unspecified number of integers below
 * --- The input ends when the input is 0 ---
 * 9 30 3 9 3 2 4 0
 * 3 9
 *
 * @author martinfall
 */
public class Count {

    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Create a hash map
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // Prompt the user to for input
        System.out.println("Enter unspecified number of integers below");
        System.out.println("--- The input ends when the input is 0 ---");
        int number = input.nextInt();

        while (number != 0) {
            // If the number has already been entered
            if (hashMap.containsKey(number)) {
                hashMap.put(number, hashMap.get(number) + 1);
            } else { // If the number has not been entered
                hashMap.put(number, 1);
            }

            // Accept additional input
            number = input.nextInt();
        }

        // Find the number with the most occurrences
        // 2 3 40 3 5 4 -3 3 3 2 0
        // 9 30 3 9 3 2 4 0
        List<Integer> values = new ArrayList<>(hashMap.values());
        Collections.sort(values);
        Collections.reverse(values);
        int max = values.get(0);

        for (Entry entry : hashMap.entrySet()) {
            if (entry.getValue().equals(max)) {
                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.println(); // Print a new line
    }
}
