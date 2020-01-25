
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author martinfall
 */
public class GuessNumber {

    public static void main(String[] args) {
        // Generate a random number to be guessed between 0-100
        int number = (int) (Math.random() * 101);

        // Display random number for testing purposes
        System.out.println(number);

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("Guess a magic number between 0 and 100");

        // Create the variable guess and initialize it to a value outside of 0-100
        int guess = -1;

        // loop continuation condition is that guess is not equal to number
        // The loop will execute until the loop continuation condition is no longer valid
        while (guess != number) {
            // Prompt the user to enter a number
            System.out.print("\nEnter your guess: ");
            guess = input.nextInt();

            if (guess == number) {
                System.out.println("Yes, the number is " + number);
            } else if (guess > number) {
                System.out.println("Your guess is too high");
            } else {
                System.out.println("Your guess is too low");
            }
        } // End of loop
    }
}
