
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * (Enter and display a string) Write a program that receives a string from the
 * keyboard and displays it on a pane. The Enter key signals the end of a
 * string. Whenever a new string is entered, it is displayed on the pane.
 *
 * @author martinfall
 */
public class EnterDisplayString extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a new Pane
        // StackPane pane = new StackPane();
        StackPane pane = new StackPane();
        StringBuilder str = new StringBuilder();

        pane.setPadding(
                new Insets(10));

        pane.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t
            ) {
                if (t.getCode().equals(KeyCode.ENTER)) {
                    pane.getChildren().clear();
                    pane.getChildren().add(new Text(str.toString()));
                    str.delete(0, str.length());
                } else {

                    str.append(t.getText());
                    System.out.println(str);
                }
            }
        }
        );

        // Create a new scene and place it in the stage
        Scene scene = new Scene(pane, 300, 100);

        primaryStage.setTitle("Exercise_15_10"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.setResizable(false); // Make the stage not resizable
        primaryStage.show(); // Display the primary stage

        pane.requestFocus();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
