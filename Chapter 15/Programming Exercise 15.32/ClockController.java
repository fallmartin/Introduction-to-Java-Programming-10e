
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * (Control a clock) Modify Listing 14.21, ClockPane.java, to add the animation
 * into this class and add two methods start() and stop() to start and stop the
 * clock. Write a program that lets the user control the clock with the Start
 * and Stop buttons, as shown in Figure 15.36a.
 *
 * @author martinfall
 */
public class ClockController extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create the controlPane pane
        HBox controlPane = new HBox(10);
        controlPane.setPadding(new Insets(10));
        controlPane.setAlignment(Pos.CENTER);

        // Create the Stop and Start controlPane
        Button btStop = new Button("Stop");
        Button btStart = new Button("Start");

        // Add the buttons to the control pane
        controlPane.getChildren().addAll(btStop, btStart);

        // Create a new clockPane pane
        ClockPane clockPane = new ClockPane();

        // Create a border pane and add clockPane to center and controlPane to bottom
        BorderPane pane = new BorderPane();
        pane.setCenter(clockPane);
        BorderPane.setAlignment(clockPane, Pos.CENTER);
        pane.setBottom(controlPane);
        BorderPane.setAlignment(controlPane, Pos.CENTER);

        // Register the event handlers with the stop and start buttons
        btStop.setOnMouseClicked(e -> clockPane.stop());
        btStart.setOnMouseClicked(e -> clockPane.start());

        // Create a new scene and add it to the stage
        Scene scene = new Scene(pane, 250, 290);
        primaryStage.setTitle("Exercise_15_32"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizable

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
