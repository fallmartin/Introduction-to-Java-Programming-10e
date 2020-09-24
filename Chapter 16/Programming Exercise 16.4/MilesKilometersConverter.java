
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * (Create a miles/kilometers converter) Write a program that converts miles and
 * kilometers, as shown in Figure 16.37b. If you enter a value in the Mile text
 * field and press the Enter key, the corresponding kilometer measurement is
 * displayed in the Kilometer text field. Likewise, if you enter a value in the
 * Kilometer text field and press the Enter key, the corresponding miles is
 * displayed in the Mile text field.
 *
 * @author martinfall
 */
public class MilesKilometersConverter extends Application {

    private TextField tfMiles = new TextField();
    private TextField tfKilometers = new TextField();
    private static final double MILES_TO_KILOMETERS = 1.609344;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the labels
        Label lblMiles = new Label("Miles");
        Label lblKilometers = new Label("Kilometers");

        // UI tweaks for the text fields
        tfMiles.setAlignment(Pos.CENTER_RIGHT);
        tfKilometers.setAlignment(Pos.CENTER_RIGHT);

        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // Add the labels and text fields
        pane.add(lblMiles, 0, 0);
        pane.add(tfMiles, 1, 0);
        pane.add(lblKilometers, 0, 1);
        pane.add(tfKilometers, 1, 1);

        // Register event handlers with the text fields
        tfMiles.setOnAction(e -> {
            double miles = Double.parseDouble(tfMiles.getText());
            tfKilometers.setText(Double.toString(convertMilesToKilometers(miles)));
        });

        tfKilometers.setOnAction(e -> {
            double kilometers = Double.parseDouble(tfKilometers.getText());
            tfMiles.setText(Double.toString(convertKilometersToMiles(kilometers)));
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("MilesKilometersConverter"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizable
    }

    public static double convertMilesToKilometers(double miles) {
        return miles * MILES_TO_KILOMETERS;
    }

    public static double convertKilometersToMiles(double kilometers) {
        return kilometers / MILES_TO_KILOMETERS;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
