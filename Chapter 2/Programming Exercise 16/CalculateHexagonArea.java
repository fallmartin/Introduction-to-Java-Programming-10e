/*
(Geometry: area of a hexagon) Write a program that prompts the user to enter the
side of a hexagon and displays its area. The formula for computing the area of a
hexagon is

area = 3 * Math.sqrt(3) * Math.pow(side, 2) / 2

where s is the length of a side. 

Here is a sample run:

Enter the side: 5.5
The area of the hexagon is 78.5895

Actual output:
Enter the side: 5.5
The area of the hexagon is 78.59180539343781
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class CalculateHexagonArea {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the side
        System.out.print("Enter the side: ");
        double side = input.nextDouble();

        // Calculate the area of the hexagon
        double area = 3 * Math.sqrt(3) * Math.pow(side, 2) / 2;

        // Display the results
        System.out.println("The area of the hexagon is " + area);
    }
}
