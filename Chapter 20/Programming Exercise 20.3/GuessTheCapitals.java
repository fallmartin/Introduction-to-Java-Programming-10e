
import java.util.*;

/**
 * (Guessing the capitals) Rewrite Programming Exercise 8.37 to store the pairs
 * of states and capitals so that the questions are displayed randomly.
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

        List<String[]> list = new ArrayList<>(Arrays.asList(capitals));

        // Create a counter to count the number of correct answers
        int count = 0;

        // Ask the question 50 times
        while (!list.isEmpty()) {
            // Generate a random index in the 0 to list size range
            int randomIndex = (int) (Math.random() * list.size());

            String[] currentPair = list.get(randomIndex);
            list.remove(currentPair);

            // Ask the question
            System.out.print("What is the capital of " + currentPair[0] + "? ");
            // Collect the user's answer and store it in the variable capital
            String capital = input.nextLine();
            // If the answer is correct
            if (capital.equalsIgnoreCase(currentPair[1])) {
                System.out.println("Your answer is correct");
                count++;
            } else { // If the answer is not correct
                System.out.println("The correct answer should be "
                        + currentPair[1]);
            }
        }

        // Display the number of correct guesses
        System.out.println("The correct count is " + count);
    }
}
