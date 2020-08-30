
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * (Create a simple calculator) Write a program to perform addition,
 * subtraction, multiplication, and division, as shown in Figure 15.25a.
 *
 * @author martinfall
 */
public class SimpleCalculator extends Application {

    TextField tfNumber1 = new TextField();
    TextField tfNumber2 = new TextField();
    TextField tfResult = new TextField();

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the numbers pane
        GridPane numbersPane = new GridPane();
        numbersPane.setPadding(new Insets(10));
        numbersPane.setHgap(10);

        // Create the labels
        Label lblNumber1 = new Label("Number 1: ");
        Label lblNumber2 = new Label("Number 2: ");
        Label lblResult = new Label("Result: ");

        // Place the labels and text fields in the border pane
        numbersPane.add(lblNumber1, 0, 0);
        numbersPane.add(tfNumber1, 1, 0);
        numbersPane.add(lblNumber2, 2, 0);
        numbersPane.add(tfNumber2, 3, 0);
        numbersPane.add(lblResult, 4, 0);
        numbersPane.add(tfResult, 5, 0);

        // Set properties for UI
        tfNumber1.setPrefColumnCount(4);
        tfNumber2.setPrefColumnCount(4);
        tfResult.setPrefColumnCount(4);
        tfResult.setEditable(false);

        // Create the buttons for the application
        Button btAdd = new Button("Add");
        Button btSubtract = new Button("Subtract");
        Button btMultiply = new Button("Multiply");
        Button btDivide = new Button("Divide");

        // Add the buttons to the buttons pane
        FlowPane buttonsPane = new FlowPane();
        buttonsPane.setAlignment(Pos.CENTER);
        buttonsPane.setHgap(10);
        buttonsPane.getChildren().addAll(btAdd, btSubtract, btMultiply, btDivide);

        // Combine numbersPane and buttonsPane into a border pane
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5));
        pane.setCenter(numbersPane);
        pane.setBottom(buttonsPane);

        // Register the event handlers with the buttons
        btAdd.setOnAction(e -> add());
        btSubtract.setOnAction(e -> subtract());
        btMultiply.setOnAction(e -> multiply());
        btDivide.setOnAction(e -> divide());

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_15_4"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    private void add() {
        Double number1 = Double.parseDouble(tfNumber1.getText());
        Double number2 = Double.parseDouble(tfNumber2.getText());
        Double result = number1 + number2;
        tfResult.setText(result.toString());
    }

    private void subtract() {
        Double number1 = Double.parseDouble(tfNumber1.getText());
        Double number2 = Double.parseDouble(tfNumber2.getText());
        Double result = number1 - number2;
        tfResult.setText(result.toString());
    }

    private void multiply() {
        Double number1 = Double.parseDouble(tfNumber1.getText());
        Double number2 = Double.parseDouble(tfNumber2.getText());
        Double result = number1 * number2;
        tfResult.setText(result.toString());
    }

    private void divide() {
        Double number1 = Double.parseDouble(tfNumber1.getText());
        Double number2 = Double.parseDouble(tfNumber2.getText());
        Double result = number1 / number2;
        tfResult.setText(result.toString());
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
