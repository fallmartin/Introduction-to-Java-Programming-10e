
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
 * (Plot the sine and cosine functions) Write a program that plots the sine
 * function in red and cosine in blue, as shown in Figure 14.48c.
 *
 * Hint: The Unicode for p is \u03c0. To display -2pi, use Text(x, y,
 * "-2\u03c0"). For a trigonometric function like sin(x), x is in radians. Use
 * the
 * following loop to add the points to a polyline:
 *
 * Polyline polyline = new Polyline();
 *
 * ObservableList<Double> list = sinFunction.getPoints();
 * double scaleFactor = 50;
 * for (int x = -170; x <= 170; x++) {
 * list.add(x + 200.0);
 * list.add(100 – 50 * Math.sin((x / 100.0) * 2 * Math.PI));
 * }
 *
 * @author martinfall
 */
public class PlotSinCos extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        // Create a pane
        Pane pane = new Pane();
        pane.setPadding(new Insets(10));
        pane.setMinWidth(400);
        pane.setMinHeight(200);

        // Create the x-axis
        Line xAxis = new Line(40, 100, 360, 100);
        xAxis.setStroke(Color.BLACK);
        xAxis.setStrokeWidth(2);

        // Create the x-axis arrowhead  and label
        Polyline xArrow = new Polyline(350, 97, 360, 100, 350, 103);
        xArrow.setStroke(Color.BLACK);
        xArrow.setStrokeWidth(2);
        Text xLabel = new Text(365, 103, "x");

        // Create the y-axis
        Line yAxis = new Line(200, 10, 200, 190);
        yAxis.setStroke(Color.BLACK);
        yAxis.setStrokeWidth(2);

        // Create the y-axis arrowhead and label
        Polyline yArrow = new Polyline(197, 20, 200, 10, 203, 20);
        yArrow.setStroke(Color.BLACK);
        yArrow.setStrokeWidth(2);
        Text yLabel = new Text(210, 15, "y");

        // Create the sine function and change its color to red
        Polyline sine = new Polyline();
        ObservableList<Double> listSine = sine.getPoints();
        double scaleFactorSine = 50;
        for (int x = -160; x <= 160; x++) {
            listSine.add(x + 200.0);
            listSine.add(100 - 50 * Math.sin((x / 100.0) * 2 * Math.PI));
        }
        sine.setStroke(Color.RED);

        // Create the cosine function and change its color to blue
        Polyline cosine = new Polyline();
        ObservableList<Double> listCosine = cosine.getPoints();
        double scaleFactorCosine = 50;
        for (int x = -160; x <= 160; x++) {
            listCosine.add(x + 200.0);
            listCosine.add(100 - 50 * Math.cos((x / 100.0) * 2 * Math.PI));

        }
        cosine.setStroke(Color.BLUE);

        // number of pi on the gui can be calculated in the previous loop
        int number = -3; // manually control the pi label

        // Label the x-axis with pi
        for (int x = -160; x <= 160; x++) {
            double y = 100 - 50 * Math.sin((x / 100.0) * 2 * Math.PI);

            if (xAxis.contains(x + 200, y)) {
                pane.getChildren().add(new Text(x + 200, y + 10,
                        (number == 0 ? "0" : number + "\u03c0")));
                number++;
            }

        }

        // All nodes to the pane
        pane.getChildren().addAll(xAxis, yAxis, xArrow, yArrow, xLabel, yLabel,
                sine, cosine);

        // Create a new scene
        Scene scene = new Scene(pane);
        stage.setTitle("Exercise_14_18"); // Set the stage title
        stage.setScene(scene); // Set the scene on the stage
        stage.setResizable(false); // Set resizeable to false
        stage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
