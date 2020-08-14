
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * (Display a pie chart) Write a program that uses a pie chart to display the
 * percentages of the overall grade represented by projects, quizzes, midterm
 * exams, and the final exam, as shown in Figure 14.46c. Suppose that projects
 * take 20 percent and are displayed in red, quizzes take 10 percent and are
 * displayed in blue, midterm exams take 30 percent and are displayed in green,
 * and the final exam takes 40 percent and is displayed in orange. Use the Arc
 * class to display the pies. Interested readers may explore the JavaFX PieChart
 * class for further study.
 *
 * Output:
 * (200.0, 100.0)
 * (130.90169943749476, 4.89434837048465)
 * (69.09830056250527, 4.894348370484636)
 * (19.098300562505244, 158.7785252292473)
 *
 * @author martinfall
 */
public class DisplayPieChart extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {
        // Create a new Pane
        Pane pane = new Pane();
        pane.setPadding(new Insets(10));

        // Declare an array for the percentages of the overall grade
        int[] grades = {20, 10, 30, 40};

        // Declare x,y for relocating label
        double x = 200;
        double y = 100;

        // Loop through grades and add pie chart "slices" to pane
        for (int i = 0; i < grades.length; i++) {
            Arc arc = getArc(grades[i]); // Create the arc
            arc.setOpacity(0.5);

            Label label = getLabel(grades[i]); // Create the label
            System.out.println("(" + x + ", " + y + ")");
            label.relocate(x, y);

            pane.getChildren().addAll(label, arc); // Add the arc and label to the pane

            x = 100 + 100 * Math.cos(
                    Math.toRadians(-(getStartingAngle(grades[i]) + getArcLength(grades[i]))));
            y = 100 + 100 * Math.sin(
                    Math.toRadians(-(getStartingAngle(grades[i]) + getArcLength(grades[i]))));
        }

        // Create a new scene and add it to the stage
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise_14_13");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public Arc getArc(int grade) {
        // Declare radius variable
        double radius = 100;
        double startAngle = getStartingAngle(grade);
        double length = getArcLength(grade);

        Arc arc = new Arc(radius * 1.1, radius * 1.1, radius, radius, startAngle, length);
        arc.setFill(getColor(grade).brighter());
        arc.setStroke(Color.TRANSPARENT);
        arc.setType(ArcType.ROUND);

        return arc;
    }

    public double getStartingAngle(int grade) {
        // Declare an array for the percentages of the overall grade
        int[] grades = {20, 10, 30, 40};
        double startAngle = 0;

        switch (grade) {
            case 20:
                break;
            case 10:
                startAngle = 360 * 0.2;
                break;
            case 30:
                startAngle = 360 * 0.2 + 360 * 0.1;
                break;
            case 40:
                startAngle = 360 * 0.2 + 360 * 0.1 + 360 * 0.3;
                break;
        }
        return startAngle;
    }

    public double getArcLength(int grade) {
        return 360 * grade / 100.0;
    }

    public Color getColor(int grade) {
        Color color = Color.TRANSPARENT;

        switch (grade) {
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

    public Label getLabel(int grade) {
        Label label = new Label();

        switch (grade) {
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

        label.setFont(Font.font("Arial", 10));

        return label;
    }
}
