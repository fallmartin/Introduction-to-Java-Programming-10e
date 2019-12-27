
/**
 * (Use the &&, || and ^ operators) Write a program that prompts the user to enter
 * an integer and determines whether it is divisible by 5 and 6, whether it is
 * divisible by 5 or 6, and whether it is divisible by 5 or 6, but not both.
 * Here is a sample run of this program:
 *
 * Enter an integer: 10
 * Is 10 divisible by 5 and 6? false
 * Is 10 divisible by 5 or 6? true
 * Is 10 divisible by 5 or 6, but not both? true
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class OperatorsChallenge {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter an integer
        System.out.print("Enter an integer: ");

        // Collect input from the user
        int number = input.nextInt();

        // Is 10 divisible by 5 and 6?
        System.out.println("Is 10 divisible by 5 and 6? "
                + (number % 5 == 0 && number % 6 == 0));

        // Is 10 divisible by 5 or 6?
        System.out.println("Is 10 divisible by 5 or 6? "
                + (number % 5 == 0 || number % 6 == 0));

        // Is 10 divisible by 5 or 6, but not both?
        System.out.println("Is 10 divisible by 5 or 6, but not both? "
                + (number % 5 == 0 ^ number % 6 == 0));
    }
}
