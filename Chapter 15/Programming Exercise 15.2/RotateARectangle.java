
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * (Rotate a rectangle) Write a program that rotates a rectangle 15 degrees
 * right when the Rotate button is clicked, as shown in Figure 15.24b.
 *
 * @author martinfall
 */
public class RotateARectangle extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a new border pane
        BorderPane pane = new BorderPane();

        // Create the rotate button and set it in the bottom of the border pane
        Button btRotate = new Button("Rotate");
        pane.setBottom(btRotate);
        BorderPane.setAlignment(btRotate, Pos.TOP_CENTER);

        // Create a rectangle object
        Rectangle rectangle = new Rectangle(100, 50, Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);
        pane.setCenter(rectangle);
        BorderPane.setAlignment(rectangle, Pos.CENTER);

        // Register the event handler with the button
        btRotate.setOnAction(e -> {
            rectangle.setRotate(rectangle.getRotate() + 15);
            btRotate.requestFocus();
        });

        // Create a scene and place it in the primary stage
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Exercise_15_2"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
