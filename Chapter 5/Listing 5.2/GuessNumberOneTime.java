/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class GuessNumberOneTime {

    public static void main(String[] args) {
        // Generate a random number to be guessed between 0-100
        int number = (int) (Math.random() * 101);

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("Guess a magic number between 0 and 100");

        // Prompt the user to enter a number
        System.out.print("\nEnter your guess: ");
        int guess = input.nextInt();

        if (guess == number) {
            System.out.println("Yes, the number is " + number);
        } else if (guess > number) {
            System.out.println("Your guess is too high");
        } else {
            System.out.println("Your guess is too low");
        }
    }
}
