
import java.io.*;
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
 * (Split files GUI) Rewrite Exercise 17.10 with a GUI, as shown in Figure
 * 17.21a.
 *
 * Output:
 * Size: 9,101 bytes
 * Number of pieces: 10
 * Size per piece: 910 bytes
 * Size of last piece: 911 bytes
 *
 * 910 bytes in MLK.txt.1
 * 910 bytes in MLK.txt.2
 * 910 bytes in MLK.txt.3
 * 910 bytes in MLK.txt.4
 * 910 bytes in MLK.txt.5
 * 910 bytes in MLK.txt.6
 * 910 bytes in MLK.txt.7
 * 910 bytes in MLK.txt.8
 * 910 bytes in MLK.txt.9
 * 911 bytes in MLK.txt.10
 *
 * @author martinfall
 */
public class SplitFilesGUI extends Application {

    // Data fields
    TextField tfFilename = new TextField();
    TextField tfNumberOfPieces = new TextField();

    @Override
    public void start(Stage primaryStage)
            throws FileNotFoundException, IOException, Exception {
        // Create the instructional label
        String instructions
                = "If you split a file named temp.txt into 3 smaller files\n"
                + "the three smaller files are temp.txt.1, temp.txt.2, and temp.txt.3";
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
        primaryStage.setTitle("Exercise17_11"); // Set the stage title
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage nonresizable

        btStart.setOnAction(e -> {
            String filename = tfFilename.getText();
            int numberOfPieces = Integer.parseInt(tfNumberOfPieces.getText());

            // Check if the source file exists
            File sourceFile = new File(filename);
            if (!sourceFile.exists()) {
                System.out.println(
                        "Source file " + filename + " does not exist.");
                System.exit(0); // 
            }

            //
            try (
                    // Create a buffered input stream
                    BufferedInputStream input
                    = new BufferedInputStream(new FileInputStream(sourceFile));) {

                // Determine the file size, file size per piece, and file size of
                // the last piece, since not all numbers divide without a remainder
                long size = input.available();
                long sizePerPiece = size / numberOfPieces;
                long delta = size % sizePerPiece;
                long sizeOfLastPiece = sizePerPiece + delta;

                // Declare a counter variable to keep track of copied files
                int byteCounter = 0;
                // Declare a value variable to copy bytes from input to output
                int value;

                System.out.printf("Size: %,d bytes %n", size);
                System.out.printf("Number of pieces: %d %n", numberOfPieces);
                System.out.printf("Size per piece: %,d bytes %n", sizePerPiece);
                System.out.printf("Size of last piece: %,d bytes %n", sizeOfLastPiece);

                for (int i = 1; i <= numberOfPieces; i++) {
                    // Handle the last file with an early if statement 
                    if (i == numberOfPieces) {
                        // While the byte counter is not up to size and value is not -1
                        while ((value = input.read()) != -1) {
                            try (
                                    // Create a buffered output stream 
                                    BufferedOutputStream output
                                    = new BufferedOutputStream(
                                            new FileOutputStream(filename + "." + i));) {
                                // 
                                output.write(value);
                                byteCounter++;
                            }
                        }
                    } else {
                        // While the byte counter is not up to size and value is not -1
                        while (byteCounter < sizePerPiece
                                && (value = input.read()) != -1) {
                            try (
                                    // Create a buffered output stream 
                                    BufferedOutputStream output
                                    = new BufferedOutputStream(
                                            new FileOutputStream(filename + "." + i));) {
                                // 
                                output.write(value);
                                byteCounter++;
                            }
                        }
                    }

                    // Display the number of bytes in each split file
                    System.out.printf("%,d bytes in %s %n",
                            byteCounter, filename + "." + i);
                    // Reset the bytes counter
                    byteCounter = 0;
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
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
