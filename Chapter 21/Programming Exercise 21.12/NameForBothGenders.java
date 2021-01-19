
import java.io.*;
import java.util.*;

/**
 * (Name for both genders) Write a program that prompts the user to enter one of
 * the filenames described in Programming Exercise 12.31 and displays the names
 * that are used for both genders in the file. Use sets to store names and find
 * common names in two sets. Here is a sample run:
 *
 * Enter a file name for baby name ranking: babynamesranking2001.txt
 * 69 names used for both genders
 * They are Tyler Ryan Christian ...]
 *
 * Output:
 * 69 names used for both genders
 * They are Addison Alex Alexis Amari Angel Ariel Armani Ashton Aubrey Avery
 * Baby Bailey Cameron Carson Casey Chandler Christian Courtney Dakota Devin
 * Devon Devyn Dominique Drew Gabriel Guadalupe Harley Hayden Hunter Jade Jaden
 * Jadyn Jaiden Jaime Jamie Jayden Jaylin Jessie Jordan Jordyn Justice Kasey
 * Kelly Kendall Kennedy Logan London Mackenzie Micah Morgan Parker Payton
 * Peyton Quinn Raven Reagan Reese Reilly Riley Ryan Rylee Sage Shannon Shea
 * Sidney Skylar Skyler Taylor Tyler
 *
 *
 * @author martinfall
 */
public class NameForBothGenders {

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {

        // Create two sets to store names of boys and girls
        HashSet<String> boys = new HashSet<>();
        HashSet<String> girls = new HashSet<>();

        // Try with resources to autoclose the scanner
        try (Scanner scanner = new Scanner(System.in)) {
            // Create a new Scanner object
            System.out.print("Enter a file name for baby name ranking: ");

            // Create a file from user input and test if it exists
            File file = new File(scanner.nextLine());
            if (!file.exists() || !file.isFile()) {
                System.out.println(file.getName() + " is not a valid file.");
                System.exit(0); // Exit the program gracefully
            }

            // Create a scanner and parse the contents of file
            try (Scanner input = new Scanner(file)) {
                while (input.hasNext()) {
                    // Scan a line, split the string, and remove null elements
                    String[] tokens = input.nextLine().split("[\\t ]");

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
                    String boy = clean[1]; // Boy name
                    String girl = clean[3]; // Girl name

                    // Update boy and girl name sets
                    boys.add(boy);
                    girls.add(girl);
                }
            }
        }

        // Removes from boys all of elements that are not contained in girls
        HashSet<String> results = (HashSet<String>) boys.clone();
        results.retainAll(girls);

        // Display the results
        System.out.println(results.size() + " names used for both genders");
        System.out.print("They are ");

        // Iterate through the sorted tree set and display the names to console
        TreeSet<String> sortedResults = new TreeSet<>(results);
        sortedResults.forEach(result -> {
            System.out.print(result + " ");
        });
    }
}
