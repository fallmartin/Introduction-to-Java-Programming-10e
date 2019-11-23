import java.util.Scanner;

public class ComputeAreaWithConstant {
    public static void main(String[] args) {
        final double PI = Math.PI; // Declare a constant
        
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter a radius
        System.out.print("Enter a number for radius: ");
        double radius = input.nextDouble();
        
        // Compute area
        double area = Math.pow(radius, 2) * PI;
        
        // Display results
        System.out.println("The area for the circle of radius " +
                radius + " is " +  area);
    }
}
