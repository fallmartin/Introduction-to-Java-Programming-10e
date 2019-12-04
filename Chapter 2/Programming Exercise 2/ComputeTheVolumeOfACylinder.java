/*
 * Write a program that reads in the radius and length of a cylinder and computes 
the area and volume using the following formulas:

area = radius * radius * p
volume = area * length

Here is a sample run:

Enter the radius and length of a cylinder: 5.5 12
The area is 95.0331
The volume is 1140.4
 */

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class ComputeTheVolumeOfACylinder {

    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter the radius and length of a cylinder
        System.out.print("Enter the radius and length of a cylinder: ");
        double radius = input.nextDouble();
        double length = input.nextDouble();
        
        // Compute the area and volume
        double area = Math.pow(radius, 2) * Math.PI;
        double volume = area * length;
        
        // Display the results
        System.out.println("The area is  " + area);
        System.out.println("The volume is " + volume);
    }
}
