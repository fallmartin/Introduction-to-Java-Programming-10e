
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
 * (Hex editor) Write a GUI application that lets the user enter a file name in
 * the text field and press the Enter key to display its hex representation in a
 * text area. The user can also modify the hex code and save it back to the
 * file, as shown in Figure 17.23b.
 *
 * @author martinfall
 */
public class HexEditor extends Application {

    // Data fields
    TextField tfFileName = new TextField();
    TextArea taEditor = new TextArea();
    String text = ""; // Create a new string
    File file;

    @Override
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
        primaryStage.setTitle("Hex Editor"); // Set the stage title
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(true); // Make the stage non-resizable

        // Set focus on the text field
        tfFileName.requestFocus();

        /**
         * Event handler for the text field tfFileName.
         */
        tfFileName.setOnAction(e -> {
            // Create a new file
            file = new File(tfFileName.getText());

            // Check if the file exists
            if (!file.exists()) {
                taEditor.setText("The file " + file.getName()
                        + " does not exist.");
            } else {
                try (
                        // Create a file input stream
                        FileInputStream input = new FileInputStream(file);) {
                    // Local varial to hold input as read from the stream
                    int value;
                    while ((value = input.read()) != -1) {
                        text = text + viewHex(value);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(HexEditor.class.getName())
                            .log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(HexEditor.class.getName())
                            .log(Level.SEVERE, null, ex);
                }

                taEditor.setText(text);
            }
        });

        /**
         * Event handler for the btSave button.
         */
        btSave.setOnAction(e -> {
            try (
                    // Create a file output stream
                    FileOutputStream output = new FileOutputStream(file);) {
                String text = taEditor.getText();

                for (int i = 0; i < text.length(); i += 3) {
                    int b = Integer.parseInt(text.substring(i, i + 3).trim(), 16);
                    output.write(b);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HexEditor.class.getName())
                        .log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(HexEditor.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        });
    }

    /**
     * Displays the hex representation of the byte value.
     *
     * (View hex) Write a program that prompts the user to enter a file name,
     * reads bytes from the file, and displays each byte’s hex representation.
     * (Hint: You can first convert the byte value into an 8-bit string, then
     * convert the bit string into a two-digit hex string.)
     *
     * @param value
     * @return
     */
    public static String viewHex(int value) {
        /**
         * Convert the byte value into an 8-bit string.
         */
        int bitMask = 1; // 00000001
        String bitString = ""; // The returned string that we will build below

        for (int i = 7; i >= 0; i--) {
            // Shift the bit at i to the least significant bit position
            int temp = value >> i;

            // Determine the value of the LSB position using bitwise AND
            int bit = temp & bitMask;

            // Update the string
            bitString = bitString + bit;
        }
        // Optional line in console
        // System.out.println("Bit string: " + bitString);

        /**
         * Convert the bit string into a two-digit hex string.
         */
        // Break the bit string in two groupings of four bits
        String firstGroup = bitString.substring(0, 4);
        String secondGroup = bitString.substring(4);
        // System.out.println("First grouping: " + firstGroup);
        // System.out.println("Second grouping: " + secondGroup);

        // Convert each grouping to an integer
        int firstGroupToInt = Integer.parseInt(firstGroup, 2);
        int secondGroupToInt = Integer.parseInt(secondGroup, 2);
        // System.out.println("First grouping to int: " + firstGroupToInt);
        // System.out.println("Second grouping to int: " + secondGroupToInt);

        String hexString = buildHexString(firstGroupToInt, secondGroupToInt);

        /**
         * Using the toHexString method of the Integer class.
         */
        // Uncomment the line below to see result in console
        // System.out.println(value + " -> 0x" + Integer.toHexString(value));
        return hexString + " ";
    }

    public static String buildHexString(int firstGroupToInt, int secondGroupToInt) {
        // String hexString = "0x";
        String hexString = "";

        hexString = switch (firstGroupToInt) {
            case 10 ->
                hexString + 'A';
            case 11 ->
                hexString + 'B';
            case 12 ->
                hexString + 'C';
            case 13 ->
                hexString + 'D';
            case 14 ->
                hexString + 'E';
            case 15 ->
                hexString + 'F';
            default ->
                hexString + firstGroupToInt;
        };

        hexString = switch (secondGroupToInt) {
            case 10 ->
                hexString + 'A';
            case 11 ->
                hexString + 'B';
            case 12 ->
                hexString + 'C';
            case 13 ->
                hexString + 'D';
            case 14 ->
                hexString + 'E';
            case 15 ->
                hexString + 'F';
            default ->
                hexString + secondGroupToInt;
        };

        // System.out.println("Hex String: " + hexString);
        return hexString;
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
