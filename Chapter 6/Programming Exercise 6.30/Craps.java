
/**
 * ﻿(Game: craps) Craps is a popular dice game played in casinos. Write a program
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
        switch (sum) {
            case 2:
            case 3:
            case 12:
                System.out.println("Craps! You lose!");
                flag = true;
                break;
            case 7:
            case 11:
                System.out.println("Natural! You win!");
                flag = true;
                break;
            case 4:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
                // A point is established
                // System.out.println("You rolled a " + sum);
                System.out.println("The previous point is " + point);
                
                // Check if the same point value is rolled
                if (sum == point) {
                    System.out.println("You win!");
                    flag = true;
                } else if (point == 7) {
                    System.out.println("You lose!");
                    flag = true;
                } else {
                    point = sum;
                    System.out.println("The point is now " + point);
                    flag = false;
                }
                break;
            default:
                System.out.println("Something went wrong!");
                break;
        }
        System.out.println();
    }

    /**
     * Roll two dice and heck the sum of the two dice.
     *
     */
    public static void rollTwoDice() {
        // Roll the dice two times
        int firstRoll = rollOneDice();
        int secondRoll = rollOneDice();
        
        // Add the results of the two rolls
        int sum = firstRoll + secondRoll;
        
        // Display the rolls and their sum
        System.out.println("Your rolled " + firstRoll + " + " + secondRoll + " = " + sum);
        
        checkRollResults(sum);
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
