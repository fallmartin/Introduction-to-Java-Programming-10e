
import java.net.URL;
import java.util.*;

/**
 * (Web crawler) Rewrite Listing 12.18, WebCrawler.java, to improve the
 * performance by using appropriate new data structures for listOfPendingURLs
 * and listofTraversedURLs.
 *
 * @author martinfall
 */
public class WebCrawler {

    private static final int LIMIT = 100;

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
        Queue<String> pendingURLs = new LinkedList<>();

        // List of traversed URLs
        Set<String> traversedURLs = new HashSet<>();

        // Add starting URL to list of pending URLs
        pendingURLs.add(startingUrl);

        while (!pendingURLs.isEmpty() && traversedURLs.size() <= LIMIT) {
            // Get the first URL
            String urlString = pendingURLs.poll();

            if (!traversedURLs.contains(urlString)) {
                traversedURLs.add(urlString);
                System.out.println("Crawl " + urlString);
            }

            for (String s : getSubURLs(urlString)) {
                if (!traversedURLs.contains(s)) {
                    // Add a new URL
                    pendingURLs.add(s);
                }
            }
        }
    }

    public static Set<String> getSubURLs(String urlString) {
        // Create a new set for URL strings
        Set<String> list = new HashSet<>();

        try {
            // Create a new URL object from string and open a stream in a scanner
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0; // current index is 0

            // While the scanner has next
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
