
import java.util.*;

/**
 * (Addition quiz) Rewrite Programming Exercise 11.16 to store the answers in a
 * set rather than a list.
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

        // Create a HashSet of type Integer to hold our answers
        HashSet<Integer> answers = new HashSet<>();

        // Accept input from user
        System.out.print("What is " + number1 + " + " + number2 + "? ");

        // Add the answer to our list
        int answer = input.nextInt();
        answers.add(answer);

        while (!flag) {
            if (number1 + number2 == (int) answers.toArray()[answers.size() - 1]) {
                flag = true;
                break;
            }
            System.out.print("Wrong answer. Try again. What is "
                    + number1 + " + " + number2 + "? ");
            answer = input.nextInt();

            if (answers.contains(answer)) {
                System.out.println("You already entered " + answer);
            } else {
                answers.add(answer);
            }
        }

        System.out.println("You got it!");
    }
}
