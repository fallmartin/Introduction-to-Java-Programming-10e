
/**
 * (Game: heads or tails) Write a program that lets the user guess whether the
 * flip of a coin results in heads or tails. The program randomly generates an
 * integer 0 or 1, which represents head or tail. The program prompts the user to
 * enter a guess and reports whether the guess is correct or incorrect.
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class HeadOrTailsGame {

    public static void main(String[] args) {
        // Randomly generate an integer 0 or 1, which represents head or tail
        Scanner input = new Scanner(System.in);
        int randomlyGeneratedNumber = (int) (Math.random() * 2);
        // System.out.println(randomlyGeneratedNumber); // Testing the random number

        // Prompt the user to enter a guess (1 for head or 0 for tails)
        System.out.print("Enter a guess (1 for head or 0 for tails): ");

        // Collect input from user
        int userGuess = input.nextInt();

        if (userGuess == randomlyGeneratedNumber) {
            System.out.println("Your guess is correct.");
        } else {
            System.out.println("Your guess is incorrect.");
        }
    }
}
