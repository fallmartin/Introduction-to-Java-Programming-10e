
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author martinfall
 */
public class TextAreaDemo extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Declare and create a DescriptionPane
        DescriptionPane descriptionPane = new DescriptionPane();

        // Set text, title, and image in the description pane
        descriptionPane.setTitle("Canada");
        String description = "The Canadian national flag...";
        descriptionPane.setImageView(new ImageView("ca.gif"));
        descriptionPane.setDescription(description);

        // Create a scene and place it in the stage
        Scene scene = new Scene(descriptionPane, 450, 150);
        primaryStage.setTitle("TextAreaDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
