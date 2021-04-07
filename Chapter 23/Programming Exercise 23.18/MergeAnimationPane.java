package mergeanimation;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
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
 * (Merge animation) Write a program that animates the merge of two sorted
 * lists. Create two arrays, list1 and list2, each of which consists of 8 random
 * numbers from 1 to 999. The array elements are displayed, as shown in Figure
 * 23.22a. Clicking the Step button causes the program to move an element from
 * list1 or list2 to temp. Clicking the Reset button creates two new random
 * arrays for a new start. When the algorithm is finished, clicking the Step
 * button displays a message to inform the user.
 *
 * @author martinfall
 */
public class MergeAnimationPane extends BorderPane {

    // Data fields of the MergeAnimationPane class
    GridPane paneForList1, paneForList2, paneForTemp;

    private final int WIDTH = 50;
    private final int HEIGHT = 20;

    private static final Border border = new Border(new BorderStroke(
            Color.BLACK,
            BorderStrokeStyle.SOLID,
            CornerRadii.EMPTY,
            new BorderWidths(1)));

    Merge merge;

    /**
     * Default constructor of the MergeAnimationPane class.
     */
    public MergeAnimationPane() {
        merge = new Merge();

        BorderPane paneForArrays = getPaneForArrays();

        /*
         * Create the buttons and register event handlers
         */
        // Step button and event handler
        Button btStep = new Button("Step");
        btStep.setOnAction(e -> {
            // Take a valid step or signal that steps are done
            if (merge.hasSteps()) {
                merge.step();

                BorderPane newPaneForArrays = getPaneForArrays();
                setCenter(newPaneForArrays);
            } else {
                btStep.setDisable(true);
            }
        });

        // Reset button and event handler
        Button btReset = new Button("Reset");
        btReset.setOnAction(e -> {
            // Reset the merge object
            merge.reset();

            // Enable the Step button
            btStep.setDisable(false);

            // Refresh the pane for array
            BorderPane newPaneForArrays = getPaneForArrays();
            setCenter(newPaneForArrays);
        });

        // Pane for buttons
        HBox paneForButtons = new HBox(10);
        paneForButtons.getChildren().addAll(btStep, btReset);
        paneForButtons.setPadding(new Insets(0, 0, HEIGHT, 0));
        paneForButtons.setAlignment(Pos.CENTER);

        // Add the panes for arrays and buttons to the pane
        setCenter(paneForArrays);
        setBottom(paneForButtons);
    }

    /**
     * Paints the arrays to console
     */
    private BorderPane getPaneForArrays() {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(20));

        // Initialize the panes for list1, list2, and temp
        paneForList1 = getPaneForList1();
        paneForList2 = getPaneForList2();
        paneForTemp = getPaneForTemp();

        // Set the padding property on top and bottom in temp
        paneForTemp.setPadding(new Insets(HEIGHT, 0, HEIGHT, 0));

        // Add list1 and list2 to a pane for lists
        GridPane paneForLists = new GridPane();
        paneForLists.add(paneForList1, 0, 0);
        paneForLists.add(paneForList2, 1, 0);

        // Add the panes for lists and temp array to the global pane
        pane.setCenter(paneForLists);
        pane.setBottom(paneForTemp);

        return pane;
    }

    /**
     * Returns a grid pane for list1.
     *
     * @return
     */
    private GridPane getPaneForList1() {

        // Create a new grid pane
        GridPane pane = new GridPane();

        // Local variables for list1 and current1
        int[] list1 = merge.getList1();
        int current1 = merge.getCurrent1();

        // Column and row constraints
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPrefWidth(WIDTH);
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPrefHeight(HEIGHT);

        // Add the index name current1 to the pane
        Label labelForCurrent1 = new Label("current1");
        pane.add(labelForCurrent1, current1 + 1, 0);

        // Add the arrow to the pane
        StackPane paneForArrow = getPaneForArrow(true);
        pane.add(paneForArrow, current1 + 1, 1);

        // Add the list name list1 to the grid pane
        Label labelForList1 = new Label("list1");
        GridPane.setHalignment(labelForList1, HPos.RIGHT);
        pane.add(labelForList1, 0, 2);

        // Add the contents of list1 to the grid pane
        for (int i = 0; i < list1.length; i++) {
            StackPane cell = new StackPane();
            cell.setBorder(border);
            cell.setAlignment(Pos.BOTTOM_CENTER);
            cell.setPrefSize(WIDTH, HEIGHT);

            Label element = new Label(Integer.toString(list1[i]));
            element.setTextAlignment(TextAlignment.CENTER);
            cell.getChildren().add(element);

            pane.getColumnConstraints().add(columnConstraints);
            pane.getRowConstraints().add(rowConstraints);
            pane.add(cell, i + 1, 2);
        }

        // Resize the pane
        pane.setPrefSize(WIDTH * 9, HEIGHT * 3);

        // Return the pane
        return pane;
    }

    /**
     * Returns a grid pane for list2.
     *
     * @return
     */
    private GridPane getPaneForList2() {

        // Create a new grid pane
        GridPane pane = new GridPane();

        // Local variables for list1 and current1
        int[] list2 = merge.getList2();
        int current2 = merge.getCurrent2();

        // Column and row constraints
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPrefWidth(WIDTH);
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPrefHeight(HEIGHT);

        // Add the index name current2 to the pane
        Label labelForCurrent2 = new Label("current2");
        pane.add(labelForCurrent2, current2 + 1, 0);

        // Add the arrow to the pane
        StackPane paneForArrow = getPaneForArrow(true);
        pane.add(paneForArrow, current2 + 1, 1);

        // Add the list name list2 to the grid pane
        Label labelForList2 = new Label("list2");
        GridPane.setHalignment(labelForList2, HPos.RIGHT);
        pane.add(labelForList2, 0, 2);

        // Add the contents of list2 to the grid pane
        for (int i = 0; i < list2.length; i++) {
            StackPane cell = new StackPane();
            cell.setBorder(border);
            cell.setAlignment(Pos.BOTTOM_CENTER);
            cell.setPrefSize(WIDTH, HEIGHT);

            Label element = new Label(Integer.toString(list2[i]));
            element.setTextAlignment(TextAlignment.CENTER);
            cell.getChildren().add(element);

            pane.getColumnConstraints().add(columnConstraints);
            pane.getRowConstraints().add(rowConstraints);
            pane.add(cell, i + 1, 2);
        }

        // Resize the pane
        pane.setPrefSize(WIDTH * 9, HEIGHT * 3);

        // Return the pane
        return pane;
    }

    /**
     * Returns a grid pane for temp.
     *
     * @return
     */
    private GridPane getPaneForTemp() {
        // Create a new grid pane
        GridPane pane = new GridPane();

        // Local variables for list1 and current1
        int[] temp = merge.getTemp();
        int current3 = merge.getCurrent3();

        // Column and row constraints
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPrefWidth(WIDTH);
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPrefHeight(HEIGHT);

        // Add the list name list1 to the grid pane
        Label labelForList3 = new Label("list2");
        GridPane.setHalignment(labelForList3, HPos.RIGHT);
        pane.add(labelForList3, 0, 0);

        // Add the contents of temp to the grid pane
        for (int i = 0; i < temp.length; i++) {
            StackPane cell = new StackPane();
            cell.setBorder(border);
            cell.setAlignment(Pos.BOTTOM_CENTER);
            cell.setPrefSize(WIDTH, HEIGHT);

            int element = temp[i];
            // int element = getElement(temp, i, current3);

            // Create a label and add it to the cell
            Label labelForElement = new Label(Integer.toString(element));
            labelForElement.setTextAlignment(TextAlignment.CENTER);
            cell.getChildren().add(labelForElement);

            pane.getColumnConstraints().add(columnConstraints);
            pane.getRowConstraints().add(rowConstraints);
            pane.add(cell, i + 1, 0);
        }

        // Add the arrow to the pane
        StackPane paneForArrow = getPaneForArrow(false);
        pane.add(paneForArrow, current3 + 1, 1);

        // Add the index name current3 to the pane
        Label labelForCurrent3 = new Label("current3");
        pane.add(labelForCurrent3, current3 + 1, 2);

        pane.setAlignment(Pos.CENTER);

        // Resize the pane
        pane.setPrefSize(WIDTH * 17, HEIGHT * 3);

        // Return the pane
        return pane;
    }

    /**
     * Returns the next possible element to be merged into temp from list1 and
     * list2.
     *
     * @param temp
     * @param i
     * @param current3
     * @return
     */
    public int getElement(int[] temp, int i, int current3) {
        // Find the next element to go in temp
        int element = temp[i];
        if (i == current3) {
            // The potential elements at list1[current1] and list2[current2]
            int element1, element2;

            // if current1 is valid but current2 is not
            if (merge.getCurrent1() < merge.getList1().length
                    && merge.getCurrent2() >= merge.getList2().length) {
                element = merge.getList1()[merge.getCurrent1()];
            } // If current2 is valid but current 1 is not
            else if (merge.getCurrent2() < merge.getList2().length
                    && merge.getCurrent1() >= merge.getList1().length) {

            } // If both current1 and current2 are
            else {
                element1 = merge.getList1()[merge.getCurrent1()];
                element2 = merge.getList2()[merge.getCurrent2()];

                element = element1 < element2 ? element1 : element2;
            }
        }
        return element;
    }

    /**
     * Returns a stack pane containing an arrow.
     *
     * @param down true if arrow is pointing down and false if pointing up
     * @return
     */
    private StackPane getPaneForArrow(boolean down) {

        // Create a new stack pane and set its alignment property
        StackPane paneForArrow = new StackPane();
        paneForArrow.setAlignment(Pos.BOTTOM_CENTER);

        // Create the arrow shaft
        Polyline p1 = new Polyline(0, 0, 0, HEIGHT);
        p1.setStrokeWidth(2);
        p1.setStroke(Color.BLUE);

        // Create the arrow point
        Polyline p2 = new Polyline(7.5, 0, 3.75, 5, 0, 0);

        // If the arrow points up
        if (!down) {
            p2 = new Polyline(7.5, 7.5, 3.75, 0, 0, 7.5);
            paneForArrow.setAlignment(Pos.TOP_CENTER);
        }

        p2.setStrokeWidth(2);
        p2.setStroke(Color.BLUE);

        Group arrow = new Group(p1, p2);

        paneForArrow.getChildren().addAll(p1, p2);

        return paneForArrow;
    }
}
