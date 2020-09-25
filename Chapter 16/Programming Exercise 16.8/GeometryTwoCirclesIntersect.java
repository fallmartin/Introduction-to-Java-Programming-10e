
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * (Geometry: two circles intersect?) Write a program that enables the user to
 * specify the location and size of the circles and displays whether the two
 * circles intersect, as shown in Figure 16.39a. Enable the user to point the
 * mouse inside a circle and drag it. As the circle is being dragged, the
 * circle’s center coordinates in the text fields are updated.
 *
 * @author martinfall
 */
public class GeometryTwoCirclesIntersect extends Application {

    private Circle circle1 = new Circle();
    private Circle circle2 = new Circle();
    Label lblIntersect = new Label("Two circles intersect? No");
    private final static int WIDTH = 200;
    private final static int HEIGHT = 200;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {

        // circle1 and circle2 initial properties
        circle1.setCenterX(75.0);
        circle1.setCenterY(110.0);
        circle1.setRadius(30);
        circle1.setFill(Color.TRANSPARENT);
        circle1.setStroke(Color.BLACK);

        circle2.setCenterX(200);
        circle2.setCenterY(100);
        circle2.setRadius(40);
        circle2.setFill(Color.TRANSPARENT);
        circle2.setStroke(Color.BLACK);

        /**
         * Circle 1 input pane
         */
        // Text fields and labels for circle 1
        Label lblPrompt1 = new Label("Enter circle 1 info:");
        Label lblCenterX1 = new Label("Center x:");
        TextField tfCenterX1 = new TextField(Double.toString(circle1.getCenterX()));
        Label lblCenterY1 = new Label("Center y:");
        TextField tfCenterY1 = new TextField(Double.toString(circle1.getCenterY()));
        Label lblRadius1 = new Label("Radius:");
        TextField tfRadius1 = new TextField(Double.toString(circle1.getRadius()));

        // UI Tweaks
        tfCenterX1.setPrefColumnCount(4);
        tfCenterY1.setPrefColumnCount(4);
        tfRadius1.setPrefColumnCount(4);

        // Border and grid panes to hold the prompt and label/text field pairs
        BorderPane paneForCircle1Inputs = new BorderPane();
        paneForCircle1Inputs.setPadding(new Insets(5));
        GridPane gpCircle1 = new GridPane();
        gpCircle1.setHgap(5);
        gpCircle1.setVgap(5);

        // Populate the border and grid panes
        gpCircle1.addColumn(0, lblCenterX1, lblCenterY1, lblRadius1);
        gpCircle1.addColumn(1, tfCenterX1, tfCenterY1, tfRadius1);
        paneForCircle1Inputs.setTop(lblPrompt1);
        paneForCircle1Inputs.setCenter(gpCircle1);

        /**
         * Circle 2 input pane
         */
        // Text fields and labels for circle 1
        Label lblPrompt2 = new Label("Enter circle 2 info:");
        Label lblCenterX2 = new Label("Center x:");
        TextField tfCenterX2 = new TextField(Double.toString(circle2.getCenterX()));
        Label lblCenterY2 = new Label("Center y:");
        TextField tfCenterY2 = new TextField(Double.toString(circle2.getCenterY()));
        Label lblRadius2 = new Label("Radius:");
        TextField tfRadius2 = new TextField(Double.toString(circle2.getRadius()));

        // UI Tweaks
        tfCenterX2.setPrefColumnCount(4);
        tfCenterY2.setPrefColumnCount(4);
        tfRadius2.setPrefColumnCount(4);

        // Border and grid panes to hold the prompt and label/text field pairs
        BorderPane paneForCircle2Inputs = new BorderPane();
        paneForCircle2Inputs.setPadding(new Insets(5));
        GridPane gpCircle2 = new GridPane();
        gpCircle2.setHgap(5);
        gpCircle2.setVgap(5);

        // Populate the border and grid panes
        gpCircle2.addColumn(0, lblCenterX2, lblCenterY2, lblRadius2);
        gpCircle2.addColumn(1, tfCenterX2, tfCenterY2, tfRadius2);
        paneForCircle2Inputs.setTop(lblPrompt2);
        paneForCircle2Inputs.setCenter(gpCircle2);

        /**
         * Pane for circle 1 and circle 2 input panes
         */
        GridPane paneForInputs = new GridPane();
        paneForInputs.setPadding(new Insets(5));
        paneForInputs.setHgap(5);
        paneForInputs.addRow(0, paneForCircle1Inputs, paneForCircle2Inputs);

        // Set borders for each input paneForCircles
        paneForCircle1Inputs.setBorder(new Border(new BorderStroke(
                Color.BLACK,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                new BorderWidths(1))));
        paneForCircle2Inputs.setBorder(new Border(new BorderStroke(
                Color.BLACK,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                new BorderWidths(1))));

        // Create the button to redraw circles
        Button btRedraw = new Button("Redraw Circles");

        // Create the paneForCircles for the 2 circles
        Pane paneForCircles = new Pane();
        paneForCircles.setMinSize(WIDTH, HEIGHT);
        paneForCircles.getChildren().addAll(circle1, circle2);

        // Add the intersect label to the pane
        lblIntersect.setLayoutX(70);
        lblIntersect.setLayoutY(0);
        paneForCircles.getChildren().add(lblIntersect);

        // Border paneForCircles for the paneForCircles for 2 circles, controls, and button
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5));
        pane.setTop(paneForCircles);
        pane.setCenter(paneForInputs);
        pane.setBottom(btRedraw);
        BorderPane.setAlignment(btRedraw, Pos.CENTER);

        // Make circles draggable
        circle1.setOnMouseDragged(e -> {
            circle1.setCenterX(e.getX());
            tfCenterX1.setText(Double.toString(circle1.getCenterX()));
            circle1.setCenterY(e.getY());
            tfCenterY1.setText(Double.toString(circle1.getCenterY()));
            checkIntersect(); // Check if the circles intersect
        });

        circle2.setOnMouseDragged(e -> {
            circle2.setCenterX(e.getX());
            tfCenterX2.setText(Double.toString(circle2.getCenterX()));
            circle2.setCenterY(e.getY());
            tfCenterY2.setText(Double.toString(circle2.getCenterY()));
            checkIntersect(); // Check if the circles intersect
        });

        // Register event listeners for the text fields of each circle
        // Circle 1
        tfCenterX1.setOnAction(e -> {
            circle1.setCenterX(Double.parseDouble(tfCenterX1.getText()));
            checkIntersect(); // Check if the circles intersect
        });

        tfCenterY1.setOnAction(e -> {
            circle1.setCenterY(Double.parseDouble(tfCenterY1.getText()));
            checkIntersect(); // Check if the circles intersect
        });
        tfRadius1.setOnAction(e -> {
            circle1.setRadius(Double.parseDouble(tfRadius1.getText()));
            checkIntersect(); // Check if the circles intersect
        });

        // Circle 2
        tfCenterX2.setOnAction(e -> {
            circle2.setCenterX(Double.parseDouble(tfCenterX2.getText()));
            checkIntersect(); // Check if the circles intersect
        });

        tfCenterY2.setOnAction(e -> {
            circle2.setCenterY(Double.parseDouble(tfCenterY2.getText()));
            checkIntersect(); // Check if the circles intersect
        });

        tfRadius2.setOnAction(e -> {
            circle2.setRadius(Double.parseDouble(tfRadius2.getText()));
            checkIntersect(); // Check if the circles intersect
        });

        // Redraw button
        btRedraw.setOnAction(e -> {
            // Circle 1 
            circle1.setCenterX(Double.parseDouble(tfCenterX1.getText()));
            circle1.setCenterY(Double.parseDouble(tfCenterY1.getText()));
            circle1.setRadius(Double.parseDouble(tfRadius1.getText()));

            // Circle 2
            circle2.setCenterX(Double.parseDouble(tfCenterX2.getText()));
            circle2.setCenterY(Double.parseDouble(tfCenterY2.getText()));
            circle2.setRadius(Double.parseDouble(tfRadius2.getText()));

            checkIntersect(); // Check if the circles intersect
        });

        // Add a listener
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("GeometryTwoCirclesIntersect"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // The stage is not resizable
    }

    public void checkIntersect() {
        // Local variable declarations for convenience
        double x1 = circle1.getCenterX();
        double y1 = circle1.getCenterY();
        double r1 = circle1.getRadius();
        double x2 = circle2.getCenterX();
        double y2 = circle2.getCenterY();
        double r2 = circle2.getRadius();

        double distanceSquared = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
        double radiiSumSquared = (r1 + r2) * (r1 + r2);

        // Update the label
        if (distanceSquared < radiiSumSquared) {
            lblIntersect.setText("Two circles intersect? Yes");
        } else {
            lblIntersect.setText("Two circles intersect? No");
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
