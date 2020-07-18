
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * (Create large dataset) Create a data file with 1,000 lines. Each line in the
 * file consists of a faculty member’s first name, last name, rank, and salary.
 * The faculty member’s first name and last name for the ith line are FirstNamei
 * and LastNamei. The rank is randomly generated as assistant, associate, and
 * full. The salary is randomly generated as a number with two digits after the
 * decimal point. The salary for an assistant professor should be in the range
 * from 50,000 to 80,000, for associate professor from 60,000 to 110,000, and
 * for full professor from 75,000 to 130,000. Save the file in Salary.txt. Here
 * are some sample data:
 *
 * FirstName1 LastName1 assistant 60055.95
 * FirstName2 LastName2 associate 81112.45
 * . . .
 * FirstName1000 LastName1000 full 92255.21
 *
 * @author martinfall
 */
public class CreateLargeDataset {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        final int NUMBER_OF_LINES = 1000;

        // Create a new File object
        File dataset = new File("src/main/java/Salary.txt");

        // Create output file
        try (PrintWriter output = new PrintWriter(dataset);) {
            for (int i = 1; i <= NUMBER_OF_LINES; i++) {
                String rank = generateRank();
                double salary = generateSalary(rank);

                output.print("FirstName" + i + "\t");
                output.print("LastName" + i + "\t");
                output.print(rank + "\t");
                if (rank.equals("full")) {
                    output.print("\t");
                }
                output.print(salary + "\n");
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Returns a random rank from an array of ranks, consisting of assistant,
     * associate, and full.
     *
     * @return
     */
    public static String generateRank() {
        String[] rank = {"assistant", "associate", "full"};
        return rank[(int) (Math.random() * rank.length)];
    }

    /**
     * Returns a randomly generated salary as a number with two digits after the
     * decimal point in the appropriate range.
     *
     * @param rank
     * @return
     */
    public static double generateSalary(String rank) {
        double salary = 0;

        switch (rank) {
            case "assistant":
                salary = 50_000_00 + (int) (Math.random() * 30_000_00);
                break;
            case "associate":
                salary = 60_000_00 + (int) (Math.random() * 50_000_00);
                break;
            case "full":
                salary = 75_000_00 + (int) (Math.random() * 55_000_00);
                break;
            default:
                System.out.println("No such rank");
                break;
        }
        return salary / 100.0;
    }
}
