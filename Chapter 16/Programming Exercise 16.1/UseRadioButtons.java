
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * (Use radio buttons) Write a GUI program as shown in Figure 16.36a. You can
 * use buttons to move the message to the left and right and use the radio
 * buttons to change the color for the message displayed.
 *
 * @author martinfall
 */
public class UseRadioButtons extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create the text
        Text text = new Text("Programming is fun");
        text.setFont(Font.font(
                "Times New Roman",
                FontWeight.EXTRA_BOLD,
                FontPosture.REGULAR,
                20));

        // Create the radio buttons
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbBlack = new RadioButton("Black");
        RadioButton rbOrange = new RadioButton("Orange");
        RadioButton rbGreen = new RadioButton("Green");

        // Create a toggle group and add the buttons to it
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbBlack.setToggleGroup(group);
        rbOrange.setToggleGroup(group);
        rbGreen.setToggleGroup(group);

        // Register an event handler with each radio button
        rbRed.setOnAction(e -> {
            text.setFill(Color.RED);
        });

        rbYellow.setOnAction(e -> {
            text.setFill(Color.YELLOW);
        });

        rbBlack.setOnAction(e -> {
            text.setFill(Color.BLACK);
        });

        rbOrange.setOnAction(e -> {
            text.setFill(Color.ORANGE);
        });

        rbGreen.setOnAction(e -> {
            text.setFill(Color.GREEN);
        });

        // Create an HBox and add the radio buttons to it
        HBox paneForRadioButtons = new HBox(10);
        paneForRadioButtons.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
        paneForRadioButtons.setAlignment(Pos.CENTER); // Center the buttons

        // Create a pane for the text
        Pane paneForText = new Pane(text);
        paneForText.setMinSize(200, 100);
        text.setX(paneForText.getMinWidth() / 2);
        text.setY(paneForText.getMinHeight() / 2);

        // Create the buttons to move the text
        Button btLeft = new Button("<=");
        Button btRight = new Button("=>");

        // Register an event handler with each button
        btLeft.setOnAction(e -> {
            if (text.getX() > 0) {
                text.setX(text.getX() - 10);
            }
        });

        // No bounds for btRight and the text can completely leave the pane
        btRight.setOnAction(e -> {text.setX(text.getX() + 10);});

        // Create an HBox and add the buttons to it
        HBox paneForButtons = new HBox(10);
        paneForButtons.getChildren().addAll(btLeft, btRight);
        paneForButtons.setAlignment(Pos.CENTER);

        // Create a border pane and add all of the panes to it
        BorderPane pane = new BorderPane();
        pane.setTop(paneForRadioButtons);
        pane.setCenter(paneForText);
        pane.setBottom(paneForButtons);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("UseRadioButtons"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
