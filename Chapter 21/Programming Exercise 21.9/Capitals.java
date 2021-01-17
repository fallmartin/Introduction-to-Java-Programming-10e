
import java.util.*;

/**
 * (Guess the capitals using maps) Rewrite Programming Exercise 8.37 to store
 * pairs of each state and its capital in a map. Your program should prompt the
 * user to enter a state and should display the capital for the state.
 *
 * @author martinfall
 */
public class Capitals {

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Generate a hash map with pairs of each state and its capital
        Map<String, String> map = getMap();

        // Create a counter to count the number of correct answers
        int count = 0;

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Ask the question 50 times
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry entry : entrySet) {
            // Ask the question
            System.out.print("What is the capital of " + entry.getKey() + "? ");

            // Collect the user's answer and store it in the variable capital
            String capital = input.nextLine();

            // If the answer is correct
            if (capital.equalsIgnoreCase((String) entry.getValue())) {
                System.out.println("Your answer is correct");
                count++;
            } else { // If the answer is not correct
                System.out.println("The correct answer should be "
                        + entry.getValue());
            }
        }

        // Close the scanner
        input.close();

        // Display the number of correct guesses
        System.out.println("The correct count is " + count);
    }

    private static Map<String, String> getMap() {
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

        // Create a map and populate it from the string array
        Map<String, String> map = new HashMap<>();
        for (String[] pair : capitals) {
            map.put(pair[0], pair[1]);
        }

        return map;
    }
}
