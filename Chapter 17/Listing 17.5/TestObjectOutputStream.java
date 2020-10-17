
import java.io.*;

/**
 *
 * @author martinfall
 */
public class TestObjectOutputStream {

    public static void main(String[] args) throws IOException {
        try (
                // Create an output stream for the file object.dat
                 ObjectOutputStream output
                = new ObjectOutputStream( // Object output stream
                        new BufferedOutputStream( // Buffered output stream
                                new FileOutputStream("object.dat")));) { // File output stream
            // Write a string, double value, and object to the file
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeObject(new java.util.Date());
        }
    }
}
