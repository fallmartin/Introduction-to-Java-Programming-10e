
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * (Count words) Write a program that counts the number of words in President
 * Abraham Lincoln’s Gettysburg address from http://cs.armstrong.edu/liang/data/
 * Lincoln.txt.
 * 
 * Output:
 * Words: 278
 *
 * @author martinfall
 */
public class CountWords {

    public static void main(String[] args) throws IOException {
        String regex = "<.+?>";
        String replacement = "";
        String text = "";
        int counter = 0;

        try {
            // Create a new URL object using a new URL. The textbook URL is deprecated
            URL url = new URL("http://www.abrahamlincolnonline.org/lincoln/speeches/gettysburg.htm");

            // Create a new Scanner object
            Scanner input = new Scanner(url.openStream());

            // Build a string from the url stream
            while (input.hasNext()) {
                String line = input.nextLine().replaceAll(regex, replacement);
                text += line;
            }

            // Grab the start and end index of the speech
            int beginIndex = text.indexOf("Four score and seven years ago");
            int endIndex = text.indexOf("perish from the earth.");

            // Create a substring from the speech
            String speech = text.substring(beginIndex, endIndex + 22);

            // Trim and split the string using ws delimiters and return the length
            System.out.println("Words: " + speech.trim().split("\\s+").length);
        } catch (MalformedURLException ex) {
            System.out.println(ex); // Catch the malformed URL exception
        }
    }
}
