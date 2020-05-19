
import java.util.Arrays;
import java.util.Scanner;

/**
 * (Game: bean machine) The bean machine, also known as a quincunx or the Galton
 * box, is a device for statistics experiments named after English scientist Sir
 * Francis Galton. It consists of an upright board with evenly spaced nails (or
 * pegs) in a triangular form, as shown in Figure 7.13
 *
 * Balls are dropped from the opening of the board. Every time a ball hits a
 * nail, it has a 50% chance of falling to the left or to the right. The piles
 * of balls are accumulated in the slots at the bottom of the board.
 *
 * Write a program that simulates the bean machine. Your program should prompt
 * the user to enter the number of the balls and the number of the slots in the
 * machine. Simulate the falling of each ball by printing its path. For example,
 * the path for the ball in Figure 7.13b is LLRRLLR and the path for the ball in
 * Figure 7.13c is RLRRLRR. Display the final buildup of the balls in the slots
 * in a histogram. Here is a sample run of the program:
 *
 * (Hint: Create an array named slots. Each element in slots stores the number
 * of balls in a slot. Each ball falls into a slot via a path. The number of Rs
 * in a path is the position of the slot where the ball falls. For example, for
 * the path LRLRLRR, the ball falls into slots[4], and for the path is RRLLLLL,
 * the ball falls into slots[2].)
 *
 * Output: Enter the number of balls to drop: 5 Enter the number of slots in the
 * bean machine: 8
 *
 * RRRRLRL 
 * LLLLRLL 
 * LLLRRRL 
 * LRLRLLR 
 * LLRRRLL
 *
 *           O
 *           O
 *     O     O     O
 * [0, 1, 0, 3, 0, 1, 0, 0]
 *
 * @author martinfall
 */
public class GameBeanMachine {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the number of balls to drop
        System.out.print("Enter the number of balls to drop: ");
        int numberOfBalls = input.nextInt();

        // Prompt the user to enter the number of slots in the bean machine
        System.out.print("Enter the number of slots in the bean machine: ");
        int length = input.nextInt();

        System.out.println();

        // Create a new array
        int[] slots = new int[length];

        // Display results
        playGame(numberOfBalls, slots);
        printHistogram(numberOfBalls, slots);
        System.out.println(Arrays.toString(slots));
    }

    public static void playGame(int numberOfBalls, int[] slots) {
        for (int i = 0; i < numberOfBalls; i++) {
            dropBall(slots);
        }
    }

    /**
     * Process the path and position for a single ball
     *
     * @param slots
     */
    public static void dropBall(int slots[]) {
        // New array to hold the ball's path
        int[] ballPath = new int[7];

        // For each possible bounce left or right
        for (int i = 0; i < slots.length - 1; i++) {
            ballPath[i] = fallLeftOrRight(); // is either 0L or 1R
        }

        // Print the ball's path
        printBallPath(ballPath);

        // find the ball's position once it reaches the bottom and update the array
        slots[findBallPosition(ballPath)]++;
    }

    /**
     * Print the ball's path
     *
     * @param ballPath
     */
    public static void printBallPath(int[] ballPath) {
        // System.out.println(Arrays.toString(ballPath));

        for (int i = 0; i < ballPath.length; i++) {
            System.out.print(ballPath[i] == 0 ? "L" : "R");
        }
        System.out.println();
    }

    /**
     * Returns 0 for left and 1 for right
     *
     * @return
     */
    public static int fallLeftOrRight() {
        return (int) (Math.random() * 2);
    }

    /**
     * Return the position of the ball from the ball's path
     *
     * @param ballPath
     */
    public static int findBallPosition(int[] ballPath) {
        int position = 0;

        for (int bounce : ballPath) {
            position += bounce;
        }

        // System.out.println(position);
        return position;
    }

    /**
     * Print a histogram of the game's results
     *
     * @param numberOfBalls
     * @param slots
     */
    public static void printHistogram(int numberOfBalls, int[] slots) {
        // Find the largest element in slots
        int max = findMax(slots);

        while (max > 0) {
            System.out.println();
            for (int i = 0; i < slots.length; i++) {
                System.out.print((slots[i] >= max) ? " O " : "   ");
            }

            max--;
        }
        System.out.println();
    }

    /**
     * Find the largest element in the array slots
     *
     * @param slots
     * @return
     */
    public static int findMax(int[] slots) {
        int max = 0;
        for (int num : slots) {
            if (max < num) {
                max = num;
            }
        }
        return max;
    }
}
