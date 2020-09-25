
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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * (Geometry: two rectangles intersect?) Write a program that enables the user
 * to specify the location and size of the rectangles and displays whether the
 * two rectangles intersect, as shown in Figure 16.39b. Enable the user to point
 * the mouse inside a rectangle and drag it. As the rectangle is being dragged,
 * the rectangle’s center coordinates in the text fields are updated.
 *
 * @author martinfall
 */
public class GeometryTwoRectanglesIntersect extends Application {

    // Rectangles with initial default values chosen to reflect those in book
    private Rectangle r1 = new Rectangle(79.0, 20.0, 40.0, 50.0);
    private Rectangle r2 = new Rectangle(110.00, 33.00, 50.00, 20.00);
    Label lblIntersect = new Label("Two rectangles intersect? Yes");
    private final static int WIDTH = 300;
    private final static int HEIGHT = 200;
    
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Set r1 and r2' fill and stroke properties
        r1.setFill(Color.TRANSPARENT);
        r1.setStroke(Color.BLACK);
        r2.setFill(Color.TRANSPARENT);
        r2.setStroke(Color.BLACK);

        /**
         * Rectangle r1 input pane
         */
        // Text fields and labels for r1
        Label lblPrompt1 = new Label("Enter rectangle 1 info:");
        Label lblX1 = new Label("X:");
        TextField tfX1 = new TextField(Double.toString(r1.getX()));
        Label lblY1 = new Label("Y:");
        TextField tfY1 = new TextField(Double.toString(r1.getY()));
        Label lblWidth1 = new Label("Width:");
        TextField tfWidth1 = new TextField(Double.toString(r1.getWidth()));
        Label lblHeight1 = new Label("Height:");
        TextField tfHeight1 = new TextField(Double.toString(r1.getHeight()));

        // UI Tweaks
        tfX1.setPrefColumnCount(4);
        tfY1.setPrefColumnCount(4);
        tfWidth1.setPrefColumnCount(4);
        tfHeight1.setPrefColumnCount(4);

        // Border and grid panes to hold the prompt and label/text field pairs
        BorderPane paneForRectangle1Inputs = new BorderPane();
        paneForRectangle1Inputs.setPadding(new Insets(5));
        GridPane gpRectangle1 = new GridPane();
        gpRectangle1.setHgap(5);
        gpRectangle1.setVgap(5);

        // Populate the border and grid panes
        gpRectangle1.addColumn(0, lblX1, lblY1, lblWidth1, lblHeight1);
        gpRectangle1.addColumn(1, tfX1, tfY1, tfWidth1, tfHeight1);
        paneForRectangle1Inputs.setTop(lblPrompt1);
        paneForRectangle1Inputs.setCenter(gpRectangle1);

        /**
         * Rectangle r2 input pane
         */
        // Text fields and labels for r1
        Label lblPrompt2 = new Label("Enter rectangle 2 info:");
        Label lblX2 = new Label("X:");
        TextField tfX2 = new TextField(Double.toString(r2.getX()));
        Label lblY2 = new Label("Y:");
        TextField tfY2 = new TextField(Double.toString(r2.getY()));
        Label lblWidth2 = new Label("Width:");
        TextField tfWidth2 = new TextField(Double.toString(r2.getWidth()));
        Label lblHeight2 = new Label("Height:");
        TextField tfHeight2 = new TextField(Double.toString(r2.getHeight()));

        // UI Tweaks
        tfX2.setPrefColumnCount(4);
        tfY2.setPrefColumnCount(4);
        tfWidth2.setPrefColumnCount(4);
        tfHeight2.setPrefColumnCount(4);

        // Border and grid panes to hold the prompt and label/text field pairs
        BorderPane paneForRectangle2Inputs = new BorderPane();
        paneForRectangle2Inputs.setPadding(new Insets(5));
        GridPane gpRectangle2 = new GridPane();
        gpRectangle2.setHgap(5);
        gpRectangle2.setVgap(5);

        // Populate the border and grid panes
        gpRectangle2.addColumn(0, lblX2, lblY2, lblWidth2, lblHeight2);
        gpRectangle2.addColumn(1, tfX2, tfY2, tfWidth2, tfHeight2);
        paneForRectangle2Inputs.setTop(lblPrompt2);
        paneForRectangle2Inputs.setCenter(gpRectangle2);

        // Set borders for each input pane
        paneForRectangle1Inputs.setBorder(new Border(new BorderStroke(
                Color.BLACK,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                new BorderWidths(1))));
        paneForRectangle2Inputs.setBorder(new Border(new BorderStroke(
                Color.BLACK,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                new BorderWidths(1))));

        /**
         * Pane for r1 and r2 input panes
         */
        GridPane paneForInputs = new GridPane();
        paneForInputs.setPadding(new Insets(5));
        paneForInputs.setHgap(5);
        paneForInputs.addRow(0, paneForRectangle1Inputs, paneForRectangle2Inputs);
        paneForInputs.setAlignment(Pos.CENTER);

        // Create the button to redraw circles
        Button btRedraw = new Button("Redraw Rectangles");

        // Create the pane for the 2 rectangles
        Pane paneForRectangles = new Pane();
        paneForRectangles.setMinSize(WIDTH, HEIGHT);
        paneForRectangles.getChildren().addAll(r1, r2);

        // Add the intersect label to the pane
        lblIntersect.setLayoutX(70);
        lblIntersect.setLayoutY(0);
        paneForRectangles.getChildren().add(lblIntersect);

        // Border pane for the pane for 2 circles, controls, and button
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5));
        pane.setTop(paneForRectangles);
        pane.setCenter(paneForInputs);
        pane.setBottom(btRedraw);
        BorderPane.setAlignment(btRedraw, Pos.CENTER);

        // Make rectangles r1 and r2 draggable
        r1.setOnMouseDragged(e -> {
            r1.setX(e.getX());
            tfX1.setText(Double.toString(r1.getX()));
            r1.setY(e.getY());
            tfY1.setText(Double.toString(r1.getY()));
            checkIntersect(); // Check if the rectangles intersect
        });
        
        r2.setOnMouseDragged(e -> {
            r2.setX(e.getX());
            tfX2.setText(Double.toString(r2.getX()));
            r2.setY(e.getY());
            tfY2.setText(Double.toString(r2.getY()));
            checkIntersect(); // Check if the recttangle intersect
        });

        // Register event listeners for the text fields of each rectangle
        // Rectangle 1
        tfX1.setOnAction(e -> {
            r1.setX(Double.parseDouble(tfX1.getText()));
            checkIntersect(); // Check if the recttangle intersect
        });
        
        tfY1.setOnAction(e -> {
            r1.setY(Double.parseDouble(tfY1.getText()));
            checkIntersect(); // Check if the recttangle intersect
        });
        
        tfWidth1.setOnAction(e -> {
            r1.setWidth(Double.parseDouble(tfWidth1.getText()));
            checkIntersect(); // Check if the recttangle intersect
        });
        
        tfHeight1.setOnAction(e -> {
            r1.setHeight(Double.parseDouble(tfHeight1.getText()));
            checkIntersect(); // Check if the recttangle intersect
        });

        // Rectangle 2
        tfX2.setOnAction(e -> {
            r2.setX(Double.parseDouble(tfX2.getText()));
            checkIntersect(); // Check if the recttangle intersect
        });
        
        tfY2.setOnAction(e -> {
            r2.setY(Double.parseDouble(tfY2.getText()));
            checkIntersect(); // Check if the recttangle intersect
        });
        
        tfWidth2.setOnAction(e -> {
            r2.setWidth(Double.parseDouble(tfWidth2.getText()));
            checkIntersect(); // Check if the recttangle intersect
        });
        
        tfHeight2.setOnAction(e -> {
            r2.setHeight(Double.parseDouble(tfHeight2.getText()));
            checkIntersect(); // Check if the recttangle intersect
        });

        // Redraw button
        btRedraw.setOnAction(e -> {
            // Rectangle 1 
            r1.setX(Double.parseDouble(tfX1.getText()));
            r1.setY(Double.parseDouble(tfY1.getText()));
            r1.setWidth(Double.parseDouble(tfWidth1.getText()));
            r1.setHeight(Double.parseDouble(tfHeight1.getText()));

            // Rectangle 2
            r2.setX(Double.parseDouble(tfX2.getText()));
            r2.setY(Double.parseDouble(tfY2.getText()));
            r2.setWidth(Double.parseDouble(tfWidth2.getText()));
            r2.setHeight(Double.parseDouble(tfHeight2.getText()));
            
            checkIntersect(); // Check if the recttangle intersect
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("GeometryTwoRectanglesIntersect"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // The stage is not resizable
    }
    
    public void checkIntersect() {
        // https://stackoverflow.com/questions/23302698/java-check-if-two-rectangles-overlap-at-any-point

        // Update the label
        if (r1.intersects(r2.getBoundsInLocal()) || r2.intersects(r1.getBoundsInLocal())) {
            lblIntersect.setText("Two rectangles intersect? Yes");
        } else {
            lblIntersect.setText("Two rectangles intersect? No");
        }
        
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
