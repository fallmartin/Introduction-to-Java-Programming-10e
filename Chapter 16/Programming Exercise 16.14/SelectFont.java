
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * (Select a font) Write a program that can dynamically change the font of a
 * text in a label displayed on a stack pane. The text can be displayed in bold
 * and italic at the same time. You can select the font name or font size from
 * combo boxes, as shown in Figure 16.42a. The available font names can be
 * obtained using Font.getFamilies(). The combo box for the font size is
 * initialized with numbers from 1 to 100.
 *
 * @author martinfall
 */
public class SelectFont extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a default font
        Font font = Font.font(
                "Times New Roman",
                FontWeight.THIN,
                FontPosture.REGULAR,
                40);

        // Create the labels for font name, size, bold, italic
        Label lblFontName = new Label("Font Name");
        Label lblFontSize = new Label("Font Size");

        // Create the combo box for the font name
        ComboBox<String> cbFontName = new ComboBox<>();
        ObservableList<String> items = FXCollections.observableArrayList(
                Font.getFamilies()
        );
        cbFontName.setItems(items); // Add items to combo box

        // Create the combo box for the font size
        ComboBox<Integer> cbFontSize = new ComboBox<>();
        for (int i = 1; i <= 100; i++) {
            // Skip autoboxing to prevent uses unchecked or unsafe operations error
            Integer size = i;
            cbFontSize.getItems().add(size);
        } // From 1 to 100

        // Create an HBox for the pane for font selection and add nodes
        HBox hBoxFont = new HBox(10);
        hBoxFont.setPadding(new Insets(5));
        hBoxFont.getChildren().addAll(
                lblFontName, cbFontName,
                lblFontSize, cbFontSize);

        // Create the check boxes for the bold and italic options
        CheckBox cbBold = new CheckBox("Bold");
        CheckBox cbItalic = new CheckBox("Italic");

        // Create an HBox for the pane for font bold and italic options
        HBox hBoxStyle = new HBox(10);
        hBoxStyle.setPadding(new Insets(5));
        hBoxStyle.setAlignment(Pos.CENTER);
        hBoxStyle.getChildren().addAll(cbBold, cbItalic);

        // Create a stack pane with the label displaying "Programming is fun"
        Label lblMessage = new Label("Programming is fun");
        lblMessage.setFont(font);
        StackPane stackPane = new StackPane(lblMessage);
        stackPane.setPrefSize(400, 200);

        // Create a border pane for all the two HBox and the stack panes
        BorderPane pane = new BorderPane();
        pane.setTop(hBoxFont);
        pane.setCenter(stackPane);
        pane.setBottom(hBoxStyle);

        // Default values for the combo boxes
        cbFontName.setValue(font.getFamily());
        cbFontSize.setValue((int) font.getSize());
        cbBold.setSelected(false);
        cbItalic.setSelected(false);

        // Global event handler to be used for all combo and check boxes
        EventHandler<ActionEvent> handler = new EventHandler<>() {
            @Override
            public void handle(ActionEvent t) {
                Font fontChange = Font.font(
                        cbFontName.getValue(),
                        (cbBold.isSelected()) ? FontWeight.BOLD : FontWeight.THIN,
                        (cbItalic.isSelected()) ? FontPosture.ITALIC : FontPosture.REGULAR,
                        cbFontSize.getValue());

                lblMessage.setFont(fontChange);
            }
        };

        // Event handler for the font name, size, weight, and posture
        cbFontName.setOnAction(handler);
        cbFontSize.setOnAction(handler);
        cbBold.setOnAction(handler);
        cbItalic.setOnAction(handler);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("SelectFont"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // The stage is not resizable
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
