
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * (Binary editor) Write a GUI application that lets the user enter a file name
 * in the text field and press the Enter key to display its binary
 * representation in a text area. The user can also modify the binary code and
 * save it back to the file, as shown in Figure 17.23a.
 *
 * @author martinfall
 */
public class BinaryEditor extends Application {

    // Data fields
    TextField tfFileName = new TextField();
    TextArea taEditor = new TextArea();
    String text = ""; // Create a new string
    File file;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create a label
        Label lblFileName = new Label("Enter a file: ");

        // Create a HBox to hold the file label and text field
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(5));
        hBox.getChildren().addAll(lblFileName, tfFileName);

        // Create a scroll pane
        ScrollPane scrollPane = new ScrollPane(taEditor);

        // Create a button
        Button btSave = new Button("Save the change");

        // Minor UI tweaks
        tfFileName.setPrefWidth(400);
        // taEditor.setPrefSize(400, 200);
        taEditor.setWrapText(true);

        // Create a border pane
        BorderPane pane = new BorderPane();
        pane.setTop(hBox);
        pane.setCenter(scrollPane);
        pane.setBottom(btSave);
        BorderPane.setAlignment(btSave, Pos.CENTER);
        pane.setPadding(new Insets(5));

        // Create a new scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.setTitle("Binary Editor"); // Set the stage title
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(true); // Make the stage non-resizable

        // Set focus on the text field
        tfFileName.requestFocus();

        /**
         * Event handler for the text field tfFileName.
         */
        tfFileName.setOnAction(e -> {
            // Create a new file object
            file = new File(tfFileName.getText());

            // Check if the file exists
            if (!file.exists()) {
                taEditor.setText("The file " + file.getName() + " does not exist.");
            } else {
                try (
                        // Create a buffered input stream
                        BufferedInputStream input
                        = new BufferedInputStream(new FileInputStream(file));) {
                    int value;
                    // Reads a byte of data from this input stream in the while loop
                    // and detect EOF
                    while ((value = input.read()) != -1) {
                        // Build the string that will be set in the text area
                        text = text + getBits(value);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(
                            BinaryEditor.class.getName())
                            .log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(
                            BinaryEditor.class.getName())
                            .log(Level.SEVERE, null, ex);
                }

                // Set the text property to the string that we built
                taEditor.setText(text);
            }
        });

        /**
         * Event handler for the btSave button.
         */
        btSave.setOnAction(e -> {
            // File is already created in the event handler from text field

            try (
                    // Create a buffered output stream
                    BitOutputStream output
                    = new BitOutputStream(file);) {
                // Write the text from the text area
                output.writeBit(taEditor.getText().trim());
                // output.close(); // Close the stream
            } catch (Exception ex) {
                Logger.getLogger(
                        BinaryEditor.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
    }

    /**
     * Displays the bit representation for the last byte in an integer.
     *
     * @param value
     * @return
     */
    public static String getBits(int value) {
        int bitMask = 1; // 00000001
        String bitString = ""; // String to hold bits

        for (int i = 7; i >= 0; i--) {
            // Shift the bit at position i to the least significant position
            int temp = value >> i;

            // Compare the shifted value in temp and bit mask using bitwise AND
            int bit = temp & bitMask;

            // Update the string with the resulting 1 or 0.
            bitString = bitString + bit;
        }
        return bitString;
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
