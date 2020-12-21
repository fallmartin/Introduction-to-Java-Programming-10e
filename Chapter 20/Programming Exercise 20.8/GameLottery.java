
import java.util.*;

/**
 * (Game: lottery) Revise Programming Exercise 3.15 to add an additional $2,000
 * award if two digits from the user input are in the lottery number. (Hint:
 * Sort the three digits in the lottery number and three digits in the user
 * input into two lists, and use the Collection’s containsAll method to check
 * whether the two digits in the user input are in the lottery number.)
 *
 * Output:
 * Enter your three digit lottery pick: 820
 * The lottery number is 902
 * Match two digit: you win $2,000
 *
 * @author martinfall
 */
public class GameLottery {

    public static void main(String[] args) {
        // Generate a lottery number
        int lottery = (int) (Math.random() * 1000);

        // Display the lottery number for testing purposes
        // System.out.println("The lottery number is " + lottery);
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

        // Create lists for the lottery and guess digits
        List<Integer> guessList = new ArrayList<>();
        guessList.add(guessDigit1);
        guessList.add(guessDigit2);
        guessList.add(guessDigit3);
        Collections.sort(guessList);
        // System.out.println(guessList);

        List<Integer> lotteryList = new ArrayList<>();
        lotteryList.add(lotteryDigit1);
        lotteryList.add(lotteryDigit2);
        lotteryList.add(lotteryDigit3);
        Collections.sort(lotteryList);
        // System.out.println(lotteryList);

        // Display the randomly generated lottery number
        System.out.println("The lottery number is " + lottery);

        if (guess == lottery) {
            /**
             * 1. If the user input matches the lottery number in the exact
             * order, the award is $10,000.
             */
            System.out.println("Exact match: you win $10,000");
        } else if (guessList.containsAll(lotteryList)) {
            /**
             * 2. If all digits in the user input match all digits in the
             * lottery number, the award is $3,000.
             */
            System.out.println("Match all digits: you win $3,000");
        } else if (twoDigitMatch(lotteryList, guessList)) {
            /**
             * 3. if two digits from the user input match two digits in the
             * lottery number, the award is $2,000.
             */

            System.out.println("Match two digit: you win $2,000");
        } else {
            /**
             * 4. If one digit in the user input matches a digit in the lottery
             * number, the award is $1,000.
             */
            for (Integer digit : guessList) {
                if (lotteryList.contains(digit)) {
                    System.out.println("Match one digit: you win $1,000");
                    break;
                }
            }
        }
    }

    private static boolean twoDigitMatch(List lotteryList, List guessList) {
        lotteryList.retainAll(guessList);
        // System.out.println(lotteryList);
        return lotteryList.size() >= 2;
    }
}
