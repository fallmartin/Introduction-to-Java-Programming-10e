package sudoku;

import java.util.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * (Game: Sudoku) The complete solution for the Sudoku problem is given in
 * Supplement VI.C. Write a program that lets the user enter the input from the
 * text fields, as shown in Figure 22.15a. Clicking the Solve button displays
 * the result, as shown in Figure 22.15b–c.
 *
 * @author martinfall
 */
public class SudokuGame extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {

        // Status label
        Label label = new Label("Label");
        label.setFont(Font.font(15));
        label.setAlignment(Pos.CENTER);
        label.setPadding(new Insets(10));

        // Sudoku grid pane
        SudokuPane sudoku = new SudokuPane();

        // Buttons for Solve and Clear and the HBox to hold them
        Button btSolve = new Button("Solve");
        btSolve.setFont(Font.font(15));
        Button btClear = new Button("Clear");
        btClear.setFont(Font.font(15));
        HBox paneForButtons = new HBox(5);
        paneForButtons.getChildren().addAll(btSolve, btClear);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setPadding(new Insets(10));

        // Border pane to hold the label, Sudoku board, and buttons pane
        BorderPane pane = new BorderPane();
        pane.setTop(label);
        pane.setCenter(sudoku);
        pane.setBottom(paneForButtons);
        BorderPane.setAlignment(label, Pos.CENTER);
        BorderPane.setAlignment(paneForButtons, Pos.CENTER);

        // Create a new scene and place it in the stage
        Scene scene = new Scene(pane); 
        stage.setTitle("Sudoku"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
        stage.setResizable(false); // Make the stage non-resizable

        // Event handler for the Solve button
        btSolve.setOnAction(e -> {
            Integer[][] grid = sudoku.readAPuzzle();

            if (!Sudoku.isValid(grid)) {
                label.setText("Invalid Input");
            } else if (Sudoku.search(grid)) {
                label.setText("Solutions Found!");
                sudoku.paint(grid);
            } else {
                label.setText("No Solution Found");
            }
        });

        // Event handler for the Clear button
        btClear.setOnAction(e -> {
            sudoku.clear();
        });
    }

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
