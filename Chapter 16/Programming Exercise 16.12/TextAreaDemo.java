
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * (Demonstrate TextArea properties) Write a program that demonstrates the
 * properties of a text area. The program uses a check box to indicate whether
 * the text is wrapped onto next line, as shown in Figure 16.41a.
 *
 * @author martinfall
 */
public class TextAreaDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a new text area
        TextArea taViewer = new TextArea();
        taViewer.setPrefSize(400, 300);
        // Initial state of the text area
        taViewer.setEditable(true); // editable
        taViewer.setWrapText(true); // wrapped text

        // Create the two check boxes
        CheckBox cbEditable = new CheckBox("Editable");
        CheckBox cbWrap = new CheckBox("Wrap");
        
        // Set the check boxes initial states
        cbEditable.setSelected(true);
        cbWrap.setSelected(true);

        // Place the check boxes in an HBox
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(cbEditable, cbWrap);

        // Create a new border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(taViewer);
        pane.setBottom(hBox);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("TextAreaDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // The stage is not resizable
        
        // Event handlers for the check boxes
        cbEditable.setOnAction(e -> {
            if (cbEditable.isSelected()) {
                taViewer.setEditable(true);
            } else {
                taViewer.setEditable(false);
            }
        });
        
        cbWrap.setOnAction(e -> {
            if (cbWrap.isSelected()) {
                taViewer.setWrapText(true);
            } else {
                taViewer.setWrapText(false);
            }
        });
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
