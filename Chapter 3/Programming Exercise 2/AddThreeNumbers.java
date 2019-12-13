
/**
 * (Game: add three numbers) The program in Listing 3.1, AdditionQuiz.java,
 * generates two integers and prompts the user to enter the sum of these two
 * integers.
 * Revise the program to generate three single-digit integers and prompt the
 * user to enter the sum of these three integers.
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class AddThreeNumbers {

    public static void main(String[] args) {
        // Generate three single-digit integers
        int number1 = (int) (Math.random() * 10);
        int number2 = (int) (Math.random() * 10);
        int number3 = (int) (Math.random() * 10);

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the sum of these three integers
        System.out.print("What is "
                + number1 + " + " + number2 + " + " + number3 + "? ");

        // Collect input from the user and store in variable sum
        int sum = input.nextInt();

        // Check the validity of the answer
        if (sum == number1 + number2 + number3) {
            System.out.println("You are correct!");
        } else {
            System.out.println("You are incorrect!");
            System.out.println("The correct answer is " + (number1 + number2 + number3));
        }
    }
}
