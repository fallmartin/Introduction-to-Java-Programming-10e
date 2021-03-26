package heapvisualizer;

import java.util.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * 
 * @author martinfall
 */
public class HeapPane extends BorderPane {

    // Data fields
    private Heap<Integer> heap = new Heap<>();
    Pane paneForNodes;

    /**
     * Default constructor for the HeapPane class.
     */
    public HeapPane() {
        // Construct the controls for the bottom pane area
        paneForNodes = initVisualizer();

        // Construct the visualizer pane
        HBox paneForControls = initControls();

        // Set the panes in the center and bottom of the border pane
        setCenter(paneForNodes);
        setBottom(paneForControls);
    }

    /**
     * Initialize the visualizer pane.
     *
     * @return
     */
    private Pane initVisualizer() {
        // Construct the display pane for the binary heap tree
        Pane paneForNodes = new Pane();
        paneForNodes.setMinSize(800, 600);

        return paneForNodes;
    }

    /**
     * Initialize the controls.
     *
     * @return
     */
    private HBox initControls() {
        // Create the buttons, label, and text field for the controls pane
        Button btInsert = new Button("Insert");
        Button btRemoveRoot = new Button("Remove the root");
        Label lblKey = new Label("Enter a key:");
        TextField tfKey = new TextField();

        // Construct an HBox to hold the controls
        HBox paneForControls = new HBox(5);
        paneForControls.setAlignment(Pos.CENTER);
        paneForControls.setPadding(new Insets(10));

        // Add the controls to the HBox
        paneForControls.getChildren().
                addAll(lblKey, tfKey, btInsert, btRemoveRoot);

        // Event handlers for the insert and remove buttons
        btInsert.setOnAction(e -> {
            String key = tfKey.getText();
            if (key.length() > 0 && key.matches("-?[\\d]+")) {
                int number = Integer.parseInt(tfKey.getText());
                heap.add(number);

                // Repaint the heap iff it is not empty
                if (heap.getSize() >= 0) {
                    repaint();
                }
            } else {
                System.out.println("Please enter an integer.");
            }

            // Clear the text field and request focus after inserting a number
            tfKey.clear();
            tfKey.requestFocus();
        });

        btRemoveRoot.setOnAction(e -> {
            heap.remove();

            // Repaint the heap iff it is not empty
            if (heap.getSize() >= 0) {
                repaint();
            }
        });

        // Return the H box to the caller method
        return paneForControls;
    }

    /**
     * I used this method to understand how to print the nodes in levels to
     * console.
     */
    private void draw() {

        int currentLevel = 0; // Current level

        // Determine the height of the heap
        int heapHeight = (int) Math.ceil(Math.log(heap.getSize() + 1) / Math.log(2)) - 1;

        // Display the heap on the console
        int startIndex = 0; // Start at 0
        int endIndex = startIndex + (int) Math.pow(2, currentLevel++); // Go to 1, not inclusive

        while (startIndex < heap.getSize()) {
            // Display the current level, start, and end indices to console
            System.out.println("Level=" + currentLevel
                    + ", startIndex=" + startIndex + ", endIndex=" + endIndex);

            // Display the node on the current level
            while (startIndex < endIndex && startIndex < heap.getSize()) {
                System.out.print(heap.get(startIndex) + " ");
                startIndex++;
            }

            // Update the start and end indices and print a new line
            startIndex = endIndex;
            endIndex = startIndex + (int) (Math.pow(2, currentLevel++));
            if (endIndex > heap.getSize()) {
                endIndex = heap.getSize();
            }

            System.out.println("\n");
        }

        // Make it purdy
        System.out.println("-------------------------------------------------");

    }

    private void repaint() {
        paneForNodes.getChildren().clear();
        Node[] nodes = paintNodes();
        paintLines(nodes);
        System.out.println(heap);
    }

    /**
     * Paints the nodes to the pane.
     *
     * @return
     */
    public Node[] paintNodes() {
        // Create an array of nodes
        Node[] nodes = new Node[heap.getSize()];
        int nodesIndex = 0;

        // double radius = 25; // Node circle radius
        int currentLevel = 0; // Current level is root

        int startIndex = 0; // Start at 0
        int endIndex = startIndex + (int) Math.pow(2, currentLevel++); // Go to 1, not inclusive

        /*
         * W is the current width of the segment in which we are horizontally
         * centering the node. At the root level, the width is
         * W = getWidth() / 2 ^ 0 = getWidth() / 1 = getWidth().
         * At level 1, it becomes W / 2 ^ 1.
         * At level 2, it becomes W / 2 ^ 2.
         * ...
         * At level n, it becomes W / 2 ^ n.
         *
         * The first node is placed at centerX = W / 2. Each additional node on
         * the same level is placed at centerX += W.
         */
        double W = getWidth(); // Find 
        while (startIndex < heap.getSize()) {
            // Starting coordinates of the root node
            double centerX = W / 2;
            double centerY = (currentLevel * 100); // + 50 ?

            while (startIndex < endIndex && startIndex < heap.getSize()) {
                // Create a new node and set its value, center x and y properties
                Node node = new Node(heap.get(startIndex), centerX, centerY);
                nodes[nodesIndex++] = node; // Add node to nodes

                // Add the node to the pane
                paneForNodes.getChildren().add(node);
                startIndex++; // Increment the startIndex
                centerX += W;
            }

            // Update the start and end indices and print a new line
            startIndex = endIndex;
            endIndex = startIndex + (int) (Math.pow(2, currentLevel++));
            if (endIndex > heap.getSize()) {
                endIndex = heap.getSize();
            }

            W /= 2;
        }
        return nodes;
    }

    /**
     * Paints the lines connecting the nodes to the pane.
     *
     * @param nodes
     */
    public void paintLines(Node[] nodes) {
        ArrayList<Line> lines = new ArrayList<>();
        for (int currentIndex = 0; currentIndex < nodes.length; currentIndex++) {
            // Find the indices of the left and right children
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Construct variables for x, y coordinates of element at current index
            double currentX = nodes[currentIndex].centerX;
            double currentY = nodes[currentIndex].centerY;

            if (leftChildIndex < heap.getSize()) {
                Line line = new Line();
                line.setStartX(currentX);
                line.setStartY(currentY);
                line.setEndX(nodes[leftChildIndex].centerX);
                line.setEndY(nodes[leftChildIndex].centerY);

                paneForNodes.getChildren().add(line);
                line.toBack();
            }

            if (rightChildIndex < heap.getSize()) {
                Line line = new Line();
                line.setStartX(currentX);
                line.setStartY(currentY);
                line.setEndX(nodes[rightChildIndex].centerX);
                line.setEndY(nodes[rightChildIndex].centerY);

                paneForNodes.getChildren().add(line);
                line.toBack();
            }
        }
    }

    /**
     * A node class representing each node in the heap.
     */
    public class Node extends Pane {

        // Data fields initialized in the constructor
        double centerX;
        double centerY;

        // Radius, stroke width, stroke color, and fill color properties
        double radius = 25;
        double strokeWidth = 2;
        Color fillColor = Color.YELLOW;
        Color strokeColor = Color.BLACK;
        Circle circle;

        /**
         * Parameterized constructor of the Node class.
         *
         * @param value
         * @param centerX
         * @param centerY
         */
        public Node(int value, double centerX, double centerY) {
            // Initialize the centerX and centerY data fields
            this.centerX = centerX;
            this.centerY = centerY;

            // Set the node's text content
            Text text = new Text(Integer.toString(value)); // Integer value
            text.setFont(new Font(radius)); // Set the font
            text.setX(centerX - text.getLayoutBounds().getWidth() / 2);
            text.setY(centerY + text.getLayoutBounds().getHeight() / 4);

            // Create the enclosing circle and set its properties
            circle = new Circle(centerX, centerY, radius, fillColor);
            circle.setStroke(strokeColor);
            circle.setStrokeWidth(strokeWidth);

            // Create a new pane and add the text and circle
            Pane pane = new Pane();
            pane.getChildren().addAll(circle, text);

            // Add the pane to the heap pane
            getChildren().add(pane);
        }
    }
}
