
import java.util.Scanner;

/**
 * Geometry: area of a pentagon) The area of a pentagon can be computed using
 * the following formula:
 *
 * Area = (5 * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / 5));
 *
 * Write a method that returns the area of a pentagon using the following
 * header:
 *
 * public static double area(double side)
 *
 * Write a main method that prompts the user to enter the side of a pentagon and
 * displays its area. Here is a sample run:
 *
 * Enter the side: 5.5
 *
 * The area of the pentagon is 52.04444136781625
 *
 * @author martinfall
 */
public class PentagonArea {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the side
        System.out.print("Enter the side: ");
        double side = input.nextDouble();
        
        System.out.printf("The area of the pentagon is %.14f", area(side));
    }

    /**
     * Calculate the area of a pentagon
     *
     * @param side
     * @return
     */
    public static double area(double side) {
        return (5 * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / 5));
    }
}
