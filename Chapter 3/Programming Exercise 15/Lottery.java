
/**
 * (Game: lottery) Revise Listing 3.8, Lottery.java, to generate a lottery of a
 * three-digit number. The program prompts the user to enter a three-digit number
 * and determines whether the user wins according to the following rules:
 *
 * 1. If the user input matches the lottery number in the exact order, the award
 * is $10,000.
 * 2. If all digits in the user input match all digits in the lottery number,
 * the award is $3,000.
 * 3. If one digit in the user input matches a digit in the lottery number,
 * the award is $1,000.
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class Lottery {

    public static void main(String[] args) {
        // Generate a lottery number
        int lottery = (int) (Math.random() * 1000);

        // Display the lottery number for testing purposes
        System.out.println("The lottery number is " + lottery);

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a guess
        System.out.print("Enter your three digit lottery pick: ");
        int guess = input.nextInt();

        // Create temp variables for lottery and guess
        int tempLottery = lottery;
        int tempGuess = guess;

        // Get digits from lottery
        int lotteryDigit3 = tempLottery % 10;
        tempLottery /= 10;

        int lotteryDigit2 = tempLottery % 10;
        tempLottery /= 10;

        int lotteryDigit1 = tempLottery % 10;

        // Get digits from guess
        int guessDigit3 = tempGuess % 10;
        tempGuess /= 10;

        int guessDigit2 = tempGuess % 10;
        tempGuess /= 10;

        int guessDigit1 = tempGuess % 10;

        // Display the randomly generated lottery number
        System.out.println("The lottery number is " + lottery);

        //System.out.println(lotteryDigit1 + "" + lotteryDigit2 + "" + lotteryDigit3);
        //System.out.println(guessDigit1 + "" + guessDigit2 + "" + guessDigit3);
        
        // 1. If the user input matches the lottery number in the exact order, 
        // the award is $10,000.
        if (guess == lottery) {
            System.out.println("Exact match: you win $10,000");
        } // 2. If all digits in the user input match all digits in the lottery 
        // number, the award is $3,000.
        else if ((guessDigit1 == lotteryDigit1 // 123 == 132
                && guessDigit2 == lotteryDigit3
                && guessDigit3 == lotteryDigit2)
                || (guessDigit1 == lotteryDigit2 // 123 == 213
                && guessDigit2 == lotteryDigit1
                && guessDigit3 == lotteryDigit3)
                || (guessDigit1 == lotteryDigit2 // 123 == 231
                && guessDigit2 == lotteryDigit3
                && guessDigit3 == lotteryDigit1)
                || (guessDigit1 == lotteryDigit3 // 123 == 312
                && guessDigit2 == lotteryDigit1
                && guessDigit3 == lotteryDigit2)
                || (guessDigit1 == lotteryDigit3 // 123 == 321
                && guessDigit2 == lotteryDigit2
                && guessDigit3 == lotteryDigit1)) {
            System.out.println("Match all digits: you win $3,000");
        } 
        // 3. If one digit in the user input matches a digit in the lottery 
        // number, the award is $1,000.
        else if ((guessDigit1 == lotteryDigit1
                || guessDigit1 == lotteryDigit2
                || guessDigit1 == lotteryDigit3)
                || (guessDigit2 == lotteryDigit1
                || guessDigit2 == lotteryDigit2
                || guessDigit2 == lotteryDigit3)
                || (guessDigit3 == lotteryDigit1
                || guessDigit3 == lotteryDigit2
                || guessDigit3 == lotteryDigit3)) {
            System.out.println("Match one digit: you win $1,000");
        }
    }
}
