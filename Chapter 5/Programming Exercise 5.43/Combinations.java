
/**
 * Math: combinations) Write a program that displays all possible combinations
 * for picking two numbers from integers 1 to 7. Also display the total number of
 * all combinations.
 *
 * Output:
 * 
1 2
1 3
1 4
1 5
1 6
1 7
2 3
2 4
2 5
2 6
2 7
3 4
3 5
3 6
3 7
4 5
4 6
4 7
5 6
5 7
6 7
The total number of all combinations is 21
 *
 */
/**
 *
 * @author martinfall
 */
public class Combinations {

    public static void main(String[] args) {
        // Create a counter variable and initialize at 0
        int count = 0;

        // Create the outer loop that counts from 1 to 7
        for (int i = 1; i <= 7; i++) {
            // Create the inner loop that also counts from 1 to 7
            for (int j = 1; j <= 7; j++) {
                // Skip all number with repeat (22) digits 
                // and permutations of previously enumerated numbers (23/32)
                if (i != j && j > i) {
                    System.out.println(i + " " + j);
                    count++;
                }
            }
        }

        System.out.println("The total number of all combinations is " + count);
    }
}
