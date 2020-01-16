
/**
 * Write a program that prompts the user to enter two characters and displays the
 * major and status represented in the characters. The first character indicates
 * the major and the second is number character 1, 2, 3, 4, which indicates
 * whether a student is a freshman, sophomore, junior, or senior. Suppose the
 * following characters are used to denote the majors:
 *
 * M: Mathematics
 * C: Computer Science
 * I: Information Technology
 *
 * Here is a sample run:
 *
 * Enter two characters: M1
 * Mathematics Freshman
 *
 * Enter two characters: C3
 * Computer Science Junior
 *
 * Enter two characters: T3
 * Invalid input
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class StudentMajorAndStatus {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two characters
        System.out.print("Enter two characters: ");
        String designation = input.nextLine();

        // Split the string into major and status
        char major = designation.charAt(0);
        char status = designation.charAt(1);

        // Create an empty String
        String temp = "";

        // Switch throught the major char and add to temp String
        switch (major) {
            case 'M':
                temp += "Mathematics ";
                break;
            case 'C':
                temp += "Computer Science ";
                break;
            case 'I':
                temp += "Information Technology ";
                break;
            default:
                System.out.println("Invalid input");
                System.exit(0);
                break;
        }

        // Switch throught the status char and add to temp String
        switch (status) {
            case '1':
                temp += "Freshman";
                break;
            case '2':
                temp += "Sophomore";
                break;
            case '3':
                temp += "Junior";
                break;
            case '4':
                temp += "Senior";
                break;
            default:
                System.out.println("Invalid input");
                System.exit(0);
                break;
        }

        // Display the results
        System.out.println(temp);
    }
}
