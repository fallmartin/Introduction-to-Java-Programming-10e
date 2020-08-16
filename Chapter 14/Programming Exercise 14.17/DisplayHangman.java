
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * (Game: hangman) Write a program that displays a drawing for the popular
 * hangman game, as shown in Figure 14.48a.
 *
 * @author martinfall
 */
public class DisplayHangman extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create a new pane
        Pane pane = new Pane();
        pane.setPadding(new Insets(10));
        pane.setMinWidth(500);
        pane.setMinHeight(600);

        // Create the base of the scaffold
        Arc base = new Arc(120, 600, 100, 50, 0, 180);
        base.setType(ArcType.OPEN);
        base.setFill(Color.TRANSPARENT);
        base.setStroke(Color.BLACK);

        // Create the trunk
        Line trunk = new Line(120, 100, 120, 550);
        trunk.setStroke(Color.BLACK);

        // Create the top of the scaffolding
        Line top = new Line(120, 100, 320, 100);
        top.setStroke(Color.BLACK);

        // Create the noose
        Line noose = new Line(320, 100, 320, 200);
        noose.setStroke(Color.BLACK);

        // Create the head
        Circle head = new Circle(320, 230, 30, Color.TRANSPARENT);
        head.setStroke(Color.BLACK);

        // Create the body
        Line body = new Line(320, 260, 320, 390);
        body.setStroke(Color.BLACK);

        // Create the arms
        Line leftArm = new Line(320, 270, 280, 350);
        leftArm.setStroke(Color.BLACK);
        Line rightArm = new Line(320, 270, 360, 350);
        rightArm.setStroke(Color.BLACK);

        // Create the legs
        Line leftLeg = new Line(320, 390, 280, 470);
        leftLeg.setStroke(Color.BLACK);
        Line rightLeg = new Line(320, 390, 360, 470);
        rightLeg.setStroke(Color.BLACK);

        // Add all the nodes to the pane
        pane.getChildren().addAll(base, trunk, top, noose, // Scaffolding
                head, body, leftArm, rightArm, leftLeg, rightLeg); // Person

        // Create a new scene
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_14_17"); // Set the primaryStage title
        primaryStage.setScene(scene); // Set the scene in the primaryStage
        primaryStage.show(); // Display the primaryStage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
