
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * (Text viewer) Write a program that displays a text file in a text area, as
 * shown in Figure 16.40a. The user enters a file name in a text field and
 * clicks the View button; the file is then displayed in a text area.
 *
 * @author martinfall
 */
public class TextViewer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Local variable declarations and initializations
        // Text area for viewing the text
        TextArea taViewer = new TextArea();
        taViewer.setPrefSize(400, 300);
        taViewer.setWrapText(true);

        // Label for the input pane
        Label lblFilename = new Label("Filename");

        // Text field for file input
        TextField tfInput = new TextField();
        tfInput.setPrefWidth(250);

        // Button to load the file in the viewer
        Button btView = new Button("View");

        // HBox for the bottom of the border pane we're creating next
        HBox paneForInput = new HBox(10);
        paneForInput.setAlignment(Pos.CENTER);
        paneForInput.getChildren().addAll(lblFilename, tfInput, btView);

        // Border pane to hold the text area, label, text field, and button
        BorderPane pane = new BorderPane();
        pane.setCenter(taViewer);
        pane.setBottom(paneForInput);

        btView.setOnAction(e -> {
            // Store the input in a string
            String filePath = tfInput.getText();

            File file = new File(filePath);
            if (!file.exists()) {
                taViewer.setText("File does not exist. Please, try again.");
            } else {
                try {
                    // Create a path to the file
                    Path path = Paths.get(filePath);
                    // Reads all content from file into a string
                    String text = Files.readString(path);
                    // Update the viewer text area
                    taViewer.setText(text);
                } catch (IOException ex) {
                    System.out.println(ex.toString());
                }
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("TextViewer"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(true); // The stage is not resizable

        tfInput.requestFocus();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
