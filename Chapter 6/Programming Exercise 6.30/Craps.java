
/**
 * (Game: craps) Craps is a popular dice game played in casinos. Write a program
 * to play a variation of the game, as follows:
 *
 * Roll two dice. Each die has six faces representing values 1, 2, …, and 6,
 * respectively. Check the sum of the two dice. If the sum is 2, 3, or 12
 * (called craps), you lose; if the sum is 7 or 11 (called natural), you win; if
 * the sum is another value (i.e., 4, 5, 6, 8, 9, or 10), a point is established.
 * Continue to roll the dice until either a 7 or the same point value is rolled.
 * If 7 is rolled, you lose. Otherwise, you win. Your program acts as a single
 * player. Here are some sample runs.
 *
 * See textbook for sample runs.
 *
 * @author martinfall
 */
public class Craps {

    static int point = 0;
    static boolean flag = false;

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        while (flag == false) {
            rollTwoDice();
        }
    }

    public static void checkRollResults(int sum) {
        /* ﻿If the sum is 2, 3, or 12 (called craps), you lose */
        if ((sum == 2 || sum == 3 || sum == 12) && point == 0) { // LOSS
            flag = true;
            System.out.println("You lose");
        } else if ((sum == 7 || sum == 11) && point == 0) { // WIN
            /* ﻿if the sum is 7 or 11 (called natural), you win*/
            flag = true;
            System.out.println("You win");
        } else { // POINT TO DETERMINE WIN OR LOSS
            /*﻿if the sum is another value (i.e., 4, 5, 6, 8, 9, or 10), a point is
            established. Continue to roll the dice until either a 7 or the same 
            point value is rolled. If 7 is rolled, you lose. Otherwise, you win. */
            if (sum == point) {
                System.out.println("You win");
                flag = true;
            } else if (sum == 7) {
                System.out.println("You lose");
                flag = true;
            } else {
                point = sum;
                flag = false;
                // System.out.println("You lose"); // Not sure about the rules here
            }
        }
    }

    /**
     * Roll two dice and heck the sum of the two dice.
     *
     */
    public static void rollTwoDice() {
        // Roll two dice
        int number1 = rollOneDice();
        int number2 = rollOneDice();

        // Calculate sum
        int sum = number1 + number2;

        // Display the roll
        System.out.printf("You rolled %d + %d = %d%n", number1, number2, sum);

        // Check the sum of two dice
        checkRollResults(sum);

        // Formatting line
        System.out.println();
    }

    /**
     * Return a value between 1 and 6
     *
     * @return
     */
    public static int rollOneDice() {
        return (int) (Math.random() * 6) + 1;
    }
}
