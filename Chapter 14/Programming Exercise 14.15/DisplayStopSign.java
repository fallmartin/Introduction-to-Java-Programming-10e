
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * (Display a STOP sign) Write a program that displays a STOP sign, as shown
 * in Figure 14.47b. The octagon is in red and the sign is in white. (Hint:
 * Place an octagon and a text in a stack pane.)
 *
 * @author martinfall
 */
public class DisplayStopSign extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        // Create a stack pane
        StackPane pane = new StackPane();
        pane.setPadding(new Insets(10));
        
        // Create the octagon
        Polygon polygon = new Polygon();
        polygon.setFill(Color.RED);
        ObservableList<Double> list = polygon.getPoints();
        
        double radius = 100;
        double centerX = 100;
        
        for (int i = 0; i < 8; i++) {
            list.add(radius * Math.cos(2 * i * Math.PI / 8));
            list.add(radius * Math.sin(2 * i * Math.PI / 8));
        }
        
        polygon.setRotate(22.5);
        
        // Create teh STOP lettering
        
        Font font = Font.font("Arial", FontWeight.BOLD, 60);
        Text stop = new Text("STOP");
        stop.setFont(font);
        stop.setFill(Color.WHITE);
        
        pane.getChildren().addAll(polygon, stop);
        
        Scene scene = new Scene(pane);
        stage.setTitle("Exercise_14_15");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
