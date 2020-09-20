
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author martinfall
 */
public class ListViewDemo extends Application {

    // Declare an array of strings for flag titles
    private String[] flagTitles = {"Canada", "China", "Denmark",
        "France", "Germany", "India", "Norway", "United Kingdom",
        "United States of America"};

    // Declare an ImageView array for the national flags of nine countries
    private ImageView[] ImageViews = {
        new ImageView("images/ca.gif"),
        new ImageView("images/china.gif"),
        new ImageView("images/denmark.gif"),
        new ImageView("images/fr.gif"),
        new ImageView("images/germany.gif"),
        new ImageView("images/india.gif"),
        new ImageView("images/norway.gif"),
        new ImageView("images/uk.gif"),
        new ImageView("images/us.gif")
    };

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        ListView<String> lv
                = new ListView<>(FXCollections.observableArrayList(flagTitles));
        lv.setPrefSize(100, 400);
        lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Create a pane to hold image views
        FlowPane imagePane = new FlowPane(10, 10);
        BorderPane pane = new BorderPane();
        pane.setLeft(new ScrollPane(lv));
        pane.setCenter(new ScrollPane(imagePane));

        lv.getSelectionModel().selectedItemProperty().addListener(ov -> {
            imagePane.getChildren().clear();

            for (Integer i : lv.getSelectionModel().getSelectedIndices()) {
                imagePane.getChildren().add(ImageViews[i]);
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("ListViewDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
