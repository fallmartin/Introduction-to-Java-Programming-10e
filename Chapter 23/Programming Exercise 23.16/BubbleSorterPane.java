package bubblesort;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * A pane containing the histogram and the control buttons.
 *
 * @author martinfall
 */
public class BubbleSorterPane extends BorderPane {

    // Constant data fields
    private static final int MAX_ARRAY_SIZE = 20;

    // Create a selection sorter object
    BubbleSorter bubbleSorter;

    // Create a new histogram object
    Histogram paneForHistogram;

    /**
     * Constructs a selection sorter pane.
     */
    public BubbleSorterPane() {

        // Create a selection sort object
        bubbleSorter = new BubbleSorter();

        // Initialize the histogram pane data field
        paneForHistogram = new Histogram(0, bubbleSorter.getArray());

        // Create the control buttons
        Button btStep = new Button("Step");
        Button btReset = new Button("Reset");

        // Create a HBox for the buttons
        HBox paneForButtons = new HBox();
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setPadding(new Insets(10));
        paneForButtons.setSpacing(10);
        paneForButtons.getChildren().addAll(btStep, btReset);

        // 
        setCenter(paneForHistogram);
        setBottom(paneForButtons);

        /**
         * Event handler for the Step button
         */
        btStep.setOnAction(e -> {
            int index = bubbleSorter.getIndex();

            if (index >= MAX_ARRAY_SIZE) {
                btStep.setDisable(true);
            } else {
                bubbleSorter.iterate(index);
            }

            // Display the array to console
            // selectionSorter.printArrayToConsole();
            paint(); // Repaint the pane

            bubbleSorter.setIndex(index + 1);
        });

        /**
         * Event handler for the Reset button
         */
        btReset.setOnAction(e -> {
            bubbleSorter = new BubbleSorter();
            bubbleSorter.setIndex(0);

            // Display the array to console
            // selectionSorter.printArrayToConsole();
            paint(); // Repaint the pane

            btStep.setDisable(false);
        });
    }

    /**
     * Convenience method that repaints the pane for histogram at each step or
     * at reset.
     */
    private void paint() {
        // Reset the pane for histogram in the selection sorter pane
        paneForHistogram = new Histogram(bubbleSorter.getIndex(),
                bubbleSorter.getArray());
        setCenter(paneForHistogram);
    }
}
