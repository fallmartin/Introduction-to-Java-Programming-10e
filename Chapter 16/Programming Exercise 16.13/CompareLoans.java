
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * (Compare loans with various interest rates) Rewrite Programming Exercise 5.21
 * to create a GUI, as shown in Figure 16.41b. Your program should let the user
 * enter the loan amount and loan period in the number of years from text
 * fields, and it should display the monthly and total payments for each
 * interest rate starting from 5 percent to 8 percent, with increments of
 * one-eighth, in a text area.
 *
 * @author martinfall
 */
public class CompareLoans extends Application {

    private TextField tfLoanAmount = new TextField();
    private TextField tfNumberOfYears = new TextField();
    TextArea textArea = new TextArea();

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the labels for the text fields
        Label lblLoanAmount = new Label("Loan Amount");
        Label lblNumberOfYears = new Label("Number of Years");

        // Set desired properties for text field and text area
        tfLoanAmount.setPrefColumnCount(10);
        tfNumberOfYears.setPrefColumnCount(4);
        textArea.setEditable(false);

        // Create a new button
        Button btShowTable = new Button("Show Table");

        // Create an HBox and place the labels, text fields, and button in it
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(5));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(lblLoanAmount, tfLoanAmount,
                lblNumberOfYears, tfNumberOfYears,
                btShowTable);

        // Create a new border pane and place the hBox and text area in it
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5));
        pane.setTop(hBox);
        pane.setCenter(textArea);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("CompareLoans"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.setResizable(false); // The stage is not resizable

        // Event handler for the button
        btShowTable.setOnAction(e -> {
            double loanAmount = Double.parseDouble(tfLoanAmount.getText());
            int numberOfYears = Integer.parseInt(tfNumberOfYears.getText());

            textArea.setText(foo(loanAmount, numberOfYears));
        });
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private String foo(double loanAmount, int numberOfYears) {
        String s = "";

        // Print the table headers
        s += String.format("%-20s%-20s%-20s",
                "Interest Rate", "Monthly Payment", "Total Payment");
        s += "\n"; // new line

        for (double annualInterestRate = 5;
                annualInterestRate <= 8;
                annualInterestRate += 1.0 / 8) {

            // Obtain monthly interest rate
            double monthlyInterestRate = annualInterestRate / 1200;

            // Calculate monthly payment
            double monthlyPayment = (loanAmount * monthlyInterestRate)
                    / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));

            // Calculate total payment
            double totalPayment = monthlyPayment * numberOfYears * 12;

            // Update the string with interest rate, monthly payment, and total payment
            s += String.format("%5.3f%-15s %s%,-20.2f%s%,-20.2f%n",
                    annualInterestRate, "%", "$", monthlyPayment, "$", totalPayment);
        }

        return s;
    }
}
