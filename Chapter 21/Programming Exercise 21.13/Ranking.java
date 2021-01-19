
import java.io.*;
import java.util.*;

/**
 * (Baby name popularity ranking) Revise Programming Exercise 21.11 to prompt
 * the user to enter year, gender, and name and display the ranking for the
 * name. Prompt the user to enter another inquiry or exit the program. Here is a
 * sample run:
 *
 * Sample:
 * Enter the year: 2010
 * Enter the gender: M
 * Enter the name: Javier
 * Boy name Javier is ranked #190 in year 2010
 * Enter another inquiry? Y
 * Enter the year: 2001
 * Enter the gender: F
 * Enter the name: Emily
 * Girl name Emily is ranked #1 in year 2001
 * Enter another inquiry? N
 *
 * Output:
 * Enter the year: 2010
 * Enter the gender: M
 * Enter the name: Javier
 * Boy name Javier is ranked #190 in year 2010
 * Enter another inquiry? Y
 * Enter the year: 2001
 * Enter the gender: F
 * Enter the name: Emily
 * Girl name Emily is ranked #1 in year 2001
 * Enter another inquiry? N
 *
 * @author martinfall
 */
public class Ranking {

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // Create a new scanner and accept user input
        try (Scanner input = new Scanner(System.in)) {
            // Test value to stop the d-while loop
            char C = 'Y';

            do {
                System.out.print("Enter the year: ");
                int year = Integer.parseInt(input.nextLine());

                System.out.print("Enter the gender: ");
                char gender = Character.toUpperCase(input.nextLine().charAt(0));

                System.out.print("Enter the name: ");
                String name = input.nextLine();

                int rank = getRank(year, gender, name);

                // Format the result message
                String result = String.format("%s name %s is ranked #%d in year %d",
                        (gender == 'M' ? "Boy" : "Girl"), name, rank, year);
                System.out.println(result);

                // 
                System.out.print("Enter another inquiry? ");
                C = Character.toUpperCase(input.nextLine().charAt(0));
            } while (C == 'Y');
        }
    }

    private static int getRank(int year, char gender, String name)
            throws Exception {
        // Create a new file and verify if valid
        File file = new File("babynamesranking" + year + ".txt");
        if (!file.exists() || !file.isFile()) {
            System.out.println("No data available for year " + year);
            System.exit(0); // Terminate the program gracefully
        }

        // Create hash maps for the boy and girl names for the current year
        Map<String, Integer> boys = new HashMap<>();
        Map<String, Integer> girls = new HashMap<>();

        // Create a new scanner and iterate over the contents of the file
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            // Scan a line and split the string around spaces and tabs delimiters
            String[] tokens = scanner.nextLine().split("[\\t ]");

            // Create an array of line tokens without null elements
            String[] clean = new String[5];
            int cleanIndex = 0;
            for (String token : tokens) {
                if (!token.equals("")) {
                    clean[cleanIndex] = token;
                    cleanIndex++;
                }
            }

            // Array format: rank, boy name, number, girl name, number
            int rank = Integer.parseInt(clean[0]);
            String boy = clean[1];
            String girl = clean[3];

            // Update boy and girl name maps
            boys.put(boy, rank);
            girls.put(girl, rank);
        }

        // Determine the rank of the name for the current year
        int rank = 0;
        if (gender == 'M') {
            if (boys.containsKey(name)) {
                rank = boys.get(name);
            }
        } else {
            if (girls.containsKey(name)) {
                rank = girls.get(name);
            }
        }

        // Return the rank of the name for the given year
        return rank;
    }
}
