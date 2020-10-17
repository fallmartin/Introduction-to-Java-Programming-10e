
import java.io.*;

/**
 * Output:
 * 1 2 3 4 5
 * John Susan Kim
 *
 * @author martinfall
 */
public class TestObjectStreamForArray {

    public static void main(String[] args)
            throws ClassNotFoundException, IOException {
        int[] numbers = {1, 2, 3, 4, 5};
        String[] strings = {"John", "Susan", "Kim"};

        try ( // Create an output stream for file array.dat
                 ObjectOutputStream output = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("array.dat", true)));) {
            output.writeObject(numbers);
            output.writeObject(strings);
        }

        try (// Create an input stream for file array.dat
                 ObjectInputStream input = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream("array.dat")));) {
            int[] newNumbers = (int[]) input.readObject();
            String[] newStrings = (String[]) input.readObject();

            // Display arrays
            for (int i = 0; i < newNumbers.length; i++) {
                System.out.print(newNumbers[i] + " ");
            }

            System.out.println();

            for (int i = 0; i < newStrings.length; i++) {
                System.out.print(newStrings[i] + " ");
            }
        }
    }
}
