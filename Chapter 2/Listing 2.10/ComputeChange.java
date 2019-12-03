import java.util.Scanner;

public class ComputeChange {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter the amount as a decimal number, such as 11.56.
        System.out.print("Enter the amount as a decimal number, such as 11.56: ");
        double amount = input.nextDouble();
        
        // Convert the amount into cents
        int remainingAmount = (int) (amount * 100); 
        
        // Divide the cents by 100 to find the number of dollars.
        int numberOfDollars = remainingAmount / 100;
        
        // Obtain the remaining cents using the cents remainder 100.
        remainingAmount %= 100;
        
        // Divide the remaining cents by 25 to find the number of quarters.
        int numberOfQuarters = remainingAmount / 25;
        
        // Obtain the remaining cents using the cents remainder 25.
        remainingAmount %= 25;
        
        // Divide the remaining cents by 10 to find the number of dimes.
        int numberOfDimes = remainingAmount / 10;
        
        // Obtain the remaining cents using the cents remainder 10.
        remainingAmount %= 10;
        
        // Divide the remaining cents by 5 to find the number of nickels.
        int numberOfNickels = remainingAmount / 5;
        
        // Obtain the remaining cents using the cents remainder 5.
        remainingAmount %= 5;
        
        // The remaining cents are the pennies.
        int numberOfPennies = remainingAmount;
        
        // Display results
        System.out.println("Your amount " + amount + " consists of");
        System.out.println(" " + numberOfDollars + " dollars");
        System.out.println(" " + numberOfQuarters + " quarters ");
        System.out.println(" " + numberOfDimes + " dimes");
        System.out.println(" " + numberOfNickels + " nickels");
        System.out.println(" " + numberOfPennies + " pennies");
    }
}
