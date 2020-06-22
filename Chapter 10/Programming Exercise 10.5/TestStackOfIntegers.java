
import java.util.Scanner;

/**
 * (Displaying the prime factors) Write a program that prompts the user to enter
 * a positive integer and displays all its smallest factors in decreasing order.
 * For example, if the integer is 120, the smallest factors are displayed as
 * 5, 3, 2, 2, 2. Use the StackOfIntegers class to store the factors
 * (e.g., 2, 2, 2, 3, 5) and retrieve and display them in reverse order.
 *
 * Output:
 * Enter a positive integer: 120
 * The smallest factors of 120 are: 5 3 2 2 2
 *
 * @author martinfall
 */
public class TestStackOfIntegers {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a positive integer
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        int copyNumber = number;

        // Create a new StackOfIntegers object
        StackOfIntegers stack = new StackOfIntegers();

        // Find the smallest factors
        for (int i = 2; number > 1;) {
            if (number % i == 0) {
                stack.push(i);
                number /= i;
            } else {
                i++;
            }
        }

        System.out.print("The smallest factors of " + copyNumber + " are: ");
        // Pop an element from the top and print it to console
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
