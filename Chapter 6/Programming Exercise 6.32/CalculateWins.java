
/**
 * ﻿(Game: chance of winning at craps) Revise Exercise 6.30 to run it 10,000 times
 * and display the number of winning games.
 *
 * All output to console has been commented out to improve performance.
 * 
 * Output: 
 * You won 4741 times.
 * 
 *
 * @author martinfall
 */
public class CalculateWins {

    static int point = 0;
    static int win = 0;
    static boolean flag = false;

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i <= 10000; i++) {
            while (flag == false) {
                playTurn();
            }
            flag = false;
            point = 0;
            // System.out.println("----------");
        }

        System.out.printf("You won %d times.", win);
    }

    /**
     * Roll two dice
     */
    public static void playTurn() {
        // Roll two dice
        int number1 = rollDice();
        int number2 = rollDice();

        // Calculate sum
        int sum = number1 + number2;

        // Display the roll
        // System.out.printf("You rolled %d + %d = %d%n", number1, number2, sum);

        // Check the sum of two dice
        checkSum(sum);

        // Formatting line
        // System.out.println();
    }

    /**
     * Check the sum of the two dice
     *
     * @param sum
     */
    public static void checkSum(int sum) {
        /* ﻿If the sum is 2, 3, or 12 (called craps), you lose */
        if ((sum == 2 || sum == 3 || sum == 12) && point == 0) { // LOSS
            flag = true;
            // System.out.println("You lose");
        } else if ((sum == 7 || sum == 11) && point == 0) { // WIN
            /* ﻿if the sum is 7 or 11 (called natural), you win*/
            flag = true;
            // System.out.println("You win");
            win++;
        } else { // POINT TO DETERMINE WIN OR LOSS
            /*﻿if the sum is another value (i.e., 4, 5, 6, 8, 9, or 10), a point is
            established. Continue to roll the dice until either a 7 or the same 
            point value is rolled. If 7 is rolled, you lose. Otherwise, you win. */
            if (sum == point) {
                // System.out.println("You win");
                flag = true;
                win++;
            } else if (sum == 7) {
                // System.out.println("You lose");
                flag = true;
            } else {
                point = sum;
                flag = false;
                // System.out.println("You lose"); // Not sure about the rules here
            }
        }
    }

    /**
     * Return a value between 1 and 6
     *
     * @return
     */
    public static int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }
}
