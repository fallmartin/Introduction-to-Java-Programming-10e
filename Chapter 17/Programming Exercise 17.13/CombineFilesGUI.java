
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * (Combine files GUI) Rewrite Exercise 17.12 with a GUI, as shown in Figure
 * 17.21b.
 *
 * @author martinfall
 */
public class CombineFilesGUI extends Application {

    // Data fields
    TextField tfFilename = new TextField();
    TextField tfNumberOfPieces = new TextField();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {

        // Create the instructional label
        String instructions
                = "If the base file is named temp.txt with three pieces\n"
                + "temp.txt.1, temp.txt.2, and temp.txt.3 are combined into "
                + "temp.txt";
        Label lblInstructions = new Label(instructions);

        // Create the labels for file and number of pieces input
        Label lblFilename = new Label("Enter a file:");
        Label lblNumberOfPieces
                = new Label("Specify the number of smaller files:");

        // Create a start button
        Button btStart = new Button("Start");

        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5));
        pane.setHgap(5);
        pane.setVgap(5);

        // Populate the grid
        // First row: instructions
        pane.add(lblInstructions, 0, 0, 2, 1);

        // Second row: file name
        pane.add(lblFilename, 0, 1);
        pane.add(tfFilename, 1, 1);

        // Third row: nubmer of pieces
        pane.add(lblNumberOfPieces, 0, 2);
        pane.add(tfNumberOfPieces, 1, 2);

        // Fourth and last row: Start button
        pane.add(btStart, 0, 3, 2, 1);
        GridPane.setHalignment(btStart, HPos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.setTitle("Exercise17_13"); // Set the stage title
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage nonresizable

        // Event handler for the start button
        btStart.setOnAction(e -> {
            // Some local variables for ease of use
            String filename = tfFilename.getText();
            int numberOfPieces = Integer.parseInt(tfNumberOfPieces.getText());

            // The fun stuff
            try (
                    // Create a random access file
                    BufferedOutputStream output
                    = new BufferedOutputStream(
                            new FileOutputStream(filename, true));) {
                // Value var to hold input as it is read from source file
                int value;

                // Process the file array
                for (int i = 1; i <= numberOfPieces; i++) {
                    try (
                            // Create a buffered input stream
                            BufferedInputStream input
                            = new BufferedInputStream(
                                    new FileInputStream(filename + "." + i));) {
                        while ((value = input.read()) != -1) {
                            output.write(value);
                        }
                    }
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
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
