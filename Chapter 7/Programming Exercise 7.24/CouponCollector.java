
import java.util.Arrays;

/**
 * (Simulation: coupon collector’s problem) Coupon collector is a classic
 * statistics problem with many practical applications. The problem is to pick
 * objects from a set of objects repeatedly and find out how many picks are
 * needed for all the ﻿objects to be picked at least once. A variation of the
 * problem is to pick cards from a shuffled deck of 52 cards repeatedly and find
 * out how many picks are needed before you see one of each suit. Assume a
 * picked card is placed back in the deck before picking another. Write a
 * program to simulate the number of picks needed to get four cards from each
 * suit and display the four cards picked (it is possible a card may be picked
 * twice). Here is a sample run of the program:
 *
 * Queen of Spades 
 * 5 of Clubs 
 * Queen of Hearts 
 * 4 of Diamonds 
 * Number of picks: 12
 *
 * @author martinfall
 */
public class CouponCollector {

    public static void main(String[] args) {
        // Counter for picks
        int picks = 0;

        // Boolean flags that are set to true when each suit is found
        boolean spades = false;
        boolean hearts = false;
        boolean diamonds = false;
        boolean clubs = false;

        // Card sequence for easy reading once the solution is reached
        int[] cards = new int[4];

        // Declare an array ref var, create the array, and assign its ref to ref var
        final int N = 52;
        int[] deck = new int[N];

        // Suits and ranks array initializers
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King"};

        // Initialize the deck of cards
        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }

        // Shuffle the deck of cards
        for (int i = 0; i < deck.length; i++) {
            // Generate a random index between 0 and 51
            int randomIndex = (int) (Math.random() * deck.length);

            int temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }

        while (!spades || !hearts || !diamonds || !clubs) {
            picks++; // increment the picks counter
            // Pick a random card
            int randomIndex = (int) (Math.random() * deck.length);
            // System.out.println(deck[randomIndex]); // Display the random card
            
            // Switch randomIndex
            switch (deck[randomIndex] / 13) {
                // Spades
                case 0:
                    spades = true;
                    cards[0] = deck[randomIndex];
                    break;
                // Hearts
                case 1:
                    hearts = true;
                    cards[1] = deck[randomIndex];
                    break;
                // Diamonds
                case 2:
                    diamonds = true;
                    cards[2] = deck[randomIndex];
                    break;
                // Clubs
                case 3:
                    clubs = true;
                    cards[3] = deck[randomIndex];
                    break;
                default:
                    // Catch errors here
                    break;
            }
        }

        // Display the cards of each suits that we picked randomly
        for (int i = 0; i < cards.length; i++) {
            String suit = suits[cards[i] / 13];
            String rank = ranks[cards[i] % 13];
            System.out.println(rank + " of " + suit);
        }

        // Display the number of picks
        System.out.println("Number of picks: " + picks);
    }
}
