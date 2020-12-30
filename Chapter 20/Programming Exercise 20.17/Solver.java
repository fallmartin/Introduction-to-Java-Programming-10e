
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * (Game: the 24-point card game) This exercise is a variation of the 24-point
 * card game described in Programming Exercise 20.13. Write a program to check
 * whether there is a 24-point solution for the four specified numbers. The
 * program lets the user enter four values, each between 1 and 13, as shown in
 * Figure 20.21. The user can then click the Solve button to display the
 * solution or display “No solution” if none exist.
 *
 * @author martinfall
 */
public class Solver extends Application {

    private TextField tfValue1 = new TextField();
    private TextField tfValue2 = new TextField();
    private TextField tfValue3 = new TextField();
    private TextField tfValue4 = new TextField();

    protected BorderPane getPane() {
        // Create a custom font for the text field
        final Font font = Font.font(
                "Arial",
                FontWeight.BOLD,
                FontPosture.REGULAR,
                25);

        // Textfield preferred width and height
        final double width = 75;
        final double height = 25;

        // Create the pane for user input values
        // Four textfields for each user input value
        tfValue1.setPrefSize(width, height);
        tfValue1.setFont(font);
        tfValue1.setAlignment(Pos.CENTER);

        tfValue2.setPrefSize(width, height);
        tfValue2.setFont(font);
        tfValue2.setAlignment(Pos.CENTER);

        tfValue3.setPrefSize(width, height);
        tfValue3.setFont(font);
        tfValue3.setAlignment(Pos.CENTER);

        tfValue4.setPrefSize(width, height);
        tfValue4.setFont(font);
        tfValue4.setAlignment(Pos.CENTER);

        // Add the textfields to a grid pane
        GridPane paneForValues = new GridPane();

        paneForValues.setPadding(new Insets(10));
        paneForValues.setHgap(10);
        paneForValues.addRow(0, tfValue1, tfValue2, tfValue3, tfValue4);

        // Create the pane for a Solve button and  textfield to display solution
        Button btSolve = new Button("Solve");
        TextField tfSolution = new TextField();
        tfSolution.setEditable(false);

        HBox paneForSolution = new HBox(10);
        paneForSolution.setAlignment(Pos.CENTER);
        paneForSolution.setPadding(new Insets(10, 0, 0, 0));
        paneForSolution.getChildren().addAll(tfSolution, btSolve);

        // Create a new border pane
        BorderPane pane = new BorderPane();
        pane.setTop(paneForSolution);
        pane.setCenter(paneForValues);

        // Event handler for the Solve button
        btSolve.setOnAction(e -> {
            // Parse the user input into an Integer array list
            Integer value1 = Integer.parseInt(tfValue1.getText());
            Integer value2 = Integer.parseInt(tfValue2.getText());
            Integer value3 = Integer.parseInt(tfValue3.getText());
            Integer value4 = Integer.parseInt(tfValue4.getText());

            ArrayList<Integer> list = new ArrayList<>();
            list.add(value1);
            list.add(value2);
            list.add(value3);
            list.add(value4);

            // Create a new TwentyFour object
            TwentyFour twentyFour = new TwentyFour(list);
            twentyFour.solve();
            tfSolution.setText(twentyFour.getRandomSolution());
        });

        return pane;
    }

    @Override // Override the start method of the Application class
    public void start(Stage stage) throws Exception {
        // Create a new Scene and place it in the stage
        Scene scene = new Scene(getPane());
        stage.setScene(scene); // Place the scene in the stage
        stage.setTitle("24 Solver"); // Set the stage title
        stage.show(); // Display the stage
        stage.setResizable(false); // Make the stage non-resizable 
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
