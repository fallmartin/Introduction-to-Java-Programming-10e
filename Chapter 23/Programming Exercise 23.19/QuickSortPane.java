package quicksort;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.text.TextAlignment;

/**
 * (Quick sort partition animation) Write a program that animates the partition
 * for a quick sort. The program creates a list that consists of 20 random
 * numbers from 1 to 999. The list is displayed, as shown in Figure 23.22b.
 * Clicking the Step button causes the program to move low to the right or high
 * to the left, or swap the elements at low and high. Clicking the Reset button
 * creates a new list of random numbers for a new start. When the algorithm is
 * finished, clicking the Step button displays a message to inform the user.
 *
 * @author martinfall
 */
public class QuickSortPane extends BorderPane {

    // Data fields
    private final int WIDTH = 50;
    private final int HEIGHT = 20;

    private static final Border border = new Border(new BorderStroke(
            Color.BLACK,
            BorderStrokeStyle.SOLID,
            CornerRadii.EMPTY,
            new BorderWidths(1)));

    private final static Color LOW_INDEX_COLOR = Color.GREEN;
    private final static Color HIGH_INDEX_COLOR = Color.RED;
    private final static Color PIVOT_INDEX_COLOR = Color.BLUE;

    QuickSort quickSort;

    /**
     * Default constructor of the QuickSortPane class.
     */
    public QuickSortPane() {
        // Initialize the quick sort data field
        quickSort = new QuickSort();

        // Create the pane for buttons
        HBox paneForButtons = getPaneForButtons();

        GridPane paneForList = getPaneForList();

        // Add the pane for buttons to the quick sort pane
        setCenter(paneForList);
        setBottom(paneForButtons);
    }

    /**
     *
     * @return
     */
    private GridPane getPaneForList() {

        // Local variables for list, low, high, and pivot
        int[] list = quickSort.getList();
        int low = quickSort.getLow();
        int high = quickSort.getHigh();
        int pivotIndex = quickSort.getPivotIndex();

        // Column and row constraints
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPrefWidth(WIDTH);
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPrefHeight(HEIGHT);

        // Create the panes for the low, high, and pivot index arrows and labels
        GridPane paneForLow = getPaneForArrow("low");
        GridPane paneForHigh = getPaneForArrow("high");
        GridPane paneForPivot = getPaneForArrow("pivot");

        // Adjust the pane for low and high indices
        paneForLow.setTranslateY(paneForLow.getBoundsInLocal().getHeight() - 3);
        paneForHigh.setTranslateY(paneForLow.getBoundsInParent().getHeight() - 3);

        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPrefSize(WIDTH * 20, HEIGHT * 13);
        pane.setPadding(new Insets(0, WIDTH, 0, WIDTH));
        pane.setAlignment(Pos.CENTER);

        // Add the contents of list to the grid pane
        for (int i = 0; i < list.length; i++) {
            // Create a stack pane and set the border and preferred size properties
            StackPane cell = new StackPane();
            cell.setBorder(border);
            cell.setPrefSize(WIDTH, HEIGHT);
            cell.setAlignment(Pos.CENTER);

            // Create a label with the value at i, set its alignment
            Label element = new Label(Integer.toString(list[i]));
            element.setTextAlignment(TextAlignment.CENTER);
            cell.getChildren().add(element);

            // Set the row and column constraints
            pane.getColumnConstraints().add(columnConstraints);
            pane.getRowConstraints().add(rowConstraints);
            pane.add(cell, i, 7); // Add the cell
        }

        // Add the arrows to the pane
        pane.add(paneForLow, low, 2);
        pane.add(paneForHigh, high, 1);
        pane.add(paneForPivot, pivotIndex, 12);

        // pane.setGridLinesVisible(true);
        // Return pane to the caller method
        return pane;
    }

    /**
     * Returns a pane with an arrow and a label.
     *
     * @param label
     * @return
     */
    private GridPane getPaneForArrow(String label) {

        // Determine the length of the arrow shaft
        int multiplier = 2; // low arrow shaft height

        if (label.equals("high")) {
            multiplier = 4; // high arrow shaft height
        }

        if (label.equals("pivot")) {
            multiplier = 6; // pivot arrow shaft height
        }

        // Create the label for the low index
        Label lblArrow = new Label(label);

        // Create the pane for arrow and the the alignement property
        StackPane paneForArrow = new StackPane();
        paneForArrow.setAlignment(Pos.BOTTOM_CENTER);
        paneForArrow.setPrefSize(WIDTH, HEIGHT * 6);

        // Create the arrow shaft and point
        Polyline shaft = new Polyline(0, 0, 0, HEIGHT * multiplier);
        Polyline point = new Polyline(0, 0, WIDTH / 4, HEIGHT / 2, WIDTH / 2, 0);

        // If the pane for arrow is for pivot, new arrow head and alignemnt
        if (label.equals("pivot")) {
            point = new Polyline(0, HEIGHT / 2, WIDTH / 4, 0, WIDTH / 2, HEIGHT / 2);
            paneForArrow.setAlignment(Pos.TOP_CENTER);
        }

        // Set the stroke width properties of shaft and point
        point.setStrokeWidth(2);
        shaft.setStrokeWidth(2);

        // Add the shaft and point to the pane for arrow
        paneForArrow.getChildren().addAll(shaft, point);

        // Create the pane for the arrow and label
        GridPane paneForIndex = new GridPane();

        // Set the alignment and preferred size properties of the pane for index
        paneForIndex.setAlignment(Pos.CENTER);
        paneForIndex.setPrefSize(WIDTH, HEIGHT * 6);
        // paneForIndex.setGridLinesVisible(true); // CONTINUE HERE

        // Update if the arrow is for a pivot index
        if (label.equals("pivot")) {
            paneForIndex.add(paneForArrow, 0, 0);
            paneForIndex.add(lblArrow, 0, 1);
        } else {
            paneForIndex.add(lblArrow, 0, 0);
            paneForIndex.add(paneForArrow, 0, 1);
        }

        // Decide on a color
        Color indexColor = Color.BLACK; // Initialization
        switch (label) {
            case "low":
                indexColor = LOW_INDEX_COLOR;
                break;
            case "high":
                indexColor = HIGH_INDEX_COLOR;
                break;
            case "pivot":
                indexColor = PIVOT_INDEX_COLOR;
                break;
        }

        // Set the stroke color
        shaft.setStroke(indexColor);
        point.setStroke(indexColor);

        // Return the pane for index to the caller method
        return paneForIndex;
    }

    /**
     * Returns the pane for buttons with registered event handlers.
     *
     * @return
     */
    private HBox getPaneForButtons() {
        // Create the pane for the buttons
        HBox paneForButtons = new HBox(10);
        paneForButtons.setPadding(new Insets(0, 0, HEIGHT, 0));
        paneForButtons.setAlignment(Pos.CENTER);

        // Create the step button and register an event handler
        Button btStep = new Button("Step");
        btStep.setOnAction(e -> {
            // Get the current status 
            int status = quickSort.getStatus();

            switch (status) {
                // If no steps were taken
                case QuickSort.STARTING_POINT:
                    // Move the low index and update the status
                    quickSort.moveLow();
                    quickSort.setStatus(QuickSort.LOW_FOUND);
                    break;

                // If the low index was moved
                case QuickSort.LOW_FOUND:
                    // Move the high index and update the status
                    quickSort.moveHigh();
                    quickSort.setStatus(QuickSort.HIGH_FOUND);
                    break;

                // If the high index was moved
                case QuickSort.HIGH_FOUND:
                    // Perform a swap and update the status
                    quickSort.swap();
                    // If there are still swaps to be done and low < high
                    if (quickSort.hasMoves()) {
                        quickSort.moveLow();
                        quickSort.setStatus(QuickSort.LOW_FOUND);

                    } // If there are no more swaps to be done and low > high
                    else {
                        quickSort.movePivot();
                        quickSort.setStatus(QuickSort.PIVOT_MOVED_DONE);
                        btStep.setDisable(true); // Disable the button
                    }
                    break;
            }

            // Print the data fields of this object to the console
            quickSort.print();

            // Repaint the center pane
            setCenter(getPaneForList());
        });

        // Create the reset button and register and event handler
        Button btReset = new Button("Reset");
        btReset.setOnAction(e -> {
            // 
            System.out.println("Reset");
            quickSort.setStatus(QuickSort.STARTING_POINT);

            // Initialize the quick sort data field
            quickSort = new QuickSort();

            btStep.setDisable(false); // Enable the button

            // Repaint the center pane
            setCenter(getPaneForList());
        });

        // Add the buttons to the pane for buttons
        paneForButtons.getChildren().addAll(btStep, btReset);

        // return the pane for buttons to the caller method
        return paneForButtons;
    }
}
