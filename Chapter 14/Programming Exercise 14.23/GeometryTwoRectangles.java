
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * (Geometry: two rectangles) Write a program that prompts the user to enter the
 * center coordinates, width, and height of two rectangles from the command
 * line. The program displays the rectangles and a text indicating whether the
 * two are overlapping, whether one is contained in the other, or whether they
 * don’t overlap, as shown in Figure 14.50. See Programming Exercise 10.13 for
 * checking the relationship between two rectangles.
 *
 * Output:
 * Enter the center coordinates x and y or rectangle r1: 100 100
 * Enter the width and height of rectangle r1: 50 50
 *
 * Enter the center coordinates x and y or rectangle r2: 100 200
 * Enter the width and height of rectangle r2: 20 20
 *
 * @author martinfall
 */
public class GeometryTwoRectangles extends Application {

    @Override // Override the start method in the Application method
    public void start(Stage stage) throws Exception {
        // Create a new scanner
        Scanner input = new Scanner(System.in);

        /**
         * Rectangle 1
         */
        //
        // Prompt the user to enter the center coordinates, width, and height of
        // rectangle r1
        System.out.print("Enter the center coordinates x and y or rectangle r1: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();

        System.out.print("Enter the width and height of rectangle r1: ");
        double width1 = input.nextDouble();
        double height1 = input.nextDouble();

        // Construct rectangle r1 and update x1 and y1 to upper left corner
        Rectangle r1 = new Rectangle(x1 - width1 / 2.0, y1 - height1 / 2.0,
                width1, height1);

        // Customize rectangle r1
        r1.setFill(Color.TRANSPARENT);
        r1.setStroke(Color.BLACK);

        // New line
        System.out.println();

        /**
         * Rectangle 2
         */
        //
        // Prompt the user to enter the center coordinates, width, and height of
        // rectangle r2
        System.out.print("Enter the center coordinates x and y or rectangle r2: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        System.out.print("Enter the width and height of rectangle r2: ");
        double width2 = input.nextDouble();
        double height2 = input.nextDouble();

        // Construct rectangle r2 and update x2 and y2 to upper left corner
        Rectangle r2 = new Rectangle(x2 - width2 / 2.0, y2 - height2 / 2.0,
                width2, height2);

        // Customize rectangle r2
        r2.setFill(Color.TRANSPARENT);
        r2.setStroke(Color.BLACK);

        // Create a new Pane
        Pane pane = new Pane();
        pane.setPadding(new Insets(10));

        // Add rectangles to pane
        pane.getChildren().addAll(r1, r2);

        // Check conditions
        String message = checkOverlap(r1, r2);
        Text text = new Text(message);

        // Create a new border pane
        BorderPane outerPane = new BorderPane();
        outerPane.setPadding(new Insets(20));
        outerPane.setCenter(pane);
        outerPane.setBottom(text);
        BorderPane.setAlignment(text, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(outerPane);
        stage.setTitle("Exercise_14_23"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        // stage.setResizable(false); // Make the stage non-resizable
        stage.show(); // Display the stage
    }

    public static String checkOverlap(Rectangle r1, Rectangle r2) {
        // Array of messages to pick a return String from
        String[] messages = new String[3];
        messages[0] = "The rectangles overlap";
        messages[1] = "One rectangle is contained in another";
        messages[2] = "The rectangles do not overlap";

        // Build arrays of vertices for rectangles r1 and r2
        double[][] v1 = buildVerticesArray(r1);
        double[][] v2 = buildVerticesArray(r2);

        // Create a counter to tally the number of vertices contained
        int counter = 0;

        // Check if each vertex is contained in the rectangle
        for (double[] vertex : v2) {
            if (r1.contains(vertex[0], vertex[1])) {
                counter++;
            }
        }

        if (counter == 4) {
            return messages[1];
        } else if (counter == 1 || counter == 2) {
            return messages[0];
        }

        // System.out.println("Counter at first pass: " + counter);

        // Reset counter to 0
        counter = 0;

        // Check if each vertex is contained in the rectangle
        for (double[] vertex : v1) {
            if (r2.contains(vertex[0], vertex[1])) {
                counter++;
            }
        }

        if (counter == 4) {
            return messages[1];
        } else if (counter == 1 || counter == 2) {
            return messages[0];
        }

        // System.out.println("Counter at second pass: " + counter);

        // If neither rectangle contains the other and they do not overlap
        return messages[2];
    }

    public static double[][] buildVerticesArray(Rectangle r) {
        // Array of vertices of rectangle r1
        double[][] vertices = new double[4][2];

        // Tope left corner
        vertices[0][0] = r.getX();
        vertices[0][1] = r.getY();
        // Top right corner
        vertices[1][0] = r.getX() + r.getWidth();
        vertices[1][1] = r.getY();
        // Bottom right corner
        vertices[2][0] = r.getX();
        vertices[2][1] = r.getY() + r.getHeight();
        // Bottom right corner
        vertices[3][0] = r.getX() + r.getWidth();
        vertices[3][1] = r.getY() + r.getHeight();

        return vertices;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
