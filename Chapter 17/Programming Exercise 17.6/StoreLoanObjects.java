
import java.io.*;

/**
 * (Store Loan objects) The Loan class in Listing 10.2 does not implement
 * Serializable. Rewrite the Loan class to implement Serializable. Write a
 * program that creates five Loan objects and stores them in a file named
 * Exercise17_06.dat.
 *
 * Output:
 * Loan amount: 300000.0
 * Interest rate: 3.0
 * Number of years: 30
 *
 * Loan amount: 310000.0
 * Interest rate: 3.25
 * Number of years: 30
 *
 * Loan amount: 320000.0
 * Interest rate: 3.5
 * Number of years: 30
 *
 * Loan amount: 330000.0
 * Interest rate: 3.75
 * Number of years: 30
 *
 * Loan amount: 340000.0
 * Interest rate: 4.0
 * Number of years: 30
 *
 * @author martinfall
 */
public class StoreLoanObjects {

    public static void main(String[] args)
            throws FileNotFoundException, ClassNotFoundException, IOException {
        // Create an array of five loan objects
        Loan[] loans = new Loan[5];

        // Populate the array
        loans[0] = new Loan(3.0, 30, 300000);
        loans[1] = new Loan(3.25, 30, 310000);
        loans[2] = new Loan(3.50, 30, 320000);
        loans[3] = new Loan(3.75, 30, 330000);
        loans[4] = new Loan(4.0, 30, 340000);

        try (
                // Create an object output stream
                 ObjectOutputStream output = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("Exercise17_06.dat")));) {
            output.writeObject(loans);
        }

        try (
                // Create an object output stream to test the output
                 ObjectInputStream input = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream("Exercise17_06.dat")));) {
            Loan[] loansReadFromFile = (Loan[]) input.readObject();

            for (Loan loan : loansReadFromFile) {
                System.out.println(loan.toString());
            }
        }
    }
}
