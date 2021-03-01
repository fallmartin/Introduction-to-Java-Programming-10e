package sudoku;

import java.util.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author martinfall
 */
public class SudokuPane extends GridPane {

    SubGrid[][] subGrid;

    /**
     * No args constructor returns a Sudoku grid pane.
     */
    public SudokuPane() {
        int subGridIndex = 0;
        this.subGrid = new SubGrid[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                subGrid[i][j] = new SubGrid(subGridIndex);
                add(subGrid[i][j], j, i);
                subGridIndex++;
            }
        }

        setHgap(0); // 3
        setVgap(0); // 3
        setPadding(new Insets(0, 3, 0, 3));

    }

    /**
     * Clears the Sudoku pane from any input.
     */
    public void clear() {
        for (Node subGrid : getChildren()) {
            for (Node square : ((SubGrid) subGrid).getChildren()) {
                Square s = ((Square) square);
                s.clear();
            }
        }
    }

    /**
     * Returns a two-dimensional Integer array representation of the Sudoku
     * board.
     *
     * @return
     */
    public Integer[][] readAPuzzle() {
        Integer[][] grid = new Integer[9][9];

        Iterator<Node> iterator = getChildren().iterator();

        while (iterator.hasNext()) {
            SubGrid subGrid = (SubGrid) iterator.next();
            Iterator<Node> subIterator = subGrid.getChildren().iterator();

            int index = subGrid.index;
            for (int i = 3 * (index / 3); i < 3 * (index / 3) + 3; i++) {
                for (int j = 3 * (index % 3); j < 3 * (index % 3) + 3; j++) {
                    Square s = (Square) subIterator.next();
                    int value = 0;

                    if (s.getText().length() > 0) {
                        value = Integer.parseInt(s.getText());
                    }

                    grid[i][j] = value;
                }
            }
        }

        return grid;
    }

    /**
     * Paints the contents of the Integer array representation of the solution
     * found.
     *
     * @param grid
     */
    public void paint(Integer[][] grid) {

        Iterator<Node> iterator = getChildren().iterator();

        while (iterator.hasNext()) {
            SubGrid subGrid = (SubGrid) iterator.next();
            Iterator<Node> subIterator = subGrid.getChildren().iterator();

            int index = subGrid.index;
            for (int i = 3 * (index / 3); i < 3 * (index / 3) + 3; i++) {
                for (int j = 3 * (index % 3); j < 3 * (index % 3) + 3; j++) {
                    Square s = (Square) subIterator.next();
                    s.setText(grid[i][j] + "");
                }
            }
        }
    }

    /**
     * Inner class representing a 3x3 sub grid of the Sudoku board.
     */
    class SubGrid extends GridPane {

        // Data fields of the class
        int index;

        private final BorderStroke borderStroke = new BorderStroke(
                Color.BLACK,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                new BorderWidths(2));
        private final Border border = new Border(borderStroke);

        Square[][] subGrid;

        /**
         * Class constructor with the parameter index indicating the position of
         * the sub grid in the board.
         *
         * @param index
         */
        public SubGrid(int index) {
            this.index = index;

            this.subGrid = new Square[3][3];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    subGrid[i][j] = new Square(i, j);
                    add(subGrid[i][j], j, i);
                }
            }

            setHgap(0); // 3
            setVgap(0); // 3
            setPadding(new Insets(0)); // 3

            setBorder(border);
        }
    }

    /**
     * Inner class representing a single cell or square of the Sudoku board.
     */
    class Square extends TextField {

        // Data fields of the class Square
        int row;
        int column;

        private static final double PREF_SIZE = 40;

        private final BorderStroke borderStroke = new BorderStroke(
                Color.LIGHTGRAY,
                BorderStrokeStyle.SOLID,
                new CornerRadii(0), // 5
                BorderWidths.DEFAULT);
        private final Border border = new Border(borderStroke);

        public Square(int row, int column) {
            this.row = row;
            this.column = column;

            setPrefSize(PREF_SIZE, PREF_SIZE);
            setBorder(border);
            setFont(Font.font(20));
            setAlignment(Pos.CENTER);
        }
    }
}
