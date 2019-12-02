import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter a degree in Fahreheit
        System.out.print("Enter a degree in Fahrenheit: ");
        
        // Receive input
        double fahrenheit = input.nextDouble();
        
        // Convert Fahreheit to Celsius
        double celsius = (fahrenheit - 32) * 5.0 / 9;
        
        // Display the result
        System.out.println("Fahreheit " + fahrenheit + " is " +
                celsius + " in Celsius.");
    }
}
