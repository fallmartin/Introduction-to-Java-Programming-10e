
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * (Color and font) Write a program that displays five texts vertically, as
 * shown in Figure 14.44a. Set a random color and opacity for each text and set
 * the font of each text to Times Roman, bold, italic, and 22 pixels.
 *
 * @author martinfall
 */
public class ColorAndFont extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create a new grid pane
        GridPane pane = new GridPane();
        // Pane padding, alignment, and horizontal gap
        pane.setPadding(new Insets(20, 5, 20, 5));
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        
        // Create a new Font object
        Font font = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 22);
        
        // Create 5 Text objects with random fills and add them to the pane
        for (int i = 0; i < 5; i++) {
            Text text = new Text("Java");
            text.setFont(font);
            text.setFill(Color.color(Math.random(), Math.random(), Math.random(), Math.random()));
            text.setRotate(90);
            pane.add(text, i, 0);
        }
        
        // Create a new scene, set the primaryStage title and add scene to the primaryStage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_14_4");
        primaryStage.setScene(scene);
        primaryStage.show(); // Display the primaryStage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
