
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * (Convert numbers) Write a program that converts between decimal, hex, and
 * binary numbers, as shown in Figure 16.37c. When you enter a decimal value in
 * the decimal-value text field and press the Enter key, its corresponding hex
 * and binary numbers are displayed in the other two text fields. Likewise, you
 * can enter values in the other fields and convert them accordingly. (Hint: Use
 * the Integer.parseInt(s, radix) method to parse a string to a decimal and use
 * Integer.toHexString(decimal) and Integer.toBinaryString(decimal) to obtain a
 * hex number or a binary number from a decimal.)
 *
 * @author martinfall
 */
public class ConvertNumbers extends Application {

    // Data fields
    private TextField tfDecimal = new TextField();
    private TextField tfHex = new TextField();
    private TextField tfBinary = new TextField();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create the labels for each text field
        Label lblDecimal = new Label("Decimal");
        Label lblHex = new Label("Hex");
        Label lblBinary = new Label("Binary");

        // UI tweaks for the text fields
        tfDecimal.setAlignment(Pos.CENTER_RIGHT);
        tfHex.setAlignment(Pos.CENTER_RIGHT);
        tfBinary.setAlignment(Pos.CENTER_RIGHT);

        // Create a grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setVgap(10);
        pane.setHgap(10);

        // Add the labels and text fields to the pane
        pane.add(lblDecimal, 0, 0);
        pane.add(tfDecimal, 1, 0);
        pane.add(lblHex, 0, 1);
        pane.add(tfHex, 1, 1);
        pane.add(lblBinary, 0, 2);
        pane.add(tfBinary, 1, 2);

        // Register the event handlers with each text field
        tfDecimal.setOnAction(e -> {
            int decimal = Integer.parseInt(tfDecimal.getText(), 10);
            tfHex.setText(Integer.toHexString(decimal));
            tfBinary.setText(Integer.toBinaryString(decimal));
        });
        tfHex.setOnAction(e -> {
            int decimal = Integer.parseInt(tfHex.getText(), 16);
            tfDecimal.setText(Integer.toString(decimal));
            tfBinary.setText(Integer.toBinaryString(decimal));

        });
        tfBinary.setOnAction(e -> {
            int decimal = Integer.parseInt(tfBinary.getText(), 2);
            tfDecimal.setText(Integer.toString(decimal));
            tfHex.setText(Integer.toHexString(decimal));
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ConvertNumbers"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // Make the stage non-resizable
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
