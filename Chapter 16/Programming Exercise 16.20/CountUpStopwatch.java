
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Count-up stopwatch) Write a program that simulates a stopwatch, as shown in
 * Figure 16.45a. When the user clicks the Start button, the button’s label is
 * changed to Pause, as shown in Figure 16.45b. When the user clicks the Pause
 * button, the button’s label is changed to Resume, as shown in Figure 16.45c.
 * The Clear button resets the count to 0 and resets the button’s label to
 * Start.
 *
 * @author martinfall
 */
public class CountUpStopwatch extends Application {

    // Strings for the labels
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    // Create the labels in order of appearance
    private Label lblHour = new Label(String.format("%02d", hour));
    private Label lblColonHourMin = new Label(":");
    private Label lblMinute = new Label(String.format("%02d", minute));
    private Label lblColonMinSec = new Label(":");
    private Label lblSecond = new Label(String.format("%02d", second));

    // Animation
    Timeline timeline = new Timeline();

    private HBox timer = new HBox(
            lblHour, // Hours
            lblColonHourMin, // :
            lblMinute, // Minutes
            lblColonMinSec, // :
            lblSecond); // Seconds

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Change the font and font size of the labels
        lblHour.setFont(Font.font("Arial", 60));
        lblColonHourMin.setFont(Font.font("Arial", 60));
        lblMinute.setFont(Font.font("Arial", 60));
        lblColonMinSec.setFont(Font.font("Arial", 60));
        lblSecond.setFont(Font.font("Arial", 60));

        // Add padding to the timer HBox
        timer.setPadding(new Insets(20));
        timer.setAlignment(Pos.CENTER);

        // Some buttons magic
        Button btAction = new Button("Start"); // Initial state
        Button btClear = new Button("Clear");

        // Create an HBox for the buttons
        HBox paneForButtons = new HBox(10, btAction, btClear);
        paneForButtons.setPadding(new Insets(10));
        paneForButtons.setAlignment(Pos.CENTER);

        // Create a border pane and add the timer and pane for buttons
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));
        pane.setCenter(timer);
        pane.setBottom(paneForButtons);

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), e -> {
            if (second < 59) {
                second++;

                lblSecond.setText(String.format("%02d", second));
            } else {
                if (minute < 59) {
                    minute++;
                    second = 0;

                    lblMinute.setText(String.format("%02d", minute));
                    lblSecond.setText(String.format("%02d", second));
                } else {
                    if (hour < 23) {
                        hour++;
                        minute = 0;
                        second = 0;

                        lblHour.setText(String.format("%02d", hour));
                        lblMinute.setText(String.format("%02d", minute));
                        lblSecond.setText(String.format("%02d", second));
                    } else {
                        hour = 0;
                        // minute and second
                    }
                }
            }
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.setAutoReverse(false);
        timeline.setCycleCount(Timeline.INDEFINITE);

        // Event handler for the buttons
        btAction.setOnAction(e -> {
            if (btAction.getText().equals("Start")
                    || btAction.getText().equals("Resume")) {
                btAction.setText("Pause");
                timeline.play();
            } else if (btAction.getText().equals("Pause")) {
                btAction.setText("Resume");
                timeline.pause();
            }
        });

        btClear.setOnAction(e -> {
            timeline.stop(); // Stop the animation

            // Reset the hour, minute, and second variables
            hour = 0;
            minute = 0;
            second = 0;

            // Update the labels
            lblHour.setText(String.format("%02d", hour));
            lblMinute.setText(String.format("%02d", minute));
            lblSecond.setText(String.format("%02d", second));
            
            // Update the button
            btAction.setText("Start");
        });

        // Create a new scene and place it in the pane
        Scene scene = new Scene(pane);
        primaryStage.setTitle("CountUpStopwatch"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizeable
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
