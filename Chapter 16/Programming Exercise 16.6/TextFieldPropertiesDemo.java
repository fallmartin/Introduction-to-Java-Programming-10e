
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * (Demonstrate TextField properties) Write a program that sets the horizontal
 * alignment and column-size properties of a text field dynamically, as shown in
 * Figure 16.38a.
 *
 * @author martinfall
 */
public class TextFieldPropertiesDemo extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create the text fields for text and column size
        TextField tfText = new TextField("JavaFX");
        tfText.setEditable(false);
        TextField tfColumnSize = new TextField();
        tfColumnSize.setPrefColumnCount(2);

        // Create the labels for the text fields
        Label lblText = new Label("Text Field");
        Label lblColumnSize = new Label("Column Size");

        // Create the radio buttons
        RadioButton rbLeft = new RadioButton("Left");
        RadioButton rbCenter = new RadioButton("Center");
        RadioButton rbRight = new RadioButton("Right");

        // Group the radio button in a toggle group
        ToggleGroup group = new ToggleGroup();
        rbLeft.setToggleGroup(group);
        rbCenter.setToggleGroup(group);
        rbRight.setToggleGroup(group);

        // Create an HBox for the radio buttons, label, and column size tf
        HBox paneForControls = new HBox(10);
        paneForControls.setAlignment(Pos.CENTER);
        paneForControls.setPadding(new Insets(10));
        paneForControls.getChildren().addAll(rbLeft, rbCenter, rbRight,
                lblColumnSize, tfColumnSize);

        // Create grid pane for the label and textfield that we're manipulating
        GridPane paneForDemo = new GridPane();
        paneForDemo.setHgap(10);
        paneForDemo.setAlignment(Pos.CENTER);
        paneForDemo.setPadding(new Insets(10));
        paneForDemo.addRow(0, lblText, tfText);

        // Create a border pane and add paneForDemo and paneForControls
        BorderPane pane = new BorderPane();
        pane.setCenter(paneForDemo);
        pane.setBottom(paneForControls);

        // Select the default option of text field and add the initial size
        tfColumnSize.setText(String.valueOf(tfText.getPrefColumnCount()));
        rbLeft.setSelected(true);
        tfText.setAlignment(Pos.CENTER_LEFT);

        // Register event handlers with the radio buttons and text field
        rbLeft.setOnAction(e -> {
            tfText.setAlignment(Pos.CENTER_LEFT);
        });

        rbCenter.setOnAction(e -> {
            tfText.setAlignment(Pos.CENTER);
        });

        rbRight.setOnAction(e -> {
            tfText.setAlignment(Pos.CENTER_RIGHT);
        });

        tfColumnSize.setOnAction(e -> {
            tfText.setPrefColumnCount(Integer.parseInt(tfColumnSize.getText()));
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("TextFieldPropertiesDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        rbLeft.requestFocus(); // Focus set on the selected default
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
