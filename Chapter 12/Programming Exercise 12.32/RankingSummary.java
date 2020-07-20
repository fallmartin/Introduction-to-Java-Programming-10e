
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * (Ranking summary) Write a program that uses the files described in
 * Programming
 * Exercise 12.31 and displays a ranking summary table for the first five
 * girl’s and boy’s names as follows:
 *
 * Year Rank 1 Rank 2 Rank 3 Rank 4 Rank 5 Rank 1 Rank 2 Rank 3 Rank 4 Rank 5
 * 2010 Isabella Sophia Emma Olivia Ava Jacob Ethan Michael Jayden William
 * 2009 Isabella Emma Olivia Sophia Ava Jacob Ethan Michael Alexander William
 * ...
 * 2001 Emily Madison Hannah Ashley Alexis Jacob Michael Matthew Joshua
 * Christopher
 *
 * @author martinfall
 */
public class RankingSummary {

    /**
     * Main method.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Create a file object for parent directory
        File directory = new File("babynameranking");

        if (!directory.exists()) {
            System.out.println("The directory " + directory.getName()
                    + " doesn't exist");
            System.exit(1);
        }

        // Create a FilenameFilter object to pass to parameterized listFiles method
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.startsWith("babynameranking") && name.endsWith(".txt")) {
                    return true;
                }
                return false;
            }
        };

        // Create a File array of all files in the parent directory
        File[] files = directory.listFiles(filter);

        // Sort the File objects in the array in descedning order to facilitate processing
        Arrays.sort(files, Collections.reverseOrder());

        // Print the title
        System.out.println("-----------------------------------------------------"
                + "--------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%n",
                "Year", "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5",
                "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5");
        System.out.println("-----------------------------------------------------"
                + "--------------------------------------------------------");

        // Loop through the array of File objects
        for (File f : files) {
            try (Scanner input = new Scanner(f);) {
                // babynameranking2001
                System.out.printf("%-10s", f.getName().substring(15, 19));

                // Create String arrays for male and female names
                String[] femaleNames = new String[5];
                String[] maleNames = new String[5];

                // Build the top name arrays for male and female names
                for (int i = 0; i < 5; i++) {
                    String[] split = input.nextLine().split("\\s");
                    femaleNames[i] = split[3];
                    maleNames[i] = split[1];
                }
                // Print the top 5 female then top 5 male names
                printNames(femaleNames);
                printNames(maleNames);
            }
            // Print a new line at the end of each line
            System.out.println();
        }
    }

    /**
     * Print an array of names in the format needed for the summary.
     *
     * @param names
     */
    public static void printNames(String[] names) {
        System.out.printf("%-10s%-10s%-10s%-10s%-10s",
                names[0], names[1], names[2], names[3], names[4]);
    }
}
