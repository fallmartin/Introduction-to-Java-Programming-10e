
import java.io.*;

/**
 * (Restore objects from a file) Suppose a file named Exercise17_07.dat has been
 * created using the ObjectOutputStream. The file contains Loan objects. The
 * Loan class in Listing 10.2 does not implement Serializable. Rewrite the Loan
 * class to implement Serializable. Write a program that reads the Loan objects
 * from the file and displays the total loan amount. Suppose you don’t know how
 * many Loan objects are there in the file, use EOFException to end the loop.
 *
 * Output:
 * The total loan amount is 1,600,000.00
 *
 * @author martinfall
 */
public class RestoreObjectsFromFile {

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
            double totalLoanAmount = 0;

            for (Loan loan : loansReadFromFile) {
                totalLoanAmount += loan.getLoanAmount();
            }

            System.out.printf("The total loan amount is %,.2f%n",
                    totalLoanAmount);
        }

    }
}
