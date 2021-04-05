package radixsorter;

import java.util.ArrayList;
import javafx.geometry.HPos;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author martinfall
 */
public class RadixSorterPane extends BorderPane {

    /**
     * Data fields of the RadixSorterPane class.
     *
     * @param RADIX_SIZE - radix or base is the number of unique digits
     * @param border - border that encases the contents of the list of integers
     *
     * @param paneForList - pane for the list of integers
     * @param paneForBuckets - pane of the buckets
     *
     * @param list - array list of integers
     * @param buckets - array list of array lists of integers
     *
     * @param listIndex - index of the integer in the list
     * @param bucketIndex - index of the bucket containing the current integer
     * @param elementIndex - index of the current integer in the current bucket
     *
     * @param radixSorter - RadixSorter object
     *
     *
     */
    // Constants
    private static final int RADIX_SIZE = 10;
    private Border border = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1)));

    // Panes
    private GridPane paneForList;
    private GridPane paneForBuckets;

    // Lists
    private ArrayList<Integer> list;
    private ArrayList<ArrayList<Integer>> buckets;

    // Indices
    private int listIndex;
    private int bucketIndex;
    private int bucketElementIndex;

    // Radix sorter
    private RadixSorter radixSorter;

    /**
     * Default constructor of the RadixSortPane class.
     */
    public RadixSorterPane() {
        // Initialize the data fields
        radixSorter = new RadixSorter();

        // Paint the list and buckets
        paint();

        /*
         * Construct the HBox for the control buttons and the buttons for the
         * pane.
         */
        HBox paneForControls = new HBox(10);
        paneForControls.setAlignment(Pos.CENTER);
        paneForControls.setPadding(new Insets(10));

        Button btStep = new Button("Step");
        Button btReset = new Button("Reset");

        paneForControls.getChildren().addAll(btStep, btReset);

        /*
         * Assign the panes for list, buckets, and buttons to the border pane's
         * top, center, and bottom properties.
         */
        setBottom(paneForControls);
        setPadding(new Insets(10));

        /*
         * Event handler for the Step button.
         */
        btStep.setOnAction(e -> {
            if (radixSorter.hasSteps()) {
                radixSorter.step();

                paint();
            } else {
                btStep.setText("Sorted");
                btStep.setDisable(true);
            }
        });

        /*
         * Event handler for the Step button.
         */
        btReset.setOnAction(e -> {
            // Create a new radix sorter
            radixSorter = new RadixSorter();
            btStep.setText("Step");

            paint();
            btStep.setDisable(false);
        });
    }

    /**
     * Paint the list and buckets to the pane.
     */
    private void paint() {
        paintList();
        paintBuckets();
    }

    /**
     * Paints the list of integers to the pane.
     */
    private void paintList() {
        // Initialize the pane for list and set alignment and border properties
        paneForList = new GridPane();
        paneForList.setAlignment(Pos.CENTER);
        paneForList.setBorder(border);

        // Initialize collections
        list = radixSorter.getList();
        buckets = radixSorter.getBuckets();

        // Initialize indices
        int[] indices = radixSorter.getIndices();
        listIndex = indices[0];
        bucketIndex = indices[1];
        bucketElementIndex = indices[2];

        /*
         * Construct the pane with current values in the list and the current
         * element highlighted.
         */
        for (int index = 0; index < list.size(); index++) {
            // Creates a column constraint object with a fixed width of 5
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(5);
            paneForList.getColumnConstraints().add(column);

            // Add the current element to pane for list as a label
            String element = Integer.toString(list.get(index));
            Label labelForElement = new Label(element);
            labelForElement.setFont(Font.font(Font.getDefault().getName(),
                    Font.getDefault().getSize()));

            // Highlight the number at the current index
            if (index == listIndex) {
                labelForElement.setTextFill(Color.RED);
                labelForElement.setFont(Font.font(Font.getDefault().getName(),
                        FontWeight.EXTRA_BOLD, Font.getDefault().getSize()));
            }

            // Add and align the label to the pane for list at the right column
            paneForList.addColumn(index, labelForElement);
            GridPane.setHalignment(labelForElement, HPos.CENTER);
        }

        // Add the pane for list to the top region of the border pane
        setTop(paneForList);
    }

    /**
     * Paints the buckets to the pane.
     */
    private void paintBuckets() {
        // Initialize the pane for  bucket
        paneForBuckets = new GridPane();

        // Initialize collections
        list = radixSorter.getList();
        buckets = radixSorter.getBuckets();

        // Initialize indices
        int[] indices = radixSorter.getIndices();
        listIndex = indices[0];
        bucketIndex = indices[1];
        bucketElementIndex = indices[2];

        /*
         * In a positional numeral system, the radix or base is the number of
         * unique digits, including the digit zero, used to represent numbers.
         * In the case of radix sort, that amounts to the numbers in the 0 to 9
         * range including 0 and 9.
         */
        for (int i = 0; i < buckets.size(); i++) {
            // Get the bucket list at index i and create a new bucket node
            ArrayList<Integer> bucketList = buckets.get(i) == null
                    ? new ArrayList<>() : buckets.get(i);
            // System.out.println(bucketList);
            Bucket bucket = new Bucket(i, bucketList);

            /*
             * If we're in the right bucket and the index of the current element
             * is equal to the element index.
             */
            if (i == bucketIndex
                    && bucketList.indexOf(list.get(listIndex)) == bucketElementIndex) {
                // System.out.println("bucketIndex=" + bucketIndex);
                // System.out.println("elementIndex=" + elementIndex);
                bucket.highlight(bucketElementIndex);
            }
            // Add the bucket node to the column of the grid
            paneForBuckets.addColumn(i, bucket);
        }

        // Add the pane for buckets to the center region of the border pane
        setCenter(paneForBuckets);
    }
}
