
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * (Select geometric figures) Write a program that draws various figures, as
 * shown in Figure 16.36b. The user selects a figure from a radio button and
 * uses a check box to specify whether it is filled.
 *
 * @author martinfall
 */
public class SelectGeometricFigures extends Application {

    private final static int WIDTH = 400;
    private final static int HEIGHT = 200;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create a stack pane
        StackPane stackPane = new StackPane();
        stackPane.setMinSize(WIDTH, HEIGHT);

        // Create the radio buttons and check box
        RadioButton rbCircle = new RadioButton("Circle");
        RadioButton rbRectangle = new RadioButton("Rectangle");
        RadioButton rbEllipse = new RadioButton("Ellipse");
        CheckBox cbFill = new CheckBox("Fill");

        // Create a label and add it to the stack pane
        Label label = new Label("Choose a geometric figure below.");
        label.setFont(
                Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20));
        stackPane.getChildren().add(label);

        // Add the radio buttons to a toggle group
        ToggleGroup group = new ToggleGroup();
        rbCircle.setToggleGroup(group);
        rbRectangle.setToggleGroup(group);
        rbEllipse.setToggleGroup(group);

        // Register an event handler with each radio button and the check box
        rbCircle.setOnAction(e -> {
            // Create a new circle
            Circle circle = new Circle((HEIGHT * 0.8) / 2);
            circle.setStroke(Color.BLACK);
            circle.setStrokeWidth(2);
            circle.setFill(Color.TRANSPARENT);

            // Check if the check box is selected
            if (cbFill.isSelected()) {
                circle.setFill(Color.LIGHTGRAY);
            }

            // Clear the stack pane and add the circle to it
            stackPane.getChildren().clear();
            stackPane.getChildren().add(circle);
        });

        rbRectangle.setOnAction(e -> {
            // Create a new rectangle
            Rectangle rectangle = new Rectangle(WIDTH * 0.7, HEIGHT * 0.7);
            rectangle.setStroke(Color.BLACK);
            rectangle.setStrokeWidth(2);
            rectangle.setFill(Color.TRANSPARENT);

            // Check if the check box is selected
            if (cbFill.isSelected()) {
                rectangle.setFill(Color.LIGHTGRAY);
            }

            // Clear the stack pane and add the rectangle to it
            stackPane.getChildren().clear();
            stackPane.getChildren().add(rectangle);
        });

        rbEllipse.setOnAction(e -> {
            // Create a new ellipse
            Ellipse ellipse = new Ellipse();
            ellipse.setStroke(Color.BLACK);
            ellipse.setStrokeWidth(2);
            ellipse.setFill(Color.TRANSPARENT);
            ellipse.setRadiusX((WIDTH * 0.8) / 2);
            ellipse.setRadiusY((HEIGHT * 0.6) / 2);

            // Check if the check box is selected
            if (cbFill.isSelected()) {
                ellipse.setFill(Color.LIGHTGRAY);
            }

            // Clear the stack pane and add the ellipse to it
            stackPane.getChildren().clear();
            stackPane.getChildren().add(ellipse);
        });

//        cbFill.selectedProperty().addListener(ov -> {
//            if (cbFill.isSelected()) {
//                Node node = stackPane.getChildren().get(0);
//                ((Shape) node).setFill(Color.LIGHTGRAY);
//            } else {
//                Node node = stackPane.getChildren().get(0);
//                ((Shape) node).setFill(Color.TRANSPARENT);
//            }
//        });
        cbFill.setOnAction(e -> {
            if (cbFill.isSelected()) {
                Node node = stackPane.getChildren().get(0);
                ((Shape) node).setFill(Color.LIGHTGRAY);
            } else {
                Node node = stackPane.getChildren().get(0);
                ((Shape) node).setFill(Color.TRANSPARENT);
            }
        });

        // Create an HBox pane for the radio buttons and the check box
        HBox paneForButtons = new HBox(10);
        paneForButtons.getChildren().addAll(
                rbCircle, rbRectangle, rbEllipse, cbFill);
        paneForButtons.setAlignment(Pos.CENTER);

        // Create a new border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(stackPane);
        pane.setBottom(paneForButtons);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("SelectGeometricFigures"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
