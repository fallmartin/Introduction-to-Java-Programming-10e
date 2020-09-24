
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * (Traffic lights) Write a program that simulates a traffic light. The program
 * lets the user select one of three lights: red, yellow, or green. When a radio
 * button is selected, the light is turned on. Only one light can be on at a
 * time (see Figure 16.37a). No light is on when the program starts.
 *
 * @author martinfall
 */
public class TrafficLight extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Local variables
        final int width = 500;
        final int height = 400;
        final int radius = 40;

        // Build a visual representation of the traffic light using a grid pane
        GridPane paneForTrafficLight = new GridPane();
        paneForTrafficLight.setPadding(new Insets(10));
        paneForTrafficLight.setGridLinesVisible(false);
        paneForTrafficLight.setMaxSize(100, 300);
        paneForTrafficLight.setBorder(
                new Border(
                        new BorderStroke(
                                Color.BLACK,
                                BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY,
                                new BorderWidths(5))));
        paneForTrafficLight.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.DIMGREY,
                                CornerRadii.EMPTY,
                                Insets.EMPTY)));

        Circle cRed = new Circle(radius);
        cRed.setFill(Color.TRANSPARENT);
        cRed.setStroke(Color.BLACK);
        cRed.setStrokeWidth(2);

        Circle cYellow = new Circle(radius);
        cYellow.setFill(Color.TRANSPARENT);
        cYellow.setStroke(Color.BLACK);
        cYellow.setStrokeWidth(2);

        Circle cGreen = new Circle(radius);
        cGreen.setFill(Color.TRANSPARENT);
        cGreen.setStroke(Color.BLACK);
        cGreen.setStrokeWidth(2);

        paneForTrafficLight.add(cRed, 0, 0);
        GridPane.setMargin(cRed, new Insets(10));
        paneForTrafficLight.add(cYellow, 0, 1);
        GridPane.setMargin(cYellow, new Insets(10));
        paneForTrafficLight.add(cGreen, 0, 2);
        GridPane.setMargin(cGreen, new Insets(10));

        // Create the radio buttons
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbGreen = new RadioButton("Green");

        // Add the buttons to a toggle group
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbGreen.setToggleGroup(group);

        // Add the radio buttons to a HBox
        HBox paneForButtons = new HBox(10);
        paneForButtons.getChildren().addAll(rbRed, rbYellow, rbGreen);
        paneForButtons.setAlignment(Pos.CENTER);

        // Event handlers for the radio buttons
        rbRed.setOnAction(e -> {
            cRed.setFill(Color.RED);
            cYellow.setFill(Color.TRANSPARENT);
            cGreen.setFill(Color.TRANSPARENT);
        });

        rbYellow.setOnAction(e -> {
            cRed.setFill(Color.TRANSPARENT);
            cYellow.setFill(Color.YELLOW);
            cGreen.setFill(Color.TRANSPARENT);
        });

        rbGreen.setOnAction(e -> {
            cRed.setFill(Color.TRANSPARENT);
            cYellow.setFill(Color.TRANSPARENT);
            cGreen.setFill(Color.GREEN);
        });

        // Create a border pane and add paneForTrafficLight and paneForButtons
        BorderPane pane = new BorderPane();
        pane.setCenter(paneForTrafficLight);
        BorderPane.setAlignment(paneForTrafficLight, Pos.CENTER);
        pane.setBottom(paneForButtons);
        BorderPane.setAlignment(paneForButtons, Pos.CENTER);
        BorderPane.setMargin(paneForButtons, new Insets(10));

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, width, height);
        primaryStage.setTitle("TrafficLight"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
