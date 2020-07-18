
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * (Process scores in a text file on the Web) Suppose that the text file on the
 * Web http://cs.armstrong.edu/liang/data/Scores.txt contains an unspecified
 * number of scores. Write a program that reads the scores from the file and
 * displays their total and average. Scores are separated by blanks.
 *
 * @author martinfall
 */
public class ProcessScores {

    public static void main(String[] args) throws MalformedURLException {
        // Create a URL object
        URL url = new URL("http://cs.armstrong.edu/liang/data/Scores.txt");

        try {
            // Local variables for number of scores and their cumulative total
            int counter = 0;
            double total = 0;
            
            // Create a new Scanner object and use openStream to get input
            Scanner input = new Scanner(url.openStream());
            
            while (input.hasNext()) {
                total += input.nextDouble(); // Cumulative sum
                counter++; // Count the number of scores
            }
            
            System.out.println("Scores total: " + total);
            System.out.printf("Scores average: %.2f", (total / counter));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
