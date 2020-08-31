
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * (Change color using a mouse) Write a program that displays the color of a
 * circle as black when the mouse button is pressed and as white when the mouse
 * button is released.
 *
 * @author martinfall
 */
public class ChangeColorUsingAMouse extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a new stack pane
        StackPane pane = new StackPane();
        pane.setPadding(new Insets(20));

        // Create a new circle object
        Circle circle = new Circle(60);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);
        circle.setFill(Color.WHITE); // When the mouse button is released

        // Add the circle to the stack pane
        pane.getChildren().add(circle);

        // Anonymous mouse event handler registered with the circle object
        circle.setOnMousePressed(e -> circle.setFill(Color.BLACK));
        circle.setOnMouseReleased(e -> circle.setFill(Color.WHITE));

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Exercise_15_7"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
