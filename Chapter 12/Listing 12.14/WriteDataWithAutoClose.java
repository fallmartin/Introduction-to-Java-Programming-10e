
import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author martinfall
 */
public class WriteDataWithAutoClose {

    public static void main(String[] args) throws Exception {
        File file = new File("scores.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(1);
        }

        try (
                // Create a file (Create/declare resource)
                PrintWriter output = new PrintWriter(file);) {
            // Write formatted output to the file
            output.print("John T Smith ");
            output.println(90);
            output.print("Erik K Jones ");
            output.println(85);
        }
    }
}
