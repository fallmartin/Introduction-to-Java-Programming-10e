
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Output:
 * John T Smith 90
 * Eric K Jones 85
 *
 * @author martinfall
 */
public class WriteData {

    public static void main(String[] args) throws IOException {
        File file = new File("scores.txt");

        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(1);
        }

        // Create a file
        PrintWriter output = new PrintWriter(file);

        // Write formatted output to file
        output.print("John T Smith ");
        output.println(90);
        output.print("Eric K Jones ");
        output.println(85);

        // Close the file
        output.close();
    }
}
