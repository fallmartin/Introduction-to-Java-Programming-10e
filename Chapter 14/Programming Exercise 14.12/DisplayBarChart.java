
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

/**
 * (Display a bar chart) Write a program that uses a bar chart to display the
 * percentages of the overall grade represented by projects, quizzes, midterm
 * exams, and the final exam, as shown in Figure 14.46b. Suppose that projects
 * take 20 percent and are displayed in red, quizzes take 10 percent and are
 * displayed in blue, midterm exams take 30 percent and are displayed in green,
 * and the final exam takes 40 percent and is displayed in orange. Use the
 * Rectangle class to display the bars. Interested readers may explore the
 * JavaFX BarChart class for further study.
 *
 * @author martinfall
 */
public class DisplayBarChart extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        // Declare an array for the percentages of the overall grade
        int[] grades = {20, 10, 30, 40};

        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setAlignment(Pos.CENTER);

        for (int i = 0; i < grades.length; i++) {
            // Create a new VBox pane
            VBox vPane = new VBox();
            vPane.setAlignment(Pos.BOTTOM_CENTER);

            // Create a label and a rectange
            Label l = getBarLabel(grades[i]);
            Rectangle r = getBarChart(grades[i]);

            // Add the label and rectangle to the VBox
            vPane.getChildren().addAll(l, r);

            // Add the VBox to the grid pane
            pane.add(vPane, i, 0);
        }

        // Create a new scene and add the pane to it
        Scene scene = new Scene(pane);
        stage.setTitle("Exercise_14_12"); // Set the stage title
        stage.setScene(scene); // Set the scene on the stage
        stage.show(); // Display the stage
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Returns a bar chart rectangle with a label.
     *
     * @param percentage
     * @return
     */
    public Rectangle getBarChart(int percentage) {
        Color color = getChartColor(percentage);

        Rectangle r = new Rectangle(100, 300 * percentage / 100.0, color);

        return r;
    }

    /**
     * Returns the color of the chart.
     *
     * @param percentage
     * @return
     */
    public Color getChartColor(int percentage) {
        Color color = Color.TRANSPARENT;

        switch (percentage) {
            case 20:
                color = Color.RED;
                break;
            case 10:
                color = Color.BLUE;
                break;
            case 30:
                color = Color.GREEN;
                break;
            case 40:
                color = Color.ORANGE;
                break;
        }

        return color;
    }

    /**
     * Return the label.
     *
     * @param percentage
     * @return
     */
    public Label getBarLabel(int percentage) {
        Label label = new Label();

        switch (percentage) {
            case 20:
                label.setText("Project -- 20%");
                break;
            case 10:
                label.setText("Quiz -- 10%");
                break;
            case 30:
                label.setText("Midterm -- 30%");
                break;
            case 40:
                label.setText("Final -- 40%");
                break;
        }

        label.setFont(Font.font("Arial", 12));

        return label;
    }
}
