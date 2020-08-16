
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * (Plot the square function) Write a program that draws a diagram for the
 * function f(x) = x2 (see Figure 14.48b).
 *
 * @author martinfall
 */
public class PlotTheSquareFunction extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create a new pane
        Pane pane = new Pane();
        pane.setPadding(new Insets(10));

        // Create the x-axis
        Line xAxis = new Line(20, 550, 780, 550);
        xAxis.setStrokeWidth(2);
        xAxis.setStroke(Color.BLACK);

        // Create the x-axis arrowhead
        Polyline xArrow = new Polyline(770, 540, 780, 550, 770, 560);
        xArrow.setStrokeWidth(2);
        xArrow.setStroke(Color.BLACK);

        // Create the x-axis label
        Text xLabel = new Text(770, 520, "X");

        // Create the y-axis
        Line yAxis = new Line(400, 20, 400, 600);
        yAxis.setStrokeWidth(2);
        yAxis.setStroke(Color.BLACK);

        // Create the y-axis arrowhead
        Polyline yArrow = new Polyline(390, 30, 400, 20, 410, 30);
        yArrow.setStrokeWidth(2);
        yArrow.setStroke(Color.BLACK);

        // Create the y-axis label
        Text yLabel = new Text(370, 30, "Y");

        // Create the graphical representation of the function 
        Polyline polyline = new Polyline();
        
        ObservableList<Double> list = polyline.getPoints();
        double scaleFactor = 0.0125;
        for (int x = -200; x <= 200; x++) {
            list.add(x + 400.0);
            list.add(scaleFactor * x * x);
        }
        
        polyline.setRotate(180);
        polyline.relocate(200, 49);
        
        // Create a label for the fuction f(x) = x^2
        Text function = new Text(200, 30, "f(x) = x^2");

        // Add all the nodes to the pane
        pane.getChildren().addAll(xAxis, yAxis, xArrow, yArrow, polyline, 
                xLabel, yLabel, function);

        // Create a new scene
        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("Exercise_14_18"); // Set the stage title
        primaryStage.setScene(scene); // Set the scene on the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
