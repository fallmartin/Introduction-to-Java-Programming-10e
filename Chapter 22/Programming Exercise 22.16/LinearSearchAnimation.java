package linearsearchanimation;

import java.util.Arrays;
import java.util.Collections;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * (Linear search animation) Write a program that animates the linear search
 * algorithm. Create an array that consists of 20 distinct numbers from 1 to 20
 * in a random order. The array elements are displayed in a histogram, as shown
 * in Figure 22.12. You need to enter a search key in the text field. Clicking
 * the Step button causes the program to perform one comparison in the algorithm
 * and repaints the histogram with a bar indicating the search position. This
 * button also freezes the text field to prevent its value from being changed.
 * When the algorithm is finished, display the status in the label at the top of
 * the border pane to inform the user. Clicking the Reset button creates a new
 * random array for a new start. This button also makes the text field editable.
 *
 * @author martinfall
 */
public class LinearSearchAnimation extends Application {

    // Data field constants for width and height of the scene
    public static final double BAR_WIDTH = 20;
    public static final int NUMBER_OF_INTEGERS = 20;
    public static final Color CURR = Color.TOMATO;

    // Create an array of Integer object
    public static Integer[] numbers;

    // Create an array of Label objects
    public static Label[] labels;

    // Create an array of rectangles to represent the integers from 1 to 20
    public static Rectangle[] histogram;

    // Create a grid pane to hold the rectangle representations of numbers
    public static GridPane paneForHistogram;

    // Create a border pane to house the result, input field, and buttons
    BorderPane pane = new BorderPane();

    // Create an index variable to hold the curr search position
    int searchIndex = -1;

    // Search results vars
    int foundIndex = -1;

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {

        // Create a label to display the status at the top of the border pane
        Label lblStatus = new Label();
        lblStatus.setPadding(new Insets(BAR_WIDTH / 4));

        // Initialize the histogram with randomly generated values
        paneForHistogram = initHistogram();

        // Create the label, text field, and buttons for the bottom HBox
        Label lblInput = new Label("Key (in double)");
        TextField tfInput = new TextField();
        Button btStep = new Button("Step");
        Button btReset = new Button("Reset");

        // Step button configuration
        btStep.disableProperty().bind(tfInput.textProperty().isEmpty());

        // Create a HBox and add the nodes above to it
        HBox paneForInput = new HBox();
        paneForInput.getChildren().addAll(lblInput, tfInput, btStep, btReset);
        paneForInput.setAlignment(Pos.CENTER);
        paneForInput.setSpacing(BAR_WIDTH / 4);
        paneForInput.setPadding(new Insets(BAR_WIDTH / 2, 0, 0, 0));

        // Set the border pane's padding and add the nodes
        pane.setPadding(new Insets(0, BAR_WIDTH / 2, BAR_WIDTH / 2, BAR_WIDTH / 2));
        pane.setTop(lblStatus);
        pane.setCenter(paneForHistogram);
        pane.setBottom(paneForInput);

        // Some alignment settings for the pane
        BorderPane.setAlignment(lblStatus, Pos.CENTER);
        BorderPane.setAlignment(paneForInput, Pos.CENTER);

        // Create a new Scene and add it to the stage
        Scene scene = new Scene(pane);
        stage.setTitle("Linear Search Animation"); // Set the stage title
        stage.setScene(scene); // Specify the scene to be used on this stage
        stage.show(); // Set the visibility of stage to true to display window
        stage.setResizable(true); // The stage is not resizable by the user

        // THE LOGIC
        // Attach an event listener to the Step button
        btStep.setOnAction(e -> {
            // Increment the search index at each click
            if (searchIndex < NUMBER_OF_INTEGERS - 1) {
                searchIndex++;

                // Prevent input from being modified after initial entry
                tfInput.setDisable(true);

                // Assign the value of the text property to a double variable key
                double key = Double.valueOf(tfInput.getText());

                // Variables for the number and bar at current value of searchIndex
                int currNumber = numbers[searchIndex];

                if (key == currNumber) {
                    foundIndex = searchIndex;
                }

                Rectangle currBar = histogram[searchIndex];

                for (Rectangle bar : histogram) {
                    bar.setFill(Color.TRANSPARENT);
                }

                currBar.setFill(CURR);
            } else {
                // If found 
                if (foundIndex == -1) {
                    lblStatus.setText("The key is not in the array");
                } else { // If not found
                    lblStatus.setText("The key is found in the array at index " + foundIndex);
                }
            }
        });

        // Attach an event listener to the Step button
        btReset.setOnAction(e -> {
            // Create a new histogram and add it to the center
            paneForHistogram = initHistogram();
            pane.setCenter(paneForHistogram);

            searchIndex = -1; // Reset the search index to 0

            // Allow initial entry into text field 
            tfInput.setDisable(false);

            // Reset the found index
            foundIndex = -1;

            // Reset the label
            lblStatus.setText("");
        });
    }

    /**
     * Build the histogram pane for the center of the border pane.
     *
     * @return
     */
    public static GridPane initHistogram() {
        // Create a grid pane for the histogram
        GridPane paneForHistogram = new GridPane();

        // Initializers moved to init which serves as constructor of histogram
        numbers = new Integer[NUMBER_OF_INTEGERS];
        labels = new Label[NUMBER_OF_INTEGERS];
        histogram = new Rectangle[NUMBER_OF_INTEGERS];

        /**
         * Create an array that consists of 20 distinct numbers from 1 to 20 in
         * a random order.
         */
        numbers = getNumbers();

        /**
         * Create an array that consists of 20 labels matching the contents of
         * numbers.
         */
        labels = getLabels();

        /**
         * Populate the rectangle array.
         */
        for (int i = 0; i < numbers.length; i++) {
            // Create a rectange object with binding property values for w, h
            Rectangle bar = new Rectangle();

            // Set the fill and stroke color properties
            bar.setFill(Color.TRANSPARENT);
            bar.setStroke(Color.BLACK);

            // Bind the width and height to the width and height of pane for histogram
            bar.setWidth(BAR_WIDTH);
            bar.setHeight((BAR_WIDTH / 2) * numbers[i]);

            // Set the value of the property graphic to the curr rectangle
            labels[i].setGraphic(bar);
            labels[i].setContentDisplay(ContentDisplay.BOTTOM);

            // Add the rectangle to the histogram array
            histogram[i] = bar;
        }

        /**
         * Populate the grid pane with the contents of the histogram array.
         */
        for (int i = 0; i < numbers.length; i++) {
            // Add the rectangle to the pane for histogram
            paneForHistogram.addColumn(i, labels[i]);
            paneForHistogram.add(histogram[i], i, 0);

            // Set the vertical alignment of the rectangle and label to bottom
            GridPane.setValignment(labels[i], VPos.BOTTOM);
            GridPane.setValignment(histogram[i], VPos.BOTTOM);
        }

        // Set a border for the pane for histogram
        BorderStroke borderStroke = new BorderStroke(
                Color.GRAY,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT);
        Border border = new Border(borderStroke);
        paneForHistogram.setBorder(border);
        paneForHistogram.setPadding(new Insets(BAR_WIDTH));

        // Set the value of the property hgap to 1
        paneForHistogram.setHgap(1);

        return paneForHistogram;
    }

    /**
     * Returns an array that consists of 20 distinct numbers from 1 to 20 in a
     * random order.
     *
     * @return
     */
    public static Integer[] getNumbers() {
        // Create an array that consists of 20 distinct numbers from 1 to 20
        Integer[] array = new Integer[NUMBER_OF_INTEGERS];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(array)); // Shuffle the array

        // Return the shuffled Integer array to the caller method
        return array;
    }

    /**
     * Returns an array of labels that matches the contents of the numbers
     * array.
     *
     * @return
     */
    public static Label[] getLabels() {
        Label[] array = new Label[NUMBER_OF_INTEGERS];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Label(numbers[i] + "");
        }
        return array;
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
