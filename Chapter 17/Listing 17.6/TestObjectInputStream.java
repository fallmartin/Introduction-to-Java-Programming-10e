
import java.io.*;

/**
 * Output: John 85.5 Sat Oct 17 05:12:58 EDT 2020
 *
 * @author martinfall
 */
public class TestObjectInputStream {

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        try (
                // Create an input stream for file object.dat
                 ObjectInputStream input
                = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream("object.dat")));) {
            // Read a string, double value, and object from the file
            String name = input.readUTF();
            double score = input.readDouble();
            java.util.Date date = (java.util.Date) input.readObject();

            System.out.println(name + " " + score + " " + date);
        }
    }
}
