
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * (Demonstrate Label properties) Write a program to let the user dynamically
 * set the properties contentDisplay and graphicTextGap, as shown in Figure
 * 16.42b.
 *
 * @author martinfall
 */
public class LabelPropertiesDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create the labels for the options pane
        Label lblContentDisplay = new Label("contentDisplay");
        Label lblGraphicTextGap = new Label("graphicTextGap");

        // Create the combo box for the content display option
        ComboBox<ContentDisplay> cbContentDisplay = new ComboBox<>();
        ContentDisplay[] list = {
            ContentDisplay.BOTTOM,
            ContentDisplay.CENTER,
            ContentDisplay.GRAPHIC_ONLY,
            ContentDisplay.LEFT,
            ContentDisplay.RIGHT,
            ContentDisplay.TEXT_ONLY,
            ContentDisplay.TOP
        };
        ObservableList<ContentDisplay> items
                = FXCollections.observableArrayList(list);
        cbContentDisplay.setItems(items);
        cbContentDisplay.setValue(ContentDisplay.LEFT);

        // Create the text field for the graphic text gap option
        TextField tfGraphicTextGap = new TextField("40"); // Default value of 40
        tfGraphicTextGap.setPrefColumnCount(4);

        // Create the label that we'll be manipulating with the default values
        Label label = new Label(
                "Grapes",
                new ImageView(
                        new Image("grapes.gif")));
        label.setContentDisplay(cbContentDisplay.getValue());
        label.setGraphicTextGap(Integer.parseInt(tfGraphicTextGap.getText()));

        // Create an HBox and add the labels, combo box, and text field
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(lblContentDisplay, cbContentDisplay,
                lblGraphicTextGap, tfGraphicTextGap);

        // Create a new stack pane and place the label with graphic node in it
        StackPane stackPane = new StackPane(label);
        stackPane.setPrefSize(400, 200);

        // Place the HBox and stack pane in a border pane
        BorderPane pane = new BorderPane();
        pane.setTop(hBox);
        pane.setCenter(stackPane);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("LabelPropertiesDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // The stage is not resizable

        // Event handler for the contentDisplay combo box
        cbContentDisplay.setOnAction(e -> {
            label.setContentDisplay(cbContentDisplay.getValue());
        });

        // Event handler for the graphicTextGap text field
        tfGraphicTextGap.setOnAction(e -> {
            label.setGraphicTextGap(
                    Double.parseDouble(tfGraphicTextGap.getText())
            );
        });
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
