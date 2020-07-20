
/**
 * (Search Web) Modify Listing 12.18 WebCrawler.java to search for the word
 * Computer Programming starting from the URL http://cs.armstrong.edu/liang.
 * Your program terminates once the word is found. Display the URL for the page
 * that contains the word.
 *
 * @author martinfall
 */
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.ArrayList;

public class WebCrawler {

    /**
     * Main method.
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // Search keyword
        String keyword = "Computer Programming";

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a URL
        System.out.print("Enter a URL: ");
        String url = input.nextLine();
        crawler(url, keyword); // Traverse the Web from the a starting url
    }

    /**
     * Crawl a given URL
     *
     * @param startingURL
     * @param keyword
     * @throws java.net.MalformedURLException
     */
    public static void crawler(String startingURL, String keyword) throws MalformedURLException, IOException {
        // Create two lists of pending and traversed URLs
        ArrayList<String> listOfPendingURLs = new ArrayList<>();
        ArrayList<String> listOfTraversedURLs = new ArrayList<>();

        // Add the starting URL to the list of pending URLs
        listOfPendingURLs.add(startingURL);

        // While our list of pending URLs is not empty
        while (!listOfPendingURLs.isEmpty()) {
            // Remove the first URL from pending and shift the rest to the left
            String urlString = listOfPendingURLs.remove(0);
            // Add the URL to the traversed URLs list
            listOfTraversedURLs.add(urlString);
            // Display to console URL being crawled
            System.out.println("Crawl " + urlString);

            // Create a new URL object
            URL url = new URL(urlString);

            // Search for keyword here
            try (Scanner input = new Scanner(url.openStream());) {
                while (input.hasNext()) {
                    String str = input.nextLine();
                    // System.out.println(str);
                    if (str.contains(keyword)) {
                        System.out.println(keyword + " was found");
                        System.out.println(urlString);
                        System.exit(0);
                    }
                }
            }

            // For each URL in array of URLs
            for (String s : getSubURLs(urlString)) {
                // If URL is not already traversed and is not in our pending list
                if (!listOfTraversedURLs.contains(s)
                        && !listOfPendingURLs.contains(s)) {
                    listOfPendingURLs.add(s); // Add it to pending
                }
            }
        }
    }

    /**
     * Returns an array of sub-URLs from a URL.
     *
     * @param urlString
     * @return
     */
    public static ArrayList<String> getSubURLs(String urlString) {
        // Create a empty list
        ArrayList<String> list = new ArrayList<>();

        try {
            // Create a new URL object with the parameter urlString
            java.net.URL url = new java.net.URL(urlString);
            // Open a stream on input Scanner object
            Scanner input = new Scanner(url.openStream());
            // Set the current index to 0
            int current = 0;
            while (input.hasNext()) { // While input has next
                // Grab a line from the stream
                String line = input.nextLine();
                // Update current to the index of http:
                current = line.indexOf("http:", current);
                while (current > 0) { // While we have an http found (current > 0)
                    int endIndex = line.indexOf("\"", current); // Find the end of the url
                    if (endIndex > 0) { // Ensure that a correct URL is found (endIndex > 0)
                        list.add(line.substring(current, endIndex)); // Add the url to the list
                        // Look for http: starting at endIndex
                        current = line.indexOf("http:", endIndex); // If found update current
                    } else { // else set current to -1 and return the list
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
