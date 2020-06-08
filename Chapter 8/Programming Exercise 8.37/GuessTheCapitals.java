
import java.util.Scanner;

/**
 * (Guess the capitals) Write a program that repeatedly prompts the user to
 * enter
 * a capital for a state. Upon receiving the user input, the program reports
 * whether the answer is correct. Assume that 50 states and their capitals are
 * stored in a two-dimensional array, as shown in Figure 8.10. The program
 * prompts the user to answer all states’ capitals and displays the total
 * correct
 * count. The user’s answer is not case-sensitive.
 *
 * Alabama Montgomery
 * Alaska Juneau
 * Arizona Phoenix
 * ... ...
 * ... ...
 *
 * Here is a sample run:
 *
 * What is the capital of Alabama? Montogomery
 * The correct answer should be Montgomery
 * What is the capital of Alaska? Juneau
 * Your answer is correct
 * What is the capital of Arizona? ...
 * ...
 * The correct count is 35
 *
 * @author martinfall
 */
public class GuessTheCapitals {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Start the test
        StartGuessing(input);
    }

    public static void StartGuessing(Scanner input) {
        // Create a a two-dimensional array that stores the 50 states and their capitals
        String[][] capitals = {
            {"Alabama", "Montgomery"},
            {"Alaska", "Juneau"},
            {"Arizona", "Phoenix"},
            {"Arkansas", "Little Rock"},
            {"California", "Sacramento"},
            {"Colorado", "Denver"},
            {"Connecticut", "Hartford"},
            {"Delaware", "Dover"},
            {"Florida", "Tallahassee"},
            {"Georgia", "Atlanta"},
            {"Hawaii", "Honolulu"},
            {"Idaho", "Boise"},
            {"Illinois", "Springfield"},
            {"Indiana", "Indianapolis"},
            {"Iowa", "Des Moines"},
            {"Kansas", "Topeka"},
            {"Kentucky", "Frankfort"},
            {"Louisiana", "Baton Rouge"},
            {"Maine", "Augusta"},
            {"Maryland", "Annapolis"},
            {"Massachusetts", "Boston"},
            {"Michigan", "Lansing"},
            {"Minnesota", "St. Paul"},
            {"Mississippi", "Jackson"},
            {"Missouri", "Jefferson City"},
            {"Montana", "Helena"},
            {"Nebraska", "Lincoln"},
            {"Nevada", "Carson City"},
            {"New Hampshire", "Concord"},
            {"New Jersey", "Trenton"},
            {"New Mexico", "Santa Fe"},
            {"New York", "Albany"},
            {"North Carolina", "Raleigh"},
            {"North Dakota", "Bismarck"},
            {"Ohio", "Columbus"},
            {"Oklahoma", "Oklahoma City"},
            {"Oregon", "Salem"},
            {"Pennsylvania", "Harrisburg"},
            {"Rhode Island", "Providence"},
            {"South Carolina", "Columbia"},
            {"South Dakota", "Pierre"},
            {"Tennessee", "Nashville"},
            {"Texas", "Austin"},
            {"Utah", "Salt Lake City"},
            {"Vermont", "Montpelier"},
            {"Virginia", "Richmond"},
            {"Washington", "Olympia"},
            {"West Virginia", "Charleston"},
            {"Wisconsin", "Madison"},
            {"Wyoming", "Cheyenne"}
        };

        // Create a counter to count the number of correct answers
        int count = 0;

        // Ask the question 50 times
        for (int i = 0; i < capitals.length; i++) {
            // Ask the question
            System.out.print("What is the capital of " + capitals[i][0] + "? ");
            // Collect the user's answer and store it in the variable capital
            String capital = input.nextLine();
            // If the answer is correct
            if (capital.equalsIgnoreCase(capitals[i][1])) {
                System.out.println("Your answer is correct");
                count++;
            } else { // If the answer is not correct
                System.out.println("The correct answer should be "
                        + capitals[i][1]);
            }
        }
        // Display the number of correct guesses
        System.out.println("The correct count is " + count);
    }
}
