
import java.io.*;

/**
 * 4.5
 * 43.25
 * 3.2
 * All data were read.
 *
 * @author martinfall
 */
public class DetectEndOfFile {

    public static void main(String[] args) {
        try {
            try (
                     DataOutputStream output
                    = new DataOutputStream(new FileOutputStream("temp.dat"));) {
                output.writeDouble(4.5);
                output.writeDouble(43.25);
                output.writeDouble(3.2);
            }

            try (
                     DataInputStream input
                    = new DataInputStream(new FileInputStream("temp.dat"));) {
                while (true) {
                    System.out.println(input.readDouble());
                }
            }
        } catch (EOFException ex) {
            System.out.println("All data were read.");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
