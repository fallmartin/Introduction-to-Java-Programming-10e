
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * (Set clock time) Write a program that displays a clock and sets the time with
 * the input from three text fields, as shown in Figure 16.38b. Use the
 * ClockPane in Listing 14.21. Resize the clock to the center of the pane.
 *
 * @author martinfall
 */
public class SetClockTime extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create the labels and text fields for hours, minutes, and seconds
        TextField tfHour = new TextField();
        TextField tfMinute = new TextField();
        TextField tfSecond = new TextField();

        tfHour.setPrefColumnCount(3);
        tfMinute.setPrefColumnCount(3);
        tfSecond.setPrefColumnCount(3);

        tfHour.setAlignment(Pos.CENTER_RIGHT);
        tfMinute.setAlignment(Pos.CENTER_RIGHT);
        tfSecond.setAlignment(Pos.CENTER_RIGHT);

        Label lblHour = new Label("Hour");
        Label lblMinute = new Label("Minute");
        Label lblSecond = new Label("Second");

        // Create an HBox and add the labels and text fields
        HBox paneForControls = new HBox(10);
        paneForControls.setPadding(new Insets(10));
        paneForControls.setAlignment(Pos.CENTER);
        paneForControls.getChildren().addAll(
                lblHour, tfHour,
                lblMinute, tfMinute,
                lblSecond, tfSecond);

        // Create a new clock pane
        ClockPane clockPane = new ClockPane(); // Defaults at the current time
        clockPane.setWidth(300);
        clockPane.setHeight(300);

        // Populate the text fields with value from the clock pane
        tfHour.setText(Integer.toString(clockPane.getHour()));
        tfMinute.setText(Integer.toString(clockPane.getMinute()));
        tfSecond.setText(Integer.toString(clockPane.getSecond()));

        // Create a new border pane and add the clock and controls panes
        BorderPane pane = new BorderPane();
        pane.setCenter(clockPane);
        pane.setBottom(paneForControls);

        // Event handler for the text fields
        tfHour.setOnAction(e -> {
            clockPane.setHour(Integer.parseInt(tfHour.getText()));
        });

        tfMinute.setOnAction(e -> {
            clockPane.setMinute(Integer.parseInt(tfMinute.getText()));
        });

        tfSecond.setOnAction(e -> {
            clockPane.setSecond(Integer.parseInt(tfSecond.getText()));
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("SetClockTime"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        tfHour.requestFocus(); // Focus set on the selected default

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
