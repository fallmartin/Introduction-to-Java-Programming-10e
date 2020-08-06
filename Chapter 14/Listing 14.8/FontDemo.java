
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 *
 * @author martinfall
 */
public class FontDemo extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create a pane to hold the Circle
        Pane pane = new StackPane();

        // Create a Circle and set its properties
        Circle circle = new Circle();
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(new Color(0.5, 0.5, 0.5, 1.0));

        // Add circle to the pane
        // pane.getChildren().add(circle);
        // Create a Label and set its properties
        Label label = new Label("JavaFX");
        label.setFont(
                Font.font( // Static method of the Font class
                        "Times New Roman", // name
                        FontWeight.BOLD, // weight
                        FontPosture.ITALIC, // posture
                        20)); // size
        // pane.getChildren().add(label);

        // Add all nodes to the pane
        pane.getChildren().addAll(circle, label);

        // Create a Scene and place it in the Stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("FontDemo"); // Set the Stage title
        primaryStage.setScene(scene); // Place the Scene in the Stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
