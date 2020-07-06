
import java.util.Scanner;

/**
 * Write a test program that prompts the user to enter five strings and displays
 * them in reverse order.
 *
 * Output:
 * Enter 5 strings:
 * Grandpa
 * Grandma
 * Dad
 * Mom
 * Me
 * 
 * Display the list in reverse order:
 * Me
 * Mom
 * Dad
 * Grandma
 * Grandpa
 *
 * @author martinfall
 */
public class TestMyStack {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        final int numberOfStrings = 5;
        // Create a new MyStack object.
        MyStack myStack = new MyStack();

        // Create a new Scanner object.
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter five strings.
        System.out.println("Enter " + numberOfStrings + " strings:");

        for (int i = 0; i < numberOfStrings; i++) {
            myStack.add(input.nextLine());
        }

        System.out.println(myStack.toString());
    }
}
