
import java.util.ArrayList;
import java.util.Scanner;

/**
 * (Addition quiz) Rewrite Listing 5.1 RepeatAdditionQuiz.java to alert the user
 * if an answer is entered again. Hint: use an array list to store answers. Here
 * is a
 * sample run:
 *
 * What is 5 + 9? 12
 * Wrong answer. Try again. What is 5 + 9? 34
 * Wrong answer. Try again. What is 5 + 9? 12
 * You already entered 12
 * Wrong answer. Try again. What is 5 + 9? 14
 * You got it!
 *
 * Output:
 * What is 4 + 5? 3
 * Wrong answer. Try again. What is 4 + 5? 1
 * Wrong answer. Try again. What is 4 + 5? 2
 * Wrong answer. Try again. What is 4 + 5? 3
 * You already entered 3
 * Wrong answer. Try again. What is 4 + 5? 9
 * You got it!
 *
 * @author martinfall
 */
public class AdditionQuiz {

    public static void main(String[] args) {
        // Create a boolean flag set to false.
        boolean flag = false;

        // Generate two random integers between 0 and 9.
        int number1 = (int) (Math.random() * 10);
        int number2 = (int) (Math.random() * 10);

        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Create an ArrayList of type Integer to hold our answers
        ArrayList<Integer> answers = new ArrayList<>();

        System.out.print("What is " + number1 + " + " + number2 + "? ");
        // int answer = number1 + number2;
        // Add the answer to our list
        answers.add(input.nextInt());

        while (!flag) {
            if (number1 + number2 == answers.get(answers.size() - 1)) {
                flag = true;
                break;
            }
            System.out.print("Wrong answer. Try again. What is "
                    + number1 + " + " + number2 + "? ");
            int answer = input.nextInt();

            if (answers.contains(answer)) {
                System.out.println("You already entered " + answer);
            } else {
                answers.add(answer);
            }
        }

        System.out.println("You got it!");
    }
}
