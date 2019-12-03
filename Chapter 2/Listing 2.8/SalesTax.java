import java.util.Scanner;

public class SalesTax {
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt user for input
        System.out.print("Enter purchase amount: ");
        double purchaseAmount = input.nextDouble();
        
        // Calculate tax
        double tax = purchaseAmount * 0.06;
        
        // Print sales tax
        System.out.println("Sales tax is $" + (int)(tax * 100) / 100.0);
    }
}
