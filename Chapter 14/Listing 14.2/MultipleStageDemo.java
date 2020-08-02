
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author martinfall
 */
public class MultipleStageDemo extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create a scene and place a button in the scene
        Scene scene = new Scene(new Button("OK"), 200, 250);
        // Set the stage title
        primaryStage.setTitle("MyJavaFX");
        // Place the scene in the stage
        primaryStage.setScene(scene);
        // Display the stage
        primaryStage.show();

        // Create a new Stage
        Stage stage = new Stage();
        // Set the stage title
        stage.setTitle("Second Stage");
        // Set a scene with a button in the stage
        stage.setScene(new Scene(new Button("New Stage"), 100, 100));
        // Display the stage
        stage.show();
        // Prevent the user from resizing the stage
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
