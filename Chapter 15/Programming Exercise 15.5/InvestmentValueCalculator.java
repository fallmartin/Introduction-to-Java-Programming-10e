
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * (Create an investment-value calculator) Write a program that calculates the
 * future value of an investment at a given interest rate for a specified number
 * of years. The formula for the calculation is:
 *
 * futureValue = investmentAmount * (1 + monthlyInterestRate) ^ (years*12)
 *
 * Use text fields for the investment amount, number of years, and annual
 * interest rate. Display the future amount in a text field when the user clicks
 * the Calculate button, as shown in Figure 15.25b.
 *
 * @author martinfall
 */
public class InvestmentValueCalculator extends Application {

    // Class variable declarations
    TextField tfInvestmentAmount = new TextField();
    TextField tfYears = new TextField();
    TextField tfAnnualInterestRate = new TextField();
    TextField tfFutureValue = new TextField();

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(5);
        pane.setVgap(5);

        // Create labels
        Label lblInvestmentAmount = new Label("Investment Amount:");
        Label lblYears = new Label("Number of Years:");
        Label lblAnnualInterestRate = new Label("Annual Interest Rate:");
        Label lblFutureValue = new Label("Future Value:");

        // Create the Calculate button
        Button btCalculate = new Button("Calculate");

        // Add the controls to the grid
        pane.add(lblInvestmentAmount, 0, 0);
        pane.add(tfInvestmentAmount, 1, 0);
        pane.add(lblYears, 0, 1);
        pane.add(tfYears, 1, 1);
        pane.add(lblAnnualInterestRate, 0, 2);
        pane.add(tfAnnualInterestRate, 1, 2);
        pane.add(lblFutureValue, 0, 3);
        pane.add(tfFutureValue, 1, 3);
        pane.add(btCalculate, 1, 4);

        // UI tweaks
        GridPane.setHalignment(btCalculate, HPos.RIGHT);
        tfInvestmentAmount.setAlignment(Pos.CENTER_RIGHT);
        tfYears.setAlignment(Pos.CENTER_RIGHT);
        tfAnnualInterestRate.setAlignment(Pos.CENTER_RIGHT);
        tfFutureValue.setAlignment(Pos.CENTER_RIGHT);
        tfFutureValue.setEditable(false);

        // Register handler with btCalculate
        btCalculate.setOnAction(e -> calculateFutureValue());

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_15_5"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    private void calculateFutureValue() {
        double investmentAmount = Double.parseDouble(tfInvestmentAmount.getText());
        double annualInterestRate = Double.parseDouble(tfAnnualInterestRate.getText());
        int years = Integer.parseInt(tfYears.getText());
        double monthlyInterestRate = annualInterestRate / 1200;
        double futureValue = investmentAmount * Math.pow((1 + monthlyInterestRate), (years * 12));

        tfFutureValue.setText(String.format("$%,.2f", futureValue));

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
