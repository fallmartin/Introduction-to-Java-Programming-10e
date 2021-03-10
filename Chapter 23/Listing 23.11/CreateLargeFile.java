package listing_23_11;

import java.io.*;

/**
 *
 * @author martinfall
 */
public class CreateLargeFile {

    /**
     *
     * Main method with driver code.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        DataOutputStream output
                = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("largedata.dat")));

        for (int i = 0; i < 800004; i++) {
            output.writeInt((int) (Math.random() * 1_000_000));
        }

        output.close();

        // Display first 100 numbers
        DataInputStream input
                = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream("largedata.dat")));

        for (int i = 0; i < 100; i++) {
            System.out.print(input.readInt() + " ");
        }

        input.close();
    }

}
