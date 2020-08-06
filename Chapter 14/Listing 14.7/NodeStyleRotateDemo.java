import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
/**
 *
 * @author martinfall
 */
public class NodeStyleRotateDemo extends Application {

    @Override // Override abstract method start(Stage) in Application
    public void start(Stage primaryStage) throws Exception {
        // Create a Scene and place a Button in the scene
        StackPane pane = new StackPane();
        Button btOK = new Button("OK");
        btOK.setStyle("-fx-border-color: blue;");
        pane.getChildren().add(btOK);
        
        // rotate the pane
        pane.setRotate(45);
        // set style for pane
        pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
        
        Scene scene = new Scene(pane, 200, 250);
        primaryStage.setTitle("NodeStyleRotateDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
