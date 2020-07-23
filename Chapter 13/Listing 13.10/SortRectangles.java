
/**
 * Output:
 * Width: 3.4 Height: 5.4 Area: 18.36
 * Width: 1.4 Height: 25.4 Area: 35.559999999999995
 * Width: 7.4 Height: 35.4 Area: 261.96
 * Width: 13.24 Height: 55.4 Area: 733.496
 *
 * @author martinfall
 */
public class SortRectangles {

    public static void main(String[] args) {
        ComparableRectangle[] rectangles = {
            new ComparableRectangle(3.4, 5.4),
            new ComparableRectangle(13.24, 55.4),
            new ComparableRectangle(7.4, 35.4),
            new ComparableRectangle(1.4, 25.4)};

        java.util.Arrays.sort(rectangles);

        for (Rectangle rectangle : rectangles) {
            System.out.print(rectangle + " ");
            System.out.println();
        }
    }
}
