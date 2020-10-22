
import java.io.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * (Address book) Write a program that stores, retrieves, adds, and updates
 * addresses as shown in Figure 17.20. Use a fixed-length string for storing
 * each attribute in the address. Use random access file for reading and writing
 * an address. Assume that the size of name, street, city, state, and zip is 32,
 * 32, 20, 2, 5 bytes, respectively.
 *
 * @author martinfall
 */
public class AddressBook extends Application {

    long pos = 0;

    // Constant data fields
    private final int NAME_LENGTH = 32;
    private final int STREET_LENGTH = 32;
    private final int CITY_LENGTH = 20;
    private final int STATE_LENGTH = 2;
    private final int ZIP_LENGTH = 5;
    private final int ENTRY_LENGTH = 91;

    // TextField data fields
    TextField tfName = new TextField();
    TextField tfStreet = new TextField();
    TextField tfCity = new TextField();
    TextField tfState = new TextField();
    TextField tfZip = new TextField();

    @Override
    public void start(Stage primaryStage)
            throws FileNotFoundException, IOException {

        // Create the labels
        Label lblName = new Label("Name");
        Label lblStreet = new Label("Street");
        Label lblCity = new Label("City");
        Label lblState = new Label("State");
        Label lblZip = new Label("Zip");

        // Create the buttons
        Button btAdd = new Button("Add");
        Button btFirst = new Button("First");
        Button btNext = new Button("Next");
        Button btPrevious = new Button("Previous");
        Button btLast = new Button("Last");
        Button btUpdate = new Button("Update");

        // Create an HBox to hold the buttons
        HBox hBoxForButtons = new HBox(10);
        hBoxForButtons.setAlignment(Pos.CENTER);
        hBoxForButtons.setPadding(new Insets(5));
        hBoxForButtons.getChildren().addAll(
                btAdd, btFirst, btNext, btPrevious, btLast, btUpdate);

        // Crate a grid pane
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));
        pane.setGridLinesVisible(false);

        // Add all labels and text fields to the grid page
        // First row (Name)
        pane.add(lblName, 0, 0);
        pane.add(tfName, 1, 0, 5, 1);

        // Second row (Street)
        pane.add(lblStreet, 0, 1);
        pane.add(tfStreet, 1, 1, 5, 1);

        // Third row (City, State, Zip)
        pane.add(lblCity, 0, 2);
        pane.add(tfCity, 1, 2);
        pane.add(lblState, 2, 2);
        pane.add(tfState, 3, 2);
        pane.add(lblZip, 4, 2);
        pane.add(tfZip, 5, 2);

        // Fourth row (Buttons)
        pane.add(hBoxForButtons, 0, 3, 6, 1);

        // Create a new scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.setTitle("Exercise17_09"); // Set the stage title
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non resizable

        // Prime the UI with the first record in the file
        try (
                // Create a random access file
                RandomAccessFile raf
                = new RandomAccessFile("AddressBook.dat", "rw");) {
            // Read the entry at position 0
            readEntry(raf, pos);
        }

        // Register an event handler for the Add button
        btAdd.setOnAction(e -> {
            try (
                    // Create a random access file
                    RandomAccessFile raf
                    = new RandomAccessFile("AddressBook.dat", "rw");) {

                // Update the position to the end of the file
                pos = raf.length();

                // Write the entry at the end of the file
                writeEntry(raf, pos);

            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });

        // Register an event handler for the First button
        btFirst.setOnAction(e -> {
            try (
                    // Create a random access file
                    RandomAccessFile raf
                    = new RandomAccessFile("AddressBook.dat", "rw");) {

                // Update the position to the beginning of the file
                pos = 0;

                // Read the entry at position 0
                readEntry(raf, pos);

            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });

        // Register an event handler for the Next button
        btNext.setOnAction(e -> {
            try (
                    // Create a random access file
                    RandomAccessFile raf
                    = new RandomAccessFile("AddressBook.dat", "rw");) {

                // Update the position to the beginning of the next entry
                pos = pos + ENTRY_LENGTH < raf.length()
                        ? pos + ENTRY_LENGTH : pos; // Don't go beyond EOF

                // Read the entry at position 0
                readEntry(raf, pos);

            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });

        // Register an event handler for the Previous button
        btPrevious.setOnAction(e -> {
            try (
                    // Create a random access file
                    RandomAccessFile raf
                    = new RandomAccessFile("AddressBook.dat", "rw");) {

                // Update the position to the beginning of the next entry
                pos = pos - ENTRY_LENGTH >= 0
                        ? pos - ENTRY_LENGTH : 0; // Don't go before 0

                // Read the entry at position 0
                readEntry(raf, pos);

            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });

        // Register an event handler for the Last button
        btLast.setOnAction(e -> {
            try (
                    // Create a random access file
                    RandomAccessFile raf
                    = new RandomAccessFile("AddressBook.dat", "rw");) {

                // Update the position to the beginning of the next entry
                pos = raf.length() - ENTRY_LENGTH;

                // Read the entry at position 0
                readEntry(raf, pos);

            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });

        // Register an event handler for the Update button
        btUpdate.setOnAction(e -> {
            try (
                    // Create a random access file
                    RandomAccessFile raf
                    = new RandomAccessFile("AddressBook.dat", "rw");) {

                // Update the position to the beginning of the next entry
                // pos = pos - ENTRY_LENGTH >= 0
                // ? pos - ENTRY_LENGTH : 0; // Don't go before 0
                // Read the entry at position 0
                writeEntry(raf, pos);

                // Display the entry in the UI with the updated values
                // pos = pos - ENTRY_LENGTH >= 0 ? pos - ENTRY_LENGTH : 0; // Don't go before 0
                readEntry(raf, pos);

            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });

    }

    /**
     * Writes an entire entry (name, street, city, state, and zip) at position
     * pos to random access file raf and clears all of the text fields.
     *
     * @param raf
     * @param pos
     * @throws IOException
     */
    public void writeEntry(RandomAccessFile raf, long pos) throws IOException {

        // Find the last position in the random access file
        raf.seek(pos);

        // Collect the string values from the text fields
        String name = updateLength(tfName.getText(), NAME_LENGTH);
        String street = updateLength(tfStreet.getText(), STREET_LENGTH);
        String city = updateLength(tfCity.getText(), CITY_LENGTH);
        String state = updateLength(tfState.getText(), STATE_LENGTH);
        String zip = updateLength(tfZip.getText(), ZIP_LENGTH);

        // Write the data fields to the file
        raf.writeBytes(name);
        raf.writeBytes(street);
        raf.writeBytes(city);
        raf.writeBytes(state);
        raf.writeBytes(zip);

        // Clear the text fields
        clearTextFields();
    }

    /**
     * Reads an entire entry (name, street, city, state, and zip) at position
     * pos from random access file raf and fills in the appropriate text fields.
     *
     * @param raf
     * @param pos
     * @throws IOException
     */
    public void readEntry(RandomAccessFile raf, long pos) throws IOException {

        // find the first position in the random access file
        raf.seek(pos);

        // Create the byte arrays at the appropriate length
        byte[] name = new byte[NAME_LENGTH];
        byte[] street = new byte[STREET_LENGTH];
        byte[] city = new byte[CITY_LENGTH];
        byte[] state = new byte[STATE_LENGTH];
        byte[] zip = new byte[ZIP_LENGTH];

        // Read the byte arrays from the file
        raf.read(name);
        raf.read(street);
        raf.read(city);
        raf.read(state);
        raf.read(zip);

        // Update the text fields
        tfName.setText(restoreLength(new String(name)));
        tfStreet.setText(restoreLength(new String(street)));
        tfCity.setText(restoreLength(new String(city)));
        tfState.setText(restoreLength(new String(state)));
        tfZip.setText(restoreLength(new String(zip)));
    }

    /**
     * Returns a string right-padded with whitespace to the parameter length.
     *
     * @param string
     * @param length
     * @return
     */
    private String updateLength(String string, int length) {
        while (string.length() < length) {
            string = string + " ";
        }
        return string;
    }

    /**
     * Returns a trimmed string.
     *
     * @param string
     * @return
     */
    private String restoreLength(String string) {
        return string.trim();
    }

    /**
     * Clear all of the text fields.
     */
    public void clearTextFields() {
        tfName.clear();
        tfStreet.clear();
        tfCity.clear();
        tfState.clear();
        tfZip.clear();
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
