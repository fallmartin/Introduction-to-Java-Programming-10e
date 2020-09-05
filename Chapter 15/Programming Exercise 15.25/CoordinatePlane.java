
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author martinfall
 */
public class CoordinatePlane extends Pane {

    public CoordinatePlane(double width, double height) {
        // Create the x-axis
        Line xAxis = new Line(10, height / 2, width - 10, height / 2);
        xAxis.setStroke(Color.GRAY);
        Polyline xAxisArrowhead = new Polyline(
                width - 15, height / 2 - 5,
                width - 10, height / 2,
                width - 15, height / 2 + 5
        );
        xAxisArrowhead.setStroke(Color.GRAY);
        Label xAxisLabel = new Label("X");
        xAxisLabel.setLayoutX(width - 20);
        xAxisLabel.setLayoutY(height / 2 - 30);

        // Create the y-axis
        Line yAxis = new Line(width / 2, 10, width / 2, height - 10);
        yAxis.setStroke(Color.GRAY);
        Polyline yAxisArrowhead = new Polyline(
                width / 2 - 5, 15,
                width / 2, 10,
                width / 2 + 5, 15);
        yAxisArrowhead.setStroke(Color.GRAY);
        Label yAxisLabel = new Label("Y");
        yAxisLabel.setLayoutX(width / 2 + 10);
        yAxisLabel.setLayoutY(5);

        // Add nodes to the pane
        getChildren().addAll(xAxis, yAxis,
                xAxisArrowhead, yAxisArrowhead,
                xAxisLabel, yAxisLabel);
    }

}
