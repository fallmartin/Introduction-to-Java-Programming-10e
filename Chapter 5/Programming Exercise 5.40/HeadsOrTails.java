
/**
 * ﻿(Simulation: heads or tails) Write a program that simulates flipping a coin one
 * million times and displays the number of heads and tails.
 * 
 * Output:
 * Number of heads: 499960
 * Number of tails: 500040
 */
/**
 *
 * @author martinfall
 */
public class HeadsOrTails {

    public static void main(String[] args) {
        // Create counter variables to hold the numbers of heads or tails
        int heads = 0, tails = 0; // Initialize at 0 for both

        // Generate a random number between 0 and 1
        for (int i = 0; i < 1000000; i++) {
            int side = (int) (Math.random() * 2) == 0? heads++ : tails++;
        }
        System.out.println("Number of heads: " + heads);
        System.out.println("Number of tails: " + tails);

    }
}
