
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * (Use ComboBox and ListView) Write a program that demonstrates selecting items
 * in a list. The program uses a combo box to specify a selection mode, as shown
 * in Figure 16.43a. When you select items, they are displayed in a label below
 * the list.
 *
 * @author martinfall
 */
public class SelectItemsInAList extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create a label for the subsequent combo box
        Label lblSelectionMode = new Label("Choose Selection Mode: ");

        // Create a combo box to specify a selection mode
        ObservableList<SelectionMode> cbItems = FXCollections.observableArrayList(
                SelectionMode.SINGLE, SelectionMode.MULTIPLE
        );
        ComboBox<SelectionMode> cbSelectionMode = new ComboBox<>(cbItems);
        cbSelectionMode.setValue(SelectionMode.SINGLE);

        // Create an HBox for the label and the combo box
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.CENTER);
        // hBox.setPrefWidth(400);
        hBox.getChildren().addAll(lblSelectionMode, cbSelectionMode);

        // Create the list view
        ObservableList<String> lvItems = FXCollections.observableArrayList(
                "China", "Japan", "Korea", "India", "Malaysia", "Vietnam"
        );
        ListView<String> listView = new ListView<>(lvItems);

        // Create an HBox with two labels to display the selected items
        Label lblAnnounce = new Label("Selected Items are: ");
        Label lblSelectedItems = new Label();
        HBox hbSelectedItems = new HBox(0);
        hbSelectedItems.setAlignment(Pos.CENTER_LEFT);
        hbSelectedItems.getChildren().addAll(lblAnnounce, lblSelectedItems);

        // Create a border pane and add the combo box and list view to it
        BorderPane pane = new BorderPane();
        pane.setTop(hBox);
        pane.setCenter(listView);
        pane.setBottom(hbSelectedItems);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setTitle("LabelPropertiesDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // The stage is not resizable

        // Event handler for the combo box
        cbSelectionMode.setOnAction(e -> {
            listView.getSelectionModel().setSelectionMode(
                    cbSelectionMode.getValue()
            );
        });

        // Event listener for the list view
        listView.setOnMouseClicked(e -> {
            Object[] list = listView.getSelectionModel().getSelectedItems().toArray();
            String s = "";

            for (Object o : list) {
                s = s + ((String) o) + " ";
            }

            lblSelectedItems.setText(s);
        });
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
