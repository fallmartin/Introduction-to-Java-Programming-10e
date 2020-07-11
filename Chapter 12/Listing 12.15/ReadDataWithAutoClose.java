
import java.util.Scanner;
import java.io.File;

/**
 * Output:
 * John T Smith 90
 * Eric K Jones 85
 *
 * @author martinfall
 */
public class ReadDataWithAutoClose {

    public static void main(String[] args) throws Exception {
        // Create a file instance
        File file = new File("scores.txt");

        try (Scanner input = new Scanner(file);) { // Create a Scanner for the file
            // Read data from a file
            while (input.hasNext()) {
                String firstName = input.next();
                String mi = input.next();
                String lastName = input.next();
                int score = input.nextInt();
                System.out.println(
                        firstName + " " + mi + " " + lastName + " " + score);

            }
        }
    }
}
