
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;

/**
 * (Baby name popularity ranking) The popularity ranking of baby names from
 * years 2001 to 2010 is downloaded from www.ssa.gov/oact/babynames and stored
 * in files named babynameranking2001.txt, babynameranking2002.txt, . . . ,
 * babynameranking2010.txt. Each file contains one thousand lines. Each line
 * contains a ranking, a boy’s name, number for the boy’s name, a girl’s name,
 * and number for the girl’s name. For example, the first two lines in the file
 * babynameranking2010.txt are as follows:
 *
 * 1 Jacob 21,875 Isabella 22,731
 * 2 Ethan 17,866 Sophia 20,477
 *
 * So, the boy’s name Jacob and girl’s name Isabella are ranked #1 and the boy’s
 * name Ethan and girl’s name Sophia are ranked #2. 21,875 boys are named
 * Jacob and 22,731 girls are named Isabella. Write a program that prompts the
 * user to enter the year, gender, and followed by a name, and displays the
 * ranking of the name for the year. Here is a sample run:
 *
 * Enter the year: 2010
 * Enter the gender: M
 * Enter the name: Javier
 * Javier is ranked #190 in year 2010
 *
 * Enter the year: 2010
 * Enter the gender: F
 * Enter the name: ABC
 * The name ABC is not ranked in year 2010
 *
 * @author martinfall
 */
public class BabyNamePopularityRanking {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the year
        System.out.print("Enter the year: ");
        int year = input.nextInt();

        // Clear the input
        input.nextLine();

        // Prompt the user to enter the gender
        System.out.print("Enter the gender: ");
        char gender = input.nextLine().charAt(0);

        // Prompt the user to enter the name
        System.out.print("Enter the name: ");
        String name = input.nextLine();

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

        // Create a flag boolean variable
        boolean flag = false;

        // Perform operations for each file in the array
        for (File f : files) {
            // Find the file corresponding to the year entered by the user
            if (f.getName().contains(Integer.toString(year))) {
                // Find the line containing the name
                try (Scanner in = new Scanner(f);) {
                    while (in.hasNext()) {
                        String str = in.nextLine();
                        if (str.contains(name)) {
                            // Once found, raise the flag
                            flag = true;
                            // Split the string using ws delimiter
                            String[] split = str.split("\\s");
                            // The element at split[0] is the rank
                            System.out.println(name + " is ranked #" + split[0] 
                                    + " in year " + year);
                            // Uncomment below to exit once name is found and displayed to console
                            // System.exit(0);
                        }
                    }
                }
            }
        }
        if (!flag) {
            System.out.println("The name " + name + " is not ranked in year " + year);
        }
    }
}
