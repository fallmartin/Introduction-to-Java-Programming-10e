
/**
 * Output:
 *
 * Radius                        Area
 * 69.335265                     15102.826271
 * 58.444669                     10730.987370
 * 94.750011                     28203.851052
 * 53.757339                     9078.736171
 * 65.256130                     13378.040247
 * ------------------------------------------
 * The total area of circles is  76494.441111
 *
 * @author martinfall
 */
public class TotalArea {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Declare circle array
        CircleWithPrivateDataFields[] circleArray;

        // Create circleArray
        circleArray = createCircleArray();

        // Print circleArray and total areas of the circles
        printCircleArray(circleArray);
    }

    /**
     * Create an array of circle objects
     *
     * @return
     */
    public static CircleWithPrivateDataFields[] createCircleArray() {
        CircleWithPrivateDataFields[] circleArray
                = new CircleWithPrivateDataFields[5];

        for (int i = 0; i < circleArray.length; i++) {
            circleArray[i] = new CircleWithPrivateDataFields(Math.random() * 100);
        }
        // Return Circle array
        return circleArray;
    }

    /**
     * Print an array of circles and their total areas
     *
     * @param circleArray
     */
    public static void printCircleArray(CircleWithPrivateDataFields[] circleArray) {
        System.out.printf("%-30s%-15s\n", "Radius", "Area");

        for (int i = 0; i < circleArray.length; i++) {
            System.out.printf("%-30f%-15f\n", circleArray[i].getRadius(),
                    circleArray[i].getArea());
        }

        System.out.println("------------------------------------------");

        // Compute and display the result
        System.out.printf("%-30s%-15f\n", "The total area of circles is",
                sum(circleArray));
    }

    public static double sum(CircleWithPrivateDataFields[] circleArray) {
        // Initialize sum
        double sum = 0;

        // Add areas to sum
        for (int i = 0; i < circleArray.length; i++) {
            sum += circleArray[i].getArea();
        }

        return sum;
    }
}
