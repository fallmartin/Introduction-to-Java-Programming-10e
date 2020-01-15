
/**
 * Write a program that prompts the user to enter a letter grade A, B, C, D, or F
 * and displays its corresponding numeric value 4, 3, 2, 1, or 0.
 * Here is a sample run:
 *
 * Enter a letter grade: B
 * The numeric value for grade B is 3
 *
 * Enter a letter grade: T
 * T is an invalid grade
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class ConvertLetterGradeToNumber {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a letter grade
        System.out.print("Enter a letter grade: ");
        String letterGrade = input.nextLine();

        switch (letterGrade) {
            case "A":
                System.out.println("The numeric value for "
                        + letterGrade + " is 4");
                break;
            case "B":
                System.out.println("The numeric value for "
                        + letterGrade + " is 3");
                break;
            case "C":
                System.out.println("The numeric value for "
                        + letterGrade + " is 2");
                break;
            case "D":
                System.out.println("The numeric value for "
                        + letterGrade + " is 1");
                break;
            case "F":
                System.out.println("The numeric value for "
                        + letterGrade + " is 0");
                break;
            default:
                System.out.println(letterGrade + " is an invalid grade");
        }
    }
}
