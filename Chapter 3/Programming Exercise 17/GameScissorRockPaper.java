
/**
 * (Game: scissor, rock, paper) Write a program that plays the popular
 * scissor-rock-paper game. (A scissor can cut a paper, a rock can knock a
 * scissor, and a paper can wrap a rock.) The program randomly generates a number
 * 0, 1, or 2 representing scissor, rock, and paper. The program prompts the user
 * to enter a number 0, 1, or 2 and displays a message indicating whether the user
 * or the computer wins, loses, or draws. Here are sample runs:
 *
 * scissor (0), rock (1), paper (2): 1
 * The computer is scissor. You are rock. You won
 *
 * scissor (0), rock (1), paper (2): 2
 * The computer is paper. You are paper too. It is a draw
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class GameScissorRockPaper {

    static String determineWinner(int computer, int user) {
        String str = "";

        if (computer == user) {
            str = "It is a draw";
        } else if (computer == 0) { // scissor (0), rock (1), paper (2)
            if (user == 1) {
                str = "You won";
            } else if (user == 2) {
                str = "You lost";
            }
        } else if (computer == 1) { // scissor (0), rock (1), paper (2)
            if (user == 0) {
                str = "You lost";
            } else if (user == 2) {
                str = "You won";
            }
        } else if (computer == 2) { // scissor (0), rock (1), paper (2)
            if (user == 0) {
                str = "You won";
            } else if (user == 1) {
                str = "You lost";
            }
        }
        return str;
    }

    static String checkInteger(int number) {
        // Create an empty string variable str
        String str = "";

        // Switch 0, 1, and 2 and return their corresponding String
        switch (number) {
            case 0:
                str = "scissor";
                break;
            case 1:
                str = "rock";
                break;
            case 2:
                str = "paper";
                break;
        }
        return str;
    }

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Generate a number 0, 1, or 2
        int computer = (int) (Math.random() * 3);

        // Display computer generated integer for testing
        // System.out.println(computer);
        // Prompt the user for input
        System.out.print("scissor (0), rock (1), paper (2): ");

        // Collect input from the user
        int user = input.nextInt();
        System.out.println("The computer is " + checkInteger(computer)
                + ". You are " + checkInteger(user)
                + (computer == user ? " too. " : ". ")
                + determineWinner(computer, user));
    }
}
