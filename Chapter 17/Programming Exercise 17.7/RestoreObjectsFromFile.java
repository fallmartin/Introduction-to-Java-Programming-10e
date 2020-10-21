
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

        // Populate the array
        Loan loan1 = new Loan(3.0, 30, 300000);
        Loan loan2 = new Loan(3.25, 30, 310000);
        Loan loan3 = new Loan(3.50, 30, 320000);
        Loan loan4 = new Loan(3.75, 30, 330000);
        Loan loan5 = new Loan(4.0, 30, 340000);

        double totalLoanAmount = 0;

        try (
                // Create an object output stream
                 ObjectOutputStream output = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("Exercise17_06.dat")));) {
            output.writeObject(loan1);
            output.writeObject(loan2);
            output.writeObject(loan3);
            output.writeObject(loan4);
            output.writeObject(loan5);
        }

        try (
                // Create an object output stream to test the output
                 ObjectInputStream input = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream("Exercise17_06.dat")));) {

            while (true) {
                Loan loan = (Loan) input.readObject();
                totalLoanAmount += loan.getLoanAmount();

            }
        } catch (EOFException ex) {
            System.out.printf("The total loan amount is %,.2f%n",
                    totalLoanAmount);
        }
    }
}
