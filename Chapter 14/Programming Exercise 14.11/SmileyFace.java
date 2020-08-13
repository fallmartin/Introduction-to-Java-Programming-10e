
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * (Paint a smiley face) Write a program that paints a smiley face, as shown in
 * Figure 14.46a.
 *
 * @author martinfall
 */
public class SmileyFace extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        // Create a border pane
        Pane pane = new Pane();
        pane.setPadding(new Insets(10)); // Set padding to 10 pixels all around

        // Create the outer circle of the smiley face
        Circle face = new Circle(120, 120, 100);
        face.setFill(Color.TRANSPARENT);
        face.setStroke(Color.BLACK);

        // Create the nose
        Polygon nose = new Polygon(120, 100, 140, 150, 100, 150);
        nose.setFill(Color.TRANSPARENT);
        nose.setStroke(Color.BLACK);

        // Create the left eye
        Ellipse leftEye = new Ellipse(80, 80, 20, 10);
        leftEye.setFill(Color.TRANSPARENT);
        leftEye.setStroke(Color.BLACK);

        // Create the right eye and pupil
        Ellipse rightEye = new Ellipse(160, 80, 20, 10);
        rightEye.setFill(Color.TRANSPARENT);
        rightEye.setStroke(Color.BLACK);

        // Create the left and right pupils
        Circle leftPupil = new Circle(80, 80, 5, Color.BLACK);
        Circle rightPupil = new Circle(160, 80, 5, Color.BLACK);

        // Create that winning smile
        Arc smile = new Arc(120, 160, 60, 20, 180, 180);
        smile.setFill(Color.TRANSPARENT);
        smile.setStroke(Color.BLACK);

        // Add all nodes to the pane
        pane.getChildren().addAll(face, nose, leftEye, rightEye, leftPupil, rightPupil, smile);

        // Create a new scene
        Scene scene = new Scene(pane);
        stage.setTitle("Exercise_14_11"); // Set the stage title
        stage.setScene(scene); // Set the scene on the stage
        stage.show(); // Display the stage
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
