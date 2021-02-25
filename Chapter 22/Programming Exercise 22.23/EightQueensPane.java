package eightqueens;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 *
 * @author martinfall
 */
public class EightQueensPane extends StackPane {

    public EightQueensPane(Integer[] solution) {
        GridPane chessboard = new GridPane();
        for (int row = 0; row < solution.length; row++) {
            for (int column = 0; column < solution.length; column++) {
                Square square = new Square();

                if (solution[row] == column) {
                    square.placeQueen();
                }

                chessboard.add(square, column, row);
            }
        }

        getChildren().add(chessboard);

        setPadding(new Insets(10, 0, 10, 0));
    }

    public static class Square extends StackPane {

        // Preferred size of the stack pane
        private static final double SIZE = 40;
        private static final Image QUEEN = new Image("/eightqueens/queen.png");

        public Square() {
            setPrefSize(SIZE, SIZE);
            setBorder(new Border(new BorderStroke(
                    Color.BLACK,
                    BorderStrokeStyle.SOLID,
                    CornerRadii.EMPTY,
                    new BorderWidths(1))));
        }

        public void placeQueen() {
            ImageView ivQueen = new ImageView(QUEEN);
            ivQueen.setPreserveRatio(true);
            ivQueen.setFitHeight(SIZE - 5);
            ivQueen.setFitWidth(SIZE - 5);
            getChildren().add(ivQueen);
        }
    }
}
