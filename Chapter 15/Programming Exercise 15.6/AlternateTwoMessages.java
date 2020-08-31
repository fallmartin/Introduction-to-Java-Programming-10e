
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * (Alternate two messages) Write a program to display the text Java is fun and
 * Java is powerful alternately with a mouse click.
 *
 * @author martinfall
 */
public class AlternateTwoMessages extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a pane
        StackPane pane = new StackPane();

        // Create the text and add it to the pane
        Text message = new Text(20, 20, "Java is fun");
        message.setFont(Font.font("Times New Roman", 20));
        pane.getChildren().add(message);

        // Register the event handler with the Text object message
        message.setOnMouseClicked(e -> {
            if (message.getText().equals("Java is fun")) {
                message.setText("Java is powerful");
            } else {
                message.setText("Java is fun");
            }
        }); // Registering the event handler with pane makes it easier to click

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 50);
        primaryStage.setTitle("Exercise_15_6"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
