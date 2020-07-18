
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * (Process large dataset) A university posts its employees’ salaries at
 * http://cs.armstrong.edu/liang/data/Salary.txt. Each line in the file consists
 * of a faculty member’s first name, last name, rank, and salary (see
 * Programming Exercise 12.24). Write a program to display the total salary for
 * assistant professors, associate professors, full professors, and all faculty,
 * respectively, and display the average salary for assistant professors,
 * associate professors, full professors, and all faculty, respectively.
 *
 * Note: The URL provided in the book is deprecated. I will use a .txt file
 * instead.
 *
 * Output:
 * Total salary for assistant professors: $22,182,763.69
 * Total salary for associate professors: $26,899,430.84
 * Total salary for full professors: $34,424,612.50
 * Total salary for all faculty: $83,506,807.03
 *
 * Average salary for assistant professors: $64,297.87
 * Average salary for associate professors: $85,124.78
 * Average salary for full professors: $101,547.53
 * Average salary for all faculty: $83,506.81
 *
 * @author martinfall
 */
public class ProcessLargeDataset {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a new File object
        File file = new File("src/main/java/Salary.txt");

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("The file " + file.getName() + " does not exist.");
            System.exit(1);
        }

        // Create input file
        try (Scanner input = new Scanner(file);) {
            double totalSalaryAssistant = 0;
            double totalSalaryAssociate = 0;
            double totalSalaryFull = 0;
            int assistants = 0;
            int associates = 0;
            int fulls = 0;

            while (input.hasNext()) {
                String line = input.nextLine();
                if (line.contains("assistant")) {
                    totalSalaryAssistant += getSalary(line);
                    assistants++;
                } else if (line.contains("associate")) {
                    totalSalaryAssociate += getSalary(line);
                    associates++;
                } else if (line.contains("full")) {
                    totalSalaryFull += getSalary(line);
                    fulls++;
                }
            }

            // The line below should add up to 1000
            // System.out.println(assistants + associates + fulls);
            // Totals
            System.out.print("Total salary for assistant professors: ");
            System.out.printf("$%,.2f%n", totalSalaryAssistant);

            System.out.print("Total salary for associate professors: ");
            System.out.printf("$%,.2f%n", totalSalaryAssociate);

            System.out.print("Total salary for full professors: ");
            System.out.printf("$%,.2f%n", totalSalaryFull);

            System.out.print("Total salary for all faculty: ");
            System.out.printf("$%,.2f%n", totalSalaryAssistant + totalSalaryAssociate + totalSalaryFull);

            // Print a line separator
            System.out.println();

            // Averages
            System.out.print("Average salary for assistant professors: ");
            System.out.printf("$%,.2f%n", totalSalaryAssistant / assistants);

            System.out.print("Average salary for associate professors: ");
            System.out.printf("$%,.2f%n", totalSalaryAssociate / associates);

            System.out.print("Average salary for full professors: ");
            System.out.printf("$%,.2f%n", totalSalaryFull / fulls);

            System.out.print("Average salary for all faculty: ");
            System.out.printf("$%,.2f%n", (totalSalaryAssistant + totalSalaryAssociate + totalSalaryFull) / 1000);
        }
    }

    public static double getSalary(String line) {
        return Double.parseDouble(line.substring(
                line.indexOf("$") + 1, line.length()).replaceAll(",", ""));
    }
}
