
import java.io.*;
import java.util.Arrays;
import java.util.Date;

/**
 * (Store objects and arrays in a file) Write a program that stores an array of
 * the five int values 1, 2, 3, 4, and 5, a Date object for the current time,
 * and the double value 5.5 into the file named Exercise17_05.dat.
 *
 * Output:
 * Array: [1, 2, 3, 4, 5]
 * Date created: Wed Oct 21 02:15:38 EDT 2020
 * Double: 5.5
 *
 * @author martinfall
 */
public class StoreObjectsAndArraysInAFile {

    public static void main(String[] args)
            throws FileNotFoundException, IOException, ClassNotFoundException {

        try (
                // Create an object output stream
                 ObjectOutputStream output = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("Exercise17_05.dat")));) {
            // Create an array of five int values
            int[] values = {1, 2, 3, 4, 5};

            // Create a double value
            double value = 5.5;

            output.writeObject(values);
            output.writeObject(new Date()); // new Date for the current time
            output.writeDouble(value);
        }

        try (
                // Create an object input stream
                 ObjectInputStream input = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream("Exercise17_05.dat")));) {

            // Read in the array object, date object, and double primitive value
            int[] values = (int[]) input.readObject();
            Date date = (Date) input.readObject();
            double value = input.readDouble();

            System.out.println("Array: " + Arrays.toString(values));
            System.out.println("Date created: " + date);
            System.out.println("Double: " + value);

        }
    }
}
