import java.util.Scanner;

public class ConvertCelsiusToFahrenheit {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt user to enter a degree in Celsius
        System.out.print("Enter a degree in Celsius: ");
        double celsius = input.nextDouble();
        
        // Convert Celsius to Fahrenheit
        double fahrenheit = (9.0 / 5) * celsius + 32;
        
        // Display the result
        System.out.println(celsius + " Celsius is " + fahrenheit + " Fahrenheit");
    }
}
