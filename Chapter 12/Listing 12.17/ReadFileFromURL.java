
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.net.URL;

/**
 * Output:
 * Enter a URL: https://www.yahoo.com/
 * The file size is 144073 characters
 *
 * @author martinfall
 */
public class ReadFileFromURL {

    public static void main(String[] args) {
        System.out.print("Enter a URL: ");
        String URLString = new Scanner(System.in).next();

        try {
            URL url = new URL(URLString);
            int count = 0;
            Scanner input = new Scanner(url.openStream());

            while (input.hasNext()) {
                String line = input.nextLine();
                count += line.length();
            }

            System.out.println("The file size is " + count + " characters");
        } catch (MalformedURLException ex) {
            System.out.println("Invalid URL");
        } catch (IOException ex) {
            System.out.println("I/O Errors: no such file");
        }
    }
}
