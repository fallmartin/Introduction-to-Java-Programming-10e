
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Output:
 * John 85.5
 * Jim 185.5
 * George 105.25
 *
 * @author martinfall
 */
public class TestDataStream {

    public static void main(String[] args) throws IOException {
        try (
                // Create an output stream for file temp.dat
                 DataOutputStream output
                = new DataOutputStream(new FileOutputStream("temp.dat"));) {
            // Write student test scores to the file
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeUTF("Jim");
            output.writeDouble(185.5);
            output.writeUTF("George");
            output.writeDouble(105.25);
        }

        try (
                // Create out input stream for file temp.dat
                 DataInputStream input
                = new DataInputStream(new FileInputStream("temp.dat"));) {
            // Read student test scores from the file
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
        }
    }
}
