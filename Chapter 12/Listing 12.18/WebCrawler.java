
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class WebCrawler {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        // Prompt the user to enter a URL
        System.out.print("Enter a URL: ");
        // Collect user input and pass it to the crawler method
        String url = input.nextLine();
        crawler(url);
    }

    public static void crawler(String startingUrl) {
        // List of pending URLs
        ArrayList<String> listOfPendingURLs = new ArrayList<>();
        // List of traversed URLs
        ArrayList<String> listOfTraversedURLs = new ArrayList<>();
        // Add starting URL to list of pending URLs
        listOfPendingURLs.add(startingUrl);

        while (!listOfPendingURLs.isEmpty()
                && listOfTraversedURLs.size() <= 100) {
            // Get the first URL
            String urlString = listOfPendingURLs.remove(0);
            if (!listOfTraversedURLs.contains(urlString)) {
                listOfTraversedURLs.add(urlString);
                System.out.println("Crawl " + urlString);
            }

            for (String s : getSubURLs(urlString)) {
                if (!listOfTraversedURLs.contains(s)) {
                    // Add a new URL
                    listOfPendingURLs.add(s);
                }
            }
        }
    }

    public static ArrayList<String> getSubURLs(String urlString) {
        ArrayList<String> list = new ArrayList<>();

        try {
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;

            while (input.hasNext()) {
                // Read a line
                String line = input.nextLine();
                // Search for a URL
                current = line.indexOf("http:", current);
                while (current > 0) {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0) { // Ensure that a correct URL is found 
                        list.add(line.substring(current, endIndex));
                        current = line.indexOf("http:", endIndex);
                    } else {
                        current = -1;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return list;
    }
}
