
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * (Move the ball) Write a program that moves the ball in a pane. You should
 * define a pane class for displaying the ball and provide the methods for
 * moving the ball left, right, up, and down, as shown in Figure 15.24c. Check
 * the boundary to prevent the ball from moving out of sight completely.
 *
 * @author martinfall
 */
public class MoveTheBall extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a new ballPane pane
        BallPane ballPane = new BallPane();

        // Create the buttons
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        Button btUp = new Button("Up");
        Button btDown = new Button("Down");

        // Add the buttons to a flow pane
        FlowPane buttonsPane = new FlowPane(Orientation.HORIZONTAL);
        buttonsPane.setHgap(10);
        buttonsPane.setAlignment(Pos.CENTER);
        buttonsPane.getChildren().addAll(btLeft, btRight, btUp, btDown);

        // Register the event handlers with the button nodes
        btLeft.setOnAction(e -> ballPane.moveLeft());
        btRight.setOnAction(e -> ballPane.moveRight());
        btUp.setOnAction(e -> ballPane.moveUp());
        btDown.setOnAction(e -> ballPane.moveDown());

        // Add the ballPane and control buttons to a border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setBottom(buttonsPane);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 350, 350);
        primaryStage.setTitle("Exercise_15_3"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
