
/**
 * Write a program that prompts the user to enter a letter and check whether the
 * letter is a vowel or consonant. Here is a sample run:
 *
 * Enter a letter: B
 * B is a consonant
 *
 * Enter a letter grade: a
 * a is a vowel
 *
 * Enter a letter grade: #
 * # is an invalid input
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class VowelOrConsonant {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a letter
        System.out.print("Enter a letter: ");
        String s = input.nextLine();

        // Convert String s to integer
        int decimal = (int) s.charAt(0);

        // System.out.println("a is " + (int) 'a');
        // System.out.println("z is " + (int) 'z');
        // System.out.println("A is " + (int) 'A');
        // System.out.println("Z is " + (int) 'Z');

        if ((decimal >= 97 && decimal <= 122)
                || (decimal >= 65 && decimal <= 90)) {
            switch (s) {
                case "a":
                case "e":
                case "i":
                case "o":
                case "u":
                // case "y":
                case "A":
                case "E":
                case "I":
                case "O":
                case "U":
                    // case "Y":
                    System.out.println(s + " is a vowel");
                    break;
                default:
                    System.out.println(s + " is a consonant");
            }
        } else {
            System.out.println(s + " is an invalid input");
        }
    }
}
